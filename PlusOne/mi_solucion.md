# LongestCommonPrefix

- Plataforma: [LeetCode]
- Dificultad: [Fácil]
- Tiempo invertido: [~1 hora]

## Enfoque Inicial
[Descripción técnica de la primera aproximación al problema. Justificación de la lógica empleada, la elección inicial de las estructuras de datos y el flujo de ejecución planeado.]
A pesar de su simplicidad, este problema me supuso una gran perdida de tiempo al comienzo, ya que salté de las listas a los enteros en un juego enrevesado de aritmética
con el fin de poder desmontar el número en su forma numérica real para luego sumarle una unidad y remontarlo en una nueva lista para devolver. Tras darme cuenta de que
ese camino no me llevaría a la solución opté por comenzar de nuevo y cambiar al lenguaje `C`.

## Dificultades y Bloqueos
- [Bloqueo 1: Descripción de la dificultad técnica encontrada. Ejemplo: problemas con el manejo de índices, condiciones de contorno o casos base complejos.]
Demasiado debugging para encontrar salidas no eficientes. Tras superar los testcase básicos, tuve que volver a empezar de cero en cuanto ví un error por 
overflow respecto a los 32 bits del entero auxiliar que estaba utilizando (testcase [9,8,7,6,5,4,3,2,1,0]). 
- [Bloqueo 2: Problemas de rendimiento, como Time Limit Exceeded (TLE) o Memory Limit Exceeded (MLE) al procesar inputs de gran tamaño.]
En `C` experimenté un TLE, reaprendí las funciones de asignación de memoria `malloc()`, `calloc()` y `realloc()` junto con el ciclo de vida sano de un puntero, aunque
en ese caso podíamos asumir que el caller invocaría al `free()` como es lógico.

## Errores Identificados
- [Error 1: Caso de prueba fallido y análisis del motivo.]
Los testcases que más me sorprendieron fueron el de [9,8,9], ya que no entendía la relevancia del puntero `*returnSize` y el de las listas grandes que podían
provocar overflow.
- [Error 2: Error conceptual, de sintaxis o uso ineficiente de las estructuras de control.]
`heap_buffer_overflow` al querer acceder a posiciones de memoria sin reservar, esto provoca comportamientos poco intuitivos.

## Análisis de Complejidad
- Complejidad Temporal: O(?) - [Justificación de la iteración y operaciones del código desarrollado.]
En el mejor de los casos O(1), cambiar el último número sumándole una unidad. El peor caso sería uno de solo nueves O(digitsSize).

- Complejidad Espacial: O(?) - [Justificación de la memoria adicional reservada en tiempo de ejecución.]
O(1) si solo se debe modificar el arreglo dado, O(digitsSize+1) si hay que abrir un nuevo hueco.

## Código
```c
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* plusOne(int* digits, int digitsSize, int* returnSize) {
    int i=digitsSize-1;
    if(*(digits+(digitsSize-1))!=9){
        *(digits+(digitsSize-1))+=1;
        *returnSize=digitsSize;
    } else {
        while(*(digits+i)==9){
            *(digits+i)=0;
            if(i==0){
                *returnSize=digitsSize+1;
                digits=calloc(digitsSize+1, sizeof(int));
                digits[0]=1;
                return digits;
            } else {
                i--;
            }
        }
        *returnSize=digitsSize; 
        *(digits+i)+=1;
    }
    return digits;
}
```

