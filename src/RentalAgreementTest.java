import org.junit.Test;

import java.time.LocalDate;
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
}
