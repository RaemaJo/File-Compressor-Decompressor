/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package filecompressor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 *
 * @author ASUS
 */
public class FileCompressor {
    
     public static void method(File file) throws IOException {
        String fileDirectory = file.getParent();
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/Compressed.gz");
        GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1) {
            gzipOS.write(buffer, 0, len);
        }
        gzipOS.close();
        fis.close();
        fos.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        File path=new File("C:\\Users\\ASUS\\Documents\\NetBeansProjects\\FileCompressor\\src\\filecompressor\\text-file.txt");
          method(path);
          
    
    
    }
    
    
}
