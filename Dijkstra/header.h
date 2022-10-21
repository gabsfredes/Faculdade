typedef struct grafo *Grafo; 
Grafo iniciarGrafo(int n);
void inserirArco(Grafo G, int v, int w, int peso);
void removeArco(Grafo G, int v, int w);
void imprimirGrafo(Grafo G);
Grafo freeGrafo(Grafo G);
void imprimeMatriz(Grafo G); 

typedef struct resultado Resultado;
typedef struct Elemento Elemento;
typedef struct fila Fila;

Fila *criaFila();
void insereFila(Fila *f, int n);
int retiraInicio(Fila *f);

Resultado *criaResultado (int n);

typedef struct filaPrioridade fPrioridade;
Grafo Dijkstra (Grafo G, Resultado *r, int origem);
void iniciarOrigemUnica(Grafo G, Resultado *r, int origem);
void relaxa(Grafo G, Resultado *r, int u, int v);
fPrioridade *criaFilaPrioridade();
void insereFilaPrioridade(fPrioridade *f, int n);
int removeFilaPrioridade(fPrioridade *f);
int extract_min(fPrioridade *f);
void imprimeResultado (Resultado *r, int n);
