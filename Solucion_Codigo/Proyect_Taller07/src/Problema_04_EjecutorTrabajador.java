/**
 * Problema 04: Se desea desarrollar un sistema de nómina para los trabajadores 
 * de una empresa. Los datos personales de los trabajadores son nombre y apellidos,
 * dirección y DNI. Además, existen diferentes tipos de trabajadores:
 *Fijos Mensuales: que cobran una cantidad fija al mes.
 *Comisionistas: cobran un porcentaje fijo por las ventas que han realizado
 *Por Horas: cobran un precio por cada una de las horas que han realizado durante 
 * el mes. El precio es fijo para las primeras 40 horas y es otro para las horas
 * realizadas a partir de la 40 hora mensual.
 *Jefe: cobra un sueldo fijo (no hay que calcularlo). Cada empleado tiene 
 * obligatoriamente un jefe (exceptuando los jefes que no tienen ninguno). El 
 * programa debe permitir dar de alta a trabajadores, así como fijar horas o 
 * ventas realizadas e imprimir la nómina correspondiente al final de mes.
 * @author Alexi Yauri
 * @version 1.0
 */
class Trabajador{
    public String nombres_Apellidos;
    public String direccion;
    public String dni;
    public Jefe jefe;

    public Trabajador() {
    }
    
    public Trabajador(String nombres_Apellidos, String direccion, String dni, Jefe jefe) {
        this.nombres_Apellidos = nombres_Apellidos;
        this.direccion = direccion;
        this.dni = dni;
        this.jefe = jefe;
    }  
    public double calcularSalario(){
        return 0.0;
    }
    public void mostrarResumen(Trabajador t){
        System.out.println(t.toString());
        System.out.printf("Sueldo final de mes: $%.2f\n", t.calcularSalario());
        System.out.println("-------------------------------------------------------------------");
    }
    @Override
    public String toString() {
        String nombreJefe = (jefe != null) ? jefe.nombres_Apellidos : "Ninguno (Es el Gerente)";
        return "Trabajador{" + "nombres_Apellidos=" + nombres_Apellidos + ", "
                + "direccion=" + direccion + ", dni=" + dni + ", jefe=" + jefe + '}';
    }
}
class Jefe extends Trabajador{
    public double sueldoFijo;
    public Jefe(double sueldoFijo, String nombres_Apellidos, String direccion, String dni) {
        super(nombres_Apellidos, direccion, dni, null);
        this.sueldoFijo = sueldoFijo;
    }
    public double calcularSalario(){
        return this.sueldoFijo;
    }   

    @Override
    public String toString() {
        return "Jefe{" + "sueldoFijo=" + sueldoFijo + '}'+super.toString();
    }
    
}
class TrabajadorFijo extends Trabajador{ 
    public double salarioFijoM;
    public TrabajadorFijo(double salarioFijoM, String nombres_Apellidos, String direccion, String dni, Jefe jefe) {
        super(nombres_Apellidos, direccion, dni, jefe);
        this.salarioFijoM = salarioFijoM;
    }
    public double calcularSalario(){
        return this.salarioFijoM;
    }

    @Override
    public String toString() {
        return "TrabajadorFijo{" + "salarioFijoM=" + salarioFijoM + '}'+super.toString();
    }
    
}

class Comisionistas extends Trabajador{
    public int ventas;
    public double comision;
    public Comisionistas(int ventas, double comision, String nombres_Apellidos, String direccion, String dni, Jefe jefe) {
        super(nombres_Apellidos, direccion, dni, jefe);
        this.ventas = ventas;
        this.comision = comision;
    }  
    public double calcularSalario(){
        return this.ventas*(this.comision/100);
    }        

    @Override
    public String toString() {
        return "Comisionistas{" + "ventas=" + ventas + ", comision=" + comision + '}'+super.toString();
    }
    
}
class TrabajadorHoras extends Trabajador{
    public int horas;
    public double precioHora_Normal;
    public double precioHora_Extra;
    public TrabajadorHoras(int horas, double precioHora_Normal, double precioHora_Extra, String nombres_Apellidos, String direccion, String dni, Jefe jefe) {
        super(nombres_Apellidos, direccion, dni, jefe);
        this.horas = horas;
        this.precioHora_Normal = precioHora_Normal;
        this.precioHora_Extra = precioHora_Extra;
    }   
    public double calcularSalario() {
        if (this.horas <= 40) {
            return this.horas * this.precioHora_Normal;
        } else {
            int horasNormales = 40;
            int horasExtras = this.horas - 40;
            return (horasNormales * this.precioHora_Normal) + (horasExtras * this.precioHora_Extra);
        }
    }

    @Override
    public String toString() {
        return "TrabajadorHoras{" + "horas=" + horas + ", precioHora_Normal=" +
                precioHora_Normal + ", precioHora_Extra=" + precioHora_Extra + '}'+super.toString();
    }
    
}
public class Problema_04_EjecutorTrabajador {
    public static void main(String[] args) {
        Jefe jefe1 = new Jefe(540, "Alexi Yauri", "Santiago Fernandez", "1106057513");
        TrabajadorFijo trabajador = new TrabajadorFijo(540, "Pedro Cueva", "AV de los Paltas", "1105047518", jefe1);
        Comisionistas comisionista = new Comisionistas(150, 10, "Diana Espinoza", "San Sebastián", "1107778882", jefe1);
        TrabajadorHoras trabajadorH = new TrabajadorHoras(40, 20, 25, "Adrián Uchuari", "El Sagrario", "1109990003", jefe1);
        trabajador.calcularSalario();
        comisionista.calcularSalario();
        trabajadorH.calcularSalario();
        Trabajador trabajador1 = new Trabajador();
        trabajador1.mostrarResumen(jefe1);
        trabajador1.mostrarResumen(trabajador);
        trabajador1.mostrarResumen(comisionista);
        trabajador1.mostrarResumen(trabajadorH);
    }
}

/**
 * run:
Jefe{sueldoFijo=540.0}Trabajador{nombres_Apellidos=Alexi Yauri, direccion=Santiago Fernandez, dni=1106057513, jefe=null}
Sueldo final de mes: $540,00
-------------------------------------------------------------------
TrabajadorFijo{salarioFijoM=540.0}Trabajador{nombres_Apellidos=Pedro Cueva, direccion=AV de los Paltas, dni=1105047518, jefe=Jefe{sueldoFijo=540.0}Trabajador{nombres_Apellidos=Alexi Yauri, direccion=Santiago Fernandez, dni=1106057513, jefe=null}}
Sueldo final de mes: $540,00
-------------------------------------------------------------------
Comisionistas{ventas=150, comision=10.0}Trabajador{nombres_Apellidos=Diana Espinoza, direccion=San Sebasti�n, dni=1107778882, jefe=Jefe{sueldoFijo=540.0}Trabajador{nombres_Apellidos=Alexi Yauri, direccion=Santiago Fernandez, dni=1106057513, jefe=null}}
Sueldo final de mes: $15,00
-------------------------------------------------------------------
TrabajadorHoras{horas=40, precioHora_Normal=20.0, precioHora_Extra=25.0}Trabajador{nombres_Apellidos=Adri�n Uchuari, direccion=El Sagrario, dni=1109990003, jefe=Jefe{sueldoFijo=540.0}Trabajador{nombres_Apellidos=Alexi Yauri, direccion=Santiago Fernandez, dni=1106057513, jefe=null}}
Sueldo final de mes: $800,00
-------------------------------------------------------------------
BUILD SUCCESSFUL (total time: 0 seconds)

 */