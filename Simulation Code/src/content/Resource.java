/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package content;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author shussain
 */
public class Resource {
    
    public static void main(String[]args) throws FileNotFoundException, IOException{
            int [][]R={{60 ,40, 30, 20 ,70},
                      {400 ,350, 200, 450, 100},
                      {50, 40, 55, 70 ,60},
                      { 0, 3 ,2 ,1, 4},
                      { 4 ,3 ,1 ,2 ,5}};
            double [][] C=new double[5][5];
            int [][]RR=new int[5][5];
            float[]FC=new float[5];
           for (int i = 0; i < 5; i++) {
                for (int j = 0; j <5; j++) {
                    
                    RR[i][j]=R[i][j];
                }
               
               
            }
            
            for (int i = 0; i <5; i++) {
            Arrays.sort(R[i]);
        }
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j <5; j++) {
                    
                    if(i>1){
                  C[i][j]=1-(float)RR[i][j]/R[i][4];
                    }
                    else
                    {
                        C[i][j]=(float)RR[i][j]/R[i][4];
                    }
                }
                
        }
            
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j <5; j++) {
                    
                    FC[i]+=C[j][i];
                }
              
               
            }
            
                for (int i = 0; i <5; i++) {
                    System.out.println(FC[i]);
        }
        
            
            
            
           
            
    }
                   
            
    
}
