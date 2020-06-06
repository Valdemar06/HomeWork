public class Homemade extends Animal {

    private boolean isVaccinated = false;
    private String name = " ";

    public Homemade(int id, int age, int weight, String color, String name ,boolean isVaccinated) {
        super(id, age, weight, color);
        this.isVaccinated = isVaccinated;
        this.name = name;
    }

    @Override
    public String vote(){
        String  homemade = "my names is " + name;
        return  super.vote() + homemade;
    }
}
