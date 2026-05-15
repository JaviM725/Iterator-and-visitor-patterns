package modelo;

import interfaces.Elemento;
import interfaces.Visitor;

/**
 * Representa un docente. Implementa Elemento para poder ser visitado.
 */
public class Docente extends Persona implements Elemento {

    public Docente(String codigo, String nombre, String direccion, String telefono) {
        super(codigo, nombre, direccion, telefono);
    }

    @Override
    public void aceptar(Visitor visitor) {
        visitor.visitar(this);
    }

    @Override
    public String toString() {
        return "Docente   " + super.toString();
    }
}
