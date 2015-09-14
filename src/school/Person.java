
package school;
import java.util.ArrayList;

public class Person {
    
//    private static int numPeople = 10;
//    private static int currentPeopleIndex = 0;
//    private static Person people[] = new Person[numPeople];
    private static ArrayList<Person>people = new ArrayList<Person>();
    
    enum Gender{
        Male, Female
    }
 
    private String name;
    private int weight;
    private Gender gender;
    
    public static Person addPerson(String _name, Gender _gender, int _weight)
    {
        Person temp = new Person(_name, _gender, _weight);
 //       people[currentPeopleIndex++] = temp;
        people.add(temp);
        return(temp);
    }
    
    Person()
    {
       name ="Obama";
       weight = 150;
       gender = Gender.Male;
    }
    
    Person(String _name,Gender _gender,int _weight)
    {
        name = _name;
       weight = _weight;
       gender = _gender;
    }
    
    public int getWeight()
    {
        return(weight);
    }
    public void setWeight(int _weight)
    {
        weight = _weight;
    }
    public String getName()
    {
        return(name);
    }
    public void setName(String _name)
    {
        name = _name;
    }
    public Gender getGender()
    {
        return(gender);
    }
    public void setGender(Gender _gender)
    {
        gender = _gender;
    }
    
    public static void printName()
    {
        System.out.println("===printNames===");
//        for(int i = 0;i < numPeople;i++)
//        if(people[i] != null)
//        {
//            System.out.println(people[i].getName());
//        }
//                for(int i = 0;i < people.size();i++)
//            System.out.println(people.get(i).getName());
                
          for(Person temp : people)
          {
              System.out.println(temp.getName());
          }
    }
    
    public static void printName(Gender _gender)
    {
        System.out.println("===printNames===");
        for(Person temp : people)
          {
              if(temp.gender == _gender)
              System.out.println(temp.getName());
          }
    }
    
    public String toString()
    {
        return(name + " " + gender + " " + weight);
    }
}
