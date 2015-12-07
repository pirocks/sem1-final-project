import java.io.Console;
public class get_char
{
    public static void get_char_internal()
    {
        Curses curses = new Curses();
        System.out.print(curses.enter_insert_mode);
        System.out.print(curses.enter_ca_mode);
        Console cons = System.console();
        System.out.print("enter:");
        char c;
        try {
             c = (char) cons.reader().read();
        } catch(Exception e) {
            return;
        }
        System.out.println("got it");
        System.out.print("value: "+ (int)c + "char:" + c);
    }
    public static void main(String[] args)
    {
        get_char_internal();
    }
}