package TypewiseAlert;

public class AlertFactory {
    public IAlertTarget AlertFactory(TypewiseAlert.EnumConstants.AlertTarget alertTarget) {
        if (alertTarget.equals(TypewiseAlert.EnumConstants.AlertTarget.TO_CONTROLLER)) return new Controller();
        else if (alertTarget.equals(TypewiseAlert.EnumConstants.AlertTarget.TO_EMAIL)) return new EmailSender();
        return new EmailSender();
    }
}
