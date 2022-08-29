package com.automationanywhere.botcommand.samples.commands.basic;

import com.automationanywhere.botcommand.data.impl.NumberValue;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;

import java.math.BigDecimal;

import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.NUMBER;


@BotCommand
@CommandPkg(
        label = "TruncateNumber",
        description = "Get the Integer part of a number",
        icon = "pkg.svg",
        name = "TruncateNumber",
        return_description = "",
        return_type = NUMBER,
        return_required = true
)


public class TruncateNumber {

    @Execute
    public NumberValue action(
            @Idx(index = "1", type = TEXT)
            @Pkg(label = "Number",description = "The value that will be used to truncate")
            @NotEmpty
                    Double number,
            @Idx(index = "2", type = TEXT)
            @Pkg(label = "DecimalPlaces",description = "The number of decimal places to keep")
            @NotEmpty
                    Double decimalPlaces

    ) {
        //return new NumberValue(number);
       return new NumberValue(truncateDecimal(number,decimalPlaces.intValue()));
    }

    private static BigDecimal truncateDecimal(double x, int numberofDecimals)
    {
        if ( x > 0) {
            return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_FLOOR);
        } else {
            return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING);
        }
    }


}
