package com.wo.edu.domain.service;

import com.wo.edu.domain.dto.ContactDto;
import com.wo.edu.domain.repository.IContactDtoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements IContactService {
    private final IContactDtoRepository contactDtoRepository;

    @Override
    public List<ContactDto> findAll() {
        return contactDtoRepository.findAll();
    }

    @Override
    public Optional<ContactDto> findById(Long id) {
        return contactDtoRepository.findById(id);
    }

    @Override
    public ContactDto save(ContactDto contactDto) {
        return contactDtoRepository.save(contactDto);
    }

    @Override
    public Boolean deleteById(Long id) {
        return findById(id).map(c -> {
            contactDtoRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
