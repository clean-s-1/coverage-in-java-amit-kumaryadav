package TypewiseAlert;

public class Controller implements IAlertTarget {

    @Override
    public boolean sendToTarget(EnumConstants.BreachType breachType) {
        int header = 0xfeed;
        System.out.printf("%s : %s\n", header, breachType);
        return true;
    }
}
