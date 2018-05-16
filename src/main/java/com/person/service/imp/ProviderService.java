package com.person.service.imp;

import com.person.service.IProviderService;
import org.springframework.stereotype.Service;

@Service
public class ProviderService implements IProviderService {
    @Override
    public void sayHello() {
        System.out.println("say  hello !!!");
    }
}
