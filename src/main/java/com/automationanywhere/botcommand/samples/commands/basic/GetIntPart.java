package com.automationanywhere.botcommand.samples.commands.basic;

import com.automationanywhere.botcommand.data.impl.NumberValue;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.commandsdk.model.DataType;

import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.*;

@BotCommand
@CommandPkg(
        label = "GetIntPart",
        description = "Get the Integer part of a number",
        icon = "pkg.svg",
        name = "GetIntPart",
        return_description = "",
        return_type = NUMBER,
        return_required = true
)


public class GetIntPart {

    @Execute
    public NumberValue action(
            @Idx(index = "1", type = AttributeType.NUMBER)
            @Pkg(label = "Number",description = "the value that will be used to extract the Int part")
            @NotEmpty
                    Double number

    ) {
       return new NumberValue(number.intValue());
    }


}
