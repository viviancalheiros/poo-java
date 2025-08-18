package taxes;

public class Individual extends Person {
    private double health;

    public Individual (String name, double income, double health) {
        super(name, income);
        this.health = health;
    }

    public void calcTax () {
        if (super.getIncome() < 20000) { super.setTax(super.getIncome()*0.15); }
        else { super.setTax(super.getIncome()*0.25); }
        super.setTax(super.getTax() - health*0.5);
        if (super.getTax() <= 0) { super.setTax(0); }
    }
}
