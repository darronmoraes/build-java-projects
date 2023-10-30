package emailapp;

public class EmailApp {

    public static void main(String[] args) {
        Email email = new Email("Darron", "Moraes");

        email.setAlternateEmail("darron@numinolabs.com");
        System.out.println("Alternate email : " + email.getAlternateEmail());
    }
}
