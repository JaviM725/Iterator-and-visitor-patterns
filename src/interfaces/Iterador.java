package interfaces;

/**
 * Interfaz del patrón Iterator.
 * Define los métodos para recorrer una colección sin exponer su estructura interna.
 */
public interface Iterador<T> {
    boolean hasNext();
    T next();
}
