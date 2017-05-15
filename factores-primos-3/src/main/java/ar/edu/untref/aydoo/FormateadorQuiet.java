package ar.edu.untref.aydoo;

class FormateadorQuiet extends Formateador{

    public FormateadorQuiet(){
        super();
    }

    @Override
    public String formatearArrayNumeros(Integer[] array) throws Exception {

        this.builder.setLength(0);

        for (int i = 0; i < array.length; i++) {
            this.builder.append(System.lineSeparator() + array[i]);
        }

        return this.builder.toString();
    }

    @Override
    public void writeToFile(Integer[] array, String formato, String fileName, int recieviedNumber) {

        this.builder.setLength(0);

        for (int i = 0; i < array.length; i++) {
            builder.append(System.lineSeparator() + array[i]);
        }

        super.escribirArchivo(fileName,recieviedNumber, builder);

    }

}
