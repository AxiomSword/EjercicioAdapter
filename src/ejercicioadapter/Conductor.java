package ejercicioadapter;

import javax.swing.JOptionPane;

public class Conductor extends Usuario {
    public Conductor() {
        super();
    }
    
    @Override
    public void adicionar() {
        this.setNombre(JOptionPane.showInputDialog("Ingrese el nombre: "));
        this.setCorreo(JOptionPane.showInputDialog("Ingrese el correo institucional: "));
        this.setContraseña(JOptionPane.showInputDialog("Ingrese la contraseña: "));
        Usuario.usuarios.add(this);
        JOptionPane.showMessageDialog(null, "El conductor se ha adicionado exitósamente.");
    }

    @Override
    public void modificar() {
        String correo = JOptionPane.showInputDialog("Ingrese el correo del conductor que desea modificar: ");
        boolean encontrado = false;
        
        for (int i = 0; i < Usuario.usuarios.size(); i++) {
            if (Usuario.usuarios.get(i) instanceof Conductor 
                && Usuario.usuarios.get(i).getCorreo().equals(correo)) {
                Usuario.usuarios.get(i).setNombre(JOptionPane.showInputDialog("Ingrese el nuevo nombre: "));
                Usuario.usuarios.get(i).setContraseña(JOptionPane.showInputDialog("Ingrese la nueva contraseña: "));
                encontrado = true;
                JOptionPane.showMessageDialog(null, "El conductor se ha modificado correctamente.");
            }
        } 
        
        if (!encontrado) System.out.println("No se encontró ningún conductor con ese correo.");
    }

    @Override
    public void consultar() {
        boolean hayConductores = false;
        
        for (int i = 0; i < Usuario.usuarios.size(); i++) {
            if (Usuario.usuarios.get(i) instanceof Conductor) {
                hayConductores = true;
            }
        }
        
        if (!hayConductores) {
            System.out.println("No hay ningún conductor registrado.");
            return;
        }
        
        System.out.println("Conductores: ");
        
        for (int i = 0; i < Usuario.usuarios.size(); i++) {
            if (Usuario.usuarios.get(i) instanceof Conductor) {
                System.out.println(Usuario.usuarios.get(i).toString());
            }
        }
    }

    @Override
    public void eliminar() {
        String correo = JOptionPane.showInputDialog("Ingrese el correo del conductor que desea eliminar: ");
        boolean encontrado = false;
        
        for (int i = 0; i < Usuario.usuarios.size(); i++) {
            if (Usuario.usuarios.get(i) instanceof Conductor
                && Usuario.usuarios.get(i).getCorreo().equals(correo)) {
                Usuario.usuarios.remove(i);
                encontrado = true;
                System.out.println("Conductor eliminado exitósamente.");
            }
        }
        
        if (!encontrado) System.out.println("No se encontró ningún conductor con ese correo.");
    }
    
    @Override
    public String toString() {
        return this.getNombre() + " - " + this.getCorreo();
    }
}
