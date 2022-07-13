package TypewiseAlert;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Map;

public class TypewiseAlertTest {

    TemperatureBreachClassification temperatureBreachClassification = new TemperatureBreachClassification();
    EmailSender emailSender = new EmailSender();
    TypewiseAlert typewiseAlert = new TypewiseAlert();

    @Test
    public void infersBreachAsPerLimitsTest() {
        assertTrue(temperatureBreachClassification.inferBreach(12, 20, 30) == EnumConstants.BreachType.TOO_LOW);
        assertTrue(temperatureBreachClassification.inferBreach(40, 20, 30) == EnumConstants.BreachType.TOO_HIGH);
        assertTrue(temperatureBreachClassification.inferBreach(20, 20, 30) == EnumConstants.BreachType.NORMAL);

    }

    @Test
    public void getLimitsTest() {
        Map<String, Integer> limitMap = temperatureBreachClassification.getLimits(EnumConstants.CoolingType.HI_ACTIVE_COOLING);
        assertTrue(limitMap.get("lower") == 0);
        assertTrue(limitMap.get("upper") == 45);
    }

    @Test
    public void getMessage() {
        String highMessage = emailSender.getMessage(EnumConstants.BreachType.TOO_HIGH);
        String lowMessage = emailSender.getMessage(EnumConstants.BreachType.TOO_LOW);
        assertTrue("Hi, the temperature is too high\n".equals(highMessage));
        assertTrue("Hi, the temperature is too low\n".equals(lowMessage));
    }

    @Test
    public void sendToTarget() {
        boolean emailSent = emailSender.sendToTarget(EnumConstants.BreachType.TOO_LOW);
        assertTrue(emailSent);
    }

    @Test
    public void sendToTargetControllerTest() {
        Controller controller = new Controller();
        boolean controllerValue = controller.sendToTarget(EnumConstants.BreachType.TOO_LOW);
        assertTrue(controllerValue);
    }

    @Test
    public void alertFactoryTest(){
        AlertFactory alertFactory = new AlertFactory();
        IAlertTarget  iAlertTargetController = alertFactory.AlertFactory(EnumConstants.AlertTarget.TO_CONTROLLER);
        IAlertTarget iAlertTargetEmail = alertFactory.AlertFactory(EnumConstants.AlertTarget.TO_EMAIL);
        IAlertTarget iAlertTargetDefault = alertFactory.AlertFactory(EnumConstants.AlertTarget.DEFAULT);
        assertTrue(iAlertTargetController instanceof Controller);
        assertTrue(iAlertTargetEmail instanceof EmailSender);
        assertTrue(iAlertTargetDefault instanceof EmailSender);

    }

    @Test
    public void sendAlert(){
       boolean sendAlert = TypewiseAlert.sendAlert(EnumConstants.AlertTarget.TO_EMAIL, EnumConstants.CoolingType.HI_ACTIVE_COOLING, 20);
       assertTrue(sendAlert == true);
    }
}
