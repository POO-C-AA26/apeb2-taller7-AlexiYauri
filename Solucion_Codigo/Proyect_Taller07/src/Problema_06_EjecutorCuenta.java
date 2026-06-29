/**
 * Problema 06: El banco UN BANCO mantiene las cuentas de varios clientes. Los 
 * datos que describen a cada una de las cuentas consisten en el número de cuenta,
 * el nombre del cliente y el balance actual. Escriba una clase para implementar
 * dicha cuenta bancaria. El método constructor debe aceptar como parámetros el
 * número de cuenta y el nombre. Debe proporcionarse métodos para depositar o 
 * retirar una cantidad de dinero y obtener el balance actual.

El banco ofrece a sus clientes dos tipos de cuentas, una de CHEQUES y una de 
* AHORROS. Una cuenta de cheques puede sobregirarse (el balance puede ser menor
* que cero), pero una cuenta de ahorros no. Al final de cada mes, se calcula el
* interés sobre la cantidad que tenga la cuenta de ahorros. Este interés se suma
* al balance. Escriba clases para describir cada uno de estos tipos de cuentas, 
* haciendo un máximo uso de la herencia. La clase de la cuenta de ahorros debe 
* proporcionar un método que sea invocado para calcular el interés. Además, el 
* banco está pensando en implementar una cuenta PLATINO que viene siendo similar
* a los otros dos tipos anteriores de cuentas bancarias, ésta tiene el interés del
* 10%, sin cargos ni castigos por sobregiro.
 * @author Usuario iTC
 * @version 1.0
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
    public void calcularInteres(){
        this.balance = this.balance +(this.balance*(this.porcentajeInteres/100));
        System.out.println("El valor total con interes es: "+this.balance);
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
    
    public void calcularValor_Interes(){
        this.balance = this.balance +(this.balance*(this.interes/100));
        System.out.println("El valor total con interes es: "+this.balance);
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

/**
 * run:
Deposito realizado
Has depositado: 500.0
Tienes; 500.0
Has retirado: 250.0
Tienes: 250.0
Cheques{}Cuentas{numeroCuenta=141518456446, nombre=Alexi Yauri, balance=250.0}
Deposito realizado
Has depositado: 1000.0
Tienes; 1000.0
El valor total con interes es: 1135.0
Has retirado: 525.5
Tienes; 609.5
Ahorros{porcentajeInteres=13.5}Cuentas{numeroCuenta=141518456545, nombre=Alexi Yauri, balance=609.5}
Deposito realizado
Has depositado: 250.75
Tienes; 250.75
El valor total con interes es: 275.825
Has retirado: 250.0
Tienes: 25.82499999999999
Platino{interes=10.0}Cuentas{numeroCuenta=14154785964512, nombre=Diana Buri, balance=25.82499999999999}
BUILD SUCCESSFUL (total time: 0 seconds)

 */