import java.util.Scanner;
class Person {
    private final String NAME;
    private final int AGE;

    public Person(String name, Scanner sc) {
        this.NAME = name;
        System.out.print("Age: ");
         this.AGE = sc.nextInt();
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        } else if (name.length()>40) {
            throw new IllegalArgumentException("Name cannot be longer than 40 characters");
        } else if (AGE < 0 || AGE > 120){
            throw new IllegalArgumentException("Age must be between 0 and 120");
        }
    }

    @Override
    public String toString(){
        return "Name: " + this.NAME + ", Age: " + this.AGE;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        Person person = new Person(name, sc);
        System.out.println("Hello " + name);
        System.out.println(person);
        
    }
}
