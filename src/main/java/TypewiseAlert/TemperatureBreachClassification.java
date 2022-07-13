package TypewiseAlert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static TypewiseAlert.TypewiseAlert.CoolingType.*;

public class TemperatureBreachClassification {
    public final int incrementCounter = 5;
    ArrayList<TypewiseAlert.CoolingType> coolingTypeConstLimit = new ArrayList<>(Arrays.asList(PASSIVE_COOLING, MED_ACTIVE_COOLING, HI_ACTIVE_COOLING));

    public Map<String, Integer> getLimits(TypewiseAlert.TypewiseAlert.CoolingType coolingType) {
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

    public  TypewiseAlert.TypewiseAlert.BreachType inferBreach(double value, double lowerLimit, double upperLimit) {
        if (value < lowerLimit) {
            return TypewiseAlert.TypewiseAlert.BreachType.TOO_LOW;
        }
        if (value > upperLimit) {
            return TypewiseAlert.TypewiseAlert.BreachType.TOO_HIGH;
        }
        return TypewiseAlert.TypewiseAlert.BreachType.NORMAL;
    }
}
