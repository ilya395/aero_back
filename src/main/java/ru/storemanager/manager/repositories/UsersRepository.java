package ru.storemanager.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.storemanager.manager.models.user.User;

public interface UsersRepository extends JpaRepository<User, Long> {

    User getByEmail(String email);
}
