// ITCS214      Lab Assignment #: Project  Date: dd/12/2018
//
// st_Name: Sayed Jalal Majed   st_id: 20174216
// st_Name: Achraf Boudabous    st_id: 20174424
// st_Name: Mahmoud Mohammed   st_id: 20175215                   section #: 10                     serial #: xx

import java.util.Scanner;

public class LibraryMain {

    public static Scanner key = new Scanner(System.in);
    public static LibrarySystem library = new LibrarySystem();

    public static void main(String [] args){

        welcomingMessage();

    }

    /**
     * displays a welcoming message
     */
    public static void welcomingMessage(){

        System.out.println("Welcome to the Library System! ");
        System.out.println("--------------------------------");
        optionsSetup();

    }

    /**
     * shows the Options available to choose from
     */
    public static void optionsSetup(){

        System.out.println();
        System.out.println("Choose your option: ");
        System.out.println("[1] to add a new library member.");
        System.out.println("[2] to add a new book.");
        System.out.println("[3] to Issue a book to a member.");
        System.out.println("[4] to return a book from a member.");
        System.out.println("[5] to remove a library member.");
        System.out.println("[6] to remove a book.");
        System.out.println("[7] to print all of a member's books information.");
        System.out.println("[8] to search a book.");
        System.out.println("[9] to search a member.");
        System.out.println("[10] to see the number of books and members in the library.");
        System.out.println("[11] to check if a book is issued.");
        System.out.println("[99] to to enter the Library test demo.");
        System.out.println("[0] to exit.");
        System.out.println();

        int num = validateInt();

        System.out.println("\n--------------------------------\n");

        switch(num){
            case 0:
                System.exit(0);
                break;

            case 1:
                addMemberSetup();
                break;

            case 2:
                addBookSetup();
                break;

            case 3:
                issueBookSetup();
                break;

            case 4:
                returnBookSetup();
                break;

            case 5:
                removeMemberSetUp();
                break;

            case 6:
                removeBookSetup();
                break;

            case 7:
                printAllBooksSetup();
                break;

            case 8:
                searchBookSetup();
                break;

            case 9:
                searchMemberSetup();
                break;

            case 10:
                statisticsSetup();
                break;

            case 11:
                checkIssuedSetup();
                break;

            case 99:
                runDemo();
                break;

            default:
                errorMessage("The number is out of bound. ");
                break;
        }
    }

    /**
     * takes a member's information and adds it to the library system
     */
    public static void addMemberSetup(){

        System.out.println("\n--------------------------------\n");

        System.out.println("Enter the member's information: ");
        System.out.println("First Name: "); key.next(); String f = key.nextLine();
        System.out.println("Last Name: "); String l = key.nextLine();
        System.out.println("Gender m/f: "); char g = key.next().charAt(0);
        while(!(g == 'm' || g == 'M' || g == 'F' || g == 'f' || g == ' ')) {
            System.out.println("Gender is not recognized.");
            g = key.next().charAt(0);
        }
        System.out.println("CPR: "); long c = validateLong();
        System.out.println("Mobile Number: "); String t = key.next();

        LibMember member = new LibMember(f,l,g,c,t);
        if (library.addMember(member))
            System.out.println("The member has been added successfully.");
        else
            errorMessage();

        System.out.println("\n--------------------------------\n");

        optionsSetup();

    }

    /**
     * takes a book's information and adds it to the library
     */
    public static void addBookSetup(){

        System.out.println("\n--------------------------------\n");

        System.out.println("Enter the books's information: ");
        System.out.println("Title: "); key.next(); String t = key.nextLine();
        System.out.println("First Author: "); String a1 = key.nextLine();
        System.out.println("Second Author: "); String a2 = key.nextLine();
        System.out.println("Publisher: "); String p = key.nextLine();
        System.out.println("Year of Publication: "); int y = validateInt();
        while(y < 0 || y > 3000) {
            System.out.println("year is out of bounds.");
            y = validateInt();
        }
        System.out.println("ISBN: "); String i = key.next();

        Book book = new Book(t,a1,a2,p,y,i);

        if (library.addBook(book))
            System.out.println("The book has been added successfully.");
        else
            errorMessage();

        System.out.println("\n--------------------------------\n");

        optionsSetup();

    }

    /**
     * takes a book's accession number and a member's CPR and issues it to the member
     */
    public static void issueBookSetup(){

        System.out.println("\n--------------------------------\n");

        System.out.println("Enter the book's accession number: ");
        long a = validateLong();
        System.out.println("Enter the member's CPR: ");
        long c = validateLong();

        if(library.issueBook(a,c))
            System.out.println("The book has been issued successfully. ");
        else
            errorMessage("Book or Member is not found.");

        System.out.println("\n--------------------------------\n");

        optionsSetup();
    }

    /**
     * removes an issued book from a members books by the book's accession number
     */
    public static void returnBookSetup(){

        System.out.println("\n--------------------------------\n");

        System.out.println("Enter the book's accession number: ");
        long a = validateLong();

        if(library.returnBook(a))
            System.out.println("The book has been returned successfully. ");
        else
            errorMessage("Book is not found.");

        System.out.println("\n--------------------------------\n");

        optionsSetup();
    }

