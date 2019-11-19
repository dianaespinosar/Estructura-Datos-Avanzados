package arboltrie;

import java.util.Arrays;

public class Trie<T> {

    private NodoTrie raiz;
    protected char[] simbolos;
    private int cont, pos;

    public Trie(char[] simbolos) {

        Arrays.sort(simbolos);
        this.simbolos = simbolos.clone();
        raiz = new NodoTrie(simbolos.length);
        cont = 0;
    }

    public char[] getSimbolos() {
        return simbolos;
    }

    public void setSimbolos(char[] simbolos) {
        this.simbolos = simbolos;
    }

    public boolean busca(String llave) {
        llave = llave.toLowerCase();
        return busca(llave, raiz);
    }

    private boolean busca(String llave, NodoTrie actual) {
        if (actual == null) {
            return false;
        }
        if (llave.compareTo("") == 0) {
            return actual.isFin();
        }
        int pos = buscaCar(llave.charAt(0));

        return busca(llave.substring(1), actual.getSig(pos));
    }

    public NodoTrie buscaFin(String llave) {
        return buscaFin(llave, raiz);
    }

    private NodoTrie buscaFin(String llave, NodoTrie actual) {
        if (actual == null) {
            return null;
        }
        if (llave.compareTo("") == 0) {
            return actual;
        }
        int pos = buscaCar(llave.charAt(0));

        return buscaFin(llave.substring(1), actual.getSig(pos));
    }

    public void insertar(String pal) {
        pal = pal.toLowerCase();
        //if (!busca(pal)) {
            insertar(pal, raiz);
        //}
    }


    private void insertar(String llave, NodoTrie actual) {
        //System.out.println("Llave es " + llave);
        if (llave.length() == 0) {
            actual.setFin(true);
            cont++;
            return;
        }
        int pos = buscaCar(llave.charAt(0));
        //System.out.println(llave.charAt(0) + " -->" +  pos);
        NodoTrie temp = actual.getSig(pos);
        if (temp == null) {
            temp = new NodoTrie(simbolos.length);
            temp.setPapa(actual);
            actual.getHijos()[pos] = temp;
        }
        insertar(llave.substring(1), temp);
    }

    public boolean eliminar(String llave) {
        llave = llave.toLowerCase();
        boolean res = false, ban;
        NodoTrie act = buscaFin(llave);
        ban = act != null;
        if (ban && llave != null && !llave.equals("")) {
            act.setFin(false);
            ban = act.estaVacio();
            
            res = !ban;
            if (ban) {
                res = eliminar(llave, act.getPapa());
            }
        }
        if (res) {
            cont--;
        }
        return res;
    }

    private boolean eliminar(String llave, NodoTrie actual) {
        if (actual == null) {
            return false;
        }
        int pos = buscaCar(llave.charAt(llave.length() - 1));
        actual.getHijos()[pos] = null;
        if (actual.isFin()) {
            return true;
        }
        if (!actual.estaVacio()) {
            return true;
        }
        if (actual.getPapa() == null) {
            return true;
        }
        return eliminar(llave.substring(0, llave.length() - 1), actual.getPapa());
    }

    private int buscaCar(char c) {
        int i = 0;
        while (i < simbolos.length && simbolos[i] != c) {
            i++;
        }
        if (i == simbolos.length) {
            throw new RuntimeException("No existe el simbolo");
        }
        return i;
    }
    
    
    /*public int posicionChar(char a){
        int i = 0;
        while(i < simbolos.length){
            if(simbolos[i] != a)
                i++;
            else
                break;
        }
        if(i < simbolos.length)
            return i;
        else
            return -1;
    }*/

    public void display() {
    char[] pal = new char[50];
            display(raiz,pal, 0 );
    }
  void display(NodoTrie root, char[] str, int level) 
{ 
    // If node is leaf node, it indicates end 
    // of string, so a null character is added 
    // and string is displayed 
    if (root.isFin())  
    { 
        str[level] = '\0'; 
        System.out.println(str);
    } 
  
    int i; 
    for (i = 0; i < root.getHijos().length; i++)  
    { 
        // Si es no nulo se encuentra un hijo agrega la llave del padre a str 
        // y llama de manera recursiva la función para el nodo del hijo
        if (root.getHijos()[i]!=null)  
        { 
            Character car = simbolos[i];
            str[level] = car; 
            display(root.getHijos()[i], str, level + 1); 
        } 
    } 
} 

    public String toString() {
        StringBuilder cadena = new StringBuilder();
        cadena.append("Las palabras ordenadas alfabéticamente son: \n");
        NodoTrie<T> actual = raiz;
        String res="";
            res = toString(actual, cadena, "");
        return res;
    }

    private String toString(NodoTrie actual, StringBuilder cad, String palabra) {
        if (actual == null) { //no hay más nodos por este camino
            return cad.toString();
        }
        if (actual.isFin()) { //encontramos una palabra
            cad.append(palabra);
            cad.append("\n");
        }
        NodoTrie[] arr = actual.getHijos(); 
        
        for (int i = 0; i < actual.getHijos().length; i++) {
            if (arr[i] != null) { //Que el nodque corresponde a una letra sea distinto de null
                String aux = palabra;
                char letra = simbolos[i];
                aux += letra; //de esa manera corresponde agregar la letra a la palabra
                toString(arr[i], cad, aux); //y ver si que palabras se forman que su inicio sea aux
            }
            //al salir del if es que ya no hay más palabras que continuen con esa letra, entonces vamos a tener la misma 
            //palabra inicial pero ahora le vamos a agregar la letra que sigue
        }
        return cad.toString();
    }

    public NodoTrie getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoTrie raiz) {
        this.raiz = raiz;
    }
   

}