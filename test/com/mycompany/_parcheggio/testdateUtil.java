/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._parcheggio;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mattia
 */
public class testdateUtil {
    
    public testdateUtil() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testisValidDateTrue() throws Exception {
        System.out.println("isValidDate");
        String data="2020-01-01";
        boolean valido=dateUtil.isValidDate(data);
        boolean expected=true;
        assertEquals(expected, valido);
    }

    @Test
    public void testisValidDateFalse() throws Exception {
        System.out.println("isValidDate");
        String data="20-01-01";
        boolean valido=dateUtil.isValidDate(data);
        boolean expected=false;
        assertEquals(expected, valido);
    }
    
     @Test
    public void testisValidDateAndTimeTrue() throws Exception {
        System.out.println("isValidDateAndTime");
        String data="2020-01-01|01-01-01";
        boolean valido=dateUtil.isValidDateAndTime(data);
        boolean expected=true;
        assertEquals(expected, valido);
    }

    @Test
    public void testisValidDateAndTimeFalse() throws Exception {
        System.out.println("isValidDateAndTime");
        String data="20-01-01";
        boolean valido=dateUtil.isValidDateAndTime(data);
        boolean expected=false;
        assertEquals(expected, valido);
    }
    
        @Test
    public void testisValidTargaTrue() throws Exception {
        System.out.println("isValidTarga");
        String targa="aa333aa";
        boolean valido=dateUtil.isValidTarga(targa);
        boolean expected=true;
        assertEquals(expected, valido);
    }

    @Test
    public void testisValidTargaFalse() throws Exception {
        System.out.println("isValidTarga");
        String targa="adafadasda";
        boolean valido=dateUtil.isValidTarga(targa);
        boolean expected=false;
        assertEquals(expected, valido);
    }
    
     @Test
    public void teststesseDateTrue() throws Exception {
        System.out.println("isValidDate");
        String data="2020-01-01|01-01-01";
        String data1="2020-01-01|01-01-01";
        boolean valido=dateUtil.stesseDate(data,data1);
        boolean expected=true;
        assertEquals(expected, valido);
    }

    @Test
    public void teststesseDateFalse() throws Exception {
        System.out.println("isValidDate");
        String data="20-01-01|02-02-02";
        String data1="20-01-03|02-02-02";
        boolean valido=dateUtil.stesseDate(data,data1);
        boolean expected=false;
        assertEquals(expected, valido);
    }
}
