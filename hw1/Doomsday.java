import java.io.Console;

public class Doomsday {
    public static void main(String[] args) {
        Console console = System.console();
        System.out.println("Welcome to the doomsDay Calculator!");
        System.out.print("What year are you looking for? ");
        String userInput = console.readLine();
        int year = Integer.parseInt(userInput); //lets you input a number
        System.out.print("What month (1-12)? ");
        userInput = console.readLine();
        int month = Integer.parseInt(userInput);
        System.out.print("What day? ");
        userInput = console.readLine();
        int day = Integer.parseInt(userInput);
        int parseYear = year % 100; //System.out.println(parseYear);
        int yearDivide = parseYear / 12; //System.out.println(yearDivide);
        int yearMod = parseYear % 12; //System.out.println(yearMod);
        int yearModDivide = yearMod / 4;
        int sum = yearDivide + yearMod + yearModDivide + 3;
        int doomsDay = sum % 7; //System.out.println(doomsDay);
        int [] leapYear = {4, 29, 7, 4, 9, 6, 11, 8, 5, 10, 7, 12};
        boolean isLeapYear;
        if (parseYear % 4 == 0 && year != 1900) {
            isLeapYear = true; //System.out.println("This is a leap year");
        } else {
            isLeapYear = false;
            leapYear[0] = 3;
            leapYear[1] = 28;
            //System.out.println("This is not a leap year");
        }
        int difference = day - leapYear[month - 1];
        //System.out.println(difference);
        int total = difference + doomsDay; //System.out.println(total);
        int mod = total % 7; //System.out.println(mod);
        if (mod < 0) {
            mod = mod + 7; //System.out.println(mod);
        }
        String[] days = {"Sunday", "Monday",  "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday"};
        System.out.println("\n" + month + "/" + day + "/" + year + " was on a "
            + days[mod] + ".");
    }
}
