package tn.esprit.spring;




import java.text.ParseException;

import java.util.Optional;

import tn.esprit.spring.entities.Role;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;


import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;

import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;
import static org.assertj.core.api.Assertions.assertThat;




@RunWith(SpringRunner.class)
@SpringBootTest
@Import(AnnotationAwareAspectJAutoProxyCreator.class)
public class EntrepriseTest {

	@Autowired
	IEntrepriseService enterpriseRepository;

	@Autowired
	IEmployeService iemployeservice;


	
	
@Test
	public void testAjouterEntreprise() throws ParseException{
		
		Entreprise e = new Entreprise("vega","electronic");
	
		enterpriseRepository.ajouterEntreprise(e);
		
		
		assertThat(e.getId()).isGreaterThan(0);
	}

	@Test
	public void testFindEntrepriseById() {
		Entreprise entreprise = enterpriseRepository.getEntrepriseById(2);
		assertThat(entreprise.getId()).isEqualTo(2);
	}


	@Test
	public void tesUpdateEntreprise() {
		Entreprise entreprise = enterpriseRepository.getEntrepriseById(2);
		entreprise.setName("Esprit2");
		int entrepriseId = enterpriseRepository.ajouterEntreprise(entreprise);
		Entreprise updatedEntreprise = enterpriseRepository.getEntrepriseById(entrepriseId);
		assertThat(updatedEntreprise.getName()).isEqualTo(entreprise.getName());
	}

	@Test
	public void tesDeleteEntreprise() {
		Entreprise entreprise = enterpriseRepository.getEntrepriseById(4);
		Optional<Entreprise> optionalEntreprise =  enterpriseRepository.optionalGetEntrepriseById(entreprise.getId());
		assertThat(optionalEntreprise.isPresent()).isTrue();
if ( optionalEntreprise.isPresent())
{
		enterpriseRepository.deleteEntrepriseById(optionalEntreprise.get().getId());
		
	}
	}
	

}
