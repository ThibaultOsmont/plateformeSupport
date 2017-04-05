package fr.eni.nsy103.plateformeSupport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.eni.nsy103.plateformeSupport.model.Client;

@Repository
public interface ClientRepository  extends JpaRepository<Client,Long>{
	
}
