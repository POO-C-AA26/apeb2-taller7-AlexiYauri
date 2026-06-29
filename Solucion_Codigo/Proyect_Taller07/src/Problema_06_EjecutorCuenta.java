/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario iTC
 */
class Cuentas{
    public String numeroCuenta;
    public String nombre;
    public double balance;

    public Cuentas(String numeroCuenta, String nombre) {
        this.numeroCuenta = numeroCuenta;
        this.nombre = nombre;
        this.balance = 0.0;
    }
    public void depositar(double valor){
        this.balance+= valor;
        System.out.println("Deposito realizado");
        System.out.println("Has depositado: "+valor);
    }
    public void retirar(double valor){
        if(valor <= this.balance){
            this.balance -= valor;
            System.out.println("Has retirado: "+valor);
            System.out.println("Tienes; "+this.balance);
        }else
            System.out.println("No tienes dinero suficiente");
    }

    @Override
    public String toString() {
        return "Cuentas{" + "numeroCuenta=" + numeroCuenta + ", nombre=" + nombre + ", balance=" + balance + '}';
    }
    
}
class Cheques extends Cuentas{

    public Cheques(String numeroCuenta, String nombre) {
        super(numeroCuenta, nombre);
    }
    public void depositar(double valor){
        this.balance+= valor;
        System.out.println("Deposito realizado");
        System.out.println("Has depositado: "+valor);
        System.out.println("Tienes; "+this.balance);
    }
    
    public void retirar(double valor){
        this.balance -= valor;
        System.out.println("Has retirado: "+valor);
        System.out.println("Tienes: "+this.balance);
    }

    @Override
    public String toString() {
        return "Cheques{" + '}'+super.toString();
    }
    
}
class Ahorros extends Cuentas{
    public double porcentajeInteres;

    public Ahorros(double porcentajeInteres, String numeroCuenta, String nombre) {
        super(numeroCuenta, nombre);
        this.porcentajeInteres = porcentajeInteres;
    }
    public void depositar(double valor){
        this.balance+= valor;
        System.out.println("Deposito realizado");
        System.out.println("Has depositado: "+valor);
        System.out.println("Tienes; "+this.balance);
    }
    public void calcularInteres(){
        this.balance = this.balance +(this.balance*(this.porcentajeInteres/100));
        System.out.println("El valor total con interes es: "+this.balance);
    }
    public void retirar(double valor){
        if(valor <= this.balance){
            this.balance -= valor;
            System.out.println("Has retirado: "+valor);
            System.out.println("Tienes; "+this.balance);
        }else
            System.out.println("No tienes dinero suficiente");
    }

    @Override
    public String toString() {
        return "Ahorros{" + "porcentajeInteres=" + porcentajeInteres + '}'+super.toString();
    }
    
}
class Platino extends Cuentas{
    public double interes ;

    public Platino( String numeroCuenta, String nombre) {
        super(numeroCuenta, nombre);
        this.interes = 10.0;
    }
    
    public void depositar(double valor){
        this.balance+= valor;
        System.out.println("Deposito realizado");
        System.out.println("Has depositado: "+valor);
        System.out.println("Tienes; "+this.balance);
    }
    public void calcularValor_Interes(){
        this.balance = this.balance +(this.balance*(this.interes/100));
        System.out.println("El valor total con interes es: "+this.balance);
    }
    public void retirar(double valor){
        this.balance -= valor;
        System.out.println("Has retirado: "+valor);
        System.out.println("Tienes: "+this.balance);
    }

    @Override
    public String toString() {
        return "Platino{" + "interes=" + interes + '}'+super.toString();
    }
    
}
public class Problema_06_EjecutorCuenta {
    public static void main(String[] args) {
        Cheques cuentaC = new Cheques("141518456446", "Alexi Yauri");
        Ahorros cuentaA = new Ahorros(13.5, "141518456545", "Alexi Yauri");
        Platino cuentaP = new Platino( "14154785964512", "Diana Buri");
        cuentaC.depositar(500);
        cuentaC.retirar(250);
        System.out.println(cuentaC.toString());
        cuentaA.depositar(1000);
        cuentaA.calcularInteres();
        cuentaA.retirar(525.5);
        System.out.println(cuentaA.toString());
        cuentaP.depositar(250.75);
        cuentaP.calcularValor_Interes();
        cuentaP.retirar(250);
        System.out.println(cuentaP.toString());
    }
}
