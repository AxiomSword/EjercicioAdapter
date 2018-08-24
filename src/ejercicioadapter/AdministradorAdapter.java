package ejercicioadapter;

import javax.swing.JOptionPane;

public class AdministradorAdapter extends Usuario {
    private Administrador administrador;

    public AdministradorAdapter() {
        super();
        this.administrador = new Administrador();
    }
    
    @Override
    public void adicionar() {
        this.administrador.crear();
        this.setNombre(this.administrador.getNombre());
        this.setCorreo(this.administrador.getCorreo());
        this.setContraseña(this.administrador.getContraseña());
        Usuario.usuarios.add(this);
        JOptionPane.showMessageDialog(null, "El administrador se ha ADAPTADO y adicionado correctamente.");
    }

    @Override
    public void modificar() {
        this.administrador.actualizar();
        JOptionPane.showMessageDialog(null, "El administrador se ha ADAPTADO y modificado correctamente.");
    }

    @Override
    public void consultar() {
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
