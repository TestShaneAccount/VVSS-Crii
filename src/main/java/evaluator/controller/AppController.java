package evaluator.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import evaluator.model.Intrebare;
import evaluator.model.Statistica;
import evaluator.model.Test;
import evaluator.repository.IntrebariRepository;
import evaluator.exception.DuplicateIntrebareException;
import evaluator.exception.NotAbleToCreateStatisticsException;
import evaluator.exception.NotAbleToCreateTestException;

public class AppController {
	private String sourceFile;
	private IntrebariRepository intrebariRepository;
	
	public AppController(String file) {
		sourceFile = file;
		intrebariRepository = new IntrebariRepository(sourceFile);
	}
	
	public Intrebare addNewIntrebare(Intrebare intrebare) throws DuplicateIntrebareException{
		
		intrebariRepository.addIntrebare(intrebare);
		
		return intrebare;
	}
	public List<Intrebare> Getall(){
		return intrebariRepository.loadIntrebariFromFile(sourceFile);
	}
	public boolean exists(Intrebare intrebare){
		return intrebariRepository.exists(intrebare);
	}
	
	public Test createNewTest() throws NotAbleToCreateTestException, NotAbleToCreateStatisticsException {
		
		if(intrebariRepository.getIntrebari().size() < 5)
			throw new NotAbleToCreateTestException("Nu exista suficiente intrebari pentru crearea unui test!(5)");
		if(intrebariRepository.getNumberOfDistinctDomains() < 4)
	throw new NotAbleToCreateTestException("Nu exista suficiente domenii pentru crearea unui test!(5)");
		List<Intrebare> testIntrebari = new LinkedList<Intrebare>();
		List<String> domenii = new LinkedList<String>();
		Intrebare intrebare;
		Test test = new Test();
		while(testIntrebari.size() != 5){
			intrebare = intrebariRepository.pickRandomIntrebare();
			
			if(!testIntrebari.contains(intrebare) && !domenii.contains(intrebare.getDomeniu())){
				testIntrebari.add(intrebare);
				domenii.add(intrebare.getDomeniu());
			}
		}
		test.setIntrebari(testIntrebari);
		return test;
	}
	
	public void loadIntrebariFromFile(String f){
		intrebariRepository.setIntrebari(intrebariRepository.loadIntrebariFromFile(f));
	}
	
	public Statistica getStatistica() throws NotAbleToCreateStatisticsException{
		
		if(intrebariRepository.getIntrebari().isEmpty())
			throw new NotAbleToCreateStatisticsException("Repository-ul nu contine nicio intrebare!");
		
		Statistica statistica = new Statistica();
		for(String domeniu : intrebariRepository.getDistinctDomains()){
			statistica.add(domeniu, intrebariRepository.getNumberOfIntrebariByDomain(domeniu));
		}
		
		return statistica;
	}



}
