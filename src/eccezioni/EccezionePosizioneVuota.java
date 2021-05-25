/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eccezioni;

/**
 *
 * @author Mattia
 */
public class EccezionePosizioneVuota extends Exception
{
    private int auto;
    private int posizione;
    
    public EccezionePosizioneVuota(int auto, int posizione)
    {
        this.auto=auto;
        this.posizione=posizione;
    }

    public int getAuto() {
        return auto;
    }

    public int getPosizione() {
        return posizione;
    }
    
    public String toString()
    {
        String s="";
        s+="La auto : "+getAuto()+" posizione: "+getPosizione()+" è vuota.";
        return s;
    }
    
}
