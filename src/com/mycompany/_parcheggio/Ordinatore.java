/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._parcheggio;

/**
 *
 * @author Mattia
 */
public class Ordinatore 
{
    
    
    
    
    public static void  scambia(autoParcheggiata v[],int posizione1, int posizione2)
    {
        autoParcheggiata c;
        c=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=c;
    }
    
    
     
    public static void  scambia(String v[],int posizione1, int posizione2)
    {
        String c;
        c=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=c;
    }
    
    public static void  scambia(int v[],int posizione1, int posizione2)
    {
        int c;
        c=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=c;
    }
    
    //Ordina un array di Libri in ordine di prezzo
    public static autoParcheggiata[] selectionSortAutoTarghe(autoParcheggiata[] a)
    {
        autoParcheggiata[] ordinato=new autoParcheggiata[a.length];
        
        //Creo un vettore di copia
        //che sarà il vettore ordinato restituito
        for (int i=0;i<ordinato.length;i++)
            ordinato[i]=a[i];
        
        //Applico l'algoritmo 
        //selection sort al vettore di copia
        for (int i=0;i<ordinato.length-1;i++)
        {
            for (int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j].getTarga().compareToIgnoreCase(ordinato[i].getTarga())<0)
                    scambia(ordinato,i,j);
            }
        }
        
        autoParcheggiata[] ordinatoCorretto=new autoParcheggiata[a.length];
        for(int i=0;i<a.length;i++)
        {
            ordinatoCorretto[i]=ordinato[i];
        }
        return ordinatoCorretto;
    }
    
    
}
