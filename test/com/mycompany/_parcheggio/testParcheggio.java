/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._parcheggio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Mattia
 */
public class testParcheggio {
    
    public parcheggio p;
    public autoParcheggiata auto;
    
    public testParcheggio() {
    }
    
     @Before
    public void inizializzazione()
    {
       p=new parcheggio();
       auto=new autoParcheggiata();
        auto.setNomeCliente("Mario");
        auto.setCognomeCliente("Rossi");
        auto.setTarga("AA111AA");
        auto.setDataEOraIngresso("2010-01-01|01-01-01");
        auto.setDataEOraUscita("2010-01-01|02-01-01");
    }
    
   /**
     * Test of getAuto method, of class parcheggio.
     */
    @Test
    public void testGetAuto() throws Exception {
        System.out.println("getAuto");
        int automobile = 0;
        autoParcheggiata expResult = auto;
        p.setAuto(auto);
        autoParcheggiata result = p.getAuto(automobile);
        assertEquals(expResult, result);
    }

    /**
     * Test of setAuto method, of class parcheggio.
     */
    @Test
    public void testSetAuto() throws Exception {
        System.out.println("setAuto");
        autoParcheggiata automobile = auto;
        p.setAuto(automobile);
    }

    /**
     * Test of eliminaAuto method, of class parcheggio.
     */
    @Test
    public void testEliminaAuto() throws Exception {
        System.out.println("eliminaAuto");
        int automobile = 0;
        p.setAuto(auto);
        p.eliminaAuto(automobile);
    }

    /**
     * Test of elencoAutoOrdinateTarghe method, of class parcheggio.
     */
    @Test
    public void testElencoAutoOrdinateTargheConAutoCompatibile() throws Exception {
        System.out.println("elencoAutoOrdinateTarghe");
        String dataInserita = "2010-01-01|01-01-01";
        p.setAuto(auto);
        String expResult = "AutoParcheggiata [\n" +
"Targa=AA111AA\n" +
"nomeCliente=Mario\n" +
"cognomeCliente=Rossi\n" +
"DataEOraIngresso=2010-01-01|01-01-01\n" +
"dataEOraUscita=2010-01-01|02-01-01\n" +
"]\n" +
"\n" +
"" ;
        String result = p.elencoAutoOrdinateTarghe(dataInserita);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testElencoAutoOrdinateTargheSenzaAutoCompatibile() throws Exception {
        System.out.println("elencoAutoOrdinateTarghe");
        String dataInserita = "2010-10-01|01-01-02";
        p.setAuto(auto);
        String expResult = "Non ci sono auto nel parcheggio con questa data" ;
        String result = p.elencoAutoOrdinateTarghe(dataInserita);
        assertEquals(expResult, result);
    }
}
