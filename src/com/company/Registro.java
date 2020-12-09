package com.company;

import java.util.Random;

public class Registro {
    public int id;
    public double priority;
    private Random random = new Random();

    Registro(int id, double priority) throws Exception {
        if(priority < 0 || priority>900000){
            String error = String.format("Error: Prioridade do objeto (%.1f) deve estar no intervalo [0,900000]",priority);
            throw new Exception(error);
        }
        this.id = id;
        this.priority = priority;
    }

    Registro(int priority) throws Exception {
        if(priority < 0 || priority>900000){
            String error = String.format("Error: Prioridade do objeto (%d) deve estar no intervalo [0,900000]",priority);
            throw new Exception(error);
        }
        this.priority = priority;
        this.id = random.nextInt(900000);
    }

}
