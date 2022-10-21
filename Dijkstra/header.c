#include <stdlib.h>
#include <stdio.h>
#include <math.h>

#define BRANCO 0
#define CINZA 1
#define PRETO 2

typedef struct grafo *Grafo;
typedef struct resultado Resultado;
typedef struct Elemento Elemento;
typedef struct fila Fila;
typedef struct filaPrioridade fPrioridade;

struct grafo
{
    int **Matriz;
    int **peso;
    int vertices; // n
};
struct resultado
{
    int *predecessor;
    int *distancia;
};
struct Elemento
{
    int valor;
    struct Elemento *prox;
};
struct fila
{
    struct Elemento *inicio;
    struct Elemento *fim;
};
struct filaPrioridade
{
    struct Elemento *inicio;
    struct Elemento *fim;
};

// inicia o grafo em 0
Grafo iniciarGrafo(int n)
{
    int i, j;
    Grafo Gr = malloc(sizeof(Gr));

    Gr->vertices = n;
    Gr->Matriz = malloc(n * sizeof(int *));
    Gr->peso = malloc(n * sizeof(int *));

    for (i = 0; i < n; i++)
    {
        Gr->Matriz[i] = malloc(n * sizeof(int *));
        Gr->peso[i] = malloc(n * sizeof(int *));
    }
    for (i = 0; i < n; i++)
    {
        for (j = 0; j < n; j++)
        {
            Gr->Matriz[i][j] = 0;
            Gr->peso[i][j] = 0;
        }
    }
    return Gr;
}

// insere o arco v-w no grafo. se já existe não faz nada
void inserirArco(Grafo G, int v, int w, int peso)
{
    if (G->Matriz[v][w] == 0)
    {
        printf("\nAresta inserida!");
        G->Matriz[v][w] = 1;
        G->peso[v][w] = peso;
    }
    else
    {
        printf("\nEssa aresta já existe\n");
    }
}

// se existe remove
void removeArco(Grafo G, int v, int w)
{
    if (G->Matriz[v][w] == 1)
    {
        G->Matriz[v][w] = 0;
        G->peso[v][w] = 0;
        printf("\nAresta removida!\n");
    }
    else
    {
        printf("\nA aresta não existe\n");
    }
}

void imprimeMatriz(Grafo G)
{
    int i, j;
    for (i = 0; i < G->vertices; i++)
    {
        for (j = 0; j < G->vertices; j++)
        {
            printf("%d\t", G->Matriz[i][j]);
        }
        printf("\n");
    }
}

void imprimePesos(Grafo G)
{
    int i, j;
    for (i = 0; i < G->vertices; i++)
    {
        for (j = 0; j < G->vertices; j++)
        {
            printf("%d\t", G->peso[i][j]);
        }
        printf("\n");
    }
}

Grafo freeGrafo(Grafo G)
{
    int i;
    for (i = 0; i < G->vertices; i++)
    {
        free(G->Matriz[i]);
        G->Matriz[i] == NULL;
    }
    free(G->Matriz);
    G->Matriz = NULL;
    free(G);
    return NULL;
}

// aqui começa a parte de dijkstra

Fila *criaFila()
{
    Fila *f = (Fila *)malloc(sizeof(Fila));
    if (f != NULL)
    {
        f->fim = NULL;
        f->inicio = NULL;
    }
    return f;
}

void insereFila(Fila *f, int n)
{
    Elemento *novo = (Elemento *)malloc(sizeof(Elemento));
    novo->valor = n;
    novo->prox = NULL;

    // se estiver vazia insere como primeiro e ultimo
    if (f->inicio == NULL)
    {
        f->fim = novo;
        f->inicio = novo;
    }
    else
    {
        f->fim->prox = novo;
        f->fim = novo;
    }
}

int retiraInicio(Fila *f)
{
    Elemento *aux;
    int x;

    if (f->inicio == NULL)
    {
        printf("Fila Vazia");
    }
    else
    {
        aux = f->inicio;
        x = f->inicio->valor;
        f->inicio = f->inicio->prox;
        free(aux);
    }
    return x;
}

