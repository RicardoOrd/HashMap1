# Implementación de HashMap (Tabla Hash)

## Descripción del Proyecto
Este proyecto consiste en la implementación desde cero de una estructura de datos tipo **HashMap** en Java. [cite_start]La implementación utiliza **Encadenamiento Separado** (Separate Chaining) para el manejo de colisiones, donde cada posición del arreglo almacena una lista enlazada de nodos[cite: 7, 9].

[cite_start]La estructura es genérica (`<K, V>`) y cuenta con **rehashing dinámico**: duplica automáticamente su capacidad cuando el factor de carga supera el 0.75 para mantener un rendimiento eficiente[cite: 65, 210].

## Estructura del Proyecto
El proyecto está organizado de la siguiente manera:

```text
HashMapProject/
├── src/
│   └── estructuras/
│       ├── Diccionario.java  (Interfaz)
│       └── TablaHash.java    (Implementación lógica)
├── test/
│   └── TestTablaHash.java    (Clase de pruebas unitarias)
└── README.md
