package TypewiseAlert;

public class AlertFactory {
    public IAlertTarget AlertFactory(TypewiseAlert.TypewiseAlert.AlertTarget alertTarget) {
        if (alertTarget.equals(TypewiseAlert.AlertTarget.TO_CONTROLLER)) return new Controller();
        else if (alertTarget.equals(TypewiseAlert.AlertTarget.TO_EMAIL)) return new EmailSender();
        return new EmailSender();
    }
}
