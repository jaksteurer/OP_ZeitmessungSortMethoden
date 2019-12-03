import java.util.Random;
import java.util.Scanner;

public class ZeitmessungSortMethoden {
	static int zaehler = 0;
	static int laenge;
	static Random rnd = new Random();
	static long s_timeStart;
	static long s_timeEnd;
	static long i_timeStart;
	static long i_timeEnd;
	static long bubble_timeStart;
	static long bubble_timeEnd;
	static long bogo_timeStart;
	static long bogo_timeEnd;
	
	public static void main(String[] args) {
		int[] array = arrayAnlegen();
		System.out.println("unsortiertes Array: "+ array);
		int[] sSort = selectionsort(array);
		System.out.println("Selectionsort: "+ sSort);
		int[] iSort = insertionsort(array);
		System.out.println("Insterionsort: "+ iSort);
		int[] bSort = bubblesort(array);
		System.out.println("Bubblesort: "+ bSort);
		int[] bogoSort = bogosort(array);
		System.out.println("Bogosort: "+ bogoSort);

	}
	public static int[] arrayAnlegen() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Geben Sie die länge des Array sein: ");
		laenge = sc.nextInt();
		sc.close();
		int[] array = new int[laenge];
		for(int i =0;i<array.length;i++) {
			array[i]= rnd.nextInt(array.length);
		}
		return array;
	}
	public static int[] selectionsort(int[] sort)
	{	sort = new int[laenge]; 
		s_timeStart = System.currentTimeMillis();
		for(int i=0;(i<sort.length-1);i++)
		{
			for(int j=i+1;j<sort.length;j++)
			{
				if(sort[i]>sort[j])
				{
					int temp = sort[i];
					sort[i] = sort[j];
					sort[j] = temp;					
				}
			}
		}
		s_timeEnd = System.currentTimeMillis();
		System.out.println("Verlauf der Schleife: "+(s_timeEnd - s_timeStart)+" Millisek.");
		return sort;
	}
	public static int[] insertionsort(int[] sort) 	
	{//2 Zahlen nebeneinander; schauen welche kleiner ist und diese wird dann nach rechts verschoben
	 //bereits geordnete zahlen werden nicht mehr angesehen
		i_timeStart = System.currentTimeMillis();
		sort = new int[laenge]; 
		int temp;
		for (int i=0;(i<sort.length-1);i++) {
			temp = sort[i];
			int j = i;
			while(j>0 && sort[j-1]>temp)
			{
				sort[j]=sort[j-1];
				j--;
			}
			sort[j]= temp;
		}
		i_timeEnd = System.currentTimeMillis();
		System.out.println("Verlauf der Schleife: "+(i_timeEnd - i_timeStart)+" Millisek.");
		
		return sort;
	}
	public static int[] bubblesort(int[] sort)
	{	bubble_timeStart = System.currentTimeMillis();
		sort = new int[laenge]; 
		int temp;
		for(int i =1;i<sort.length;i++)
		{
			for(int j=0;j<sort.length-1;j++)
			{
				if(sort[j]>sort[j+1])
				{
					temp = sort[j];
					sort[j] = sort[j+1];
					sort[j+1] = temp;
				}
			}
		}
		bubble_timeEnd = System.currentTimeMillis();
		System.out.println("Verlauf der Schleife: "+(bubble_timeEnd - bubble_timeStart)+" Millisek.");
		
		return sort;
	}
	//Bogosort
	public static int[] bogosort(int [] array)
	{	bogo_timeStart = System.currentTimeMillis();
		array = new int[laenge]; 
		while(!isSorted(array)){
			zaehler++;
			mix(array);
		}
		bogo_timeEnd = System.currentTimeMillis();
		System.out.println("Verlauf der Schleife: "+(bogo_timeEnd - bogo_timeStart)+" Millisek.");
		return array;
	}
	public static void print (int[] s) {
		System.out.print("Bogosort: ");
		for(int i = 0;(i<s.length-1);i++) {
			System.out.print(+s[i] + " ");
		}
		System.out.println();
	}
	public static int[] mix(int[] array) {
		
		for(int i = 0; i<array.length;i++)
		{
			int index1 = rnd.nextInt(array.length);
			int index2 = rnd.nextInt(array.length);
			
			int temp = array[index1];
			array[index1] = array[index2];
			array[index2] = temp;
		}
		return array;
	}
	public static boolean isSorted(int[] a) {
		for(int i=0;i<(a.length-1);i++)
		{
			if(a[i]>a[i+1]) {
				return false;
			}
		}
		return true;
	}
}
