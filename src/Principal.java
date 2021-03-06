
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author katty
 */
public class Principal extends javax.swing.JFrame {

    public static int cuality = 0;
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
            String sSistemaOperativo = System.getProperty("os.name");
    System.out.println(sSistemaOperativo);
        setIconImage(new ImageIcon(getClass().getResource("Assets/logo_doramas.png")).getImage());
         System.setProperty("http.agent", "Chrome");
        try {
            getLastChapters();
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cualityGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaUtlimosCapitulos = new javax.swing.JList<>();
        btn360 = new javax.swing.JRadioButton();
        btn480 = new javax.swing.JRadioButton();
        btn720 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        imgViewDorama = new javax.swing.JLabel();
        percentLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        jt_url = new javax.swing.JTextField();
        speed_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Descargas Doramas");

        jScrollPane1.setViewportView(listaUtlimosCapitulos);

        cualityGroup.add(btn360);
        btn360.setSelected(true);
        btn360.setText("360p");

        cualityGroup.add(btn480);
        btn480.setText("480p");

        cualityGroup.add(btn720);
        btn720.setText("720p");

        jButton1.setBackground(new java.awt.Color(48, 63, 159));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Descargar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        progressBar.setBackground(new java.awt.Color(0, 0, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(220, 220, 220))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn360)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn480)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn720)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jt_url, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imgViewDorama, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(percentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(speed_label)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(percentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(speed_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jt_url, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(imgViewDorama, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn360)
                    .addComponent(btn480)
                    .addComponent(btn720))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        getCuality();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btn360;
    private javax.swing.JRadioButton btn480;
    private javax.swing.JRadioButton btn720;
    private javax.swing.ButtonGroup cualityGroup;
    public static javax.swing.JLabel imgViewDorama;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField jt_url;
    public static javax.swing.JList<String> listaUtlimosCapitulos;
    public static javax.swing.JLabel percentLabel;
    public static javax.swing.JProgressBar progressBar;
    public static javax.swing.JLabel speed_label;
    // End of variables declaration//GEN-END:variables
    
    
    public static LinkedList<String> list_chapters_name = new LinkedList();
    static LinkedList<String>list_chapters_urls = new LinkedList();
    public static LinkedList<String>list_img_urls = new LinkedList();
    static String url_video = "";
    
    private void getLastChapters() throws IOException {
       
        //Log.d("------>","<-----");
        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    


                    Document doc = Jsoup.connect(Comun.main_url).userAgent("Mozilla").timeout(10000).get();
                    Elements links = doc.select("div.thumb-cap");
                    Elements links_text = doc.select("div.thumb-cap > strong > a");
                    Elements images = doc.select("div.thumb-cap > a > img");
                    Elements generes = doc.select("div#genuno > ul.alfa > li > a");
                   System.out.println("run: ---->"+generes.size());
                    //Log.d("size",""+images.size());
                    //Log.d("size",""+links_text.size());

                    for (int i = 0; i <links_text.size() ; i++) {
                       System.out.println(links_text.get(i).text());
                        System.out.println(links_text.get(i).attr("href"));
                        System.out.println("--->"+images.get(i).attr("src"));
                        list_chapters_name.add(links_text.get(i).text());
                        list_chapters_urls.add(links_text.get(i).attr("href"));
                        list_img_urls.add(images.get(i).attr("src"));
                    }

                    /*if (Comun.list_generes.isEmpty()){
                        for (Element genere:generes) {
                           System.out.println("run: --->"+genere.text()+"---"+genere.attr("href"));
                            GenereModel genereModel = new GenereModel(genere.text(),genere.attr("href"));
                            System.out.println("run: "+genereModel.toString());

                            Comun.list_generes.add(genereModel);
                        }
                    }*/


                    fillList();


                }
                catch (Exception e)
                {

                    JOptionPane.showMessageDialog(null,"Ha Ocurrido un error intenta de nuevo mas tarde");
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }
    
    private void fillList(){
        Vector doramasVector = new Vector();
        DefaultListModel model = new DefaultListModel();
        for(String chapter: list_chapters_name){
            model.addElement(chapter);
        }
        System.out.println(model.size());
        
        Principal.listaUtlimosCapitulos.setModel(model);
        Principal.listaUtlimosCapitulos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                
                
                try {
                    int postiton = Principal.listaUtlimosCapitulos.getSelectedIndex();
                    
                    System.out.println(list_chapters_urls.get(postiton));
                    System.out.println(list_img_urls.get(postiton));
                    getImage("imagen.jpg",list_img_urls.get(postiton));
                    
                    url_video = list_chapters_urls.get(postiton);
                    jt_url.setText(list_chapters_urls.get(postiton));
                } catch (IOException ex) {
                  
                }
                
            }
        });
        
    }
    
    private void getImage(final String filename, final String urlString) throws MalformedURLException, IOException {
        BufferedInputStream in = null;
        FileOutputStream fout = null;
        
        try {
            in = new BufferedInputStream(new URL(urlString).openStream());
            fout = new FileOutputStream(filename);

            final byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
            }
        }finally {
            if (in != null) {
                in.close();
            }
            if (fout != null) {
                fout.close();
            }
            
            setImage();
        }
        
        
    }
    
    private void setImage(){
        Principal.imgViewDorama.setIcon(new ImageIcon(new ImageIcon("imagen.jpg").getImage().getScaledInstance(Principal.imgViewDorama.getWidth(), Principal.imgViewDorama.getHeight(), Image.SCALE_DEFAULT)));
    }

    private void getCuality() {
       if(btn360.isSelected() == true){
           cuality = 0;
       }
       if(btn480.isSelected() == true){
           cuality = 1;
       }
       if(btn720.isSelected() == true){
           cuality = 2;
       }
       
       new Core(jt_url.getText());
       
    }


}
