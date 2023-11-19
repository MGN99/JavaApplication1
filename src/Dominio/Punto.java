package Dominio;

public class Punto {
    private double x,y;
    private String id;

    public Punto() {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Punto{" + "x=" + x + ", y=" + y + ", id=" + id + '}';
    }
    
    
    
    
    
    
    
    

   


    
    
    
    
}
