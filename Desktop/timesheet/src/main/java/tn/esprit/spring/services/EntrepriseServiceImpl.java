package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.controller.ControllerEntrepriseImpl;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {
	private static final Logger l = Logger.getLogger(ControllerEntrepriseImpl.class);

	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;
	
	public int ajouterEntreprise(Entreprise entreprise) {
	    l.info("debut ajout enreprise");

		try{
		entrepriseRepoistory.save(entreprise);
		l.debug("entreprise ajoutée avec succèes ");

		return entreprise.getId();
		}
		catch (Exception e) {
			l.error("erreur dans ajouter entreprise "+e); 
			return 0 ;}
	}
		

	public int ajouterDepartement(Departement dep) {
	    l.info("debut ajout département");

		try{
		deptRepoistory.save(dep);
		l.debug("departement ajoutée avec succèes ");

		return dep.getId();
		}
		catch (Exception e) {
			l.error("erreur dans ajouter département "+e); 
			return 0 ;}
	}
	
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
	    l.info("debut affectation département");

		Optional<Entreprise> enOptional = entrepriseRepoistory.findById(entrepriseId);
		Optional<Departement> depOptional = deptRepoistory.findById(depId);
		try{
		if(enOptional.isPresent() && depOptional.isPresent())
		{
		    l.info("entreprise et dépratement trouvé ");

			Entreprise entrepriseManagedEntity = enOptional.get();
			Departement depManagedEntity = depOptional.get();
			
			depManagedEntity.setEntreprise(entrepriseManagedEntity);
			deptRepoistory.save(depManagedEntity);
		}
		l.debug("departement affecté avec succèes ");

		}
		catch (Exception e) {
			l.error("erreur dans l'affectation du département "+e); 
			}
		
				
		
	}
	
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		
	    l.info("debut affichage département");

		Optional<Entreprise> enOptional = entrepriseRepoistory.findById(entrepriseId);
		
		if(enOptional.isPresent())
		{
		    l.info("departement trouvé");

			Entreprise entrepriseManagedEntity = enOptional.get();
			List<String> depNames = new ArrayList<>();
			for(Departement dep : entrepriseManagedEntity.getDepartements()){
				depNames.add(dep.getName());
			}
			l.debug("departements affichés avec succès ");

			return depNames;
		

		}
		
			l.error("erreur dans l'affichage du département"); 
			return Collections.emptyList(); 

			
		
	}

	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
	    l.info("debut suppression entreprise");

		Optional<Entreprise> enOptional = entrepriseRepoistory.findById(entrepriseId);
		try{

		if(enOptional.isPresent())
		{
		    l.info(" enreprise trouvée");

			entrepriseRepoistory.delete(enOptional.get());	
			l.debug("entreprise supprimé avec succès ");

		}
		}
		catch (Exception e) {
			l.error("erreur dans la supression de l'entreprise "); 
		
			}
		
	}

	@Transactional
	public void deleteDepartementById(int depId) {
	    l.info(" debut suppression département by id");

		Optional<Departement> depOptional = deptRepoistory.findById(depId);

		try{
		if(depOptional.isPresent())
		{
		    l.info(" departement trouvé");

			deptRepoistory.delete(depOptional.get());	
		}
		l.debug("departements supprimé avec succès ");

	}
	catch (Exception e) {
		l.error("erreur dans la supression du département"); 
	
		}
	}
	

	public Entreprise getEntrepriseById(int entrepriseId) {
	    l.info(" debut affichage entreprise par id");

		Optional<Entreprise> enOptional = entrepriseRepoistory.findById(entrepriseId);
		
		if(enOptional.isPresent())
		{
		    l.info(" enreprise trouvée");

			l.debug("entreprise affiché avec succès ");

			return enOptional.get();	
		}
		
		
			l.error("erreur dans l'affichage de l'entreprise "); 
			return null;

			
		
	}
	public Optional<Entreprise> optionalGetEntrepriseById(int entrepriseId) {
		return entrepriseRepoistory.findById(entrepriseId);
		}


}
