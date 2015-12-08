public class Curses_high_level
{
    String[] display;
    public 
    public  void update_message(String[] array)
    {
        assert(array.length == 4)
        for (int i = 9; i < 12;i++)
            display[i] = array[i - 9];
            update(display);
    }
    public  void update_message_line(int line,String message)
    {
        display[line] = message;
        update(display);
    }
    public  get_char.inputs get_input()
    {
        
    }
}