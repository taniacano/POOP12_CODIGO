/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poop12;

/**
 *
 * @author Alna
 */
public class POOP12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //HILO Thread
        System.out.println("##########HILO Thread##########");
        new Hilo ("Primer hilo").start();
	new Hilo ("Segundo Hilo").start();
	System.out.println("Termina el hilo principal");
        
        //HILO Runnable
        System.out.println("##########HILO Runnable##########");
        new Thread(new HiloR (), "HILOR 1").start();
	new Thread(new HiloR (), "HILOR 2").start();
	System.out.println("Termina el hilo principal");
 
}
    
}
