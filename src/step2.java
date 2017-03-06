import java.io.FileNotFoundException;

public class step2 {
    public step2() throws FileNotFoundException {
        java.io.PrintWriter output = new java.io.PrintWriter("out2b.txt");

        String myName = "Jae Jee\n";
        char chA = 'A', chB = 'B', chC = 'C', chD = 'D';
        double dA = 93.7, dB = 7, dC = 10, dD = 6;
        Stack cStack=new Stack();  //a stack for Charater;
        Stack dStack=new Stack(); //a stack for Double;
        Stack vStack=new Stack();  //a stack for Variable class

        output.println(myName);


        cStack.push('A');
        cStack.push('B');
        cStack.push('C');
        cStack.writeOut(output);
        output.println();

        cStack.push('D');
        cStack.writeOut(output);
        output.println();

        output.println("character popped: "+cStack.pop());
        cStack.writeOut(output);
        output.println();

        output.println("character popped: "+cStack.pop(output));
        output.println("character popped: "+cStack.pop(output));
        output.println("character popped: "+cStack.pop(output));
        output.println("character popped: "+cStack.pop(output));
        output.println("character popped: "+cStack.pop(output));
        output.println();


        dStack.push(dA);
        dStack.push(dC);
        dStack.writeOut(output);
        output.println();

        vStack.push(new Variable(chA, dA));
        vStack.push(new Variable(chB, dB));
        vStack.push(new Variable(chC, dC));
        vStack.writeOut(output);

        output.close();
    }
}
