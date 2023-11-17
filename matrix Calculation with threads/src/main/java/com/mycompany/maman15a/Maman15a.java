/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maman15a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author abargel_ido
 */
public class Maman15a {

    public static void main(String[] args) {
        
        int n,m,p;
        try{
         n = Integer.parseInt(args[0]);m = Integer.parseInt(args[1]);p =Integer.parseInt( args[2]);
        }
        catch(ArrayIndexOutOfBoundsException e){
             n=2;m=3;p=5;
        }
      
        Matt fMatt = new Matt(n,m);//create mat
        Matt lMatt = new Matt(m,p);// create mat
        
        startExecute(fMatt,lMatt);  // excecute process
        
        
    }
    
    public static void startExecute(Matt m, Matt t)
    {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i =0;i<m.getN();i++)// creating n*p threads
        {
            for (int j =0;j<t.getP();j++)
                executor.execute(new CalThreads(i,j,m,t));// create new thread
            
        }
        executor.shutdown();// shutdown the processes
    }
    
}
