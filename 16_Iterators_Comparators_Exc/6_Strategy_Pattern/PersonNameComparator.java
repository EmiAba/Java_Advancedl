import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        Integer firstNameLength = firstPerson.getName().length();
        Integer secondNameLength = secondPerson.getName().length();
        int nameLengthComparingResult=firstNameLength.compareTo(secondNameLength);

        if(nameLengthComparingResult==0){

            char firstPersonNameLetter = firstPerson.getName().toUpperCase().charAt(0);
            char secondPersonNameLetter = secondPerson.getName().toUpperCase().charAt(0);

            return Character.compare(firstPersonNameLetter, secondPersonNameLetter);
        }

        return nameLengthComparingResult;
    }
}
