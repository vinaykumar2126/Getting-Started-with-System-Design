package SocialMediaFeed;

public interface Subject {
    void addFollower(User user);
    void removeFollower(User user);
    void notifyFollowers(Posts post);
}
