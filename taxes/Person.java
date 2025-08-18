package taxes;

abstract class Person {
    private String name;
    private double income;
    private double tax;

    public Person (String name, double income) {
        this.name = name;
        this.income = income;
        this.tax = 0;
    }

    public String getName () {
        return this.name;
    }

    public double getIncome () {
        return this.income;
    }

    public double getTax () {
        return this.tax;
    }

    public void setTax (double tax) {
        this.tax = tax;
    }
}
