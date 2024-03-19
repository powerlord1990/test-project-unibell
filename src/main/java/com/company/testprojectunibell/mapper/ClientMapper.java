package com.company.testprojectunibell.mapper;

import com.company.testprojectunibell.dto.ClientDto;
import com.company.testprojectunibell.dto.ContactDto;
import com.company.testprojectunibell.entity.Client;
import com.company.testprojectunibell.entity.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client convertClientDtoToClient(ClientDto ClientDto);


}
