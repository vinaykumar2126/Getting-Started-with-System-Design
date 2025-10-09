package NewsNotificationSystem;
import java.util.ArrayList;
import java.util.List;

public class NewsChannel implements Subject {
    private List<Observer> subscribers;
    private String latestnews;

    public NewsChannel(){
        this.subscribers = new ArrayList<>();
    }
    @Override
    public void subscribe(Observer observer) {
        subscribers.add(observer);
        // System.out.println(subscribers.toString());
    }

    @Override
    public void unsubscribe(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : subscribers) {
            observer.update(latestnews);
        }
    }

    public void setLatestNews(String news) {
        this.latestnews = news;
        notifyObservers();
    }
}
