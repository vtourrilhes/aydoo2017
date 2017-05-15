package ar.edu.untref.aydoo;

public class FactoresPrimos {

    private OrdenadorDeArray ordenadorDeArray;
    private Calculador calculador;
    private Formateador formateador;
    private Integer[] respuesta;
    private Integer[] respuestaOrdenada;
    private boolean escrituraArchivoRequerida;
    private String nombreArchivo;
    private String orden;
    private String formato;

    public FactoresPrimos() {
        this.calculador = new Calculador();
        this.ordenadorDeArray = new OrdenadorDeArray();
        this.orden = "--sort=asc";
    }

    public void run(final String[] args) throws Exception {

        try {

            int numeroRecibido = Integer.parseInt(args[0]);
            formato = this.parsearFormato(args[1]);

            crearFormatter(formato);

            try {
                checkErroresFormato(formato);
            }catch(Exception e){
                throw e;
            }
            procesarParametrosOpcionales(args);

            respuesta = calculador.calcularNumerosPrimos(numeroRecibido);

            this.ordenarArray(respuesta);

            respuestaOrdenada =  this.ordenarArray(respuesta);

            String aMostrarEnConsola = formateador.formatearArrayNumeros(respuestaOrdenada);

            if (this.escrituraArchivoRequerida) {
                this.formateador.writeToFile(respuestaOrdenada, formato,nombreArchivo, numeroRecibido);
            }

            imprimirEnConsola(numeroRecibido, aMostrarEnConsola);

        } catch (Exception e) {
            throw e;
        }

    }

    private Integer[] ordenarArray(Integer[] respuesta) {

        this.orden.toLowerCase();

        if (orden.contains("asc")) {
            respuesta = this.ordenadorDeArray.ordenarArray(respuesta);
        } else if (orden.contains("des")) {
            respuesta =  this.ordenadorDeArray.ordenarArrayDescendente(respuesta);

        }

        return respuesta;

    }

    private void crearFormatter(String formato) {

        if(formato.equals("pretty")){
            this.formateador = new FormateadorPretty();
        }if(formato.equals("quiet")){
            this.formateador = new FormateadorQuiet();
        }

    }

    private void checkErroresFormato(String formato) throws Exception {
        if(! formato.equals("pretty") && !formato.equals("quiet")){
                throw new Exception("Formato no aceptado. "
                        + "Las opciones posibles son: pretty o quiet.");
        }
    }

    private void procesarParametrosOpcionales(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].contains("--sort=")) {
                this.orden = args[i];
            }
            if (args[i].contains("--output-file=")) {
                this.nombreArchivo = args[i].replace("--output-file=", "");
                this.escrituraArchivoRequerida =  true;
            }
        }
    }

    private void imprimirEnConsola(int numeroRecibido, String aMostrarEnConsola) {
        System.out.print("Factores primos " + numeroRecibido + ": ");
        System.out.print(aMostrarEnConsola);
    }

    private String parsearFormato(final String formato) {

        //si el formato está vacio, devuelvo pretty
        if (formato.equals("--format=")) {
            return "pretty";
        }

        formato.toLowerCase(); // lo transformo todoo a minuscula

        return formato.substring(9);
    }

}
