package tuple;

public class Tuple<P1, P2> {
    private P1 parameter1;
    private P2 parameter2;

    public Tuple(){}
    public P1 getParameter1() {
        return this.parameter1;
    }

    public void setParameter1(P1 parameter1) {
        this.parameter1 = parameter1;
    }

    public P2 getParameter2() {
        return this.parameter2;
    }

    public void setParameter2(P2 parameter2) {
        this.parameter2 = parameter2;
    }

    @Override
    public String toString() {
        return this.parameter1 + " -> "+this.parameter2;
    }
}
