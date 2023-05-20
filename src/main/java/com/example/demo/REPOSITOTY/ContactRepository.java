package com.example.demo.REPOSITOTY;

import com.example.demo.ENTITY.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Integer> {
}
