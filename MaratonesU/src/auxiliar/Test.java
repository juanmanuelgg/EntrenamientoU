package auxiliar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test
{
	public static void main(String[] args) 
	{
		int[]array={0,1,2,3,5,6,7,8,9};
		List<Integer> list=new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) list.add(array[i]);
		System.out.println(list);
		int objeto=4;
		int pos = Collections.binarySearch(list, objeto);
		if (pos < 0) list.add(-pos-1,objeto);

		System.out.println(list);
	}

}