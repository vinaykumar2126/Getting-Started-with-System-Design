package SocialMediaFeed;

public class Hashtags extends PostDecorator {
    public Hashtags(Posts content) {
        super(content);
    }

    @Override
    public String createPost() {
        return decoratedPost.createPost() + " with #fun #socialmedia";
    }
    
}
