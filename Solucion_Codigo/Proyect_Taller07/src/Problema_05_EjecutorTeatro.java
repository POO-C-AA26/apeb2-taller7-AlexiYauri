/**
 * Problema 05: Dadas las siguientes clases, que expresan una relación de 
 * herencia entre las entidades:

Se desea gestionar la venta de entradas para un espectáculo en un teatro. 
* El patio de butacas del teatro se divide en varias zonas, cada una identificada
* por su nombre. Los datos de las zonas son los mostrados en la siguiente tabla:

NOMBRE ZONA	NÚMERO DE LOCALIDADES	PRECIO NORMA	PRECIO ABONADO
Principal	200	25$	17.5$
PalcoB	40	70$	40$
Central	400	20$	14$
Lateral	100	15.5$	10$
Para realizar la compra de una entrada, un espectador debe indicar la zona que 
* desea y presentar al vendedor el documento que justifique que tiene algún tipo
* de descuento (estudiante, abonado o pensionista). El vendedor sacará la entrada
* del tipo apropiado y de la zona indicada, en el momento de la compra se asignará
* a la entrada un identificador (un número entero) que permitirá la identificación
* de la entrada en todas las operaciones que posteriormente se desee realizar con ella.

Una entrada tiene como datos asociados su identificador, la zona a la que pertenece y el nombre del comprador.

Los precios de las entradas dependen de la zona y del tipo de entrada según lo 
* explicado a continuación:

Entradas normales: su precio es el precio normal de la zona elegida sin ningún 
* tipo de descuento.
Entradas reducidas (para estudiantes o pensionistas): su precio tiene una rebaja
* del 15% sobre el precio normal de la zona elegida.
Entradas abonado: su precio es el precio para abonados de la zona elegida.
La interacción entre el vendedor y la aplicación es la descrita en los siguientes
* casos de usos.
 * @author Alexi Yauri
 * @version 1.0
 */
class Zona{
    public String nombreZona;
    public int cantidadLocalidades;
    public double precioNormal;
    public double precioAbonado;

    public Zona(String nombreZona, int cantidadLocalidades, double precioNormal, double precioAbonado) {
        this.nombreZona = nombreZona;
        this.cantidadLocalidades = cantidadLocalidades;
        this.precioNormal = precioNormal;
        this.precioAbonado = precioAbonado;
    }

    @Override
    public String toString() {
        return "Zona{" + "nombreZona=" + nombreZona + ", cantidadLocalidades=" +
                cantidadLocalidades + ", precioNormal=" + precioNormal + ", "
                + "precioAbonado=" + precioAbonado + '}';
    }
    
}
class Entrada{
    public int id;
    public Zona zona;
    public String nombreComprador;
    public int numeroEntrada;
    public double costoFinalEntrada;

    public Entrada(int id, Zona zona, String nombreComrpador, int numeroEntrada) {
        this.id = id;
        this.zona = zona;
        this.nombreComprador = nombreComrpador;
        this.numeroEntrada = numeroEntrada;
    }

    public double calcularCostoFinalEntrada(double precioEntrada){
        return this.costoFinalEntrada = precioEntrada * this.numeroEntrada;
        
    }
    @Override
    public String toString() {
        return "Entrada{" + "id=" + id + ", zona=" + zona + ", nombreComrpador="
                + nombreComprador + ", numeroEntrada=" + numeroEntrada + ", "
                + "costoFinalEntrada=" + costoFinalEntrada + '}';
    }
    
}
class Entrada_Normal extends Entrada{

    public Entrada_Normal(int id, Zona zona, String nombreComprador, int numeroEntrada) {
        super(id, zona, nombreComprador, numeroEntrada);
    }
    public double calcularCostoFinalEntrada(){
        return this.costoFinalEntrada = super.calcularCostoFinalEntrada(zona.precioNormal);
    }

    @Override
    public String toString() {
        return "Entrada_Normal{" + '}'+super.toString();
    }
    
}
class Entrada_Reducido extends Entrada{

    public double porcentajeRebaja;

    public Entrada_Reducido(double porcentajeRebaja, int id, Zona zona, String 
            nombreComprador, int numeroEntrada) {
        super(id, zona, nombreComprador, numeroEntrada);
        this.porcentajeRebaja = porcentajeRebaja;
    }
    
    public double calcularCostoFinalEntrada(){
       return this.costoFinalEntrada= (super.calcularCostoFinalEntrada(zona.precioNormal)
               - (zona.precioNormal*(this.porcentajeRebaja/100)));
    }

    @Override
    public String toString() {
        return "Entrada_Reducido{" + "porcentajeRebaja=" + porcentajeRebaja + '}'
                +super.toString();
    }
    
}
class Entrada_Abonado extends Entrada{

    public Entrada_Abonado(int id, Zona zona, String nombreComprador, int numeroEntrada) {
        super(id, zona, nombreComprador, numeroEntrada);
    }
    public double calcularCostoFinalEntrada(){
        return this.costoFinalEntrada = super.calcularCostoFinalEntrada(zona.precioAbonado); 
    }

    @Override
    public String toString() {
        return "Entrada_Abonado{" + '}'+super.toString();
    }
    
}
public class Problema_05_EjecutorTeatro {
    public static void main(String[] args) {
        Zona zona1 = new Zona("Principal",200,25,17.5);
        Zona zona2 = new Zona("PalcoB",40,70,40);
        Zona zona3 = new Zona("Central",400,20,14);
        Zona zona4 = new Zona("Lateral",100,15.5,10);
        Entrada_Normal entNormal = new Entrada_Normal(1, zona4, "Jonnathan", 2);
        Entrada_Reducido entReducido = new Entrada_Reducido(15,3 , zona2, "Adree", 2);
        Entrada_Abonado entAbonado = new Entrada_Abonado(3, zona3, "Raul y Enrique", 2);
        entNormal.calcularCostoFinalEntrada();
        entReducido.calcularCostoFinalEntrada();
        entAbonado.calcularCostoFinalEntrada();
        System.out.println(entNormal);
        System.out.println(entReducido);
        System.out.println(entAbonado);
    }
}
/**
 * Run: Entrada_Normal{}Entrada{id=1, zona=Zona{nombreZona=Lateral, cantidadLocalidades=100, precioNormal=15.5, precioAbonado=10.0}, nombreComrpador=Jonnathan, numeroEntrada=2, costoFinalEntrada=31.0}
Entrada_Reducido{porcentajeRebaja=15.0}Entrada{id=3, zona=Zona{nombreZona=PalcoB, cantidadLocalidades=40, precioNormal=70.0, precioAbonado=40.0}, nombreComrpador=Adree, numeroEntrada=2, costoFinalEntrada=129.5}
Entrada_Abonado{}Entrada{id=3, zona=Zona{nombreZona=Central, cantidadLocalidades=400, precioNormal=20.0, precioAbonado=14.0}, nombreComrpador=Raul y Enrique, numeroEntrada=2, costoFinalEntrada=28.0}
BUILD SUCCESSFUL (total time: 0 seconds)

 */