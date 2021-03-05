// ITCS214
//  Lab Assignment #: 3
// Date: dd/12/2018
// Name: Ashraf Boudabous
// ID: 20174424
//section #: 10
// serial #: xx
import java.util.NoSuchElementException;

public class ArrayStack<E> implements StackInt<E>
{

    private E[ ] theData;
    private int topOfStack = -1;
    private static final int INITIAL_CAPACITY = 10;


    public ArrayStack()
    {
        theData = (E[]) new Object[INITIAL_CAPACITY];
    }

    public ArrayStack(int cap)
    {
        if (cap <= 0 )
            cap = INITIAL_CAPACITY;
        theData = (E[]) new Object[cap];
    }


    public  ArrayStack (ArrayStack<E> other)
    {
        theData = (E[]) new Object[other.topOfStack + 1];
        for (int i = 0; i < other.topOfStack + 1; i++)
            theData[i]= other.theData[i];
        topOfStack = other.topOfStack;

    }


    @Override
    public E push(E obj)
    {
        if (topOfStack == theData.length - 1) {
            reallocate();
        }
        topOfStack++;
        theData[topOfStack] = obj;
        return obj;
    }


    @Override
    public E pop()
    {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return theData[topOfStack--];
    }


    @Override
    public E peek()
    {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return theData[topOfStack];
    }


    @Override
    public boolean isEmpty()
    {
        return topOfStack == -1;
    }


    private void reallocate() {
        E[] temp = (E[]) new Object[2 * theData.length];
        System.arraycopy(theData, 0, temp, 0, theData.length);
        theData = temp;
    }

}
