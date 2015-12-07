import java.io.Console;
public class get_char
{
    public static void get_char_internal()
    {
        // try 
        // {
        //     String[] cmd = {"/bin/sh", "-c", "stty raw </dev/tty"};
        //     Runtime.getRuntime().exec(cmd).waitFor();
        // }
        // catch (Exception e) 
        // {
        //     return;
        // }
        Curses curses = new Curses();
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