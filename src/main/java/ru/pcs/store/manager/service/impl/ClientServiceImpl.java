package ru.pcs.store.manager.service.impl;

import ru.pcs.store.manager.enums.ClientStatus;
import ru.pcs.store.manager.form.ClientForm;
import ru.pcs.store.manager.model.Client;
import ru.pcs.store.manager.repositories.ClientRepository;
import ru.pcs.store.manager.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private  final ClientRepository clientRepository;

    @Override
    public void create(ClientForm form) {
        Client client = Client.builder()
                .name(form.getName())
                .status(ClientStatus.active)
                .address(form.getAddress())
                .phone(form.getPhone())
                .email(form.getEmail())
                .build();
        clientRepository.save(client);
    }

    @Override
    public List<Client> readAll() {
        return clientRepository.findAll();
    }

    @Override
    public List<Client> findAllByStatusOrderByName(ClientStatus status) {
        return clientRepository.findAllByStatusOrderByName(status);
    }

    @Override
    public Client read(Long id) {
        return clientRepository.getById(id);
    }

    @Override
    public void update(Long id, ClientForm form) {
        Client client = clientRepository.getById(id);
        client.setName(form.getName());
        client.setPhone(form.getPhone());
        client.setEmail(form.getEmail());
        client.setAddress(form.getAddress());
        client.setStatus(form.getStatus());
        clientRepository.save(client);
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public void makeClientStatusActive(Long id) {
        Client client = clientRepository.getById(id);
        client.setStatus(ClientStatus.active);
        clientRepository.save(client);
    }

    @Override
    public void makeClientStatusPassive(Long id) {
        Client client = clientRepository.getById(id);
        client.setStatus(ClientStatus.passive);
        clientRepository.save(client);
    }

    @Override
    public void makeClientStatusArchive(Long id) {
        Client client = clientRepository.getById(id);
        client.setStatus(ClientStatus.archive);
        clientRepository.save(client);
    }
}
