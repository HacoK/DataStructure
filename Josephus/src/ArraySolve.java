import java.util.Scanner;

public class ArraySolve {
	public static void main(String[] args){
		Scanner sr=new Scanner(System.in);
		System.out.println("Input n for Josephus:");
		int n=sr.nextInt();
		System.out.println("Input m for Josephus:");
		int m=sr.nextInt();
		System.out.println("The lucky number is:"+josephus(n,m));
	}
	public static int josephus(int n,int m){
		int luck=0;
		boolean[] men=new boolean[n];
		int count=0;
		int index=0;
		int check=0;
		for(int i=0;i<n;i++){
			men[i]=true;
		}
		while(count<n-1){
			while(check!=m){
				if(men[index%n])
					{check++;
				     index++;
				     }
				else index++;
			}
			men[index%n]=false;
			count++;
			check=0;
		}
		for(int i=0;i<n;i++)
			{if(men[i])
				luck=i+1;}
		return luck;
	}
}
