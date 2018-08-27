package ejercicioadapter;

public class Pasajero extends Usuario {

  public Pasajero() {
    super();
  }

  @Override
  public String adicionar(String nombre, String correo, String contraseña) {
    boolean correoYaExiste = false;

    for (Usuario usuario : this.getUsuarios()) {
      if (usuario instanceof Pasajero
              && usuario.getCorreo().equals(correo)) {
        correoYaExiste = true;
      }
    }

    if (correoYaExiste) {
      return correo + " ya está registrado como pasajero.";
    } else {
      Pasajero pasajero = new Pasajero();
      pasajero.setNombre(nombre);
      pasajero.setCorreo(correo);
      pasajero.setContraseña(contraseña);
      Usuario.usuarios.add(pasajero);

      return "El pasajero se ha adicionando exitósamente.";
    }
  }

  @Override
  public String modificar(String correo, String nombre, String contraseña) {
    boolean encontrado = false;

    for (Usuario usuario : this.getUsuarios()) {
      if (usuario instanceof Pasajero
              && usuario.getCorreo().equals(correo)) {
        encontrado = true;
        usuario.setNombre(nombre);
        usuario.setContraseña(contraseña);
      }
    }

    if (!encontrado) {
      return "No se encontró ningún pasajero con ese correo.";
    } else {
      return "El pasajero se ha modificado correctamente.";
    }
  }

  @Override
  public String consultar() {
    String mensaje = "";
    boolean hayPasajeros = false;

    for (Usuario usuario : this.getUsuarios()) {
      if (usuario instanceof Pasajero) {
        hayPasajeros = true;
        mensaje += "NOMBRE: " + usuario.getNombre() + " - CORREO: " + usuario.getCorreo() + "\n";
      }
    }

    if (!hayPasajeros) {
      mensaje = "No hay ningún pasajero registrado.";
    } else {
      mensaje = "Pasajeros registrados: \n\n" + mensaje;
    }

    return mensaje;
  }

  @Override
  public String eliminar(String correo) {
    boolean encontrado = false;

    for (int i = 0; i < Usuario.usuarios.size(); i++) {
      if (Usuario.usuarios.get(i) instanceof Pasajero
              && Usuario.usuarios.get(i).getCorreo().equals(correo)) {
        encontrado = true;
        Usuario.usuarios.remove(i);
      }
    }

    if (!encontrado) {
      return "No se encontró ningún pasajero con ese correo.";
    } else {
      return "Pasajero eliminado exitósamente.";
    }
  }

  @Override
  public String toString() {
    return this.getNombre() + " - " + this.getCorreo();
  }
}
