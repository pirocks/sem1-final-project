
public class board {
	protected int boardValue[][] = new int[8][8];
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
	public board apply_move(move move_in)
	{
		assert(valid.validinternal(this,move_in));
		return move_in.apply_move(this);
	}
	public boolean valid_move(board board_in,move move_in)
	{
		if (valid.validinternal(board_in,move_in))
		{
			move_in.apply_move(board_in);
			return true;
		}
		else
			return false;
	}
	public boolean valid_move(move move_in)
	{
		if (valid.validinternal(this,move_in))
		{
			move_in.apply_move(this);
			return true;
		}
		else
			return false;
	}

}

