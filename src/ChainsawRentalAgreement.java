import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class ChainsawRentalAgreement extends RentalAgreement{
    // Rental Agreement constructor for ladders
    public ChainsawRentalAgreement(int rentalDays, Date checkOutDate, int discountPercent){
        toolCode = ToolCode.CHNS;
        toolType = "Chainsaw";
        toolBrand = "Stihl";
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

    //Method used to calculate the Charge Days based on
    //TODO look into way to do this without a loop to increase efficiency at higher rental days
    @Override
    protected int calculateChargeDays() {
        int chargeDays = 0;
        Calendar c = Calendar.getInstance();
        c.setTime(checkOutDate);
        // Iterate through every rental day
        for(int i = 0; i < rentalDays; i++){
            c.add(Calendar.DATE, 1);
            // Make sure it is not a weekend
            if(!(Calendar.DAY_OF_WEEK == Calendar.SATURDAY || Calendar.DAY_OF_WEEK == Calendar.SUNDAY)){
                chargeDays++;
            }
        }
        return  chargeDays;
    }
}
