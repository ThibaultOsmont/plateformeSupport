package fr.eni.nsy103.plateformeSupport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.eni.nsy103.plateformeSupport.model.Salarie;

@Repository
public interface SalarieRepository  extends JpaRepository<Salarie,Long>{

	@Query("SELECT s  FROM Salarie s where s.login = :login AND s.pwd = :password")
	public Salarie findByLoginPassword(@Param("login") String login,@Param("password") String password);
	
	/**
	 * Récupère tous les salaries qui sont conseillers
	 * 
	 * @return
	 * 	Tous les conseillers
	 */
	@Query("SELECT s FROM Salarie s INNER JOIN Profil p ON s.id_salarie = p.id_profil "
			+ "WHERE p.userStatus like 'CNS'")
	public List<Salarie> findAllConseiller();
	
	/**
	 * Récupère tous les salaries qui sont au centre d'accueil
	 * 
	 * @return
	 * 	Toutes les personnes travaillant au centre d'accueil
	 */
	@Query("SELECT s FROM Salarie s INNER JOIN Profil p ON s.id_salarie = p.id_profil "
			+ "WHERE p.userStatus like 'ACC'")
	public List<Salarie> findAllCentreAccueil();
	
	/**
	 * Récupère tous les salaries qui sont administrateurs
	 * 
	 * @return
	 * 	Tous les administrateurs
	 */
	@Query("SELECT s FROM Salarie s INNER JOIN Profil p ON s.id_salarie = p.id_profil "
			+ "WHERE p.userStatus like 'ADM'")
	public List<Salarie> findAllAdmin();
}
