package fr.eni.nsy103.plateformeSupport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.eni.nsy103.plateformeSupport.model.Profil;

@Repository
public interface ProfilRepository  extends JpaRepository<Profil,Long>{
	
	/**
	 * Récupère un profil par son id (QUi est aussi l'id du salarié)
	 * 
	 * @param id
	 * 		Id du profil ou du salarié.
	 * 
	 * @return
	 * 		Le profil s'il existe ou null.
	 */
	@Query("SELECT p  FROM Profil p where p.id_profil = :id")
	public Profil findById(@Param("id") String id);
}
