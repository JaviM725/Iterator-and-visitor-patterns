package iteradores;

import interfaces.Iterador;
import modelo.Docente;
import java.util.ArrayList;

/**
 * Recorre el ArrayList de docentes saltando de dos en dos:
 * solo visita los índices pares (0, 2, 4, 6...).
 * Útil para procesar una muestra alterna de la lista.
 */
public class IteradorDocentePares implements Iterador<Docente> {

    private final ArrayList<Docente> lista;
    private int posicion;

    public IteradorDocentePares(ArrayList<Docente> lista) {
        this.lista = lista;
        this.posicion = 0; // Empieza en el índice 0 (par)
    }

    @Override
    public boolean hasNext() {
        return posicion < lista.size();
    }

    @Override
    public Docente next() {
        Docente docente = lista.get(posicion);
        posicion += 2; // Salta al siguiente índice par
        return docente;
    }
}
