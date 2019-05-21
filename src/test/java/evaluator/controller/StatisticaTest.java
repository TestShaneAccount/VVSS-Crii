package evaluator.controller;

import evaluator.exception.NotAbleToCreateStatisticsException;
import evaluator.model.Statistica;
import org.junit.Test;

import static org.junit.Assert.*;

public class StatisticaTest {

    private  String oIntrebare = "C:\\Facultate\\VVSS\\src\\src\\main\\java\\evaluator\\main\\intrebari.txt";
    private  String zeroIntrebari = "C:\\Facultate\\VVSS\\src\\src\\main\\java\\evaluator\\main\\zeroIntrebari.txt";
    private  String treiIntrebari = "C:\\Facultate\\VVSS\\src\\src\\main\\java\\evaluator\\main\\intrebari3ok.txt";
    private  String cinciIntrebariAcelasiDomeniu = "C:\\Facultate\\VVSS\\src\\src\\main\\java\\evaluator\\main\\intrebari5acDomeniu.txt";
    private  String cinciIntrebariok = "C:\\Facultate\\VVSS\\src\\src\\main\\java\\evaluator\\main\\intrebari5.txt";

    @Test
    public void getStatisticaValid() {
        AppController controller = new AppController(oIntrebare);
        try {
            Statistica s = controller.getStatistica();
            assert (s.getIntrebariDomenii().size() == 1);
            assert(s.getIntrebariDomenii().get("weekend") == 1 );

        } catch (NotAbleToCreateStatisticsException e) {
            assert (false);
        }

    }

    @Test
    public void getStatisticaInvalid(){
        AppController controller = new AppController(zeroIntrebari);
        try {
            Statistica s = controller.getStatistica();
            assert (false);

        } catch (NotAbleToCreateStatisticsException e) {
            assert (true);
        }
    }

    @Test
    public void getStatisticaValid2() {
        AppController controller = new AppController(cinciIntrebariok);
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