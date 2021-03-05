/*
	Ashraf Boudabous
	20174424
	Section.10
*/

public class SetApplication{
	public static void main(String[] args){
		Set s1 = new Set();

		System.out.println(s1.isEmpty() +" - "+ s1.getLength());
		s1.addElement(7);
		System.out.println(s1.isEmpty() +" - "+ s1.getLength());

		s1.addElement(6);
		s1.addElement(5);
		s1.addElement(4);
		s1.addElement(3);
		System.out.println("Is 5 member of s1 "+ s1.isMember(5));
		System.out.println("Is 16 member of s1 "+ s1.isMember(16));

		Set s2 = new Set(5);
		s2.addElement(5);
		s2.addElement(6);
		s2.addElement(7);
		s2.addElement(8);
		s2.addElement(9);

		System.out.println("Is s1 a sub set of s2 "+ s1.subSet(s2) );
		System.out.println("Is s1 equal to s2 "+ s1.isEqual(s2) );

		System.out.println("Union: ");
		s1.union(s2).print();
		System.out.println(" ");
		s1.intersection(s2).print();
		System.out.println(" ");
	}
}