public class RecursivePalindrome {
    
    public static boolean isPal(String s){
        if(s.length() == 0 || s.length() == 1){
            return true; 
        }
        if(s.charAt(0) == s.charAt(s.length()-1)){
            return isPal(s.substring(1, s.length()-1));
        }

        return false;
    }
    
    public static void main(String args[])  { 
        for(;;){ 
            String original;
            original = MyIO.readLine();

            if(original.equals("FIM")){
                System.exit(0);
            }   
            
            if(isPal(original)){
                System.out.println("SIM");
            }else{
                System.out.println("NAO");
            }
        }
   }
}
