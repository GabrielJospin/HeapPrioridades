//package com.company;

public class Heap {
    Registro[] heap; //vetor A
    int maxElementos; //maximo de eletos de A
    int size; //m - quantidade atual de eletos no heap

    Heap(){
        this.heap = new Registro[4000];
        this.maxElementos = 4000;
        size = 0;
    }

    public Registro max(){ //eleto que possui maior prioridade é raiz
        if(size == 0){
            Registro rg = new Registro();
            return rg;
        }
        else return heap[0];
    }

    public void maxHeapify(int posicao){
        int filhoEsq = GetPositionLeft(posicao);
        int filhoDir = GetPositionRight(posicao);
        int maior = posicao;
        if(filhoDir > 0 && filhoDir <= size){
            if(heap[filhoDir].priority > heap[filhoEsq].priority)   maior=filhoDir;
        }
        if(filhoEsq > 0 && filhoEsq <= size){
            if(heap[filhoEsq].priority > heap[maior].priority)  maior = filhoEsq;
        }
        

        if(maior != posicao){
            Registro rg = heap[posicao];
            heap[posicao] = heap[maior];
            heap[maior] = rg;
            maxHeapify(maior);
        }
         
    }

    public Registro extractMax(){
        if(size==0){
            Registro rg = new Registro();
            return rg;
        }
        else{
            Registro aux = heap[0];
            heap[0] = heap[size-1];
            size--;
            maxHeapify(0); //raiz desorganizada
            return aux;
        }
        
    }

    

    public boolean insert(Registro rg){
        if(size >= maxElementos)
                return false;

        heap[size]=null;
        increaseKey(size,rg);
        size++;
        return true;
    }

    public void Print(int position, int displacement){
        if(position>=maxElementos){
            return;
        }
        int left = GetPositionLeft(position);
        int right = GetPositionRight(position);

        if(right<maxElementos && heap[right] != null) Print(right,displacement+1);
        for(int i = 1;i<displacement;i++)System.out.print("     ");
        System.out.println(heap[position].priority +" "+heap[position].id);
        if(left<maxElementos && heap[left] != null) Print(left,displacement+1);


    }

    public void Print(){
        for(int i = 0; i<size;i++){
            System.out.printf("%d %.1f| ",heap[i].id,heap[i].priority);
        }
        System.out.println();
    }


    public void increaseKey(int position, Registro register){
        heap[position]=register;
        int dad = GetPositionDad(position);
        while ((position>0) && heap[dad].priority < heap[position].priority ){
            Registro helper;
            helper = heap[dad];
            heap[dad] = heap[position];
            heap[position] = helper;
            position = GetPositionDad(position);
            dad = GetPositionDad(position);
        }

    }

    public int GetPositionDad (int i){
        return (i-1)/2;
    }

    public int GetPositionRight(int i){
        return 2*i + 2;
    }

    public int GetPositionLeft(int i){
        return 2*i + 1;
    }

}
