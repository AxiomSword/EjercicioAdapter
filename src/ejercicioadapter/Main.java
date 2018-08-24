package ejercicioadapter;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Usuario usuario;
        
        while (true) {
            int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, 
                "Bienvenido, seleccione una opción:\n\n"
                + "1. Conductor\n"
                + "2. Pasajero\n"
                + "3. Administrador\n"
                + "0. Salir"
            ));
            
            switch (opcion) {
                case 1:
                    // Conductor
                    usuario = new Conductor();
                    
                    int opcion2 = -1;
                    
                    while (opcion2 != 0) {
                        opcion2 = Integer.parseInt(JOptionPane.showInputDialog(null, 
                            "1. Adicionar conductor\n"
                            + "2. Modificar conductor\n"
                            + "3. Consultar conductores\n"
                            + "4. Eliminar conductor\n"
                            + "0. Atraś"
                        ));
                        
                        switch (opcion2) {
                            case 1:
                                usuario.adicionar();
                                break;
                            case 2:
                                usuario.modificar();
                                break;
                            case 3:
                                usuario.consultar();
                                break;
                            case 4:
                                break;
                        }
                    }
                    break;
                case 2:
                    // Pasajero
                    
                    break;
                case 3:
                    // Administrador
                    
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
