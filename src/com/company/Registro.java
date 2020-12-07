package com.company;

import java.util.Random;

public class Registro {
    public int id;
    public int priority;
    private Random random = new Random();

    Registro(int id, int priority){
        this.id = id;
        this.priority = priority;
    }

    Registro(int priority){
        this.priority = priority;
        this.id = random.nextInt(100);
    }

}
