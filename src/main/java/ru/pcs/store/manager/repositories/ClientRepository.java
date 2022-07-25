package ru.pcs.store.manager.repositories;

import ru.pcs.store.manager.enums.ClientStatus;
import ru.pcs.store.manager.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findAllByStatusOrderByName(ClientStatus status);
}
