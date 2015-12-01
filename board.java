
public class board {
	private int boardValue[][] = new int[8][8];
	public board(int[][] board_in)
	{
		boardValue = board_in;
	}
	public int getPiece(int y, int x)
	{
		return boardValue[y][x];
	}
	public void setPiece(int y, int x, int value)
	{
		boardValue[y][x] = value;
	}
	public int[][] toArray()
	{
		return boardValue;
	}
	public board move(board board_in,int x_in, int y_in, int x_end, int y_end, boolean castlingq)
	{
		if (! castlingq)
		{
			int piece = (board_in).getPiece(y_in, x_in);
			(board_in).setPiece(y_end, x_end,piece);
			(board_in).setPiece(y_in, x_in,pieces.blank);
			return board_in;
		}
		else
		{
			return(null);
		}
	}
	public boolean valid_move(board board_in,int x_in, int y_in, int x_end, int y_end, boolean castlingq)
	{
		if (valid.validinternal(board_in.toArray(),x_in,y_in,x_end,y_end))
		{
			move(board_in,x_in,y_in,x_end,y_end,castlingq);
			return true;
		}
		else
			return false;
	}

}

