import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class JackhammerRentalAgreement extends  RentalAgreement{
    // Rental Agreement constructor for ladders
    public JackhammerRentalAgreement(ToolCode toolCode, int rentalDays, Date checkOutDate, int discountPercent){
        switch (toolCode){
            case JAKR:
                this.toolCode = ToolCode.JAKR;
                toolBrand = "Ridgid";
                break;
            case JAKD:
                this.toolCode = ToolCode.JAKD;
                toolBrand = "DeWalt";
                break;
        }
        toolType = "Jackhammer";
        this.rentalDays = rentalDays;
        this.checkOutDate = checkOutDate;
        dueDate = calculateDueDate();
        dailyCharge = new BigDecimal("2.99");
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
            // Make sure it is not a weekend or holiday
            if(!(isHoliday(c, true) || isWeekend(c))){
                chargeDays++;
            }
        }
        return  chargeDays;
    }
}
