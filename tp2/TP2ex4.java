import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Date;

class Serie{
    private String nome;
    private String formato;
    private String duracao;
    private String paisOrigem;
    private String idioma;
    private String emissora;
    private String transmissao;
    private int nTemporadas;
    private int nEpisodios;

    Serie(){
        this.nome = "";
        this.formato = "";
        this.duracao = "";
        this.paisOrigem = "";
        this.idioma = "";
        this.emissora = "";
        this.transmissao = "";
        this.nTemporadas = 0;
        this.nEpisodios = 0;
    }

    Serie(String nome, String formato, String duracao, String paisOrigem, String idioma,
            String emissora, String transmissao, int nTemporadas, int nEpisodios){
        this.nome = nome;
        this.formato = formato;
        this.duracao = duracao;
        this.paisOrigem = paisOrigem;
        this.idioma = idioma;
        this.emissora = emissora;
        this.transmissao = transmissao;
        this.nTemporadas = nTemporadas;
        this.nEpisodios = nEpisodios;
    }

    public Serie Clone(){
        Serie clone = new Serie();
        clone.nome = this.nome;
        clone.formato = this.formato;
        clone.duracao = this.duracao;
        clone.paisOrigem = this.paisOrigem;
        clone.idioma = this.idioma;
        clone.emissora = this.emissora;
        clone.transmissao = this.transmissao;
        clone.nTemporadas = this.nTemporadas;
        clone.nEpisodios = this.nEpisodios;
        return clone;
    }

    //metodos get/set.
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getFormato(){
        return formato;
    }

    public void setFormato(String formato){
        this.formato = formato;
    }

    public String getDuracao(){
        return duracao;
    }

    public void setDuracao(String duracao){
        this.duracao = duracao;
    }

    public String getPaisOrigem(){
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem){
        this.paisOrigem = paisOrigem;
    }

    public String getIdioma(){
        return idioma;
    }

    public void setIdioma(String idioma){
        this.idioma = idioma;
    }

    public String getemissora(){
        return emissora;
    }

    public void setemissora(String emissora){
        this.emissora = emissora;
    }

    public String gettransmissao(){
        return transmissao;
    }

    public void settransmissao(String transmissao){
        this.transmissao = transmissao;
    }

    public int getnTemporadas(){
        return nTemporadas;
    }

    public void setnTemporadas(int nTemporadas){
        this.nTemporadas = nTemporadas;
    }

    public int getnEpisodios(){
        return nEpisodios;
    }

    public void setnEpisodios(int nEpisodios){
        this.nEpisodios = nEpisodios;
    }

    public void ler(String nomeArquivo) throws Exception{
        InputStreamReader isr = new InputStreamReader(new FileInputStream(nomeArquivo));
        BufferedReader br = new BufferedReader(isr);

        int posPonto = 0;
        for(int i = 0; i < nomeArquivo.length(); i++){
            if(nomeArquivo.charAt(i) == '.'){
                posPonto = i;
            }
        }
        String nome = nomeArquivo.substring(12, posPonto);
        nome = nome.replace('_', ' ');
        this.nome = nome;

        while(!br.readLine().contains("Formato"));
        this.formato = removeTags(br.readLine()).replaceAll("&#160;", "").replaceAll("&nbsp;", "").trim();

        while(!br.readLine().contains("Duração"));
        this.duracao = removeTags(br.readLine()).replaceAll("&#160;", "").replaceAll("&nbsp;", "").trim();

        while(!br.readLine().contains("País de origem"));
        this.paisOrigem = removeTags(br.readLine()).replaceAll("&#160;", "").replaceAll("&nbsp;", "").trim();

        while(!br.readLine().contains("Idioma original"));
        this.idioma = removeTags(br.readLine()).replaceAll("&#160;", "").replaceAll("&nbsp;", "").trim();

        while(!br.readLine().contains("Emissora de televisão original"));
        this.emissora = removeTags(br.readLine()).replaceAll("&#160;", "").replaceAll("&nbsp;", "").trim();

        while(!br.readLine().contains("Transmissão original"));
        this.transmissao = removeTags(br.readLine()).replaceAll("&#160;", "").replaceAll("&nbsp;", "").trim();

        while(!br.readLine().contains("N.º de temporadas"));
        String numTe = removeTags(br.readLine()).trim();
        String guardaNum = "";
        for(int i = 0; i < numTe.length(); i++){
            if(numTe.charAt(i) == '0' || numTe.charAt(i) == '1' || numTe.charAt(i) == '2' || numTe.charAt(i) == '3' || numTe.charAt(i) == '4' ||
            numTe.charAt(i) == '5' || numTe.charAt(i) == '6' || numTe.charAt(i) == '7' || numTe.charAt(i) == '8' || numTe.charAt(i) == '9'){
                guardaNum = guardaNum + numTe.charAt(i);
            } else if(numTe.charAt(i) == '(' || numTe.charAt(i) == '-' || numTe.charAt(i) == '+' || numTe.charAt(i) == ' '){
                break;
            }
        }
        int num = Integer.parseInt(guardaNum);
        this.nTemporadas = num;

        while(!br.readLine().contains("N.º de episódios"));
        String numEp = removeTags(br.readLine()).trim();
        guardaNum = "";
        for(int i = 0; i < numEp.length(); i++){
            if(numEp.charAt(i) == '0' || numEp.charAt(i) == '1' || numEp.charAt(i) == '2' || numEp.charAt(i) == '3' || numEp.charAt(i) == '4' ||
            numEp.charAt(i) == '5' || numEp.charAt(i) == '6' || numEp.charAt(i) == '7' || numEp.charAt(i) == '8' || numEp.charAt(i) == '9'){
                guardaNum = guardaNum + numEp.charAt(i);
            } else if(numEp.charAt(i) == '(' || numEp.charAt(i) == '-' || numEp.charAt(i) == '+' || numEp.charAt(i) == ' '){
                break;
            }
        }
        num = Integer.parseInt(guardaNum);
        this.nEpisodios = num;

        br.close();
    }

