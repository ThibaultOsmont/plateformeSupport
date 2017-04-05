package fr.eni.nsy103.plateformeSupport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.eni.nsy103.plateformeSupport.model.Profil;

@Repository
public interface ProfilRepository  extends JpaRepository<Profil,Long>{
	
}
