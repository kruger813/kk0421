package test;

import main.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

// Additional test cases not covered by SpecTest
public class CheckoutTest {
    @Test
    public void test1(){
        Assert.assertThrows(InvalidInputException.class, () -> {
            Checkout checkout = new Checkout("NULL", 5, 10, "9/3/20");
        });
    }

    @Test
    public void test2(){
        Assert.assertThrows(InvalidInputException.class, () -> {
            Checkout checkout = new Checkout("JAKR", 0, 10, "9/3/20");
        });
    }

    @Test
    public void test3(){
        Assert.assertThrows(InvalidInputException.class, () -> {
            Checkout checkout = new Checkout("JAKR", -1, 10, "9/3/20");
        });
    }

    @Test
    public void test4(){
        Assert.assertThrows(InvalidInputException.class, () -> {
            Checkout checkout = new Checkout("JAKR", 6, -1, "9/3/20");
        });
    }

    @Test
    public void test5(){
        Assert.assertThrows(InvalidInputException.class, () -> {
            Checkout checkout = new Checkout("JAKR", 6, 101, "9/3/20");
        });
    }
}
