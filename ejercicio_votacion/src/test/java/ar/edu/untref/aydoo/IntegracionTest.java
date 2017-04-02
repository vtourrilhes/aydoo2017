package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;

public class IntegracionTest {

    @Test
    public void ganadorNacionalUnicaFormulaTest(){

        Votacion votacion = new Votacion();
        Partido fpv = new Partido("Frente para la Victoria");
        Candidato scioli = new Candidato("Scioli");
        Formula formula = new Formula(fpv,scioli);
        fpv.agregarFormula(formula);
        Provincia salta = new Provincia("Salta");
        Voto voto = new Voto(formula,salta);

        votacion.votar(voto);

        Assert.assertEquals(scioli.getNombre(),votacion.calcularCandidatoGanadorNacional().getNombre());

    }

    @Test
    public void ganadorNacionalDosFormulas7a2votosTest(){

        Votacion votacion = new Votacion();
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
        votacion.votar(voto);
        votacion.votar(voto1);
        votacion.votar(voto2);
        votacion.votar(voto3);
        votacion.votar(voto4);
        votacion.votar(voto5);
        votacion.votar(voto6);

        Assert.assertEquals(scioli.getNombre(),votacion.calcularCandidatoGanadorNacional().getNombre());

    }

    @Test
    public void ganadorProvinciaUnicoVotoTest(){

        Votacion votacion = new Votacion();
        Partido fpv = new Partido("Frente para la Victoria");
        Candidato scioli = new Candidato("Scioli");
        Formula formula = new Formula(fpv,scioli);
        fpv.agregarFormula(formula);
        Provincia salta = new Provincia("Salta");
        Voto voto = new Voto(formula,salta);

        votacion.votar(voto);

        Assert.assertEquals(fpv,votacion.calcularPartidoGanadorEnProvincia(salta));

    }

    @Test
    public void ganadorProvinciaJujuyMultiplesVotosDiferentesProvinciasTest(){

        Votacion votacion = new Votacion();
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
        votacion.votar(voto);
        votacion.votar(voto1);
        votacion.votar(voto2);
        votacion.votar(voto3);
        votacion.votar(voto4);
        votacion.votar(voto5);
        votacion.votar(voto6);

        Assert.assertEquals(cambiemos,votacion.calcularPartidoGanadorEnProvincia(jujuy));

    }

    @Test
    public void testEmisionVotoTest(){

        Votacion votacion = new Votacion();
        Partido fpv = new Partido("Frente para la Victoria");
        Candidato scioli = new Candidato("Scioli");
        Formula formula = new Formula(fpv,scioli);
        fpv.agregarFormula(formula);
        Provincia salta = new Provincia("Salta");
        Voto voto = new Voto(formula,salta);

        votacion.votar(voto);

        Assert.assertEquals(1,votacion.getCantidadVotos());

    }

}
