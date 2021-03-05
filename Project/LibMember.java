// ITCS214      Lab Assignment #: Project  Date: dd/12/2018
//
// st_Name: Sayed Jalal Majed   st_id: 20174216
// st_Name: Achraf Boudabous    st_id: 20174424
// st_Name: Mahmoud Mohammed   st_id: 20175215                   section #: 10                     serial #: xx

import java.util.Arrays;
import java.util.Objects;

public class LibMember {

    private String firstName;
    private String lastName;
    private char gender;
    private long cprNum;
    private String teleNum;
    private Book booksIssued[];
    private int numBooksIssued;

    /**
     * creates a default new Member
     */
    public LibMember() {

        firstName = "";
        lastName = "";
        gender = ' ';
        cprNum = 0;
        teleNum = "";
        booksIssued = new Book[10];
        numBooksIssued = 0;

    }

    /**
     * creates a new book with given information
     * @param f
     * @param l
     * @param g
     * @param c
     * @param t
     */
    public LibMember(String f, String l, char g, long c, String t) {

        firstName = f;
        lastName = l;
        gender = g;
        cprNum = c;
        teleNum = t;
        booksIssued = new Book[10];
        numBooksIssued = 0;

    }

    /**
     * returns the member's first name
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *  sets the member's first name
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * returns the member's last name
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * sets the member's last name
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * returns the member's gender
     * @return
     */
    public char getGender() {
        return gender;
    }

    /**
     * sets the member's gender
     * @param gender
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

    /**
     * returns the member's CPR
     * @return
     */
    public long getCprNum() {
        return cprNum;
    }

    /**
     * sets the member's CPR
     * @param cprNum
     */
    public void setCprNum(long cprNum) {
        this.cprNum = cprNum;
    }

    /**
     * returns the phone number
     * @return
     */
    public String getTeleNum() {
        return teleNum;
    }

    /**
     * sets the phone number
     * @param teleNum
     */
    public void setTeleNum(String teleNum) {
        this.teleNum = teleNum;
    }

    /**
     * returns the array of books issued
     * @return
     */
    public Book[] getBooksIssued() {
        return booksIssued;
    }

    /**
     * sets an array of books issued
     * @param booksIssued
     */
    public void setBooksIssued(Book[] booksIssued) {
        this.booksIssued = booksIssued;
    }

    /**
     * returns the number of books issued
     * @return
     */
    public int getNumBooksIssued() {
        return numBooksIssued;
    }

    /**
     * sets the number of books issued
     * @param numBooksIssued
     */
    public void setNumBooksIssued(int numBooksIssued) {
        this.numBooksIssued = numBooksIssued;
    }

    /**
     * adds a book from the books issued
     * @param newBook
     * @return
     */
    public boolean addToBooksIssued(Book newBook){

        if(numBooksIssued < 10) {
            booksIssued[numBooksIssued] = newBook;
            numBooksIssued++;
            return true;
        }else{
            return false;
        }

    }

    /**
     * removes a book from the books issued
     * @param newBook
     * @return
     */
    public boolean removeFromBooksIssued(Book newBook){

        if(numBooksIssued > 0) {
            for(int i = 0; i<booksIssued.length; i++) {
                Book book = booksIssued[i];
                if (book.equals(newBook)){
                    for(int j = i ; j<numBooksIssued ; j++) {
                        booksIssued[j] = booksIssued[j+1];
                    }
                    booksIssued[--numBooksIssued] = null;

                    return true;
                }
            }
        }

        return false;
    }

    /**
     * check if a member is equal to the given one
     * @param libMember
     * @return
     */
    public boolean equals(LibMember libMember) {

        if (libMember == null) return false;

        if(     gender == libMember.gender &&
                cprNum == libMember.cprNum &&
                Objects.equals(firstName, libMember.firstName) &&
                Objects.equals(lastName, libMember.lastName) &&
                Objects.equals(teleNum, libMember.teleNum))
            return true;
        else
            return false;
    }

    /**
     * returns the member's information in a String
     * @return
     */
    public String toString() {
        return "\nLibMember {" +
                "\n firstName: " + firstName +
                "\n lastName: " + lastName +
                "\n gender: " + gender +
                "\n cprNum: " + cprNum +
                "\n teleNum: " + teleNum +
                "\n booksIssued: " + Arrays.toString(booksIssued) +
                "\n numBooksIssued: " + numBooksIssued +
                " }\n";
    }
}
