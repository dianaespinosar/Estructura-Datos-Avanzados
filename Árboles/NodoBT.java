package ejercicios;

public class NodoBT <T extends Comparable <T>>{
    T element;
    NodoBT<T> izq, der,papa;

    NodoBT(T elem) {
        element = elem;
        izq = null;
        der = null;
        papa = null;
    }

    public int numDescendientes() {
        int hijos = 0;
        if (izq != null) {
            hijos += 1 + izq.numDescendientes();
        }
        if (der != null) {
            hijos += 1 + der.numDescendientes();
        }
        return hijos;
    }

    public T getElement() {
        return element;
    }
    
    

    public String toString() {
        return element.toString() + "\n[" + izq.toString() + "---" + der.toString() + "]";
    }

    public NodoBT<T> getDer() {
        return der;
    }

    public NodoBT<T> getIzq() {
        return izq;
    }

    public void setIzq(T elem) {
        izq = new NodoBT<T>(elem);
    }

    public void setDer(T elem) {
        der = new NodoBT<T>(elem);
    }
    
    public NodoBT<T> getPapa() {
        return papa;
    }
    public void setPapa(NodoBT<T> pap) {
        papa = pap;
    }
    

}
