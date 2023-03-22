package bg.softuni.mobilele.services;

import bg.softuni.mobilele.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ApplicationUserDetailsServiceTest {

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
    void testUserFound(){}

    @Test
    void testUserNotFound(){}
}
