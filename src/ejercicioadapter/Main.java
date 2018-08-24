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
            
            int opcion2;
            
            switch (opcion) {
                case 1: // Conductor
                    usuario = new Conductor();
                    opcion2 = -1;
                    
                    while (opcion2 != 0) {
                        opcion2 = Integer.parseInt(JOptionPane.showInputDialog(null, 
                            "Menú conductor\n\n"
                            + "1. Adicionar conductor\n"
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
                                usuario.eliminar();
                                break;
                        }
                    }
                    
                    break;
                case 2: // Pasajero
                    usuario = new Pasajero();
                    opcion2 = -1;
                    
                    while (opcion2 != 0) {
                        opcion2 = Integer.parseInt(JOptionPane.showInputDialog(
                            "Menú pasajero\n\n"
                            + "1. Adicionar pasajero\n"
                            + "2. Modificar pasajero\n"
                            + "3. Consultar pasajeros\n"
                            + "4. Eliminar pasajero\n"
                            + "0. Atrás"
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
                                usuario.eliminar();
                                break;
                        }
                    }
                    
                    break;
                case 3: // Administrador
                    usuario = new AdministradorAdapter();
                    opcion2 = -1;
                    
                    while (opcion2 != 0) {
                        opcion2 = Integer.parseInt(JOptionPane.showInputDialog(
                            "Menú administrador\n\n"
                            + "1. Adicionar administrador\n"
                            + "2. Modificar administrador\n"
                            + "3. Consultar administrador\n"
                            + "4. Eliminar administrador\n"
                            + "0. Atrás"
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
                                usuario.eliminar();
                                break;
                        }
                    }
                    
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
