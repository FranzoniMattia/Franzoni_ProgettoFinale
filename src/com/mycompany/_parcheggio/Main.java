/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._parcheggio;

import eccezioni.*;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Mattia
 */
public class Main 
{
    
    public static void main(String[] args) 
    {
          
        Scanner tastiera=new Scanner(System.in);
        
        String[] vociMenu=new String[8];
        int sceltaUtente=-1;
        
      
        autoParcheggiata auto;
        
        String nomeFileTesto="parcheggi.txt";
        String nomeFileBinario="parcheggi.bin";
        
        parcheggio p=new parcheggio();
        
        vociMenu[0]="Esci";  
        vociMenu[1]="Aggiungi auto";
        vociMenu[2]="Registra uscita";
        vociMenu[3]="Elimina auto";
        vociMenu[4]="Vedi parcheggi auto(Per data)";
        vociMenu[5]="Vedi auto presenti";
        vociMenu[6]="Esporta in formato CSV";
        vociMenu[7]="Salva";          
        
        try 
        {
            p=p.caricaParcheggio(nomeFileBinario);
            System.out.println("Dati caricati correttamente");
        } 
        catch (IOException ex) 
        {
            System.out.println("Impossibile accedere al file in lettura. I dati non sono stati caricati");
        } 
        catch (FileException ex) 
        {
            System.out.println(ex.toString());
        }
        
        Menu menu= new Menu(vociMenu);
        
        do
        {
            try
            {
                sceltaUtente=menu.sceltaMenu();
                switch(sceltaUtente)
                {
                    case 0:
                    {
                        System.out.println("L'applicazione verrà terminata");
                        break;
                    }
                    case 1:
                    {
                        auto=new autoParcheggiata();
                        System.out.println("Targa-->");
                        auto.setTarga(tastiera.nextLine());
                        System.out.println("Nome-->");
                        auto.setNomeCliente(tastiera.nextLine());
                        System.out.println("Cognome-->");
                        auto.setCognomeCliente(tastiera.nextLine());
                        System.out.println("Data Ingresso in formato(yyyy-mm-dd|hh-mm-ss)-->");
                       
                        String data=tastiera.nextLine();
                        if(dateUtil.isValidDateAndTime(data))
                            auto.setDataEOraIngresso(nomeFileTesto);
                        else
                        {
                            System.out.println("Data non corretta");
                            break;
                        }
                        
                        auto.setDataEOraUscita(null);
                        try
                        {
                            p.setAuto(auto);
                            System.out.println("Ok inserimento eseguito correttamente, l'auto prende come codice ID: il numero del suo posto nel parcheggio");
                        }
                        catch(EccezionePosizioneNonValida e1)
                        {
                            System.out.println(e1.toString());
                        }
                        System.out.println("Premi un pulsante per continuare");
                        tastiera.nextLine();
                        break;
                    }
                    case 2:
                    {
                          try
                        {
                            for(int i=0;i<100;i++)
                            {
                                if(p.getAuto(i).getNomeCliente()!=null)
                                {
                                    auto=p.getAuto(i);
                                    if (auto.getDataEOraUscita()==null)
                                         System.out.println(i+")"+auto.toString());
                                }
                            }
                            System.out.println("Inserisci codice ID dell'auto che e' uscita(numero del posto auto nel parcheggio, partendo da 0)-->");
                            int codice =tastiera.nextInt();
                             tastiera.nextLine();
                            
                           System.out.println("Data uscita in formato(yyyy-mm-dd|hh-mm-ss)-->");
                            String data=tastiera.nextLine();
                            if(dateUtil.isValidDateAndTime(data))
                                p.getAuto(codice).setDataEOraUscita(nomeFileTesto);
                            else
                            {
                                System.out.println("Data non corretta");
                                break;
                            }
                        }
                        catch (EccezionePosizioneNonValida e1)
                        {
                            System.out.println(e1.toString());
                        }
                        
                         

                        System.out.println("Premi un pulsante per continuare");
                        tastiera.nextLine();
                        
                        break;
                    }
                    case 3:
                    {
                         try
                        {
                            for(int i=0;i<100;i++)
                            {
                                if(p.getAuto(i).getNomeCliente()!=null)
                                {
                                    auto=p.getAuto(i);
                                    System.out.println(i+")"+auto.toString());
                                }
                            }
                            System.out.println("Inserisci codice dell'auto da eliminare-->");
                            int codice =tastiera.nextInt();
                            p.eliminaAuto(codice);
                        }
                        catch (EccezionePosizioneNonValida e1)
                        {
                            System.out.println(e1.toString());
                        }
                        
                        tastiera.nextLine();
                        System.out.println("Premi un pulsante per continuare");
                        tastiera.nextLine();
                        
                        break;
                    }
                    case 4:
                    {
                        System.out.println("Data di ricerca in formato(yyyy-mm-dd|hh-mm-ss)-->");
                            String data=tastiera.nextLine();
                            if(!dateUtil.isValidDateAndTime(data))
                            {
                                System.out.println("Data non corretta");
                                break;
                            }
                              try {
                                  System.out.println(p.elencoAutoOrdinateTarghe(data));
                              } 
                              catch (EccezionePosizioneNonValida ex) 
                                {
                                System.out.println(ex.toString());
                                }
                        break;
                    }
                    case 5:
                    {
                         try
                        {
                            for(int i=0;i<100;i++)
                            {
                                if(p.getAuto(i).getNomeCliente()!=null)
                                {
                                    auto=p.getAuto(i);
                                    if (auto.getDataEOraUscita()==null)
                                         System.out.println(i+")"+auto.toString());
                                }
                            }
                           
                        }
                        catch (EccezionePosizioneNonValida e1)
                        {
                            System.out.println(e1.toString());
                        }

                        System.out.println("Premi un pulsante per continuare");
                        tastiera.nextLine();
                        break;
                    }
                   
                    case 6:
                    {
                        try
                        {
                            p.esportaAutoCSV(nomeFileTesto);
                            System.out.println("Auto esportate correttamente");
                        }
                        catch(IOException e1)
                        {
                            System.out.println("Impossibile accedere al file");
                        }
                        catch(FileException e2)
                        {
                            System.out.println(e2.toString());
                        }
                        catch(EccezionePosizioneNonValida e3)
                        {
                            System.out.println(e3.toString());
                        }
                        break;
                    }
                    case 7:
                    {
                        try 
                        {
                            p.salvaParcheggio(nomeFileBinario);
                            System.out.println("Dati salvati correttamente");
                        } catch (IOException ex) 
                        {
                            System.out.println("Impossibile accedere al file in scrittura");
                        }

                     }

                }
                
            }
            catch (InputMismatchException | NumberFormatException e1 )
            {
                tastiera.nextLine();
                System.out.println("Input non corretto");
            }
            
            
            
        }while (sceltaUtente!=0);
            

    }
    
    
    
}




