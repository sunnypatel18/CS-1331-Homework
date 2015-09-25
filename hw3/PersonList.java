public class PersonList {
    private Person[] people;
    private int count = 0;

    public PersonList(int maxSize) {
        people = new Person[maxSize];
    }
    public void listPeople() {
        for (int i = 0; i < count; ++i) {
            System.out.println(people[i]);
        }
    }
    public void add(Person p) {
        if (count < people.length) {
            people[count] = p;
            count++;
        }
    }
}