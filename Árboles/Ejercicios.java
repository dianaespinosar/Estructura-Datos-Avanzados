package ejercicios;

public class Ejercicios <T> {

    public static String permutar (String cadena){
        StringBuilder res = new StringBuilder();
        StringBuilder guarda = new StringBuilder();
        return permutar(res, cadena, guarda);
    }
    
    private static String permutar(StringBuilder res, String cadena, StringBuilder guarda){
        for(int i =0; i < cadena.length(); i++){
            guarda.append(cadena.charAt(i));
            String palabra = cadena.substring(0,i) + cadena.substring(i + 1);  
            permutar(res, palabra, guarda);
            guarda.deleteCharAt(guarda.length() -1);
            
        }
        if(cadena.length() == 0)
            res.append(guarda).append("\n");
        return res.toString();
    }
    
    
    
    
    public static int minMov( String cad1, String cad2){

        return minMov(cad1,cad2,Math.max(cad1.length(), cad2.length()), 0, 0 );

    }

    private static int minMov(String cad1, String cad2, int menor, int i, int mov){

        if(mov < menor){

            System.out.println("Movimientos: " + mov + " menor a " + menor);
            if(i == cad1.length() || i == cad2.length()){
                /*System.out.println("Cad1 = " + cad1.length());
                System.out.println("Cad2 = " + cad2.length());
                System.out.println("Mov antes de quitar lo extra = " + mov);*/
                mov = mov + Math.abs((cad1.length()-cad2.length()));
                //System.out.println("Movimientos después de quitar lo extra = " + mov);
                return mov;
            }

            else{

                System.out.println("i = " + i + "\nCaracter en cad1 es: " + cad1.charAt(i));

                if(cad1.charAt(i) == cad2.charAt(i)){
                    System.out.println("Caracteres iguales: " + cad1.charAt(i));
                   return minMov(cad1, cad2, menor, (i + 1), mov);
                }
                else{
                    System.out.println("No son iguales los caracteres");
                    System.out.println("Movimientos hasta el momento son " + mov);
                    //Sustitución
                    System.out.println("Sustitución de " + cad1.charAt(i) );
                    int n = minMov(cad1.substring(0, i) + 

                            cad2.substring(i, i +1) + cad1.substring(i + 1), cad2, menor, i + 1, mov + 1 );
                    System.out.println("n = " + n  + "\nMenor = " + menor);
                    if(n < menor){
                        menor = n;
                        System.out.println("Menor cambio a " + menor);
                        
                    }

                        
                        //Quitar
                        System.out.println("Quitar a " + cad1.charAt(i));
                       // System.out.println("movimientos = " + mov);
                        n = minMov(cad1.substring(0, i) + cad1.substring(i + 1),

                                cad2, menor, i, mov + 1 );
                        //System.out.println("n = " + n + "\nMenor = " + menor);
                        if(n < menor)

                            menor = n;

                        
                            //Agregar
                            System.out.println("Agregar antes de " + cad1.charAt(i));
                            n = minMov(cad1.substring(0, i) +cad2.substring(i, i +1)+ cad1.substring(i),

                                cad2, menor, i + 1, mov + 1 );
                           // System.out.println("n = " + n  + "\nMenor = + " + menor);
                            if(n < menor)

                                menor = n;

                }

            }

        }

        return menor;

    }
   
    

   

    public static void main(String[] args) {
        String cadena = "12345";
        System.out.println(permutar(cadena));
         //System.out.println(minMov("die", "andi"));
    }
}
