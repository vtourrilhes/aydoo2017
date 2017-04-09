Correciones:

    -Se eliminaron archivos basura como Foo.test y la carpeta IT dentro de src
    
    -Se modificó el nombre de la clase Votación por JuntaElectoral ya que representa mejor la realidad
    
    -Se eliminó la clase Formula ya que no era relevante para el problema y solo causaba confusión en el modelo;
        *Ahora una JuntaElectoral tiene una lista de votos
        *Un voto tiene un candidato y una provincia
        *Un candidato tiene un partido asignado y a su vez un partido tiene una lista de candidatos (Esto último no me cierra
         mucho pero a mi parecer esta bien que el partido tenga conocimiento de sus candidatos por mas que en este momento
         no se use para nada)
    -Actualizado el modelo uml y los tres diagramas de secuencia con las correciones pedidas
    
    -Se corrigieron los warnings del proyecto

Dudas:

    -No se si se deben poner getters y setters en los diagramas de clases
    
    -No se si estan bien representadas las relaciones y por eso las aclare arriba en las correciones
    
    -Hice de vuelta los diagramas de secuencia, me resultan muy cargadosde ciclos  (En especial el de calcularPartidoGanadorEnProvincia 
     ya que modele todas las iteraciones) y me hace dudar un poco si estan bien hechos
