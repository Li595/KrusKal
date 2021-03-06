package com.mycompany.spanningtree;

import java.util.*;

public class Kruskal {
    List<ArrayList<String>> points = new ArrayList<ArrayList<String>>();
    
    public boolean pointsArrayCheck(Connections connection){
        for(int i=0;i<points.size();i++){
            return points.get(i).contains(Character.toString(connection.getStartPoint())) && points.get(i).contains(Character.toString(connection.getEndPoint()));
        }
        return false;
    }
    
    public void existingArrayCheck(List<ArrayList<String>> points){
        for(int i=0;i<points.size();i++){
            //Проверка на существование более, чем одного множества
            //И отсечение множества если оно крайнее
            if(points.size()>1 && i!=points.size()-1){
                //Дополнительный цикл для сравнение элементов не только в следующем множестве, но и во всех остальных
                for (int k=i+1;k<points.size();k++) {
                    for (int j = 0; j < points.get(i).size(); j++) {
                        //Проверка на содержание в множестве элементов текущего
                        //Запись значений и удаление множества
                        if (points.get(k).contains(points.get(i).get(j))) {
                            points.get(i).addAll(points.get(k));
                            points.remove(k);
                        }
                        //Если при удалении множества оно является последним, то цикл прекращается
                        if (k==points.size())
                            break;
                    }
                }
            } 
        }
    }
      
    public List<Connections> algorithm(List<Connections> connectionsList){
        List<Connections> minimalSpanningTree = new ArrayList<Connections>();
        
        connectionsList.sort(new Sorting());
        
        points.add(new ArrayList<String>());
        points.get(0).add(Character.toString(connectionsList.get(0).getStartPoint()));
        points.get(0).add(Character.toString(connectionsList.get(0).getEndPoint()));
        
        minimalSpanningTree.add(connectionsList.get(0));
        
        for (int i=1;i<connectionsList.size();i++){
            if(!pointsArrayCheck(connectionsList.get(i))){
                minimalSpanningTree.add(connectionsList.get(i));
                for(int j=0;j<points.size();j++){
                    if (points.get(j).contains(Character.toString(connectionsList.get(i).getStartPoint())) || points.get(j).contains(Character.toString(connectionsList.get(i).getEndPoint()))){
                        points.get(j).add(Character.toString(connectionsList.get(i).getStartPoint()));
                        points.get(j).add(Character.toString(connectionsList.get(i).getEndPoint()));
                    }else{
                        List<String> listTemp = new ArrayList<>();
                        listTemp.add(Character.toString(connectionsList.get(i).getStartPoint()));
                        listTemp.add(Character.toString(connectionsList.get(i).getEndPoint()));
                        points.add((ArrayList<String>) listTemp);
                    }
                }
                existingArrayCheck(points);
            }
        }  
        return minimalSpanningTree;
    }
}
