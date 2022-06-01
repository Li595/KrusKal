package com.mycompany.spanningtree;

import java.util.*;

public class ConsoleInput {
    List<Connections> connections = new ArrayList<Connections>();
    
    public static char getCharFromString(String str, int index)
    {
        return str.charAt(index);
    }
    
    public List InputFromConsole () 
    {
        
        Scanner scanner = new Scanner(System.in);
        boolean inputEnd = false;
        boolean deleteCheck = false;
        while (!deleteCheck)
        {     
            while (!inputEnd)
            {
                for (int i=0;i<i+1;i++)
                {
                    System.out.println("Input connection first, then weight: ");
                    String cn = scanner.nextLine();
                    int wg = Integer.parseInt(scanner.nextLine());
                    char ch1 = getCharFromString(cn, 0);
                    char ch2 = getCharFromString(cn, 1);
                    Connections connection = new Connections(ch1, ch2, wg);
                    connections.add(connection);                    
                    System.out.println("Continue to input?(y/n): ");
                    if (scanner.nextLine().equals("n"))
                    {
                        inputEnd=true;
                        break;
                    }
                }
                for (int j=0;j<connections.size();j++){
                    connections.get(j).displayInfo();
                }
            }
                
            System.out.println("Do you want to delete connections?(y/n): ");
            if(scanner.nextLine().equals("y"))
            {
                connections.clear();
                inputEnd = false;
            }
            else
            {
            deleteCheck = true;
            }
        }
        return connections;
    }
}
