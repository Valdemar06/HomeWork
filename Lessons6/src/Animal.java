public class Animal {
    private int id;
    private int age;
    private int weight;
    private String color;
    private Animal [] animals = new Animal[20];

    public Animal( int id, int age, int weight, String color){
        this.id = id;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public String vote(){
        String hello = "Hello, ";
        return  hello;
    }

    public void add(Animal animal,int index){
            animals[index] = animal;
    }
    public void voteAll(){
        for (int i = 0; i <animals.length ; i++) {
            if(animals[i] != null)
            System.out.println(animals[i].vote());
        }
    }
}
