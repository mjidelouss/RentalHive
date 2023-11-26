package com.root.rentalheive.services;

import com.root.rentalheive.entities.Type;
import com.root.rentalheive.repositories.TypeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TypeServices {

    TypeRepository typeRepository;

    @Autowired
    public TypeServices(TypeRepository typeRepository){
        this.typeRepository=typeRepository;
    }

    public Type addService(@Valid Type type) {
        return typeRepository.save(type);
    }

    public Type updateService(@Valid Type type) {
        if (typeRepository.findById(type.getId()).isPresent()) {
            return typeRepository.save(type);
        } else {
            throw new IllegalArgumentException("Type not found for id: " + type.getId());
        }
    }

    public void deleteService(@Valid Type type) {
        if (typeRepository.findById(type.getId()).isPresent()) {
            typeRepository.delete(type);
        } else {
            throw new IllegalArgumentException("Type not found for id: " + type.getId());
        }
    }

    public Type findByName(String name) {
        return typeRepository.findByName(name).orElse(null);
    }

    public Type findById(Long id) {
        return typeRepository.findById(id).orElse(null);
    }

    public List<Type> getTypes() {
        return typeRepository.findAll();
    }
}
