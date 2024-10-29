import Controlador.UsuarioControlador;
import database.ConexionDB;
import Modelo.UsuarioDAO;
import vista.UsuarioVista;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main_Controlador_modelo_vista_database {
    public static void main(String[] args) {
        try{
            Connection conexion = ConexionDB.getConexion();
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);
            UsuarioVista usuarioVista = new UsuarioVista();
            UsuarioControlador usuarioControlador = new UsuarioControlador(usuarioDAO, usuarioVista);

            Scanner scanner = new Scanner(System.in);
            int opcion;
            do{
                System.out.println("\n=== Menu de Gestion de Usuarios ===");
                System.out.println("1.  Mostrar usuarios ");
                System.out.println("2.  Agregar usuarios ");
                System.out.println("0.  Salir ");
                System.out.print("Selecciona una opcion:  ");
                opcion = scanner.nextInt();
                switch (opcion){
                    case 1:
                        usuarioControlador.listarUsuario();
                        break;
                    case 2:
                        usuarioControlador.agregarUsuario();
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema... ");
                        break;
                    default:
                        System.out.println("Opcion no valida. Intente de nuevo.");
                        break;
                }
            }while (opcion !=0);

            ConexionDB.cerrarConexion();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
