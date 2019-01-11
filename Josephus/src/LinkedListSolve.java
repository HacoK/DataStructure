import java.util.Scanner;

public class LinkedListSolve {
	
	public static void main(String[] args){
		Scanner sr=new Scanner(System.in);
		System.out.println("Input n for Josephus:");
		int n=sr.nextInt();
		System.out.println("Input m for Josephus:");
		int m=sr.nextInt();
		System.out.println("The lucky number is:"+josephus(n,m));
	}
	public static int josephus(int n,int m){
		RingList list=new RingList();
		for(int i=1;i<=n;i++){
			list.link(new RingNode(i,null));
		}
        RingNode p=list.header;
		for(int i=1;i<n;i++){
			for(int j=0;j<m-1;j++)
				p=p.theNext;
			p.theNext=p.theNext.theNext;
		}
		return p.element;
	}
}
class RingNode{
	int element;
	RingNode theNext;
	RingNode(int element,RingNode theNext){
		this.element=element;
		this.theNext=theNext;
	}
}
class RingList{
	RingNode header=new RingNode(0,null);
	RingNode rear=header;
	public void link(RingNode linker){
		if(header.theNext==null){
			header.theNext=linker;
			linker.theNext=linker;
			rear=linker;
		}
		else{
			rear.theNext=linker;
			linker.theNext=header.theNext;
			rear=linker;
		}
	}
}