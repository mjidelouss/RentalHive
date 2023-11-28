package com.root.rentalheive.services;

import com.root.rentalheive.entities.Type;
import java.util.List;

public interface TypeService {
    Type findById(Long typeId);

    List<Type> getTypes();

    Type findByName(String name);

    Type addService(Type type);

    Type updateService(Type type);

    void deleteService(Type type);
}
