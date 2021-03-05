/*
	Ashraf Boudabous
	20174424
	Section.10
*/

import java.util.ArrayList;

public class Set{
	private ArrayList<Integer> list;
	private int length;

	public Set(){
		list 	= new ArrayList<Integer>(10);
		length 	= 0;
	}

	public Set(int cap){
		list 	= new ArrayList<Integer>(cap);
		length 	= 0;
	}

	public Set(int[] arr){
		list 	= new ArrayList<Integer>();

		for (int x: arr){
			list.add(x);
		}

		length 	= arr.length;
	}

	public int getLength(){ return length; }

	public boolean isEmpty(){ return (length == 0); }

	public void addElement( int element ){
		list.add(element);
		length++;
	}

	public boolean isMember( int element ){
		for (int x: list){
			if (x == element)
				return true;
		}
		return false;
	}

	public boolean subSet(Set aSet){
		for (int x: aSet.list){
			if ( !isMember(x) )
				return false;
		}
		return true;
	}

	public boolean isEqual(Set aSet){
		if ( this.length != aSet.length ){
			return false;
		}
		for (int x: aSet.list){
			if ( !isMember(x) )
				return false;
		}
		return true;
	}

	public Set union(Set aSet){
		Set achraf = new Set();

		for (int x: list)
			achraf.addElement(x);

		for (int x: aSet.list){
			if ( !achraf.isMember(x) )
				achraf.addElement(x);
		}
		return achraf;
	}

	public Set intersection(Set aSet){
		Set achraf = new Set();
		for (int x: aSet.list){
			if ( isMember(x) )
				achraf.addElement(x);
		}
		return achraf;
	}

	public void print(){
		for (int x: list)
			System.out.print(x +", ");
	}
}