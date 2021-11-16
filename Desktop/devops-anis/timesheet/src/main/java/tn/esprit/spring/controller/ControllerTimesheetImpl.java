package tn.esprit.spring.controller;

import java.util.Date;
import org.apache.log4j.Logger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;
import tn.esprit.spring.services.ITimesheetService;

@Controller
public class ControllerTimesheetImpl {
	private static final Logger l = Logger.getLogger(ControllerEntrepriseImpl.class);

	@Autowired
	IEmployeService iemployeservice;
	@Autowired
	IEntrepriseService ientrepriseservice;
	@Autowired
	ITimesheetService itimesheetservice;

	public int ajouterMission(Mission mission) {
		itimesheetservice.ajouterMission(mission);
		return mission.getId();
	}

	public void affecterMissionADepartement(int missionId, int depId) {
		itimesheetservice.affecterMissionADepartement(missionId, depId);

	}
	public void ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin) {
		try {
			l.info("In ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin) : ");
			l.debug("Je vais lancer l'ajout.");
		itimesheetservice.ajouterTimesheet(missionId, employeId, dateDebut, dateFin);
			l.debug("l'ajout c'est bon louled selket");
			l.info("Out ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin) : ");

		}
		catch (Exception e) { l.error("Erreur dans getAllPrducts() : " + e); } 

	}

	
	public void validerTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin, int validateurId) {
		itimesheetservice.validerTimesheet(missionId, employeId, dateDebut, dateFin, validateurId);

	}
	public List<Mission> findAllMissionByEmployeJPQL(int employeId) {

		return itimesheetservice.findAllMissionByEmployeJPQL(employeId);
	}


	public List<Employe> getAllEmployeByMission(int missionId) {

		return itimesheetservice.getAllEmployeByMission(missionId);
	}
}
