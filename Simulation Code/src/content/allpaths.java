/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package content;

/**
 *
 * @author shussain
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.InputStreamReader;
import java.util.HashMap;
 
class allpaths implements Runnable{
    static public int j=0;
 
 static int dim = 9, size = 0; // dim is number of nodes in graph
 // size had been used to keep record of index to remove node from Arraylist
    static boolean[] color = new boolean[dim + 1];      // to remember visit
    static int[][] graph = new int[10][10];
    static ArrayList<Integer> al = new ArrayList<Integer>();
    
 
    public static void main(String[] S) throws IOException {
        
       
       
         BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
         
          RE e=new RE();
        
         
        for (int I = 1; I <= dim; I++) {
            String[] s = br.readLine().split(" ");
            int len = s.length;
            for (int J = 1; J <= len; J++) {
                graph[I][J] = Integer.parseInt(s[J - 1]);
            }
        }
        Arrays.fill(color, false);      // initially all are unvisited
 
        int src = Integer.parseInt(br.readLine());      //Source node
        int dst = Integer.parseInt(br.readLine());      //Destination node
 
        //dfs(src, dst);  // backtracking
       dfs(src, dst);
    }
 
    static HashMap<Float,ArrayList> dfs(int src, int dst) {
         RE e=new RE();
          allpaths all=new allpaths();
         Thread t=new Thread(all);
        HashMap<Float,ArrayList>Pathh=new HashMap<>();
        al.add(src);
        size++;
        Packet p=new Packet();
      
        color[src] = true;
        if (src == dst) {     
            // tests for base condition to stop
           
                //     Prints the path
                //System.out.print(al+ "  ");
                Pathh.put(e.cost().get(j), al);
                System.out.println(Pathh+" "+" Delay= "+al.size()*(Math.round(p.Packetize().get(j))));
                j++;
            
           // System.out.println();
           
        }
        for (int I = 1; I <= dim; I++) {
            if (graph[src][I] == 1) {
                if (color[I] == false) {
                    dfs(I, dst);        // These lines do
                    color[I] = false;   // main job of backtracking
                    size--;
                    al.remove(size);
                }
            }
        }
     return Pathh;
    }

    @Override
    public void run() {
        System.out.println("delay");
    }
}