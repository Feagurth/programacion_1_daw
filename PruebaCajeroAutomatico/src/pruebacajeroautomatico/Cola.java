/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebacajeroautomatico;

/**
 *
 * @author Super
 */
public class Cola {

    class Nodo {

        int info;
        Nodo sig;
    }

    private Nodo raiz, fondo;

    Cola() {
        this.raiz = null;
        this.fondo = null;
    }

    public boolean vacia() {
        return (raiz == null);
    }

    public void insertar(int x) {
        Nodo nuevo = new Nodo();
        nuevo.info = x;

        nuevo.sig = null;

        if (vacia()) {
            raiz = nuevo;
            fondo = nuevo;
        } else {
            fondo.sig = nuevo;
            fondo = nuevo;
        }
    }

    public int extraer() {
        if (!vacia()) {
            int informacion = raiz.info;
            if (raiz.sig == null) {
                raiz = null;
                fondo = null;
            } else {
                raiz = raiz.sig;
            }

            return informacion;
        } else {
            return Integer.MAX_VALUE;
        }

    }

    public void imprimir() {
        Nodo aux = raiz;

        System.out.println("");
        System.out.println("Contenido de la cola");
        System.out.println("--------------------");
        while (aux != null) {
            System.out.println(aux.info);
            aux = aux.sig;
        }
    }

    public int cantidad()
    {
        Nodo aux = raiz;
        int num_Nodos = 0;

        while (aux != null) {
            num_Nodos++;
            aux = aux.sig;
        }
    
        return num_Nodos;
    }
}
