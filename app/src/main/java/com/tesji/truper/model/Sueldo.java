package com.tesji.truper.model;

public class Sueldo {
    private String nombre;
    private String tipoEmpleado;
    private int horasTra;
    private int cuota;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public int getHorasTra() {
        return horasTra;
    }

    public void setHorasTra(int horasTra) {
        this.horasTra = horasTra;
    }

    public int getCuota() {
        return cuota;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }

    public String CalcularPago(){

        String resultado="";
        int pagoNormal=0;
        int horasNormales=40;
        int horasExtras;
        double pagoHE;
        double totalPago;

        if(horasTra==40){
            pagoNormal=horasNormales*cuota;
            resultado="PAGO : "+pagoNormal;
        }else if (tipoEmpleado=="Tipo 1"){
            pagoNormal=horasNormales*cuota;
            horasExtras=horasTra-40;
            pagoHE=(1.5*cuota)*horasExtras;
            totalPago=pagoNormal+pagoHE;
            resultado="PAGO : "+ totalPago;
        }else if (tipoEmpleado=="Tipo 2"){
            pagoNormal=horasNormales*cuota;
            horasExtras=horasTra-40;
            pagoHE=(2*cuota)*horasExtras;
            totalPago=pagoNormal+pagoHE;
            resultado="PAGO : "+ totalPago;
        }else if (tipoEmpleado=="Tipo 3"){
            pagoNormal=horasNormales*cuota;
            horasExtras=horasTra-40;
            pagoHE=(2.5*cuota)*horasExtras;
            totalPago=pagoNormal+pagoHE;
            resultado="PAGO : "+ totalPago;
        }else if (tipoEmpleado=="Tipo 4"){
            pagoNormal=horasNormales*cuota;
            horasExtras=horasTra-40;
            pagoHE=(3*cuota)*horasExtras;
            totalPago=pagoNormal+pagoHE;
            resultado="PAGO : "+ totalPago;
        }

        return resultado;

    }
}



