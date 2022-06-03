package com.mycompany.spanningtree;

import java.io.FileNotFoundException;
import java.util.*;

public class SpanningTree {
     
    public static void main(String[] args){
        List<Connections> connectionsList = new ArrayList<Connections>();
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("How do you want to input?(text/file): ");
        if(scanner.nextLine().equals("text"))
        {
            ConsoleInput connections = new ConsoleInput();
            connectionsList = connections.inputFromConsole();
        }
        else
        {
            try
            {
                FileInput connections = new FileInput();
                connectionsList = connections.inputFromFile();
            }
            catch(FileNotFoundException e)
            {
                System.out.println(e.getMessage());
                System.out.println("Do you want to input from console?(y/n)");
                if(scanner.nextLine().equals("y"))
                {
                    ConsoleInput connections = new ConsoleInput();
                    connectionsList = connections.inputFromConsole();
                }
            }
            finally{
                scanner.close();
            }
        }
        List<Connections> minimalSpanningTree;
        Kruskal minimalSpanningTreeTemp = new Kruskal(); 
        minimalSpanningTree = minimalSpanningTreeTemp.algorithm(connectionsList);
        for(Connections temp: minimalSpanningTree){
            System.out.println(temp.getStartPoint()+""+temp.getEndPoint()+" "+temp.getWeight());
        }
    }
}
    
