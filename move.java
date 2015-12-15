
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
    public board apply_move(board board_in_object)
    {
        int[][] board_in = board_in_object.toArray();
        //assert(valid.validinternal(board_in,this));
        boolean castlingq = false;
        boolean right_castleq = false;
        if(board_in[y_in][x_in] == pieces.wking)if(Math.abs(x_in - x_end) > 1 && 0 == Math.abs(y_in - y_end) && y_in == 7)//castling
		{
			if(x_in == 4 && y_in == 7 && x_end == 1 && y_end == 7)
			{
				if(board_in[7][0] == pieces.wrook && board_in[7][1] == pieces.blank && board_in[7][2] == pieces.blank)
				{
					castlingq = true;
					right_castleq = false;
				}
			}
			else if(x_in == 4 && y_in == 7 && x_end == 6 && y_end == 7)//| x_end == 5)
			{
				if(board_in[7][7] == pieces.wrook && board_in[7][6] == pieces.blank && board_in[7][5] == pieces.blank && board_in[7][4] == pieces.wking)
				{
					castlingq = true;
					right_castleq = true;
				}
			}
		}
		if(board_in[y_in][x_in] == pieces.bking)if(Math.abs(x_in - x_end) > 1 && 0 == Math.abs(y_in - y_end) && y_in == 0)//castling
		{
			if(x_in == 3 && y_in == 0 && (x_end == 1) && y_end == 0 )
			{
				if(board_in[0][0] == pieces.brook && board_in[0][1] == pieces.blank && board_in[0][2] == pieces.blank)
				{
					castlingq = true;
					right_castleq =  false;
				}
			}
			else if(x_in == 3 && y_in == 0 && (x_end == 5) && y_end == 0 )//| x_end == 5)
			{
				if(board_in[0][7] == pieces.brook && board_in[0][6] == pieces.blank && board_in[0][5] == pieces.blank && board_in[0][4] == pieces.blank)
				{
					castlingq = true;
			        right_castleq =  true;
				}    
			}
		}
		if(castlingq)
		{
		    int piece = board_in[y_in][x_in];
        	board_in[y_end][x_end] = piece;
        	board_in[y_in][x_in] = pieces.blank;
        	if(right_castleq)
        	    return (new board(board_in)).apply_move(new move(7,y_in,5,y_in));
        	else
        	    return (new board(board_in)).apply_move(new move(0,y_in,1,y_in));
		}
        else
        {
        	int piece = board_in[y_in][x_in];
        	board_in[y_end][x_end] = piece;
        	board_in[y_in][x_in] = pieces.blank;
        }
        return new board(board_in);
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
    public int getPiece(board in)
    {
        return in.toArray()[y_in][x_in];
    }
    public String toString()
    {
        return("move: x_start: " + this.get_x_in() + " y_start: " + this.get_y_in() 
        + " x_end: " + this.get_x_end() + "  y_end: " + this.get_y_end());
    }
}
