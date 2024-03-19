package com.company.testprojectunibell.controller;

import com.company.testprojectunibell.dto.ClientDto;
import com.company.testprojectunibell.dto.ContactDto;
import com.company.testprojectunibell.entity.Client;
import com.company.testprojectunibell.entity.Contact;
import com.company.testprojectunibell.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
@Slf4j
public class ClientController {
    private final ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client addClient(@RequestBody ClientDto clientDTO) {
        return clientService.addClient(clientDTO);
    }

    @PostMapping("/{clientId}/contacts")
    @ResponseStatus(HttpStatus.CREATED)
    public Contact addContact(@PathVariable Long clientId, @RequestBody ContactDto contactDto) {
        return clientService.addContact(clientId, contactDto);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{clientId}")
    @ResponseStatus(HttpStatus.OK)
    public Client getClientById(@PathVariable Long clientId) {
        return clientService.getClientById(clientId);
    }

    @GetMapping("/{clientId}/contacts")
    @ResponseStatus(HttpStatus.OK)
    public List<Contact> getClientContacts(@PathVariable Long clientId) {
        return clientService.getClientContacts(clientId);
    }
}
