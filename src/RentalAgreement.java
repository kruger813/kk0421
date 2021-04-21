import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

// Parent class of object generated at checkout
public abstract class RentalAgreement {
    // Enum for tool codes
    enum ToolCode{
        LADW, CHNS, JAKR, JAKD
    }

    // Rental Agreement values
    private ToolCode toolCode;
    private String toolType;
    private String toolBrand;
    private int rentalDays;
    private Date checkOutDate;
    private Date dueDate;
    private BigDecimal dailyCharge;
    private int chargeDays;
    private BigDecimal preDiscountCharge;
    private int discountPercent;
    private BigDecimal discountAmount;
    private BigDecimal finalCharge;

    // Prints Rental Agreement to the console
    public void printRentalAgreement(){
        System.out.println("Tool code: " + toolCode);
        System.out.println("Tool type: " + toolType);
        System.out.println("Tool brand: " + toolBrand);
        System.out.println("Rental days: " + rentalDays);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
        System.out.println("Check out date: " + dateFormat.format(checkOutDate));
        System.out.println("Due date: " + dateFormat.format(dueDate));
        System.out.println("Daily rental charge: $" + dailyCharge);
        System.out.println("Charge days: " + chargeDays);
        System.out.println("Pre-discount charge: $" + preDiscountCharge);
        System.out.println("Discount percent: " + discountPercent + "%");
        System.out.println("Discount amount: $" + discountAmount);
        System.out.println("Final charge: $" + finalCharge);
    }

    // Method used to calculate the Due Date based on Check Out Date and Rental Days
    protected Date calculateDueDate(){
        Calendar c = Calendar.getInstance();
        c.setTime(checkOutDate);
        c.add(Calendar.DATE, rentalDays);
        return c.getTime();
    }

    // Method used to calculate the Pre-discount Charge based on Charge Days and Daily Charge
    protected BigDecimal calculatePreDiscountCharge(){
        return dailyCharge.multiply(new BigDecimal(chargeDays));
    }

    // Method used to calculate the Discount Amount based on Pre-discount Charge and Discount Percent
    protected BigDecimal calculateDiscountAmount(){
        BigDecimal unRounded = preDiscountCharge.multiply(new BigDecimal(discountPercent/100.0));
        return unRounded.setScale(2, RoundingMode.HALF_UP);
    }

    // Method used to calculate the Final Charge based on Pre-discount Charge and Discount Amount
    protected  BigDecimal calculateFinalCharge(){
        return preDiscountCharge.subtract(discountAmount);
    }

    abstract int calculateChargeDays();


}