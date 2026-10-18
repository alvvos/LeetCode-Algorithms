# Solución óptima: Plus One

## Patrón Algorítmico
Matemáticas y manipulación de arrays (recorrido inverso).

## Claves de la Resolución
- El problema simula una suma manual. Se debe comenzar a sumar desde el dígito menos significativo (el final del array) hacia el más significativo (el principio).
- Si al iterar se encuentra un dígito menor a 9, simplemente se incrementa en 1 y el algoritmo termina prematuramente retornando el array. Esto es seguro porque no se generará ningún acarreo (carry) hacia la izquierda.
- Si el dígito es un 9, la suma de 1 produce un 10. Se escribe un 0 en esa posición y el bucle avanza al siguiente dígito hacia la izquierda para simular el acarreo.
- Si el bucle finaliza por completo, significa que todos los dígitos eran 9 (ejemplo: 99, 999). En este escenario, el número aumenta su longitud. La solución requiere asignar un nuevo array de tamaño `digitsSize + 1`, donde el primer valor será 1 y todos los demás serán 0 (ejemplo: 100, 1000).

## Consideraciones de Optimización y Lenguaje
- Legibilidad frente a aritmética de punteros: El uso de la notación de corchetes `digits[i]` es internamente equivalente a la aritmética de punteros `*(digits + i)` en C, pero resulta mucho más limpio y fácil de mantener.
- Inicialización con `calloc`: En el caso extremo donde todos los números son 9, la función `calloc` de C resulta clave, ya que asigna la memoria y simultáneamente inicializa todos los valores a 0 de forma nativa. Solo es necesario establecer el primer índice `newDigits[0] = 1`.
- Retorno anticipado: La estructura de control no necesita cláusulas `else` complejas, ya que la sentencia `return` dentro del bloque condicional `if (digits[i] < 9)` rompe el flujo de ejecución en cuanto el trabajo está terminado, logrando una complejidad de tiempo constante O(1) en el mejor de los casos (ej. 123 -> 124).

## Análisis de Complejidad Óptima
- Complejidad Temporal: O(N). Donde N es la cantidad de elementos en el array `digits`. En el peor de los casos (por ejemplo, [9, 9, 9]), el algoritmo itera a través de todos los elementos una única vez.
- Complejidad Espacial: O(1) auxiliar en el caso promedio, ya que las modificaciones se realizan in-place sobre el array recibido en los argumentos. O(N) en el peor de los casos estrictos, debido a la necesidad de reservar memoria con `calloc` para un nuevo array de tamaño N + 1.

## Código Óptimo
```c
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* plusOne(int* digits, int digitsSize, int* returnSize) {
    for (int i = digitsSize - 1; i >= 0; i--) {
        if (digits[i] < 9) {
            digits[i]++;
            *returnSize = digitsSize;
            return digits;
        }
        digits[i] = 0;
    }
    
    int* newDigits = (int*)calloc(digitsSize + 1, sizeof(int));
    newDigits[0] = 1;
    *returnSize = digitsSize + 1;
    
    return newDigits;
}
