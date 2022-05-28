package com.mycompany.spanningtree;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class Sorting {
    
    public static void NumSorting (ArrayList<ArrayList<String>> input) {
        
        SortedSet<Integer> set = new TreeSet<>();
        ArrayList<Integer> list_num = new ArrayList<Integer>();
        String bigstr = "";
        for (int i=0;i<input.size();i++)
        {
            for (int j=1;j<input.get(i).size();j++)
            {
            bigstr = input.get(i).get(j);
            int number = Integer.parseInt(bigstr);
            set.add(number);
            }
        }
        list_num.addAll(set);
        MinConnectionList(input,list_num);
        
    }

    public static ArrayList<String> MinConnectionList(ArrayList<ArrayList<String>> input, ArrayList<Integer> list_num){
        ArrayList<String> min_con = new ArrayList<String>();
        for (int i=0; i<list_num.size();i++)
        {
            int num_1 = list_num.get(i);
        
            for(int j=0;j<input.size();j++)
            {
                if (Integer.toString(num_1).equals(input.get(j).get(1)))
                {
                min_con.add(input.get(j).get(0));
                }
            }
        }
        KrusKal.AddMinConnection(min_con,input);
        return min_con;
    }   
}
