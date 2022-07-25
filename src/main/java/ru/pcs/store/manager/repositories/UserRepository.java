package ru.pcs.store.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pcs.store.manager.enums.Role;
import ru.pcs.store.manager.model.Users;

import java.util.List;

public interface UserRepository extends JpaRepository <Users, Long> {

    List<Users> findAllByRole(Role role);
}
