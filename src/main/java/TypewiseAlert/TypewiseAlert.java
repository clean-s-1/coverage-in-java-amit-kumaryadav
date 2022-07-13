package TypewiseAlert;

import java.util.Map;

public class TypewiseAlert {


    public class BatteryCharacter {
        public TypewiseAlert.EnumConstants.CoolingType coolingType;
    }

    public static TypewiseAlert.EnumConstants.BreachType classifyTemperatureBreach(TypewiseAlert.EnumConstants.CoolingType coolingType, double temperatureInC) {
        TemperatureBreachClassification breachClassification = new TemperatureBreachClassification();
        Map<String, Integer> limits = breachClassification.getLimits(coolingType);
        return breachClassification.inferBreach(temperatureInC, limits.get("lower"), limits.get("upper"));
    }

    public static boolean sendAlert(TypewiseAlert.EnumConstants.AlertTarget alertTarget, BatteryCharacter batteryChar, double temperatureInC) {
        TypewiseAlert.EnumConstants.BreachType breachType = classifyTemperatureBreach(batteryChar.coolingType, temperatureInC);
        AlertFactory alertFactory = new AlertFactory();
        IAlertTarget target = alertFactory.AlertFactory(alertTarget);
        return target.sendToTarget(breachType);
    }

}
