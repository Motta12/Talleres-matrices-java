class Nodo {
    int fila;
    int columna;
    int valor;
    Nodo siguiente;

    public Nodo(int fila, int columna, int valor) {
        this.fila = fila;
        this.columna = columna;
        this.valor = valor;
        this.siguiente = null;
    }
}

class MatrizDispersa {
    Nodo cabeza;

    public void insertar(int fila, int columna, int valor) {
        if (valor == 0) return;

        Nodo nuevo = new Nodo(fila, columna, valor);

        if (cabeza == null || fila < cabeza.fila || (fila == cabeza.fila && columna < cabeza.columna)) {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null &&
                    (actual.siguiente.fila < fila ||
                            (actual.siguiente.fila == fila && actual.siguiente.columna < columna))) {
                actual = actual.siguiente;
            }
            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
        }
    }

    public boolean eliminar(int fila, int columna) {
        Nodo actual = cabeza;
        Nodo anterior = null;

        while (actual != null) {
            if (actual.fila == fila && actual.columna == columna) {
                if (anterior == null) {
                    cabeza = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                return true;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
        return false;
    }

    public void mostrar() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.println("(" + actual.fila + ", " + actual.columna + ") = " + actual.valor);
            actual = actual.siguiente;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MatrizDispersa matriz = new MatrizDispersa();
        matriz.insertar(0, 1, 5);
        matriz.insertar(1, 2, 8);
        matriz.insertar(2, 0, 3);

        matriz.mostrar();
    }
}
