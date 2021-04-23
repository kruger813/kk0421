import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// Parent class of object generated at checkout
public abstract class RentalAgreement {

    // Rental Agreement values
    protected ToolCode toolCode;
    protected String toolType;
    protected String toolBrand;
    protected int rentalDays;
    protected Date checkOutDate;
    protected Date dueDate;
    protected BigDecimal dailyCharge;
    protected int chargeDays;
    protected BigDecimal preDiscountCharge;
    protected int discountPercent;
    protected BigDecimal discountAmount;
    protected BigDecimal finalCharge;

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
    protected BigDecimal calculateFinalCharge(){
        return preDiscountCharge.subtract(discountAmount);
    }

    // Method to detect if a date falls on a weekend
    protected boolean isWeekend(Calendar c){
        return (c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY);
    }

    // Method to detect if a date falls on a holiday
    protected boolean isHoliday(Calendar c, boolean carryOverMode){
        return ((c.get(Calendar.MONTH) == Calendar.JULY && c.get(Calendar.DATE) == 4) ||
                (c.get(Calendar.MONTH) == Calendar.JULY && c.get(Calendar.DATE) == 3 && c.get(Calendar.DAY_OF_WEEK) ==
                        Calendar.FRIDAY) && carryOverMode ||
                (c.get(Calendar.MONTH) == Calendar.JULY && c.get(Calendar.DATE) == 5 && c.get(Calendar.DAY_OF_WEEK) ==
                        Calendar.MONDAY) && carryOverMode ||
                (c.get(Calendar.MONTH) == Calendar.SEPTEMBER && c.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY &&
                        c.get(Calendar.DAY_OF_MONTH) <= 7));

    }

    abstract int calculateChargeDays();


}
