// ITCS214      Lab Assignment #: Project  Date: dd/12/2018
//
// st_Name: Sayed Jalal Majed   st_id: 20174216
// st_Name: Achraf Boudabous    st_id: 20174424
// st_Name: Mahmoud Mohammed   st_id: 20175215                   section #: 10                     serial #: xx

import java.util.Objects;

public class Book {

    private String title;
    private String author1;
    private String author2;
    private String publisher;
    private int yearPublication;
    private String isbn;
    private long accessionNum;
    private LibMember issuedTo;
    private static long accNum = 1001;

    /**
     * creates a new default book
     *
     */
    public Book() {

        title = "";
        author1 = "";
        author2 = "";
        publisher = "";
        yearPublication = 0;
        isbn = "";
        accessionNum = accNum++;
        issuedTo = null;

    }

    /**
     * creates a new book with given information
     * @param t
     * @param a1
     * @param a2
     * @param p
     * @param y
     * @param i
     */
    public Book(String t, String a1, String a2, String p, int y, String i) {

        title = t;
        author1 = a1;
        author2 = a2;
        publisher = p;
        yearPublication = y;
        isbn = i;
        accessionNum = accNum++;
        issuedTo = null;

    }

    /**
     * returns the title
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * sets the given title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * returns the author 1
     * @return
     */
    public String getAuthor1() {
        return author1;
    }

    /**
     * sets the given author 1
     * @param author1
     */
    public void setAuthor1(String author1) {
        this.author1 = author1;
    }

    /**
     * returns the author 2
     * @return
     */
    public String getAuthor2() {
        return author2;
    }

    /**
     * sets the given author 2
     * @param author2
     */
    public void setAuthor2(String author2) {
        this.author2 = author2;
    }
    /**#
     * returns the publisher
     * @return
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * sets the given publisher
     * @param publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * returns the year of Publication
     * @return
     */
    public int getYearPublication() {
        return yearPublication;
    }

    /**
     *  sets the given year of publication
     *
     * @param yearPublication
     */
    public void setYearPublication(int yearPublication) {
        this.yearPublication = yearPublication;
    }

    /**
     * returns the ISBN
     * @return
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * sets the given ISBN
     * @param isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * gets the accession number
     * @return
     */
    public long getAccessionNum() {
        return accessionNum;
    }

    /**
     * sets the given accession number
     * @param accessionNum
     */
    public void setAccessionNum(long accessionNum) {
        this.accessionNum = accessionNum;
    }

    /**
     *returns the issued member
     * @return
     */
    public LibMember getIssuedTo() {
        return issuedTo;
    }

    /**
     * issues the book to the given member
     * @param issuedTo
     */
    public void setIssuedTo(LibMember issuedTo) {
        this.issuedTo = issuedTo;
    }

    /**
     * checks to see if the books the equal
     * @param b
     * @return
     */
    public boolean equals(Book b) {

        if (b == null) return false;

        if (    yearPublication == b.yearPublication &&
                Objects.equals(title, b.title) &&
                Objects.equals(author1, b.author1) &&
                Objects.equals(author2, b.author2) &&
                Objects.equals(publisher, b.publisher) &&
                Objects.equals(isbn, b.isbn))
            return true;
        else
            return false;
    }

    /**
     * returns the books info in a string
     * @return
     */
    public String toString() {
        return "\nBook {" +
                "\n title: " + title +
                "\n author1: " + author1 +
                "\n author2: " + author2 +
                "\n publisher: " + publisher +
                "\n yearPublication: " + yearPublication +
                "\n isbn: " + isbn +
                "\n accessionNum: " + accessionNum +
                " }\n";
    }
}