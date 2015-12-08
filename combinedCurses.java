public class combinedCurses
{
    private highlighted_board Board;
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
    class input_methods
    {
        public static String get_char_internal(String prompt)
        {
            System.out.print(prompt);
            Curses curses;
            if(utils.global_curses == null)
            {
                curses = new Curses();
                utils.global_curses = curses;
            }
            else
                curses = utils.global_curses;
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
            return out;
        }
        public static inputs get_input()
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
        public static inputs get_input(String prompt)
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
    }
    public combinedCurses(highlighted_board in)
    {
        
    }
    public inputs get_input()
    {
        return input_methods.get_input()
    }
}