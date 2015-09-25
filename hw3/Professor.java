public class Professor extends Person {
    protected int rateMyProfessorRating;
    protected double averageGPA;

    public Professor(String firstName, String lastName,
        int rateMyProfessorRating, double averageGPA) {
        super(firstName, lastName);
        this.rateMyProfessorRating = rateMyProfessorRating;
        this.averageGPA = averageGPA;
    }
    public String toString() {
        return "Hi, my name is " + firstName + " " + lastName
            + ". My Rate My Professor rating is " + rateMyProfessorRating
            + "/5 and my average GPA is " + averageGPA
            + "/4.00. I really wish students"
            + " would stop emailing me so much.";
    }
}