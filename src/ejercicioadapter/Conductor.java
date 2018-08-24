package ejercicioadapter;


import javax.swing.JOptionPane;

public class Conductor extends Usuario {
    public Conductor() {
        super();
    }
    String mensaje;
    
    @Override
    public String adicionar(String nombre, String correo, String contraseña) {
        Conductor conductor= new Conductor();
        conductor.setNombre(nombre);
        conductor.setCorreo(correo);
        conductor.setContraseña(contraseña);
        Usuario.usuarios.add(conductor);
        
       return mensaje = "El pasajero se ha adicionando exitósamente.";
    }


    @Override
    public String modificar(String correo) {
        
        boolean encontrado = false;
        
        for (int i = 0; i < Usuario.usuarios.size(); i++) {
            if (Usuario.usuarios.get(i) instanceof Conductor 
                && Usuario.usuarios.get(i).getCorreo().equals(correo)) {
                Usuario.usuarios.get(i).setNombre(JOptionPane.showInputDialog("Ingrese el nuevo nombre: "));
                Usuario.usuarios.get(i).setContraseña(JOptionPane.showInputDialog("Ingrese la nueva contraseña: "));
                encontrado = true;
                mensaje = "El conductor se ha modificado correctamente.";
            }
        } 
        if (!encontrado){
            mensaje = "No se encontró ningún conductor con ese correo.";
        }
        
        return mensaje;
        
    }

    @Override
    public String consultar() {
        boolean hayConductores = false;
        
        for (int i = 0; i < Usuario.usuarios.size(); i++) {
            if (Usuario.usuarios.get(i) instanceof Conductor) {
                hayConductores = true;
            }
        }
        
        if (!hayConductores) {
            mensaje = "No hay ningún conductor registrado.";
        }
        
        mensaje = "Conductores: \n";
        
        for (int i = 0; i < Usuario.usuarios.size(); i++) {
            if (Usuario.usuarios.get(i) instanceof Conductor) {
                mensaje = mensaje+ Usuario.usuarios.get(i).toString() + "\n";
            }
        }
        return mensaje;
    }

    @Override
    public String eliminar(String correo) {
        boolean encontrado = false;
        
        for (int i = 0; i < Usuario.usuarios.size(); i++) {
            if (Usuario.usuarios.get(i) instanceof Conductor
                && Usuario.usuarios.get(i).getCorreo().equals(correo)) {
                Usuario.usuarios.remove(i);
                encontrado = true;
                mensaje = "Conductor eliminado exitósamente.";
            }
        }
        
        if (!encontrado) mensaje = "No se encontró ningún conductor con ese correo.";
        
        return mensaje;
    }
    
    @Override
    public String toString() {
        return this.getNombre() + " - " + this.getCorreo();
    }
}
