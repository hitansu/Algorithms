package array;

public class FindMedianSortedArrSameSize {

	public static void main(String[] args) {
		
		int[] a= {1, 2, 3,6};
		int[] b= {4, 6, 8,10};
		int median= findMedian(a, b, a.length);
		System.out.println(median);
		median= findMedianLogN(a, 0, a.length-1,b, 0, a.length-1);
		System.out.println(median);
		System.out.println(media(a, 0, a.length-1,b, 0, a.length-1));
		
	//	System.out.println(func(new int[]{1,2,6,7}, new int[]{3,5,9,10}, 4, 4));

	}
	
	static int findMedian(int[] a, int[] b, int n) {
		int m1= -1;
		int m2= -1;
		int i= 0;
		int j= 0;
		
		for(int index= 0;index<=n;index++) {
			if(i== n) {
				m1= m2;
				m2= b[0];
				break;
			} else if(j== n) {
				m1= m2;
				m2= a[0];
				break;
			} 
			
			if(a[i]<b[j]) {
				m1= m2;
				m2= a[i];
				i++;
			} else {
				m1= m2;
				m2= b[j];
				j++;
			}
		}
		
		return (m1+m2)/2;
	}


	static double func(int a[], int b[], int n,int m)
	{
	    if(n<m) return func(b,a,m,n);
	    if(m==0)
	    return (a[(n-1)/2]+a[(n/2)])/2;
	    int l = 0;
	    int h = 2*m;
	    
	    while(l<=h)
	    {
	        int m2 = (l+h)/2;
	        int m1 = n+m-m2;
	        
	        double l1 = (m1==0) ? Integer.MIN_VALUE : a[(m1-1)/2];
	        double r1 = (m1==2*n) ? Integer.MAX_VALUE : a[(m1)/2];
	        double l2 = (m2==0) ? Integer.MIN_VALUE : b[(m2-1)/2];
	        double r2 = (m2==2*m)? Integer.MAX_VALUE :  b[(m2)/2];
	        
	        if(l1 > r2)
	            l=m2+1;
	        else if(l2 > r1)
	            h=m2-1;
	        else
	        return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2;
	    }
	    
	    return -1;
	    

	}
	
	 public static int media(int[] arr1, int l1, int h1, int[] arr2, int l2, int h2)
     {
         int mid1 = (h1 + l1 ) / 2;
         int mid2 = (h2 + l2 ) / 2;
 
         if (h1 - l1 == 1)
             return (Math.max(arr1[l1] , arr2[l2]) + Math.min(arr1[h1] , arr2[h2]))/2;
         else if (arr1[mid1] > arr2[mid2])
             return media(arr1, l1, mid1 , arr2, mid2 , h2);    
         else
             return media(arr1, mid1 , h1, arr2, l2 , mid2 );    
     }  
	
	static int findMedianLogN(int[] a, int alow, int ahigh,int[] b, int blow,int bhigh) {
		if(ahigh-alow!= bhigh-blow) return -1;
		int n= ahigh-alow+1;
		if(n== 0)
			return -1;
		if(n== 1)
			return (a[alow]+b[blow])/2;
		if(n== 2)
			return (Math.max(a[alow], b[blow])+Math.min(a[ahigh], b[bhigh]))/2;
		
		int m1= findMedian(a,alow,ahigh);
		int m2= findMedian(b,blow,bhigh);
		
		int amid= alow+((ahigh-alow)/2);
		int bmid= blow+((bhigh-blow)/2);
		if(m1== m2) {
			return m1;
		} else if(m1>m2) {
			if(n%2== 0)
				return findMedianLogN(a, alow, amid, b, bmid+1,bhigh);
			return findMedianLogN(a, alow, amid-1, b, bmid+1,bhigh);
		} else  {
			if(n%2== 0)
				return findMedianLogN(a, amid+1, ahigh, b,blow, bmid);
			return findMedianLogN(a, amid+1, ahigh, b,blow, bmid-1);
		
		}
	}

	private static int findMedian(int[] arr, int l, int h) {
		int mid= (l+h)/2;
		if((h-l+1)%2== 0)
			return (arr[mid]+arr[mid+1])/2;
		return arr[mid];
	}

}
