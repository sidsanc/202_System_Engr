// ################PROBLEM STATEMENT###################
// Consider the following 2 classes - BookRental and MovieRental.

// a. Identify a code smell in the following Java code (2 points)

// b. Explain how you will refactor the code to get rid of the code smell (4 points)

// c. Write the re-factored code (14 points)

// public class BookRental {
//    private String bookTitle;
//    private String author;
//    private Date rentDate;
//    private Date dueDate;
//    private double rentalFee;
//    public boolean isOverdue() {
//        Date now = new Date();
//        return dueDate.before(now); 
//    }
// }
// public class MovieRental {
//    private String movieTitle;
//    private int classification;
//    private Date rentDate;
//    private Date dueDate;
//    private double rentalFee;
//    public boolean isOverdue() {
//        Date now = new Date();
//        return dueDate.before(now); 
//    } 
// }

// #############SOLUTION############

// a. The code smell is that there is duplicate code in the 2 classes. Both classes have the same method isOverdue().

// b. TO get rid of the code smell, we can create a new abstract class Rental.
// 1. Move the common properties :title, rentDate, dueDate, rentalFee from the BookRental and MovieRental classes to the Rental class.
// 2. removing the duplicate implementation of the isOverdue() method from the BookRental and MovieRental classes, since they have the same implementation in the Rental class.
// 3. Define the BookRental and MovieRental classes as subclasses of the Rental class.
// 4. Add the specific fields for the BookRental and MovieRental classes, author and classification respectively.
// 5. Apply null check for dueDate to check whether it is a null pointer exception as it returns a boolean value.

// c. the re-factored code is as follows:
// the solution follows the DRY principle and eliminate the duplication of code in the two classes

import Java.util.date;

public abstract class Rental {
    protected Date rentDate;
    protected Date dueDate;
    protected double rentalFee;
    protected String title;

    public boolean isOverdue(){
        if (dueDate != null) {
            Date now = new Date();
            return dueDate.before(now);
        } else {
            return false;
        }
    } 
}

public class BookRental extends Rental{
    private String author;
}

public class MovieRental extends Rental{
    private int classification;
}

public class main (){
        public static void main (String [] args) {
        BookRental book = new Bookrental();
        book.isOverdue();
        MovieRental movie = new Movierental();
        movie.isOverdue(); 
    }
}

