package ejercicioadapter;

import java.util.ArrayList;

public abstract class Usuario {
    protected static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    
    private String nombre;
    private String correo;
    private String contraseña;
    
    abstract public void adicionar();
    abstract public void modificar();
    abstract public void consultar();
    abstract public void eliminar();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
