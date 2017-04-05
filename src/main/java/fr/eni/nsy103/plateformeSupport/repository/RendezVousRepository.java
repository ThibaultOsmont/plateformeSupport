package fr.eni.nsy103.plateformeSupport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.eni.nsy103.plateformeSupport.model.RendezVous;

@Repository
public interface RendezVousRepository  extends JpaRepository<RendezVous,Long>{

}
