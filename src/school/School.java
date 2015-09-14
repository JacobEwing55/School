
package school;

public class School {

    public static void main(String[] args) {
        Person juan = Person.addPerson("Juan",Person.Gender.Male,175);
        juan.setName("Diego");
        Person joseph = Person.addPerson("Joseph",Person.Gender.Male,210);
        Person sharkeisha = Person.addPerson("Sharkeisha",Person.Gender.Female,170);
        System.out.println(joseph.getGender());
        Person.printName();
        Person.printName(Person.Gender.Male);
        
        System.out.println(joseph);
    }
}
