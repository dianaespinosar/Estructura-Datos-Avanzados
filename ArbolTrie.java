package arboltrie;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArbolTrie {
    
    public static void leeArchivo(String nom, Trie a) {
        try {
            File file = new File(nom);
            Scanner leeArch = new Scanner(file);
            String palabra;
            while (leeArch.hasNextLine()) {
                palabra = leeArch.nextLine();
                a.insertar(palabra);
            }

            leeArch.close();

        } catch (Exception e) {
           throw new NullPointerException("Error"); 
        }
    }
    
    public static ArrayList<String> leeArchivoArregloString(String nom) {
        
        try {
            ArrayList<String> res = new ArrayList<String>();
            File file = new File(nom);
            Scanner leeArch = new Scanner(file);
            String palabra;
            while (leeArch.hasNextLine()) {
                palabra = leeArch.nextLine();
                res.add(palabra);
                
            }

            leeArch.close();
            //String[] respuesta = (String[]) res.toArray();
            return res;
        } catch (Exception e) {
           throw new NullPointerException("Error"); 
        }
    }
    
    public static void mergeSort(String[] names) {
        if (names.length >= 2) {
            String[] left = new String[names.length / 2];
            String[] right = new String[names.length - names.length / 2];

            for (int i = 0; i < left.length; i++) {
                left[i] = names[i];
            }

            for (int i = 0; i < right.length; i++) {
                right[i] = names[i + names.length / 2];
            }

            mergeSort(left);
            mergeSort(right);
            merge(names, left, right);
        }
    }

    public static void merge(String[] names, String[] left, String[] right) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < names.length; i++) {
            if (b >= right.length || (a < left.length && left[a].compareToIgnoreCase(right[b]) < 0)) {
                names[i] = left[a];
                a++;
            } else {
                names[i] = right[b];
                b++;
            }
        }
    }
    
    public static String imprimeArreglo(String[] res){
        StringBuilder a = new StringBuilder();
        for(int i = 0; i < res.length; i++){
            a.append(res[i]).append("\n");
        }
        return a.toString();
    }

    public static void main(String[] args) {
        char[] sim = {'a','b', 'c','d','e', 'f','g','h', 'i','j','k', 'l','m',
             'n', 'o','p','q', 'r','s','t', 'u','v','w', 'x','y','z'};
         Trie arbol = new Trie(sim);
         leeArchivo("Palabras.txt", arbol);
         System.out.println(arbol.toString());
         
        ArrayList<String> resp =  leeArchivoArregloString("Palabras.txt");
        String[] res =  resp.toArray(new String[resp.size()]);
        mergeSort(res);
         System.out.println(imprimeArreglo(res));
        

    }
    
}
