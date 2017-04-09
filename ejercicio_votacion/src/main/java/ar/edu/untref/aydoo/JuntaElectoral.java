package ar.edu.untref.aydoo;

import java.util.*;

public class JuntaElectoral {

    private List<Voto> votos;

    public JuntaElectoral(){
        this.votos = new LinkedList<>();
    }

    public void votar(Voto voto) {
        this.votos.add(voto);
    }

    public Candidato calcularCandidatoGanadorNacional() {

        Candidato ganador = null;
        Integer cantidadVotos = -1;

        Map<Candidato,Integer> votoPorCandidato = this.getTablaVotosPorCandidato();

        Iterator it = votoPorCandidato.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry par = (Map.Entry)it.next();

            if((Integer)par.getValue()>cantidadVotos.intValue()){
                cantidadVotos = (Integer) par.getValue();
                ganador = (Candidato) par.getKey();
            }

        }

        return ganador;
    }

    public Partido calcularPartidoGanadorEnProvincia(Provincia provincia) {

        Partido ganador = null;
        Integer cantidadVotos = -1;

        Map<Partido,Integer> votoPorPartido = this.getTablaResultadosPorProvincia(provincia);

        Iterator it = votoPorPartido.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry par = (Map.Entry)it.next();

            if((Integer)par.getValue()>cantidadVotos.intValue()){
                cantidadVotos = (Integer) par.getValue();
                ganador = (Partido) par.getKey();
            }

        }
        return ganador;

    }

    public int getCantidadVotos() {
        return this.votos.size();
    }

    /**
     * @return devuelve un hashmap con <Candidato,cantidadVotos>
     * */
    private HashMap<Candidato,Integer> getTablaVotosPorCandidato(){

        HashMap<Candidato,Integer> votoPorCandidato = new HashMap<>();

        for (Voto voto: this.votos) {
            if(!votoPorCandidato.containsKey(voto.getCandidato())){
                votoPorCandidato.put(voto.getCandidato(),1);
            }else{
                int votosActuales = votoPorCandidato.get(voto.getCandidato()) + 1;
                votoPorCandidato.put(voto.getCandidato(),votosActuales);
            }
        }

        return votoPorCandidato;
    }

    /**
     * @return  devuelve un hashmap con <Partido,cantidadVotos> filtrando por el parametro provincia
     * */
    private HashMap<Partido,Integer> getTablaResultadosPorProvincia(Provincia provincia){

        HashMap<Partido,Integer> votoPorPartido = new HashMap<>();

        for (Voto voto: this.votos) {

            if(voto.getProvincia().equals(provincia)){

                if(!votoPorPartido.containsKey(voto.getCandidato().getPartido())){
                    votoPorPartido.put(voto.getCandidato().getPartido(),1);
                }else{
                    int votosActuales = votoPorPartido.get(voto.getCandidato().getPartido()) + 1;
                    votoPorPartido.put(voto.getCandidato().getPartido(),votosActuales);
                }
            }

        }

        return votoPorPartido;
    }

}
