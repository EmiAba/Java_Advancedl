public class Person implements Comparable<Person> {
    private String name;
    private String town;
    private Integer age;

    public Person(String name, String town, Integer age) {
        this.name = name;
        this.town = town;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getTown() {
        return town;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public int compareTo(Person otherPerson) {
        // Compare names first
        int nameComparingResult = name.compareTo(otherPerson.name);
        if (nameComparingResult != 0) {
            return nameComparingResult;
        }

        // If names are equal, compare ages
        int ageComparingResult = age.compareTo(otherPerson.age);
        if (ageComparingResult != 0) {
            return ageComparingResult;
        }

        // If ages are also equal, compare towns
        return town.compareTo(otherPerson.town);
    }
}
