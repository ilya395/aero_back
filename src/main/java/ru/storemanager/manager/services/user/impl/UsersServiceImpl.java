package ru.storemanager.manager.services.user.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.storemanager.manager.enums.Role;
import ru.storemanager.manager.forms.UserDto;
import ru.storemanager.manager.models.user.User;
import ru.storemanager.manager.repositories.UsersRepository;
import ru.storemanager.manager.services.user.UsersService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {

    final private PasswordEncoder passwordEncoder;
    private final UsersRepository usersRepository;

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public void makeUserAdmin(Long id) {
        User user = usersRepository.getById(id);
        user.setRole(Role.ADMIN);
        usersRepository.save(user);
    }

    @Override
    public void singUpUser(UserDto form) {
        User user = User.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .email(form.getEmail())
                .password(passwordEncoder.encode(form.getPassword()))
                .role(Role.USER)
                .build();
        usersRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return usersRepository.getByEmail(email);
    }

    @Override
    public void updateUser(UserDto userDto, String email) {
        User user = usersRepository.getByEmail(email);
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        usersRepository.save(user);
    }
}
