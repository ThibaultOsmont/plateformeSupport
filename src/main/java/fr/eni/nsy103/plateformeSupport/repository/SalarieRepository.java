package fr.eni.nsy103.plateformeSupport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import fr.eni.nsy103.plateformeSupport.model.Salarie;

@Repository
public interface SalarieRepository  extends JpaRepository<Salarie,Long>{

	@Query("SELECT s  FROM Salarie s where s.login = :login AND s.pwd = :password")
	public Salarie findByLoginPassword(@Param("login") String login,@Param("password") String password);
	
}
