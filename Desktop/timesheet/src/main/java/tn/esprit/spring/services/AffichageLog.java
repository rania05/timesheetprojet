package tn.esprit.spring.services;

import org.apache.log4j.Logger;
public class AffichageLog {
private static final Logger l = Logger.getLogger(AffichageLog.class);
public static void main(String[] args) {
AffichageLog al = new AffichageLog();
int a = 5;
int b = 0;
al.getAllPrducts(a,b); }
public void getAllPrducts (int a,int b)
{
try {

l.info("In getAllPrducts() : ");
l.debug("Je vais lancer la divsion.");
//int i = 1/0;
l.debug("Je viens de lancer la divsion. ");



if(b!=0)
{
	int i = a/b;
	l.debug("Je viens de lancer la divsion. " + i);
	
}else
{
	l.warn("impossible de Diviser par 0");
}

l.debug("Je viens de finir l'opération X.");
l.info("Out getAllPrducts() without errors.");
}
catch (Exception e) { l.error("Erreur dans getAllPrducts() : " + e); }
}}
