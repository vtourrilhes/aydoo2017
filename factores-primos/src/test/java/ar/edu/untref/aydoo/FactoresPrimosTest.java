package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;


public class FactoresPrimosTest 
{
	
	private Program program = new Program();       
      	
	
   @Test
   public void test120(){
				       
 		
      int numero = 120;
      Assert.assertEquals(2,program.getMinimoFactorPrimo(numero));
      numero = numero/program.getMinimoFactorPrimo(numero);//numero = 60
      Assert.assertEquals(2,program.getMinimoFactorPrimo(numero));
      numero = numero/program.getMinimoFactorPrimo(numero);//numero = 30
      Assert.assertEquals(2,program.getMinimoFactorPrimo(numero));
      numero = numero/program.getMinimoFactorPrimo(numero);//numero = 15
      Assert.assertEquals(3,program.getMinimoFactorPrimo(numero));
      numero = numero/program.getMinimoFactorPrimo(numero);//numero = 5
      Assert.assertEquals(5,program.getMinimoFactorPrimo(numero));
      
      
   }
   
   @Test
   public void test3(){
      int numero = 3;
      Assert.assertEquals(3,program.getMinimoFactorPrimo(numero));
      numero = numero/program.getMinimoFactorPrimo(numero);//numero = 1
      Assert.assertEquals(1,program.getMinimoFactorPrimo(numero));
      numero = numero/program.getMinimoFactorPrimo(numero);//numero = 1
      
   }
   
   @Test
   public void test90(){
      int numero = 90;
      Assert.assertEquals(2,program.getMinimoFactorPrimo(numero));
      numero = numero/program.getMinimoFactorPrimo(numero);//numero = 45
      Assert.assertEquals(3,program.getMinimoFactorPrimo(numero));
      numero = numero/program.getMinimoFactorPrimo(numero);//numero = 15
      Assert.assertEquals(3,program.getMinimoFactorPrimo(numero));
      numero = numero/program.getMinimoFactorPrimo(numero);//numero = 5
      Assert.assertEquals(5,program.getMinimoFactorPrimo(numero));
      
   }
   
   @Test
   public void test1 (){
      int numero = 1;
      Assert.assertEquals(1,program.getMinimoFactorPrimo(numero));      
   } 
     
}
