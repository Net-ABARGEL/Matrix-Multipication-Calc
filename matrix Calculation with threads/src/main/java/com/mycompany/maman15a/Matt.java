/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maman15a;

import java.util.Random;

/**
 *
 * @author abargel_ido
 */
public class Matt extends Thread{
    public int indexes[][]; //our Mat
    private int n;  //column
    private int p;  //rows
    private int counteri;   //counter
    private int counterj;   //counter

    public int getN() {
        return n;
    }

    public int getP() {
        return p;
    }
    
    public void setIndexes(int[][] indexes) {
        this.indexes = indexes;
    }

    public int[][] getIndexes() {
        return indexes;
    }
    
    public Matt(int n, int p)   //builder
    {
        this.n=n;
        this.p=p;
        counteri = 0;
        counterj=0;
        indexes = new int[n][p];
        
        Random rnd = new Random();  //add random values to the mat
        for (int i=0;i<n;i++)
            for (int j =0;j<p;j++)
                indexes[i][j] = rnd.nextInt(10);
    }
    
    //synchronized function that will print the multiply matt values in order
    public synchronized void printValue(int i, int j,int sum,Matt t)
    {
        while (counteri !=i  || counterj!=j )   //not the correcrt thread
        {   try{
                wait(); //put in waiting list
            }
            catch(InterruptedException e)
            {
                System.out.println("Interrupted hile waiting");
            }
        }
                System.out.print(" "+sum + "["+i+" "+j+"]");    //print the value and indexes

        if (j==t.p-1)   //end of row
        {
            counteri++; //increas the column
            counterj=0;
            System.out.println();   // new line
        }
        else {counterj++;}

        notifyAll();    //notify all waiting list to the next process
    }
    
    public void multMat(int i, int j,Matt t)    //function that doing Mat multiply
    {
        int sum=0;
        
        for (int o = 0; o <this.p;o++)  //multiply the vectors of both matts
            sum+= this.indexes[i][o]*t.indexes[o][j];
       printValue(i,j,sum,t);// go to print values
       
    }
    
    
}
