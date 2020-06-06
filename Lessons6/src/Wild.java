public class Wild extends  Animal {
    private boolean isPredator = false;

    public Wild(int id, int age, int weight, String color, boolean isPredator) {
        super(id, age, weight, color);
        this.isPredator = isPredator;
    }

    @Override
    public String vote() {
        String wild = "I am a wild animal";
        if (isPredator) return super.vote() + wild+" and I am angry ";
        else return super.vote() + wild;
    }
}
