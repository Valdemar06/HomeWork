public class Cat extends Homemade {

    public Cat(int id, int age, int weight, String color, String name, boolean isVaccinated) {
        super(id, age, weight, color, name, isVaccinated);
    }

    @Override
    public String vote() {
        String meow = " Meow";
        return super.vote()+meow;
    }
}
