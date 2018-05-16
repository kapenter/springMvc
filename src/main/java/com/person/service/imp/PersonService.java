package com.person.service.imp;

import com.person.service.IPersonService;
import org.springframework.stereotype.Service;

@Service(value ="personService" )
public class PersonService implements IPersonService {

    @Override
    public void referPersonName() {
        System.out.println(" hello  i am getHere");
    }

    @Override
    public void sayHello() {
        System.out.println("hello everyOne!!!!");
    }
}
