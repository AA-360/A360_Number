package com.automationanywhere.botcommand.samples.commands.basic;

import com.automationanywhere.botcommand.data.impl.NumberValue;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.commandsdk.model.DataType;

import java.math.BigDecimal;

import static com.automationanywhere.commandsdk.model.AttributeType.SELECT;
import static com.automationanywhere.commandsdk.model.DataType.NUMBER;

@BotCommand
@CommandPkg(
        label = "Round",
        description = "Rounds a number",
        icon = "pkg.svg",
        name = "Round",
        return_description = "",
        return_type = NUMBER,
        return_required = true
)


public class Round {

    @Execute
    public NumberValue action(
            @Idx(index = "1", type = AttributeType.NUMBER)
            @Pkg(label = "Number",description = "the value that will be used to round")
            @NotEmpty
                    Double number,
            @Idx(index = "2", type = AttributeType.NUMBER)
            @Pkg(label = "Decimal places",description = "")
            @NotEmpty
            Double decimal_places,
            @Idx(index = "3", type = SELECT, options = {
                    @Idx.Option(index = "3.1", pkg = @Pkg(label = "Floor", value = "f")),
                    @Idx.Option(index = "3.2", pkg = @Pkg(label = "Ceiling", value = "c"))})
            @Pkg(label = "Round mode",description = "", default_value = "f", default_value_type = DataType.STRING)
            @NotEmpty
            String mode

    ) {
        if ( mode.equals("f")) {
            return new NumberValue(BigDecimal.valueOf(number).setScale(decimal_places.intValue(), BigDecimal.ROUND_FLOOR));
        } else {
            return new NumberValue(BigDecimal.valueOf(number).setScale(decimal_places.intValue(), BigDecimal.ROUND_CEILING));
        }
    }


}
