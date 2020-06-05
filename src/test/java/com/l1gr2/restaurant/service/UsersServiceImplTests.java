package com.l1gr2.restaurant.service;

import com.l1gr2.restaurant.entity.Users;
import com.l1gr2.restaurant.repository.UsersRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class UsersServiceImplTests {

    @Mock
    UsersRepository usersRepository;

    @InjectMocks
    UsersServiceImpl usersService;

    @Test
    public void shouldGetAllUsers() {
        // given
        given(usersRepository.findAll()).willReturn(prepareData());
        // when
        List<Users> listOfUsers = usersService.getAllUsers();
        // then
        assertThat(listOfUsers, hasSize(4));
    }

    @Test
    public void shouldFindUserAndGetRole() {
        // given
        given(usersRepository.findById("admin")).willReturn(java.util.Optional.of(new Users("admin", "Jan Nowak", "admin", "ADMIN")));
        // when
        String role = usersService.findUserAndGetRole("admin", "admin");
        // then
        assertThat(role, is(equalTo("ADMIN")));
    }

    public List<Users> prepareData() {
        Users user1 = new Users();
        Users user2 = new Users();
        Users user3 = new Users();
        Users user4 = new Users();
        return Arrays.asList(user1, user2, user3, user4);
    }
}
