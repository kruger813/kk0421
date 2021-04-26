package test;

import main.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class RentalAgreementTest {
    @Test
    public void testLadderPrint(){
        Date temp = new Date();
        RentalAgreement rental0 = new LadderRentalAgreement(ToolCode.LADW, 4, temp, 15);
        rental0.printRentalAgreement();
    }

    @Test
    public void testChainsawPrint(){
        Date temp = new Date();
        RentalAgreement rental0 = new ChainsawRentalAgreement(ToolCode.CHNS, 11, temp, 20);
        rental0.printRentalAgreement();
    }

    @Test
    public void testJackhammerPrint(){
        Date temp = new Date();
        RentalAgreement rental0 = new JackhammerRentalAgreement(ToolCode.JAKR, 3, temp, 0);
        rental0.printRentalAgreement();
        RentalAgreement rental1 = new JackhammerRentalAgreement(ToolCode.JAKD, 17, temp, 32);
        rental1.printRentalAgreement();
    }

    @Test
    public void customPrintTest(){
        ToolCode code = ToolCode.JAKR;
        int month = 7;
        int day = 5;
        int year =  2020;
        int days = 4;
        int discount = 50;
        RentalAgreement rental0;
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month-1);
        c.set(Calendar.DAY_OF_MONTH, day);
        switch (code){
            case LADW:
                rental0 = new LadderRentalAgreement(code, days, c.getTime(), discount);
                break;
            case CHNS:
                rental0 = new ChainsawRentalAgreement(code, days, c.getTime(), discount);
                break;
            case JAKR:
            case JAKD:
                rental0 = new JackhammerRentalAgreement(code, days, c.getTime(), discount);
                break;
            default:
                rental0 = null;
        }
        System.out.println(c.get(Calendar.DAY_OF_WEEK));
    }

    @Test
    public void testCase0(){
        ToolCode code = ToolCode.JAKR;
        int month = 9;
        int day = 3;
        int year =  2015;
        int days = 5;
        int discount = 15;
        RentalAgreement rental0;
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month-1);
        c.set(Calendar.DAY_OF_MONTH, day);
        switch (code){
            case LADW:
                rental0 = new LadderRentalAgreement(code, days, c.getTime(), discount);
                break;
            case CHNS:
                rental0 = new ChainsawRentalAgreement(code, days, c.getTime(), discount);
                break;
            case JAKR:
            case JAKD:
                rental0 = new JackhammerRentalAgreement(code, days, c.getTime(), discount);
                break;
            default:
                rental0 = null;
        }
        Assert.assertSame(ToolCode.JAKR, rental0.getToolCode());
        Assert.assertEquals("Jackhammer", rental0.getToolType());
        Assert.assertEquals("Ridgid", rental0.getToolBrand());
        Assert.assertEquals(5, rental0.getRentalDays());
        Assert.assertEquals(c.getTime(), rental0.getCheckOutDate());
        c.add(Calendar.DATE, 5);
        Assert.assertEquals(c.getTime(), rental0.getDueDate());
        Assert.assertEquals(new BigDecimal("2.99"), rental0.getDailyCharge());
        Assert.assertEquals(2, rental0.getChargeDays());
        Assert.assertEquals(new BigDecimal("5.98"), rental0.getPreDiscountCharge());
        Assert.assertEquals(15, rental0.getDiscountPercent());
        Assert.assertEquals(new BigDecimal("0.90"), rental0.getDiscountAmount());
        Assert.assertEquals(new BigDecimal("5.08"), rental0.getFinalCharge());
    }

    @Test
    public void testCase1(){
        ToolCode code = ToolCode.LADW;
        int month = 7;
        int day = 2;
        int year =  2020;
        int days = 3;
        int discount = 10;
        RentalAgreement rental0;
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month-1);
        c.set(Calendar.DAY_OF_MONTH, day);
        switch (code){
            case LADW:
                rental0 = new LadderRentalAgreement(code, days, c.getTime(), discount);
                break;
            case CHNS:
                rental0 = new ChainsawRentalAgreement(code, days, c.getTime(), discount);
                break;
            case JAKR:
            case JAKD:
                rental0 = new JackhammerRentalAgreement(code, days, c.getTime(), discount);
                break;
            default:
                rental0 = null;
        }
        Assert.assertSame(ToolCode.LADW, rental0.getToolCode());
        Assert.assertEquals("Ladder", rental0.getToolType());
        Assert.assertEquals("Werner", rental0.getToolBrand());
        Assert.assertEquals(3, rental0.getRentalDays());
        Assert.assertEquals(c.getTime(), rental0.getCheckOutDate());
        c.add(Calendar.DATE, 3);
        Assert.assertEquals(c.getTime(), rental0.getDueDate());
        Assert.assertEquals(new BigDecimal("1.99"), rental0.getDailyCharge());
        Assert.assertEquals(2, rental0.getChargeDays());
        Assert.assertEquals(new BigDecimal("3.98"), rental0.getPreDiscountCharge());
        Assert.assertEquals(10, rental0.getDiscountPercent());
        Assert.assertEquals(new BigDecimal("0.40"), rental0.getDiscountAmount());
        Assert.assertEquals(new BigDecimal("3.58"), rental0.getFinalCharge());
    }

    @Test
    public void testCase2(){
        ToolCode code = ToolCode.CHNS;
        int month = 7;
        int day = 2;
        int year =  2015;
        int days = 5;
        int discount = 25;
        RentalAgreement rental0;
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month-1);
        c.set(Calendar.DAY_OF_MONTH, day);
        switch (code){
            case LADW:
                rental0 = new LadderRentalAgreement(code, days, c.getTime(), discount);
                break;
            case CHNS:
                rental0 = new ChainsawRentalAgreement(code, days, c.getTime(), discount);
                break;
            case JAKR:
            case JAKD:
                rental0 = new JackhammerRentalAgreement(code, days, c.getTime(), discount);
                break;
            default:
                rental0 = null;
        }
        Assert.assertSame(ToolCode.CHNS, rental0.getToolCode());
        Assert.assertEquals("Chainsaw", rental0.getToolType());
        Assert.assertEquals("Stihl", rental0.getToolBrand());
        Assert.assertEquals(5, rental0.getRentalDays());
        Assert.assertEquals(c.getTime(), rental0.getCheckOutDate());
        c.add(Calendar.DATE, 5);
        Assert.assertEquals(c.getTime(), rental0.getDueDate());
        Assert.assertEquals(new BigDecimal("1.49"), rental0.getDailyCharge());
        Assert.assertEquals(3, rental0.getChargeDays());
        Assert.assertEquals(new BigDecimal("4.47"), rental0.getPreDiscountCharge());
        Assert.assertEquals(25, rental0.getDiscountPercent());
        Assert.assertEquals(new BigDecimal("1.12"), rental0.getDiscountAmount());
        Assert.assertEquals(new BigDecimal("3.35"), rental0.getFinalCharge());
    }

    @Test
    public void testCase3(){
        ToolCode code = ToolCode.JAKD;
        int month = 9;
        int day = 3;
        int year =  2015;
        int days = 6;
        int discount = 0;
        RentalAgreement rental0;
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month-1);
        c.set(Calendar.DAY_OF_MONTH, day);
        switch (code){
            case LADW:
                rental0 = new LadderRentalAgreement(code, days, c.getTime(), discount);
                break;
            case CHNS:
                rental0 = new ChainsawRentalAgreement(code, days, c.getTime(), discount);
                break;
            case JAKR:
            case JAKD:
                rental0 = new JackhammerRentalAgreement(code, days, c.getTime(), discount);
                break;
            default:
                rental0 = null;
        }
        Assert.assertSame(ToolCode.JAKD, rental0.getToolCode());
        Assert.assertEquals("Jackhammer", rental0.getToolType());
        Assert.assertEquals("DeWalt", rental0.getToolBrand());
        Assert.assertEquals(6, rental0.getRentalDays());
        Assert.assertEquals(c.getTime(), rental0.getCheckOutDate());
        c.add(Calendar.DATE, 6);
        Assert.assertEquals(c.getTime(), rental0.getDueDate());
        Assert.assertEquals(new BigDecimal("2.99"), rental0.getDailyCharge());
        Assert.assertEquals(3, rental0.getChargeDays());
        Assert.assertEquals(new BigDecimal("8.97"), rental0.getPreDiscountCharge());
        Assert.assertEquals(0, rental0.getDiscountPercent());
        Assert.assertEquals(new BigDecimal("0.00"), rental0.getDiscountAmount());
        Assert.assertEquals(new BigDecimal("8.97"), rental0.getFinalCharge());
    }

    @Test
    public void testCase4(){
        ToolCode code = ToolCode.JAKR;
        int month = 7;
        int day = 2;
        int year =  2015;
        int days = 9;
        int discount = 0;
        RentalAgreement rental0;
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month-1);
        c.set(Calendar.DAY_OF_MONTH, day);
        switch (code){
            case LADW:
                rental0 = new LadderRentalAgreement(code, days, c.getTime(), discount);
                break;
            case CHNS:
                rental0 = new ChainsawRentalAgreement(code, days, c.getTime(), discount);
                break;
            case JAKR:
            case JAKD:
                rental0 = new JackhammerRentalAgreement(code, days, c.getTime(), discount);
                break;
            default:
                rental0 = null;
        }
        Assert.assertSame(ToolCode.JAKR, rental0.getToolCode());
        Assert.assertEquals("Jackhammer", rental0.getToolType());
        Assert.assertEquals("Ridgid", rental0.getToolBrand());
        Assert.assertEquals(9, rental0.getRentalDays());
        Assert.assertEquals(c.getTime(), rental0.getCheckOutDate());
        c.add(Calendar.DATE, 9);
        Assert.assertEquals(c.getTime(), rental0.getDueDate());
        Assert.assertEquals(new BigDecimal("2.99"), rental0.getDailyCharge());
        Assert.assertEquals(5, rental0.getChargeDays());
        Assert.assertEquals(new BigDecimal("14.95"), rental0.getPreDiscountCharge());
        Assert.assertEquals(0, rental0.getDiscountPercent());
        Assert.assertEquals(new BigDecimal("0.00"), rental0.getDiscountAmount());
        Assert.assertEquals(new BigDecimal("14.95"), rental0.getFinalCharge());
    }

    @Test
    public void testCase5(){
        ToolCode code = ToolCode.JAKR;
        int month = 7;
        int day = 2;
        int year =  2020;
        int days = 4;
        int discount = 50;
        RentalAgreement rental0;
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month-1);
        c.set(Calendar.DAY_OF_MONTH, day);
        switch (code){
            case LADW:
                rental0 = new LadderRentalAgreement(code, days, c.getTime(), discount);
                break;
            case CHNS:
                rental0 = new ChainsawRentalAgreement(code, days, c.getTime(), discount);
                break;
            case JAKR:
            case JAKD:
                rental0 = new JackhammerRentalAgreement(code, days, c.getTime(), discount);
                break;
            default:
                rental0 = null;
        }
        Assert.assertSame(ToolCode.JAKR, rental0.getToolCode());
        Assert.assertEquals("Jackhammer", rental0.getToolType());
        Assert.assertEquals("Ridgid", rental0.getToolBrand());
        Assert.assertEquals(4, rental0.getRentalDays());
        Assert.assertEquals(c.getTime(), rental0.getCheckOutDate());
        c.add(Calendar.DATE, 4);
        Assert.assertEquals(c.getTime(), rental0.getDueDate());
        Assert.assertEquals(new BigDecimal("2.99"), rental0.getDailyCharge());
        Assert.assertEquals(1, rental0.getChargeDays());
        Assert.assertEquals(new BigDecimal("2.99"), rental0.getPreDiscountCharge());
        Assert.assertEquals(50, rental0.getDiscountPercent());
        Assert.assertEquals(new BigDecimal("1.50"), rental0.getDiscountAmount());
        Assert.assertEquals(new BigDecimal("1.49"), rental0.getFinalCharge());
    }
}
