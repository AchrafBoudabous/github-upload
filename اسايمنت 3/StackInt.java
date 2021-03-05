// ITCS214
//  Lab Assignment #: 3
// Date: dd/12/2018
// Name: Ashraf Boudabous
// ID: 20174424
//section #: 10
// serial #: xx
import java.util.NoSuchElementException;
public interface StackInt<E>
{
    E push(E obj);
    E peek();
    E pop();
    boolean isEmpty();
}
