package com.root.rentalheive.services;

import com.root.rentalheive.entities.Devis;
import com.root.rentalheive.repositories.DevisRepository;
import com.root.rentalheive.services.Impl.DevisServiceImpl;
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
class DevisServiceTest {

    @Mock
    private DevisRepository devisRepository;
    @InjectMocks
    private DevisServiceImpl devisServiceImpl;

    @Test
    public void returnAll() {
        List<Devis> expectedDevisList = new ArrayList<>();
        Mockito.when(devisRepository.findAll()).thenReturn(expectedDevisList);;
        List<Devis> actualDevisList = this.devisServiceImpl.getDevis();
        assertEquals(expectedDevisList, actualDevisList);
    }

    @Test
    public void delete() {
        Devis devis = new Devis();
        devis.setId(1L);
        Mockito.doNothing().when(devisRepository).delete(devis);
        devisRepository.delete(devis);
        Mockito.verify(devisRepository).delete(devis);
    }


}