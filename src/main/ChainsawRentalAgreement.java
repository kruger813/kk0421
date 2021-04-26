package main;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class ChainsawRentalAgreement extends RentalAgreement{
    // Rental Agreement constructor for ladders
    public ChainsawRentalAgreement(ToolCode toolCode, int rentalDays, Date checkOutDate, int discountPercent){
        // There is no reason to use a switch statement here except to make adding new tool codes easier.
        switch (toolCode){
            case CHNS:
                this.toolCode = ToolCode.CHNS;
                toolBrand = "Stihl";
                break;
        }
        toolType = "Chainsaw";
        this.rentalDays = rentalDays;
        this.checkOutDate = checkOutDate;
        dueDate = calculateDueDate();
        dailyCharge = new BigDecimal("1.49");
        chargeDays = calculateChargeDays();
        preDiscountCharge = calculatePreDiscountCharge();
        this.discountPercent = discountPercent;
        discountAmount = calculateDiscountAmount();
        finalCharge = calculateFinalCharge();
    }

    //Method used to calculate the Charge Days based on Check Out Date and Rental Days
    @Override
    protected int calculateChargeDays() {
        int chargeDays = (rentalDays / 7) * 5;
        Calendar c = Calendar.getInstance();
        c.setTime(checkOutDate);
        // Calculate what day of week rental ends on
        int endDay = c.get(Calendar.DAY_OF_WEEK) + (rentalDays % 7);
        // See if the last week of the rental rolled over a weekend
        if(endDay == 7){
            chargeDays += (rentalDays % 7) - 1;
        }
        else if(endDay > 7){
            chargeDays += (rentalDays % 7) - 2;
        }
        else{
            chargeDays += rentalDays % 7;
        }
        return chargeDays;
    }
}
