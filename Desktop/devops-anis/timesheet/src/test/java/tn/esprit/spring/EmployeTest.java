package tn.esprit.spring;




import java.text.ParseException;


import java.util.Optional;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IEmployeService;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;




@RunWith(SpringRunner.class)
@SpringBootTest
@Import(AnnotationAwareAspectJAutoProxyCreator.class)
public class EmployeTest {
	//@Autowired
	//private EmployeServiceImpl e ;
	
	@Autowired
	IEmployeService e;

	

	
	private Employe emp = new Employe("Test", "Test", "Test@test.tn", "root", true, Role.INGENIEUR);
	
	@Test
	public void testAdd()
	{
		
		
		int res = e.addOrUpdateEmploye(emp);
		assertFalse("Error in Adding Employe", res==0);
		assertTrue("Added Emplye Successfully",res!=0);	
	}
	
	@Test
	public void testGetEmployePrenomById()
	{
		
		
		int id = e.addOrUpdateEmploye(emp);
		String res = e.getEmployePrenomById(id);
		assertFalse("Error in getting Employe Prenom", res==null);
		assertTrue("Got Employe Prenom successfully",res!=null);
	}
	
	@Test
	public void testRemoveEmploye()
	{
		e.deleteEmployeById(11);
		String res = e.getEmployePrenomById(11);
		System.out.println(res);
		assertThat(res==null);
	}

}
