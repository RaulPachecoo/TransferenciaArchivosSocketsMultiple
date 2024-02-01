/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transferenciaarchivossocketsmultiple;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raúl
 */
public class Cliente {
    public static void main(String[] args) {
        //Socket socket = new Socket();
        Scanner sc = new Scanner(System.in); 
        try {
            Socket socket = new Socket("localhost", 5555);
            //socket.connect(address);
            // Flujo de salida dell socket, para enviar datos al servidor
            OutputStream outputStream = socket.getOutputStream();
            //Lee el contenido del archivo y se lo envia al servidor
            String rutaArchivo; 
            System.out.println("Introduce la ruta del archivo a enviar: ");
            rutaArchivo = sc.nextLine(); 
            BufferedReader bufferedReader = new BufferedReader(new FileReader(rutaArchivo));
            
            PrintWriter printWriter = new PrintWriter(outputStream, true);
            
            while(bufferedReader.ready()){
                String linea = bufferedReader.readLine();
                
                printWriter.println(linea);
            }
            
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
