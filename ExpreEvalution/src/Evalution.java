import java.io.*;
import java.util.ArrayList;

public class Evalution {
	public static void main(String[] args) throws IOException{
		System.out.println("Input an infix expression(#):");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String ex=br.readLine();
		String temp="";
		char c;
		operator buff=null;
		int level=0;
		ArrayList<Double> operands=new ArrayList<>();
		ArrayList<operator> operators=new ArrayList<>();
		operators.add(new operator('#',-1));
		for(int i=0;i<ex.length();i++){
			c=ex.charAt(i);
			if(c=='+'){
				buff=new operator('+',1+2*level);
				if(buff.prior(operators.get(operators.size()-1))){
					operators.add(buff);
				}else{
					do{
						operators.get(operators.size()-1).execute(operands);
						operators.remove(operators.size()-1);
					}while(!buff.prior(operators.get(operators.size()-1)));
					operators.add(buff);
				}
			}else if(c=='-'){
				buff=new operator('-',1+2*level);
				if(buff.prior(operators.get(operators.size()-1))){
					operators.add(buff);
				}else{
					do{
						operators.get(operators.size()-1).execute(operands);
						operators.remove(operators.size()-1);
					}while(!buff.prior(operators.get(operators.size()-1)));
					operators.add(buff);
				}
			}else if(c=='*'){
				buff=new operator('*',2+2*level);
				if(buff.prior(operators.get(operators.size()-1))){
					operators.add(buff);
				}else{
					do{
						operators.get(operators.size()-1).execute(operands);
						operators.remove(operators.size()-1);
					}while(!buff.prior(operators.get(operators.size()-1)));
					operators.add(buff);
				}
			}else if(c=='/'){
				buff=new operator('/',2+2*level);
				if(buff.prior(operators.get(operators.size()-1))){
					operators.add(buff);
				}else{
					do{
						operators.get(operators.size()-1).execute(operands);
						operators.remove(operators.size()-1);
					}while(!buff.prior(operators.get(operators.size()-1)));
					operators.add(buff);
				}
			}else if(c=='%'){
				buff=new operator('%',2+2*level);
				if(buff.prior(operators.get(operators.size()-1))){
					operators.add(buff);
				}else{
					do{
						operators.get(operators.size()-1).execute(operands);
						operators.remove(operators.size()-1);
					}while(!buff.prior(operators.get(operators.size()-1)));
					operators.add(buff);
				}
			}else if(c=='('){
				level++;
				operators.add(new operator('(',0));
			}else if(c==')'){
				level--;
				while(operators.get(operators.size()-1).op!='('){
					buff=operators.get(operators.size()-1);
					buff.execute(operands);
					operators.remove(operators.size()-1);
				}
				operators.remove(operators.size()-1);
			}else if(c=='#'){
				while(operators.get(operators.size()-1).op!='#'){
					operators.get(operators.size()-1).execute(operands);
					operators.remove(operators.size()-1);	
				}
			}else{
				while((ex.charAt(i+1)!='+')&&(ex.charAt(i+1)!='-')&&(ex.charAt(i+1)!='*')&&(ex.charAt(i+1)!='/')&&(ex.charAt(i+1)!='%')&&(ex.charAt(i+1)!='(')&&(ex.charAt(i+1)!=')')&&(ex.charAt(i+1)!='#')){
					c=ex.charAt(i);
					temp=temp+c;
					i++;
				}
				temp=temp+ex.charAt(i);
				operands.add(Double.parseDouble(temp));
				temp="";
			}
		}
		System.out.println("The value of the expression is:"+operands.get(0));
	}
}

class operator{
	char op;
	int pred;
	operator(char op,int pred){
		this.op=op;
		this.pred=pred;
	}
	boolean prior(operator cmp){
		if(this.pred>cmp.pred)
			return true;
		else
			return false;
	}
	void execute(ArrayList<Double> operands){
		double m=operands.get(operands.size()-1),n=operands.get(operands.size()-2);
		operands.remove(operands.size()-1);
		operands.remove(operands.size()-1);
		switch(this.op){
		case '+':
			operands.add(m+n);
			break;
		case '-':
			operands.add(n-m);
			break;
		case '*':
			operands.add(m*n);
			break;
		case '/':
			operands.add(n/m);
			break;
		case '%':
			operands.add(n%m);
			break;
		default:
			break;
		}
	}
}