package com.mycompany.spanningtree;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class SpanningTree {
    ArrayList<ArrayList<String>> array_list;
    
    public static char getCharFromString(String str, int index)
    {
        return str.charAt(index);
    }
    
    private static File choseTextFile() {
        FileDialog dialog = new FileDialog((Frame) null, "Select File To Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        File[] file = dialog.getFiles();
        return file[0];
    }
    
    public static void main(String args[]) throws FileNotFoundException
    {
    ArrayList<ArrayList<String>> array_list = new ArrayList<ArrayList<String>>();
    Scanner scanner = new Scanner(System.in);
    System.out.println("How do you want to input?(text/file): ");
    if (scanner.nextLine().equals("text"))
    {
        int chk = 0;
        int chk3 =0;
        int chk5 = 0;
        while (chk5 < 2)
        {
            if (chk5 < 2 & chk5 > 0)
            {
                chk = 0;
                chk3 = 0;
            }            
            while (chk < 1)
            {
                int b = 0;
                System.out.println("Input connection and weight: ");
                while (b < 1)
                {
                    b ++ ;
                    array_list.add(new ArrayList<String>());
                    array_list.get(chk3).add(scanner.nextLine());
                    array_list.get(chk3).add(scanner.nextLine());                     
                }
                chk3 ++;
                System.out.println("Continue to input?(y/n): ");
                String chk2 = scanner.nextLine();
                if (chk2.equals("n"))
                    chk = 1;
            }
            System.out.println("Do you want to delete connections?(y/n): ");
            String chk4 = scanner.nextLine();
            if(chk4.equals("y"))
            {
                array_list.clear();
                chk5 = 1;
            }
            else
            {
            chk5 = 2;
            }
        }
    }
    else
    {  
        Scanner sc = new Scanner(choseTextFile());
        int ck = 0;
        while (sc.hasNextLine()) 
        {
            String[] line = sc.nextLine().trim().split(" ");
            array_list.add(new ArrayList<String>());
            array_list.get(ck).add(line[0]);
            array_list.get(ck).add(line[1]); 
            ck++;
        }   
    }
    int lenght = array_list.size();
    
    ArrayList<Integer> list_num = new ArrayList<Integer>();
    String bigstr = "";
    for (int i=0;i<array_list.size();i++)
    {
        for (int j=1;j<array_list.get(i).size();j++)
        {
           bigstr = array_list.get(i).get(j);
           int number = Integer.parseInt(bigstr);
           list_num.add(number);
        }
    }
    Collections.sort(list_num); 

    ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
    ArrayList<ArrayList<String>> connections = new ArrayList<ArrayList<String>>();
    ArrayList<ArrayList<String>> array_list3 = new ArrayList<ArrayList<String>>();
    ArrayList<String> min_con_temp = new ArrayList<String>();
    ArrayList<Integer> list_num1 = (ArrayList<Integer>) list_num.stream().distinct().collect(Collectors.toList());
    
    for (int i = 0; i < lenght; i++)
        {
            array_list3.add(array_list.get(i));
        }
    
    int x = 0;
    int num_1 = 0;
    int num_temp = 0;   
    
    while (x<list_num1.size())
    {
        num_1 = list_num1.get(num_temp);
        num_temp++;
        
        for(int j=0;j<array_list3.size();j++)
        {
            if (Integer.toString(num_1).equals(array_list3.get(j).get(1)))
            {
                min_con_temp.add(array_list3.get(j).get(0));
            }
        }
        
        x++;       
    }
    connections.add(new ArrayList<String>());
    connections.get(0).add(Character.toString(getCharFromString(min_con_temp.get(0),0)));
    connections.get(0).add(Character.toString(getCharFromString(min_con_temp.get(0),1)));
    for(int i=0;i<array_list3.size();i++)
    {
        if (array_list3.get(i).get(0).equals(min_con_temp.get(0)))
            output.add(array_list3.get(i));
    }
    
    int big2=min_con_temp.size();
    int big=1;
    while(big<big2)
    {
        int k =0;
        min_con_temp.remove(0);
        char ch1 = getCharFromString(min_con_temp.get(0), 0);
        char ch2 = getCharFromString(min_con_temp.get(0), 1);
        
        for(int i=0;i<connections.size();i++)
        {
            if(connections.size()>1)
                if(i+1<connections.size())
                {
                    for(int j=0;j<connections.get(i).size();j++)
                    {   
                        if(connections.get(i+1).contains(connections.get(i).get(j)))
                        {
                            connections.get(i).addAll(connections.get(i+1));
                            connections.remove(i+1);
                            j = connections.get(i).size();
                        }
                    }
                }
            
            if (connections.get(k).contains(Character.toString(ch1)) & connections.get(k).contains(Character.toString(ch2)))
            {
                
            }
            else
            {
                for(int j=0;j<array_list3.size();j++)
                {
                    if (array_list3.get(j).get(0).equals(min_con_temp.get(0)))
                    {
                    output.add(array_list3.get(j));
                    }
                }  
            }
            
            int lenght_f = connections.size();
            int lenght_s = 0;
            
            for(int j=0;j<connections.size();j++)
            {
                if (connections.get(j).contains(Character.toString(ch1)) | connections.get(j).contains(Character.toString(ch2)))
                {
                    connections.get(j).add(Character.toString(ch1));
                    connections.get(j).add(Character.toString(ch2));
                    i=connections.size();
                    j=connections.size();
                }
                else
                {                      
                    lenght_s++;
                }
            }
            
            if(lenght_f == lenght_s)
            {
                connections.add(new ArrayList<String>());
                connections.get(lenght_f).add(Character.toString(ch1));
                connections.get(lenght_f).add(Character.toString(ch2));                
                i=connections.size();
            }

            k++;
            big++;

        }        
    }
    
    System.out.println("Output: ");
    for (int i=0;i<output.size();i++)
        System.out.println(output.get(i));
    
    }
}
