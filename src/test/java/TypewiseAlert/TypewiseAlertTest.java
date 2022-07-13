package TypewiseAlert;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TypewiseAlertTest {
    @Test
    public void infersBreachAsPerLimits() {
        TemperatureBreachClassification temperatureBreachClassification = new TemperatureBreachClassification();
        assertTrue(temperatureBreachClassification.inferBreach(12, 20, 30) == EnumConstants.BreachType.TOO_LOW);
    }
}
