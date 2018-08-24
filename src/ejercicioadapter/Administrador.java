package ejercicioadapter;

import javax.swing.JOptionPane;

public class Administrador {
    private String nombre;
    private String correo;
    private String contraseña;
    
    public void crear() {
        this.nombre = JOptionPane.showInputDialog("Ingrese el nombre: ");
        this.correo = JOptionPane.showInputDialog("Ingrese el correo: ");
        this.contraseña = JOptionPane.showInputDialog("Ingrese la contraseña: ");
    }
    
    public void actualizar() {
        String correo = JOptionPane.showInputDialog("Ingrese el correo del administrador que desea modificar: ");
        boolean encontrado = false;
        
        for (int i = 0; i < Usuario.usuarios.size(); i++) {
            /* ¿Cómo sé que un usuario es administrador en el ArrayList de usuarios? */
            if (!(Usuario.usuarios.get(i) instanceof Conductor)
                && !(Usuario.usuarios.get(i) instanceof Pasajero)
                && Usuario.usuarios.get(i).getCorreo().equals(correo)) {
                Usuario.usuarios.get(i).setNombre(JOptionPane.showInputDialog("Ingrese el nuevo nombre: "));
                Usuario.usuarios.get(i).setContraseña(JOptionPane.showInputDialog("Ingrese la nueva contraseña: "));
                encontrado = true;
            }
        }
        
        if (!encontrado) System.out.println("No se encontró ningún administrador con ese correo.");
    }
    
    public void listar() {
        boolean hayAdministradores = false;
        
        for (int i = 0; i < Usuario.usuarios.size(); i++) {
            /* ¿Cómo sé que un usuario es administrador en el ArrayList de usuarios? */
            if (!(Usuario.usuarios.get(i) instanceof Conductor)
                && !(Usuario.usuarios.get(i) instanceof Pasajero)) {
                hayAdministradores = true;
            }
        }
        
        if (!hayAdministradores) {
            System.out.println("No hay ningún administrador registrado.");
            return;
        }
        
        System.out.println("Administradores: ");
        
        for (int i = 0; i < Usuario.usuarios.size(); i++) {
            /* ¿Cómo sé que un usuario es administrador en el ArrayList de usuarios? */
            if (!(Usuario.usuarios.get(i) instanceof Conductor)
                && !(Usuario.usuarios.get(i) instanceof Pasajero)) {
                System.out.println(Usuario.usuarios.get(i).toString());
            }
        }
    }
    
    public void quitar() {
        String correo = JOptionPane.showInputDialog("Ingrese el correo del administrador que desea eliminar: ");
        boolean encontrado = false;
        
        for (int i = 0; i < Usuario.usuarios.size(); i++) {
            if (!(Usuario.usuarios.get(i) instanceof Conductor)
                && !(Usuario.usuarios.get(i) instanceof Pasajero)
                && Usuario.usuarios.get(i).getCorreo().equals(correo)) {
                Usuario.usuarios.remove(i);
                encontrado = true;
                System.out.println("Administrador eliminado exitósamente.");
            }
        }
        
        if (!encontrado) System.out.println("No se encontró ningún administrador con ese correo.");
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }
}
