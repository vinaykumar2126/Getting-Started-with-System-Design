package SocialMediaFeed;

public class Media extends PostDecorator{

    public Media(Posts post) {
        super(post);
    }

    @Override
    public String createPost() {
        return decoratedPost.createPost() + " with Media" ;
    }
    
}
