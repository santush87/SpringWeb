package bg.softuni.mobilele.services;

import bg.softuni.mobilele.domain.entities.UserEntity;
import bg.softuni.mobilele.domain.entities.UserRoleEntity;
import bg.softuni.mobilele.domain.enums.RoleEnum;
import bg.softuni.mobilele.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.opentest4j.AssertionFailedError;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ApplicationUserDetailsServiceTest {

    private static final String EXISTING_USERNAME = "Martin";
    private static final String NOT_EXISTING_USERNAME = "Pesho";
    private static final String PASSWORD = "toptop";

    private ApplicationUserDetailsService toTest;

    @Mock
    private UserRepository mocKUserRepository;

    @BeforeEach
    void setUp() {
        toTest = new ApplicationUserDetailsService(
                mocKUserRepository
        );
    }

    @Test
    void testUserFound() {
        /* ARRANGE */
        UserRoleEntity testAdminRole = new UserRoleEntity().setRole(RoleEnum.ADMIN);
        UserRoleEntity testUserRole = new UserRoleEntity().setRole(RoleEnum.USER);

        UserEntity testUserEntity = new UserEntity()
                .setUsername(EXISTING_USERNAME)
                .setPassword(PASSWORD)
                .setRoles(List.of(testAdminRole, testUserRole));

        when(mocKUserRepository.findByUsername(EXISTING_USERNAME))
                .thenReturn(Optional.of(testUserEntity));
        /* END OF ARRANGE */

        /* ACT */
        UserDetails adnimDetails =
                toTest.loadUserByUsername(EXISTING_USERNAME);
        /* END OF ACT */

        /* ASSERT */
        Assertions.assertNotNull(adnimDetails);
        Assertions.assertEquals(EXISTING_USERNAME, adnimDetails.getUsername());
        Assertions.assertEquals(testUserEntity.getPassword(), adnimDetails.getPassword());

        Assertions.assertEquals(2, adnimDetails.getAuthorities().size());

        assertRole(adnimDetails.getAuthorities(), "ROLE_ADMIN");
        assertRole(adnimDetails.getAuthorities(), "ROLE_USER");
        /* END OF ASSERT */
    }

    private void assertRole(Collection<? extends GrantedAuthority> authorities,
                            String role) {
        authorities
                .stream()
                .filter(a->role.equals(a.getAuthority()))
                .findAny()
                .orElseThrow(()->new AssertionFailedError("Role " + role + " not found!"));
    }

    @Test
    void testUserNotFound() {
        assertThrows(UsernameNotFoundException.class,
                () -> toTest.loadUserByUsername(NOT_EXISTING_USERNAME));
    }
}
