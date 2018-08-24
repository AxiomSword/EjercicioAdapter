package ejercicioadapter;

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
    }

    @Override
    public void modificar() {
        this.administrador.actualizar();
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
