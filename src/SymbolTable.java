import java.util.ArrayList;

public class SymbolTable {
    static String strOri,strExpression,strOperator,strVariable,strInfix,strPostfix;
    static ArrayList<Variable> Table=new ArrayList();

    public SymbolTable(String strOri) {
        this.strOri = strOri;

        //scan(strOri);
        //buildTable(strExpression);
        //buildInfix(strVariable,strOperator);
    }

    public static String scan(String strOri){
        strExpression="";
        for (int index=0;index<strOri.length();index++){
            if (strOri.charAt(index)!=' '){
                strExpression+=strOri.charAt(index);
            }
        }

        strOperator="";
        for (int index=0;index<strExpression.length();index++) {
            if (strExpression.charAt(index)=='^'){
                strOperator+='^';
            }else if (strExpression.charAt(index)=='+'){
                strOperator+='+';
            }else if (strExpression.charAt(index)=='-'){
                strOperator+='-';
            }else if (strExpression.charAt(index)=='*'){
                strOperator+='*';
            }else if (strExpression.charAt(index)=='/'){
                strOperator+='/';
            }
        }

        return strExpression;
    }

    public static void buildTable(String strExpression){

        Table.add(new Variable('A',9.5));
        Table.add(new Variable('B',4.0));
        Table.add(new Variable('C',3.0));
        Table.add(new Variable('D',2.0));
        Table.add(new Variable('E',6.0));
        Table.add(new Variable('F',8.0));
        Table.add(new Variable('G',4.0));

        strVariable="";
        for (int index=0;index<strExpression.length();index++) {
            if (strExpression.charAt(index)=='9'){
                strVariable+='A';
            }else if (strExpression.charAt(index)=='4'){
                if(strVariable.contains("B")){
                    strVariable+='G';
                }else
                strVariable+='B';
            }else if (strExpression.charAt(index)=='3'){
                strVariable+='C';
            }else if (strExpression.charAt(index)=='2'){
                strVariable+='D';
            }else if (strExpression.charAt(index)=='6'){
                strVariable+='E';
            }else if (strExpression.charAt(index)=='8'){
                strVariable+='F';
            }else if (strExpression.charAt(index)=='4'){
                strVariable+='G';
            }
        }
    }

    public String buildInfix(String strVariable,String strOperator){
        strInfix="";
        int index=0;
        while (index<strOperator.length()){
            strInfix+=strVariable.charAt(index);
            if (!strOperator.isEmpty())
                strInfix+=strOperator.charAt(index);
            index++;
        }strInfix+=strVariable.charAt(index);
        return strInfix;
    }

    public String toString(){
        return "<Exam 2: Jae Jee>\nValid Expression = " + strExpression + "\nOperator String = "
                + strOperator + "\n\nSymbol Table" + outTable() + "\nVariable String = " + strVariable
                + "\ninfix = " + strInfix;
    }

    public String outTable(){
        StringBuilder builder = new StringBuilder();
        for (Variable var : Table) {
            builder.append(var);
            builder.append("\n");
        }
        String text = builder.toString();
        return "\n"+text;
    }

    public static String infix2Postfix(String strInfix){
        StackInterface<Character> opStack = new LinkedStack<Character>();
        StringBuilder postfix = new StringBuilder();
        int infixLen = strInfix.length();
        char topOp;

        for (int index = 0; index < infixLen; index++)
        {
            boolean done = false;
            char nextCharacter = strInfix.charAt(index);

            if (nextCharacter=='A'||nextCharacter=='B'||nextCharacter=='C'||nextCharacter=='D'
                    ||nextCharacter=='E'||nextCharacter=='F'|| nextCharacter=='G')
                postfix = postfix.append(nextCharacter);
            else
            {
                switch (nextCharacter)
                {
                    case '^':
                        opStack.push(nextCharacter);
                        break;

                    case '+': case '-': case '*': case '/':
                    while (!done && !opStack.isEmpty())
                    {
                        topOp = opStack.peek();

                        if (opsOrder(nextCharacter) <= opsOrder(topOp))
                        {
                            postfix = postfix.append(topOp);
                            opStack.pop();
                        }
                        else
                            done = true;
                    }

                    opStack.push(nextCharacter);
                    break;

                    default: break;
                }
            }
        }

        while (!opStack.isEmpty())
        {
            topOp = opStack.pop();
            postfix = postfix.append(topOp);
        }
        return postfix.toString();
    }

    private static int opsOrder(char op)
    {
        switch (op)
        {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            case '^':           return 3;
        }

        return -1;
    }

    public static double evaluate(String postfix)
    {
        StackInterface<Double> valueStack = new LinkedStack<Double>();
        int characterCount = postfix.length();

        for (int index = 0; index < characterCount; index++)
        {
            char nextCharacter = postfix.charAt(index);
            switch(nextCharacter)
            {
                case 'A': case 'B': case 'C': case 'D': case 'E': case 'F': case 'G':
                valueStack.push(varVal(nextCharacter));
                break;

                case '+': case '-': case '*': case '/': case '^':
                Double numTwo = valueStack.pop();
                Double numOne = valueStack.pop();
                Double result = calc(numOne, numTwo, nextCharacter);
                valueStack.push(result);
                break;

                default: break;
            }
        }

        return (valueStack.peek()).doubleValue();
    }


    private static double varVal(char variable)
    {
        switch (variable)
        {
            case 'A': return 9.5;
            case 'B': return 4.0;
            case 'C': return 3.0;
            case 'D': return 2.0;
            case 'E': return 6.0;
            case 'F': return 8.0;
            case 'G': return 4.0;
        }

        return 0;
    }

    private static Double calc(Double numOne, Double numTwo, char op)
    {
        double result;
        switch (op)
        {
            case '+':
                result = numOne.doubleValue() + numTwo.doubleValue();
                break;

            case '-':
                result = numOne.doubleValue() - numTwo.doubleValue();
                break;

            case '*':
                result = numOne.doubleValue() * numTwo.doubleValue();
                break;

            case '/':
                result = numOne.doubleValue() / numTwo.doubleValue();
                break;

            case '^':
                result = Math.pow(numOne.doubleValue(), numTwo.doubleValue());
                break;

            default:
                result = 0;
                break;
        }
        return result;
    }
}
