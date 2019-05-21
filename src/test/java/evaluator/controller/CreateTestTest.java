package evaluator.controller;

import evaluator.exception.NotAbleToCreateStatisticsException;
import evaluator.exception.NotAbleToCreateTestException;
import evaluator.model.Intrebare;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class CreateTestTest {

    private  String oIntrebare = "C:\\Facultate\\VVSS\\src\\src\\main\\java\\evaluator\\main\\intrebari.txt";
    private  String treiIntrebariLaFel = "C:\\Facultate\\VVSS\\src\\src\\main\\java\\evaluator\\main\\intrebari3.txt";
    private  String treiIntrebari = "C:\\Facultate\\VVSS\\src\\src\\main\\java\\evaluator\\main\\intrebari3ok.txt";
    private  String cinciIntrebariAcelasiDomeniu = "C:\\Facultate\\VVSS\\src\\src\\main\\java\\evaluator\\main\\intrebari5acDomeniu.txt";
    private  String cinciIntrebariok = "C:\\Facultate\\VVSS\\src\\src\\main\\java\\evaluator\\main\\intrebari5.txt";
    @Test
    public void BVA_invalid1() {
       AppController controller = new AppController(oIntrebare);
       try{
           controller.createNewTest();
           assert(false);
       }
       catch (NotAbleToCreateTestException e) {
          //e.printStackTrace();
       } catch (NotAbleToCreateStatisticsException e) {
           //e.printStackTrace();
           assert(false);
       }
    }


   @Test
    public void BVA_invalid2() {
        AppController controller = new AppController(treiIntrebariLaFel);
        try{
            controller.createNewTest();
            assert(false);
        }
        catch (NotAbleToCreateTestException e) {
            //e.printStackTrace();
        } catch (NotAbleToCreateStatisticsException e) {
            //e.printStackTrace();
            assert(false);
        }
    }

    @Test
    public void BVA_invalid13() {
        AppController controller = new AppController(cinciIntrebariAcelasiDomeniu);
        try{
            controller.createNewTest();
            assert(false);
        }
        catch (NotAbleToCreateTestException e) {
            //e.printStackTrace();
        } catch (NotAbleToCreateStatisticsException e) {
            //e.printStackTrace();
            assert(false);
        }
    }


    @Test
    public void BVA_invalid14() {
        AppController controller = new AppController(treiIntrebari);
        try{
            controller.createNewTest();
            assert (false);
        }
        catch (NotAbleToCreateTestException e) {
            //e.printStackTrace();
        } catch (NotAbleToCreateStatisticsException e) {
            //e.printStackTrace();
            assert(false);
        }
    }


    @Test
    public void ECP_valid1() {
        AppController controller = new AppController(cinciIntrebariok);
        evaluator.model.Test test = new evaluator.model.Test();
        try {
             test = controller.createNewTest();
            assert (test.getIntrebari().size() == 5);

        }
        catch (NotAbleToCreateTestException e) {
           e.printStackTrace();
            assert (false);
        } catch (NotAbleToCreateStatisticsException e) {
            //e.printStackTrace();
            assert(false);
        }

        List<Intrebare> intrebari = test.getIntrebari();
        for (int i = 0; i < intrebari.size(); i++) {
            for (int j = 0; j < intrebari.size(); j++) {
                if (intrebari.get(i) == intrebari.get(j) && i != j)
                    assert (false);
                if (intrebari.get(i).getDomeniu() == intrebari.get(j).getDomeniu() && i != j)
                    assert (false);
                {
                }
            }
        }
    }

    }
