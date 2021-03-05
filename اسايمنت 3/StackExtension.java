// ITCS214
//  Lab Assignment #: 3
// Date: dd/12/2018
// Name: Ashraf Boudabous
// ID: 20174424
//section #: 10
// serial #: xx

import java.util.NoSuchElementException;
public class StackExtension extends ArrayStack<Integer>{

    ArrayStack<Integer> st;
    public StackExtension (){
        st = null;
    }
    public StackExtension (ArrayStack<Integer> st1){
        st = st1;
    }
    public int size(){
        if (st == null)
            throw new NoSuchElementException();
        ArrayStack<Integer> st2 = new ArrayStack<Integer>(st);
        int count = 0;
        while (!st2.isEmpty()){
            st2.pop();
            count++;
        }
        return count;
    }
    public int minimum(){
        if (st == null)
            throw new NoSuchElementException();
        ArrayStack<Integer> st2 = new ArrayStack<Integer>(st);
        int min = st2.pop();
        while (!st2.isEmpty()){
            if (st2.peek() < min)
                min = st2.pop();
            else
                st2.pop();
        }
        return min;
    }

    public int maximum(){

        if (st == null)
            throw new NoSuchElementException();

        ArrayStack<Integer> st2 = new ArrayStack<Integer>(st);
        int max = st2.pop();

        while (!st2.isEmpty()){

            if (st2.peek() > max)
                max = st2.pop();
            else
                st2.pop();

        }

        return max;
    }

    public boolean contains(int item){

        if (st == null)
            throw new NoSuchElementException();

        ArrayStack<Integer> st2 = new ArrayStack<Integer>(st);
        boolean found = false;

        while(!st2.isEmpty()){

            if (st2.peek() == item)
                found = true;

            st2.pop();
        }

        return found;
    }

    public boolean remove(int item){

        if (st == null)
            throw new NoSuchElementException();

        if (!contains(item))
            return false;

        ArrayStack<Integer> st2 = new ArrayStack<Integer>();

        while(!st.isEmpty()){

            st2.push(st.pop());

        }
        while (!st2.isEmpty()){

            if (st2.peek() == item){

                st2.pop();

            }else{

                st.push(st2.pop());

            }

        }

        return true;

    }

    public void sort (){

        if (st == null)
            throw new NoSuchElementException();

        ArrayStack<Integer> st2 = new ArrayStack<Integer>();

        while(!st.isEmpty()){

            int tmp = st.pop();

            // while temporary stack is not empty and
            // top of stack is greater than temp
            while(!st2.isEmpty() && st2.peek() > tmp)
            {
                // pop from temporary stack and
                // push it to the input stack
                st.push(st2.pop());
            }

            // push temp in temporary of stack
            st2.push(tmp);

        }

        st = st2;

    }

    public boolean isEqual(ArrayStack<Integer> st1){

        if (st == null || st1 == null)
            throw new NoSuchElementException();

        StackExtension st2 = new StackExtension(st);
        StackExtension st3 = new StackExtension(st1);

        int size1 = st2.size();
        int size2 = st3.size();

        if (size1 != size2)
            return false;

        while(!st2.isEmpty()){

            int temp1 = st2.pop();
            int temp2 = st3.pop();

            if (temp1 != temp2)
                return false;
        }

        return true;

    }

    public static void merge(ArrayStack<Integer> st1, ArrayStack<Integer> st2, ArrayStack<Integer> st3){

        if(st1.isEmpty() && st2.isEmpty())
            System.out.println("Both stacks are empty");

        else
        {
            while(!st1.isEmpty() && !st2.isEmpty()){

                st3.push(st1.pop());
                st3.push(st2.pop());

            }

            while(!st1.isEmpty())
                st3.push(st1.pop());

            while(!st2.isEmpty())
                st3.push(st2.pop());
        }

    }

    public void print(){
        ArrayStack<Integer> st1 = new ArrayStack<Integer>(st);

        while(!st1.isEmpty())
            System.out.println(st1.pop());

        System.out.println();

    }

}
