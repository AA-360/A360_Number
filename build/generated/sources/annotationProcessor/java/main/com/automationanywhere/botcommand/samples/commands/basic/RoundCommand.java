package com.automationanywhere.botcommand.samples.commands.basic;

import com.automationanywhere.bot.service.GlobalSessionContext;
import com.automationanywhere.botcommand.BotCommand;
import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import java.lang.ClassCastException;
import java.lang.Deprecated;
import java.lang.Double;
import java.lang.Object;
import java.lang.String;
import java.lang.Throwable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class RoundCommand implements BotCommand {
  private static final Logger logger = LogManager.getLogger(RoundCommand.class);

  private static final Messages MESSAGES_GENERIC = MessagesFactory.getMessages("com.automationanywhere.commandsdk.generic.messages");

  @Deprecated
  public Optional<Value> execute(Map<String, Value> parameters, Map<String, Object> sessionMap) {
    return execute(null, parameters, sessionMap);
  }

  public Optional<Value> execute(GlobalSessionContext globalSessionContext,
      Map<String, Value> parameters, Map<String, Object> sessionMap) {
    logger.traceEntry(() -> parameters != null ? parameters.entrySet().stream().filter(en -> !Arrays.asList( new String[] {}).contains(en.getKey()) && en.getValue() != null).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).toString() : null, ()-> sessionMap != null ?sessionMap.toString() : null);
    Round command = new Round();
    HashMap<String, Object> convertedParameters = new HashMap<String, Object>();
    if(parameters.containsKey("number") && parameters.get("number") != null && parameters.get("number").get() != null) {
      convertedParameters.put("number", parameters.get("number").get());
      if(convertedParameters.get("number") !=null && !(convertedParameters.get("number") instanceof Double)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","number", "Double", parameters.get("number").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("number") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","number"));
    }

    if(parameters.containsKey("decimal_places") && parameters.get("decimal_places") != null && parameters.get("decimal_places").get() != null) {
      convertedParameters.put("decimal_places", parameters.get("decimal_places").get());
      if(convertedParameters.get("decimal_places") !=null && !(convertedParameters.get("decimal_places") instanceof Double)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","decimal_places", "Double", parameters.get("decimal_places").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("decimal_places") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","decimal_places"));
    }

    if(parameters.containsKey("mode") && parameters.get("mode") != null && parameters.get("mode").get() != null) {
      convertedParameters.put("mode", parameters.get("mode").get());
      if(convertedParameters.get("mode") !=null && !(convertedParameters.get("mode") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","mode", "String", parameters.get("mode").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("mode") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","mode"));
    }
    if(convertedParameters.get("mode") != null) {
      switch((String)convertedParameters.get("mode")) {
        case "f" : {

        } break;
        case "c" : {

        } break;
        default : throw new BotCommandException(MESSAGES_GENERIC.getString("generic.InvalidOption","mode"));
      }
    }

    try {
      Optional<Value> result =  Optional.ofNullable(command.action((Double)convertedParameters.get("number"),(Double)convertedParameters.get("decimal_places"),(String)convertedParameters.get("mode")));
      return logger.traceExit(result);
    }
    catch (ClassCastException e) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.IllegalParameters","action"));
    }
    catch (BotCommandException e) {
      logger.fatal(e.getMessage(),e);
      throw e;
    }
    catch (Throwable e) {
      logger.fatal(e.getMessage(),e);
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.NotBotCommandException",e.getMessage()),e);
    }
  }
}
