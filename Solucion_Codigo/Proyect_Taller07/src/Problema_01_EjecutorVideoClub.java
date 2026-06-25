
import java.util.Arrays;

/**
 * Problema 02: Un videoclub dispone de una serie de películas que pueden estar 
 * en DVD (con capacidad en Gb.) o en VHS (una sola cinta por película y con 
 * cierto tipo de cinta magnetica). De las películas interesa guardar el título,
 * el autor, el año de edición y el idioma (o los idiomas, en caso de DVD). El 
 * precio de alquiler de las películas varía en función del tipo de película. 
 * Las DVD siempre son 10% mas caras que las de VHS.
 * @author Alexi Yauri
 * @version 1.0
 */
class Pelicula{
    public String titulo;
    public String autor;
    public int anioEdicion;

    public Pelicula(String titulo, String autor, int anioEdicion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioEdicion = anioEdicion;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "titulo=" + titulo + ", autor=" + autor + ", anioEdicion=" + anioEdicion + '}';
    }
    
}
class Soporte{
    public double costoAlquiler;
    public int cantidad;
    public double precio;
    public Pelicula pelicula;
    public Soporte(int cantidad, double precio, Pelicula pelicula) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.pelicula = pelicula;
    }
    public double calcularAlquiler(){
        this.costoAlquiler = this.cantidad * this.precio;
        return this.costoAlquiler;
    }
    @Override
    public String toString() {
        return "Soporte{" + "costoAlquiler=" + costoAlquiler + ", cantidad=" + cantidad + ", precio=" + precio + ", pelicula=" + pelicula + '}';
    }
}
class DVD extends Soporte{
    public String idiomas[];
    public double porcentajeRecargo;
    public DVD(String[] idiomas, double porcentajeRecargo, int cantidad, double precio, Pelicula pelicula) {
        super(cantidad, precio, pelicula);
        this.idiomas = idiomas;
        this.porcentajeRecargo = porcentajeRecargo;
    }
    public double costoAlquiler(){
        this.costoAlquiler = super.calcularAlquiler()+(this.costoAlquiler*(this.porcentajeRecargo/100));
        return this.costoAlquiler;
    }
    @Override
    public String toString() {
        return "DVD{" + "idiomas=" + Arrays.toString(idiomas) + ", recargo=" + porcentajeRecargo + '}'+super.toString();
    }
} 
class VHS extends Soporte{
    public String idioma;
    public VHS(String idioma, int cantidad, double precio, Pelicula pelicula) {
        super(cantidad, precio, pelicula);
        this.idioma = idioma;
    }
    @Override
    public String toString() {
        return "VHS{" + "idioma=" + idioma + '}'+super.toString();
    }
}
public class Problema_01_EjecutorVideoClub {
    public static void main(String[] args) {
        Pelicula peli1 = new Pelicula("El Mundial","Enrique",2026);
        String idiomas[] = {"Espaniol","Ingles"};
        DVD peliMundial = new DVD(idiomas, 10, 2,50, peli1);
        peliMundial.costoAlquiler();
        System.out.println(peliMundial);
        Pelicula peli2 = new Pelicula("Spiterman", "Alexi",2026);
        VHS Spiterman = new VHS("Espaniol",2,50, peli2);
        Spiterman.calcularAlquiler();
        System.out.println(Spiterman);      
    }
}
/**
 * Run: DVD{idiomas=[Espaniol, Ingles], recargo=10.0}Soporte{costoAlquiler=100.0, pelicula=Pelicula{titulo=El Mundial, autor=Enrique, anioEdicion=2026}}
BUILD SUCCESSFUL (total time: 0 seconds)
 */