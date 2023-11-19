
import Dominio.Linea;
import Dominio.Punto;
import Dominio.lineaHandler;
import Dominio.puntoHandler;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Clase Enter que representa la interfaz gráfica principal de la aplicación.
 * Permite la carga de archivos locales y remotos, así como la visualización de un mapa.
 */
public class Enter extends javax.swing.JFrame{
    private ArrayList<Punto> puntos = new ArrayList();
    private ArrayList<Punto> puntosCoord;
    private ArrayList<Linea> lineas = new ArrayList();
    private double maxX = -999999;
    private double maxY = -999999;
    private double minX = 9999999;
    private double minY = 9999999;
    private int cont =0;
    private CiudadesProvider ciudades;
    
    
    /**
     * Constructor de la clase Enter que inicializa y configura la interfaz gráfica.
     */
    public Enter() {
        initComponents();
        
        
        agregarOpcionesAComboBox();
        
     
    }
    
    //hola
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("LeerArchivos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Carga de archvios directa", jPanel1);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton3.setText("Acceder");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jButton3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jButton3)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Carga de archivos remoto", jPanel2);

        jButton2.setText("Ver mapa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento de clic en el botón "LeerArchivos".
     * Permite al usuario seleccionar archivos locales para la carga de nodos y líneas.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(this,"Ingrese un archivo nodo.xml");
        JFileChooser ar = new JFileChooser();
        int res = ar.showOpenDialog(this);
        if(res == JFileChooser.APPROVE_OPTION){
            
            try {
                File file = ar.getSelectedFile();
                SAXParserFactory factory  = SAXParserFactory.newInstance();
                SAXParser saxParser = factory.newSAXParser();
                puntoHandler handler = new puntoHandler();
                saxParser.parse(file, handler);
                puntos = handler.getPuntos();
                if(cont == 0){
                    sacarLimites(puntos);
                    this.cont=1;
                }
                else{
                    this.maxX = -999999;
                    this.maxY = -999999;
                    this.minX = 9999999;
                    this.minY = 9999999;
                    sacarLimites(puntos);
                }
                
                
                
                this.puntosCoord = new ArrayList<>(puntos);
                convertirCoordenadasAGeopixeles(puntosCoord,maxX,minX,maxY,minY);
                
                  
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(Enter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException ex) {
                Logger.getLogger(Enter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Enter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("Lectura nodos listo");
        
        JOptionPane.showMessageDialog(this,"Ingrese un archivo edge.xml");
        JFileChooser ar2 = new JFileChooser();
        int res2 = ar2.showOpenDialog(this);
        if(res2 == JFileChooser.APPROVE_OPTION){
           
            try {
                File file = ar2.getSelectedFile();
                SAXParserFactory factory  = SAXParserFactory.newInstance();
                SAXParser saxParser = factory.newSAXParser();
                lineaHandler handler = new lineaHandler();
                handler.setPuntos(puntosCoord);
                saxParser.parse(file, handler);
                lineas = handler.getLineas();
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(Enter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException ex) {
                Logger.getLogger(Enter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Enter.class.getName()).log(Level.SEVERE, null, ex);
            }
                

        }
        System.out.println("Lectura lineas listo");
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Maneja el evento de clic en el botón "Ver mapa".
     * Abre una nueva ventana de Mapita para visualizar el mapa con los puntos y líneas cargados.
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        try{
            if(puntosCoord.isEmpty() && lineas.isEmpty()){
                    JOptionPane.showMessageDialog(this,"Las listas estan vacías, cargue los archivos correspondientes");
                }
            else{
                    Mapita m = new Mapita(puntosCoord,lineas,maxX, minX, maxY, minY);
                    m.setVisible(true);
                }
        } catch(NullPointerException e ){
                JOptionPane.showMessageDialog(this,"Las listas estan vacías, cargue los archivos correspondientes");
                
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Maneja el evento de selección de un elemento en el JComboBox.
     * Obtiene la ciudad seleccionada y realiza acciones correspondientes.
     */
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    /**
     * Maneja el evento de clic en el botón "Acceder" para la carga de archivos remotos.
     * Obtiene la información de la ciudad seleccionada y realiza acciones correspondientes.
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String nameCiudad = jComboBox2.getSelectedItem().toString();
        try {
            CiudadesProvider.Ciudad city = ciudades.ciudad(nameCiudad);
            System.out.println("lectura terminada:\n"+city.getXmlNodes());
            System.out.println("Tamaña de archivo puntos: "+city.getXmlNodes().length());
            System.out.println("Tamaña de archivo linea: "+city.getXmlEdges().length());
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser= factory.newSAXParser();

            puntoHandler handler = new puntoHandler();
            saxParser.parse(new InputSource(new StringReader(city.getXmlNodes())), handler);
            puntos = handler.getPuntos();
            System.out.println("puntos-------------:");
            for(Punto p: puntos){
                System.out.println("ID: "+p.getId()+" X: "+p.getX()+" Y: "+p.getY());
            }
            
            if(cont == 0){
                    sacarLimites(puntos);
                    this.cont=1;
                }
                else{
                    this.maxX = -999999;
                    this.maxY = -999999;
                    this.minX = 9999999;
                    this.minY = 9999999;
                    sacarLimites(puntos);
                }
                
                
                
            this.puntosCoord = new ArrayList<>(puntos);
            convertirCoordenadasAGeopixeles(puntosCoord,maxX,minX,maxY,minY);
            
            
            SAXParserFactory factory2  = SAXParserFactory.newInstance();
            SAXParser saxParser2 = factory2.newSAXParser();
            lineaHandler handler2 = new lineaHandler();
            handler2.setPuntos(puntosCoord);
            saxParser2.parse(new InputSource(new StringReader(city.getXmlEdges())), handler2);
            lineas = handler2.getLineas();
            System.out.println("LINEAS------------:");
            for(Linea p: lineas){
                System.out.println("ID: "+p.getId()+" P1X: "+p.getP1().getX()+" P2Y: "+p.getP1().getY()+"  P1_ID: "+p.getP1().getId()+
                        "| P2X: "+p.getP2().getId()+" P2Y"+p.getP2().getY()+" P2_ID: "+p.getP2().getId());
            }
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(Enter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Enter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Enter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed
   
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Enter().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

    /**
     * Convierte las coordenadas geográficas a píxeles en un rango de [0, 1000] para su representación gráfica.
     *
     * @param puntos Lista de puntos que se deben convertir.
     * @param maxX Valor máximo de coordenada X en el mapa.
     * @param minX Valor mínimo de coordenada X en el mapa.
     * @param maxY Valor máximo de coordenada Y en el mapa.
     * @param minY Valor mínimo de coordenada Y en el mapa.
     */
    public static  void convertirCoordenadasAGeopixeles( ArrayList<Punto> puntos, double maxX, double minX, double maxY, double minY) {

    for(Punto p: puntos){
        double latitud = p.getY();
        double longitud = p.getX();

        double x = (longitud - minX) / (maxX - minX);
        double y = (latitud - minY) / (maxY - minY);

        double xPixel =  (x * 1000);
        double yPixel =  ((1.0 - y) * 1000);

        p.setX(xPixel);
        p.setY(yPixel);

        }
    }

    /**
     * Determina los límites geográficos (máximos y mínimos) a partir de una lista de puntos.
     *
     * @param puntos Lista de puntos para la obtención de límites geográficos.
     */
    private void sacarLimites(ArrayList<Punto> puntos) {
        for(Punto p: puntos){
            if(p.getX() > maxX){
                this.maxX = p.getX();
            }

            if(p.getY() > maxY){
                this.maxY = p.getY();
            }
            if(p.getX() < minX){
                this.minX = p.getX();
            }
            if(p.getY() < minY){
                this.minY = p.getY();
            }
        }
    }

    /**
     * Agrega las opciones de ciudades disponibles al JComboBox.
     */
    private void agregarOpcionesAComboBox() {
        jComboBox2.removeAllItems();
        ciudades = CiudadesProvider.instance();

        try {
            for (String ciudad : ciudades.list()) {
                jComboBox2.addItem(ciudad);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}
