#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_FIELD_SIZE 100

typedef struct {
    char nome[MAX_FIELD_SIZE];
    char formato[MAX_FIELD_SIZE];
    char duracao[MAX_FIELD_SIZE];
    char pais[MAX_FIELD_SIZE];
    char idioma[MAX_FIELD_SIZE];
    char emissora[MAX_FIELD_SIZE];
    char transmissao[MAX_FIELD_SIZE];
    int num_temporadas;
    int num_episodios;
} Serie;

char *remove_line_break(char *line) {
    while (*line != '\r' && *line != '\n') line++;
    *line = '\0';
    return line;
}

char *freadline(char *line, int max_size, FILE *file) {
    return remove_line_break(fgets(line, max_size, file));
}

char *readline(char *line, int max_size) {
    return freadline(line, max_size, stdin);
}

void print_serie(Serie *serie) {
    printf("%s %s %s %s %s %s %s %d %d\n",
        serie->nome,
        serie->formato,
        serie->duracao,
        serie->pais,
        serie->idioma,
        serie->emissora,
        serie->transmissao,
        serie->num_temporadas,
        serie->num_episodios
    );
}

// Retorna o tamanho em bytes de um arquivo.
long tam_arquivo(FILE *file) {
    fseek(file, 0L, SEEK_END);
    long size = ftell(file);
    rewind(file);
    return size;
}

// Retorna todo o conteúdo do arquivo numa string.
char *ler_html(char filename[]) {
    FILE *file = fopen(filename, "r");
    if (!file) {
        fprintf(stderr, "Falha ao abrir arquivo %s\n", filename);
        exit(1);
    }
    long tam = tam_arquivo(file);
    char *html = (char *) malloc(sizeof(char) * (tam + 1));
    fread(html, 1, tam, file);
    fclose(file);
    html[tam] = '\0';
    return html;
}

/**
 * @brief Extrai os textos de uma tag html.
 * 
 * @param html Ponteiro para o caractere que abre a tag '<'.
 * @param texto Ponteiro para onde o texto deve ser colocado.
 * 
 * @return Ponteiro para o texto extraído.
 */
char *extrair_texto(char *html, char *texto) {
    char *start = texto;
    int contagem = 0;
    while (*html != '\0') {
        if (*html == '<') {
            if (
                (*(html + 1) == 'p') ||
                (*(html + 1) == 'b' && *(html + 2) == 'r') ||
                (*(html + 1) == '/' && *(html + 2) == 'h' && *(html + 3) == '1') ||
                (*(html + 1) == '/' && *(html + 2) == 't' && *(html + 3) == 'h') ||
                (*(html + 1) == '/' && *(html + 2) == 't' && *(html + 3) == 'd')
            ) break;
            else contagem++;
        }
        else if (*html == '>') contagem--;
        else if (contagem == 0 && *html != '"') {
            if (*html == '&') html = strchr(html, ';');
            else if (*html != '\r' && *html != '\n') *texto++ = *html;
        }
        html++;
    }
    *texto = '\0';
    return *start == ' ' ? start + 1 : start;
}

/**
 * @brief Lê o HTML da série e popula os campos da struct.
 * 
 * @param serie Struct Serie que vai receber os dados.
 * @param html String contendo todo o HTML do arquivo.
 */
void ler_serie(Serie *serie, char *html) {
    char texto[MAX_FIELD_SIZE];

    char *ptr = strstr(html, "<h1");
    extrair_texto(ptr, texto);

    char *parenteses_ptr = strchr(texto, '(');
    if (parenteses_ptr != NULL) *(parenteses_ptr - 1) = '\0';

    strcpy(serie->nome, texto);

    ptr = strstr(ptr, "<table class=\"infobox_v2\"");

    ptr = strstr(ptr, "Formato");
    ptr = strstr(ptr, "<td");
    strcpy(serie->formato, extrair_texto(ptr, texto));

    ptr = strstr(ptr, "Duração");
    ptr = strstr(ptr, "<td");
    strcpy(serie->duracao, extrair_texto(ptr, texto));

    ptr = strstr(ptr, "País de origem");
    ptr = strstr(ptr, "<td");
    strcpy(serie->pais, extrair_texto(ptr, texto));

    ptr = strstr(ptr, "Idioma original");
    ptr = strstr(ptr, "<td");
    strcpy(serie->idioma, extrair_texto(ptr, texto));

    ptr = strstr(ptr, "Emissora de televisão original");
    ptr = strstr(ptr, "<td");
    strcpy(serie->emissora, extrair_texto(ptr, texto));

    ptr = strstr(ptr, "Transmissão original");
    ptr = strstr(ptr, "<td");
    strcpy(serie->transmissao, extrair_texto(ptr, texto));

    ptr = strstr(ptr, "N.º de temporadas");
    ptr = strstr(ptr, "<td");
    sscanf(extrair_texto(ptr, texto), "%d", &serie->num_temporadas);

    ptr = strstr(ptr, "N.º de episódios");
    ptr = strstr(ptr, "<td");
    sscanf(extrair_texto(ptr, texto), "%d", &serie->num_episodios);
}

