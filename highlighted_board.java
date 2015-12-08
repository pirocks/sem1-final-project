public class highlighted_board extends board
{
    public enum states
    {
        blank,
        selected,
        move_valid,
        flashing_check,
    }
    private states[][] highlights;
    public highlighted_board()
    {
        highlights = new states[8][8];
        for(int y = 0; y < 8; y++)
            for(int x = 0; x < 8; x++)
                highlights[y][x] = states.blank;
    }
    public void update_valids(board board_in,int x_in,int y_in)
    {
        highlights[y_in][x_in] = states.selected;
        for(int y = 0; y < 8; y++)
            for(int x = 0; x < 8; x++)
                if(valid.validinternal(board_in,x_in,y_in,x,y))
                    highlights[y][x] = states.move_valid;
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
}