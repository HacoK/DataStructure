import java.util.Iterator;
import java.util.LinkedList;

class Literal
{
      double coefficient;
      int exponent;
      Literal(double coefficient,int exponent){
    	  this.coefficient=coefficient;
    	  this.exponent=exponent;
      }
}

public class ADD {
	public static void main(String[] args){
		LinkedList<Literal> A=new LinkedList<Literal>(),B=new LinkedList<Literal>();
			A.add(new Literal(2,100));A.add(new Literal(3,14));A.add(new Literal(2,8));A.add(new Literal(1,0));
			B.add(new Literal(-2,100));B.add(new Literal(8,14));B.add(new Literal(-3,10));B.add(new Literal(10,6));B.add(new Literal(-1,1));
		LinkedList<Literal> sum=add(A,B);
		Iterator<Literal> it=sum.iterator();
		Literal temp;
		while(it.hasNext())
		{
			temp=it.next();
			if(temp!=sum.getLast())System.out.println(temp.coefficient+"X"+temp.exponent);
			else System.out.println(temp.coefficient);
		}
	}
	
	
	public static LinkedList<Literal> add(LinkedList<Literal> A,LinkedList<Literal> B){
		LinkedList<Literal> sum=new LinkedList<Literal>();
		Iterator<Literal> ita=A.iterator();
		Iterator<Literal> itb=B.iterator();
		Literal a,b;
		double value;
		a=ita.next();
		b=itb.next();
		while(true){
			if(a.exponent==b.exponent){
			    value=a.coefficient+b.coefficient;
			    if(value!=0){
				    sum.add(new Literal(value,a.exponent));
			    }
			    if(ita.hasNext()&&itb.hasNext()){
			    	a=ita.next();
			    	b=itb.next();
			    }else
			    	break;
		    }
			else if(a.exponent>b.exponent){
				sum.add(new Literal(a.coefficient,a.exponent));
				if(ita.hasNext())
					a=ita.next();
				else
					break;
			}
			else if(a.exponent<b.exponent){
				sum.add(new Literal(b.coefficient,b.exponent));
				if(itb.hasNext())
					b=itb.next();
				else
					break;
			}
		}
		if(a.exponent!=sum.getLast().exponent){
			sum.add(new Literal(a.coefficient,a.exponent));
			while(ita.hasNext()){
			    a=ita.next();
			    sum.add(new Literal(a.coefficient,a.exponent));
		}
		}
		else if(b.exponent!=sum.getLast().exponent){
			sum.add(new Literal(b.coefficient,b.exponent));
			while(itb.hasNext()){
			    b=itb.next();
			    sum.add(new Literal(b.coefficient,b.exponent));
		}
		}
		return sum;
	}
}
