package simulation;

public class Main {

    public static void main(String[] args) {
        Porsche911 p = new Porsche911(1445.0, 456.0, 330.0, 1.0);
        JGameAdapter.registerPartikle(p);
        JGameAdapter.startEngine(800, 400);
    }
}
