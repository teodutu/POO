import java.lang.Exception;

class Book {
    private String title, author, publisher;
    private int pageCount;

    Book() {}

    Book (String t, String a, String p, int pages) throws Exception {
         if (pages == 0) {
            throw new Exception("Nu e bune cartile fara pagini!");
         }

        title = t;
        author = a;
        publisher = p;
        pageCount = pages;
    }

    void setTitle(String t) {
        title = t;
    }

    void setAuthor(String a) {
        author = a;
    }

    void setPublisher(String p) {
        publisher = p;
    }

    void setPageCount(int pages) {
        pageCount = pages;
    }

    String getTitle() {
        return title;
    }

    String getAuthor() {
        return author;
    }

    String getPublisher() {
        return publisher;
    }

    void print() {
        System.out.println("BOOK_TITLE: " + title.toUpperCase());
        System.out.println("BOOK_AUTHOR:" + author);
        System.out.println("BOOK_PUBLISHER: " + publisher.toLowerCase());
    }

    int getPageCount() {
        return pageCount;
    }
}
