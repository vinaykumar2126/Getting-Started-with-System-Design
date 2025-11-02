package SocialMediaFeed;

public class Main {
    public static void main(String args[]) {
        User alice = new User("alice");
        User bob = new User("bob");
        User charlie = new User("charlie");

        // Bob and Charlie follow Alice
        alice.addFollower(bob);
        alice.addFollower(charlie);

        // Alice creates a decorated post
        Posts alicePost = new SimplePost();
        alicePost = new Media(alicePost);
        alicePost = new Hashtags(alicePost);
        alicePost = new Mention(alicePost);
        
        // Alice posts (Bob and Charlie are notified)
        System.out.println("=== Alice posting ===");
        alice.post(alicePost);

        // Charlie follows Bob
        bob.addFollower(charlie);

        // Bob creates a simple post
        System.out.println("\n=== Bob posting ===");
        bob.post(new SimplePost());
    }
}