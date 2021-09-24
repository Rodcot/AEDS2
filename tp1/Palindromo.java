class Palindromo  {  
    public static void main(String args[])  { 
        for(;;){ 
            String original, reverse = "";
            original = MyIO.readLine();
            if(original.equals("FIM")){
                System.exit(0);
            }   
            int length = original.length();   
            for ( int i = length - 1; i >= 0; i-- )  
                reverse = reverse + original.charAt(i);  
            if (original.equals(reverse))  
                System.out.println("SIM");  
            else  
                System.out.println("NAO");
        }
   }  
}  