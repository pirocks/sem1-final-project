public class Curses_high_level
{
    String[] display;
    public class void update_board(board in)
    {
        curses.board_update(in);
    }
    public class void update_message(String[] array)
    {
        assert(array.length == 4)
        for (int i = 9; i < 12;i++)
            display[i] = array[i - 9];
    }
    public class void update_message_line(int line)
    {
        
    }
}