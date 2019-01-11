import java.util.Scanner;

public class Hanoi {
	public static void main(String[] args){
		System.out.println("Input the number of disks:");
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		moveDisks(n,'A','B','C');
	}
	public static void moveDisks(int n,char fromTower,char toTower,char auxTower){
		if(n<=0)
			return;
		else if(n==1)
			System.out.println("Move Disk 1 from "+fromTower+" to "+toTower);
		else{
			moveDisks(n-1,fromTower,auxTower,toTower);
			System.out.println("Move Disk "+n+" from "+fromTower+" to "+toTower);
			moveDisks(n-1,auxTower,toTower,fromTower);
		}
	}

}
