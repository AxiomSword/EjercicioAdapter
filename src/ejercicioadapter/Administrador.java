package ejercicioadapter;

import javax.swing.JOptionPane;

public class Administrador {

    public Administrador() {
        super();
    }
    
    private String nombre;
    private String correo;
    private String contraseña;

    public void crear() {
        System.out.println("Adaptando para adicionar administrador...");
    }

    public void actualizar() {
        System.out.println("Adaptando para modificar administrador...");
    }

    public void listar() {
        
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

        if (!encontrado) {
            System.out.println("No se encontró ningún administrador con ese correo.");
        }
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
