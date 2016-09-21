import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;


public class Comun {
    public static String main_img_url = "http://www.estrenosdoramas.org/wp-content/uploads/2016/08/Moon_Lovers_-_Scarlet_Heart_Ryeo_-_SBS.jpg?781e19";
    public static String main_url = "http://estrenosdoramas.org/";
    public static LinkedList<DoramaThumbModel> list_doramas_thumbs = new LinkedList();
    public static LinkedList<GenereModel> list_generes = new LinkedList();
    public static Color accentColor = new Color(48,63,159);
    public Comun(){
        
    }
    public static void saveUrl(final String filename, final String urlString) throws MalformedURLException, IOException {
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
        }
    }
    
    public static void getImage(final String filename, final String urlString) throws MalformedURLException, IOException {
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
        }
        
        
    }
}
