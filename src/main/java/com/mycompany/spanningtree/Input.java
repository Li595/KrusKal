package com.mycompany.spanningtree;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Input {  
    
    public static char getCharFromString(String str, int index)
    {
        return str.charAt(index);
    }
    
    public static void InputFromConsole () 
    {
        List<Connections> connections = new ArrayList<Connections>();
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
                    Connections connection = new Connections(cn, ch1, ch2, wg);
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
    }

    private static File choseTextFile() 
    {
        FileDialog dialog = new FileDialog((Frame) null, "Select File To Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        File[] file = dialog.getFiles();
        return file[0];
    }
    
    public static void InputFromFile() throws FileNotFoundException
    {
        List<Connections> connections = new ArrayList<Connections>();
        Scanner sc = new Scanner(choseTextFile());             
        while (sc.hasNextLine()) 
        {
            String[] line = sc.nextLine().trim().split(" ");
            String cn = line[0];
            int wg = Integer.parseInt(line[1]);
            char ch1 = getCharFromString(cn, 0);
            char ch2 = getCharFromString(cn, 1);
            Connections connection = new Connections(cn, ch1, ch2, wg);
            connections.add(connection);                    
            if (sc.hasNext() == false){               
                sc.close();
                break;
            }
        }
        sc.close();
        for (int j=0;j<connections.size();j++){
            connections.get(j).displayInfo();
        }
    }
}

