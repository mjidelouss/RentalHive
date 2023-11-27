package com.root.rentalheive.services;

import com.root.rentalheive.entities.Type;
import com.root.rentalheive.repositories.TypeRepository;
import com.root.rentalheive.services.Impl.TypeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

public class TypeServicesTest {


    @Mock
    private TypeRepository typeRepository;

    @InjectMocks
    private TypeServiceImpl typeServiceImpl;

    @Test
    public void addServiceTest() {
        Type type =Type.builder()
                .id(1L)
                .name("type test")
                .build();
        Mockito.when(typeRepository.save(type)).thenReturn(type);

        Type addedType = typeServiceImpl.addService(type);

        assertEquals(type, addedType);
    }

    @Test
    public void updateServiceTest() {
        Type type =Type.builder()
                .id(1L)
                .name("updated test")
                .build();

        Mockito.when(typeRepository.save(type)).thenReturn(type);

        Type updatedType = typeServiceImpl.updateService(type);

        assertEquals(type, updatedType);
    }

    @Test
    public void deleteServiceTest() {
        Type type =Type.builder()
                .id(1L)
                .build();

        Mockito.doNothing().when(typeRepository).delete(type);

        typeServiceImpl.deleteService(type);

        Mockito.verify(typeRepository).delete(type);
    }

    @Test
    public void getTypesTest() {
        List<Type> types = new ArrayList<>();
        types.add(new Type());
        types.add(new Type());
        Mockito.when(typeRepository.findAll()).thenReturn(types);
        List<Type> retrievedTypes = typeServiceImpl.getTypes();
        assertEquals(types, retrievedTypes);
    }
}