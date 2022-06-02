package com.mycompany.spanningtree;

public class Connections implements Addable{
    private char startPoint;
    private char endPoint;
    private int weight;
    
    Connections(char startPoint, char endPoint, int weight){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.weight = weight;
    }
    
    public Character getStartPoint(){
        return startPoint;
    }
    
    public Character getEndPoint(){
        return endPoint;
    }
    
    public int getWeight(){
        return weight;
    }
    
    public void add(){
    }
}

interface Addable{
    void add();       
    }
