package BlogPost;

public class Main {
  public static void main(String[] args) {
    BlockPost blockPost1 = new BlockPost();
    blockPost1.authorName = "John Doe";
    blockPost1.title = "Lorem Ipsum";
    blockPost1.text = "Lorem ipsum dolor sit amet.";
    blockPost1.publicationDate = "2000.05.04.";

    BlockPost blockPost2 = new BlockPost();
    blockPost2.authorName = "Tim Urban";
    blockPost2.title = "Wait but why";
    blockPost2.text = "A popular long-form, stick-figure-illustrated blog about almost everything.";
    blockPost2.publicationDate = "2010.10.10.";

    BlockPost blockPost3 = new BlockPost();
    blockPost3.authorName = "William Turton";
    blockPost3.title = "One Engineer Is Trying to Get IBM to Reckon With Trump";
    blockPost3.text = "Daniel Hanley, a cybersecurity engineer at IBM, doesn’t want to be " +
        "the center of attention. When I asked to take his picture outside one of IBM’s " +
        "New York City offices, he told me that he wasn’t really into the whole organizer " +
        "profile thing.";
    blockPost3.publicationDate = "2017.03.28.";
  }
}
