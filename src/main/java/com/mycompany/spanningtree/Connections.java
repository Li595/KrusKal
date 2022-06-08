package com.mycompany.spanningtree;

public class Connections{
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
}
