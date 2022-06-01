
package com.mycompany.spanningtree;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileInput {
    
    public static char getCharFromString(String str, int index)
    {
        return str.charAt(index);
    }
    
    private static File choseTextFile() 
    {
        FileDialog dialog = new FileDialog((Frame) null, "Select File To Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        File[] file = dialog.getFiles();
        return file[0];
    }
    
    public List InputFromFile() throws FileNotFoundException
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
            Connections connection = new Connections(ch1, ch2, wg);
            connections.add(connection);                    
            if (sc.hasNext() == false){               
                sc.close();
                break;
            }
        }
        sc.close();
        TreeSet<Connections> ascendedConnections = new TreeSet<Connections>();
        ascendedConnections.addAll(connections);
        return connections;
    }
    
}