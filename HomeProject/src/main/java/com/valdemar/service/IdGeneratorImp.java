package com.valdemar.service;

import java.util.UUID;

public class IdGeneratorImp implements IdGenerator {
    @Override
    public String generation() {
        return UUID.randomUUID().toString();
    }
}
