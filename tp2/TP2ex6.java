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

class Pilha {
    private Serie[] array;
    private int qtde;

    public Pilha() {
        this(50);
    }

    public Pilha(int size) {
        array = new Serie[size];
        qtde = 0;
    }

    //metodos descritos no TP.
    public void empilhar(Serie item) throws Exception {
        if(qtde >= array.length) {
            throw new Exception("Erro ao inserir");
        }
        array[qtde] = item;
        qtde++;
    }

    public Serie desempilhar() throws Exception {
        if(qtde == 0) {
            throw new Exception("Erro ao remover");
        }
        return array[--qtde];
    }

    public void mostrar() {
        for (int i = qtde-1; i >= 0; i--) {
			System.out.println(array[i]);
		}
    }
}

class TP2ex6{
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
    public static void palavraComando(String seriesInput, Pilha pilha) throws Exception {
        if(seriesInput.charAt(0) == 'I') {
            String[] temp = seriesInput.split(" ");
            pilha.empilhar(acharLer(temp[1]));
        } else if(seriesInput.charAt(0) == 'R') {
            removed[countRemoved] = pilha.desempilhar();
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
        String[] entrada = new String[1000];

        //leitura do input.
        do {
            entrada[nEntrada] = MyIO.readLine();
        } while (entrada[nEntrada++].equals("FIM") == false);
        nEntrada--;

        Pilha pilhaSerie = new Pilha();
        try{
            for(int i = 0; i < nEntrada; i++) {
            pilhaSerie.empilhar(acharLer(entrada[i]));
            }
        }catch (Exception e){}
        

        int amount = MyIO.readInt();
        String[] seriesInput = new String[amount];

        //lendo demais inputs e manipulando lista baseado nos comandos descritos no TP.
        do {
            seriesInput[count] = MyIO.readLine();
            try{
                palavraComando(seriesInput[count], pilhaSerie);
            } catch (Exception e){}
            count++;
        } while (count < amount);

        imprimirRemoved();
        pilhaSerie.mostrar();
    }
}