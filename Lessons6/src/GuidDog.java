public class GuidDog extends Homemade {
    private boolean isTrained = false;

    public GuidDog(int id, int age, int weight, String color, String name, boolean isVaccinated, boolean isTrained) {
        super(id, age, weight, color, name, isVaccinated);
        this.isTrained = isTrained;
    }
    @Override
    public String vote(){
        String line = "";
        if(isTrained = true) line = " I can take you home ";
        else line = " I can't take you home ";
        return super.vote()+line;
    }
}
