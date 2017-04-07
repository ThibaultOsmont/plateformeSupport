package fr.eni.nsy103.plateformeSupport.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.eni.nsy103.plateformeSupport.model.RendezVous;
import fr.eni.nsy103.plateformeSupport.util.enums.Jours;

@Repository
public interface RendezVousRepository  extends JpaRepository<RendezVous,Long>{
	@Query("Select rdv From RendezVous rdv where rdv.rdvPK.salarie.id = :salarieid and rdv.rdvPK.client.id = :clientid ")
	public RendezVous findRendezVousRepositoryByIdsalarie(@Param("salarieid") int salarieId,@Param("clientid") int c);
	
	@Query("select r.jour from RendezVous r where r.jour >= :dateDebut and r.jour <= :dateFin")
	public List<Date> findRdvBetweenDates(@Param("dateDebut") Date dateDebut,@Param("dateFin") Date dateFin);
}
