public class psuedoMain
{
    public static void main(String[] args)
    {
        //ned to add try loop n init to aviod fatal errors
        Curses curses = new Curses();
        System.out.print(curses.clear_screen);
        //System.out.print(curses.exit_insert_mode);
        //System.out.print(curses.enter_alt_charset_mode);
        System.out.print(curses.enter_ca_mode);
        System.out.print("");
        //System.out.print(curses.key_up);
        
        System.out.print(curses.cursor_up);
        System.out.print(curses.cursor_up);
        System.out.print(curses.cursor_up);
        System.out.print(curses.cursor_up);
        System.out.print(curses.cursor_up);
        System.out.print(curses.cursor_up);
        System.out.print(curses.cursor_down);
        //System.out.print(curses.parm_down_cursor);
        try {
            Thread.sleep(1000000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}