import java.util.Scanner;

import static javax.management.Query.and;


public class Main {
    public static <c> void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //new Screen();

        int multiplo = 0;
        int laco = 0;


        System.out.println("Informe a ordem do grafo: ");
        int ordem = scan.nextInt();

        System.out.println("Informe a quantidade de arestas do grafo: ");
        int arestas = scan.nextInt();
        int matrizAdj [][] = new int [ordem][ordem];
        int matrizInc [][] = new int [ordem][arestas];

        System.out.println("O grafo é orientado? true/false: ");
        Boolean orient = scan.nextBoolean();

        for (int i = 0; i < ordem; i++){
            for (int j = 0; j < ordem; j++){
                matrizAdj[i][j] = 0;
            }
        }

        for (int i = 0; i < ordem; i++){
            for (int j = 0; j < arestas; j++){
                matrizAdj[i][j] = 0;
            }
        }

        for (int e = 1; e <= arestas; e++){
            System.out.println("Aresta " + e);
            System.out.println("Vértice de saída: ");
            int verSai = scan.nextInt();
            System.out.println("Vértice de entrada: ");
            int verEnt = scan.nextInt();
            if (orient){
                matrizAdj [verSai - 1] [verEnt - 1] = 1;
                matrizInc [verSai - 1] [e - 1] = -1;
                matrizInc [verEnt - 1] [e - 1] = 1;
            }
            else{
                if (matrizAdj [verEnt - 1] [verSai - 1] >= 1){
                    matrizAdj [verEnt - 1] [verSai - 1] ++ ;
                    matrizAdj [verSai - 1] [verEnt - 1] ++ ;
                }
                else{
                    matrizAdj [verEnt - 1] [verSai - 1] = 1;
                    matrizAdj [verSai - 1] [verEnt - 1] = 1;
                }
                matrizInc [verEnt - 1] [e - 1] = 1;
                matrizInc [verSai - 1] [e - 1] = 1;
            }
            if(verEnt == verSai){ laco ++ ; }
        }

        if (orient) { System.out.println("\nMatriz de Adjacência do grafo orientado: ");}
        else { System.out.println("\nMatriz de Adjacência do grafo não orientado: ");}
        for (int i = 0; i < ordem; i++) {
            System.out.println();
            for (int j = 0; j < ordem; j++) {
                System.out.print(matrizAdj[i][j] + "   ");
                if (matrizAdj[i][j] > 1) {
                    multiplo = matrizAdj[i][j];
                }
            }
            System.out.println();
        }

        if (orient) { System.out.println("\nMatriz de Incidência do grafo orientado: ");}
        else { System.out.println("\nMatriz de Incidcência do grafo não orientado: ");}
        for (int i = 0; i < ordem; i++) {
            System.out.println();
            for (int j = 0; j < arestas; j++) {
                System.out.print(matrizInc[i][j] + "   ");
            }
        }

        System.out.println("\n\nInformações :");

        if (multiplo >1) {
            if (multiplo ==2) { System.out.println("\n - O grafo possui 1 aresta múltipla.");}
            else { System.out.println("\n - O grafo possui " + (multiplo - 1) +" arestas múltiplas.");}
        }
        else if (arestas ==0){ System.out.println("\n- Grafo trivial, não possui arestas. ");}
        else{ System.out.println("\n- Grafo simples, não possui arestas múltiplas. ");}

        if (laco ==0) { System.out.println("\n- O grrafo não possui laço. ");}
        else if (laco ==1) { System.out.println("\n- O grrafo possui " + laco + " laço. ");}
        else { System.out.println("\n- O grrafo possui " + laco + " laços. ");}

        int k = (ordem * (ordem-1))/2;
        if (arestas == k){ System.out.println("\n- Grafo completo, todos os vértices são adjacentes. ");}



        scan.close();
    }
}