/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.companyname.springapp.web.domain;


import com.companyname.springapp.domain.Product;
import org.junit.Before;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author daniela.fagundez
 */
public class ProductTests {
    
    private Product product;
    @Before
    public void setUp()throws Exception {
        product = new Product();
    } 
    
    @Test
    public void testSetAndGetDescription(){
        String testDescription = "aDescription";
        assertNull(product.getDescription());
        product.setDescription(testDescription);
        assertEquals(testDescription,product.getDescription());
    }
    @Test
    public void testSetPrecio(){
        double testPrecio = 100.00;
        assertNull(product.getPrice());
        product.setPrice(testPrecio);
        assertEquals(testPrecio,product.getPrice(), 0);
    }
  
    
    
   
  

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
