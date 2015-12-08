public class highlight_locations
{
    public int current_len = 0;
    public int[] x_locs;
    public int[] y_locs;
    public String[] colors;
    public highlight_locations(int[] x,int[] y,String[] colors)
    {
        assert(x.length == y.length == colors.lentgh);
        x_locs = x;
        y_locs = y;
        this.colors = colors;
    }
    public highlight_locations(int len)
    {
        x_locs = new int[len];
        y_locs = new int[len];
        colors = new String[len];
    }
    public highlight_locations()
    {
        this(64);
    }
    public highlight_locations(highlighted_board in)
    {
        this(64)
        int i = 0;
        String color;
        for(int y = 0; y < in.length; y++)
            for(int x = 0; x < in[0].length;x++)
            {
                color = state_to_string(in.get(y,x));
                if(color != null)
                {
                    x_locs[i] = x;
                    y_locs[i] = y;
                    colors[i] = color;
                }
            }
    }
    public add(int x,int y,String color)
    {
        x_locs[current_len] = x;
        y_locs[current_len] = y;
        colors[current_len] = color;
        current_len++;
    }
    // public String[] state_to_string(highlighted_board.states in)
    // {
    //     switch(in)
    //     {
    //         case highlighted_board.states.blank:
    //             return null;
    //         case highlighted_board.states.selected:
    //             return new String[] {utils.YELLOW,utils.RESET};
    //         case highlighted_board.states.move_valid:
    //             return new String[] {utils.GREEN,utils.RESET};
    //         case highlighted_board.states.flashing_check:
    //             return new String[] {utils.RED,utils.RESET};
    //     }
    // }
    public String state_to_string(highlighted_board.states in)
    {
        switch(in)
        {
            case highlighted_board.states.blank:
                return null;
            case highlighted_board.states.selected:
                return utils.YELLOW;
            case highlighted_board.states.move_valid:
                return utils.GREEN;
            case highlighted_board.states.flashing_check:
                return utils.RED;
        }
    }
}