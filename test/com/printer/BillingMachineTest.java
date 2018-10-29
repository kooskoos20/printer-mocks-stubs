package com.printer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;


public class BillingMachineTest {

    @Test
    public void shouldPassThePurchaseOrderDescriotionToThePrinter(){
        TestPrinter printer=new TestPrinter();
        BillingMachine billingMachine=new BillingMachine(printer);
        Product product = new Product("test",20);
        List<Product> listOfProducts  = new ArrayList<>();
        listOfProducts.add(product);
        PurchaseOrder po = new PurchaseOrder(listOfProducts);
        billingMachine.process(po);
        assertEquals(po.description(),printer.content);
    }
    @Test
    public void shouldTruncateValueTo100BeforePassingItToPrinter(){
        TestPrinter printer=new TestPrinter();
        BillingMachine billingMachine=new BillingMachine(printer);
        Product product = new Product("test",20);
        List<Product> listOfProducts  = new ArrayList<>();
        listOfProducts.add(product);
        PurchaseOrder po = new PurchaseOrder(listOfProducts);
        FakePurchaseOrder fpo = new FakePurchaseOrder("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678902432432432432423412524545781509179857012875980710257821705987912057870197509175");
        billingMachine.process(fpo);
        assertEquals("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890",printer.content);
    }
}

