package modelo;

/**
 * Clase base que contiene los campos comunes de Estudiante y Docente.
 */
public abstract class Persona {
    protected String codigo;
    protected String nombre;
    protected String direccion;
    protected String telefono;

    public Persona(String codigo, String nombre, String direccion, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getCodigo()    { return codigo; }
    public String getNombre()    { return nombre; }
    public String getDireccion() { return direccion; }
    public String getTelefono()  { return telefono; }

    /**
     * Verifica si todos los campos están completos (no nulos ni vacíos).
     */
    public boolean datosCompletos() {
        return noVacio(codigo) && noVacio(nombre)
            && noVacio(direccion) && noVacio(telefono);
    }

    private boolean noVacio(String valor) {
        return valor != null && !valor.trim().isEmpty();
    }

    @Override
    public String toString() {
        return String.format("[Código: %s | Nombre: %s | Dirección: %s | Teléfono: %s]",
            codigo, nombre, direccion, telefono);
    }
}
