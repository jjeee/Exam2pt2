public class Variable {
    char variable;
    double value;

    public Variable(char variable, double value) {
        this.value = value;
        this.variable = variable;
    }

    public char getVariable() {
        return variable;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return variable +"\t"+ value ;
    }
}
