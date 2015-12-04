public class Curses_interface
{
    public String[] current; 
    public Curses curses;
    public Curses_interface(String[] in)
    {
        curses = new Curses();
        curses.complete_update();
        this.current = in;
    }
    public String diff(String[] in)
    {
        String diff
        for(int i = 0; i < in.length; i++)
        {
            if(!(current[i].equals(in[i])))
            {
                
            }
        }
    }
    public void complete_update()
    {
        System.out.print(curses.clear_screen);
        System.out.print(curses.exit_alt_charset_mode);
        System.out.print(curses.cursor_home);
        System.out.print(curses.cursor_invisible);
    }
}