// ITCS214      Lab Assignment #: Project  Date: dd/12/2018
//
// st_Name: Sayed Jalal Majed   st_id: 20174216
// st_Name: Achraf Boudabous    st_id: 20174424
// st_Name: Mahmoud Mohammed   st_id: 20175215                   section #: 10                     serial #: xx

import java.util.LinkedList;
import java.util.ListIterator;

public class LibrarySystem {

    private LinkedList<Book> booksList;
    private LinkedList<LibMember> membersList;
    private int booksListSize;
    private int membersListSize;

    /**
     * creates a new Library System
     */
    public LibrarySystem() {

        booksList = new LinkedList<Book>();
        membersList = new LinkedList<LibMember>();
        booksListSize = 0;
        membersListSize = 0;

    }

    /**
     * adds a new book
     * @param book
     * @return
     */
    public boolean addBook(Book book){

        boolean exists = false;

        for(Book b : booksList)
            if(book.equals(b))
                exists = true;

        if(exists)
            return false;
        else{
            booksList.add(book);
            booksListSize++;
            return true;
        }
    }

    /**
     * deletes a book by it's accession number
     * @param accNum
     * @return
     */
    public boolean deleteBook(long accNum){

        if(booksListSize == 0)
            return false;

        for(Book book : booksList) {
            if (book.getAccessionNum() == accNum) {
                returnBook(accNum);
                booksList.remove(book);
                booksListSize--;

                return true;
            }
        }

        return false;

    }

    /**
     * adds a new member
     * @param libMember
     * @return
     */
    public boolean addMember(LibMember libMember){

        boolean exists = false;

        for(LibMember l : membersList)
            if(libMember.equals(l))
                exists = true;

        if(exists)
            return false;
        else{
            membersList.add(libMember);
            membersListSize++;
            return true;
        }

    }

    /**
     *  deletes a member by it's CPR number
     * @param CPR
     * @return
     */
    public boolean deleteMember(long CPR){

        if(membersListSize == 0)
            return false;

        for(LibMember member : membersList) {
            if (member.getCprNum() == CPR) {
                for (Book b : booksList) {
                    if (b.getIssuedTo().getCprNum() == CPR) {
                        return false;
                    } else {
                        membersList.remove(member);
                        membersListSize--;
                        return true;
                    }
                }

            }
        }
        return false;
    }

    /**
     * returns if a book exists in the library or not
     * @param accNum
     * @return
     */
    public int searchBook(long accNum){

        if(booksListSize <= 0)
            return -1;

        ListIterator<Book> bookItr = booksList.listIterator(0);
        Book book;

        while (bookItr.hasNext()) {
            book = bookItr.next();
            if(book.getAccessionNum() == accNum)
                return booksList.indexOf(book);

        }

        return -1;
    }

    /**
     *  returns if a member exists in the library or not
     * @param CPR
     * @return
     */
    public int searchMember(long CPR){

        if(membersListSize <= 0)
            return -1;

        ListIterator<LibMember> memberItr = membersList.listIterator(0);
        LibMember libMember;

        while (memberItr.hasNext()) {
            libMember = memberItr.next();
            if (libMember.getCprNum() == CPR)
                return membersList.indexOf(libMember);

        }

        return -1;
    }

    /**
     * checks if there are no books

     * @return
     */
    public boolean isEmptyBooksList(){

        if(booksList == null || booksList.size() == 0)
            return true;
        else
            return false;

    }

    /**
     * checks if there are no members
     * @return
     */
    public boolean isEmptyMembersList(){

        if(membersList == null || membersList.size() == 0)
            return true;
        else
            return false;

    }

    /**
     * returns the number of books in the library
     * @return
     */
    public int sizeBooksList() {
        return booksListSize;
    }

    /**
     * returns the number of members in the library
     * @return
     */
    public int sizeMembersList() {
        return membersListSize;
    }

    /**
     * issues a book to a member
     * @param accNum
     * @param CPR
     * @return
     */
    public boolean issueBook(long accNum, long CPR) {

        if(searchBook(accNum) != -1 && searchMember(CPR) != -1 ) {
            Book book = booksList.get(searchBook(accNum));
            LibMember libMember = membersList.get(searchMember(CPR));

            if (book.getIssuedTo() == null) {
                if (libMember.getNumBooksIssued() < 10) {
                    book.setIssuedTo(libMember);
                    libMember.addToBooksIssued(book);
                    return true;
                }
            }
        }

        return false;

    }

    /**
     * removes a book from a member
     * @param accNum
     * @return
     */
    public boolean returnBook(long accNum) {

        if (searchBook(accNum) != -1) {
            Book book = booksList.get(searchBook(accNum));
            if (book.getIssuedTo() != null){
                LibMember libMember = book.getIssuedTo();
                libMember.removeFromBooksIssued(book);
                book.setIssuedTo(null);
                return true;
            }
        }
        return false;
    }

    /**
     * displays the books issued to a member
     * @param CPR
     */
    public void printBooksIssued(long CPR){

        if(searchMember(CPR) != -1){
            LibMember libMember = membersList.get(searchMember(CPR));

            for(Book book : libMember.getBooksIssued()){
                if(book != null)
                    System.out.println(book.toString());

            }
        }

    }

    /**
     * displays a book's information
     * @param accNum
     * @return
     */
    public boolean printBook(long accNum){

        if(searchBook(accNum) != -1) {
            Book book = booksList.get(searchBook(accNum));
            System.out.println(book.toString());
            return true;
        }else
            return false;

    }

    /**
     * displays a member's information
     * @param CPR
     * @return
     */
    public boolean printMember(long CPR){

        if(searchMember(CPR) != -1) {
            LibMember member = membersList.get(searchMember(CPR));
            System.out.println(member.toString());
            return true;
        }else
            return false;

    }

    /**
     * checks if a book is issued or not
     * @param accNum
     * @return
     */
    public boolean isBookIssued(long accNum){

        int index = searchBook(accNum);
        if(index == -1)
            return false;

        return (booksList.get(index).getIssuedTo() != null);

    }
}
