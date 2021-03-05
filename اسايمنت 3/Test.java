// ITCS214
//  Lab Assignment #: 3
// Date: dd/12/2018
// Name: Ashraf Boudabous
// ID: 20174424
//section #: 10
// serial #: xx

public class Test {

    public static void main(String [] args) {

        ArrayStack<Integer> st = new ArrayStack<Integer>();
        st.push(10);
        st.push(152);
        st.push(70);
        st.push(17);
        st.push(200);
        st.push(786);
        st.push(59);
        st.push(466);
        
        StackExtension stack = new StackExtension(st);

        System.out.println("Print: ");

        stack.print();

        System.out.println("Sort: ");

        stack.sort();
        stack.print();

        System.out.println("Remove 17: ");
        stack.remove(17);
        stack.print();


        System.out.println("min: ");

        System.out.println(stack.minimum() + "\n");

        System.out.println("max: ");

        System.out.println(stack.maximum() + "\n");


        ArrayStack<Integer> st1 = new ArrayStack<Integer>();
        ArrayStack<Integer> st2 = new ArrayStack<Integer>();
        ArrayStack<Integer> st3 = new ArrayStack<Integer>();

        st1.push(87);
        st1.push(32);
        st1.push(76);
        st1.push(54);
        st1.push(35);
        st1.push(67);
        st1.push(90);
        st1.push(97);

        st2.push(78);
        st2.push(54);
        st2.push(26);
        st2.push(10);
        st2.push(65);
        st2.push(98);
        st2.push(75);
        st2.push(21);


        System.out.println("Merge between Stack 1 and 2 in Stack 3: ");
        StackExtension.merge(st1, st2, st3);

        StackExtension stack3 = new StackExtension(st3);
        stack3.print();




    }

}
