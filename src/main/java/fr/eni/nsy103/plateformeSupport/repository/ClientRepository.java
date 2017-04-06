package fr.eni.nsy103.plateformeSupport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.eni.nsy103.plateformeSupport.model.Client;

@Repository
public interface ClientRepository  extends JpaRepository<Client,Long>{
	/*@Query("Select c from Client c Where c.client.nom = :lastname and c.client.prenom = :firstname")
	public List <Client> findByLastname(@Param("lastname") String lastname,@Param("firstname") String firstname);*/
}
