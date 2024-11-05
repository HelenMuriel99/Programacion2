package Proyectoo.Cliente;

import java.util.Scanner;

public class Cliente {
    private String nombre;
    private String telefono;

    public Cliente(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su nombre: ");
        this.nombre = scanner.nextLine();
        System.out.print("Ingrese su número telefónico");
        this.telefono = scanner.nextLine();
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString(){
        return "Cliente: " +nombre+ "Teléfono: " +telefono;
    }
}
