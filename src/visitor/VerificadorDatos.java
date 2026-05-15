package visitor;

import interfaces.Visitor;
import modelo.Estudiante;
import modelo.Docente;
import java.util.Random;

/**
 * Visitor concreto: VerificadorDatos.
 *
 * Al visitar un Estudiante:
 *   - Si los datos están completos → imprime confirmación.
 *   - Si faltan datos → simula el envío de una notificación al estudiante.
 *
 * Al visitar un Docente:
 *   - Si los datos están completos → imprime confirmación.
 *   - Si faltan datos → genera un código numérico de máximo 4 dígitos y lo reporta.
 */
public class VerificadorDatos implements Visitor {

    private static final String RESET  = "\u001B[0m";
    private static final String VERDE  = "\u001B[32m";
    private static final String ROJO   = "\u001B[31m";
    private static final String AMARILLO = "\u001B[33m";

    private final Random random = new Random();

    @Override
    public void visitar(Estudiante estudiante) {
        System.out.println("  Verificando → " + estudiante);

        if (estudiante.datosCompletos()) {
            System.out.println(VERDE + "  ✔ Datos completos." + RESET);
        } else {
            String camposFaltantes = detectarCamposFaltantes(estudiante);
            System.out.println(ROJO + "  ✘ Datos incompletos. Campos faltantes: " + camposFaltantes + RESET);
            enviarNotificacionEstudiante(estudiante);
        }
    }

    @Override
    public void visitar(Docente docente) {
        System.out.println("  Verificando → " + docente);

        if (docente.datosCompletos()) {
            System.out.println(VERDE + "  ✔ Datos completos." + RESET);
        } else {
            String camposFaltantes = detectarCamposFaltantes(docente);
            System.out.println(ROJO + "  ✘ Datos incompletos. Campos faltantes: " + camposFaltantes + RESET);
            enviarCodigoDocente(docente);
        }
    }

    // ─── Métodos auxiliares ───────────────────────────────────────────────────

    /**
     * Detecta cuáles campos específicos están vacíos o nulos.
     */
    private String detectarCamposFaltantes(modelo.Persona persona) {
        StringBuilder sb = new StringBuilder();
        if (esVacio(persona.getCodigo()))    sb.append("[código] ");
        if (esVacio(persona.getNombre()))    sb.append("[nombre] ");
        if (esVacio(persona.getDireccion())) sb.append("[dirección] ");
        if (esVacio(persona.getTelefono()))  sb.append("[teléfono] ");
        return sb.toString().trim();
    }

    private boolean esVacio(String valor) {
        return valor == null || valor.trim().isEmpty();
    }

    /**
     * Simula el envío de una notificación al estudiante por datos incompletos.
     */
    private void enviarNotificacionEstudiante(Estudiante estudiante) {
        String nombre = esVacio(estudiante.getNombre()) ? "(sin nombre)" : estudiante.getNombre();
        System.out.println(AMARILLO
            + "  📩 Notificación enviada al estudiante "
            + nombre
            + ": Por favor actualice sus datos en el sistema."
            + RESET);
    }

    /**
     * Genera un código numérico de máximo 4 dígitos para el docente.
     */
    private void enviarCodigoDocente(Docente docente) {
        int codigo = random.nextInt(9000) + 1000; // Garantiza exactamente 4 dígitos
        String nombre = esVacio(docente.getNombre()) ? "(sin nombre)" : docente.getNombre();
        System.out.println(AMARILLO
            + "  🔑 Código generado para el docente "
            + nombre
            + ": " + codigo
            + " (para actualización de datos)"
            + RESET);
    }
}
