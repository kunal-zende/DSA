

public class AccessModifier {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(); //created object
        acc.userName = "Kunal";
        acc.setPassword("kunal");
        System.out.println(acc.userName);
        // System.out.println(acc.password);
    }
}

//Acccess Specifier
class BankAccount{
    public String userName;  //access 
    private String password;  // access within the class only
    public void setPassword(String newPassword){   //we can change password outside the class but 
        password = newPassword;                 // can,t access it
    }
}
