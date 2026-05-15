package main;

import colecciones.ColeccionDocentes;
import colecciones.ColeccionEstudiantes;
import interfaces.Iterador;
import modelo.Docente;
import modelo.Estudiante;
import visitor.VerificadorDatos;
import interfaces.Visitor;

/**
 * Punto de entrada principal.
 * Demuestra:
 *   - Patrón Iterator: 4 formas de recorrido (2 por colección).
 *   - Patrón Visitor: verificación de datos completos con notificaciones.
 */
public class Main {

    // Colores para la consola
    private static final String RESET   = "\u001B[0m";
    private static final String CYAN    = "\u001B[36m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String NEGRITA = "\u001B[1m";

    public static void main(String[] args) {

        // ── 1. Construir colección de estudiantes ──────────────────────────────
        ColeccionEstudiantes colEstudiantes = new ColeccionEstudiantes();
        colEstudiantes.agregar(new Estudiante("EST-004", "Laura Martínez", "Calle 45 #12-30", "3001234567"));
        colEstudiantes.agregar(new Estudiante("EST-001", "Carlos Pérez",   "Av. 68 #23-10",   "3109876543"));
        colEstudiantes.agregar(new Estudiante("EST-003", "Andrés Gómez",   null,              "3205551234")); // dirección faltante
        colEstudiantes.agregar(new Estudiante("EST-002", "María López",    "Cra. 7 #15-20",   ""           )); // teléfono faltante
        colEstudiantes.agregar(new Estudiante("EST-005", "Sofía Ramírez",  "Calle 100 #5-60", "3157894561"));

        // ── 2. Construir colección de docentes ────────────────────────────────
        ColeccionDocentes colDocentes = new ColeccionDocentes();
        colDocentes.agregar(new Docente("DOC-01", "Prof. Hernández", "Calle 80 #10-50",   "3001111111"));
        colDocentes.agregar(new Docente("DOC-02", "Prof. Torres",    "",                  "3002222222")); // dirección faltante
        colDocentes.agregar(new Docente("DOC-03", "Prof. Vargas",    "Av. Suba #60-20",   "3003333333"));
        colDocentes.agregar(new Docente("DOC-04", null,              "Cra. 30 #25-10",    "3004444444")); // nombre faltante
        colDocentes.agregar(new Docente("DOC-05", "Prof. Jiménez",   "Calle 13 #55-30",   "3005555555"));
        colDocentes.agregar(new Docente("DOC-06", "Prof. Castillo",  "Av. El Dorado #70", "3006666666"));

        separador("═", 70);
        System.out.println(NEGRITA + CYAN + "          PATRÓN ITERATOR — RECORRIDOS DE COLECCIONES" + RESET);
        separador("═", 70);

        // ── 3. Iterator: TreeSet de estudiantes — orden normal (A→Z) ──────────
        titulo("Iterator 1/4 | Estudiantes — Orden Normal (Código A → Z)");
        Iterador<Estudiante> itEstNormal = colEstudiantes.crearIteradorNormal();
        while (itEstNormal.hasNext()) {
            System.out.println("  " + itEstNormal.next());
        }

        // ── 4. Iterator: TreeSet de estudiantes — orden inverso (Z→A) ─────────
        titulo("Iterator 2/4 | Estudiantes — Orden Inverso (Código Z → A)");
        Iterador<Estudiante> itEstInverso = colEstudiantes.crearIteradorAlternativo();
        while (itEstInverso.hasNext()) {
            System.out.println("  " + itEstInverso.next());
        }

        // ── 5. Iterator: ArrayList de docentes — todos en orden ───────────────
        titulo("Iterator 3/4 | Docentes — Orden Normal (todos, índice 0→fin)");
        Iterador<Docente> itDocNormal = colDocentes.crearIteradorNormal();
        while (itDocNormal.hasNext()) {
            System.out.println("  " + itDocNormal.next());
        }

        // ── 6. Iterator: ArrayList de docentes — solo posiciones pares ────────
        titulo("Iterator 4/4 | Docentes — Solo Posiciones Pares (índices 0, 2, 4...)");
        Iterador<Docente> itDocPares = colDocentes.crearIteradorAlternativo();
        while (itDocPares.hasNext()) {
            System.out.println("  " + itDocPares.next());
        }

        // ── 7. Visitor: verificación de datos ─────────────────────────────────
        separador("═", 70);
        System.out.println(NEGRITA + MAGENTA + "          PATRÓN VISITOR — VERIFICACIÓN DE DATOS" + RESET);
        separador("═", 70);

        Visitor verificador = new VerificadorDatos();

        titulo("Visitor | Verificando Estudiantes");
        Iterador<Estudiante> itVEstudiante = colEstudiantes.crearIteradorNormal();
        while (itVEstudiante.hasNext()) {
            itVEstudiante.next().aceptar(verificador);
            System.out.println();
        }

        titulo("Visitor | Verificando Docentes");
        Iterador<Docente> itVDocente = colDocentes.crearIteradorNormal();
        while (itVDocente.hasNext()) {
            itVDocente.next().aceptar(verificador);
            System.out.println();
        }

        separador("═", 70);
        System.out.println(NEGRITA + "  Ejecución completada." + RESET);
        separador("═", 70);
    }

    // ── Utilidades de formato ──────────────────────────────────────────────────

    private static void titulo(String texto) {
        System.out.println();
        separador("─", 70);
        System.out.println("  " + NEGRITA + texto + RESET);
        separador("─", 70);
    }

    private static void separador(String caracter, int repeticiones) {
        System.out.println(caracter.repeat(repeticiones));
    }
}
