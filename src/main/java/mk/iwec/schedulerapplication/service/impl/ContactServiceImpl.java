package mk.iwec.schedulerapplication.service.impl;


import mk.iwec.schedulerapplication.model.Contact;
import mk.iwec.schedulerapplication.repository.ContactRepository;
import mk.iwec.schedulerapplication.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContactServiceImpl implements GenericService<Contact> {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> getAll() {
        return contactRepository.findAll();
    }

    @Override
    public Optional<Contact> getById(UUID id) {
        return contactRepository.findById(id);
    }

    @Override
    public Contact save(Contact entity) {
        return contactRepository.save(entity);
    }

    @Override
    public Optional<Contact> update(UUID id, Contact entity) {
        return getById(id).map(contact1->{
            contact1.setFirstname(entity.getFirstname());
            contact1.setEmail(entity.getEmail());
            contact1.setAddress(entity.getAddress());
            contact1.setLastname(entity.getLastname());
            contact1.setPhoneNumber(entity.getPhoneNumber());
            contact1.setAvatar(entity.getAvatar());
            return contactRepository.save(contact1);
        });
    }

    @Override
    public boolean delete(UUID id) {
        return getById(id).map(contact->{
            contactRepository.delete(contact);
            return true;
        }).orElse(false);
    }
}
