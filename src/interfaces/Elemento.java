package interfaces;

/**
 * Interfaz Elemento del patrón Visitor.
 * Cada clase que quiera ser "visitada" debe implementar el método aceptar().
 */
public interface Elemento {
    void aceptar(Visitor visitor);
}
