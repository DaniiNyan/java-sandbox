package com.daniinyan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daniinyan.models.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