Resultado *criaResultado(int n)
{
    Resultado *r = (Resultado *)malloc(sizeof(Resultado));
    if (r != NULL)
    {

        r->predecessor = malloc(n * sizeof(int));
        r->distancia = malloc(n * sizeof(int));
    }

    // inicia todos em branco, predecessor nulo, tempo de descoberta e fim nulo
    for (int i = 0; i < n; i++)
    {
        r->predecessor[i] = -1;
        r->distancia[i] = 0;
    }

    return r;
}

fPrioridade *criaFilaPrioridade()
{
    fPrioridade *f = (fPrioridade *)malloc(sizeof(fPrioridade));
    if (f != NULL)
    {
        f->fim = NULL;
        f->inicio = NULL;
    }
    return f;
}

void insereFilaPrioridade(fPrioridade *f, int n)
{
    Elemento *novo = (Elemento *)malloc(sizeof(Elemento));
    novo->valor = n;
    novo->prox = NULL;

    // se estiver vazia insere como primeiro e ultimo
    if (f->inicio == NULL)
    {
        f->fim = novo;
        f->inicio = novo;
    }
    else
    {
        f->fim->prox = novo;
        f->fim = novo;
    }
}

int removeFilaPrioridade(fPrioridade *f)
{
    Elemento *aux;
    int x;

    if (f->inicio == NULL)
    {
        printf("Fila Vazia");
    }
    else
    {
        aux = f->inicio;
        x = f->inicio->valor;
        f->inicio = f->inicio->prox;
        free(aux);
    }
    return x;
}

void iniciarOrigemUnica(Grafo G, Resultado *r, int origem)
{
    for (int i = 0; i < G->vertices; i++)
    {
        r->distancia[i] = __INT_MAX__; // infinito
        r->predecessor[i] = -1; // nulo
    }
    r->distancia[origem] = 0;
}

void relaxa(Grafo G, Resultado *r, int u, int v)
{
    if (r->distancia[v] > r->distancia[u] + G->peso[u][v])
    {
        r->distancia[v] = r->distancia[u] + G->peso[u][v];
        r->predecessor[v] = u;
    }
}

int extract_min(fPrioridade *f)
{
    // retorna o menor elemento da fila
    int min = f->inicio->valor;
    
    Elemento *aux = f->inicio;
    f->inicio = f->inicio->prox;
    free(aux);
    return min;
}

Grafo Dijkstra(Grafo G, Resultado *r, int origem)
{
    iniciarOrigemUnica(G, r, origem);
    fPrioridade *P = criaFilaPrioridade(); // cria fila de prioridade vazia
    Fila *S = criaFila();                  // cria conjunto solução

    // insere todos os vertices na fila de prioridade
    for (int i = 0; i < G->vertices; i++)
    {
        insereFilaPrioridade(P, i);
    }

    // enquanto a fila de prioridade não estiver vazia
    while (P->inicio != NULL)
    {
        int u = extract_min(P); // extrai o vertice com menor distancia
        insereFila(S, u);              // insere na solução o vertice u

        // pra cada vertice v pertencente a Adj[u] relaxa
        for (int i = 0; i < G->vertices; i++)
        {
            if (G->Matriz[u][i] != 0)
            {
                relaxa(G, r, u, i);
            }
        }
    }
}

void imprimeResultado(Resultado *r, int n)
{
    printf("\nVértices\n");
    for (int i = 0; i < n; i++)
    {
        printf("%d\t", i);
    }
    printf("\n");
    printf("Predecessor:\n");
    for (int i = 0; i < n; i++)
    {
        printf("%d\t", r->predecessor[i]);
    }
    printf("\n");
    printf("Distancia:\n");
    for (int i = 0; i < n; i++)
    {
        printf("%d\t", r->distancia[i]);
    }
    printf("\n");
}