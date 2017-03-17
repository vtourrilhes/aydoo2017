class FactoresPrimos
{
    public static void main ( String [] arguments )
    {
       	
	int numero = Integer.parseInt(arguments[0]);	
	System.out.print("Factores primos de "+numero+": ");	

	while(numero!=1){
	    
            int respuesta=2;
	    
	    while(numero%respuesta!=0){
	        respuesta++;
	    }
		
            System.out.print(respuesta+" ");
            
	
	    numero = numero/respuesta;	
	}

	System.out.print("\n");	

	
    }
    

}
