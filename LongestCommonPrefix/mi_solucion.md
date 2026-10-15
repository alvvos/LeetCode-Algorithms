# LongestCommonPrefix

- Plataforma: [LeetCode]
- Dificultad: [Fácil]
- Tiempo invertido: [45 minutos]

## Enfoque Inicial
[Descripción técnica de la primera aproximación al problema. Justificación de la lógica empleada, la elección inicial de las estructuras de datos y el flujo de ejecución planeado.]
De un primer vistazo supe que necesitaría una doble iteración, una por cada cadena y otra por cada letra, una de las ideas claves a la hora de resolver el problema para mi fue apoyarse en una cadena pivote. Es necesario comprobar antes de leer nada sí el array está vacio o si contiene cadenas vacias. Después la solución pasa por almacenar el caracter previo al actual
para poder llevar a cabo la comparativa secuencial a través de todas las cadenas iterando sobre cada posición. La clase StringBuilder ha sido clave en cuanto a los métodos de alto
nivel que ofrece para poder agilizar algunas instrucciones básicas como agregar carácteres o fusionar la lista en una sola cadena.

## Dificultades y Bloqueos
- [Bloqueo 1: Descripción de la dificultad técnica encontrada. Ejemplo: problemas con el manejo de índices, condiciones de contorno o casos base complejos.]
He fallado mucho al tratar de leer memoria no existente o registrada, el clásico IndexOutOfBoundsException, cuesta a veces acordarse de hacer las comprobaciones
necesarias para no recibir una excepción como está.
- [Bloqueo 2: Problemas de rendimiento, como Time Limit Exceeded (TLE) o Memory Limit Exceeded (MLE) al procesar inputs de gran tamaño.]
No en este caso, he sacado una latencia de 1ms, lo cual está muy bien a pesar de la cantidad de líneas que tiene el método propuesto.

## Errores Identificados
- [Error 1: Caso de prueba fallido y análisis del motivo.]
Los casos más complejos fueron en un primer momento ["",""] ya que no supe distinguir que se trataba de simplemente dos cadenas vacías. Tuve problemas también
con el caso ["ab", "a"] nuevamente por un problema de acceso a una posición de memoria que no existe.
- [Error 2: Error conceptual, de sintaxis o uso ineficiente de las estructuras de control.]
He reaprendido que los tipos nativos no pueden ser null, al menos en Java. En LeetCode al menos estoy teniendo problemas con la puerta lógica 'not'.

## Análisis de Complejidad
- Complejidad Temporal: O(?) - [Justificación de la iteración y operaciones del código desarrollado.]
La complejidad temporal es O(N x M) donde N es el número de carácteres de la cadena más corta mientras que M es el número de cadenas de 'strs', en el peor
de los casos todas las cadenas son iguales.

- Complejidad Espacial: O(?) - [Justificación de la memoria adicional reservada en tiempo de ejecución.]
Complejidad constante en los integers y char's definidos (O(1)), el crecimiento de la complejidad es lineal dependiendo de cuantos caracteres haya que 
almacenar en 'prefix', por tanto la respuesta a esta cuestión es O(M).

## Código
```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        int i=0, j=0;
        char c_prev=0, c_aux=0;
        if(strs[0].isEmpty() || !(strs.length>0)){
            return "";
        }
        while(j<strs[0].length()){
            c_prev=strs[0].charAt(j);
            for(i=0; i<strs.length; i++){
                if(j<strs[i].length()){
                    c_aux = strs[i].charAt(j);
                    if(c_aux!=c_prev){
                        return prefix.toString();
                    }
                    c_prev = c_aux;
                } else {
                    return prefix.toString();
                }
            }
            prefix.append(c_aux);
            j++;
        }  
        return prefix.toString(); 
    }
}
```

