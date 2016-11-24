
import com.littlebigberry.httpfiledownloader.*;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class Core implements FileDownloaderDelegate{
    Comun comun = new Comun();
    static String name = "";
    static String url_video = "";
    public static LinkedList<String> list_chapters_name = new LinkedList();
    static LinkedList<String>list_chapters_urls = new LinkedList();
    public static LinkedList<String>list_img_urls = new LinkedList();
    
    static int progresoDescarga = 0;
    
    public static LinkedList<IframeLink> arrayIframes = new LinkedList();
    //public static LinkedList<VideoModel> arrVideos = new LinkedList();
    static String title = "";
        public Core(String ur){
            //descargar("mmm","mm");
        try {
            
            getInfo(ur);
        } catch (IOException ex) {
            Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
       
           ///////---------trae capitulos
    
    
    
        
        //procesar url para obtener enlaces
    
        private void getInfo(String my_url) throws IOException, ParseException{
        
        System.out.println("Fetching %s..."+ my_url);

        
        Document doc = Jsoup.connect(my_url).userAgent("Mozilla").timeout(5000).get();
        
        Elements links = doc.select("iframe");
        Elements titles = doc.select("title");
        System.out.println("\nVideos: (%d)"+ links.size());
        for (Element link : links) {
            System.out.println(" * video:"+ link.attr("src"));
            IframeLink iframe = new IframeLink(link.attr("src"));
            if(iframe.getUrl().contains("mundoasia")){
                System.out.println("----->"+iframe.getUrl());
               arrayIframes.add(iframe);
            }
            
        }
        for(Element t: titles){
            System.out.println(t.text());
            String cap = t.text();
            title = cap+".mp4";
        }
        
        getIframeslinks();
        //System.out.println(doc);

    }
    
    private  void getIframeslinks() throws IOException, ParseException{
        IframeLink link;
        //System.out.println(arrayIframes.size());
        for(IframeLink iframe:  arrayIframes){
            //System.out.println("Clases.MainWindow.getIframeslinks()");
          //  System.out.println(iframe.getUrl());
            moreInfo(iframe.getUrl());
        }
        
    }
    
    private  void moreInfo(String frame_url) throws IOException, ParseException{
        Document doc = Jsoup.connect(frame_url).userAgent("Mozilla").timeout(10000).get();
        Elements links = doc.select("script[type]");
        //System.out.println(links);
     
        String pattern = "\\[(.*?)\\]";

      // Create a Pattern object
         Pattern r = Pattern.compile(pattern);

      // Now create matcher object.
        for(Element link: links){
            String text = link+"";
            if(text.contains("jwplayer('embed').setup({")){
                //JOptionPane.showMessageDialog(null, text.trim());
               // System.out.println(text.trim());
                 Matcher m = r.matcher(text);
                if (m.find( )) {
                    System.out.println("---->Found value: " + m.group(0) );
                   
                    processResults(m.group(0));
                   
                    //JOptionPane.showMessageDialog(null, m.group(0));
                 }else {
                   // System.out.println("NO MATCH");
                 }
            }
        }
    }
    
    private void processResults(String result) throws IOException{
        System.out.println(result);
        LinkedList<String> srcs = new LinkedList();
        Matcher m = Pattern.compile(
                            Pattern.quote("file:'")
                            + "(.*?)"
                            + Pattern.quote("',")
                   ).matcher(result);
        while(m.find()){
           
            String match = m.group(1);
            System.out.println(">"+match+"<");
            srcs.add(match);
            
        }
        //JOptionPane.showMessageDialog(null, ""+srcs.size());
        if(srcs.size() > 0){
            System.out.println(srcs.get(Principal.cuality));
            descargar(title, srcs.get(Principal.cuality));
            
        }
        
    }
    
    String test = "http://81.4.123.64/repro/amz/examples/gp2.php?code=30423679556A763066646751305A576C4C5655644D5A6B64695A4545";
    private void descargar(String file_name, String url){
        String folder = "Descargas/";
        url = test;
        File dir = new File(folder);

        if (!dir.exists())
          if (!dir.mkdir())
            return; // no se pudo crear la carpeta de destino
 
        
        FileDownloader fileDownloader = new FileDownloader(this);
		fileDownloader.setUrl(url);
		fileDownloader.setLocalLocation(folder+file_name);
		fileDownloader.beginDownload();
    }
    
        @Override
	public void didStartDownload(FileDownloader fileDownloader) {
		System.out.println("Download started");
                
	}

	@Override
	public void didProgressDownload(FileDownloader fileDownloader) {
		String kbPerSecond = "Calculating...";
                
		if (fileDownloader.getKbPerSecond() != null) {
			kbPerSecond = fileDownloader.getKbPerSecond() + " kb/s";
		}
                Principal.speed_label.setText("Velocidad de Descarga: "+kbPerSecond);
                String percentString[] = fileDownloader.getPercentComplete().split("%");
                int percent = Math.round(Float.parseFloat(percentString[0]));
                Principal.progressBar.setValue(percent);
                Principal.progressBar.setToolTipText(fileDownloader.getPercentComplete());
                Principal.percentLabel.setText(fileDownloader.getPercentComplete()+ " completado ");
		
	}

	@Override
	public void didFinishDownload(FileDownloader fileDownloader) {
            
            JOptionPane.showMessageDialog(null, "Descarga Terminada");
		
	}

	@Override
	public void didFailDownload(FileDownloader fileDownloader) {
		// TODO Auto-generated method stub
                JOptionPane.showMessageDialog(null, "Descarga Fallida");
		
	}
}
