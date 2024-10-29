package vista;

import Modelo.Usuario;
import Modelo.UsuarioDAO;

import java.util.List;

public class UsuarioVista {

    public  void  mostrarUsuarios(List<Usuario> usuarios){
        System.out.println("\n*** Lista de Usuarios ***");
        if (usuarios.isEmpty()){
            System.out.println("No hay usuarios registrados.");
        }else{
            System.out.println("-----------------------------------------------------");
            System.out.printf(" %5s | %15s | %25s |\n", "ID" , "NOMBRE", "EMAIL");
            System.out.println("-----------------------------------------------------");
            for (Usuario usuario : usuarios){
                System.out.printf(" %5s | %15s | %25s |\n", usuario.getId(),usuario.getNombre(), usuario.getEmail());
                System.out.println("-----------------------------------------------------");
            }
        }
    }
}
