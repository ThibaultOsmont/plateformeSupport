package fr.eni.nsy103.plateformeSupport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import fr.eni.nsy103.plateformeSupport.model.Personne;

public interface PersonneRepository extends Repository<Personne,Long>{
	@Query("SELECT p FROM PERSONNE p WHERE p.lastname = :lastname AND p.firstname = :firstname")
	public List<Personne> findByLastname(@Param("lastname") String lastname,@Param("firstname") String firstname);
}