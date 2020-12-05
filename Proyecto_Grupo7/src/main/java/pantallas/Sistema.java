/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantallas;

import java.util.Iterator;
import soldado.Soldado;
import tdas_linkedlist.CircularLinkedList;



/**
 *
 * @author Gabriel
 */
public class Sistema extends Thread {
    CircularLinkedList<Soldado> soldados;
    int cantidadSoldados;
    int cantidadVivos;
    
    @Override
    public void run() {

        
    }
    
    //Este metodo crea la lista circular con tantos soldados como sean requeridos.
    //Se debe haber fijado una cantidad de soldados previamente para que funcione.
    public void iniciarCirculo(int cantidad){
        cantidadSoldados = cantidad;
        soldados = new CircularLinkedList<> ();
        for(int i = 1; i <= cantidadSoldados; i++) {
            soldados.addLast(new Soldado(i));
        }
    }
    
    public void ejecucion() {
        Iterator it = soldados.listIterator(0);
        Soldado actual;
        boolean interruptor = true;
        cantidadVivos = cantidadSoldados;
        System.out.println(soldados.size());
        while(interruptor) {
            actual = (Soldado) it.next();
            System.out.println(actual);
            System.out.println("soldado numero " + actual.getID() + " asesina a: ");
            actual = (Soldado) it.next();
            if(actual.isAlive()){
                actual.matar(actual);
                cantidadVivos--;
                System.out.println("vivos: " + cantidadVivos);
            }
            if (cantidadVivos == 1) {
                interruptor = false;
            }
        }
        System.out.println("resultado final");
        for(Soldado soldado: soldados){
            System.out.println(soldado);
        }
    }
    

    

    
    
    
}
