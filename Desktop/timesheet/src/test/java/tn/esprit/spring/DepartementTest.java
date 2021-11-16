package tn.esprit.spring;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Tag;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tn.esprit.spring.services.*;
import tn.esprit.spring.entities.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)

public class DepartementTest{
	
	DepartementServiceImpl d;

	@Test
		public void afficheAllDepartementsTest() {
			List<Departement> res =d.getAllDepartements();
			
			assertFalse("Error to display Departements", res==null);
			assertTrue("display Departements Successfully",res!=null);	

}
}
