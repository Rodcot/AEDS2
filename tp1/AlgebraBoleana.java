public class AlgebraBoleana {
    public static void main(String args[])  { 
        for(;;){ 
            int input = MyIO.readInt();
            int[] intArray = new int[input];

            if(input == 0){
                System.exit(0);
            }

            for(int i = 0; i < input; i++){
                intArray[i] = MyIO.readInt();
            }

            String expression = MyIO.readLine();
            int len = expression.length();
            String output = "";

            for(int i = 0 ; i < len ; i++){
                if(expression.charAt(i) == 'A')
                    output = output + intArray[0];
                else if(expression.charAt(i) == 'B')
                    output = output + intArray[1];
                else if(input > 2 && expression.charAt(i) == 'C')
                    output = output + intArray[1];
                else if(expression.charAt(i) == ' ')
                    output = output + "";
                else if(expression.charAt(i) == ',')
                    output = output + "\0";
                else
                    output = output + expression.charAt(i);
            }

            output = output.replaceAll("not\\(0\\)", "1");
            output = output.replaceAll("not\\(1\\)", "0");
            output = output.replaceAll("and(11)", "1");

            //and(not(A) , not(B))

            System.out.println(output);
        }
    }
}
/*
            for(int i = 0 ; i < 5 ; i++){
                output = output.replaceAll("not\\(0\\)", "1");
                output = output.replaceAll("not\\(1\\)", "0");
                output = output.replaceAll("and\\(0\\,0\\)", "0");
                output = output.replaceAll("and\\(1\\,0\\)", "0");
                output = output.replaceAll("and\\(0\\,1\\)", "0");
                output = output.replaceAll("and\\(1,1\\)", "1");
                output = output.replaceAll("or\\(0\\,0\\)", "0");
                output = output.replaceAll("or\\(1\\,0\\)", "1");
                output = output.replaceAll("or\\(0\\,1\\)", "1");
                output = output.replaceAll("or\\(\\1\\,\\1\\)", "1");
                output = output.replaceAll("and\\(0\\,0\\,0\\)", "0");
                output = output.replaceAll("and\\(0\\,0\\,1\\)", "0");
                output = output.replaceAll("and\\(0\\,1\\,0\\)", "0");
                output = output.replaceAll("and\\(0\\,1\\,1\\)", "0");
                output = output.replaceAll("and\\(1\\,0\\,0\\)", "0");
                output = output.replaceAll("and\\(1\\,0\\,1\\)", "0");
                output = output.replaceAll("and\\(1\\,1\\,0\\)", "0");
                output = output.replaceAll("and\\(1\\,1\\,1\\)", "1");
                output = output.replaceAll("or\\(0\\,0\\,0\\)", "0");
                output = output.replaceAll("or\\(0\\,0\\,1\\)", "1");
                output = output.replaceAll("or\\(0\\,1\\,0\\)", "1");
                output = output.replaceAll("or\\(0\\,1\\,1\\)", "1");
                output = output.replaceAll("or\\(1\\,0\\,0\\)", "1");
                output = output.replaceAll("or\\(1\\,0\\,1\\)", "1");
                output = output.replaceAll("or\\(1\\,1\\,0\\)", "1");
                output = output.replaceAll("or\\(1\\,1\\,1\\)", "1");  
            }
            */
