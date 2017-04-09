package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;

public class IntegracionTest {

    @Test
    public void ganadorNacionalUnicaFormulaTest(){

        JuntaElectoral juntaElectoral = new JuntaElectoral();
        Partido fpv = new Partido("Frente para la Victoria");
        Candidato scioli = new Candidato("Scioli",fpv);
        Provincia salta = new Provincia("Salta");
        Voto voto = new Voto(scioli,salta);

        juntaElectoral.votar(voto);

        Assert.assertEquals(scioli.getNombre(), juntaElectoral.calcularCandidatoGanadorNacional().getNombre());

    }

    @Test
    public void ganadorNacionalDosFormulas7a2votosTest(){

        JuntaElectoral juntaElectoral = new JuntaElectoral();
        Partido fpv = new Partido("Frente para la Victoria");
        Partido cambiemos = new Partido("Cambiemos");
        Candidato scioli = new Candidato("Scioli",fpv);
        Candidato macri = new Candidato("Macri",cambiemos);
        fpv.agregarCandidato(scioli);
        cambiemos.agregarCandidato(macri);
        Provincia salta = new Provincia("Salta");
        Voto voto = new Voto(scioli,salta);
        Voto voto3 = new Voto(scioli,salta);
        Voto voto4 = new Voto(scioli,salta);
        Voto voto5 = new Voto(scioli,salta);
        Voto voto6 = new Voto(scioli,salta);
        Voto voto1 = new Voto(macri,salta);
        Voto voto2 = new Voto(macri,salta);
        juntaElectoral.votar(voto);
        juntaElectoral.votar(voto1);
        juntaElectoral.votar(voto2);
        juntaElectoral.votar(voto3);
        juntaElectoral.votar(voto4);
        juntaElectoral.votar(voto5);
        juntaElectoral.votar(voto6);

        Assert.assertEquals(scioli, juntaElectoral.calcularCandidatoGanadorNacional());

    }

    @Test
    public void ganadorProvinciaUnicoVotoTest(){

        JuntaElectoral juntaElectoral = new JuntaElectoral();
        Partido fpv = new Partido("Frente para la Victoria");
        Candidato scioli = new Candidato("Scioli",fpv);
        fpv.agregarCandidato(scioli);
        Provincia salta = new Provincia("Salta");
        Voto voto = new Voto(scioli,salta);

        juntaElectoral.votar(voto);

        Assert.assertEquals(fpv, juntaElectoral.calcularPartidoGanadorEnProvincia(salta));

    }

    @Test
    public void ganadorProvinciaJujuyMultiplesVotosDiferentesProvinciasTest(){

        JuntaElectoral juntaElectoral = new JuntaElectoral();
        Partido fpv = new Partido("Frente para la Victoria");
        Partido cambiemos = new Partido("Cambiemos");
        Candidato scioli = new Candidato("Scioli",fpv);
        Candidato macri = new Candidato("Macri",cambiemos);
        fpv.agregarCandidato(scioli);
        cambiemos.agregarCandidato(macri);
        Provincia salta = new Provincia("Salta");
        Provincia jujuy = new Provincia("Jujuy");
        Provincia tucuman=new Provincia("tucuman");
        Voto voto = new Voto(scioli,jujuy);
        Voto voto1 = new Voto(macri,jujuy);
        Voto voto2 = new Voto(macri,tucuman);
        Voto voto3 = new Voto(macri,jujuy);
        Voto voto4 = new Voto(macri,jujuy);
        Voto voto5 = new Voto(macri,salta);
        Voto voto6 = new Voto(scioli,salta);
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
        Candidato scioli = new Candidato("Scioli",fpv);
        fpv.agregarCandidato(scioli);
        Provincia salta = new Provincia("Salta");
        Voto voto = new Voto(scioli,salta);

        juntaElectoral.votar(voto);

        Assert.assertEquals(1, juntaElectoral.getCantidadVotos());

    }

}
