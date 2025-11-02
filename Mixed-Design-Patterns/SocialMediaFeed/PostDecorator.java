package SocialMediaFeed;

public abstract class PostDecorator implements Posts {
    protected Posts decoratedPost;

    public PostDecorator(Posts decoratedPost) {
        this.decoratedPost = decoratedPost;
    }

    @Override
    public String createPost() {
        return decoratedPost.createPost();
    }
}
