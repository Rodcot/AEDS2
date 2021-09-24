import java.util.Random;

public class Alteracao {
    public static void main(String args[])  { 
        for(;;){ 
            String input, cyphertext = "";
            char alphabet, key1, key2;

            Random gerador = new Random();
            gerador.setSeed(4);
            key1 = (char)('a'+(Math.abs(gerador.nextInt()) % 26));
            key2 = (char)('a'+(Math.abs(gerador.nextInt()) % 26));

            input = MyIO.readLine();
            if(input.equals("FIM")){
                System.exit(0);
            }   
            int length = input.length();   
            for ( int i = 0; i < length; i++ )  {
                alphabet = input.charAt(i);
                if(alphabet == key1){
                    alphabet = key2;
                }
                cyphertext = cyphertext + alphabet;
            }
            MyIO.println(cyphertext);
        }
   }
}
