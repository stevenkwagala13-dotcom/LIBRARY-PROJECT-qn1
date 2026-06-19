
package cholatem.communitylibrarysystem;

import java.time.LocalDate;

public class Loan {
    private Book book;
    private Member member;
    private LocalDate borrowDate;
    private LocalDate dueDate;

    public Loan(Book book, Member member, LocalDate borrowDate, LocalDate dueDate) {
        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    public Book getBook() { return book; }
    public Member getMember() { return member; }

    @Override
    public String toString() {
        return "Loan -> " + book.getTitle() +
               " to " + member.getName() +
               " (Due: " + dueDate + ")";
    }
}