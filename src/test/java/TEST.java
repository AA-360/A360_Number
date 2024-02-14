import com.automationanywhere.botcommand.data.impl.NumberValue;
import com.automationanywhere.botcommand.samples.commands.basic.GetIntPart;
import com.automationanywhere.botcommand.samples.commands.basic.Round;
import com.automationanywhere.botcommand.samples.commands.basic.TruncateNumber;
import com.sun.jdi.DoubleValue;
import org.testng.annotations.Test;

import javax.crypto.Mac;
import javax.swing.*;
import java.math.BigDecimal;

public class TEST {
    @Test
    public void testEncode(){
        GetIntPart a = new GetIntPart();
        TruncateNumber b = new TruncateNumber();
        Round c = new Round();

        //alert(a.action(1.324).toString());
        //alert(b.action(1.324,2.0).toString());
        //System.out.println(b.action(1.324,3.0).toString());
        //System.out.println(truncateDecimal(1.23,2));
        //BigDecimal c =  new BigDecimal(String.valueOf(1.26)).setScale(3, BigDecimal.ROUND_CEILING);
        BigDecimal d = new BigDecimal(123.13698);
        BigDecimal roundOff = d.setScale(0, BigDecimal.ROUND_CEILING);
        System.out.println(roundOff);

        NumberValue dv = c.action(132.12547,2.0,"f");

        int dd  =1;

    }


    private static BigDecimal truncateDecimal(double x, int numberofDecimals)
    {
        if ( x > 0) {
            return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_FLOOR);
        } else {
            return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING);
        }
    }

    public void encode(){
        try {
            alert("qsdasdas");
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        }catch (Exception e){
            alert(e.getMessage());
        }
    }

    private void alert(String text){
        JOptionPane.showMessageDialog(null, text, "InfoBox: Title", JOptionPane.INFORMATION_MESSAGE);
    }
}

