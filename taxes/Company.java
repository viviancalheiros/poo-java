package taxes;

public class Company extends Person {
    private int employees;

    public Company(String name, double income, int employees) {
        super(name, income);
        this.employees = employees;
    }

    public void calcTax () {
        if (this.employees > 10) { super.setTax(super.getIncome()*0.14); }
        else { super.setTax(super.getIncome()*0.16); }
        if (super.getTax() <= 0) { super.setTax(0); }
    }

}
