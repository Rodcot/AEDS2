public class IsRecursivo {
    public static void main(String args[])  { 
        for(;;){ 
            String input; 
            input = MyIO.readLine();

            if(input.equals("FIM")){
                System.exit(0);
            }

            int len = input.length();
            int flag = 0;

            for(int i = 0; i < len; i++){
                if(input.charAt(i) == 'A' || input.charAt(i) == 'E' || input.charAt(i) == 'I' || input.charAt(i) == 'O' || input.charAt(i) == 'U' 
                || input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'i' || input.charAt(i) == 'o' || input.charAt(i) == 'u' ){
                }else{
                    flag = 1;
                }
            }

            if(flag == 1){
                System.out.print("NAO ");
            }else{
                System.out.print("SIM ");
            }
            
            flag = 0;

            for(int i = 0; i < len; i++){
                if(input.charAt(i) == 'B' || input.charAt(i) == 'C' || input.charAt(i) == 'D' || input.charAt(i) == 'F' || input.charAt(i) == 'H' 
                || input.charAt(i) == 'J' || input.charAt(i) == 'K' || input.charAt(i) == 'L' || input.charAt(i) == 'M' || input.charAt(i) == 'N'
                || input.charAt(i) == 'P' || input.charAt(i) == 'Q' || input.charAt(i) == 'R' || input.charAt(i) == 'S' || input.charAt(i) == 'T'
                || input.charAt(i) == 'V' || input.charAt(i) == 'W' || input.charAt(i) == 'X' || input.charAt(i) == 'Z' || input.charAt(i) == 'b'
                || input.charAt(i) == 'c' || input.charAt(i) == 'd' || input.charAt(i) == 'f' || input.charAt(i) == 'h' || input.charAt(i) == 'j'
                || input.charAt(i) == 'q' || input.charAt(i) == 'r' || input.charAt(i) == 's' || input.charAt(i) == 't' || input.charAt(i) == 'v'
                || input.charAt(i) == 'w' || input.charAt(i) == 'x' || input.charAt(i) == 'z' || input.charAt(i) == 'k' ){
                }else{
                    flag = 1;
                }

                
            }

            if(flag == 1){
                System.out.print("NAO ");
            }else{
                System.out.print("SIM ");
            }

            flag = 0;

            for(int i = 0; i < len; i++){
                if(input.charAt(i) == '1' || input.charAt(i) == '2' || input.charAt(i) == '3' || input.charAt(i) == '4' || input.charAt(i) == '5' 
                || input.charAt(i) == '6' || input.charAt(i) == '7' || input.charAt(i) == '8' || input.charAt(i) == '9' || input.charAt(i) == '0'){
                }else{
                    flag = 1;
                } 
            }
            
            if(flag == 1){
                System.out.print("NAO ");
            }else{
                System.out.print("SIM ");
            }

            flag = 0;

            for(int i = 0; i < len; i++){
                if(input.charAt(i) == '1' || input.charAt(i) == '2' || input.charAt(i) == '3' || input.charAt(i) == '4' || input.charAt(i) == '5' 
                || input.charAt(i) == '6' || input.charAt(i) == '7' || input.charAt(i) == '8' || input.charAt(i) == '9' || input.charAt(i) == '0'
                || input.charAt(i) == '.' || input.charAt(i) == ','){
                }else{
                    flag = 1;
                } 
            }
            
            if(flag == 1){
                System.out.println("NAO");
            }else{
                System.out.println("SIM");
            }

        }
    }
}
