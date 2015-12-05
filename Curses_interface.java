public class Curses_interface
{
    public int height = 12;
    public String[] current; 
    public Curses curses;
    public Curses_interface(String[] in,int height)
    {
        assert(in.length == 12);
        curses = new Curses();
        curses.complete_update();
        this.current = in;
        this.height = height;
    }
    public Curses_interface()
    {
        this(new String[12],12)
    }
    public String[] diff(String[] in)
    {
        String out[] = new String[height];
        for(int i = 0; i < in.length; i++)
        {
            if(!(current[i].equals(in[i])))
                out[i] = in[i];
            else
                out[i] = null;
        }
        return out;
    }
    public void update(String[] in)
    {
        String[] to_update = diff(in);
        String current;
        for(int i = 0; i < in.length;i++,curses.down)
        {
            current = to_update[i]
            if(current == null)
                continue;
            else
            {
                assert(current.length < 51);
                System.out.print(curses.cursor_down);
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