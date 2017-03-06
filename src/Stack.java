import java.util.EmptyStackException;

public class Stack<T>{
    private static final int SIZE=100;
    private T[] stack;
    private int topIndex;
    private boolean initialized=false;

    public Stack() {
        T[] tempStack = (T[])new Object[SIZE];
        stack = tempStack;
        topIndex = SIZE;
        initialized = true;
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
    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();
        else
            return stack[topIndex];
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
    public void emptyWrite(java.io.PrintWriter output){
        if(isEmpty())
            output.println("Stack is empty. Nothing to pop!");
    }



}