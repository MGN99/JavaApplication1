
import Dominio.Linea;
import Dominio.Punto;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class vision extends javax.swing.JPanel {
    private ArrayList<Punto> puntos;
    private ArrayList<Linea> lineas;
    private ArrayList<String> calles = new ArrayList();
    private ArrayList<Color> colorCalles = new ArrayList();
    private double zoom = 2.0;
    private int x =700;
    private int y =700;
    private int ubiX;
    private int ubiY;
    private int click =0;
    private Punto p1 = new Punto();
    private Punto p2 = new Punto();
    private double longXP1;
    private double latiYP1;
    private double longXP2;
    private double latiYP2;
    private final int xClip;
    private final int yClip;
    private double Xmaximo;
    private double Xminimo;
    private double Ymaximo;
    private double Yminimo;
    
    /**
     * 
     * @param puntos1 lista que contiene los puntos del mapa que hemos seleccionado
     * @param lineas1 lista de que contiene los dos puntos correspondientes a una linea
     * @param x1 variable que almacena el punto x en nuestra zona de clip del mapa
     * @param y1 variable que almacena el punto y en nuestra zona de clip del mapa
     * @param maxX variable que almacena la latitud mayor del mapa seleccionado
     * @param minX variable que almacena la latitud menor del mapa seleccionado
     * @param maxY variable que almacena la longitud mayor del mapa seleccionado
     * @param minY variable que almacena la longitud mayor del mapa seleccionado
     */
    
    public vision(ArrayList<Punto> puntos1, ArrayList<Linea> lineas1, int x1, int y1, double maxX, double minX, double maxY, double minY) {
        initComponents();
        
        this.puntos = puntos1;
        this.lineas = lineas1;
        xClip = x1;
        yClip = y1;
        Xmaximo = maxX;
        Xminimo = minX;
        Ymaximo = maxY;
        Yminimo = minY;
        verificarCallesUnicas();
        colorParaCadaCalle();
        
        //cantidad de nombres de caminos
        System.out.println(calles.size());
        System.out.println(colorCalles.size());
        
        
        
    }

    /**
    * Este método sobrescrito se utiliza para realizar la representación visual
    * En este caso, se utiliza para dibujar
    * un mapa en un panel con capacidades gráficas.
    *
    * @param g El contexto gráfico utilizado para dibujar en el componente.
    */
    @Override
    protected void paintComponent(Graphics g) {
        // Llama a la implementación del método en la superclase para realizar
    // las operaciones de pintura básicas.
    super.paintComponent(g);

    // Convierte el contexto gráfico en un objeto Graphics2D para aprovechar
    // características avanzadas de dibujo.
    Graphics2D g2 = (Graphics2D) g;

    // Aplica el recorte al área de dibujo utilizando el método clippin.
    clippin(g2);

    // Realiza la traslación del sistema de coordenadas según la posición
    // especificada por las variables ubiX y ubiY.
    g2.translate(ubiX, ubiY);

    // Dibuja un punto relleno en la posición actual del sistema de coordenadas.
    g2.fillOval(-5, -5, 10, 10);

    // Escala el sistema de coordenadas según el factor de zoom especificado.
    g2.scale(zoom, zoom);

    // Llama al método creacionMapa para dibujar el mapa en el panel.
    creacionMapa(g2);
  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(102, 102, 255));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                formMouseWheelMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    //coordenada del mouse cuando mantienes el click
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        ubiX = evt.getX();
        ubiY = evt.getY();
    }//GEN-LAST:event_formMousePressed
    //movimiento en el mapa
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int xx = evt.getX() - ubiX;
        int yy = evt.getY() - ubiY;
     
        x+=xx;
        y+=yy;
        
        repaint();
    }//GEN-LAST:event_formMouseDragged
    //tamaño al hacer zoom
    private void formMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_formMouseWheelMoved
        double valor = evt.getPreciseWheelRotation();
        if(valor < 0){
            zoom *= 1.1;
        }
        else{
            zoom /= 1.1;
        }
        repaint();
    }//GEN-LAST:event_formMouseWheelMoved
    /**
     * Este método se invoca cuando se produce un clic en el mapa. 
     * Captura las coordenadas del clic y realiza acciones específicas 
     * según el número de clics registrados.
     *
     * @param evt El objeto que contiene la información del evento de clic del ratón.
     */
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        int clickX = evt.getX();
        int clickY = evt.getY();
        
        
                
        String texto = "";
        if(click < 2){            
            if(click == 0){
                Punto p = clickAPuntoCercano(clickX,clickY);
                if(p != null){
                    p1 = p;
                    longXP1 = desconvertirValoresX(p1);
                    latiYP1 = desconvertirValoresY(p1);
                    System.out.println("P1: "+longXP1+" "+latiYP1);
                    
                }
            }
            if(click == 1){
                Punto pp = clickAPuntoCercano(clickX,clickY);
                if(pp != null){
                    p2 = pp;
                    longXP2 = desconvertirValoresX(p2);
                    latiYP2 = desconvertirValoresY(p2);
                    System.out.println("P2: "+longXP2+" "+latiYP2);
                }
            }
            
            click++;
        }
        
        
        
        if(click == 2){
            double distancia = calcularDistanciaHaversine();
            
            texto+= "Punto 1: "+p1.getId()+" ID \nCoordenada X: "+longXP1+"\n                       Y: "+latiYP1+
            "\n-----------------------------------------------------------\n"
            + "Punto 2: "+p2.getId()+" ID \nCoordenada x: "+longXP2+"\n                       Y: "+latiYP2+"\n"
            + "La distancia entre los dos puntos es de "+distancia+" km";
        
            JOptionPane.showMessageDialog(this,texto);
            click =0;
            longXP1 =0;
            latiYP1 =0;
            longXP2 =0;
            latiYP2 =0;
            p1 = null;
            p2 = null;
        }
        
    }//GEN-LAST:event_formMouseClicked
    
    /**
 * Verifica  las calles unicas en una lista de líneas.
 * Itera sobre la lista de líneas y agrega el nombre de las calles 
 * únicas a una lista si no se encuentran previamente.
 */
    private void verificarCallesUnicas(){
        
        for(Linea edge: lineas){
            boolean found = false;
            found = buscarCalle(found,edge);
            if(!found){
                calles.add(edge.getNombre());
            }
        }
    }
     
    /**
    * Busca una calle en la lista de calles mediante comparación de nombres.
    *
    * @param found Un indicador booleano que se establece en true si la calle se encuentra, de lo contrario, permanece en false.
    * @param edge La línea (calle) que se está buscando en la lista.
    * @return true si la calle se encuentra en la lista de calles, de lo contrario, false.
    */
    private boolean buscarCalle(boolean found, Linea edge) {
        for(int i=0;i<calles.size();i++){          
            if(calles.get(i).equalsIgnoreCase(edge.getNombre())){
                found = true;
                return found;
            }
        }
        return false;
    }
    
    /**
    * Asigna un color aleatorio a cada calle única en la lista de calles.
    * Itera sobre la lista de calles y genera un color aleatorio para cada calle,
    * asegurándose de que no se repitan los colores para calles diferentes.
    */
    private void colorParaCadaCalle() {
        for(int i=0;i<calles.size();i++){
                      
            int color1 = (int) (Math.random() * 256);
            int color2 = (int) (Math.random() * 256);
            int color3 = (int) (Math.random() * 256);
            Color color = new Color(color1, color2, color3);
            boolean found = false;
            found = buscarColor(found,color);
            if(!found){
                colorCalles.add(color);
            }
            
        }
        
    }
    /**
    * Busca un color en la lista de colores asignados a calles mediante comparación de igualdad.
    *
    * @param found Un indicador booleano que se establece en true si el color se encuentra, de lo contrario, permanece en false.
    * @param color El color que se está buscando en la lista.
    * @return true si el color se encuentra en la lista de colores, de lo contrario, false.
    */
    private boolean buscarColor(boolean found,Color color) {
        for(Color c: colorCalles){
            if(c.equals(color)){
                found = true;
                return found;
            }
        }
        return false;
    }
    
    /**
    * Crea la representación gráfica del mapa, dibujando puntos y líneas en el panel.
    *
    * @param g2 El contexto gráfico utilizado para realizar el dibujo.
    */
    private void creacionMapa(Graphics g2) {
        g2.setColor(Color.BLACK);
        
        for (Punto punto : puntos) {
            int px = x - (int) punto.getX();
            int py = y - (int) punto.getY();
            g2.fillOval(px, py, 4, 4);
        }

        for(int i=0;i<calles.size();i++){
             for (Linea linea : lineas) {
                 if(linea.getNombre().equalsIgnoreCase(calles.get(i))){
                        g2.setColor(colorCalles.get(i));
                        Punto p1 = linea.getP1();
                        Punto p2 = linea.getP2();

                        int x1 = x - (int) p1.getX();
                        int y1 = y - (int) p1.getY();
                        int x2 = x - (int) p2.getX();
                        int y2 = y - (int) p2.getY();
                        g2.drawLine(x1, y1, x2, y2);
                 }
                
            }
        }
        
        /*g2.setColor(Color.red);
        for (Linea linea : lineas) {
            Punto p1 = linea.getP1();
            Punto p2 = linea.getP2();

            int x1 = x - (int) p1.getX();
            int y1 = y - (int) p1.getY();
            int x2 = x - (int) p2.getX();
            int y2 = y - (int) p2.getY();
            g2.drawLine(x1, y1, x2, y2);

        }*/
       
        
        
    }
    /**
    * Realiza un recorte en el mapa mediante la configuración de un área recortada y lo muestra con un borde verde.
    *
    * @param g2 El contexto gráfico utilizado para realizar el recorte y el dibujo.
    */
    private void clippin(Graphics2D g2) {
        //recorte en el mapa
        Shape clip = new Rectangle(0,0,xClip,yClip);
        g2.setClip(clip);
        g2.setColor(Color.GREEN);
        g2.draw(clip);
    }

    /**
    * Encuentra el punto más cercano a las coordenadas del clic en el mapa.
    *
    * @param clickX La coordenada X del clic en el mapa.
    * @param clickY La coordenada Y del clic en el mapa.
    * @return El punto más cercano a las coordenadas del clic, o null si no se encuentra ningún punto.
    */
    private Punto clickAPuntoCercano(int clickX, int clickY) {
        System.out.println("Click en coord: "+clickX+" "+clickY);
        double distanCorta = 9999999.9;
        Punto punto = null;
        
        for(Punto p : puntos){
            int px = (int) p.getX();
            int py = (int) p.getY();
            
            double distan = Math.sqrt(Math.pow(x - px, 2) + Math.pow(y - py, 2));
           
            if(distan < distanCorta){
                punto = p;
                distanCorta = distan;
            }
        }
        
        return punto;
    }

    /**
    * Desconvierte la coordenada X de un punto en el rango [0, 1000] a su valor original en el rango [Xminimo, Xmaximo].
    *
    * @param p El punto que contiene la coordenada X a desconvertir.
    * @return El valor original de la coordenada X en el rango [Xminimo, Xmaximo].
    */
    private double desconvertirValoresX(Punto p) {
        double x =  p.getX()/ 1000;
        //double y = 1.0 - (p.getY() / 1000);

        double longitud = (x * (Xmaximo - Xminimo)) + Xminimo;
        //double latitud = (y * (Ymaximo - Yminimo)) + Yminimo;
        //p.setX(longitud);
        //p.setY(latitud);
        return longitud;
    }
    
    /**
    * Desconvierte la coordenada y de un punto en el rango [0, 1000] a su valor original en el rango [Yminimo, Ymaximo].
    *
    * @param p El punto que contiene la coordenada Y a desconvertir.
    * @return El valor original de la coordenada Y en el rango [Yminimo, Ymaximo].
    */
    private double desconvertirValoresY(Punto p) {
        double y = 1.0 - (p.getY() / 1000);
        double latitud = (y * (Ymaximo - Yminimo)) + Yminimo;
        return latitud;
    }
    
    /**
    * Calcula la distancia en kilómetros entre dos puntos geográficos utilizando la fórmula de Haversine.
    * 
    * @return La distancia en kilómetros entre los puntos representados por (latiYP1, longXP1) y (latiYP2, longXP2).
    */
    private double calcularDistanciaHaversine() {
        double latitudEnRadianes1 = Math.toRadians(latiYP1);
        double longitudEnRadianes1 = Math.toRadians(longXP1);
        double latitudEnRadianes2 = Math.toRadians(latiYP2);
        double longitudEnRadianes2 = Math.toRadians(longXP2);

        double diferenciaLatitud = latitudEnRadianes2 - latitudEnRadianes1;
        double diferenciaLongitud = longitudEnRadianes2 - longitudEnRadianes1;

        double a = Math.pow(Math.sin(diferenciaLatitud / 2), 2) +
                   Math.cos(latitudEnRadianes1) * Math.cos(latitudEnRadianes2) *
                   Math.pow(Math.sin(diferenciaLongitud / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        c*= 6371;
        return c;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
