package ru.pcs.store.manager.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pcs.store.manager.form.UserForm;
import ru.pcs.store.manager.model.Users;
import ru.pcs.store.manager.repositories.UserRepository;
import ru.pcs.store.manager.service.UsersService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {

    private final UserRepository userRepository;

    @Override
    public void createUser(UserForm form) {
        Users user = Users.builder()
                .name(form.getName())
                .email(form.getEmail())
                .phone(form.getPhone())
                .role(form.getRole())
                .build();

        userRepository.save(user);
    }

    @Override
    public Users findById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void update(Long id, UserForm form) {
        Users users = userRepository.getById(id);
        users.setName(form.getName());
        users.setEmail(form.getEmail());
        users.setPhone(form.getPhone());
        users.setRole(form.getRole());
        userRepository.save(users);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
