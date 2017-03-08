import java.io.IOException;

public class Step1{
    String strInput ="9.5 - 4 * 3 ^ 2 /6 +8 * 4";
    SymbolTable st=new SymbolTable(strInput);
    public Step1() throws IOException {
        java.io.PrintWriter output = new java.io.PrintWriter("out2a.txt");

        String stExpress=st.scan(strInput);
        st.buildTable(stExpress);
        st.buildInfix(SymbolTable.strVariable,SymbolTable.strOperator);
        System.out.println(st);

        output.println(st);
        output.close();

    }

}
