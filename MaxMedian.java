
public class MaxMedian
{
	public static void main(String[] args) {

		/********** Given Question : An array and a value k which denotes no of operations ********/

		int a[] = new int [] {1, 3, 5, 8, 10, 12, 15, 20, 31};
		int k = 77;

		///// "An operation is increment the value of any array element A[i] by 1 //////////////////
		/////Find max value of median that can be achieved by k operations /////////////////////////
		/******************************************************************************************/

		int n = a.length;
		int m = n/2;
		int med = a[m];
		int op[] = new int[m+1];
		op[0] = 0;
		for(int i=1; i<op.length; i++)
		{
		    op[i] = op[i-1] + i*(a[m+i] - a[m+i-1]);
		    // System.out.println(op[i]);   
		}
		int limit = k >= op[op.length-1] ? (op.length-1) : 0;
		for(int i=0; i<op.length; i++)
		{
		    if(k < op[i])
		    {
		        limit = i-1;
		        break;
		    }
		}
		
		int minValue = a[m+limit];
		k = k-op[limit];
		int maxValue = minValue + k/(limit+1);
		
		System.out.println("maxValue:" + maxValue);
		
	}
}
