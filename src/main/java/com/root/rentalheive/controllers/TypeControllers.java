package com.root.rentalheive.controllers;
import com.root.rentalheive.entities.Type;
import com.root.rentalheive.services.TypeServices;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping( "/api/types")
public class TypeControllers {
    private TypeServices typeServices;
    TypeControllers(TypeServices typeServices){
        this.typeServices = typeServices;
    }

    @GetMapping("")
    public List<Type> getTypes() {
        return typeServices.getTypes();
    }

    @GetMapping("/{name}")
    public Type getType(@PathVariable String name){
        return typeServices.findByName(name);
    }

    @PostMapping("")
    public Type addType(@RequestBody Type type){
        return typeServices.addService(type);
    }

    @PutMapping("")
    public Type updateType(@RequestBody Type type){
        return typeServices.updateService(type);
    }

    @DeleteMapping("/{id}")
    public void deleteType(@PathVariable Long id){
        typeServices.deleteService(typeServices.findById(id));
    }
}
