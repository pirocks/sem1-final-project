import java.io.Console;
public class combinedCurses
{
    private highlighted_board Board;
    private Curses curses;
    private class current
    {
        private String[] message;
        private String[] board_string;
        public current(String[] message,String[] board_string)
        {
            this.message = utils.string_aray_copy(message);
            this.board_string = utils.string_aray_copy(board_string);
        }
    }
    current Current;
    private String[] message;
    private String[] board_string;
    public enum inputs
    {
        left,
        right,
        up,
        down,
        enter,
        quit,
        help,
        other,
    }
    //begin input stuff
        public String get_char_internal(String prompt)
        {
            System.out.print(prompt);
            Console cons = System.console();
            String out = "";
            try {
                out += (char) cons.reader().read();
                if(out.charAt(out.length() - 1) == (char)27)
                {
                    out += (char) cons.reader().read();
                    out += (char) cons.reader().read();
                }
            } catch(Exception e) {
                System.out.println("exception");
                assert(false);
                //return null;
            }
            //System.out.println("\ngot it");
            //System.out.println("value:" + out);
            // curses.fix_the_terminal();
            // for(int i =0; i < out.length();i++)
            //     System.out.println("char #"+ i +":" + (int)(out.charAt(i)));
            // curses.fix_the_terminal();
            System.out.print(curses.delete_line);
            return out;
        }
        public inputs get_input()
        {
            String in = get_char_internal("");
            if(in.equals("\024"))
                System.exit(1);
            if(in.equals("h"))
                return inputs.help;
            if(in.equals("q"))
                return inputs.quit;
            if(in.equals("\003"))
                return inputs.quit;
            if(in.equals(""+(char)27+(char)91+(char)68))
            {
                //System.out.print("left");
                return inputs.left;
            }
            if(in.equals(""+(char)27+(char)91+(char)67))
            {
                //System.out.print("right");
                return inputs.right;
            }
            if(in.equals(""+(char)27+(char)91+(char)65))
            {
                //System.out.print("up");
                return inputs.up;
            }
            if(in.equals(""+(char)27+(char)91+(char)66))
            {
                //System.out.print("down");
                return inputs.down;
            }
            if(in.equals("\n"))
            {
                //System.exit(0);
                return inputs.enter;
            }
            if(in.equals("\015"))
            {
                //System.exit(0);
                return inputs.enter;
            }
            return inputs.other;
        }
        public inputs get_input(String prompt)
        {
            String in = get_char_internal(prompt);
            if(in.equals("\024"))
                System.exit(1);
            if(in.equals("h"))
                return inputs.help;
            if(in.equals("q"))
                return inputs.quit;
            if(in.equals("\003"))
                return inputs.quit;
            if(in.equals("\027\091\068"))
                return inputs.left;
            if(in.equals("\027\091\067"))
                return inputs.right;
            if(in.equals("\027\091\065"))
                return inputs.up;
            if(in.equals("\027\091\066"))
                return inputs.down;
            return inputs.other;
        }
    //end input stuff
    public combinedCurses(highlighted_board in,String[] message)
    {
        Board = in;
        curses = new Curses();
        board_string = utils.create_fancy_board(Board);
        this.message = message;
        Current = new current(message,board_string);
        full();
    }
    public void update_message(String[] in)
    {
        message = in;
    }
    public void set_board(highlighted_board in)
    {
        Board = in;
    }
    //begin display stuff
        public void full()
        {
            raw_mode.leave_raw();
            System.out.print(curses.clear_screen);
            for(int i =0; i < board_string.length;i++)System.out.println(board_string[i]);
            for(int i =0;i < message.length;i++)System.out.println(message[i]);
            raw_mode.enter_raw();
        }
        public void update()
        {
            raw_mode.leave_raw();
            update_board();
            update_message();
            //for(int i =0; i < utils.create_fancy_board(Board).length;i++)System.out.println(utils.create_fancy_board(Board)[i]);
            //System.out.println("updateing");//assert(false);
            //utils.display_fancy_board(Board);
            //System.out.println("length:"+utils.create_fancy_board(Board).length);
            //System.out.print(curses.clear_screen);
            //full();
            raw_mode.enter_raw();
        }
        public void update_board()
        {
            
            System.out.print(curses.exit_insert_mode);
            System.out.print(curses.cursor_home);
            board_string = utils.create_fancy_board(Board);
            String[] differences = diff_board(board_string);
            for(int i = 0; i < differences.length;i++)
            {
                if(differences[i] != null)
                {
                    //System.out.print(curses.delete_line);
                    System.out.print(differences[i]);
                }
                System.out.print(curses.newline);
            }
            Current.board_string = utils.string_aray_copy(board_string);
        }
        public void update_message()
        {
            System.out.print(curses.exit_insert_mode);
            String[] differences = diff_message(message);
            for(int i = 0; i < differences.length;i++)
            {
                if(differences[i] != null)
                {
                    System.out.print(curses.delete_line);
                    System.out.print(differences[i]);
                }
                System.out.print(curses.newline);
            }
            Current.message = utils.string_aray_copy(message);
        }
        private String[] diff_message(String[] in)
        {
            assert(Current.message.length == in.length);
            String out[] = new String[in.length];
            for(int i = 0; i < in.length; i++)
            {
                if(!(Current.message[i].equals(in[i])))
                    out[i] = in[i];
                else
                    out[i] = null;
            }
            return out;
        }
        private String[] diff_board(String[] in)
        {
            assert(Current.board_string.length == in.length);
            String out[] = new String[in.length];
            for(int i = 0; i < in.length; i++)
            {
                if(!(Current.board_string[i].equals(in[i])))
                    out[i] = in[i];
                else
                    out[i] = null;
            }
            return out;
        }
    //end display stuff
    public static class raw_mode
    {
        public static void enter_raw()
        {
            try
            {
                String[] stuff = {"/bin/sh", "-c", "stty raw </dev/tty"};
                Runtime.getRuntime().exec(stuff).waitFor();
            }
            catch(Exception e)
            {
                return;
            }
            return;
        }
        public static void leave_raw()
        {
            try
            {
                String[] stuff = {"/bin/sh", "-c", "stty sane </dev/tty"};
                Runtime.getRuntime().exec(stuff).waitFor();
            }
            catch(Exception e)
            {
                return;
            }
            return;
        }
    };
    //begin higher level stuff higher_level_stuff
        public int[] get_piece_coordinates(String[] message_piece,int x_in,int y_in)
        {
            raw_mode.enter_raw();
            int x = x_in;
            int y = y_in;
            boolean exit = false;
            assert(message_piece.length == 4);
            update_message(message_piece);
            inputs current = inputs.other;
            while(exit != true)
            {
                board_string = utils.create_fancy_board(Board);
                update();
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
                        if(y > 0)
                            y--;
                        break;
                    case down:
                        if(y < 7)
                            y++;
                        break;
                    case enter:
                        exit = true;
                        break;
                    case quit:
                        System.out.print("quiting");
                        raw_mode.leave_raw();
                        System.exit(1);
                        break;
                    case other:
                        {}
                        break;
                    default:
                        {}
                        break;
                }
                Board.update_valids(x,y);
            }
            Board.set_prevselected(x,y);
            return new int[] {x,y};
        }
        public int[] get_move_coordinates(String[] message_move,int x_in,int y_in)
        {
            raw_mode.enter_raw();
            Board.set_prevselected(x_in,y_in);
            update();
            int x = x_in;
            int y = y_in;
            boolean exit = false;
            assert(message_move.length == 4);
            update_message(message_move);
            inputs current = inputs.other;
            while(exit != true)
            {
                Board.set_prevselected(x_in,y_in);
                update();
                board_string = utils.create_fancy_board(Board);
                update();
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
                    case down:
                        if(y < 7)
                            y++;
                        break;
                    case up:
                        if(y > 0)
                            y--;
                        break;
                    case enter:
                        exit = true;
                        break;
                    case quit:
                        System.out.print("quiting");
                        raw_mode.leave_raw();
                        System.exit(1);
                        break;
                    case other:
                        {}
                        break;
                    default:
                        {}
                        break;
                }
                Board.update_valids(x_in,y_in);
                Board.set_selected(x,y);
            }
            Board.clean_prevselected();
            update();
            return new int[] {x,y};
        }
        public void write_message(String[] in)
        {
            assert(in.length == 4);
            update_message(in);
            update();
        }
        public void write_board(highlighted_board in)
        {
            set_board(in);
            update();
        }
    //end higher level stuff
}