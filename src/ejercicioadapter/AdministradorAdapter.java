package ejercicioadapter;

public class AdministradorAdapter extends Usuario {

  private Administrador administrador;

  public AdministradorAdapter() {
    super();
    this.administrador = new Administrador();
  }

  @Override
  public String adicionar(String nombre, String correo, String contraseña) {
    this.administrador.crear();

    boolean correoYaExiste = false;

    for (Usuario usuario : this.getUsuarios()) {
      if (usuario instanceof AdministradorAdapter
              && usuario.getCorreo().equals(correo)) {
        correoYaExiste = true;
      }
    }

    if (correoYaExiste) {
      return correo + " ya está registrado como administrador.";
    } else {
      this.setNombre(nombre);
      this.setCorreo(correo);
      this.setContraseña(contraseña);
      Usuario.usuarios.add(this);

      return "Se ha adicionado un administrador exitósamente.";
    }
  }

  @Override
  public String modificar(String correo, String nombre, String contraseña) {
    this.administrador.actualizar();

    boolean encontrado = false;

    for (Usuario usuario : this.getUsuarios()) {
      if (usuario instanceof AdministradorAdapter
              && usuario.getCorreo().equals(correo)) {
        encontrado = true;
        usuario.setNombre(nombre);
        usuario.setContraseña(contraseña);
      }
    }

    if (!encontrado) {
      return "No se encontró ningún administrador con ese correo.";
    } else {
      return "El administrador se ha modificado correctamente.";
    }
  }

  @Override
  public String consultar() {
    this.administrador.listar();

    String mensaje = "";
    boolean hayAdministradores = false;

    for (Usuario usuario : this.getUsuarios()) {
      if (usuario instanceof AdministradorAdapter) {
        hayAdministradores = true;
        mensaje += "NOMBRE: " + usuario.getNombre() + " - CORREO: " + usuario.getCorreo() + "\n";
      }
    }

    if (!hayAdministradores) {
      mensaje = "No hay ningún administrador registrado.";
    } else {
      mensaje = "Administradores registrados: \n\n" + mensaje;
    }

    return mensaje;
  }

  @Override
  public String eliminar(String correo) {
    this.administrador.quitar();

    boolean encontrado = false;

    for (int i = 0; i < this.getUsuarios().size(); i++) {
      if (this.getUsuarios().get(i) instanceof AdministradorAdapter
              && this.getUsuarios().get(i).getCorreo().equals(correo)) {
        encontrado = true;
        this.getUsuarios().remove(i);
      }
    }

    if (!encontrado) {
      return "No se encontró ningún administrador con ese correo.";
    } else {
      return "Administrador eliminado exitósamente.";
    }
  }

  @Override
  public String toString() {
    return this.getNombre() + " - " + this.getCorreo();
  }
}
