import java.util.Scanner;

public class BookstoreTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book book = new Book();

        book.setTitle(sc.nextLine());
        book.setAuthor(sc.nextLine());
        book.setPublisher(sc.nextLine());
        book.setPageCount(sc.nextInt());
        sc.next();

        try {
            Book book2 = new Book(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextInt());

            System.out.println(BookstoreCheck.checkIfDouble(book, book2));
            BookstoreCheck.getLongest(book, book2).print();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
