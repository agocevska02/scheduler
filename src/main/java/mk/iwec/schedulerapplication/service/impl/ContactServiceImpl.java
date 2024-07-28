package mk.iwec.schedulerapplication.service.impl;


import mk.iwec.schedulerapplication.model.Contact;
import mk.iwec.schedulerapplication.repository.ContactRepository;
import mk.iwec.schedulerapplication.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;
    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Optional<Contact> getContactsById(Long id) {
        return contactRepository.findById(id);
    }

    @Override
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Optional<Contact> updateContact(Long id, Contact contact) {
        return getContactsById(id).map(contact1->{
            contact1.setFirstname(contact.getFirstname());
            contact1.setEmail(contact.getEmail());
            contact1.setAddress(contact.getAddress());
            contact1.setLastname(contact.getLastname());
            contact1.setPhonenumber(contact.getPhonenumber());
            return contactRepository.save(contact1);
        });
    }

    @Override
    public boolean deleteContact(Long id) {
        return getContactsById(id).map(contact->{
            contactRepository.delete(contact);
            return true;
        }).orElse(false);
    }
}
