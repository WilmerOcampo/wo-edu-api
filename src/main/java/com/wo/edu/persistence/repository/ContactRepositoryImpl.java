package com.wo.edu.persistence.repository;

import com.wo.edu.domain.dto.ContactDto;
import com.wo.edu.domain.repository.IContactDtoRepository;
import com.wo.edu.persistence.entity.user.Contact;
import com.wo.edu.persistence.mapper.IContactMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ContactRepositoryImpl implements IContactDtoRepository {
    private final IContactRepository contactRepository;
    private final IContactMapper contactMapper;

    @Override
    public List<ContactDto> findAll() {
        List<Contact> contacts = contactRepository.findAll();
        return contactMapper.toContactsDto(contacts);
    }

    @Override
    public Optional<ContactDto> findById(Long id) {
        return contactRepository.findById(id).map(contactMapper::toContactDto);
    }

    @Override
    public ContactDto save(ContactDto contactDto) {
        Contact contact = contactMapper.toContact(contactDto);
        return contactMapper.toContactDto(contactRepository.save(contact));
    }

    @Override
    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }
}
