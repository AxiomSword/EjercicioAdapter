package ejercicioadapter;

import javax.swing.JOptionPane;

public class Pasajero extends Usuario {
    public Pasajero() {
        super();
    }

    String mensaje;
    
    @Override
    public String adicionar(String nombre, String correo, String contraseña) {
        Pasajero pasajero= new Pasajero();
        pasajero.setNombre(nombre);
        pasajero.setCorreo(correo);
        pasajero.setContraseña(contraseña);
        Usuario.usuarios.add(pasajero);
        
       return mensaje = "El pasajero se ha adicionando exitósamente.";
    }
    
    @Override
    public String modificar(String correo) {
        
        boolean encontrado = false;
        
        for (int i = 0; i < Usuario.usuarios.size(); i++) {
            if (Usuario.usuarios.get(i) instanceof Pasajero 
                && Usuario.usuarios.get(i).getCorreo().equals(correo)) {
                Usuario.usuarios.get(i).setNombre(JOptionPane.showInputDialog("Ingrese el nuevo nombre: "));
                Usuario.usuarios.get(i).setContraseña(JOptionPane.showInputDialog("Ingrese la nueva contraseña: "));
                encontrado = true;
                mensaje = "El pasajero se ha modificado correctamente.";
            }
        } 
        if (!encontrado){
            mensaje = "No se encontró ningún pasajero con ese correo.";
        }     
        return mensaje;
        
    }

       @Override
    public String consultar() {
        boolean hayConductores = false;
        
        for (int i = 0; i < Usuario.usuarios.size(); i++) {
            if (Usuario.usuarios.get(i) instanceof Pasajero) {
                hayConductores = true;
            }
        }
        
        if (!hayConductores) {
            mensaje = "No hay ningún Pasajero registrado.";
        }
        
        mensaje = "Pasajeros: \n";
        
        for (int i = 0; i < Usuario.usuarios.size(); i++) {
            if (Usuario.usuarios.get(i) instanceof Pasajero) {
                mensaje = mensaje+ Usuario.usuarios.get(i).toString() + "\n";
            }
        }
        return mensaje;
    }

       @Override
    public String eliminar(String correo) {
        boolean encontrado = false;
        
        for (int i = 0; i < Usuario.usuarios.size(); i++) {
            if (Usuario.usuarios.get(i) instanceof Pasajero
                && Usuario.usuarios.get(i).getCorreo().equals(correo)) {
                Usuario.usuarios.remove(i);
                encontrado = true;
                mensaje = "Pasajero eliminado exitósamente.";
            }
        }
        
        if (!encontrado) mensaje = "No se encontró ningún Pasajero con ese correo.";
        
        return mensaje;
    }

    @Override
    public String toString() {
        return this.getNombre() + " - " + this.getCorreo();
    }
}
