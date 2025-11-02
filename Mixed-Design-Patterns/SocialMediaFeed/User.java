package SocialMediaFeed;
import java.util.ArrayList;
import java.util.List;

public class User implements Subject, Observer {
    private String username;
    private List<Observer> followers = new ArrayList<>();
    public User(String username){
        this.username = username;
    }
    @Override
    public void addFollower(User user) {
        followers.add(user);
    }
    @Override
    public void removeFollower(User user) {
        followers.remove(user);
    }
    @Override
    public void notifyFollowers(Posts post) {
        for (Observer follower : followers) {
            follower.update(username, post);
        }
    }
    @Override
    public void update(String username, Posts post) {
        System.out.println(this.username + " received notification: " + username + " posted - " + post.createPost());
    }
    public void post(Posts post){
        notifyFollowers(post);
    }
}
