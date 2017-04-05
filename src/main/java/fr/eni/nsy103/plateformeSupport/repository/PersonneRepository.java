package fr.eni.nsy103.plateformeSupport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.eni.nsy103.plateformeSupport.model.Personne;

@Repository
public interface PersonneRepository extends JpaRepository<Personne,Long>{
	//@Query("SELECT new fr.eni.nsy103.plateformeSupport.modele.Personne")
	//public List<Personne> findByLastname(@Param("lastname") String lastname,@Param("firstname") String firstname);
}