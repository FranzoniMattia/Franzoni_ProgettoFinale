/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._parcheggio;

import eccezioni.EccezionePosizioneNonValida;
import eccezioni.FileException;
import file.TextFile;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Mattia
 */
public class parcheggio implements Serializable{
    private autoParcheggiata[] auto;
    private static final int NUM_AUTO_MAX=100;
    private static int AUTO;
    
     public parcheggio()
   {
       auto=new autoParcheggiata[NUM_AUTO_MAX];
       
       for (int i=0;i<NUM_AUTO_MAX;i++)
       {
           auto[i]=new autoParcheggiata();
       }
       
       AUTO=0;
   }
     
    /**
    * Restituisce un auto del parcheggio
    * @param auto Il numero che identifica l'auto nel parcheggio
    * @return l'auto
    */
   public autoParcheggiata getAuto(int automobile) throws EccezionePosizioneNonValida
   {
       autoParcheggiata a;
       try
       {
            a=auto[automobile];
            return a;
       }
       catch(ArrayIndexOutOfBoundsException e1)
       {
           throw new EccezionePosizioneNonValida(automobile,0);
       }
  
   }
   
   /**
    * Inserisce un auto nel parcheggio
    * @param automobile Il numero che identifica l'auto nel parcheggio
    */
   public void setAuto(autoParcheggiata automobile) throws EccezionePosizioneNonValida
   {
       try
       {
            auto[AUTO]=automobile;
            AUTO++;
            System.out.println(AUTO);
       }
       catch(ArrayIndexOutOfBoundsException e1)
       {
           throw new EccezionePosizioneNonValida(AUTO,0);
       }
  
   }
   
   
   
   
   
   
    /**
    * Elimina un auto nel parcheggio
    * @param automobile Il numero che identifica l'auto nel parcheggio
    */
   public void eliminaAuto(int automobile) throws EccezionePosizioneNonValida
   {
       try
       {
            for(int i=automobile;i<NUM_AUTO_MAX;i++)
            {
                if(i==NUM_AUTO_MAX-1)
                {
                    auto[i]=new autoParcheggiata();
                }
                else
                    auto[i]=auto[i+1];
            }
            AUTO--;
       }
       catch(ArrayIndexOutOfBoundsException e1)
       {
           throw new EccezionePosizioneNonValida(AUTO,0);
       }
  
   }
   
   
   
   
   
   	 /**
        * Restituisce una stringa che rappresenta l elenco delle auto ordinate per targa
        * @return stringa con elenco delle auto parcheggiate per targa
        */
  public String elencoAutoOrdinateTarghe(String dataInserita) throws EccezionePosizioneNonValida
  {
      autoParcheggiata[] elencoAuto=new autoParcheggiata[AUTO];
      autoParcheggiata auto;
      int c=0;
      
      for(int i=0;i<AUTO;i++)
      {
              auto=getAuto(i);
              if (auto!=null&&dateUtil.stesseDate(dataInserita, auto.getDataEOraIngresso()))
              {
                  elencoAuto[c]=auto;
                  c++;
              }
      }
      
      int numAuto=0;
      for(int i=0;i<elencoAuto.length;i++)
          if(elencoAuto[i]!=null)
              numAuto++;
      if(numAuto==0)
      {
          return "Non ci sono auto nel parcheggio con questa data";  
      }
      else
      {
          elencoAuto=Ordinatore.selectionSortAutoTarghe(elencoAuto);
      
          String dati="";
          for(int i=0;i<elencoAuto.length;i++)
            {
                dati=dati+elencoAuto[i].toString()+"\n";
            }
            return dati;  
      }
      
  }
   
  
  
  
  
  
  
      /**
    * Salva i parcheggi  su file CSV
    * @param filePathName Il numero che identifica l'auto nel parcheggio
    */
  public void esportaAutoCSV(String filePathName) throws IOException, EccezionePosizioneNonValida, FileException
  {
      autoParcheggiata auto;
      String stringaAuto;
      TextFile f1= new TextFile(filePathName, 'W');
      for (int i=0;i<NUM_AUTO_MAX;i++)
      {
              auto=getAuto(i);
              if (auto.getNomeCliente()!=null)
              {
                  stringaAuto=auto.toCSV();
                  f1.toFile(stringaAuto);
              }
          
      }
      f1.close(); 
  }
   
  
  
  
  
  
  
        /**
    * Salva i parcheggi
    * @param nomeFile 
    */
   public void salvaParcheggio(String nomeFile) throws IOException
  {   
      FileOutputStream f1=new FileOutputStream(nomeFile);
      ObjectOutputStream writer=new ObjectOutputStream(f1);
      writer.writeObject(this);
      writer.flush();
      writer.close();   
  }
  

   
   
   
   
   
           /**
    * Carica i parcheggi
    * @param nomeFile 
    */
  public parcheggio caricaParcheggio(String nomeFile) throws IOException, FileException
  {
      parcheggio s;
      FileInputStream f1=new FileInputStream(nomeFile);
      ObjectInputStream reader=new ObjectInputStream(f1);
      
       try 
       {
           s=(parcheggio)reader.readObject();
           numAutoPresentiTotalmente(s);
           reader.close();
           return s;
       } 
       catch (ClassNotFoundException ex) 
       {
           reader.close();
           throw new FileException("Errore di lettura");
       }   
  }
  
  
  
  
  
  
  
        /**
    * Determina il numero di auto totali presenti nel parcheggio
    * @param parcheggio s 
    */
    private int numAutoPresentiTotalmente(parcheggio s) 
    {
        try
        {
            for(int i=0;i<NUM_AUTO_MAX;i++)
            {
                if(s.getAuto(i).getNomeCliente()!=null)
                    AUTO++;
            } 
            
        }
        catch (EccezionePosizioneNonValida e1)
                        {
                            System.out.println(e1.toString());
                        }
        return AUTO;
    }
}
