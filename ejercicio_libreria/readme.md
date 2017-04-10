Correcciones: 
    
    - se modifico el modelo:
        Las relaciones entre clases ya se reflejan con el codigo
        
        Producto se hizo una clase abstracta y se quitaron los if else y los instanceof, ahora se usa polimorfismo para realizar 
        los calculos de precios
        
        Ahora cada clase se ocupa de calcular su propio precio y lo unico que hace la libreria al pedir el monto es iterar sumando los 
        precios de cada proucto en el mes especificado
        
        Una revista  y un diario ahora tienen una suscripcion que ahora es una clase (y esta suscripcion tiene un Tipo de suscripcion)  
        y una periodicidad
       
   
    - Se agregaron Test de la clase Compra y mas test en la clase IntegracionTest
    
Aclaraciones: 
        
        -Realice nuevamente todo en un unico commit, ya que no queria commitear cosas que rompian (tuve que modificar el modelo y despues
        reflejar eso en el codigo, y recien ahi hice funcionar los tests y cree nuevos tests, el codigo anterior a la correccion
        si lo habia realizado usando TDD aunque no se vio reflejado en los commits)
        