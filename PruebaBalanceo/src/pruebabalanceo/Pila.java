/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebabalanceo;

/**
 *
 * @author Super
 */
public class Pila {

    public class Nodo {

        int info;
        Nodo sig;
    }

    private Nodo raiz;

    public Pila() {
        this.raiz = null;

    }

    public void insertar(int x) {
        Nodo nuevo = new Nodo();

        nuevo.info = x;

        if (raiz == null) {
            nuevo.sig = null;
            raiz = nuevo;
        } else {
            nuevo.sig = raiz;
            raiz = nuevo;

        }

    }

    public int extraer() {
        if (raiz != null) {
            int informacion = raiz.info;
            raiz = raiz.sig;
            return informacion;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public void imprimir() {
        Nodo aux = raiz;

        System.out.println("Elementos de la pila");
        System.out.println("--------------------");

        while (aux != null) {
            System.out.printf("%d\n", aux.info);
            aux = aux.sig;
        }
    }

    public int cantidad() {
        int numNodos = 0;
        Nodo aux = raiz;

        while (aux != null) {
            numNodos++;
            aux = aux.sig;
        }

        return numNodos;
    }

    public int retornar() {
        if (!vacia()) {
            return raiz.info;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public boolean vacia() {
        return (raiz == null);
    }

}
