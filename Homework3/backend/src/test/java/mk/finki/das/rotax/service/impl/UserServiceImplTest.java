package mk.finki.das.rotax.service.impl;

import mk.finki.das.rotax.model.User;
import mk.finki.das.rotax.repository.UserRepository;
import mk.finki.das.rotax.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    UserService userService;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    void saveUser() {

    }

    @Test
    void findAll() {
        List<User> userList = new ArrayList<>();
        userList.add(User.builder().userId(1L).build());
        userList.add(User.builder().userId(2L).build());

        when(userRepository.findAll()).thenReturn(userList);

        Set<User> users = userService.findAll();
        assertEquals(users.size(), 2);
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        User user = User.builder().userId(1L).build();

        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));

        User userReturned = userService.findById(1L);
        assertNotNull(userReturned);
        verify(userRepository).findById(anyLong());
        verify(userRepository, never()).findAll();
    }

    @Test
    void deleteById() {
        userService.deleteById(1L);
        verify(userRepository, times(1)).deleteById(anyLong());
    }
}