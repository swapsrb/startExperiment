import java.util.*;
public class Kthsmallest {

	public static void main(String args[])
	{
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(8);
		arr.add(7);
		arr.add(12);
		arr.add(3);
		arr.add(5);
		arr.add(9);
		arr.add(24);
		arr.add(1);
		int k = 3;
		System.out.println("Kth smallest element = " + getkthsmallest(arr, k));
    }
    public static int getkthsmallest(final List<Integer> A, int B) {
        
        int[] h = new int[B];
        createMaxHeap(A.subList(0, B), h);
        /*
        for(int l=0; l<B; l++)
                System.out.print(" " + h[l]);*/
        
        int n = A.size();
        
        for(int i=B; i<n; i++)
        {
            int e = A.get(i);
            if(e < h[0])
            {
                h[0] = e;
                heapify(h);
            }
        }
        
        return h[0];
        
    }
    
    private static void swap(int h[], int p, int q)
    {
        int tmp = h[p];
        h[p] = h[q];
        h[q] = tmp;
    }
    
    private static void createMaxHeap(List<Integer> A, int[] h)
    {
        int n = A.size();
        h[0] = A.get(0);
        for(int i=1; i<n; i++)
        {
            h[i] = A.get(i);
            int ptr = i;
            int parent = (ptr-1)/2;
            
            while(ptr >=0 && h[ptr] > h[parent])
            {
                swap(h, ptr, parent);
                ptr = parent;
                parent = (ptr-1)/2;
            }
        }
        
    }
    
    private static void heapify(int h[])
    {
        
        int n = h.length;
        int curr = 0;
        int leftChild = 2*curr+1;
        int rightChild = 2*curr+2;
        // System.out.println(curr + " --> " + leftChild + " ---->" + rightChild);
        while(curr < n && (leftChild<n && h[curr]<h[leftChild]) || (rightChild<n &&h[curr]<h[rightChild]))
        {
            int greatestChildPtr;
            if(rightChild >= n)
            {
                if(leftChild <n && h[curr]<h[leftChild])
                {
                    greatestChildPtr = leftChild;
                    swap(h, curr, greatestChildPtr);
                }
                break;
            }
            else if(h[curr]<h[leftChild] || h[curr]<h[rightChild])
            {
                greatestChildPtr = h[leftChild] > h[rightChild] ? (leftChild) : (rightChild);
                swap(h, curr, greatestChildPtr);
                curr = greatestChildPtr;
                leftChild = 2*curr+1;
                rightChild = 2*curr+2;
            }
        }
        /*for(int i=0; i<n; i++)
            System.out.print(" " + h[i]);*/
    }
}

