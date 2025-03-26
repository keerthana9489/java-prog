import java.util.Stack ;
public class InfixToPostfix {
public static string convert (String infix) {
Stack<charecter>Stack =new Stack<>();
StringBuilder postfix=new stringBuilders();
For(char ch: infix.tocharArray()){
if(character.isletter or Digit(ch)){
Postfix.append(ch);
}else if(ch=')') {
while(Stack.peek()=!'(') {
Postfix.append(stack.pop());
}
Stack.pop();
}else{
while(!Stack is Empty() &&precedence
(Stack.peek()>=precedence(ch)){
Postfix.append(stack.pop());
}
stack.push(ch);
}
}
while(!Stack isEmpty()) {
Postfix.append(stack.pop());
}
return postfix.to String();
}
Private static nt precedence (char op) {
return(op=="+"||op=="-")?|:(op=="*"||op=="/")?2:0;
} 

Public static void main(String[]args) {

String infix="a-b*d/e (b+c)";
System.out.println("postfix:"+convert(infix));

}
}