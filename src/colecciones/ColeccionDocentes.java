package colecciones;

import interfaces.Coleccion;
import interfaces.Iterador;
import iteradores.IteradorDocenteNormal;
import iteradores.IteradorDocentePares;
import modelo.Docente;
import java.util.ArrayList;

/**
 * Colección de docentes almacenada en un ArrayList.
 * Provee dos iteradores: normal (todos en orden) y por pares (índices 0, 2, 4...).
 */
public class ColeccionDocentes implements Coleccion<Docente> {

    private final ArrayList<Docente> lista;

    public ColeccionDocentes() {
        this.lista = new ArrayList<>();
    }

    public void agregar(Docente docente) {
        lista.add(docente);
    }

    public ArrayList<Docente> getLista() {
        return lista;
    }

    /** Iterador normal: recorre todos los docentes de inicio a fin */
    @Override
    public Iterador<Docente> crearIteradorNormal() {
        return new IteradorDocenteNormal(lista);
    }

    /** Iterador alternativo: recorre solo los docentes en posiciones pares */
    @Override
    public Iterador<Docente> crearIteradorAlternativo() {
        return new IteradorDocentePares(lista);
    }
}
