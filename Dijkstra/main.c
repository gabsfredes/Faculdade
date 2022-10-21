/* 
Gabriel dos Santos Fredes e Gabriel Bitencourt Cardoso
*/
#include <stdlib.h>
#include <stdio.h>
#include <locale.h>
#include "header.h"

/*
Implemente em C o algoritmo de Dijkstra para a busca do caminho mínimo de origem única
em grafos orientados ponderados. O programa deverá imprimir na tela os caminhos mínimos
do nodo de origem para os demais nodos.

Deverá ser implementado um menu contendo a inserção de arestas, a impressão do grafo, a
geração do caminho mínimo e a impressão do caminho mínimo.
*/

int main(void)
{
	setlocale(LC_ALL, "Portuguese");
	int n, op, vert, ares, origem, peso;

	printf("Quantos vertíces no grafo? ");
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
		printf("\nInforme sua opção: ");
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
			printf("\nMemória liberada!\nO Programa será encerrado.\n");
			
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
