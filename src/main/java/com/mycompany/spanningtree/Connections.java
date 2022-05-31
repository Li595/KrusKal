
package com.mycompany.spanningtree;


public class Connections {
    String connection;
    char startPoint;
    char endPoint;
    int weight;
    
    Connections(String c, char s, char e, int w){
        this.connection = c;
        this.startPoint = s;
        this.endPoint = e;
        this.weight = w;
    }
    
    void displayInfo(){
        System.out.printf("Connection: %s Points: %c, %c Weight: %d\n", connection, startPoint, endPoint, weight);
    }    
}
