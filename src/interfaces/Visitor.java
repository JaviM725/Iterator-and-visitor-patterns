package interfaces;

import modelo.Estudiante;
import modelo.Docente;

/**
 * Interfaz del patrón Visitor.
 * Declara una operación de visita para cada tipo de elemento concreto.
 */
public interface Visitor {
    void visitar(Estudiante estudiante);
    void visitar(Docente docente);
}
