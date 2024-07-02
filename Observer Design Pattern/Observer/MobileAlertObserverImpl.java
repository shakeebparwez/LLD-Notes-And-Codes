package ObserverPattern.Observer;

import ObserverPattern.Observable.StocksObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver {
    String userName;
    StocksObservable observable;

    public MobileAlertObserverImpl(String emailId, StocksObservable observable) {
        this.observable = observable;
        this.userName = emailId;
    }

    @Override
    public void update() {
        sendMsgOnMobile(userName, "Product is in Stock! Hurry Up!");
    }

    private void sendMsgOnMobile(String userName, String msg) {
        System.out.println(msg + "\nSent to: " + userName);
    }
}

