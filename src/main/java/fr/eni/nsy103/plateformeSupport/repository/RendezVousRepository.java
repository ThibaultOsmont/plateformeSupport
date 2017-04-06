package fr.eni.nsy103.plateformeSupport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.eni.nsy103.plateformeSupport.model.Client;
import fr.eni.nsy103.plateformeSupport.model.RendezVous;
import fr.eni.nsy103.plateformeSupport.model.Salarie;

@Repository
public interface RendezVousRepository  extends JpaRepository<RendezVousRepository,Long>{
@Query("Select rdv From RendezVous rdv where rdv.rdvPK.salarieId = :salarieid and rdv.rdvPK.clientId = :clientid ")
public RendezVousRepository FindRendezVousRepositoryByIdsalarie(@Param("salarieid") String salarieId,@Param("clientid") String c);
}
