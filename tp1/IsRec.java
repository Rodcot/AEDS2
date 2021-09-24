import java.io.*;

public class isRec {
    public static String isVogal(String x, int i, int count) {
        String s = x.toUpperCase();
        if (i < x.length()) {
            if (s.charAt(i) == 'A' || s.charAt(i) == 'O' || s.charAt(i) == 'I' || s.charAt(i) == 'E'
                    || s.charAt(i) == 'U') {
                return isVogal(x, i + 1, count + 1);
            } else {
                return isVogal(x, i + 1, count);
            }
        } else {
            if (count == s.length()) {
                return "SIM";
            } else {
                return "NAO";
            }
        }

    }
    
    public static String isCons(String x, int i, int count) {
        String s = x.toUpperCase();
        if (i < x.length()) {
            if (s.charAt(i) == 'A' || s.charAt(i) == 'O' || s.charAt(i) == 'I' || s.charAt(i) == 'E'
                    || s.charAt(i) == 'U') {
                return isCons(x, i + 1, count);
            } else {
                return isCons(x, i + 1, count + 1);
            }
        } else {
            if (count == s.length()) {
                return "SIM";
            } else {
                return "NAO";
            }
        }
    }
    
    public static String isInt(String x, int i, int count) {
        String s = x.toUpperCase();
        if (i < x.length()) {
            if ((int) s.charAt(i) > 47 && (int) s.charAt(i) < 58) {
                return isInt(x, i + 1, count + 1);
            } else {
                return isInt(x, i + 1, count);
            }
        } else {
            if (count == s.length()) {
                return "SIM";
            } else {
                return "NAO";
            }
        }

    }
    
    public static String isFloat(String x, int i, int count) {
        String s = x.toUpperCase();
        if (i < x.length()) {
            if ((int) s.charAt(i) > 47 && (int) s.charAt(i) < 58 || (int) s.charAt(i) == 44) {
                return isFloat(x, i + 1, count + 1);
            } else {
                return isFloat(x, i + 1, count);
            }
        } else {
            if (count == s.length()) {
                return "SIM";
            } else {
                return "NAO";
            }
        }

    }
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
        String[] s = new String[1000];
        boolean flag = true;
        int i = 0;
        while (flag == true) {
            s[i] = br.readLine();
            if (s[i].equals("FIM")) {
                flag = false;
            } else {
                System.out.print(isVogal(s[i], 0, 0) + " ");
                System.out.print(isCons(s[i], 0, 0)+ " ");
                System.out.print(isInt(s[i], 0, 0)+ " ");
                System.out.println(isFloat(s[i], 0, 0));
                i++;
            }
        }
    }
}