package threeuple;

public class Threeuple<P1, P2, P3> {
    private P1 parameter1;
    private P2 parameter2;
    private P3 parameter3;

    public Threeuple(){}
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

    public P3 getParameter3() {
        return this.parameter3;
    }

    public void setParameter3(P3 parameter3) {
        this.parameter3 = parameter3;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.parameter1)
                .append(" -> ")
                .append(this.parameter2)
                .append(" -> ")
                .append(this.parameter3);
        return output.toString();
    }
}

