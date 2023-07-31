package com.tmseincman.restproject.mapper.custom;

import com.tmseincman.restproject.model.Person;
import com.tmseincman.restproject.vo.v2.PersonVOV2;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonVOV2 convertEntityToVo(Person person){
        PersonVOV2 vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setAddress(person.getAddress());
        vo.setGender(person.getGender());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setBirthDate(new Date());
        return vo;
    }

    public Person convertVoToEntity(PersonVOV2 person){
        Person obj = new Person();
        obj.setId(person.getId());
        obj.setAddress(person.getAddress());
        obj.setGender(person.getGender());
        obj.setFirstName(person.getFirstName());
        obj.setLastName(person.getLastName());
        //obj.setBirthDate(new Date());
        return obj;
    }
}
