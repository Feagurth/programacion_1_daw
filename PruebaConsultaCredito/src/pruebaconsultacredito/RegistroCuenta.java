/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaconsultacredito;

/**
 *
 * @author Super
 */
public class RegistroCuenta {

    private int cuenta;
    private String nombre;
    private String apellido;
    private double saldo;

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public RegistroCuenta() {
        this(0, "", "", 0.0f);
    }

    public RegistroCuenta(int cuenta, String nombre, String apellido, double saldo) {
        this.cuenta = cuenta;
        this.nombre = nombre;
        this.apellido = apellido;
        this.saldo = saldo;
    }

}
