/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filecompressor;

import static filecompressor.FileCompressor.method;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author ASUS
 */
public class Decompressor {
     public static void method(File file) throws IOException {
        String fileDirectory = file.getParent();

        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/Decompressed.txt");
        GZIPInputStream gis = new GZIPInputStream(fis);
        byte[] buffer = new byte[1024];
        int len;
        while ((len = gis.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }
        fis.close();
        gis.close();
        fos.close();
     }

    
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        File path=new File("C:\\Users\\ASUS\\Documents\\NetBeansProjects\\FileCompressor\\src\\filecompressor\\text-file.txt");
          method(path);
          
    }
    
}
