/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.puntoventa;

import javax.swing.table.DefaultTableModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author castr
 */
public class ControllerPVTest {
    
    public ControllerPVTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }


    /**
     * Test of agregarProducto method, of class ControllerPV.
     */
    @Test
    public void testAgregarProducto() {
        System.out.println("agregarProducto");
        ModelProduct p = new ModelProduct(" ",1,10); 
        DefaultTableModel modelo = new DefaultTableModel();
        ControllerPV instance = new ControllerPV();
        String expResult = "El nombre es obligatorio";
        String result = instance.agregarProducto(p, modelo);
        assertEquals(expResult, result);
    }
    
     /*@Test
    public void testAgregarProducto_precioAlfanumerico() {
        System.out.println("agregarProducto");
        ModelProduct p = new ModelProduct("Manzana verde","botella de agua",10); 
        DefaultTableModel modelo = new DefaultTableModel();
        ControllerPV instance = new ControllerPV();
        String expResult = "Precio inválido";
        String result = instance.agregarProducto(p, modelo);
        assertEquals(expResult, result);
    }*/
    
}
