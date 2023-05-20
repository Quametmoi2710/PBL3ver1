package com.example.demo.SERVICE;
import com.example.demo.ENTITY.Contact;
import com.example.demo.REPOSITOTY.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ContactService {
    @Autowired private ContactRepository contactRepository;
    public List<Contact> listAll(){
        return (List<Contact>) this.contactRepository.findAll();
    }
    public void saveContact(Contact contact){
        this.contactRepository.save(contact);
    }
    public Contact getById(Integer id){
        Optional<Contact> result = this.contactRepository.findById(id);
        if(result.isPresent()) return result.get();
        else return null;
    }
    public void delete(Integer id){
        this.contactRepository.deleteById(id);
    }
}
