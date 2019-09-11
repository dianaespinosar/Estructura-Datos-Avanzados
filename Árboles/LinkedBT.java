package ejercicios;

import java.util.ArrayList;
import java.util.Iterator;
import ejercicios.NodoBT;

public class LinkedBT <T extends Comparable<T>> implements BinaryTreeADT<T> {
    protected NodoBT raiz;
    
    public boolean isEmpty() {
        if(raiz == null)
            return true;
        else 
            return false;
    }
    
    public void setRaiz(NodoBT<T> a){
        raiz = a;
    }

    public int size() {
       
    }

public boolean contains(T elem) {
        if (isEmpty() || elem == null)
            return false;
        if (raiz.getElement().equals(elem))
            return true;            
        return contains(elem, raiz.getDer()) || contains(elem, raiz.getIzq());
    }

    private boolean contains(T elem, NodoBT nodo){
        if (nodo == null || nodo.element == null)
            return false;
        if (nodo.getElement().equals(elem))
            return true;
        return contains(elem, nodo.getDer()) || contains(elem, nodo.getDer());

    }
 
    public Iterator<T> inOrden() {
       
    }

    @Override
    public Iterator<T> preOrden() {
        ArrayList<T> lista = new ArrayList<T>();
        preorden(raiz, lista);
        return lista.iterator();
    }
    
    private void preorden(NodoBT<T> actual, ArrayList<T> lista){
        if(actual == null)
            return;
        lista.add(actual.getElement());
        preorden(actual.getIzq(), lista);
        preorden(actual.getDer(), lista);
    }

    public Iterator<T> postOrden() {
        ArrayList<T> lista = new ArrayList<T>();
        postorden(raiz, lista);
        return lista.iterator();
    }
    
    private void postorden(NodoBT<T> actual, ArrayList<T> lista){
        if(actual == null)
            return;
        
        preorden(actual.getIzq(), lista);
        preorden(actual.getDer(), lista);
        lista.add(actual.getElement());
    }
    
    public int alturaArbol(){
        return alturaArbol(raiz);
    }
    
    private int alturaArbol(NodoBT base){
        if(base == null)
            return 0;
        return 1 + Math.max(alturaArbol(base.getIzq()), alturaArbol(base.getDer()));
    }
    
     public static void main(String[] args) {
        
        NodoBT a = new NodoBT('a');

        LinkedBT arbol = new LinkedBT();
        
        NodoBT b = new NodoBT('b');
        NodoBT c = new NodoBT('c');
        NodoBT d = new NodoBT('d');
        NodoBT e = new NodoBT('e');
        NodoBT f = new NodoBT('f');
        NodoBT g = new NodoBT('g');
        NodoBT h = new NodoBT('h');
        NodoBT i = new NodoBT('i');
        NodoBT j = new NodoBT('j');
        NodoBT k = new NodoBT('k');
        
        a.setIzq(b);
        a.setDer(c);
        b.setIzq(d);
        b.setDer(e);
        d.setIzq(f);
        f.setIzq(g);
        e.setIzq(h);
        c.setIzq(i);
        c.setDer(j);
        j.setIzq(k);}

        System.out.println(arbol.alturaArbol());
        
     }
    
}
