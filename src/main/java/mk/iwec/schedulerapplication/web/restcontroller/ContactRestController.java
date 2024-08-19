package mk.iwec.schedulerapplication.web.restcontroller;

import mk.iwec.schedulerapplication.mapper.ContactMapper;
import mk.iwec.schedulerapplication.model.Contact;
import mk.iwec.schedulerapplication.model.dto.ContactDTO;
import mk.iwec.schedulerapplication.service.impl.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/contacts")
public class ContactRestController {

    @Autowired
    private ContactServiceImpl contactService;

    @Autowired
    private ContactMapper contactMapper;

    @GetMapping
    public List<ContactDTO> getAllContacts() {
        List<Contact> contacts = contactService.getAll();
        return contacts.stream()
                .map(contactMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactDTO> getContactById(@PathVariable UUID id) {
        Optional<Contact> contact = contactService.getById(id);
        return contact.map(contactMapper::entityToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ContactDTO> createContact(@RequestBody ContactDTO contactDTO) {
        Contact contact = contactMapper.dtoToEntity(contactDTO);
        Contact createdContact = contactService.save(contact);
        ContactDTO createdContactDTO = contactMapper.entityToDto(createdContact);
        return ResponseEntity.ok(createdContactDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ContactDTO> updateContact(@PathVariable UUID id, @RequestBody ContactDTO contactDTO) {
        Contact contact = contactMapper.dtoToEntity(contactDTO);
        Optional<Contact> updatedContact = contactService.update(id, contact);
        return updatedContact.map(contactMapper::entityToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable UUID id) {
        boolean isDeleted = contactService.delete(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
