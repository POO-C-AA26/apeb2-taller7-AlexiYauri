
/**
 * Problema 03: Implemente un sistema de envío de mensajes a móviles. Existen 
 * dos tipos de mensajes que se pueden enviar entre móviles, mensajes de texto 
 * (SMS) y mensajes que contienen imágenes (MMS). Por un lado, los mensajes de 
 * texto contienen un mensaje en caracteres que se desea enviar de un móvil a otro.
 * Por otro lado, los mensajes que contienen imágenes almacenan información sobre
 * la imagen a enviar, la cual se representará por el nombre del fichero que la
 * contiene. Independientemente del tipo de mensaje, cada mensaje tendrá asociado
 * un remitente de dicho mensaje y un destinatario. Ambos estarán definidos 
 * obligatoriamente por un número de móvil, y opcionalmente se podrá guardar 
 * información sobre su nombre. Además, los métodos enviarMensaje y visualizarMensaje
 * deben estar definidos.
 * @author Alexi Yauri
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