import java.io.*;
import java.net.*;

class htmlSearch {
    static int MAX_TAM = 25;

    public static boolean isFim(String s) {
        boolean resposta = true;
        if (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M')
            resposta = false;

        return resposta;
    }

    public static String getHtml(String fimereco) {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String resposta = "", line;

        try {
            url = new URL(fimereco);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                resposta += line + "\n";
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            is.close();
        } catch (IOException ioe) {
        }
        return resposta;
    }

    public static int[] vetor(String s) {

        int[] array = new int[MAX_TAM];
        for (int i = 0; i < MAX_TAM; i++) {
            array[i] = 0;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '\u003C') {
                i++;
                if (s.charAt(i) == 'b' && s.charAt(i + 1) == 'r' && s.charAt(i + 2) == '\u003E') {
                    array[23]++;
                    i += 2;
                } else if (s.charAt(i) == 't' && s.charAt(i + 1) == 'a' && s.charAt(i + 5) == '\u003E') {
                    array[24]++;
                    i += 5;

                }
                i--;
            } else if (s.charAt(i) == 'a')
                array[0]++;
            else if (s.charAt(i) == 'e')
                array[1]++;
            else if (s.charAt(i) == 'i')
                array[2]++;
            else if (s.charAt(i) == 'o')
                array[3]++;
            else if (s.charAt(i) == 'u')
                array[4]++;
            else if (s.charAt(i) == '\u00E1')
                array[5]++;
            else if (s.charAt(i) == '\u00E9')
                array[6]++;
            else if (s.charAt(i) == '\u00ED')
                array[7]++;
            else if (s.charAt(i) == '\u00F3')
                array[8]++;
            else if (s.charAt(i) == '\u00FA')
                array[9]++;
            else if (s.charAt(i) == '\u00E0')
                array[10]++;
            else if (s.charAt(i) == '\u00E8')
                array[11]++;
            else if (s.charAt(i) == '\u00EC')
                array[12]++;
            else if (s.charAt(i) == '\u00F2')
                array[13]++;
            else if (s.charAt(i) == '\u00F9')
                array[14]++;
            else if (s.charAt(i) == '\u00E3')
                array[15]++;
            else if (s.charAt(i) == '\u00F5')
                array[16]++;
            else if (s.charAt(i) == '\u00E2')
                array[17]++;
            else if (s.charAt(i) == '\u00EA')
                array[18]++;
            else if (s.charAt(i) == '\u00EE')
                array[19]++;
            else if (s.charAt(i) == '\u00F4')
                array[20]++;
            else if (s.charAt(i) == '\u00FB')
                array[21]++;
            else if (s.charAt(i) > 'a' && s.charAt(i) <= 'z')
                array[22]++;
        }
        return array;
    }

    public static void mostraTela(int[] num, String s) {

        MyIO.println("a(" + num[0] + ") e(" + num[1] + ") i(" + num[2] + ") o(" + num[3] + ") u(" + num[4] + ")"
                + " \u00E1(" + num[5] + ") \u00E9(" + num[6] + ") \u00ED(" + num[7] + ") \u00F3(" + num[8] + ") \u00FA("
                + num[9] + ")" + " \u00E0(" + num[10] + ") \u00E8(" + num[11] + ") \u00EC(" + num[12] + ") \u00F2("
                + num[13] + ") \u00F9(" + num[14] + ")" + " \u00E3(" + num[15] + ") \u00F5(" + num[16] + ") \u00E2("
                + num[17] + ") \u00EA(" + num[18] + ") \u00EE(" + num[19] + ")" + " \u00F4(" + num[20] + ") \u00FB("
                + num[21] + ") consoante(" + num[22] + ") <br>(" + num[23] + ") <table>(" + num[24] + ") " + s);
    }

    public static void main(String[] args) {
        MyIO.setCharset("utf-8");
        String page = "";
        String fim = "";
        int[] numeros = new int[MAX_TAM];
        page = MyIO.readLine();
        while (isFim(page)) {
            fim = MyIO.readLine();
            fim = getHtml(fim);
            numeros = vetor(fim);
            mostraTela(numeros, page);
            page = MyIO.readLine();
        }
    }
}