import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Date;


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
        this.nome = nome.trim();

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

class No {
    public Serie elemento; // Conteudo do no.
    public No esq, dir;  // Filhos da esq e dir.

    /**
     * Construtor da classe.
     * @param elemento Conteudo do no.
     */
    public No(Serie elemento) {
        this(elemento, null, null);
    }

    /**
     * Construtor da classe.
     * @param elemento Conteudo do no.
     * @param esq No da esquerda.
     * @param dir No da direita.
     */
    public No(Serie elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}

class AVB {
	private No raiz; // Raiz da arvore.

	/**
	 * Construtor da classe.
	 */
	public AVB() {
		this.raiz = null;
	}

	/**
	 * Metodo publico iterativo para pesquisar elemento.
	 * @param x Elemento que sera procurado.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	public boolean pesquisar(String x) {
		return pesquisar(x, raiz);
	}

	/**
	 * Metodo privado recursivo para pesquisar elemento.
	 * @param x Elemento que sera procurado.
	 * @param i No em analise.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	private boolean pesquisar(String x, No i) {
        boolean resp;

		if (i == null) {
            resp = false;

        }else if (x.equals(i.elemento.getNome())) {
         resp = true;

        } else if (x.compareTo(i.elemento.getNome()) < 0) {
            System.out.print(" esq");
            resp = pesquisar(x, i.esq);

        } else {
            System.out.print(" dir");
            resp = pesquisar(x, i.dir);

        }
        return resp;
	}

	/**
	 * Metodo publico iterativo para inserir elemento.
	 * @param x Elemento a ser inserido.
	 * @throws Exception Se o elemento existir.
	 */
	public void inserir(Serie x) throws Exception {
		raiz = inserir(x, raiz);
	}

	/**
	 * Metodo privado recursivo para inserir elemento.
	 * @param x Elemento a ser inserido.
	 * @param i No em analise.
	 * @return No em analise, alterado ou nao.
	 * @throws Exception Se o elemento existir.
	 */
	private No inserir(Serie x, No i) throws Exception {
		if (i == null) {
         i = new No(x);

        } else if (x.getNome().compareTo(i.elemento.getNome()) < 0) {
            i.esq = inserir(x, i.esq);

        } else if (x.getNome().compareTo(i.elemento.getNome()) > 0) {
            i.dir = inserir(x, i.dir);

        } else {
            throw new Exception("Erro ao inserir!");
        }

		return i;
	}

	/**
	 * Metodo publico iterativo para remover elemento.
	 * @param x Elemento a ser removido.
	 * @throws Exception Se nao encontrar elemento.
	 */
	public void remover(String x) throws Exception {
		raiz = remover(x, raiz);
	}

	/**
	 * Metodo privado recursivo para remover elemento.
	 * @param x Elemento a ser removido.
	 * @param i No em analise.
	 * @return No em analise, alterado ou nao.
	 * @throws Exception Se nao encontrar elemento.
	 */
	private No remover(String x, No i) throws Exception {

	    if (i == null) {
            throw new Exception("Erro ao remover!");

        } else if (x.compareTo(i.elemento.getNome()) < 0) {
            i.esq = remover(x, i.esq);

        } else if (x.compareTo(i.elemento.getNome()) > 0) {
            i.dir = remover(x, i.dir);

        } else if (i.dir == null) { // Sem no a direita.
            i = i.esq;

        } else if (i.esq == null) { // Sem no a esquerda.
            i = i.dir;
            
        } else { // No a esquerda e no a direita.
            i.esq = maiorEsq(i, i.esq);
		}

		return i;
	}

	/**
	 * Metodo para trocar o elemento "removido" pelo maior da esquerda.
	 * @param i No que teve o elemento removido.
	 * @param j No da subarvore esquerda.
	 * @return No em analise, alterado ou nao.
	 */
	private No maiorEsq(No i, No j) {
        // Encontrou o maximo da subarvore esquerda.
		if (j.dir == null) {
		    i.elemento = j.elemento; // Substitui i por j.
			j = j.esq; // Substitui j por j.ESQ.

		} else { // Existe no a direita.
         // Caminha para direita.
			j.dir = maiorEsq(i, j.dir);
		}
		return j;
	}

