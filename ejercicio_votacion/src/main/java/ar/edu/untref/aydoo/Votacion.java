package ar.edu.untref.aydoo;

import java.util.*;

public class Votacion {

    private List<Voto> votos;

    public Votacion(){
        this.votos = new LinkedList<Voto>();
    }

    public void votar(Voto voto) {
        this.votos.add(voto);
    }

    public Candidato calcularCandidatoGanadorNacional() {

        Candidato ganador = null;
        Integer cantidadVotos = -1;

        Map<Candidato,Integer> votoPorCandidato = this.getTablaResultados();

        Iterator it = votoPorCandidato.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();

            if((Integer)e.getValue()>cantidadVotos.intValue()){
                cantidadVotos = (Integer) e.getValue();
                ganador = (Candidato) e.getKey();
            }

        }

        return ganador;
    }

    public Partido calcularPartidoGanadorEnProvincia(Provincia provincia) {

        Partido ganador = null;
        Integer cantidadVotos = -1;

        Map<Partido,Integer> votoPorCandidato = this.getTablaResultadosPorProvincia(provincia);

        Iterator it = votoPorCandidato.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();

            if((Integer)e.getValue()>cantidadVotos.intValue()){
                cantidadVotos = (Integer) e.getValue();
                ganador = (Partido) e.getKey();
            }

        }
        return ganador;

    }

    public int getCantidadVotos() {
        return this.votos.size();
    }

    /**
     * devuelve un hashmap con <Candidato,cantidadVotos>
     * */
    private HashMap<Candidato,Integer> getTablaResultados(){

        HashMap<Candidato,Integer> votoPorCandidato = new HashMap<>();

        for (Voto voto: this.votos) {
            if(!votoPorCandidato.containsKey(voto.getFormula().getCandidato())){
                votoPorCandidato.put(voto.getFormula().getCandidato(),1);
            }else{
                int votosActuales = votoPorCandidato.get(voto.getFormula().getCandidato()) + 1;
                votoPorCandidato.put(voto.getFormula().getCandidato(),votosActuales);
            }
        }

        return votoPorCandidato;
    }

    /**
     * devuelve un hashmap con <Partido,cantidadVotos> filtrando por el parametro provincia
     * */
    private HashMap<Partido,Integer> getTablaResultadosPorProvincia(Provincia provincia){

        HashMap<Partido,Integer> votoPorPartido = new HashMap<>();

        for (Voto voto: this.votos) {

            if(voto.getProvincia().getNombre().equals(provincia.getNombre())){

                if(!votoPorPartido.containsKey(voto.getFormula().getPartido())){
                    votoPorPartido.put(voto.getFormula().getPartido(),1);
                }else{
                    int votosActuales = votoPorPartido.get(voto.getFormula().getPartido()) + 1;
                    votoPorPartido.put(voto.getFormula().getPartido(),votosActuales);
                }
            }

        }

        return votoPorPartido;
    }

}
