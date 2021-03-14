package exceptions;

public class NoSuchUsernameOrPasswordException extends Exception {
    public NoSuchUsernameOrPasswordException(){
        super("No Such Password Or Username");
    }
}
