package ejercicioadapter;

import javax.swing.JOptionPane;

public class Pasajero extends Usuario {
    public Pasajero() {
        super();
    }

    @Override
    public void adicionar() {
        this.setNombre(JOptionPane.showInputDialog("Ingrese el nombre: "));
        this.setCorreo(JOptionPane.showInputDialog("Ingrese el correo institucional: "));
        this.setContraseña(JOptionPane.showInputDialog("Ingrese la contraseña: "));
        Usuario.usuarios.add(this);
    }

    @Override
    public void modificar() {
        String correo = JOptionPane.showInputDialog("Ingrese el correo del pasajero que desea modificar: ");
        boolean encontrado = false;
        
        for (int i = 0; i < Usuario.usuarios.size(); i++) {
            if (Usuario.usuarios.get(i) instanceof Pasajero 
                && Usuario.usuarios.get(i).getCorreo().equals(correo)) {
                Usuario.usuarios.get(i).setNombre(JOptionPane.showInputDialog("Ingrese el nuevo nombre: "));
                Usuario.usuarios.get(i).setContraseña(JOptionPane.showInputDialog("Ingrese la nueva contraseña: "));
                encontrado = true;
            }
        } 
        
        if (!encontrado) System.out.println("No se encontró ningún pasajero con ese correo.");
    }

    @Override
    public void consultar() {
        boolean hayPasajeros = false;
        
        for (int i = 0; i < Usuario.usuarios.size(); i++) {
            if (Usuario.usuarios.get(i) instanceof Pasajero) {
                hayPasajeros = true;
            }
        }
        
        if (!hayPasajeros) {
            System.out.println("No hay ningún pasajero registrado.");
            return;
        }
        
        System.out.println("Pasajeros: ");
        
        for (int i = 0; i < Usuario.usuarios.size(); i++) {
            if (Usuario.usuarios.get(i) instanceof Pasajero) {
                System.out.println(Usuario.usuarios.get(i).toString());
            }
        }
    }

    @Override
    public void eliminar() {
        String correo = JOptionPane.showInputDialog("Ingrese el correo del pasajero que desea eliminar: ");
        boolean encontrado = false;
        
        for (int i = 0; i < Usuario.usuarios.size(); i++) {
            if (Usuario.usuarios.get(i) instanceof Pasajero
                && Usuario.usuarios.get(i).getCorreo().equals(correo)) {
                Usuario.usuarios.remove(i);
                encontrado = true;
                System.out.println("Pasajero eliminado exitósamente.");
            }
        }
        
        if (!encontrado) System.out.println("No se encontró ningún pasajero con ese correo.");
    }
    
    @Override
    public String toString() {
        return this.getNombre() + " - " + this.getCorreo();
    }
}
