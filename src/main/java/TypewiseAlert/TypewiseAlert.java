package TypewiseAlert;

import java.util.Map;

public class TypewiseAlert {

    public static EnumConstants.BreachType classifyTemperatureBreach(EnumConstants.CoolingType coolingType, double temperatureInC) {
        TemperatureBreachClassification breachClassification = new TemperatureBreachClassification();
        Map<String, Integer> limits = breachClassification.getLimits(coolingType);
        return breachClassification.inferBreach(temperatureInC, limits.get("lower"), limits.get("upper"));
    }

    public static boolean sendAlert(EnumConstants.AlertTarget alertTarget, EnumConstants.CoolingType coolingType, double temperatureInC) {
        EnumConstants.BreachType breachType = classifyTemperatureBreach(coolingType, temperatureInC);
        AlertFactory alertFactory = new AlertFactory();
        IAlertTarget target = alertFactory.AlertFactory(alertTarget);
        return target.sendToTarget(breachType);
    }

}
