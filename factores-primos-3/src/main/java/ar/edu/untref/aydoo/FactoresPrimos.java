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
        this.formateador = new Formateador();
        this.ordenadorDeArray = new OrdenadorDeArray();
        this.orden = "--sort=asc";
    }

    public void run(final String[] args) throws Exception {

        try {

            int numeroRecibido = Integer.parseInt(args[0]);
            formato = args[1];

            procesarParametrosOpcionales(args);

            respuesta = calculador.calcularNumerosPrimos(numeroRecibido);

            respuestaOrdenada =  this.ordenadorDeArray.sortArray(orden, respuesta);

            String aMostrarEnConsola = formateador.formatearArrayNumeros(respuestaOrdenada,formato);

            if (this.escrituraArchivoRequerida) {
                this.formateador.writeToFile(respuestaOrdenada, formato,nombreArchivo, numeroRecibido);
            }

            imprimirEnConsola(numeroRecibido, aMostrarEnConsola);

        } catch (Exception e) {
            throw e;
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

}
