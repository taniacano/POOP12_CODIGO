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
public class Cuenta extends Thread {
    private static long saldo = 0;
    public Cuenta (String nombre){
        super (nombre);
    }
    
    @Override
    public void run (){
        if (getName().equals("Deposito 1")||
            getName().equals("Deposito 2")){
            this.depositarDinero(100);
        } else {
            this.extraerDinero(50);
        }
        System.out.println("Termina el " + getName());
    }
    
    public synchronized void depositarDinero (int cantidad){
        saldo += cantidad;
        System.out.println("Se depositaron "+ cantidad+"pesos");
            notifyAll();
    }
   	public synchronized void extraerDinero(int cantidad) {
		try {
			if (saldo <= 0){
				System.out.println(getName() + " espera depOsito"
					+ "\nSaldo  " + saldo);
					sleep(5000);
			}
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		saldo -= cantidad;
		System.out.println(getName() + " extrajo " + cantidad +
			" pesos.\nSaldo restante = "+ saldo);
			notifyAll();
	}

	public static void main(String[] args) {
		new Cuenta("Acceso 1").start();
		new Cuenta("Acceso 2").start();
		new Cuenta("Deposito 1").start();
		new Cuenta("Deposito 2").start();
		System.out.println("Termina el hilo principal");
	}
}
