package ar.edu.untref.aydoo;

public class Formatter {

    /**
     * @return Devuelve un String listo para imprimir dado el formato
     */

    public String formatArrayNumbers(Integer[] array, String format) throws Exception {

        String answer = "";
        StringBuilder builder = new StringBuilder(answer);

        String parsedFormat = this.parseFormat(format);

        switch (parsedFormat){
            case "pretty":
                for(int i=0;i<array.length;i++){
                    builder.append(array[i]+" ");
                }
                break;
            case "quiet":
                System.out.println();
                for(int i=array.length-1;i>=0;i--){
                    builder.append("\n"+array[i]);
                }
                break;
            default:
                throw new Exception("Formato no aceptado. Las opciones posibles son: pretty o quiet.");
        }

        return builder.toString();
    }

    private String parseFormat(String format) {

        //si el formato está vacio, devuelvo pretty
        if(format.equals("--format=")) return "pretty";

        format.toLowerCase(); // lo transformo todoo a minuscula
        return format.substring(9);
    }
}
