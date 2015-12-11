public class highlighted_board extends board
{
    public enum states
    {
        blank,
        selected,
        move_valid,
        flashing_check,
        previously_selected,
    }
    private states[][] highlights;
    public highlighted_board(int[][] in)
    {
        super(in);
        highlights = new states[8][8];
        for(int y = 0; y < 8; y++)
            for(int x = 0; x < 8; x++)
                highlights[y][x] = states.blank;
    }
    public void update_valids(int x_in,int y_in)
    {
        for(int y = 0; y < 8;y++)
            for (int x = 0;x < 8 ;x++ ) 
                if(highlights[y][x] != states.previously_selected)
                    highlights[y][x] = states.blank;
        highlights[y_in][x_in] = states.selected;
        for(int y = 0; y < 8; y++)
            for(int x = 0; x < 8; x++)
                if(valid.validinternal(this.toArray(),x_in,y_in,x,y))
                    highlights[y][x] = states.move_valid;
    }
    public void set_selected(int x,int y)
    {
        highlights[y][x] = states.selected;
    }
    public void set_prevselected(int x,int y)
    {
        clean_prevselected();
        highlights[y][x] = states.previously_selected;
    }
    public highlighted_board(int[][] in, states[][] states_in)
    {
        super(in);
        highlights = states_in;
    }
    public states get(int y, int x)
    {
        return highlights[y][x];
    }
    public void clean_prevselected()
    {
        for (int y =0; y < highlights.length ;y++ )
            for (int x =0;x < highlights[0].length ;x++ )
                if(highlights[y][x] == states.previously_selected)
                    highlights[y][x] = states.blank;
    }
}