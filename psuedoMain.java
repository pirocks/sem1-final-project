public class psuedoMain
{
    public static void main(String[] args)
    {
        //ned to add try loop n init to aviod fatal errors
        Curses curses = new Curses();
        System.out.print(curses.clear_screen);
        System.out.print(curses.exit_insert_mode);
        //System.out.print("\n\n\n\n\n\n\n\n\n\n\n");
        //for(int i =0; i < 20;i++)System.out.print(curses.cursor_up);
        System.out.print(curses.cursor_invisible);
        System.out.print("hola");
        System.out.print(curses.exit_insert_mode);
        //System.out.print(curses.insert_line);
        System.out.print(curses.cursor_home);
        System.out.print("hola2");
        System.out.print(curses.cursor_home);
        System.out.print(curses.delete_character);
        System.out.print(" ");
        System.out.print(curses.delete_character);
        System.out.print(" ");
        //System.out.print(curses.delete_line);
        try {
            Thread.sleep(1000000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}