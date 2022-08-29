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

public final class TruncateNumberCommand implements BotCommand {
  private static final Logger logger = LogManager.getLogger(TruncateNumberCommand.class);

  private static final Messages MESSAGES_GENERIC = MessagesFactory.getMessages("com.automationanywhere.commandsdk.generic.messages");

  @Deprecated
  public Optional<Value> execute(Map<String, Value> parameters, Map<String, Object> sessionMap) {
    return execute(null, parameters, sessionMap);
  }

  public Optional<Value> execute(GlobalSessionContext globalSessionContext,
      Map<String, Value> parameters, Map<String, Object> sessionMap) {
    logger.traceEntry(() -> parameters != null ? parameters.entrySet().stream().filter(en -> !Arrays.asList( new String[] {}).contains(en.getKey()) && en.getValue() != null).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).toString() : null, ()-> sessionMap != null ?sessionMap.toString() : null);
    TruncateNumber command = new TruncateNumber();
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

    if(parameters.containsKey("decimalPlaces") && parameters.get("decimalPlaces") != null && parameters.get("decimalPlaces").get() != null) {
      convertedParameters.put("decimalPlaces", parameters.get("decimalPlaces").get());
      if(convertedParameters.get("decimalPlaces") !=null && !(convertedParameters.get("decimalPlaces") instanceof Double)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","decimalPlaces", "Double", parameters.get("decimalPlaces").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("decimalPlaces") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","decimalPlaces"));
    }

    try {
      Optional<Value> result =  Optional.ofNullable(command.action((Double)convertedParameters.get("number"),(Double)convertedParameters.get("decimalPlaces")));
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
