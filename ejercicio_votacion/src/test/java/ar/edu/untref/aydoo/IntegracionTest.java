package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;

public class IntegracionTest {

    @Test
    public void ganadorNacionalUnicaFormulaTest(){

        JuntaElectoral juntaElectoral = new JuntaElectoral();
        Partido fpv = new Partido("Frente para la Victoria");
        Candidato scioli = new Candidato("Scioli");
        Formula formula = new Formula(fpv,scioli);
        fpv.agregarFormula(formula);
        Provincia salta = new Provincia("Salta");
        Voto voto = new Voto(formula,salta);

        juntaElectoral.votar(voto);

        Assert.assertEquals(scioli.getNombre(), juntaElectoral.calcularCandidatoGanadorNacional().getNombre());

    }

    @Test
    public void ganadorNacionalDosFormulas7a2votosTest(){

        JuntaElectoral juntaElectoral = new JuntaElectoral();
        Partido fpv = new Partido("Frente para la Victoria");
        Partido cambiemos = new Partido("Cambiemos");
        Candidato scioli = new Candidato("Scioli");
        Candidato macri = new Candidato("Macri");
        Formula formula = new Formula(fpv,scioli);
        Formula formula2 = new Formula(cambiemos,macri);
        fpv.agregarFormula(formula);
        cambiemos.agregarFormula(formula2);
        Provincia salta = new Provincia("Salta");
        Voto voto = new Voto(formula,salta);
        Voto voto3 = new Voto(formula,salta);
        Voto voto4 = new Voto(formula,salta);
        Voto voto5 = new Voto(formula,salta);
        Voto voto6 = new Voto(formula,salta);
        Voto voto1 = new Voto(formula2,salta);
        Voto voto2 = new Voto(formula2,salta);
        juntaElectoral.votar(voto);
        juntaElectoral.votar(voto1);
        juntaElectoral.votar(voto2);
        juntaElectoral.votar(voto3);
        juntaElectoral.votar(voto4);
        juntaElectoral.votar(voto5);
        juntaElectoral.votar(voto6);

        Assert.assertEquals(scioli.getNombre(), juntaElectoral.calcularCandidatoGanadorNacional().getNombre());

    }

    @Test
    public void ganadorProvinciaUnicoVotoTest(){

        JuntaElectoral juntaElectoral = new JuntaElectoral();
        Partido fpv = new Partido("Frente para la Victoria");
        Candidato scioli = new Candidato("Scioli");
        Formula formula = new Formula(fpv,scioli);
        fpv.agregarFormula(formula);
        Provincia salta = new Provincia("Salta");
        Voto voto = new Voto(formula,salta);

        juntaElectoral.votar(voto);

        Assert.assertEquals(fpv, juntaElectoral.calcularPartidoGanadorEnProvincia(salta));

    }

    @Test
    public void ganadorProvinciaJujuyMultiplesVotosDiferentesProvinciasTest(){

        JuntaElectoral juntaElectoral = new JuntaElectoral();
        Partido fpv = new Partido("Frente para la Victoria");
        Partido cambiemos = new Partido("Cambiemos");
        Candidato scioli = new Candidato("Scioli");
        Candidato macri = new Candidato("Macri");
        Formula formula = new Formula(fpv,scioli);
        Formula formula2 = new Formula(cambiemos,macri);
        fpv.agregarFormula(formula);
        cambiemos.agregarFormula(formula2);
        Provincia salta = new Provincia("Salta");
        Provincia jujuy = new Provincia("Jujuy");
        Provincia tucuman=new Provincia("tucuman");
        Voto voto = new Voto(formula,jujuy);
        Voto voto1 = new Voto(formula2,jujuy);
        Voto voto2 = new Voto(formula2,tucuman);
        Voto voto3 = new Voto(formula2,jujuy);
        Voto voto4 = new Voto(formula2,jujuy);
        Voto voto5 = new Voto(formula2,salta);
        Voto voto6 = new Voto(formula,salta);
        juntaElectoral.votar(voto);
        juntaElectoral.votar(voto1);
        juntaElectoral.votar(voto2);
        juntaElectoral.votar(voto3);
        juntaElectoral.votar(voto4);
        juntaElectoral.votar(voto5);
        juntaElectoral.votar(voto6);

        Assert.assertEquals(cambiemos, juntaElectoral.calcularPartidoGanadorEnProvincia(jujuy));

    }

    @Test
    public void testEmisionVotoTest(){

        JuntaElectoral juntaElectoral = new JuntaElectoral();
        Partido fpv = new Partido("Frente para la Victoria");
        Candidato scioli = new Candidato("Scioli");
        Formula formula = new Formula(fpv,scioli);
        fpv.agregarFormula(formula);
        Provincia salta = new Provincia("Salta");
        Voto voto = new Voto(formula,salta);

        juntaElectoral.votar(voto);

        Assert.assertEquals(1, juntaElectoral.getCantidadVotos());

    }

}
