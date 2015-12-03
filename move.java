public class move
{
    private int x_in;
    private int y_in;
    private int x_end;
    private int y_end;
    private boolean castlingq;
    
    public move(int x_in, int y_in, int x_end,int y_end,boolean castlingq)
    {
        this.x_in = x_in;
        this.y_in = y_in;
        this.x_end = x_end;
        this.y_end = y_end;
        this.castlingq = castlingq;
    }
    
    public move(int x_in, int y_in, int x_end,int y_end)
    {
        this.x_in = x_in;
        this.y_in = y_in;
        this.x_end = x_end;
        this.y_end = y_end;
        this.castlingq = false;
    }
    public move(int[] moves)
    {
        assert(moves.length == 4);
        this.x_in = moves[0];
        this.y_in = moves[1];
        this.x_end = moves[2];
        this.y_end = moves[3];
    }
    public move(move in)
    {
        this.x_in = in.get_x_in();
        this.y_in = in.get_y_in();
        this.x_end = in.get_x_end();
        this.y_end = in.get_y_end();;
    }
    public board apply_move(board board_in)
    {
        assert(valid.validinternal(board_in,this));
    	int piece = (board_in).getPiece(y_in, x_in);
		(board_in).setPiece(y_end, x_end,piece);
		(board_in).setPiece(y_in, x_in,pieces.blank);
		return board_in;
    }
    public int get_x_in()
    {
        return x_in;
    }
    public int get_y_in()
    {
        return y_in;
    }
    public int get_x_end()
    {
        return x_end;
    }
    public int get_y_end()
    {
        return y_end;
    }
    public int[] get_start()
    {
        int [] out = new int[2];
        out[0] = x_in;
        out[1] = y_in;
        return out;
    }
    public int[] get_end()
    {
        int [] out = new int[2];
        out[0] = x_end;
        out[1] = y_end;
        return out;
    }
}
