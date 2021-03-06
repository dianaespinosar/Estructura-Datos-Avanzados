
package ejercicios;

import java.util.Iterator;

public interface BinaryTreeADT  <T>{
    public boolean isEmpty();
    public int size();
    public boolean contains (T a);
    public Iterator<T> inOrden();
    public Iterator<T> preOrden();
    public Iterator<T> postOrden();
}
