import java.util.Arrays;
//proofread this it probably needs it
public class scored_board extends board
{
    private double eval;
    public scored_board(int[][] board_in,double eval)
	{
		super(board_in);
	    this.eval = eval;
	}
	//later the board should be able to apply moves in order for eval board to avoid 
	// changing of pieces without updating eval
	public board apply_move(move move_in)
	{
    	update_eval(move_in);
    	return super.apply_move(move_in);
	}
	public boolean valid_move(board board_in,move move_in)
	{
		assert(false);
		if (valid.validinternal(board_in,move_in))
		{
			move_in.apply_move(board_in);
			return true;
		}
		else
			return false;
	}//fix this if using carry
	public boolean valid_move(move move_in)
	{
		assert(false);
		if (valid.validinternal(this,move_in))
		{
			move_in.apply_move(this);
			return true;
		}
		else
			return false;
	}//fix this if usig carry
	public void update_eval(move move_in)
	{
	    //as of now uses slow calculation methods. will fix later.
	    this.eval = white_count(super.boardValue) - black_count(super.boardValue);
	}
	private static double white_count(int[][] board_in)
	{
	    //this is super slow
	    //need to fix
	    int piece;
	    double eval = 0.0;
	    for(int y = 0; y < board_in.length;y++)
	        for(int x = 0; x < board_in[0].length;x++)
	        {
	            piece = board_in[y][x];
	            switch(piece)
	            {
	                case pieces.white.king:
	                    eval += 100.0;
	                    break;
	                case pieces.white.knight:
	                    eval += 3.0;
	                    break;
	                case pieces.white.rook:
	                    eval += 5.0;
	                    break;
	                case pieces.white.queen:
	                    eval += 9.0;
	                    break;
	                case pieces.white.bishop:
	                    eval += 3.0;
	                    break;
	                case pieces.white.pawn:
	                    eval += 1.0;
	                    break;
	            }
	        }
	   return eval;
	}
	private static double black_count(int[][] board_in)
	{
	    //this is super slow
	    //need to fix
	    int piece;
	    double eval = 0.0;
	    for(int y = 0; y < board_in.length;y++)
	        for(int x = 0; x < board_in[0].length;x++)
	        {
	            piece = board_in[y][x];
	            switch(piece)
	            {
	                case pieces.black.king:
	                    eval += 100.0;
	                    break;
	                case pieces.black.knight:
	                    eval += 3.0;
	                    break;
	                case pieces.black.rook:
	                    eval += 5.0;
	                    break;
	                case pieces.black.queen:
	                    eval += 9.0;
	                    break;
	                case pieces.black.bishop:
	                    eval += 3.0;
	                    break;
	                case pieces.black.pawn:
	                    eval += 1.0;
	                    break;
	            }
	        }
	   return eval;
	}
	public double get_eval()
	{
		//assert(white_count(super.boardValue) - black_count(super.boardValue) == eval);
		//enable last assert when enabling carry
		return white_count(super.boardValue) - black_count(super.boardValue);
	}
	public board to_board()
	{
		return new board(super.boardValue);
	}
	public static scored_board copy_board(scored_board source)
	{
		//deepcopy
		int[][] temp = source.toArray();
		int[][] finall = new int[8][8];
		for (int i = 0; i < finall.length; i++)
  			finall[i] = Arrays.copyOf(temp[i], temp[i].length);
		scored_board out = new scored_board(finall,source.get_eval());
		return out;
	}
	public scored_board(board board_in)
	{
		this(board_in.toArray(),white_count(board_in.toArray())-black_count(board_in.toArray()));
	}
}