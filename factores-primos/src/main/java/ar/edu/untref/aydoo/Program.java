package ar.edu.untref.aydoo;

public class Program{
    public static final void main(String arg[]){

    	int numero = Integer.parseInt(arg[0]);	
	   System.out.print("Factores primos de "+numero+": ");	

		while(numero!=1){
	    
	   	 int respuesta = getMinimoFactorPrimo(numero);
		
   	    System.out.print(respuesta+" ");
       
		    numero = numero/respuesta;	
		} 

		System.out.print("\n");	
    }
    
    public static int getMinimoFactorPrimo(int numero){
    
    	if(numero==1) return numero;
    	
       int respuesta=2;
	    
	    while(numero%respuesta!=0){
	        respuesta++;
	    }
	
		return respuesta;
    
    }
    
    
}
