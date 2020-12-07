package com.company;

public class Heap {
    Registro[] heap;
    int maxElementos;
    int m;

    Heap(){
        this.heap = new Registro[1000];
        this.maxElementos = 1000;
        m = 0;
    }

    Registro max(){
        return new Registro(0);
    }

    Registro extractMax(){
        return new Registro(0);
    }

    boolean insert(){
        return false;
    }

    void Print(){

    }


}
