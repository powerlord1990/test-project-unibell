package com.company.testprojectunibell.repository;

import com.company.testprojectunibell.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
