package evaluator.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import evaluator.exception.NotAbleToCreateTestException;
import evaluator.model.Intrebare;
import evaluator.model.Statistica;

import evaluator.controller.AppController;
import evaluator.exception.NotAbleToCreateStatisticsException;
import evaluator.model.Test;

//functionalitati
//F01.	 adaugarea unei noi intrebari pentru un anumit domeniu (enunt intrebare, raspuns 1, raspuns 2, raspuns 3, raspunsul corect, domeniul) in setul de intrebari disponibile;
//F02.	 crearea unui nou test (testul va contine 5 intrebari alese aleator din cele disponibile, din domenii diferite);
//F03.	 afisarea unei statistici cu numarul de intrebari organizate pe domenii.

public class StartApp {

	private static final String file = "C:\\Facultate\\VVSS\\src\\5-ProiectEvaluatorExamen\\ProiectEvaluatorExamen\\src\\main\\java\\evaluator\\main\\intrebari.txt";
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		
		AppController appController = new AppController(file);
		
		boolean activ = true;
		String optiune = null;
		
		while(activ){
			
			System.out.println("");
			System.out.println("1.Afiseaza intrebari");
			System.out.println("2.Creeaza test");
			System.out.println("3.Statistica");
			System.out.println("4.Exit");
			System.out.println("");
			
			optiune = console.readLine();
			
			switch(optiune){
			case "1" : {
			List<Intrebare> intrebari = appController.Getall();
				for (Intrebare i: intrebari
					 ) {
					System.out.println(i.getEnunt() +" " + i.getVarianta1() + " " + i.getVarianta2() + " " + i.getVariantaCorecta() + " " + i.getDomeniu());


				}
break;
			}
			case "2" : {
				try {
					Test test = null;
					try {
						test = appController.createNewTest();
					} catch (NotAbleToCreateStatisticsException e) {
						System.out.println(e.getMessage());
					}
					for (Intrebare i : test.getIntrebari()
						 ) {
						System.out.println(i.getEnunt() + ", " + i.getVarianta1() + ", " + i.getVarianta2() +"," + i.getVarianta3());

					}
				} catch (NotAbleToCreateTestException e) {
					System.out.println(e.getMessage());
				}
				break;
			}
			case "3" :
				appController.loadIntrebariFromFile(file);
				Statistica statistica;
				try {
					statistica = appController.getStatistica();
					System.out.println(statistica);
				} catch (NotAbleToCreateStatisticsException e) {
					// TODO
				}
				
				break;
			case "4" :
				activ = false;
				break;
			default:
				break;
			}
		}
		
	}

}
