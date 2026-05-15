package colecciones;

import interfaces.Coleccion;
import interfaces.Iterador;
import iteradores.IteradorEstudianteNormal;
import iteradores.IteradorEstudianteInverso;
import modelo.Estudiante;
import java.util.TreeSet;

/**
 * Colección de estudiantes almacenada en un TreeSet.
 * El TreeSet ordena automáticamente los estudiantes por código (orden natural).
 * Provee dos iteradores: normal (A→Z) e inverso (Z→A).
 */
public class ColeccionEstudiantes implements Coleccion<Estudiante> {

    private final TreeSet<Estudiante> conjunto;

    public ColeccionEstudiantes() {
        this.conjunto = new TreeSet<>();
    }

    public void agregar(Estudiante estudiante) {
        conjunto.add(estudiante);
    }

    public TreeSet<Estudiante> getConjunto() {
        return conjunto;
    }

    /** Iterador en orden natural: código A → Z */
    @Override
    public Iterador<Estudiante> crearIteradorNormal() {
        return new IteradorEstudianteNormal(conjunto);
    }

    /** Iterador en orden inverso: código Z → A */
    @Override
    public Iterador<Estudiante> crearIteradorAlternativo() {
        return new IteradorEstudianteInverso(conjunto);
    }
}
