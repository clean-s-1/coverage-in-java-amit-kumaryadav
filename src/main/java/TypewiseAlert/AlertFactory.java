package TypewiseAlert;

public class AlertFactory {
    public IAlertTarget AlertFactory(EnumConstants.AlertTarget alertTarget) {
        if (alertTarget.equals(EnumConstants.AlertTarget.TO_CONTROLLER)) return new Controller();
        else if (alertTarget.equals(EnumConstants.AlertTarget.TO_EMAIL)) return new EmailSender();
        return new EmailSender();
    }
}
