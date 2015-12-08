public class Curses_high_level
{
    String[] display;
    highlighted_board localboard
    Curses_interface intface;
    public Curses_high_level()
    {
        intface = new Curses_interface();
    }
    public void update_message(String[] array)
    {
        assert(array.length == 4)
        for (int i = 9; i < 12;i++)
            display[i] = array[i - 9];
        intface.update(display);
    }
    public void update_message_line(int line,String message)
    {
        display[line] = message;
        intface.update(display);
    }
    public get_char.inputs get_input(String[] message)
    {
        update_message(message);
        get_char.get_input("")
    }
    public void board_update()
    {
        String[] temp = utils.create_fancy_board(localboard)
        for(int i = 0; i < temp.length;i++)
            display[i] = temp[i];
        
    }
    public int[] get_piece_coordinates(String[] message_piece)
    {
        int x = 0;
        int y = 0;
        boolean exit = false;
        assert(message.length == 4);
        update_message(message_piece);
        get_char.inputs current = inputs.other;
        while(exit != true)
        {
            board_update();
            current = get_input();
            switch(current)
            {
                case left:
                    if(x > 0)
                        x--;
                    break;
                case right:
                    if(x < 7)
                        x++;
                    break;
                case up:
                    if(y < 7)
                        y++;
                    break;
                case down:
                    if(y > 0)
                        y--;
                    break;
                case enter:
                    exit = true;
                    break;
                case quit:
                    System.exit(1);
                    break;
                case other:
                    {}
                    break;
                default:
                    {}
                    break;
            }
            update_valids(x,y);
        }
        return new int[] {x,y};
    }
    public int[] get_move_coordinates(String[] message_move,int x_in,int y_in)
    {
        int x = 0;
        int y = 0;
        boolean exit = false;
        assert(message.length == 4);
        update_message(message_piece);
        get_char.inputs current = inputs.other;
        while(exit != true)
        {
            board_update();
            current = get_input();
            switch(current)
            {
                case left:
                    if(x > 0)
                        x--;
                    break;
                case right:
                    if(x < 7)
                        x++;
                    break;
                case up:
                    if(y < 7)
                        y++;
                    break;
                case down:
                    if(y > 0)
                        y--;
                    break;
                case enter:
                    exit = true;
                    break;
                case quit:
                    System.exit(1);
                    break;
                case other:
                    {}
                    break;
                default:
                    {}
                    break;
            }
            update_valids(x_in,y_in);
            update_valids(x,y);
        }
        return new int[] {x,y};
    }
}