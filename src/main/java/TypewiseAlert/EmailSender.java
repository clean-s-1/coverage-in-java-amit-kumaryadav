package TypewiseAlert;

import java.util.HashMap;
import java.util.Map;

import static TypewiseAlert.EnumConstants.BreachType.TOO_HIGH;
import static TypewiseAlert.EnumConstants.BreachType.TOO_LOW;

public class EmailSender implements IAlertTarget {

    Map<TypewiseAlert.EnumConstants.BreachType, String> map = new HashMap();

    @Override
    public boolean sendToTarget(TypewiseAlert.EnumConstants.BreachType breachType) {
        String recipient = "a.b@c.com";
        String message = getMessage(breachType);
        System.out.printf("To: %s\n", recipient);
        System.out.println(message);
        return true;
    }

    public String getMessage(TypewiseAlert.EnumConstants.BreachType key) {
        map.put(TOO_LOW, "Hi, the temperature is too low\n");
        map.put(TOO_HIGH, "Hi, the temperature is too high\n");
        return map.get(key);
    }
}
