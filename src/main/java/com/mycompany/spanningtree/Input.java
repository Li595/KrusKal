package com.mycompany.spanningtree;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {
          
    
    public static void InputFromConsole () 
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList<String>> input = new ArrayList<ArrayList<String>>();
        boolean inputEnd = false;
        boolean deleteCheck = false;
        while (deleteCheck == false)
        {     
            while (inputEnd == false)
            {
                for (int i=0;i<i+1;i++)
                {
                    System.out.println("Input connection first, then weight: ");
                    input.add(new ArrayList<String>());
                    input.get(i).add(scanner.nextLine());
                    input.get(i).add(scanner.nextLine());                     
                    System.out.println("Continue to input?(y/n): ");
                    if (scanner.nextLine().equals("n"))
                    {
                        inputEnd=true;
                        break;
                    }
                }
            }
        
            System.out.println("Do you want to delete connections?(y/n): ");
            if(scanner.nextLine().equals("y"))
            {
                input.clear();
                inputEnd = false;
            }
            else
            {
            deleteCheck = true;
            }
        }
        Sorting.NumSorting(input);   
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
        ArrayList<ArrayList<String>> input = new ArrayList<ArrayList<String>>();
        Scanner sc = new Scanner(choseTextFile());
        int i = 0;
                   
        while (sc.hasNextLine()) 
        {
            String[] line = sc.nextLine().trim().split(" ");
            input.add(new ArrayList<String>());
            input.get(i).add(line[0]);
            input.get(i).add(line[1]); 
            i++;
            if (sc.hasNext() == false){               
                sc.close();
                break;
            }
        }
        sc.close();
        Sorting.NumSorting(input);      
    }   
}
