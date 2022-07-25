package ru.storemanager.manager.services.user;

import ru.storemanager.manager.forms.UserDto;
import ru.storemanager.manager.models.user.User;

import java.util.List;

public interface UsersService {

    List<User> getAllUsers();

    void makeUserAdmin(Long id);

    void singUpUser(UserDto userDto);

    User getUserByEmail (String email);

    void updateUser (UserDto userDto, String email);
}
