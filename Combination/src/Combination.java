import java.io.*;

public class Combination {
	public static void main(String[] args){
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input a natural number n:");
		int n=0;
		try{
			n=Integer.parseInt(br.readLine());
		}catch(IOException e){
			e.printStackTrace();
		}
		int r=0;
		System.out.println("Input the number of elements selected(r):");
		try{
			r=Integer.parseInt(br.readLine());
		}catch(IOException e){
			e.printStackTrace();
		}
		int[] temp=new int[r];
		System.out.println("The varied combinations:");
		combine(n,r,r,temp);
	}
	public static void combine(int n,int r,int hole,int[] comb){
		if(hole==0){
			for(int i=0;i<r;i++)
				System.out.print(comb[i]+" ");
			System.out.println("");
		}
		else if(n<hole)
			return;
		else{
			combine(n-1,r,hole,comb);
			comb[hole-1]=n;
			combine(n-1,r,hole-1,comb);
		}
	}
}
