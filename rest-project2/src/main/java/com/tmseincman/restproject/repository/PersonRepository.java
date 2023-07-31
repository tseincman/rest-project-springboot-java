package com.tmseincman.restproject.repository;

import com.tmseincman.restproject.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
