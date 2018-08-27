package ejercicioadapter;

public class Conductor extends Usuario {

  public Conductor() {
    super();
  }

  @Override
  public String adicionar(String nombre, String correo, String contraseña) {
    boolean correoYaExiste = false;

    for (Usuario usuario : this.getUsuarios()) {
      if (usuario instanceof Conductor
              && usuario.getCorreo().equals(correo)) {
        correoYaExiste = true;
      }
    }

    if (correoYaExiste) {
      return correo + " ya está registrado como conductor.";
    } else {
      Conductor conductor = new Conductor();
      conductor.setNombre(nombre);
      conductor.setCorreo(correo);
      conductor.setContraseña(contraseña);
      Usuario.usuarios.add(conductor);

      return "El conductor se ha adicionando exitósamente.";
    }
  }

  @Override
  public String modificar(String correo, String nombre, String contraseña) {
    boolean encontrado = false;

    for (Usuario usuario : this.getUsuarios()) {
      if (usuario instanceof Conductor
              && usuario.getCorreo().equals(correo)) {
        encontrado = true;
        usuario.setNombre(nombre);
        usuario.setContraseña(contraseña);
      }
    }

    if (!encontrado) {
      return "No se encontró ningún conductor con ese correo.";
    } else {
      return "El conductor se ha modificado correctamente.";
    }
  }

  @Override
  public String consultar() {
    String mensaje = "";
    boolean hayConductores = false;

    for (Usuario usuario : this.getUsuarios()) {
      if (usuario instanceof Conductor) {
        hayConductores = true;
        mensaje += "NOMBRE: " + usuario.getNombre() + " - CORREO: " + usuario.getCorreo() + "\n";
      }
    }

    if (!hayConductores) {
      mensaje = "No hay ningún conductor registrado.";
    } else {
      mensaje = "Conductores registrados: \n\n" + mensaje;
    }

    return mensaje;
  }

  @Override
  public String eliminar(String correo) {
    boolean encontrado = false;

    for (int i = 0; i < this.getUsuarios().size(); i++) {
      if (this.getUsuarios().get(i) instanceof Conductor
              && this.getUsuarios().get(i).getCorreo().equals(correo)) {
        encontrado = true;
        this.getUsuarios().remove(i);
      }
    }

    if (!encontrado) {
      return "No se encontró ningún conductor con ese correo.";
    } else {
      return "Conductor eliminado exitósamente.";
    }
  }

  @Override
  public String toString() {
    return this.getNombre() + " - " + this.getCorreo();
  }
}
