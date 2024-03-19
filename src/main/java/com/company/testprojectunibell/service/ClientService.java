package com.company.testprojectunibell.service;

import com.company.testprojectunibell.dto.ClientDto;
import com.company.testprojectunibell.dto.ContactDto;
import com.company.testprojectunibell.entity.Client;
import com.company.testprojectunibell.entity.Contact;

import java.util.List;

public interface ClientService {

    Client addClient(ClientDto client);

    Contact addContact(Long clientId, ContactDto contact);

    List<Client> getAllClients();

    Client getClientById(Long clientId);

    List<Contact> getClientContacts(Long clientId);
}
