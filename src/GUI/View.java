/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import filecompressor.*;

/**
 *
 * @author ASUS
 */
    
    

public class View extends JFrame implements ActionListener {

    JButton compresseButton, deCompresseButton;

    View() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        compresseButton = new JButton("Select a file to compress");
        compresseButton.addActionListener(this);
        compresseButton.setBounds(20, 100, 200, 30);

        deCompresseButton = new JButton("select a file to decompress");
        deCompresseButton.addActionListener(this);
        deCompresseButton.setBounds(240, 100, 200, 30);

        this.add(compresseButton);
        this.add(deCompresseButton);
        this.setSize(500, 200);
        this.getContentPane().setBackground(Color.red);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == compresseButton) {
            JFileChooser obj = new JFileChooser();
            int response = obj.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(obj.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try {
                    FileCompressor.method(file);
                    JOptionPane.showMessageDialog(null, "Compression sucessfull");
                } catch (HeadlessException | IOException excp) {
                    JOptionPane.showMessageDialog(null, excp.toString());
                }
            }
        }
        if (e.getSource() == deCompresseButton) {
            JFileChooser obj = new JFileChooser();
            int response = obj.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(obj.getSelectedFile().getAbsolutePath());

                try {
                    Decompressor.method(file);
                    JOptionPane.showMessageDialog(null, "DeCompression sucessfull");
                } catch (HeadlessException | IOException excp) {
                    JOptionPane.showMessageDialog(null, excp.toString());
                }
            }

        }
    }

    public static void main(String args[]) {
        View frame = new View();
        frame.setVisible(true);
    }
    
}
