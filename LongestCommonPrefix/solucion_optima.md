# Solución óptima: Longest Common Prefix

## Patrón Algorítmico
Escaneo Horizontal (Horizontal Scanning).

## Claves de la Resolución
- En lugar de evaluar carácter por carácter en todas las cadenas a la vez (escaneo vertical), resulta más eficiente asumir que la primera cadena completa es el prefijo común.
- Iteramos sobre el resto de las cadenas. Si la cadena actual no comienza con el prefijo asumido, reducimos el prefijo eliminando su último carácter hasta que haya coincidencia.
- Si en algún momento el prefijo se reduce a una cadena vacía, se retorna inmediatamente, ya que no existe ningún prefijo común posible, evitando iteraciones innecesarias sobre el resto del array.

## Consideraciones de Optimización y Lenguaje
- Uso eficiente de la API nativa: El método `String.indexOf(String str)` de Java está altamente optimizado. Utilizar `strs[i].indexOf(prefix) != 0` verifica de forma rápida si la cadena empieza por el prefijo iterado.
- Evitar estructuras adicionales: Al recortar un `String` nativo mediante `substring()`, se elimina la necesidad de instanciar un objeto auxiliar como `StringBuilder` y gestionar la anexión iterativa de caracteres.

## Análisis de Complejidad Óptima
- Complejidad Temporal: O(S). Donde S es la suma total de los caracteres de todas las cadenas. En el peor de los casos, las comparaciones realizarán tantas operaciones como caracteres existan en la entrada.
- Complejidad Espacial: O(1). Únicamente se gestionan punteros de memoria subyacentes mediante el método `substring` de Java sobre las cadenas ya existentes, sin requerir asignación de memoria adicional que escale con el tamaño de la entrada.

## Código Óptimo
```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        String prefix = strs[0];
        
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        
        return prefix;
    }
}
