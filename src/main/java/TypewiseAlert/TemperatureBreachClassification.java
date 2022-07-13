package TypewiseAlert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static TypewiseAlert.EnumConstants.CoolingType.*;


public class TemperatureBreachClassification {
    public final int incrementCounter = 5;
    ArrayList<EnumConstants.CoolingType> coolingTypeConstLimit = new ArrayList<>(Arrays.asList(PASSIVE_COOLING, MED_ACTIVE_COOLING, HI_ACTIVE_COOLING));

    public Map<String, Integer> getLimits(EnumConstants.CoolingType coolingType) {
        Map<String, Integer> result = new HashMap<>();
        int lowerLimit = 0;
        int upperLimit = 35;
        for (int i = 0; i < coolingTypeConstLimit.size(); i++) {
            if (coolingTypeConstLimit.get(i).equals(coolingType)) {
                upperLimit = upperLimit + i * incrementCounter;
                break;
            }
        }
        result.put("lower", lowerLimit);
        result.put("upper", upperLimit);
        return result;
    }

    public EnumConstants.BreachType inferBreach(double value, double lowerLimit, double upperLimit) {
        if (value < lowerLimit) {
            return EnumConstants.BreachType.TOO_LOW;
        }
        if (value > upperLimit) {
            return EnumConstants.BreachType.TOO_HIGH;
        }
        return EnumConstants.BreachType.NORMAL;
    }
}
