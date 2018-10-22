abstract class BookstoreCheck {
    static boolean checkIfDouble(Book b1, Book b2) {
        return (b1.getAuthor().equals(b2.getAuthor()) &&
                b1.getTitle().equals(b2.getTitle()) &&
                b1.getPublisher().equals(b2.getPublisher()) &&
                b1.getPageCount() == b2.getPageCount());
    }

    static Book getLongest(Book b1, Book b2) {
        return (b1.getPageCount() < b2.getPageCount() ? b2 : b1);
    }
}
