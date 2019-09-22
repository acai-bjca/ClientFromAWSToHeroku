/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientfromawstoheroku;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 2137441
 */
public class ClientFromAWSToHeroku {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {       
        URL url = new URL(args[0]);
        int hilos = Integer.parseInt(args[1]);
        long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
        TInicio = System.currentTimeMillis(); //Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
        List<ClientThread> clientes = new ArrayList<>();
        for(int i=0; i<hilos; i++){
            ClientThread thread = new ClientThread(url);
            clientes.add(thread);
            thread.start();
        }
        for(ClientThread c : clientes){            
            c.join();
        }
        TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
        tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
        System.out.println("Numero de clientes: "+hilos);
        System.out.println("url: "+url);
        System.out.println("Tiempo de ejecución en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos
    }
}
