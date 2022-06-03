package com.mycompany.spanningtree;

import java.util.*;

public class Sorting implements Comparator<Connections> { 
    public int compare(Connections weight1,Connections weight2){
        return weight1.getWeight() - weight2.getWeight();
    }  
}
