package com.apress.demo;

import com.apress.demo.domain.User;
import com.apress.demo.repositories.UserRepository;
import com.apress.demo.services.MongoUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDataMongoApplicationTests {

    @Autowired
    private MongoUserService mongoUserService;

    @Autowired
    private UserRepository userRepository;

    /*@Test
    public void createUsersService() {
        User user = new User("1", "Paulo", "paulo@gmail.com", false);
        User userCreated = mongoUserService.createUser(user);
        assertEquals("Paulo", userCreated.getName());
        assertEquals("paulo@gmail.com", userCreated.getEmail());
    }*/

    @Test
    public void getAllUsersService() {
        List<User> users = mongoUserService.getUsers();
        assertNotNull(users);
    }

    @Test
    public void getUserByIdService() {
        User user = mongoUserService.getUser("1");
        assertEquals("Paulo", user.getName());
        assertEquals("paulo@gmail.com", user.getEmail());
    }

    @Test
    public void findAllUsersRepository() {
        List<User> users = userRepository.findAll();
        assertNotNull(users);
        assertTrue(!users.isEmpty());
    }

    @Test
    public void findUserByIdRepository() {
        User user = userRepository.findById("2").get();
        assertNotNull(user);
    }

    @Test
    public void createUserRepository() {
        User user = new User("4", "Joseph", "joseph@gmail.com", true);
        User savedUser = userRepository.save(user);
        User newUser = userRepository.findById(savedUser.getId()).get();
        assertEquals("Joseph", newUser.getName());
        assertEquals("joseph@gmail.com", newUser.getEmail());
    }
}
