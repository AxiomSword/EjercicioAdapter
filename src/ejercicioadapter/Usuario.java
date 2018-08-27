package ejercicioadapter;

import java.util.ArrayList;

public abstract class Usuario {

  protected static ArrayList<Usuario> usuarios = new ArrayList<>();

  private String nombre;
  private String correo;
  private String contraseña;

  abstract public String adicionar(String nombre, String correo, String contraseña);

  abstract public String modificar(String correo, String nombre, String contraseña);

  abstract public String consultar();

  abstract public String eliminar(String correo);

  protected ArrayList<Usuario> getUsuarios() {
    return Usuario.usuarios;
  }

  protected String getNombre() {
    return nombre;
  }

  protected void setNombre(String nombre) {
    this.nombre = nombre;
  }

  protected String getCorreo() {
    return correo;
  }

  protected void setCorreo(String correo) {
    this.correo = correo;
  }

  protected String getContraseña() {
    return contraseña;
  }

  protected void setContraseña(String contraseña) {
    this.contraseña = contraseña;
  }
}
