package laboratory3.task1;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private Address address;

    public User(){}
    public User(final String firstName, final String lastName,
                final String email, final int age, final Address address){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.age=age;
        this.address=address;
    }
    public User(final String firstName, final String lastName,
                final String email, final int age, final String country,
                final String district, final String city){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.age=age;
        address = new Address(country,district,city);
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail  () {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public void validate(){
        try{
            if (!firstName.matches("[a-zA-Z]+") | !lastName.matches("[a-zA-Z]+")
                    | !email.matches("[a-zA-Z0-9]{4,20}@[a-z]{1,5}\\.[a-z]{1,3}") | age <= 0 | age > 200 |
                    !address.getCountry().matches("[A-Z][a-z]+") |
                    !address.getCity().matches("[A-Z][a-z]+") |
                    !address.getStreet().matches("[A-Z][a-z]+( [A-Z][a-z]+)?"))
                throw new UncheckedException(ErrorCode.ERROR_400);
            System.out.println("Successful validation");
        } catch (UncheckedException e){
            System.out.println(e.getMessage());
        } catch (NullPointerException e){
            System.out.println(ErrorCode.ERROR_400 + "; Not initialized field");
        }
    }
}
