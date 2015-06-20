/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package content;

import java.util.ArrayList;

/**
 *
 * @author shussain
 */
public class Packet {
    public ArrayList<Float> Packetize()
    {
        int data=500;
        int size_of_packet=10;
        int no_of_packet=data/size_of_packet;
        RE a=new RE();
        //int packet_ratio;
       float total_cost=0;
        
        for (int i = 0; i <5; i++) {
         total_cost+= a.cost().get(i);
        }
        ArrayList<Float>packet_ratio=new ArrayList<Float>();
        for (int i = 0; i <5; i++) {
         packet_ratio.add((a.cost().get(i)/total_cost)*no_of_packet);
        }
        /*for (int i = 0; i <5; i++) {
            System.out.println(Math.round(packet_ratio.get(i)));
        }*/
        return packet_ratio;
        
    }
   /* public static void main(String []args)
    {
        Packet pac=new Packet();
        pac.Packetize();
    }*/
}

