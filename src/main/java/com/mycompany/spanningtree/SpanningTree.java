package com.mycompany.spanningtree;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class SpanningTree {
        
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("How do you want to input?(text/file): ");
        if(scanner.nextLine().equals("text"))
        {
            Input.InputFromConsole();
        }
        else
        {
            try
            {
                Input.InputFromFile();               
            }
            catch(FileNotFoundException e)
            {
                System.out.println(e.getMessage());
                System.out.println("Do you want to input from console?(y/n)");
                if(scanner.nextLine().equals("y"))
                {
                    Input.InputFromConsole();
                }
            }
            finally{
                scanner.close();
            }
        }
    }
}
