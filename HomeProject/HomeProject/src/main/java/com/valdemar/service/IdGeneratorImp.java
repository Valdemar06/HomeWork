package com.valdemar.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdGeneratorImp implements IdGenerator {
    @Override
    public String generation() {
        return UUID.randomUUID().toString();
    }
}
