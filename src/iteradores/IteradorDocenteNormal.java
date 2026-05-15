package iteradores;

import interfaces.Iterador;
import modelo.Docente;
import java.util.ArrayList;

/**
 * Recorre el ArrayList de docentes de inicio a fin (índice 0, 1, 2, 3...).
 */
public class IteradorDocenteNormal implements Iterador<Docente> {

    private final ArrayList<Docente> lista;
    private int posicion;

    public IteradorDocenteNormal(ArrayList<Docente> lista) {
        this.lista = lista;
        this.posicion = 0;
    }

    @Override
    public boolean hasNext() {
        return posicion < lista.size();
    }

    @Override
    public Docente next() {
        return lista.get(posicion++);
    }
}
