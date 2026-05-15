package modelo;

import interfaces.Elemento;
import interfaces.Visitor;

/**
 * Representa un estudiante. Implementa Comparable para que el TreeSet
 * pueda ordenarlo por código estudiantil de forma natural.
 * Implementa Elemento para poder ser visitado por un Visitor.
 */
public class Estudiante extends Persona implements Comparable<Estudiante>, Elemento {

    public Estudiante(String codigo, String nombre, String direccion, String telefono) {
        super(codigo, nombre, direccion, telefono);
    }

    @Override
    public int compareTo(Estudiante otro) {
        // Orden natural del TreeSet: por código estudiantil alfabético
        return this.codigo.compareTo(otro.codigo);
    }

    @Override
    public void aceptar(Visitor visitor) {
        visitor.visitar(this);
    }

    @Override
    public String toString() {
        return "Estudiante " + super.toString();
    }
}
