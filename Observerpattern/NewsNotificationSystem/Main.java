package NewsNotificationSystem;

public class Main {
    public static void main(String args[]){
        NewsChannel bbcNews = new NewsChannel();
        Observer johnApp = new PhoneApp("John");
        Observer aliceApp = new PhoneApp("Alice");
        bbcNews.subscribe(johnApp);
        bbcNews.subscribe(aliceApp);

        bbcNews.setLatestNews("Sports: World Cup finals tomorrow!");
    }
    
}
