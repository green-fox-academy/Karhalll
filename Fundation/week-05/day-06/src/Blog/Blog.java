package Blog;

import BlogPost.BlogPost;
import java.util.ArrayList;
import java.util.List;

public class Blog {
  private List<BlogPost> blogPosts = new ArrayList<BlogPost>();

  public void add(BlogPost blogPost) {
    blogPosts.add(blogPost);
  }

  public void delete(int index) {
    blogPosts.remove(index);
  }

  public void update(int index, BlogPost blogPost) {
    blogPosts.set(index, blogPost);
  }
}
