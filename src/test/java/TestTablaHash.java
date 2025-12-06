import com.estructuras.TablaHash;

/**
 * Clase de prueba para verificar el funcionamiento de la TablaHash.
 * Cubre inserción, búsqueda, eliminación y redimensionamiento dinámico.
 */
public class TestTablaHash {

    public static void main(String[] args) {
        System.out.println("=== INICIO DE PRUEBAS DE TABLA HASH ===\n");

        // Instanciar la tabla
        TablaHash<String, Integer> tabla = new TablaHash<>();

        // -------------------------------------------------
        // PRUEBA 1: Inserción Básica y Recuperación (put/get)
        // -------------------------------------------------
        System.out.println("--- Prueba 1: Inserción y Recuperación ---");
        tabla.put("Gato", 1);
        tabla.put("Perro", 2);
        tabla.put("Elefante", 3);

        System.out.println("Valor de 'Gato': " + tabla.get("Gato") + " (Esperado: 1)");
        System.out.println("Valor de 'Perro': " + tabla.get("Perro") + " (Esperado: 2)");
        System.out.println("Valor de 'Leon' (no existe): " + tabla.get("Leon") + " (Esperado: null)");
        System.out.println("Tamaño actual: " + tabla.size() + " (Esperado: 3)\n");

        // -------------------------------------------------
        // PRUEBA 2: Actualización de Valores
        // -------------------------------------------------
        System.out.println("--- Prueba 2: Actualización de Claves Existentes ---");
        System.out.println("Insertando ('Gato', 10)...");
        tabla.put("Gato", 10); // Debería sobrescribir el 1

        System.out.println("Nuevo valor de 'Gato': " + tabla.get("Gato") + " (Esperado: 10)");
        System.out.println("Tamaño después de update: " + tabla.size() + " (Esperado: 3, no debe aumentar)\n");

        // -------------------------------------------------
        // PRUEBA 3: Eliminación (remove)
        // -------------------------------------------------
        System.out.println("--- Prueba 3: Eliminación ---");
        Integer eliminado = tabla.remove("Perro");

        System.out.println("Valor eliminado: " + eliminado + " (Esperado: 2)");
        System.out.println("Busqueda de 'Perro' tras eliminar: " + tabla.get("Perro") + " (Esperado: null)");
        System.out.println("Tamaño actual: " + tabla.size() + " (Esperado: 2)\n");

        // -------------------------------------------------
        // PRUEBA 4: ContainsKey
        // -------------------------------------------------
        System.out.println("--- Prueba 4: ContainsKey ---");
        System.out.println("¿Contiene 'Elefante'?: " + tabla.containsKey("Elefante") + " (Esperado: true)");
        System.out.println("¿Contiene 'Perro'?: " + tabla.containsKey("Perro") + " (Esperado: false)\n");

        // -------------------------------------------------
        // PRUEBA 5: Resize (Rehashing)
        // -------------------------------------------------
        System.out.println("--- Prueba 5: Redimensionamiento Dinámico (Resize) ---");
        System.out.println("Capacidad inicial: 11. Límite antes de resize: 8 elementos (0.75)");
        System.out.println("Insertando elementos masivamente...");

        // Ya tenemos 2 elementos ("Gato", "Elefante").
        // Insertamos 15 más para forzar que la capacidad se duplique (probablemente a 22 y luego 44 o similar)
        for (int i = 1; i <= 15; i++) {
            tabla.put("Clave" + i, i * 100);
        }

        System.out.println("Elementos totales insertados: " + tabla.size());

        // Verificar que los datos antiguos siguen ahí (significa que el rehash funcionó)
        System.out.println("Verificando integridad de datos antiguos ('Gato'): " + tabla.get("Gato") + " (Esperado: 10)");

        // Verificar datos nuevos (que hayan caído en nuevos índices)
        System.out.println("Verificando datos nuevos ('Clave10'): " + tabla.get("Clave10") + " (Esperado: 1000)");
        System.out.println("Verificando datos nuevos ('Clave15'): " + tabla.get("Clave15") + " (Esperado: 1500)");

        System.out.println("\n=== FIN DE PRUEBAS ===");
    }
}