package ru.pcs.store.manager.service;

import ru.pcs.store.manager.enums.ClientStatus;
import ru.pcs.store.manager.form.ClientForm;
import ru.pcs.store.manager.model.Client;

import java.util.List;

public interface ClientService {

    void create(ClientForm form);

    List<Client> readAll();

    List<Client> findAllByStatusOrderByName(ClientStatus status);

    Client read(Long id);

    void update(Long id, ClientForm form);

    void delete(Long id);

    void makeClientStatusActive(Long id);

    void makeClientStatusPassive(Long id);

    void makeClientStatusArchive(Long id);
}
