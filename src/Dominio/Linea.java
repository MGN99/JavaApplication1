package Dominio;

public class Linea {
    private Punto p1,p2;
    private String id;
    private String nombre;
    
    
    
    public Linea(){
        p1 = null;
        p2 = null;
        this.nombre = "";
    }

    public Punto getP1() {
        return p1;
    }

    public void setP1(Punto p1) {
        this.p1 = p1;
    }

    public Punto getP2() {
        return p2;
    }

    public void setP2(Punto p2) {
        this.p2 = p2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
    

    public String mostrar(){
        return "Punto 1: "+p1.getId()+" Punto 2: "+p2.getId()+" ID: "+id+" Nombre: "+nombre;
    }
    
    
}