   /* SAIDA PADRÃO
       raiz dir dir dir dir dir esq NAO
       raiz dir dir dir dir dir dir dir dir dir dir dir dir dir dir dir dir dir esq NAO
       raiz dir dir esq dir dir esq esq dir NAO
       raiz dir dir dir dir dir dir dir dir dir esq dir NAO
       raiz dir dir dir dir dir dir dir SIM
       raiz dir dir dir dir dir dir dir dir SIM
       raiz dir dir dir dir dir dir dir dir dir esq dir NAO
       raiz dir dir dir dir dir dir dir dir dir SIM
       raiz dir dir dir dir dir dir dir dir dir dir SIM
       raiz dir dir dir dir dir dir dir dir dir dir dir esq NAO
       raiz dir dir dir dir dir dir dir dir dir dir dir dir esq dir dir NAO
       raiz dir dir dir dir dir dir dir dir dir dir dir dir SIM
   */
  /**
	 * Metodo publico iterativo para exibir elementos.
	 */
	public void caminharCentral() {
		System.out.print("[ ");
		caminharCentral(raiz);
		System.out.println("]");
	}

	/**
	 * Metodo privado recursivo para exibir elementos.
	 * @param i No em analise.
	 */
	private void caminharCentral(No i) {
		if (i != null) {
			caminharCentral(i.esq); // Elementos da esquerda.
			System.out.print(i.elemento.getNome() + " "); // Conteudo do no.
			caminharCentral(i.dir); // Elementos da direita.
		}
	}

}

class TP4ex1{
   static int comparacoes = 0;
   static int movimentacoes = 0;

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
    public static void palavraComando(String seriesInput, AVB arvore) throws Exception {
        if(seriesInput.charAt(0) == 'I') {
            String temp = seriesInput.substring(2);
            arvore.inserir(acharLer(temp));
        } else if(seriesInput.charAt(0) == 'R') {
            String temp = seriesInput.substring(2);
            arvore.remover(temp);
        }
    }

    public static long now(){
        return new Date().getTime();
    }  

    public static void main(String[] args) {
        MyIO.setCharset("UTF-8");
        int nEntrada = 0;
        int count = 0;
        Serie series = new Serie();
        String[] entrada = new String[1000];
        String alvoDePesquisa = "";

        //leitura do input.
        do {
            entrada[nEntrada] = MyIO.readLine();
        } while (entrada[nEntrada++].equals("FIM") == false);
        nEntrada--;

        AVB arvoreSerie = new AVB();

        //criando objetos series
        String[] arquivo = new String[100];
        for(int i = 0; i < nEntrada; i++) {
            arquivo[i] = "/tmp/series/";
            arquivo[i] += entrada[i]; 
        }
        for(int i = 0; i < nEntrada; i++) {
            try {
                series = new Serie();
                series.ler(arquivo[i]);
                arvoreSerie.inserir(series);
            } catch (Exception e) {}
        }

        //inserindo e removendo series na arvore.
        int amount = MyIO.readInt();
        String[] seriesInput = new String[amount];
        do {
            seriesInput[count] = MyIO.readLine();
            try{
                palavraComando(seriesInput[count], arvoreSerie);
            } catch (Exception e){}
            count++;
        } while (count < amount);

        //arvoreSerie.caminharCentral();

        //leitura dos inputs de pesquisa.
        long inicio = now();
        alvoDePesquisa = MyIO.readLine();
        do {
            System.out.print(" raiz");
            boolean resposta = arvoreSerie.pesquisar(alvoDePesquisa);

            if(resposta == true){
                System.out.println(" SIM");
            }else{
                System.out.println(" NAO");
            }

            alvoDePesquisa = MyIO.readLine();
        } while(alvoDePesquisa.equals("FIM") == false);
        long fim = now();
        double tempo = (fim - inicio)/1000.0;

        /*
        //gravar em matricula_sort.
        Arq.openWrite("729205_arvoreBinaria.txt", "UTF-8");
        Arq.print("Matrícula : 729205 \t");
        Arq.print("Tempo de Execução : " + tempo + "s \t");
        Arq.print("Numero de Comparações : " + comparacoes+10);
        Arq.print("Numero de Movimentações : " + movimentacoes+15);
        Arq.close();
        */
    }
}