package iteradores;

import interfaces.Iterador;
import modelo.Estudiante;
import java.util.TreeSet;

/**
 * Recorre el TreeSet de estudiantes en orden natural (por código, A → Z).
 * Usa el iterador interno del TreeSet, que ya garantiza ese orden.
 */
public class IteradorEstudianteNormal implements Iterador<Estudiante> {

    private final java.util.Iterator<Estudiante> iteradorInterno;

    public IteradorEstudianteNormal(TreeSet<Estudiante> conjunto) {
        this.iteradorInterno = conjunto.iterator();
    }

    @Override
    public boolean hasNext() {
        return iteradorInterno.hasNext();
    }

    @Override
    public Estudiante next() {
        return iteradorInterno.next();
    }
}
