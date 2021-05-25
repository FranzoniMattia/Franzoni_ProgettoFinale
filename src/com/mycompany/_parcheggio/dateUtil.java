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
public class dateUtil {
    
   /**
	 * Metodo per verificare che la stringa inserita abbia un formato corretto e conforme con il formato 
	 * (yyyy-mm-dd)
	 * @param text	Stringa da controllare 
	 * @return	Ritorna true se è una stringa con il formato corretto ,false altrimenti
	 */
	public static boolean isValidDate(String text) {
		if(text.length()!=10)
		{
			return false;
		}
		for(int i=0;i<4;i++)
		{
			if(!(Character.isDigit(text.charAt(i))))
			{
				return false;
			}
		}
		if(text.charAt(4)!='-')
		{
			return false;
		}
		for(int i=5;i<7;i++)
		{
			if(!(Character.isDigit(text.charAt(i))))
			{
				return false;
			}
		}
		if(text.charAt(7)!='-')
		{
			return false;
		}
		for(int i=8;i<10;i++)
		{
			if(!(Character.isDigit(text.charAt(i))))
			{
				return false;
			}
		}
		
		return true;
	}
    
	/**
	 * Metodo per verificare che la stringa inserita abbia un formato corretto e conforme con il formato 
	 * (yyyy-mm-dd|hh-mm-ss)
	 * @param text	Stringa da controllare 
	 * @return	Ritorna true se è una stringa con il formato corretto ,false altrimenti
	 */
    public static boolean isValidDateAndTime(String text) {
		if(text.length()!=19)
		{
			return false;
		}
		for(int i=0;i<4;i++)
		{
			if(!(Character.isDigit(text.charAt(i))))
			{
				return false;
			}
		}
		if(text.charAt(4)!='-')
		{
			return false;
		}
		for(int i=5;i<7;i++)
		{
			if(!(Character.isDigit(text.charAt(i))))
			{
				return false;
			}
		}
		if(text.charAt(7)!='-')
		{
			return false;
		}
		for(int i=8;i<10;i++)
		{
			if(!(Character.isDigit(text.charAt(i))))
			{
				return false;
			}
		}
		if(text.charAt(10)!='|')
		{
			return false;
		}
		for(int i=11;i<13;i++)
		{
			if(!(Character.isDigit(text.charAt(i))))
			{
				return false;
			}
		}
		if(text.charAt(13)!='-')
		{
			return false;
		}
		for(int i=14;i<16;i++)
		{
			if(!(Character.isDigit(text.charAt(i))))
			{
				return false;
			}
		}
		if(text.charAt(16)!='-')
		{
			return false;
		}
		for(int i=17;i<19;i++)
		{
			if(!(Character.isDigit(text.charAt(i))))
			{
				return false;
			}
		}
		return true;
	}

	public static boolean isValidTarga(String insert) {
		if(insert.length()!=7)
		{
			return false;
		}
		for(int i=0;i<2;i++)
		{
			if(insert.toLowerCase().charAt(i)<97||insert.toLowerCase().charAt(i)>122)
			{
				return false;
			}
		}
		for(int i=2;i<5;i++)
		{
			if(!(Character.isDigit(insert.charAt(i))))
			{
				return false;
			}
		}
		for(int i=5;i<7;i++)
		{
			if(insert.toLowerCase().charAt(i)<97||insert.toLowerCase().charAt(i)>122)
			{
				return false;
			}
		}
		return true;
	}

   /**
	 * Metodo per determinare che la parte data di un Date sia identica a quella di un altro Date
	 * @param dataEOraPrenotazione	Primo oggetto date
	 * @param dataEOraPrenotazione2	Secondo oggetto Date
	 * @return	ritorna true se sono uguali , false altrimenti
	 */
	public static boolean stesseDate(String dataEOraPrenotazione, String dataEOraPrenotazione2) {
		//di entrambe le date trasformate in stringhe prendiamo i primi 10 caratteri che identificano la data , senza orario quindi
		//semplicemente poi verichiamo se sono uguali o meno
		String primaData=dataEOraPrenotazione.substring(0, 10);
		String secondaData=dataEOraPrenotazione2.substring(0, 10);
		
		return primaData.equals(secondaData);
	}
}
