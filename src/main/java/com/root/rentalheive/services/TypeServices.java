package com.root.rentalheive.services;

import com.root.rentalheive.entities.Type;
import com.root.rentalheive.repositories.TypeRepository;
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

    public Type addService(Type type) {
        return typeRepository.save(type);
    }

    public Type updateService(Type type) {
        return typeRepository.save(type);
    }

    public void deleteService(Type type) {
        typeRepository.delete(type);
    }

    public Type findByName(String name) {
        if(typeRepository.findByName(name).isPresent()){
            return typeRepository.findByName(name).get();
        }
        return null;
    }
    public Type findById(Long id){
        if(typeRepository.findById(id).isPresent()){
            return typeRepository.findById(id).get();
        }
        return null;
    }

    public List<Type> getTypes() {
        return typeRepository.findAll();
    }
}
