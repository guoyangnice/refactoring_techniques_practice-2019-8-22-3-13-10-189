package com.tws.refactoring.extract_method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OwingPrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void should_print_order_when_print_owing_given_name_and_price() {
    	//given
    	String name = "yang";
    	List<Order> orderList = new ArrayList<Order>();
    	orderList.add(new Order(60));
    	orderList.add(new Order(6));
    	OwingPrinter owingPrinter = new OwingPrinter();
    	//when
    	owingPrinter.printOwing(name,orderList);
    	//then
    	String resultString = 
    			"*****************************\r\n"+
    			"****** Customer totals ******\r\n"+
    			"*****************************\r\n"+
    			"name: yang\r\n"+
    			"amount: 66.0\r\n";
    	assertEquals(resultString, outContent.toString());
    }
    
}