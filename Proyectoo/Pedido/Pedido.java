package Proyectoo.Pedido;

import Proyectoo.Base.Base;
import Proyectoo.Cliente.Cliente;
import Proyectoo.Jugo.Jugo;
import Proyectoo.Tamaño.Tamaño;

public class Pedido {
    private Cliente cliente;
    private Jugo jugo;
    private Base base;
    private Tamaño tamaño;

    public Pedido(Cliente cliente, Jugo jugo,Base base, Tamaño tamaño){
        this.cliente = cliente;
        this.jugo = jugo;
        this.base = base;
        this.tamaño = tamaño;
    }

    public double calcularPedidoTotal(){
        return jugo.getPrecioBase()+ base.getCostoAdicional()+ tamaño.getCostoAdicional();
    }

    @Override
    public String toString(){
        return cliente+ "\n" + "Jugo: " +jugo.getSabor()+ "\n" + "Tamaño: " +tamaño.getNombre() + "\n"+ "`Precio total: Bs." +calcularPedidoTotal();
    }
}
