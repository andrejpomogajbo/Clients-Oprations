package com.example.javatest.services;

import com.example.javatest.models.ClientAccount;
import com.example.javatest.models.ClientCreateRequest;
import com.example.javatest.repositories.ClientAccountRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClientAccountService
{
    private final ClientAccountRepository repository;

    public ClientAccountService(ClientAccountRepository repository)
    {
        this.repository = repository;
    }

    public ClientAccount createClient(ClientCreateRequest request)
    {
        ClientAccount account = new ClientAccount();
        account.setFullName(request.getFullName());
        account.setGender(request.getGender());
        account.setStatus(request.getStatus());
        return repository.save(account);
    }

    public List<ClientAccount> getAllClients()
    {
        return repository.findAll();
    }

    public Optional<ClientAccount> getClientById(Long id)
    {
        return repository.findById(id);
    }

    public Optional<ClientAccount> deleteClientById(Long id)
    {
        return repository.findById(id)
            .map(client -> {
                repository.delete(client);
                return client;});
    }
}
