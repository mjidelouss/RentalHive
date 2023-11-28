package com.root.rentalheive.services.Impl;
import com.root.rentalheive.entities.Devis;
import com.root.rentalheive.repositories.DevisRepository;
import com.root.rentalheive.services.DevisService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DevisServiceImpl implements DevisService {

    private final DevisRepository devisRepository;

    public List<Devis> getDevis() {
        return this.devisRepository.findAll();
    }

    public Devis saveDevis(Devis devis) {
        return this.devisRepository.save(devis);
    }

    public boolean deleteDevis(@NotNull Long id) {
        Devis devis = devisRepository.findById(id).orElse(null);

        if (devis != null) {
            this.devisRepository.delete(devis);
            return true;
        } else {
            throw new IllegalArgumentException("Devis not found for id: " + id);
        }
    }

}
