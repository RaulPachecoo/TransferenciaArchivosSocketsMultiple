/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transferenciaarchivossocketsmultiple;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raúl
 */
public class Servidor {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            // Se crea el serverSocket y el InetSocketAdress para asignarle el puerto y la ip.
            serverSocket = new ServerSocket(5555);
            //InetSocketAddress address = new InetSocketAddress("localhost", 5555);
            //serverSocket.bind(address);
            System.out.println("Servidor iniciado");

            while (true) {
                // Acepta las conexiones 
                Socket socket = serverSocket.accept();
                System.out.println("Conexion establecida");

                // Crea un hilo para manejar la conexión
                Thread hiloCliente = new Thread(new HiloConexion(socket));
                hiloCliente.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
