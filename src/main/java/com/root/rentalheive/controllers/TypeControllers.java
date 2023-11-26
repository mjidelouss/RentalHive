package com.root.rentalheive.controllers;
import com.root.rentalheive.entities.Type;
import com.root.rentalheive.services.TypeServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Type>> getTypes() {
        List<Type> typeList = typeServices.getTypes();
        return new ResponseEntity<>(typeList, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Type> getType(@PathVariable String name) {
        Type type = typeServices.findByName(name);
        return type != null
                ? new ResponseEntity<>(type, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("")
    public ResponseEntity<Type> addType(@RequestBody Type type) {
        Type addedType = typeServices.addService(type);
        return new ResponseEntity<>(addedType, HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Type> updateType(@RequestBody Type type) {
        Type updatedType = typeServices.updateService(type);
        return new ResponseEntity<>(updatedType, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteType(@PathVariable Long id) {
        Type type = typeServices.findById(id);

        if (type != null) {
            typeServices.deleteService(type);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
