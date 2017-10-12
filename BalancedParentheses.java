/*
Check for balanced parentheses in an expression

Given an expression string exp , write a program to examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp. For example, the program should print true for exp = “[()]{}{[()()]()}” and false for exp = “[(])”

Algorithm:
1) Declare a character stack S.
2) Now traverse the expression string exp.
    a) If the current character is a starting bracket (‘(‘ or ‘{‘ or ‘[‘) then push it to stack.
    b) If the current character is a closing bracket (‘)’ or ‘}’ or ‘]’) then pop from stack and if the popped character is the matching starting bracket then fine else parenthesis are not balanced.
3) After complete traversal, if there is some starting bracket left in stack then “not balanced”

*/
public class BalancedParentheses{
	/* Stack implementation */
	static class stack{
		int top = -1;
		char str[] = new char[100];
		void push(char ele){
			if(top == 99){
				System.out.println("stack overflows");
			}else{
				str[++top] = ele;
			}
		}
		char pop(){
			if(top == -1){
				System.out.println("Stack underflow");
				return '\0';
			}
			char ele = str[top];
			top--;
			return ele;
		}
		boolean checkEmpty(){
			return (top == -1) ? true : false;
		}
	}
	/* Returns true if character1 and character2 are matching left and right Parenthesis */
	static boolean compareChar(char start, char end){
		if( (start == '{' && end == '}') || (start == '(' && end == ')') || (start == '[' && end == ']') ){
			return true;
		}
		return false;
	}
	/* Return true if expression has balanced parenthesis */
	static boolean expBalanced(char[] exp){
		/* Declare empty stack */
		stack st = new stack();
		/* Loop through each character */
		for( int i=0; i<exp.length; i++){
			/*If the exp[i] is a starting parenthesis then push it*/
			if(exp[i] == '{' || exp[i] == '(' || exp[i] == '[' ){
				st.push(exp[i]);
			}
			/*If the exp[i] is a ending parenthesis then pop it*/
			else if(exp[i] == '}' || exp[i] == ')' || exp[i] == ']' ){
				/* If we see an ending parenthesis without a pair then return false */
				if(st.checkEmpty()){
					return false;
				}
				/* Pop the top element from stack, if miss match of the pop character return false */
				else if(!compareChar(st.pop(), exp[i])){
					return false;
				}
			}
		}
		/* Return true if stack is empty else false */
		return st.checkEmpty() ? true : false;
	}
	/* Main class compilation starts */
	public static void main(String args[]){
		char exp[] = {'{','(',')','}','[',']'};
		if(expBalanced(exp)){
			System.out.println("Expresion Matched");
		}else{
			System.out.println("Expresion Not Matched");
		}
	}
}