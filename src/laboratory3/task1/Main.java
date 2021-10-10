package laboratory3.task1;

public class Main {

    public static void main(String[] args) {
	User user1 = new User("Ivan", "Petrenko", "myemail@gmail.com", 20, null);
	user1.validate();
	user1.setAddress(new Address("Ukraine", "Lviv","Zelena"));
	user1.validate();
	user1.setFirstName("1Van");
	user1.validate();
    }
}
