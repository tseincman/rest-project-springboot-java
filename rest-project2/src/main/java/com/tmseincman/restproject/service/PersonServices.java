package com.tmseincman.restproject.service;

import com.tmseincman.restproject.exception.ResourceNotFoundException;
import com.tmseincman.restproject.mapper.ProjectMapper;
import com.tmseincman.restproject.model.Person;
import com.tmseincman.restproject.repository.PersonRepository;
import com.tmseincman.restproject.vo.v1.PersonVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository personRepository;

    public PersonVO findById(Long id){

        logger.info("Finding one person");

        return ProjectMapper.parseObject(personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID")), PersonVO.class) ;
    }

    public List<PersonVO> findAll(){

        logger.info("Finding all people");

        return ProjectMapper.parseListObjects(personRepository.findAll(), PersonVO.class) ;
    }


    public PersonVO create(PersonVO person){
        logger.info("Creating one person");
        var entity = ProjectMapper.parseObject(person, Person.class);
        return ProjectMapper.parseObject(personRepository.save(entity), PersonVO.class);
    }

    public PersonVO update(PersonVO person){
        logger.info("Updating one person");
        var entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return ProjectMapper.parseObject(personRepository.save(entity), PersonVO.class);
    }

    public void delete(Long id){
        logger.info("Deleting one person");

        var entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        personRepository.delete(entity);
    }
}
