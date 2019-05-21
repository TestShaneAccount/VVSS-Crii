package evaluator.controller;

import evaluator.exception.NotAbleToCreateStatisticsException;
import evaluator.exception.NotAbleToCreateTestException;
import evaluator.model.Statistica;
import org.junit.Test;

import static org.junit.Assert.*;

public class Top_Down {

    private  String oIntrebare = "C:\\Facultate\\VVSS\\src\\src\\main\\java\\evaluator\\main\\intrebari.txt";
    private  String zeroIntrebari = "C:\\Facultate\\VVSS\\src\\src\\main\\java\\evaluator\\main\\zeroIntrebari.txt";
    private  String treiIntrebariLaFel = "C:\\Facultate\\VVSS\\src\\src\\main\\java\\evaluator\\main\\intrebari3.txt";
    private  String treiIntrebari = "C:\\Facultate\\VVSS\\src\\src\\main\\java\\evaluator\\main\\intrebari3ok.txt";
    private  String cinciIntrebariAcelasiDomeniu = "C:\\Facultate\\VVSS\\src\\src\\main\\java\\evaluator\\main\\intrebari5acDomeniu.txt";
    private  String cinciIntrebariok = "C:\\Facultate\\VVSS\\src\\src\\main\\java\\evaluator\\main\\intrebari5.txt";



    @Test
    public void Top_Down() {
            AppController controller = new AppController(cinciIntrebariok);

        try {
            controller.createNewTest();
            assert (true);
        } catch (NotAbleToCreateTestException e) {
            assert (false);
        } catch (NotAbleToCreateStatisticsException e) {
            assert(false);
        }

         controller = new AppController(oIntrebare);
        try {
           assert ( controller.Getall().size() == 1);
            controller.createNewTest();
            assert (false);
        } catch (NotAbleToCreateTestException e) {
            assert (true);
        } catch (NotAbleToCreateStatisticsException e) {
            assert(false);
        }

        controller = new AppController(cinciIntrebariok);

        try {
            assert ( controller.Getall().size() == 5);
            controller.createNewTest();
            assert (true);
        } catch (NotAbleToCreateTestException e) {
            assert (false);
        } catch (NotAbleToCreateStatisticsException e) {
            assert(false);
        }

    }

    @Test
    public void loadIntrebariFromFile() {

        AppController controller = new AppController(cinciIntrebariok);
        controller.loadIntrebariFromFile(cinciIntrebariok);
        assert (controller.Getall().size() == 5);
    }

    @Test
    public void getStatistica() {
        AppController controller = new AppController(zeroIntrebari);
        try {
            Statistica s = controller.getStatistica();
            assert (false);

        } catch (NotAbleToCreateStatisticsException e) {
            assert (true);
        }

         controller = new AppController(cinciIntrebariok);
        try {
            Statistica s = controller.getStatistica();
            assert (s.getIntrebariDomenii().size() == 5);
            assert(s.getIntrebariDomenii().get("weekend") == 1 );
            assert(s.getIntrebariDomenii().get("test") == 1 );
            assert(s.getIntrebariDomenii().get("blabla") == 1 );
            assert(s.getIntrebariDomenii().get("trtrtr") == 1 );
            assert(s.getIntrebariDomenii().get("ggggg") == 1 );

        } catch (NotAbleToCreateStatisticsException e) {
            assert (false);
        }
    }
}