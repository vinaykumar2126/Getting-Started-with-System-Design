package SocialMediaFeed;

public abstract class PostDecorator implements Posts {
    protected Posts decoratedPost;

    public PostDecorator(Posts decoratedPost) {
        this.decoratedPost = decoratedPost;
    }

}
