package fr.eni.nsy103.plateformeSupport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.eni.nsy103.plateformeSupport.model.Salarie;

@Repository
public interface SalarieRepository  extends JpaRepository<Salarie,Long>{

}
