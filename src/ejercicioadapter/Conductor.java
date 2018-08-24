package ejercicioadapter;

import javax.swing.JOptionPane;

public class Conductor extends Usuario {
    public Conductor() {
        super();
    }
    
    @Override
    public void adicionar() {
        this.setNombre(JOptionPane.showInputDialog("Ingrese su nombre: "));
        this.setCorreo(JOptionPane.showInputDialog("Ingrese su correo institucional: "));
        this.setContraseña(JOptionPane.showInputDialog("Ingrese su contraseña: "));
        Usuario.usuarios.add(this);
    }

    @Override
    public void modificar() {
        String correo = JOptionPane.showInputDialog("Ingrese el correo del conductor que desea modificar: ");
        boolean encontrado = false;
        
        for (int i = 0; i < Usuario.usuarios.size(); i++) {
            if (Usuario.usuarios.get(i) instanceof Conductor 
                && Usuario.usuarios.get(i).getCorreo().equals(correo)) {
                Usuario.usuarios.get(i).setNombre(JOptionPane.showInputDialog("Ingrese su nombre: "));
                Usuario.usuarios.get(i).setContraseña(JOptionPane.showInputDialog("Ingrese su contraseña: "));
                encontrado = true;
            }
        } 
        
        if (!encontrado) System.out.println("No se encontró ningún conductor");
    }

    @Override
    public void consultar() {
        if (Usuario.usuarios.isEmpty()) {
            System.out.println("No hay conductores registrados.");
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
        
    }
    
    @Override
    public String toString() {
        return this.getNombre() + " - " + this.getCorreo();
    }
}
