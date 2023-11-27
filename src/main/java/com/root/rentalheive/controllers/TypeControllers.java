package com.root.rentalheive.controllers;
import com.root.rentalheive.entities.Type;
import com.root.rentalheive.services.Impl.TypeServiceImpl;
import com.root.rentalheive.services.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping( "/api/types")
public class TypeControllers {

    private final TypeService typeService;

    @GetMapping("")
    public ResponseEntity<List<Type>> getTypes() {
        List<Type> typeList = typeService.getTypes();
        return new ResponseEntity<>(typeList, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Type> getType(@PathVariable String name) {
        Type type = typeService.findByName(name);
        return type != null
                ? new ResponseEntity<>(type, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("")
    public ResponseEntity<Type> addType(@RequestBody Type type) {
        Type addedType = typeService.addService(type);
        return new ResponseEntity<>(addedType, HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Type> updateType(@RequestBody Type type) {
        Type updatedType = typeService.updateService(type);
        return new ResponseEntity<>(updatedType, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteType(@PathVariable Long id) {
        Type type = typeService.findById(id);

        if (type != null) {
            typeService.deleteService(type);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
