import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Serie {
    private String nome;
    private String formato;
    private String duracao;
    private String paisOrigem;
    private String idioma;
    private String emissora;
    private String transmissao;
    private int nTemporadas;
    private int nEpisodios;

    Serie() {
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

    Serie(String nome, String formato, String duracao, String paisOrigem, String idioma, String emissora, String transmissao, int nTemporadas, int nEpisodios) {
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

    //clone.
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

    //get e sets das variaveis.
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getEmissora() {
        return emissora;
    }

    public void setEmissora(String emissora) {
        this.emissora = emissora;
    }

    public String getTransmissao() {
        return transmissao;
    }

    public void setTransmissao(String transmissao) {
        this.transmissao = transmissao;
    }

    public int getnTemporadas() {
        return nTemporadas;
    }

    public void setnTemporadas(int nTemporadas) {
        this.nTemporadas = nTemporadas;
    }

    public int getnEpisodios() {
        return nEpisodios;
    }

    public void setnEpisodios(int nEpisodios) {
        this.nEpisodios = nEpisodios;
    }

    //leitura do arquivo e atribuições das variaveis.
    public void ler(String nomeArquivo) throws Exception {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(nomeArquivo));
        BufferedReader br = new BufferedReader(isr);

        int posPonto = 0;
        for(int i = 0; i < nomeArquivo.length(); i++) {
            if(nomeArquivo.charAt(i) == '.') {
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
        for(int i = 0; i < numTe.length(); i++) {
            if(numTe.charAt(i) == '0' || numTe.charAt(i) == '1' || numTe.charAt(i) == '2' || numTe.charAt(i) == '3' || numTe.charAt(i) == '4' ||
            numTe.charAt(i) == '5' || numTe.charAt(i) == '6' || numTe.charAt(i) == '7' || numTe.charAt(i) == '8' || numTe.charAt(i) == '9') {
                guardaNum = guardaNum + numTe.charAt(i);
            } else if(numTe.charAt(i) == '(' || numTe.charAt(i) == '-' || numTe.charAt(i) == '+' || numTe.charAt(i) == ' ') {
                break;
            }
        }
        int num = Integer.parseInt(guardaNum);
        this.nTemporadas = num;

        while(!br.readLine().contains("N.º de episódios"));
        String numEp = removeTags(br.readLine()).trim();
        guardaNum = "";
        for(int i = 0; i < numEp.length(); i++) {
            if(numEp.charAt(i) == '0' || numEp.charAt(i) == '1' || numEp.charAt(i) == '2' || numEp.charAt(i) == '3' || numEp.charAt(i) == '4' ||
            numEp.charAt(i) == '5' || numEp.charAt(i) == '6' || numEp.charAt(i) == '7' || numEp.charAt(i) == '8' || numEp.charAt(i) == '9') {
                guardaNum = guardaNum + numEp.charAt(i);
            } else if(numEp.charAt(i) == '(' || numEp.charAt(i) == '-' || numEp.charAt(i) == '+' || numEp.charAt(i) == ' ') {
                break;
            }
        }
        num = Integer.parseInt(guardaNum);
        this.nEpisodios = num;
        br.close();
    }

    //metodo para printar corretamente os elementos da classe.
    public String toString() {
        return nome + " " + formato + " " + duracao + " " + paisOrigem + " " + idioma + " " + emissora + " " + transmissao + " " + nTemporadas + " " + nEpisodios;
    }

    //metodo removedor de tags <>
    String removeTags(String line) {
        String newLine = "";

        int i = 0;
        while(i < line.length()) {
            if(line.charAt(i) == '<') {
                i++;
                while(line.charAt(i) != '>') {
                    i++;
                }
            } else {
                newLine += line.charAt(i);
            }
            i++;
        }
        return newLine;
    }
}

class Lista {
    private Serie[] array;
    private int n;

    public Lista() {
        this(100);
    }

    public Lista(int size) {
        array = new Serie[size];
        n = 0;
    }

    public Serie[] getArray() {
        return this.array;
    }

    public int getTamanhoArray() {
        return this.array.length;
    }

    //metodos descritos no TP.
    public void inserirInicio(Serie serie) throws Exception {
        if(n >= array.length) {
            throw new Exception("Erro ao inserir objeto!");
        }
        for(int i = n; i > 0; i--) {
            array[i] = array[i - 1].Clone();
        }
        array[0] = serie.Clone();
        n++;
    }

    public void inserir(Serie serie, int posicao) throws Exception {
        if(n >= array.length || posicao < 0 || posicao > n) {
            throw new Exception("Erro ao inserir objeto na posicao: " + posicao);
        }
        for(int i = n; i > posicao; i--) {
            array[i] = array[i - 1].Clone();
        }
        array[posicao] = serie.Clone();
        n++;
    }

    public void inserirFim(Serie serie) throws Exception {
        if(n >= array.length) {
            throw new Exception("Erro ao inserir objeto!");
        }
        array[n] = serie.Clone();
        n++;
    }

    public Serie removerInicio() throws Exception {
        if(n == 0) {
            throw new Exception("Erro ao remover, tamanho igual a zero!");
        }

        Serie resp = array[0].Clone();
        n--;

        for(int i = 0; i < n; i++) {
            array[i] = array[i + 1].Clone();
        }
        return resp;
    }

    public Serie remover(int posicao) throws Exception {
        if(n == 0 || posicao < 0 || posicao >= n) {
            throw new Exception("Erro ao remover");
        }

        Serie resp = array[posicao];
        n--;
        
        for(int i = posicao; i < n; i++) {
            array[i] = array[i + 1].Clone();
        }
        return resp;
    }

    public Serie removerFim() throws Exception {
        if(n == 0) {
            throw new Exception("Erro ao remover do final!");
        }
        return array[--n];
    }

    public void mostrar() {
        for(int i = 0; i < n; i++) {
            System.out.println(array[i]);
        }
    }
}

class TP2ex5{
    //guardar e contar as series removidas.
    static Serie[] removed = new Serie[20];   
    static int countRemoved = 0;

    //metodo para facilitar o processo de pegar e ler o arquivo .html
    public static Serie acharLer(String entrada) throws Exception {
        Serie serie = new Serie(); 
        String arquivo = "";

        arquivo = "/tmp/series/";
        arquivo += entrada; 
        serie = new Serie();
        serie.ler(arquivo);

        return serie;
    }                          

    //metodo para interpretar as palavras comandos descritas no TP.
    public static void palavraComando(String seriesEntrada, Lista lista) throws Exception {
        String[] temp = new String[2];

        if(seriesEntrada.charAt(0) == 'I' && seriesEntrada.charAt(1) == 'I') {
            temp = seriesEntrada.split(" ");
            lista.inserirInicio(acharLer(temp[1]));
        } else if(seriesEntrada.charAt(0) == 'I' && seriesEntrada.charAt(1) == 'F') {
            temp = seriesEntrada.split(" ");
            lista.inserirFim(acharLer(temp[1]));
        } else if(seriesEntrada.charAt(0) == 'I' && seriesEntrada.charAt(1) == '*') {
            temp = seriesEntrada.split(" ");
            lista.inserir(acharLer(temp[2]), Integer.parseInt(temp[1]));
        } else if(seriesEntrada.charAt(0) == 'R' && seriesEntrada.charAt(1) == '*') {
            temp = seriesEntrada.split(" ");
            removed[countRemoved] = lista.remover(Integer.parseInt(temp[1]) );
            countRemoved++;
        } else if(seriesEntrada.charAt(0) == 'R' && seriesEntrada.charAt(1) == 'I') {
            removed[countRemoved] = lista.removerInicio();
            countRemoved++;
        } else if(seriesEntrada.charAt(0) == 'R' && seriesEntrada.charAt(1) == 'F') {
            removed[countRemoved] = lista.removerFim();
            countRemoved++;
        }
    }

    public static void imprimirRemoved() {
        for(int i = 0; i < countRemoved; i++) {
            MyIO.println("(R) "+ removed[i].getNome());
        }
    }

    public static void main(String[] args) {
        MyIO.setCharset("UTF-8");
        int nEntrada = 0;
        int count = 0;
        Serie series = new Serie();
        Lista listaSerie = new Lista(100);
        String[] entrada = new String[1000];
        String[] seriesEntrada = new String[1000];

        //leitura do input.
        do {
            entrada[nEntrada] = MyIO.readLine();
        } while (entrada[nEntrada++].equals("FIM") == false);
        nEntrada--;

        //criando objetos series e manipulando lista.
        String[] arquivo = new String[100];
        for(int i = 0; i < nEntrada; i++) {
            arquivo[i] = "/tmp/series/";
            arquivo[i] += entrada[i]; 
        }
        for(int i = 0; i < nEntrada; i++) {
            try {
                series.ler(arquivo[i]);
                listaSerie.inserirFim(series);
            } catch (Exception e) {}
        }

        //lendo demais inputs e manipulando lista baseado nos comandos descritos no TP.
        int amount = MyIO.readInt();
        do {
            seriesEntrada[count] = MyIO.readLine();
            try{
                palavraComando(seriesEntrada[count], listaSerie);
            } catch (Exception e){}
            count++;
        } while (count < amount);

        imprimirRemoved();
        listaSerie.mostrar();
    }
}