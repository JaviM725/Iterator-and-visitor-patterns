package interfaces;

/**
 * Interfaz de la Colección (parte del patrón Iterator).
 * Toda colección que quiera ser recorrida debe implementar esta interfaz
 * y proveer uno o más iteradores.
 */
public interface Coleccion<T> {
    Iterador<T> crearIteradorNormal();
    Iterador<T> crearIteradorAlternativo();
}
