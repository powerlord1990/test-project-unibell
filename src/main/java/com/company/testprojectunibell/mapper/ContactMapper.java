package com.company.testprojectunibell.mapper;

import com.company.testprojectunibell.dto.ContactDto;
import com.company.testprojectunibell.entity.Contact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    Contact convertContactToContact(ContactDto contactDto);
}
