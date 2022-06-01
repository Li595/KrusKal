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
            //TODO соединить получаемый лист с консольным вводом
            ConsoleInput connections = new ConsoleInput();
            connections.InputFromConsole();
        }
        else
        {
            try
            {
                FileInput connections = new FileInput();
                connectionsList = connections.InputFromFile();
                //connections.InputFromFile();
            }
            catch(FileNotFoundException e)
            {
                System.out.println(e.getMessage());
                System.out.println("Do you want to input from console?(y/n)");
                if(scanner.nextLine().equals("y"))
                {
                    ConsoleInput connections = new ConsoleInput();
                    connections.InputFromConsole();
                }
            }
            finally{
                scanner.close();
            }
        }
        Sorting ascendedConnections = new Sorting();
        ascendedConnections.ascendingWeight(connectionsList);                         
    }
}