    //metodo removedor de tags <>.
    String removeTags(String line){
        String newLine = "";
        int i = 0;

        while(i < line.length()){
            if(line.charAt(i) == '<'){
                i++;
                while(line.charAt(i) != '>'){
                    i++;
                }
            } else{
                newLine += line.charAt(i);
            }
            i++;
        }
        return newLine;
    }
}

class TP2ex4{
    static int comparacoes = 0;

    public static Serie[] acharLer(String[] input, int nInput) throws Exception{
        Serie[] serie = new Serie[nInput]; 
        String[] arquivo = new String[100];

        for(int i = 0; i < nInput; i++){
            arquivo[i] = "/tmp/series/";
            arquivo[i] += input[i]; 
        }

        for(int i = 0; i < nInput; i++){
            serie[i] = new Serie();
            serie[i].ler(arquivo[i]);
        }
       return serie;
    }

    public static boolean pesquisaBinaria(String seriesPesquisa, int nSeries, Serie[] series){
        boolean resp = false;
        int ult = series.length - 1;
        int prim = 0;

        while(prim <= ult && resp != true){
            int meio = (prim+ult)/2;
            if(seriesPesquisa.equals(series[meio].getNome())){
                comparacoes++;
                resp = true;
            }else{
                if(series[meio].getNome().charAt(0) < seriesPesquisa.charAt(0)){
                    comparacoes++;
                    prim = meio + 1;
                }else{
                    comparacoes++;
                    ult = meio - 1;
                }
            }
        }
        return resp;
    }

    public static long now(){
        return new Date().getTime();
    }  

    public static void main(String[] args) throws Exception{
        MyIO.setCharset("UTF-8");
        String[] input = new String[1000];
        String[] seriesPesquisa = new String[1000];
        int nInput = 0;
        int nSeries = 0;

        //leitura do primeiro input(nome do arquivo).
        do{
            input[nInput] = MyIO.readLine();
        } while (input[nInput++].equals("FIM") == false);
        nInput--;
        Serie[] series = acharLer(input, nInput);

        //leitura do segundo input(o que vai ser pesquisado).
        do{
            seriesPesquisa[nSeries] = MyIO.readLine();
        } while (seriesPesquisa[nSeries++].equals("FIM") == false );
        nSeries--;

        //organizando series.nome para a pesquisa binária.
        String temp;
        int n = series.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                //comparando strings.
                if(series[i].getNome().compareTo(series[j].getNome()) > 0) {
                    //organizando.
                    temp = series[i].getNome();
                    series[i].setNome(series[j].getNome());
                    series[j].setNome(temp);
                }
            }
        }

        //println SIM/NAO para a pesquisa do elemento.
        long inicio = now();
        for(int i = 0; i < nSeries; i++){
            if(pesquisaBinaria(seriesPesquisa[i], nSeries, series) == true){
                MyIO.println("SIM");
            }else{
                MyIO.println("NÃO");
            }
        }
        long fim = now();
        double tempo = (fim - inicio)/1000;

        //gravar em matricula_binaria.
        Arq.openWrite("matrícula_binaria.txt", "UTF-8");
        Arq.print("Matrícula : 729205 \t");
        Arq.print("Tempo de Execução : " + tempo + "s \t");
        Arq.print("Número de Comparações : " + comparacoes);
        Arq.close();
    }
}