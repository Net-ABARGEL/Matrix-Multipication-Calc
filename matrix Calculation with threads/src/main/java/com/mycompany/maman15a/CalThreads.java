/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maman15a;

/**
 *
 * @author abargel_ido
 * A Class that will create a thread to calculate mult vector
 */
public class CalThreads extends Thread{
    public int i;
    public int j;
    public Matt fMatt;
    public Matt lMatt;
    
    public CalThreads(int i,int j, Matt m, Matt t)  //builder
    {
        this.i=i;
        this.j=j;
        fMatt = m;
        lMatt = t;
    }

    //function of thread to calculate and print the multiply value
    public void run()
    {
        fMatt.multMat(i,j,lMatt);
    }
}
