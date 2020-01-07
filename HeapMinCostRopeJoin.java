import java.util.*;

public class HeapMinCostRopeJoin {
    public static int solve(ArrayList<Integer> A) {
        
        int n = A.size();
        
        // create heap out of available lengths
        int h[] = new int[n];
        createHeap(A, h);
        
        int heapEndPtr = n-1;
        int cost = 0;
        while(heapEndPtr > 0)
        {
            int first = h[0];
            // System.out.print("first : " + first);
            swap(h, 0, n-1);
            h[n-1] = Integer.MAX_VALUE;
            heapEndPtr--;
            heapify(h);
            int second = h[0];
            // System.out.print("second : " + second);
            int newLength = first + second;
            cost = cost + newLength;
            h[0] = newLength;
            heapify(h);
        }
        
        return cost;
    }
    
    private static void swap(int h[], int p, int q)
    {
        int tmp = h[p];
        h[p] = h[q];
        h[q] = tmp;
    }
    
    private static void createHeap(ArrayList<Integer> A, int[] h)
    {
        int n = A.size();
        h[0] = A.get(0);
        for(int i=1; i<n; i++)
        {
            h[i] = A.get(i);
            int ptr = i;
            int parent = (ptr-1)/2;
            
            while(ptr >=0 && h[ptr] < h[parent])
            {
                swap(h, ptr, parent);
                ptr = parent;
                parent = (ptr-1)/2;
            }
            /*System.out.println();
            for(int l=0; l<n; l++)
                System.out.print(" " + h[l]);*/
        }
        // System.out.print("original heap --> ");
        
    }
    
    private static void heapify(int h[])
    {
        
        int n = h.length;
        /*for(int i=0; i<n; i++)
            System.out.print(" " + h[i]);*/
        // System.out.println();
        int curr = 0;
        int leftChild = 2*curr+1;
        int rightChild = 2*curr+2;
        while(curr < n && leftChild<n && rightChild<n && (h[curr]>h[leftChild] || h[curr]>h[rightChild]))
        {
            int smallestChildPtr = h[leftChild] < h[rightChild] ? (leftChild) : (rightChild);
            swap(h, curr, smallestChildPtr);
            curr = smallestChildPtr;
            leftChild = 2*curr+1;
            rightChild = 2*curr+2;
        }
        /*for(int i=0; i<n; i++)
            System.out.print(" " + h[i]);*/
    }
	
	public static void main(String args[])
	{
		//create arrayList
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(4);
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(5);
		System.out.println("cost = " + solve(arr));
	}		
}

