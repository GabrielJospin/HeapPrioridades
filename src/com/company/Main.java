package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static Heap heap = new Heap();
    static Random random = new Random();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

	    System.out.println("\t\t***Trabalho de IAA***");
        System.out.println("Maria Eduarda Rodrigues Garcia\t 11796621");
        System.out.println("Gabriel Medeiros Jospin\t 11796020");
        System.out.println("");

        while (true){
          System.out.println("Selecione a função a ser testada: ");
          System.out.println("1. imprime Chamado de Máxima Prioridade");
          System.out.println("2. extrai Chamado de Máxima Prioridade");
          System.out.println("3. insere Chamado");
          System.out.println("4. imprime fila de chamados");
          System.out.println("5. EXIT");
          int option = scan.nextInt();
          teste(option);
        }


//
//        for(int i = 1; i<4000;i++){
//            int key = random.nextInt(900000);
//            try{
//                Registro registro = new Registro(key);
//                if(heap.insert(registro))
//                    System.out.println('T');
//                else
//                    System.out.println('F');
//
//            }catch (Exception e){
//                System.out.println(e);
//            }
//
//        }
//
//        heap.Print(0,1);
//        for (int i = 0; i<heap.maxElementos;i++)
//            if(heap.heap[i]!=null)
//                System.out.printf("%.2f | %d\n",heap.heap[i].priority, heap.heap[i].id);
//

    }

    private static void teste(int option) {
        switch (option){
            case 1:
                testeMax();
                break;
            case 2:
                testeExtractMax();
                break;
            case 3:
                testeInsert();
                break;
            case 4:
                testePrint();
                break;
            case 5:
                System.exit(0);
            case 89:
                heap.Print(0,1);
                break;
            default:
                System.out.println("Opção Inválida, tente novamente");
        }
    }

    private static void testePrint() {
        heap.Print();
    }

    private static void testeInsert(){
        System.out.println("**Inserir elemento**");
        System.out.print("Insira o id: ");
        int id = scan.nextInt();
        System.out.print("Insira a prioridade: ");
        double prioridade = scan.nextDouble();
        Registro registro = null;

        try {
            registro = new Registro(id,prioridade);
        } catch (Exception e) {
            e.printStackTrace();
            testeInsert();
        }

        if(heap.insert(registro))
            System.out.println("T");
        else
            System.out.println("3F");

    }

    private static void testeExtractMax() {
        Registro max = heap.extractMax();
        if(max != null)
            System.out.printf("%d | %.1f \n",max.id,max.priority);
        else
            System.out.println("-1 -1,0");
    }

    private static void testeMax() {
        Registro max = heap.max();
        if(max != null)
            System.out.printf("%d | %.1f \n",max.id,max.priority);
        else
            System.out.println("-1 -1,0");
    }


}
