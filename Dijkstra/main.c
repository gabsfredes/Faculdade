/* 
Gabriel dos Santos Fredes e Gabriel Bitencourt Cardoso
*/
#include <stdlib.h>
#include <stdio.h>
#include <locale.h>
#include "header.h"

/*
Implemente em C o algoritmo de Dijkstra para a busca do caminho m�nimo de origem �nica
em grafos orientados ponderados. O programa dever� imprimir na tela os caminhos m�nimos
do nodo de origem para os demais nodos.

Dever� ser implementado um menu contendo a inser��o de arestas, a impress�o do grafo, a
gera��o do caminho m�nimo e a impress�o do caminho m�nimo.
*/

int main(void)
{
	setlocale(LC_ALL, "Portuguese");
	int n, op, vert, ares, origem, peso;

	printf("Quantos vert�ces no grafo? ");
	scanf("%i", &n);

	Grafo *gr;
	gr = iniciarGrafo(n);

	do
	{
		printf("\n----------\n1 - Inserir Aresta");
		printf("\n2 - Remover Aresta");
		printf("\n3 - Imprimir Grafo");
		printf("\n4 - Dijkstra");
		printf("\n5 - Sair\n----------");
		printf("\nInforme sua op��o: ");
		scanf("%i", &op);

		switch (op)
		{
		case 1:
			printf("\nInforme a origem: ");
			scanf("%i", &vert);
			printf("Informe a destino: ");
			scanf("%i", &ares);
			printf("Informe o peso: ");
			scanf("%i", &peso);
			inserirArco(gr, vert, ares, peso);
			break;
		case 2:
			printf("\nInforme a aresta: ");
			scanf("%i", &vert);
			scanf("%i", &ares);
			removeArco(gr, vert, ares);
			break;

		case 3:
			printf("\nGrafo:\n");
			imprimeMatriz(gr);
			printf("\nPesos:\n");
			imprimePesos(gr);
			break;
		case 4:
			printf("\nInforme a origem: ");
			scanf("%i", &origem);

			Resultado *r;
			r = criaResultado(n);

			Dijkstra(gr, r, origem);
			printf("\n\nResultado:\n");
			imprimeResultado(r, n);

			break;
		case 5:
			freeGrafo(gr);
			printf("\nMem�ria liberada!\nO Programa ser� encerrado.\n");
			
			//encerra o programa
			op = 5;
			system("pause");
			return 0;
			break;
		}

	} while (op != 5);
	system("pause");
	return 0;
}
