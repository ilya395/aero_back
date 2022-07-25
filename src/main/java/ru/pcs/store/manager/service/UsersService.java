package ru.pcs.store.manager.service;

import ru.pcs.store.manager.form.UserForm;
import ru.pcs.store.manager.model.Users;

import java.util.List;

public interface UsersService {

    void createUser(UserForm form);

    Users findById(Long id);

    List<Users> findAll();

    void update(Long id, UserForm form);

    void delete(Long id);
}
