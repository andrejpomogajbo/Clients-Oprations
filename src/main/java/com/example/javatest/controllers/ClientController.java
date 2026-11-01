package com.example.javatest.controllers;

import com.example.javatest.models.ClientAccount;
import com.example.javatest.models.ClientCreateRequest;
import com.example.javatest.services.ClientAccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController
{
    private final ClientAccountService service;

    public ClientController(ClientAccountService service)
    {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClientAccount> createClient(@Valid @RequestBody ClientCreateRequest request)
    {
        return ResponseEntity.status(201).body(service.createClient(request));
    }

    @GetMapping
    public ResponseEntity<List<ClientAccount>> getAllClientsEndpoint()
    {
        return ResponseEntity.ok(service.getAllClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientAccount> getClientById(@PathVariable Long id)
    {
        return service.getClientById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClientById(@PathVariable Long id)
    {
        return service.deleteClientById(id)
            .map(client -> ResponseEntity.noContent().<Void>build())
            .orElse(ResponseEntity.notFound().build());
    }
}
