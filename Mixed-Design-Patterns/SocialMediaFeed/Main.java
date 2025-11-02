package SocialMediaFeed;

public class Main {
    public static void main(String args[]){
        Posts decoratedPosts = new SimplePost();
        System.out.println(decoratedPosts.createPost());
        decoratedPosts= new Media(decoratedPosts);
        System.out.println(decoratedPosts.createPost());
        decoratedPosts= new Hashtags(decoratedPosts);
        System.out.println(decoratedPosts.createPost());
        decoratedPosts = new Mention(decoratedPosts);
        System.out.println(decoratedPosts.createPost());
    }
    
}
