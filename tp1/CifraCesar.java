class CifraCesar  {  
    public static void main(String args[])  { 
        for(;;){ 
            String input, cyphertext = "";
            char alphabet;
            input = MyIO.readLine();
            if(input.equals("FIM")){
                System.exit(0);
            }   
            int length = input.length();   
            for ( int i = 0; i < length; i++ )  {
                alphabet = input.charAt(i);
                alphabet = (char)(alphabet+3);
                cyphertext = cyphertext + alphabet;

            }
            MyIO.println(cyphertext);
        }
   }  
}  