package ejercicioadapter;

import javax.swing.JOptionPane;

public class AdministradorAdapter extends Usuario {
    private Administrador administrador;
    String mensaje;

    public AdministradorAdapter() {
        super();
        this.administrador = new Administrador();
    }
    
    @Override
    public String adicionar(String nombre, String correo, String contraseña) {
        this.setNombre(nombre);
        this.setCorreo(correo);
        this.setContraseña(contraseña);
        Usuario.usuarios.add(this);
        this.administrador.crear();
        return "Se ha adicionado un administrador exitósamente.";
    }

    @Override
    public String modificar(String correo) {
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

        if (!encontrado) {
            System.out.println("No se encontró ningún administrador con ese correo.");
        }
        
        this.administrador.actualizar();
        return "El administrador se ha ADAPTADO y modificado correctamente.";
    }

    @Override
    public String consultar() {
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
        
        this.administrador.listar();
    }

    @Override
    public void eliminar() {
        this.administrador.quitar();
    }
    
    @Override
    public String toString() {
        return this.getNombre() + " - " + this.getCorreo();
    }
}
