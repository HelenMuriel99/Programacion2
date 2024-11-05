package Proyectoo.Base;

public class Base {
    private String tipo;
    private double costoAdicional;

    public Base(String tipo, double costoAdicional){
        this.tipo = tipo;
        this.costoAdicional = costoAdicional;
    }

    public String getTipo() {
        return tipo;
    }

    public double getCostoAdicional() {
        return costoAdicional;
    }

    @Override
    public String toString(){
        return tipo+ "(Costo adicional: Bs." +costoAdicional+ ")";
    }
}