    /**
     * removes a member by its CPR number
     */
    public static void removeMemberSetUp(){

        System.out.println("\n--------------------------------\n");

        System.out.println("Enter the member's CPR: ");
        long c = validateLong();

        if(library.searchMember(c) != -1){
            library.deleteMember(c);
            System.out.println("The member has been removed successfully. ");
        }else
            errorMessage("Member is not found.");

        System.out.println("\n--------------------------------\n");

        optionsSetup();
    }

    /**
     * removes a book by its accession number
     */
    public static void removeBookSetup(){

        System.out.println("\n--------------------------------\n");

        System.out.println("Enter the book's accession number: ");
        long a = validateLong();

        if(library.searchBook(a) != -1){
            library.deleteBook(a);
            System.out.println("The book has been removed successfully. ");
        }else
            errorMessage("Book is not found.");

        System.out.println("\n--------------------------------\n");

`   `        optionsSetup();
    }

    /**
     * prints all books issued to a member
     */
    public static void printAllBooksSetup(){

        System.out.println("\n--------------------------------\n");

        System.out.println("Enter the member's CPR: ");
        long c = validateLong();

        library.printBooksIssued(c);

        System.out.println("\n--------------------------------\n");

        optionsSetup();

    }

    /**
     * takes the accession number and displayed the associated book
     */
    public static void searchBookSetup(){

        System.out.println("\n--------------------------------\n");

        System.out.println("Enter the book's accession number: ");
        long a = validateLong();

        if(library.printBook(a))
            System.out.println("\nHere's your Book! \n");
        else
            errorMessage("Book is not found.");

        System.out.println("\n--------------------------------\n");

        optionsSetup();

    }

    /**
     * takes the cpr number and displayed the associated member
     */
    public static void searchMemberSetup(){

        System.out.println("\n--------------------------------\n");

        System.out.println("Enter the member's CPR: ");
        long c = validateLong();

        if(library.printMember(c))
            System.out.println("\nHere's your Member! \n");
        else
            errorMessage("Member is not found.");

        System.out.println("\n--------------------------------\n");

        optionsSetup();

    }

    /**
     * Displays the number of members and books in the Library
     */
    public static void statisticsSetup(){

        System.out.println("\n--------------------------------\n");

        System.out.print("Number of Books in the library: ");
        System.out.println(library.sizeBooksList());
        System.out.print("Number of Members in the library: ");
        System.out.println(library.sizeMembersList());

        System.out.println("\n--------------------------------\n");

        optionsSetup();
    }

    /**
     * it takes an accession number of a book and checks if its issued or not
     */
    public static void checkIssuedSetup(){

        System.out.println("\n--------------------------------\n");

        System.out.println("Enter the book's accession number: ");
        long a = validateLong();

        if(library.isBookIssued(a))
            System.out.println("The Book is issued. ");
        else
            System.out.println("The book is not issued/found. ");

        System.out.println("\n--------------------------------\n");

        optionsSetup();

    }

    /**
     * displays an Error message
     */
    public static void errorMessage(){

        System.out.println("An Error has occurred.");
        System.out.println("\n--------------------------------\n");
        optionsSetup();

    }

    /**
     * displays an Error message + the given String
     * @param m
     */
    public static void errorMessage(String m){

        System.out.println("An Error has occurred. " + m);
        System.out.println("\n--------------------------------\n");
        optionsSetup();

    }

    /**
     * runs a demo of the whole system
     */
    public static void runDemo(){

        System.out.println("\n--------------------------------");
        System.out.println("********************************\n");


        LibMember member = new LibMember("Jalal","Majed",'m',1,"20174216");
        library.addMember(member);
        LibMember member2 = new LibMember("Achraf","Saleem",'m',2,"20174424");
        library.addMember(member2);
        LibMember member3 = new LibMember("Mahmood","Mohammed",'m',3,"20175215");
        library.addMember(member3);

        Book book = new Book("Harry Potter"," J. K. Rowling"," ","Bloomsbury",1997,"978-0-54-501022-1");
        library.addBook(book);
        Book book2 = new Book("Java, Problem Solving & Programming","Savitch, Walter J.","Kenrick Mock ","Pearson Education",2001,"978-0-13-376626-4");
        library.addBook(book2);
        Book book3 = new Book("Human Rights - Legal Clinic","Dr.Wafa Janahi"," ","University of Bahrain",2017,"973-0-18-852323-9");
        library.addBook(book3);

        library.issueBook(1001,1);
        library.issueBook(1002,2);
        library.issueBook(1003,3);

        library.printMember(1);
        library.printMember(2);
        library.printMember(3);

        System.out.println("\n********************************");
        System.out.println("--------------------------------\n");

        optionsSetup();
    }

    /**
     * makes sure the entered value is an long and returns it
     * @return
     */
    public static long validateLong() {

        long number;
        do {

            while (!key.hasNextLong()) {
                String input = key.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
            }
            number = key.nextLong();

        } while (number < 0);

        return number;
    }

    /**
     * makes sure the entered value is an int and returns it
     * @return
     */
    public static int validateInt() {

        int number;
        do {

            while (!key.hasNextInt()) {
                String input = key.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
            }
            number = key.nextInt();
        } while (number < 0);

        return number;
    }
}
