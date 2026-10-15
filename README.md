# Algoritmia y estructuras de datos

Este repositorio es un registro exhaustivo de mi evolución en la resolución de problemas algorítmicos. Su propósito no es servir como un simple archivo de código, sino documentar de forma estricta mi proceso cognitivo, la identificación de patrones de diseño algorítmico y el análisis de la complejidad computacional.

## Metodología de estudio

Para garantizar la asimilación real de los conceptos, cada problema se aborda en dos fases claramente diferenciadas. Esta separación me permite comparar mi intuición inicial frente a la solución de máxima eficiencia.

### 1. Fase de exploración y desarrollo inicial
El primer acercamiento al problema lo realizo sin asistencia, priorizando la obtención de una solución funcional. En esta fase documento:
- **Razonamiento inicial:** La lógica detrás de la primera implementación, aunque sea mediante fuerza bruta.
- **Bloqueos técnicos:** Casos límite no contemplados de inicio (ej. excepciones por referencias nulas o índices fuera de rango).
- **Análisis de complejidad base:** Evaluación asintótica de tiempo y espacio de mi propia solución.

### 2. Fase de optimización y refactorización
Una vez completado el problema, analizo la solución más eficiente posible. Esta fase sirve como base de conocimiento técnico para interiorizar conceptos avanzados:
- **Patrón algorítmico subyacente:** Identificación de la técnica clave (ej. escaneo horizontal, two pointers, programación dinámica).
- **Optimizaciones a nivel de lenguaje:** Uso eficiente de las APIs nativas (como los métodos optimizados de `String` en Java) y gestión de memoria.
- **Complejidad óptima:** Análisis del rendimiento ideal (Big O) justificado matemáticamente.

## Estructura del repositorio

Cada desafío se aísla en un directorio propio que sigue una nomenclatura secuencial. Dentro de cada directorio, el contenido se divide en los ficheros de código y sus respectivos documentos de análisis.

```text
algoritmos/
├── 001-longest-common-prefix/
│   ├── MiSolucion.java
│   ├── mi_solucion.md
│   ├── SolucionOptima.java
│   └── solucion_optima.md
└── 002-siguiente-problema/
    └── ...
