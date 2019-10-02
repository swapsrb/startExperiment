import java.util.*;

public class MergeSort
{
	public static void main(String[] args)
	{
		List<Integer> list = new ArrayList<>();
		list = Arrays.asList(11, 43, 7, 2, 3, 5, 4, 1, 8, 6, 0, 13, 12, 20);
		//list = Arrays.asList(2, 1);
		System.out.println(list);
		performMergeSort(list, 0, list.size()-1);
		System.out.println(list);
	}

	private static void performMergeSort(List<Integer> list, int start, int end)
	{
		/*if(start >= end)
		{
			List<Integer> singleElement = new ArrayList<Integer>();
			singleElement.add(list.get(start));
			return singleElement;
		}*/
		if(start < end)
		{
			int mid = (start+end)/2;
			performMergeSort(list, start, mid);
			performMergeSort(list, mid+1, end);
			mergeLists(list, start, mid, end);
		}
	}
	
	private static void mergeLists(List<Integer> inputList,int start, int mid, int end)
	{
		System.out.println("start: " + start + " mid : " + mid + " end : " + end);
		List<Integer> sortedList = new ArrayList<Integer>();
		int i, j, k;
		for(i = start, j = mid+1, k=0; i <= mid && j <= end ; k++)
		{
			System.out.println("i=" + i + ", j=" + j);
			if(inputList.get(i) <= inputList.get(j))
			{
				System.out.println("Element added : "+inputList.get(i));
				sortedList.add(inputList.get(i));
				i++;
			}
			else 
			{
				System.out.println("Element added : "+inputList.get(j));
				sortedList.add(inputList.get(j));
				j++;
			}
		}
		
		for(int r=i; r<=mid; r++)
		{
			sortedList.add(inputList.get(r));
			System.out.println("Element added : "+inputList.get(r));
			k++;
		}	
		
		for(int r=j; r<=end; r++)
		{
			sortedList.add(inputList.get(r));
			System.out.println("Element added : "+inputList.get(r));
			k++;
		}
		for(int refresh = start, s=0; refresh<=end; refresh++, s++)
		{
			inputList.set(refresh, sortedList.get(s));
		}
				
		System.out.println(sortedList);
		inputList = sortedList;
	}
}
