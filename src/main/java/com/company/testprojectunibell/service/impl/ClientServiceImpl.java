package com.company.testprojectunibell.service.impl;

import com.company.testprojectunibell.dto.ClientDto;
import com.company.testprojectunibell.dto.ContactDto;
import com.company.testprojectunibell.entity.Client;
import com.company.testprojectunibell.entity.Contact;
import com.company.testprojectunibell.exception.ClientNotFoundException;
import com.company.testprojectunibell.mapper.ClientMapper;
import com.company.testprojectunibell.mapper.ContactMapper;
import com.company.testprojectunibell.repository.ClientRepository;
import com.company.testprojectunibell.repository.ContactRepository;
import com.company.testprojectunibell.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;
    private final ClientMapper clientMapper;

    public Client addClient(ClientDto clientDto) {
        Client client = clientMapper.convertClientDtoToClient(clientDto);
        return clientRepository.save(client);
    }

    public Contact addContact(Long clientId, ContactDto contactDto) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException("Client not found with id " + clientId));
        Contact contact = contactMapper.convertContactToContact(contactDto);
        contact.setClient(client);
        client.getContacts().add(contact);
        return contactRepository.save(contact);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException("Client not found with id " + clientId));
    }

    public List<Contact> getClientContacts(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException("Client not found with id " + clientId));
        return client.getContacts();
    }
}