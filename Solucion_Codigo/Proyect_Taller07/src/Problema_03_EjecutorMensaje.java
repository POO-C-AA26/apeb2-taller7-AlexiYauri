
/**
 * 
 * @author Usuario iTC
 * @version 1.0
 */
class Telefono{
    public String numeroTelefono;
    public String nombre;

    public Telefono(String numeroTelefono, String nombre) {
        this.numeroTelefono = numeroTelefono;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Telefono{" + "numeroTelefono=" + numeroTelefono + ", nombre=" + nombre + '}';
    }
    
}
class Mensaje{
    public Telefono remitente;
    public Telefono destinatario;

    public Mensaje(Telefono remitente, Telefono destinatario) {
        this.remitente = remitente;
        this.destinatario = destinatario;
    }
    public void enviarMensaje(){
        System.out.println("------------------");
        System.out.println("Enviando mensaje...");
    }
    public void visualizarMensaje(){
        
        System.out.println("De: "+this.remitente.toString());
        System.out.println("Para: "+this.destinatario.toString());
    }
}
class SMS extends Mensaje{
    public String texto;

    public SMS(String texto, Telefono remitente, Telefono destinatario) {
        super(remitente, destinatario);
        this.texto = texto;
    }

    
    public void enviarMensaje(){
        super.enviarMensaje();
        System.out.println("Mensaje Enviado...");
    }
    public void visualizarMensaje(){
        super.visualizarMensaje();
        System.out.println("Tipo: Mensaje de Texto (SMS)");
        System.out.println("Contenido: " + this.texto);
    }
    
}
class MMS extends Mensaje{
    public String nombreFichero;

    public MMS(String nombreFichero, Telefono remitente, Telefono destinatario) {
        super(remitente, destinatario);
        this.nombreFichero = nombreFichero;
    }

    
    public void enviarMensaje(){
        super.enviarMensaje();
        System.out.println("Mensaje Enviado...");
    }
    public void visualizarMensaje(){
        
        super.visualizarMensaje();
        System.out.println("Tipo: Mensaje de imagen MMS");
        System.out.println("Nombre de Fichero: "+this.nombreFichero);
    }
}
public class Problema_03_EjecutorMensaje {
    public static void main(String[] args) {
        Telefono tl1 = new Telefono("0990037615","Alexi");
        Telefono tl2 = new Telefono("0990037615","Diana");
        SMS mensaje1 = new SMS("Hola que tal", tl1, tl2);
        mensaje1.enviarMensaje();
        mensaje1.visualizarMensaje();
        MMS mensaje2 = new MMS("diagrama_uml_herencia.png", tl1, tl2);
        mensaje2.enviarMensaje();
        mensaje2.visualizarMensaje();
    }
}

/**
 * run:
------------------
Enviando mensaje...
Mensaje Enviado...
De: Telefono{numeroTelefono=0990037615, nombre=Alexi}
Para: Telefono{numeroTelefono=0990037615, nombre=Diana}
Tipo: Mensaje de Texto (SMS)
Contenido: Hola que tal
------------------
Enviando mensaje...
Mensaje Enviado...
De: Telefono{numeroTelefono=0990037615, nombre=Alexi}
Para: Telefono{numeroTelefono=0990037615, nombre=Diana}
Tipo: Mensaje de imagen MMS
Nombre de Fichero: diagrama_uml_herencia.png
BUILD SUCCESSFUL (total time: 0 seconds)

 */