package com.mycompany.spanningtree;

import java.util.*;

public class Kruskal {
    ArrayList<ArrayList<String>> points = new ArrayList<ArrayList<String>>();
    
    public boolean pointsArrayCheck(Connections connection){
        for(int i=0;i<points.size();i++){
            return points.get(i).contains(Character.toString(connection.getStartPoint())) && points.get(i).contains(Character.toString(connection.getEndPoint()));
        }
        return false;
    }
      
    public void algorithm(List<Connections> connectionsList){
        ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
        points.add(new ArrayList<String>());
        points.get(0).add(Character.toString(connectionsList.get(0).getStartPoint()));
        points.get(0).add(Character.toString(connectionsList.get(0).getEndPoint()));
        output.add(new ArrayList<String>());
        output.get(0).add(Character.toString(connectionsList.get(0).getStartPoint())+Character.toString(connectionsList.get(0).getEndPoint()));
        output.get(0).add(Integer.toString(connectionsList.get(0).getWeight()));
        for (int i=1;i<connectionsList.size();i++){
            if(!pointsArrayCheck(connectionsList.get(i))){
                for(int j=0;j<points.size();j++){
                    if (points.get(j).contains(Character.toString(connectionsList.get(i).getStartPoint())) || points.get(j).contains(Character.toString(connectionsList.get(i).getEndPoint()))){
                        points.get(j).add(Character.toString(connectionsList.get(i).getStartPoint()));
                        points.get(j).add(Character.toString(connectionsList.get(i).getEndPoint()));
                        break;
                    }else{
                        points.add(new ArrayList<String>());
                        points.get(points.size()-1).add(Character.toString(connectionsList.get(i).getStartPoint()));
                        points.get(points.size()-1).add(Character.toString(connectionsList.get(i).getEndPoint()));
                        break;
                    }
                }              
            }
        }
        System.out.println(points);
        System.out.println(output);
    }
}
