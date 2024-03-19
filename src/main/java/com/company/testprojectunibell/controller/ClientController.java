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
    public ResponseEntity<Client> addClient(@RequestBody ClientDto clientDTO) {
        Client savedClient = clientService.addClient(clientDTO);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

    @PostMapping("/{clientId}/contacts")
    public ResponseEntity<Contact> addContact(@PathVariable Long clientId, @RequestBody ContactDto contactDto) {
        Contact savedContact = clientService.addContact(clientId, contactDto);
        return new ResponseEntity<>(savedContact, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getAllClients();
        log.info(clients.toString());
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> getClientById(@PathVariable Long clientId) {
        Client client = clientService.getClientById(clientId);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @GetMapping("/{clientId}/contacts")
    public ResponseEntity<List<Contact>> getClientContacts(@PathVariable Long clientId) {
        List<Contact> contacts = clientService.getClientContacts(clientId);
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }
}
