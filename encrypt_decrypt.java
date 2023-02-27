/*In this project first we insert a number than select a file for encryption */
/*For decryption we again insert the same number and than select that file */
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ImageOperation {

    static void operate(int key){
        JFileChooser filechooser = new JFileChooser();
        filechooser.showOpenDialog(null);
        File file=filechooser.getSelectedFile();
        //File input stream reader
        try{
            FileInputStream fis = new FileInputStream(file);
            byte []data=new byte[fis.available()];
            fis.read(data);
            int i=0;
            for(byte b:data){
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null,"Operation Successfully");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("This is Testing of Encryption Decryption");
        JFrame f = new JFrame();
        f.setTitle("Image Operation");
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font = new Font("Roboto",Font.BOLD,25);
        //creating button
        JButton button = new JButton();
        button.setFont(font);
        button.setText("Select File");
        //Creating Textfield
        JTextField textfield = new JTextField(10);
        textfield.setFont(font);
        button.addActionListener(e->{
            System.out.println("button clicked");
            String text=textfield.getText();
            int temp=Integer.parseInt(text);
            operate(temp);
        });
        f.setLayout(new FlowLayout());
        f.add(button);
        f.add(textfield);
        f.setVisible(true);
    }
}
