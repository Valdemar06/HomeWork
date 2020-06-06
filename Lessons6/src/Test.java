public class Test {
    public static void main(String[] args) {
        GuidDog guidDog = new GuidDog(5,5,5, "White", "Hello", true , true);
        Wolf wolf = new Wolf(1, 2,120, "Grey", true);
        Cat cat = new Cat(5,5,52,"Black", "Pushok", true);
        Crocodile crocodile = new Crocodile(6,10,500,"Green", true);
        Dog dog = new Dog(5,5,50,"Black", "Tor", true);
        Fish fish = new Fish(5,5,10,"Gold", "Bruce", true);
        Giraffe giraffe = new Giraffe(5,5,1000,"Yellow",false);
        Hamster hamster = new Hamster(6,6,6,"Grey", "Chack", true);
        Lion lion = new Lion(6,6,60,"Black", true);
        Animal animal = new Animal(1,2,5,"Grey");
        animal.add(wolf,0);
        animal.add(guidDog,1);
        animal.add(cat, 2);
        animal.add(crocodile,3);
        animal.add(dog,4);
        animal.add(fish,5);
        animal.add(giraffe,6);
        animal.add(hamster,7);
        animal.add(lion,8);
        animal.voteAll();
    }
}
