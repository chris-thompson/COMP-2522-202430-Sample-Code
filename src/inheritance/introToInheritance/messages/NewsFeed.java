package inheritance.introToInheritance.messages;

import java.util.ArrayList;

/**
 * Stores news posts for the news feed in a
 * social network application (like FaceBook or Google+).
 *<p>
 * Display of the posts is currently simulated by printing the
 * details to the terminal.
 *
 * @author  BCIT Based on code by the authors of BlueJ
 * @version 2024
 */
public class NewsFeed {

    private final ArrayList<Post> posts;

    /**
     * Constructs empty news feed.
     */
    public NewsFeed() {
        posts = new ArrayList<>();
    }

    /**
     * Adds a post to the news feed.
     *
     * @param post  The post to be added.
     */
    public void addPost(final Post post) {
        posts.add(post);
    }

    /**
     * Shows the news feed. Currently: print the news feed details
     * to the terminal. (To do: replace this later with display
     * in web browser.)
     */
    public void show() {
        for (Post post : posts) {
            post.display();
            System.out.println();
        }
    }

    /**
     * Drives the program.
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        NewsFeed myNewsFeed = new NewsFeed();
        myNewsFeed.addPost(new Post("Chris Post"));
        myNewsFeed.addPost(new MessagePost("Chris MessagePost", "I like spaghetti too!"));
        myNewsFeed.addPost(new PhotoPost("Chris PhotoPost", "spaghetti", "Look at all the spaghetti!"));
        for (Post post : myNewsFeed.posts) {
            post.like();
        }
        for (Post post : myNewsFeed.posts) {
            post.addComment("Ravioli wars!");
        }
        myNewsFeed.show();
    }
}
