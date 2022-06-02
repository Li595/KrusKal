package com.mycompany.spanningtree;

import java.util.*;

public class ConsoleInput extends Input { 
        
    public List inputFromConsole () 
    {
        List<Addable> connections = new ArrayList<Addable>();
        Scanner scanner = new Scanner(System.in);
        boolean inputEnd = false;
        boolean deleteCheck = false;
        while (!deleteCheck)
        {     
            while (!inputEnd)
            {
                System.out.println("Input connection first, then weight: ");
                String cn = scanner.nextLine();
                int wg = Integer.parseInt(scanner.nextLine());
                char ch1 = getCharFromString(cn, 0);
                char ch2 = getCharFromString(cn, 1);
                Addable connection = new Connections(ch1, ch2, wg);
                connections.add(connection);                    
                System.out.println("Continue to input?(y/n): ");
                if (scanner.nextLine().equals("n"))
                {
                    inputEnd=true;
                    break;
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
