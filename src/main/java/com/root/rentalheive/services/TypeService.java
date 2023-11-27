package com.root.rentalheive.services;

import com.root.rentalheive.entities.Type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeService {
    Type findById(Long typeId);

    List<Type> getTypes();

    Type findByName(String name);

    Type addService(Type type);

    Type updateService(Type type);

    void deleteService(Type type);
}
