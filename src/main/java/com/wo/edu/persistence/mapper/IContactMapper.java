package com.wo.edu.persistence.mapper;

import com.wo.edu.domain.dto.ContactDto;
import com.wo.edu.persistence.entity.user.Contact;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IContactMapper {
    ContactDto toContactDto(Contact contact);

    List<ContactDto> toContactsDto(List<Contact> contacts);

    @InheritInverseConfiguration
    @Mapping(target = "updatedAt", ignore = true)
    Contact toContact(ContactDto contactDto);
}
