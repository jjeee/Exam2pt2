import java.util.ArrayList;

public class SymbolTable {
    static String strOri,strExpression,strOperator,strVariable,strInfix;
    static ArrayList<Variable> Table=new ArrayList();

    public SymbolTable(String strOri) {
        this.strOri = strOri;
        Table.add(new Variable('A',9.5));
        Table.add(new Variable('B',4.0));
        Table.add(new Variable('C',3.0));
        Table.add(new Variable('D',2.0));
        Table.add(new Variable('E',6.0));
        Table.add(new Variable('F',8.0));
        Table.add(new Variable('G',4.0));

        scan(strOri);
        buildTable(strExpression);
        buildInfix(strVariable,strOperator);
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
        /*System.out.println("<Exam 2: Jae Jee>");
        System.out.println("Valid Expression = "+strExpression);
        System.out.println("Operator String = "+strOperator+"\n");
        System.out.println("Symbol Table");
        for (Variable var:Table) {
            System.out.println(var);
        }System.out.println();
*/
        strVariable="";
        for (int index=0;index<strExpression.length();index++) {
            if (strExpression.charAt(index)=='9'){
                strVariable+='A';
            }else if (strExpression.charAt(index)=='4'){
                if(strExpression.contains("B")){
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
        while (strVariable.isEmpty()&&(index<strVariable.length())){
            strInfix+=strVariable.charAt(index);
            if (!strOperator.isEmpty())
                strInfix+=strOperator.charAt(index);
            index++;
        }
        return strInfix;
    }

    public String toString(){
        return "<Exam 2: Jae Jee>\nValid Expression = " + strExpression + "\nOperator String = "
                + strOperator + "\n\nSymbol Table" + "\n\nVariable String = " + strVariable
                + "\ninfix = " + strInfix;
    }
}
