import java.util.EmptyStackException;

public class Stack<T>{
    private static final int SIZE=100;
    private T[] stack;
    private int topIndex;

    public Stack() {
        T[] tempStack = (T[])new Object[SIZE];
        stack = tempStack;
        topIndex = SIZE;
    }

    public void push(T newEntry) {
        stack[topIndex-1] = newEntry;
        topIndex--;
    }

    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();
        else
        {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex++;
            return top;
        }
    }

    public T pop(java.io.PrintWriter output) {
        if (isEmpty()){
            try {
                output.println("Stack is empty. Nothing to pop!");
            }catch (EmptyStackException e){
                System.out.println(e);
            }
        }
        else
        {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex++;
            return top;
        }
        return null;
    }

    public boolean isEmpty() {
        return topIndex>99;
    }

    public void writeOut(java.io.PrintWriter output){

        output.println("Stack Pointer\tValue");
        for (int i=topIndex;i<100;i++){
            output.println("\t\t"+i+"\t\t"+stack[i]);
        }
    }
}