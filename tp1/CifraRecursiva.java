public class CifraRecursiva {
    public static String cipher(String str, int i){
        char ch = str.charAt(0);
        StringBuffer output = new StringBuffer();
        ch = (char)('a'+(ch - 'a' + i) % 26);
        output.append(ch);

        if(str.length() > 1){
            output.append(cipher(str.substring(1), i));
        }
        return output.toString();
    }
    public static void main(String args[])  { 
        for(;;){ 
            String input;

            input = MyIO.readLine();
            if(input.equals("FIM")){
                System.exit(0);
            }   

            String ciphertext = cipher(input, 3);

            MyIO.println(ciphertext);
        }
   }  
    
}
