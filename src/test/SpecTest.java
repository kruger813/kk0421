package test;

import main.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

// Tests scenarios from the specification document
public class SpecTest {
    @Test
    public void test1(){
        Assert.assertThrows(InvalidInputException.class, () -> {
            Checkout checkout = new Checkout("JAKR", 5, 101, "9/3/15");
        });
    }

    @Test
    public void test2(){
        Checkout checkout = new Checkout("LADW", 3, 10, "7/2/20");
        RentalAgreement rentalAgreement = checkout.generateRentalAgreement();
        rentalAgreement.printRentalAgreement();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
        Assert.assertSame(ToolCode.LADW, rentalAgreement.getToolCode());
        Assert.assertEquals("Ladder", rentalAgreement.getToolType());
        Assert.assertEquals("Werner", rentalAgreement.getToolBrand());
        Assert.assertEquals(3, rentalAgreement.getRentalDays());
        Assert.assertEquals("07/02/20", dateFormat.format(rentalAgreement.getCheckOutDate()));
        Assert.assertEquals("07/05/20", dateFormat.format(rentalAgreement.getDueDate()));
        Assert.assertEquals(new BigDecimal("1.99"), rentalAgreement.getDailyCharge());
        Assert.assertEquals(2, rentalAgreement.getChargeDays());
        Assert.assertEquals(new BigDecimal("3.98"), rentalAgreement.getPreDiscountCharge());
        Assert.assertEquals(10, rentalAgreement.getDiscountPercent());
        Assert.assertEquals(new BigDecimal("0.40"), rentalAgreement.getDiscountAmount());
        Assert.assertEquals(new BigDecimal("3.58"), rentalAgreement.getFinalCharge());
    }

    @Test
    public void test3(){
        Checkout checkout = new Checkout("CHNS", 5, 25, "7/2/15");
        RentalAgreement rentalAgreement = checkout.generateRentalAgreement();
        rentalAgreement.printRentalAgreement();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
        Assert.assertSame(ToolCode.CHNS, rentalAgreement.getToolCode());
        Assert.assertEquals("Chainsaw", rentalAgreement.getToolType());
        Assert.assertEquals("Stihl", rentalAgreement.getToolBrand());
        Assert.assertEquals(5, rentalAgreement.getRentalDays());
        Assert.assertEquals("07/02/15", dateFormat.format(rentalAgreement.getCheckOutDate()));
        Assert.assertEquals("07/07/15", dateFormat.format(rentalAgreement.getDueDate()));
        Assert.assertEquals(new BigDecimal("1.49"), rentalAgreement.getDailyCharge());
        Assert.assertEquals(3, rentalAgreement.getChargeDays());
        Assert.assertEquals(new BigDecimal("4.47"), rentalAgreement.getPreDiscountCharge());
        Assert.assertEquals(25, rentalAgreement.getDiscountPercent());
        Assert.assertEquals(new BigDecimal("1.12"), rentalAgreement.getDiscountAmount());
        Assert.assertEquals(new BigDecimal("3.35"), rentalAgreement.getFinalCharge());
    }

    @Test
    public void test4(){
        Checkout checkout = new Checkout("JAKD", 6, 0, "9/3/15");
        RentalAgreement rentalAgreement = checkout.generateRentalAgreement();
        rentalAgreement.printRentalAgreement();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
        Assert.assertSame(ToolCode.JAKD, rentalAgreement.getToolCode());
        Assert.assertEquals("Jackhammer", rentalAgreement.getToolType());
        Assert.assertEquals("DeWalt", rentalAgreement.getToolBrand());
        Assert.assertEquals(6, rentalAgreement.getRentalDays());
        Assert.assertEquals("09/03/15", dateFormat.format(rentalAgreement.getCheckOutDate()));
        Assert.assertEquals("09/09/15", dateFormat.format(rentalAgreement.getDueDate()));
        Assert.assertEquals(new BigDecimal("2.99"), rentalAgreement.getDailyCharge());
        Assert.assertEquals(3, rentalAgreement.getChargeDays());
        Assert.assertEquals(new BigDecimal("8.97"), rentalAgreement.getPreDiscountCharge());
        Assert.assertEquals(0, rentalAgreement.getDiscountPercent());
        Assert.assertEquals(new BigDecimal("0.00"), rentalAgreement.getDiscountAmount());
        Assert.assertEquals(new BigDecimal("8.97"), rentalAgreement.getFinalCharge());
    }

    @Test
    public void test5(){
        Checkout checkout = new Checkout("JAKR", 9, 0, "7/2/15");
        RentalAgreement rentalAgreement = checkout.generateRentalAgreement();
        rentalAgreement.printRentalAgreement();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
        Assert.assertSame(ToolCode.JAKR, rentalAgreement.getToolCode());
        Assert.assertEquals("Jackhammer", rentalAgreement.getToolType());
        Assert.assertEquals("Ridgid", rentalAgreement.getToolBrand());
        Assert.assertEquals(9, rentalAgreement.getRentalDays());
        Assert.assertEquals("07/02/15", dateFormat.format(rentalAgreement.getCheckOutDate()));
        Assert.assertEquals("07/11/15", dateFormat.format(rentalAgreement.getDueDate()));
        Assert.assertEquals(new BigDecimal("2.99"), rentalAgreement.getDailyCharge());
        Assert.assertEquals(5, rentalAgreement.getChargeDays());
        Assert.assertEquals(new BigDecimal("14.95"), rentalAgreement.getPreDiscountCharge());
        Assert.assertEquals(0, rentalAgreement.getDiscountPercent());
        Assert.assertEquals(new BigDecimal("0.00"), rentalAgreement.getDiscountAmount());
        Assert.assertEquals(new BigDecimal("14.95"), rentalAgreement.getFinalCharge());
    }

    @Test
    public void test6(){
        Checkout checkout = new Checkout("JAKR", 4, 50, "7/2/20");
        RentalAgreement rentalAgreement = checkout.generateRentalAgreement();
        rentalAgreement.printRentalAgreement();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
        Assert.assertSame(ToolCode.JAKR, rentalAgreement.getToolCode());
        Assert.assertEquals("Jackhammer", rentalAgreement.getToolType());
        Assert.assertEquals("Ridgid", rentalAgreement.getToolBrand());
        Assert.assertEquals(4, rentalAgreement.getRentalDays());
        Assert.assertEquals("07/02/20", dateFormat.format(rentalAgreement.getCheckOutDate()));
        Assert.assertEquals("07/06/20", dateFormat.format(rentalAgreement.getDueDate()));
        Assert.assertEquals(new BigDecimal("2.99"), rentalAgreement.getDailyCharge());
        Assert.assertEquals(1, rentalAgreement.getChargeDays());
        Assert.assertEquals(new BigDecimal("2.99"), rentalAgreement.getPreDiscountCharge());
        Assert.assertEquals(50, rentalAgreement.getDiscountPercent());
        Assert.assertEquals(new BigDecimal("1.50"), rentalAgreement.getDiscountAmount());
        Assert.assertEquals(new BigDecimal("1.49"), rentalAgreement.getFinalCharge());
    }
}
