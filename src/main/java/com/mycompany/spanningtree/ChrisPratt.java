package com.mycompany.kruskalalgorithm;

import java.util.ArrayList;

public class ChrisPratt {
    
    public static char getCharFromString(String str, int index)
    {
        return str.charAt(index);
    }
    
    public static ArrayList<ArrayList<String>> AddMinConnection(ArrayList<String> min_con, ArrayList<ArrayList<String>> input){
        //Добавление минимальной связи по умолчанию
        ArrayList<ArrayList<String>> connections = new ArrayList<ArrayList<String>>();
        connections.add(new ArrayList<String>());
        connections.get(0).add(Character.toString(getCharFromString(min_con.get(0),0)));
        connections.get(0).add(Character.toString(getCharFromString(min_con.get(0),1)));
        Algorithm(connections,min_con,input);
        return connections;
    }
    
    public static void ExistingArraysCheck(ArrayList<ArrayList<String>> connections){
        
        //Проверка на наличие одинаковых вершин в разных массивах и объединение массивов в случае наличия
        //Выполняется только в случае, если массивов больше, чем один
        for(int i=0;i<connections.size();i++)
        {
            if(connections.size()>1 & i+1<connections.size())
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
        }
    }
    
    public static void ConnectionsUpdate (ArrayList<ArrayList<String>> connections, ArrayList<String> min_con){
        int lenght_f = connections.size();
        int lenght_s = 0;
        char ch1 = getCharFromString(min_con.get(0), 0);
        char ch2 = getCharFromString(min_con.get(0), 1);    
        for(int j=0;j<connections.size();j++)
        {
            if (connections.get(j).contains(Character.toString(ch1)) | connections.get(j).contains(Character.toString(ch2)))
            {
                connections.get(j).add(Character.toString(ch1));
                connections.get(j).add(Character.toString(ch2));
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
            }
    }
        
    public static void Algorithm(ArrayList<ArrayList<String>> connections, ArrayList<String> min_con, ArrayList<ArrayList<String>> input){
        ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
        //Добавление первой связи в вывод по умолчанию
        for(int j=0;j<input.size();j++)
        {
            if (input.get(j).get(0).equals(min_con.get(0)))
            {
                output.add(input.get(j));
            }
        }
        
        
            
        while(min_con.size()>1){
            min_con.remove(0);
            char ch1 = getCharFromString(min_con.get(0), 0);
            char ch2 = getCharFromString(min_con.get(0), 1);
        
            ExistingArraysCheck(connections);
 
            for(int i=0;i<connections.size();i++){
                if (!(connections.get(i).contains(Character.toString(ch1)) & connections.get(i).contains(Character.toString(ch2))))
                    {
                        for(int j=0;j<input.size();j++)
                        {
                            if (input.get(j).get(0).equals(min_con.get(0)))
                            {
                            output.add(input.get(j));
                            input.remove(j);
                            }
                        }  
                    }
            }
            
            ConnectionsUpdate(connections, min_con);
            
        }
        System.out.println("Output: ");
            for (int i=0;i<output.size();i++)
                System.out.println(output.get(i));
        
        System.exit(0);
    }                      
}
