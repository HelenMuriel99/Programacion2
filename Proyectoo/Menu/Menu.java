package Proyectoo.Menu;

import Proyectoo.Base.Base;
import Proyectoo.BaseDeDatosJugos.BaseDeDatosJugos;
import Proyectoo.Cliente.Cliente;
import Proyectoo.Jugo.Jugo;
import Proyectoo.Pedido.Pedido;
import Proyectoo.Tamaño.Tamaño;

import java.util.Scanner;

public class Menu {
    private BaseDeDatosJugos baseDeDatosJugos;
    private Cliente cliente;
    
    public Menu(){
        baseDeDatosJugos = new BaseDeDatosJugos();
    }
    
    public void iniciar(){
        cliente = new Cliente();
        Scanner scanner = new Scanner(System.in);
        Jugo jugoSeleccionado = null;
        Base baseSeleccionada = null;
        Tamaño tamañoSeleccionado = null;
        
        while (true){
            System.out.println("\nBienvenid@ al Menú de Jugos HAPPY HEALTHY");
            System.out.println("1. *** Menú de Sabores ***");
            System.out.println("2. *** Seleccione el sabor ***");
            System.out.println("3. *** Base del Sabor (Agua o Leche ***");
            System.out.println("4. *** Tamaño del jugo ***");
            System.out.println("5. *** Precio Total de la compra ***");
            System.out.println("6. *** Salir ***");
            System.out.println("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.println("Menú de Sabores: ");
                    for (int i = 0; i < baseDeDatosJugos.getJugos().size(); i++) {
                        System.out.println((i + 1) + "." + baseDeDatosJugos.getJugos().get(i));
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el número del sabor que desea: ");
                    int saborSeleccionado = scanner.nextInt() - 1;
                    jugoSeleccionado = baseDeDatosJugos.obtenerJugo(saborSeleccionado);
                    if (jugoSeleccionado != null) {
                        System.out.println("Has seleccionado: " + jugoSeleccionado.getSabor());
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;
                case 3:
                    if (jugoSeleccionado != null) {
                        System.out.println("Selecione la base (1 para Agua, 2 para Leche");
                        int base = scanner.nextInt();
                        if (base == 1) {
                            baseSeleccionada = new Base("Agua", 0.5);
                        } else if (base == 2) {
                            baseSeleccionada = new Base("Leche", 4.0);
                        } else {
                            System.out.println("Opcion no válida.");
                        }
                    } else {
                        System.out.println("Primero seleccione un sabor (opción 2).");
                    }
                    break;
                case 4:
                    if (jugoSeleccionado != null) {
                        System.out.println("Seleccione el tamaño (1 para pequeño, 2 para mediano, 3 para grande");
                        int tamaño = scanner.nextInt();

                        switch (tamaño) {
                            case 1:
                                tamañoSeleccionado = new Tamaño("Pequeño", 5.0);
                                break;
                            case 2:
                                tamañoSeleccionado = new Tamaño("Mediano", 10.0);
                                break;
                            case 3:
                                tamañoSeleccionado = new Tamaño("Grande", 20.0);
                                break;
                            default:
                                System.out.println("Opción no válida.");
                        }
                    } else {
                        System.out.println("Primerp seleccione un sabor (opcion 2)");
                    }
                    break;
                case 5:
                    if (jugoSeleccionado != null && baseSeleccionada != null && tamañoSeleccionado != null) {
                        Pedido pedido = new Pedido(cliente, jugoSeleccionado, baseSeleccionada, tamañoSeleccionado);
                        System.out.println("Resumen del pedido: ");
                        System.out.println(pedido);
                    } else {
                        System.out.println("Primero seleccione todas las opciones (sabor, base, tamaño).");
                    }
                    break;
                case 6:
                    System.out.println("Gracias por usar el menú de Jugos HAPPY HEALTHY. ¡Hasta Luego!");
                    scanner.close();
                    break;
                default:
                    System.out.println("Opción no válida. Porfavor seleccione una opción del menú.");
                    break;
            }
            System.out.println();
        }
    }
}
