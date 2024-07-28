package mk.iwec.schedulerapplication.service;

import mk.iwec.schedulerapplication.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {

    List<Contact> getAllContacts();
    Optional<Contact> getContactsById(Long id);
    Contact saveContact(Contact contact);
    Optional<Contact> updateContact(Long id,Contact contact);
    boolean deleteContact(Long id);
}
