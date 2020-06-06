public class Dog extends  Homemade {
    public Dog(int id, int age, int weight, String color, String name, boolean isVaccinated) {
        super(id, age, weight, color, name, isVaccinated);
    }

    @Override
    public String vote() {
        String dog  = " Woof";
        return super.vote() + dog;
    }
}
