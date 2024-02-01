/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transferenciaarchivossocketsmultiple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raúl
 */
public class HiloConexion extends Thread{
    private final Socket socket;

        public HiloConexion(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("archivo_salida.txt", true))) {
                // Obtiene el flujo de entrada del socket, para leer los datos enviados
                InputStream inputStream = socket.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                // Lee línea a línea el archivo y lo muestra por pantalla
                String linea;
                while ((linea = bufferedReader.readLine()) != null) {
                    System.out.println(linea);
                    writer.write(linea);
                    writer.newLine();
                }

                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
}
