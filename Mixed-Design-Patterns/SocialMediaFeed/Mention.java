package SocialMediaFeed;

public class Mention extends PostDecorator {
    public Mention(Posts decoratedPosts){
        super(decoratedPosts);
    }
    public String mentioning(){
        return "harry";
    }
    @Override
    public String createPost(){
        return decoratedPost.createPost() + " mentioning " + mentioning();
    }
    
}