#define MAX_LINE_SIZE 250
#define PREFIXO "/tmp/series/"

int isFim(char line[]) {
    return line[0] == 'F' && line[1] == 'I' && line[2] == 'M';
}

Serie clonar(Serie *serie) {
    return *serie;
}

//começo das coisas de lista.
Serie array[100];
int nLista = 0;

//começo dos metodos descritos no TP.
void inserirInicio(Serie serie){
    int i;

    if(nLista >= 100){
        printf("Erro ao inserir1.");
        exit(1);
    }
    //levando a lista para tras para poder inserir elemento no inicio.
    for(i = nLista; i > 0; i--){
        array[i] = array[i-1];
    }
    array[0] = serie;
    nLista++;
}

void inserir(Serie serie, int pos){
    int i;

    if(nLista >= 100 || pos < 0 || pos > nLista) {
        printf("Erro ao inserir2.");
        exit(1);
    }
    //levando elementos para tras até a posição desejada.
    for(i = nLista; i > pos; i--){
        array[i] = array[i-1];
    }
    array[pos] = serie;
    nLista++;
}

void inserirFim(Serie serie){
    if(nLista >= 100){
        printf("Erro ao inserir3.");
        exit(1);
    }
    array[nLista] = clonar(&serie);
    nLista++;
}

Serie removerInicio(){
    int i;
    Serie removido;

    if(nLista == 0){
        printf("Erro ao remover1.");
        exit(1);
    }
    removido = array[0];
    nLista--;
    for(i = 0; i < nLista; i++){
        array[i] = array[i+1];
    }
    return removido; // função retorna elemento removido.
}

Serie remover(int pos) {
   int i;
   Serie removido;

   if (nLista == 0 || pos < 0 || pos >= nLista) {
      printf("Erro ao remover2.");
      exit(1);
   }
   removido = array[pos];
   nLista--;
   for(i = pos; i < nLista; i++){
      array[i] = array[i+1];
   }
   return removido;
}

Serie removerFim() {
   if (nLista == 0) {
      printf("Erro ao remover3.");
      exit(1);
   }
   return array[--nLista];
}

void mostrar (){
   int i;

   for(i = 0; i < nLista; i++){
      printf("%s %s %s %s %s %s %s %i %i\n", array[i].nome, array[i].formato, array[i].duracao, array[i].pais, array[i].idioma, array[i].emissora, array[i].transmissao, array[i].num_temporadas, array[i].num_episodios);
   }
}

//não sendo usada.
Serie acharLer(char entrada[]){
    Serie serie;
    char *html = ler_html(entrada);
    ler_serie(&serie, html);
    return serie;
}

//função sort da questão
Serie getMaior(int n) {
    Serie maior = array[0];

    for (int i = 0; i < n; i++) {
        if(maior.num_temporadas < array[i].num_temporadas){
            maior = array[i];
        }
    }
    return maior;
}

void countingSort(int n) {
    //Array para contar o numero de ocorrencias de cada elemento
    int tamCount = getMaior(n).num_temporadas + 1;
    int count[tamCount];
    Serie ordenado[n];

    //Inicializar cada posicao do array de contagem 
    for (int i = 0; i < tamCount; count[i] = 0, i++);

    //Agora, o count[i] contem o numero de elemento iguais a i
    for (int i = 0; i < n; count[array[i].num_temporadas]++, i++);

    //Agora, o count[i] contem o numero de elemento menores ou iguais a i
    for(int i = 1; i < tamCount; count[i] += count[i-1], i++);

    //Ordenando
    for(int i = n-1; i >= 0 ; ordenado[count[array[i].num_temporadas]-1] = array[i], count[array[i].num_temporadas]--, i--);

    //Ordenando Nomes
    for (int i = n-1; i >= 0; i--) {
        for(int j = 0; j < i; j++){
            if(ordenado[j].num_temporadas == ordenado[j+1].num_temporadas){
                if(strcmp(ordenado[j].nome, ordenado[j+1].nome) > 0){
                    Serie temp = ordenado[j];
                    ordenado[j] = ordenado[j+1];
                    ordenado[j+1] = temp;
                }
            }
        }
	}

    //Copiando para o array original
    for(int i = 0; i < n; array[i] = ordenado[i], i++);
}

int main() {
    Serie series[100];
    int nEntrada = 0;
    size_t tam_prefixo = strlen(PREFIXO);
    char line[MAX_LINE_SIZE];

    strcpy(line, PREFIXO);
    readline(line + tam_prefixo, MAX_LINE_SIZE);

    while (!isFim(line + tam_prefixo)) {
        char *html = ler_html(line);
        ler_serie(&series[nEntrada], html);
        inserirFim(series[nEntrada]);
        free(html);
        readline(line + tam_prefixo, MAX_LINE_SIZE);
        nEntrada++;
    }

    countingSort(nEntrada);
    
    mostrar();
    return EXIT_SUCCESS;
}