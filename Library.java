
package steven.communitylibrarysystem;
import java.util.ArrayList;
import java.time.LocalDate;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Member> members;
    private ArrayList<Loan> loans;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        loans = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    // LEND BOOK (important rule enforcement)
    public void lendBook(String isbn, String memberId) {

        Book foundBook = null;
        Member foundMember = null;

        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                foundBook = b;
                break;
            }
        }

        for (Member m : members) {
            if (m.getMemberId().equals(memberId)) {
                foundMember = m;
                break;
            }
        }

        if (foundBook == null || foundMember == null) {
            System.out.println("Book or Member not found.");
            return;
        }

        if (!foundBook.isAvailable()) {
            System.out.println("REJECTED: Book already on loan.");
            return;
        }

        Loan loan = new Loan(
                foundBook,
                foundMember,
                LocalDate.now(),
                LocalDate.now().plusDays(14)
        );

        loans.add(loan);
        foundMember.addLoan(loan);
        foundBook.setAvailable(false);

        System.out.println("Loan successful: " + foundBook.getTitle());
    }

    // RETURN BOOK
    public void returnBook(String isbn) {

        Loan targetLoan = null;

        for (Loan l : loans) {
            if (l.getBook().getIsbn().equals(isbn)) {
                targetLoan = l;
                break;
            }
        }

        if (targetLoan == null) {
            System.out.println("No active loan found.");
            return;
        }

        targetLoan.getBook().setAvailable(true);
        targetLoan.getMember().removeLoan(targetLoan);
        loans.remove(targetLoan);

        System.out.println("Book returned successfully.");
    }

    public void searchBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                System.out.println(b);
            }
        }
    }

    public void printState() {
        System.out.println("Books:");
        for (Book b : books) System.out.println(b);

        System.out.println("\nMembers:");
        for (Member m : members) System.out.println(m);

        System.out.println("\nLoans:");
        for (Loan l : loans) System.out.println(l);
    }
}
