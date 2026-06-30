
/**
 *
 * @author Usuario iTC
 */
import java.util.ArrayList;
import java.util.List;
class ComponenteSeccion {
    // Clase base abstracta para permitir la extensión a futuros componentes
}
class Parrafo extends ComponenteSeccion {
    private List<Sentencia> sentencias;

    public Parrafo() {
        this.sentencias = new ArrayList<>();
    }

    public void agregarSentencia(Sentencia s) {
        this.sentencias.add(s);
    }

    public List<Sentencia> getSentencias() {
        return sentencias;
    }
}

class Figura extends ComponenteSeccion {
    private String url;
    private String pieDeFoto;

    public Figura(String url, String pieDeFoto) {
        this.url = url;
        this.pieDeFoto = pieDeFoto;
    }

    public String getUrl() { return url; }
    public String getPieDeFoto() { return pieDeFoto; }
}

// Futuros componentes 
//class Tabla extends ComponenteSeccion { 
//}
//class Lista extends ComponenteSeccion {
//}
class Sentencia {
    public List<Palabra> palabras;
    public Sentencia() {
        this.palabras = new ArrayList<>();
    }

    public void agregarPalabra(Palabra p) {
        this.palabras.add(p);
        p.vincularASeccion(this); 
    }

    public List<Palabra> getPalabras() {
        return palabras;
    }
    
    public String getTextoSentencia() {
        StringBuilder sb = new StringBuilder();
        for (Palabra p : palabras) {
            sb.append(p.getTexto()).append(" ");
        }
        return sb.toString().trim() + ".";
    }
}

class Palabra {
    private String texto;
    private List<Sentencia> sentenciasDondeAparece;

    public Palabra(String texto) {
        this.texto = texto;
        this.sentenciasDondeAparece = new ArrayList<>();
    }

    public String getTexto() {
        return texto;
    }

    public void vincularASeccion(Sentencia s) {
        if (!sentenciasDondeAparece.contains(s)) {
            this.sentenciasDondeAparece.add(s);
        }
    }

    public int getFrecuenciaUso() {
        return sentenciasDondeAparece.size();
    }
}
class Seccion {
    private String nombre;
    private List<ComponenteSeccion> componentes;

    public Seccion(String nombre) {
        this.nombre = nombre;
        this.componentes = new ArrayList<>();
    }

    public void agregarComponente(ComponenteSeccion componente) {
        this.componentes.add(componente);
    }

    public String getNombre() { return nombre; }
    public List<ComponenteSeccion> getComponentes() { return componentes; }
}

class Capitulo {
    private String titulo;
    private List<Seccion> secciones;

    public Capitulo(String titulo) {
        this.titulo = titulo;
        this.secciones = new ArrayList<>();
    }

    public void agregarSeccion(Seccion s) {
        this.secciones.add(s);
    }

    public String getTitulo() { return titulo; }
    public List<Seccion> getSecciones() { return secciones; }
}
public class Problema_01_EjecutorLibro {
    public static void main(String[] args) {
        System.out.println("---SISTEMA DE LIBROS--- ");
        Capitulo capitulo1 = new Capitulo("Problema 01");
        Seccion seccion1 = new Seccion("1.1 Gestion libros");
        capitulo1.agregarSeccion(seccion1);
        Palabra p1 = new Palabra("Hola");
        Palabra p2 = new Palabra("este");
        Palabra p3 = new Palabra("es");
        Palabra p4 = new Palabra("el");
        Palabra p5 = new Palabra("primer");
        Palabra p6 = new Palabra("problema");      
        Sentencia s1 = new Sentencia();
        s1.agregarPalabra(p1); 
        s1.agregarPalabra(p2); 
        s1.agregarPalabra(p3); 
        s1.agregarPalabra(p4); 
        Sentencia s2 = new Sentencia();
        s2.agregarPalabra(p1); 
        s2.agregarPalabra(p2); 
        Sentencia s3 = new Sentencia();
        s3.agregarPalabra(p1); 
        s3.agregarPalabra(p5); 
        s3.agregarPalabra(p6); 
        Parrafo parrafo1 = new Parrafo();
        parrafo1.agregarSentencia(s1);
        parrafo1.agregarSentencia(s2);
        parrafo1.agregarSentencia(s3);
        Figura figura1 = new Figura("https://share.google/XX6whue43GSrAxvlY", "Figura 1: Jerarquia de clases");
        seccion1.agregarComponente(parrafo1);
        seccion1.agregarComponente(figura1);
        System.out.println("CAPITULO: " + capitulo1.getTitulo());
        for (Seccion sec : capitulo1.getSecciones()) {
            System.out.println("\nSECCION: " + sec.getNombre());
            for (ComponenteSeccion comp : sec.getComponentes()) {
                if (comp instanceof Parrafo) {
                    System.out.println("Contenido del Parrafo:");
                    Parrafo p = (Parrafo) comp;
                    for (Sentencia sent : p.getSentencias()) {
                        System.out.println(" -" + sent.getTextoSentencia());
                    }
                } else if (comp instanceof Figura) {
                    Figura f = (Figura) comp;
                    System.out.println("\nFigura:");
                    System.out.println("  URL: " + f.getUrl());
                    System.out.println("  Leyenda: " + f.getPieDeFoto());
                }
            }
        }
        System.out.println("\n=========================================================");
        System.out.println("---COMPROBACION---");
        System.out.println("La palabra '" + p1.getTexto() + "' se vuelve a usar en: " + p1.getFrecuenciaUso() + " sentencias distintas.");
        System.out.println("La palabra '" + p2.getTexto() + "' se vuelve a usar en: " + p2.getFrecuenciaUso() + " sentencias distintas.");
    }
}

/**
 * run:
---SISTEMA DE LIBROS--- 
CAPITULO: Problema 01

SECCION: 1.1 Gestion libros
Contenido del Parrafo:
 -Hola este es el.
 -Hola este.
 -Hola primer problema.

Figura:
  URL: https://share.google/XX6whue43GSrAxvlY
  Leyenda: Figura 1: Jerarquia de clases

=========================================================
---COMPROBACION---
La palabra 'Hola' se vuelve a usar en: 3 sentencias distintas.
La palabra 'este' se vuelve a usar en: 2 sentencias distintas.
BUILD SUCCESSFUL (total time: 0 seconds)

 */