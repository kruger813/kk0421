package main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Class used to validate input and generate Rental Agreement
public class Checkout {

    // Checkout variables
    private String toolCode;
    private int rentalDayCount;
    private int discountPercent;
    private String checkOutDate;
    private Date validatedDate;

    // Checkout constructor requires Tool Code, Rental Day Count, Discount Percent, and Check Out Date
    public Checkout(String toolCode, int rentalDayCount, int discountPercent, String checkOutDate){
        this.toolCode = toolCode;
        this.rentalDayCount = rentalDayCount;
        this.discountPercent = discountPercent;
        this.checkOutDate = checkOutDate;
        validate();
    }

    // Method used to validate checkout inputs
    private void validate(){
        switch (toolCode){
            case "LADW":
            case "CHNS":
            case "JAKR":
            case "JAKD":
                break;
            default:
                throw new InvalidInputException("Please input a valid tool code.");
        }
        if(rentalDayCount < 1){
            throw new InvalidInputException("Rental day count must be 1 or greater.");
        }
        if(discountPercent < 0 || discountPercent > 100){
            throw new InvalidInputException("Discount Percent must be between 0 and 100.");
        }
        try{
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
            validatedDate = dateFormat.parse(checkOutDate);
        }
        catch (ParseException e){
            throw new InvalidInputException("Please enter a valid date formatted as mm/dd/yy.");
        }
    }

    // Method used to generate Rental Agreement from current Checkout
    public RentalAgreement generateRentalAgreement(){
        switch (toolCode){
            case "LADW":
               return new LadderRentalAgreement(ToolCode.LADW, rentalDayCount, validatedDate, discountPercent);
            case "CHNS":
                return new ChainsawRentalAgreement(ToolCode.CHNS, rentalDayCount, validatedDate, discountPercent);
            case "JAKR":
                return new JackhammerRentalAgreement(ToolCode.JAKR, rentalDayCount, validatedDate, discountPercent);
            case "JAKD":
                return new JackhammerRentalAgreement(ToolCode.JAKD, rentalDayCount, validatedDate, discountPercent);
            default:
                return null;
        }
    }
}
