package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private Connection conexion;

    public UsuarioDAO(Connection conexion){
        this.conexion = conexion;
    }

    public List<Usuario> obtenerUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT id, nombre, email FROM usuario";

        try(PreparedStatement statement = conexion.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()){

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("Nombre");
                String email = resultSet.getString("email");
                Usuario usuario = new Usuario(id, nombre, email);
                usuarios.add(usuario);
            }
        }catch (SQLException e){
            throw new RuntimeException("Error al obtener los usuario" +e.getMessage(), e);

        }
        return usuarios;
    }

    public void agregarUsuario(String nombre, String email) throws SQLException{
        String sql = "INSERT INTO usuario(nombre, email) VALUES(?,?)";

        try(PreparedStatement stmt = conexion.prepareStatement(sql)){
            stmt.setString(1, nombre);
            stmt.setString(2, email);
            stmt.execute();
        }catch (SQLException e){
            throw new RuntimeException("Error al obtener los usuarios" +e.getMessage(), e);
        }
    }
}
