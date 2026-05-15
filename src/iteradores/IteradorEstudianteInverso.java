package iteradores;

import interfaces.Iterador;
import modelo.Estudiante;
import java.util.TreeSet;

/**
 * Recorre el TreeSet de estudiantes en orden inverso (por código, Z → A).
 * Usa el descendingIterator() del TreeSet.
 */
public class IteradorEstudianteInverso implements Iterador<Estudiante> {

    private final java.util.Iterator<Estudiante> iteradorInterno;

    public IteradorEstudianteInverso(TreeSet<Estudiante> conjunto) {
        this.iteradorInterno = conjunto.descendingIterator();
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
