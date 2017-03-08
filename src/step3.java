import java.io.IOException;

public class step3 {
    String strInput ="9.5 - 4 * 3 ^ 2 /6 +8 * 4";
    SymbolTable st=new SymbolTable(strInput);
    public step3() throws IOException{
        java.io.PrintWriter output = new java.io.PrintWriter("out2c.txt");

        String stExpress=st.scan(strInput);
        st.buildTable(stExpress);
        st.buildInfix(SymbolTable.strVariable,SymbolTable.strOperator);

        String postFix=st.infix2Postfix(SymbolTable.strInfix);
        double eval=st.evaluate(postFix);

        output.println("<Exam 2: Jae Jee>");
        output.println("Postfix: "+postFix+"\n");
        output.println("Evaluation: "+eval);
        output.close();

    }



}
