/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._parcheggio;

import eccezioni.FileException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;


/**
 * La classe rappresenta un auto parcheggiata.
 * I suoi suoi attributi sono:<br>
 * targa <br>
 * nomeCliente <br>
 * cognomeCliente <br>
 * dataEOraIngresso <br>
 * dataEOraUscita <br>
 * @author Mattia
 * @version 1.0
 */



public class autoParcheggiata implements Serializable
{

        //attributi
	private String targa;
	private String nomeCliente;
	private String cognomeCliente;
	private String dataEOraIngresso;
	private String dataEOraUscita;

        
        
        /**
 * Costruttore della classe autoParcheggiata
 * @param targa targa dell auto
 * @param nomeCliente nome del cliente 
 * @param cognomeCliente cognome del cliente
 * @param dataEOraIngresso data ingresso nel parcheggio
 * @param dataEOraUscita data uscita dal parcheggio
 */
    public autoParcheggiata(String targa,String nomeCliente,String cognomeCliente,String dataEOraIngresso,String dataEOraUscita)
    {
        this.targa=targa;
        this.nomeCliente=nomeCliente;
        this.cognomeCliente=cognomeCliente;
        this.dataEOraIngresso=dataEOraIngresso;
        this.dataEOraUscita=dataEOraUscita;
    }
    
    
    
    
    
        /**
   * Costruttore di copia della classe autoParcheggiata. Consente di istanziare un nuovo parcheggio
   * @param l: parcheggio nel quale verrà istanziata la nuova auto parcheggiata. 
   * Il parcheggio istanziato sarà una copia del parcheggio l
   */
    public autoParcheggiata(autoParcheggiata l)
    {
        targa=l.getTarga();
        nomeCliente=l.getNomeCliente();
        cognomeCliente=l.getCognomeCliente();
        dataEOraIngresso=l.getDataEOraIngresso();
        dataEOraUscita=l.getDataEOraUscita();
    }
    
    
    
    
    
    
    
    /**
     * Costruttore di default della classe autoParcheggiata. 
     * Consente di istanziare un nuovo parcheggio con i seguenti 
     * valori di default per gli attributi<br>
     * targa: stringa vuota<br>
     * nomeCliente: stringa vuota<br>
     * cognomeCliente: stringa vuota<br>
     * dataEOraIngresso: stringa vuota<br>
     * dataEOraUscita: stringa vuota<br>
    */
    public autoParcheggiata()
    {
        targa="";
        nomeCliente="";
        cognomeCliente="";
        dataEOraIngresso="";
        dataEOraUscita="";
        
    }
        
        
    
    
    

         /**
         * Restituisce la targa associata alla macchina parcheggiata
         * @return targa
         */
	public String getTarga() {
		return targa;
	}

        
        
        
        
        
        /**
        * Assegna il la targa associata alla macchina parcheggiata
        * @param targa targa della macchina pargheggiata
        */
	public void setTarga(String targa) {
		this.targa = targa;
	}

        
        
        
        
        /**
         * Restituisce il nome del proprietario associato alla macchina parcheggiata
         * @return nomeCliente
         */
	public String getNomeCliente() {
		return nomeCliente;
	}

        
        
        
        
        /**
        * Assegna il nome del proprietario della macchina parcheggiata
        * @param nomeCliente nome del proprietario della  macchina parcheggiata
        */
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

        
        
        
        
         /**
         * Restituisce il cognome del proprietario associato alla macchina parcheggiata
         * @return cognomeCliente
         */
	public String getCognomeCliente() {
		return cognomeCliente;
	}

        
        
        
        
         /**
        * Assegna il cognome del proprietario della macchina parcheggiata
        * @param cognomeCliente cognome del proprietario della  macchina pargheggiata
        */
	public void setCognomeCliente(String cognomeCliente) {
		this.cognomeCliente = cognomeCliente;
	}

        
        
        
        
        /**
         * Restituisce la data in ingresso associata alla macchina parcheggiata
         * @return dataEOraIngresso
         */
	public String getDataEOraIngresso() {
		return dataEOraIngresso;
	}

        
        
        
         /**
        * Assegna la data e ora di ingresso della macchina parcheggiata
        * @param dataEOraIngresso dataEOraIngresso della macchina parcheggiata
        */
	public void setDataEOraIngresso(String dataEOraIngresso) {
		this.dataEOraIngresso = dataEOraIngresso;
	}

        
        
        
        
        /**
         * Restituisce la data in uscita associata alla macchina parcheggiata
         * @return dataEOraUscita
         */
	public String getDataEOraUscita() {
		return dataEOraUscita;
	}

        
        
        
        
           /**
        * Assegna la data e ora di uscita della macchina parcheggiata
        * @param dataEOraUscita dataEOraUscita ddella macchina parcheggiata
        */
	public void setDataEOraUscita(String dataEOraUscita) {
		this.dataEOraUscita = dataEOraUscita;
	}

        
        
        
        
	 /**
        * Restituisce una stringa che rappresenta la macchina parcheggiata
        * @return stringa con codiceNumerico, targa dell'auto, cognome del cliente, nome del cliente, data di ingresso e uscita del proprietario della macchina parcheggiata
        */
	public String toString() {
		return "AutoParcheggiata [\nTarga="  + targa + "\nnomeCliente=" + nomeCliente + "\ncognomeCliente="
				+ cognomeCliente + "\nDataEOraIngresso=" + dataEOraIngresso + "\ndataEOraUscita="
				+ dataEOraUscita +  "\n]\n";
	}

        
        
            /**
    * metodo per la rappresentazione dell'oggetto in formato CSV
    * @return stringa con targa, nomeCliente, cognomeCliente, dataEOraIngresso, dataEOraUscita
    * 
    */
	public String toCSV() 
	{
		return  targa + ",\"" + nomeCliente + "\",\"" +cognomeCliente + "\",\""  + dataEOraIngresso + "\"," + dataEOraUscita +  "\n";
	}

}
 