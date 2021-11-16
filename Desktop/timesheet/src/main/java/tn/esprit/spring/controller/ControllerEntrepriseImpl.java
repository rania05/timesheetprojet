package tn.esprit.spring.controller;

import java.util.List;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.EntrepriseServiceImpl;
import tn.esprit.spring.services.IDepartementService;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;
import tn.esprit.spring.services.ITimesheetService;

@Controller
public class ControllerEntrepriseImpl{

	private static final Logger l = Logger.getLogger(ControllerEntrepriseImpl.class);
	
	@Autowired
	IEmployeService iemployeservice;
	@Autowired
	IEntrepriseService ientrepriseservice;
	@Autowired
	IDepartementService idepartementService;
	@Autowired
	ITimesheetService itimesheetservice;
	
	public int ajouterEntreprise(Entreprise ssiiConsulting) {
		try{
			ientrepriseservice.ajouterEntreprise(ssiiConsulting);
			l.debug("entreprise ajoutée avec succèes ");
			return ssiiConsulting.getId();
		}
		catch (Exception e) {
			l.debug("ajouté avec succès "); 
			return 0 ;}
			
		


	}
	
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		try{
		ientrepriseservice.affecterDepartementAEntreprise(depId, entrepriseId);
		l.info("department id ="+depId+"entreprise Id="+entrepriseId);
		}
		catch (Exception e) { 
			
			l.error("Erreur dans affecterDepartementAEntreprise : " + e); }
		
	}
	public void deleteEntrepriseById(int entrepriseId)
	{
		try{
		ientrepriseservice.deleteEntrepriseById(entrepriseId);
		l.info("entreprise supprimé est celle de l'id ="+entrepriseId);
		}
		catch(Exception e) { l.error("l'entreprise n'existe pas: " + e); }
		
	}
	public Entreprise getEntrepriseById(int entrepriseId) {

		return ientrepriseservice.getEntrepriseById(1);
		
	}
	
	public int ajouterDepartement(Departement dep) {
		return idepartementService.ajouterDepartement(dep);
	}
	
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		return ientrepriseservice.getAllDepartementsNamesByEntreprise(entrepriseId);
	}

	public void deleteDepartementById(int depId) {
try{
	idepartementService.deleteDepartementById(depId);
		l.info("le departement supprimé est celle de l'id ="+depId);

}
catch(Exception e) { l.error("le departement n'existe pas: " + e); }

	}
}
