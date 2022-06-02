package com.mycompany.spanningtree;

import java.util.*;

public class Sorting implements Comparator<Connections> {
    
    public int compare(Connections weight1,Connections weight2){
        if (weight1.getWeight() == weight2.getWeight()){
            return 0;
        }
        if (weight1.getWeight() > weight2.getWeight()){
            return 1;
        }else{
            return -1;
        }     
    }  
}
