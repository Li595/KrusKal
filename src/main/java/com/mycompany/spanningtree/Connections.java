package com.mycompany.spanningtree;

public class Connections implements Comparable<Connections> {
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
    
    public int compareTo(Connections compareConnection){
        int compareWeight = ((Connections) compareConnection).getWeight();
        if (this.weight == compareWeight){
            return this.weight;
        }else{
        return this.weight - compareWeight;
        }
    }
    
    void displayInfo(){
        System.out.printf("Points: %c, %c Weight: %d\n", startPoint, endPoint, weight);
    }    
}
