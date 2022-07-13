package TypewiseAlert;

import java.util.Map;

public class TypewiseAlert {
    public enum BreachType {
        NORMAL, TOO_LOW, TOO_HIGH
    }

    ;

    public enum CoolingType {
        PASSIVE_COOLING, HI_ACTIVE_COOLING, MED_ACTIVE_COOLING
    }

    ;

    public enum AlertTarget {
        TO_CONTROLLER, TO_EMAIL
    }

    ;


    public class BatteryCharacter {
        public CoolingType coolingType;
    }


    public static BreachType classifyTemperatureBreach(CoolingType coolingType, double temperatureInC) {
        TemperatureBreachClassification breachClassification = new TemperatureBreachClassification();
        Map<String, Integer> limits = breachClassification.getLimits(coolingType);
        return breachClassification.inferBreach(temperatureInC, limits.get("lower"), limits.get("upper"));
    }

    public static boolean sendAlert(AlertTarget alertTarget, BatteryCharacter batteryChar, double temperatureInC) {
        BreachType breachType = classifyTemperatureBreach(batteryChar.coolingType, temperatureInC);
        AlertFactory alertFactory = new AlertFactory();
        IAlertTarget target = alertFactory.AlertFactory(alertTarget);
        return target.sendToTarget(breachType);
    }

}
