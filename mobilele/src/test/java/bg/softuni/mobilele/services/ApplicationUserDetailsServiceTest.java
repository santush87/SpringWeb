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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ApplicationUserDetailsServiceTest {

    private final String EXISTING_USERNAME = "Martin";
    private final String NOT_EXISTING_USERNAME = "Pesho";
    private final String PASSWORD = "toptop";

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

        UserRoleEntity testAdminRole = new UserRoleEntity().setRole(RoleEnum.ADMIN);
        UserRoleEntity testUserRole = new UserRoleEntity().setRole(RoleEnum.USER);

        UserEntity testUserEntity = new UserEntity()
                .setUsername(EXISTING_USERNAME)
                .setPassword(PASSWORD)
                .setRoles(List.of(testAdminRole, testUserRole));

        when(mocKUserRepository.findByUsername(EXISTING_USERNAME))
                .thenReturn(Optional.of(testUserEntity));

        UserDetails adnimDetails =
                toTest.loadUserByUsername(EXISTING_USERNAME);

        //ASSERT
        Assertions.assertNotNull(adnimDetails);
        Assertions.assertEquals(EXISTING_USERNAME, adnimDetails.getUsername());
        Assertions.assertEquals(testUserEntity.getPassword(), adnimDetails.getPassword());

        Assertions.assertEquals(2, adnimDetails.getAuthorities().size());
    }

    @Test
    void testUserNotFound() {
        assertThrows(UsernameNotFoundException.class,
                () -> {
                    toTest.loadUserByUsername(NOT_EXISTING_USERNAME);
                });
    }
}
