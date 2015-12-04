public class valid
{
	public static int abs(int input)
	{
		if( input < 0)
			return(-1 * input);
		return(input);
	}
	public static boolean on_board(int x, int y)
	{
		return(x < 8 && y < 8 && x >= 0 && x >= 0);
	}
	public static boolean emptyq(int[][] board_in, int x_in, int y_in) 
	{
		return board_in[y_in][x_in] == pieces.blank  ;
	}

	public static boolean is_white(int piece_in)
	{
		return ((piece_in != 0) && (piece_in < 7));
	}

	public static boolean is_black(int piece_in)
	{
		return (piece_in > 6);
	}

	public static boolean w_pawn(int[][] board_in, int x_in, int y_in, int x_end, int y_end) 
	{
		if (on_board(x_end,y_end))
		{
			if (x_in == x_end)
			{
				if (y_in - y_end == 1)
					return emptyq(board_in,x_end,y_end);
				else if (y_in - y_end == 2)
				{
					if (y_in == 6)
						return emptyq(board_in,x_end,y_end) && emptyq(board_in,x_end,y_end + 1);
				}	
				else
					return false;
			}
			else if (abs(x_in - x_end) == 1)
			{
				if (y_in - y_end == 1)
					if (is_black(board_in[y_end][x_end]))
						return true;
					else
						return false;
				else
					return false;
			}
			else
				return false;
		}
		return false;
	}
	
	public static boolean rook(int[][] board_in, int x_in, int y_in, int x_end, int y_end, boolean whiteq) 
	{
		if (on_board(x_end,y_end))
		{
			if (x_in != x_end && y_in == y_end)
			{
				int current_x = x_in;
				if ((x_end - x_in) == 0)
					return false;
				int change = (x_end - x_in)/abs(x_end - x_in);
				current_x += change;
				while (x_end != current_x)
				{
					if(emptyq(board_in, current_x,y_in))
						{}
					else{
						return false;}
					current_x += change;
				}
				if(whiteq)
				{
					if (emptyq(board_in, x_end,y_in) || is_black(board_in[y_end][x_end]))
						return true;
					else{
						return false;}
				}
				else
				{
					if (emptyq(board_in, x_end,y_in) || is_white(board_in[y_end][x_end]))
						return true;
					else{
						return false;}
				}
			}
			else if (y_in != y_end && x_in == x_end)
			{
				int current_y = y_in;
				if ((y_end - y_in) == 0)
					return false;
				int change = (y_end - y_in)/abs(y_end - y_in);
				current_y += change;
				while (y_end != current_y)
				{
					if(emptyq(board_in, x_in,current_y))
						{}
					else{
						return false;}
					current_y += change;
				}
				if(whiteq)
				{
					if (emptyq(board_in, x_in,y_end) || is_black(board_in[y_end][x_end]))
						return true;
					else{
						return false;}
				}
				else
				{
					if (emptyq(board_in, x_in,y_end) || is_white(board_in[y_end][x_end]))
						return true;
					else{
						return false;}
				}
			}
		}
		return false;
	}

	public static boolean knight(int[][] board_in, int x_in, int y_in, int x_end, int y_end,boolean whiteq) 
	{
		if (whiteq)
		{
			if (on_board(x_end,y_end))
			{
				if (abs(y_end - y_in) == 2 && abs(x_end - x_in) == 1 && ((is_black(board_in[y_end][x_end]) || board_in[y_end][x_end] == pieces.blank  )))
					return true;
				else if (abs(y_end - y_in) == 1 && abs(x_end - x_in) == 2 && ((is_black(board_in[y_end][x_end]) || board_in[y_end][x_end] == pieces.blank  )))
					return true;
			}
		}
		else
		{
			if (on_board(x_end,y_end))
			{
				if (abs(y_end - y_in) == 2 && abs(x_end - x_in) == 1 && ((is_white(board_in[y_end][x_end]) || board_in[y_end][x_end] == pieces.blank  )))
					return true;
				else if (abs(y_end - y_in) == 1 && abs(x_end - x_in) == 2 && ((is_white(board_in[y_end][x_end]) || board_in[y_end][x_end] == pieces.blank  )))
					return true;
			}
		}
		return false;
	}

	public static boolean bishop(int[][] board_in, int x_in, int y_in, int x_end, int y_end,boolean whiteq) 
	{
		if (on_board(x_end,y_end))
		{
			int x_distance = x_end - x_in;
			int y_distance = y_end - y_in;
			if (x_distance == 0 || y_distance == 0)
				return false;
			if (abs(x_distance) == abs(y_distance))
			{
				int current_x = x_in;
				int current_y = y_in;
				int x_change = x_distance / abs(x_distance);
				int y_change = y_distance / abs(y_distance);
				current_x += x_change;
				current_y += y_change;
				while (x_end != current_x)
				{
					if (emptyq(board_in,current_x,current_y))
						{}
					else{
						return false;}
					current_x += x_change;
					current_y += y_change;
				}
				if (whiteq)
				{
					if (emptyq(board_in, x_end,y_end) || is_black(board_in[y_end][x_end]))
						return true;
					else
						return false;
				}
				else
				{
					if (emptyq(board_in, x_end,y_end) || is_white(board_in[y_end][x_end]))
						return true;
					else
						return false;
				}
			}
		}
		return false;
	}

	public static boolean queen(int[][] board_in, int x_in, int y_in, int x_end, int y_end,boolean whiteq) 
	{
		return (rook(board_in, x_in, y_in, x_end, y_end,whiteq) || bishop(board_in, x_in, y_in, x_end, y_end,whiteq) );
	}

	public static boolean w_king(int[][] board_in, int x_in, int y_in, int x_end, int y_end) //castling ! implemented
	{
		if (on_board(x_end,y_end))
		{
			if(is_black(board_in[y_end][x_end]) || board_in[y_end][x_end] == pieces.blank)
				if(abs(y_in - y_end) == 1 || abs(x_in -x_end) == 1)
					return true;
		}
		return false;
	}

	public static boolean b_pawn(int[][] board_in, int x_in, int y_in, int x_end, int y_end) 
	{
		if (on_board(x_end,y_end))
		{
			if (x_in == x_end)
			{
				if (y_end - y_in == 1)
					return emptyq(board_in,x_end,y_end);
				else if (y_end - y_in == 2)
				{
					if (y_in == 1)
						return emptyq(board_in,x_end,y_end) && emptyq(board_in,x_end,y_end - 1);
				}	
				else
					return false;
			}
			else if (abs(x_in - x_end) == 1)
			{
				if (y_end - y_in == 1)
					if (is_white(board_in[y_end][x_end]))
						return true;
					else
						return false;
				else
					return false;
			}
			else
				return false;
		}
		return false;
	}

	public static boolean b_king(int[][] board_in, int x_in, int y_in, int x_end, int y_end) 
	{
		if (on_board(x_end,y_end))
			if(is_white(board_in[y_end][x_end]) || board_in[y_end][x_end] == pieces.blank)
				if(abs(y_in - y_end) == 1 || abs(x_in -x_end) == 1)
					return true;
				else
					{/*printf("distance");*/}
			else
				{/*printf("is white is pieces.blank endpiece:%d\n",board_in[y_end][x_end]);*/}
		else
			{/*printf("on board_in[][]");*/}
		return false;
	}

	public static boolean white(int[][] board_in, int x_in, int y_in, int x_end, int y_end)
	{
		int piece = board_in[y_in][x_in];
		switch(piece)
		{
			case pieces.wpawn:
				return w_pawn(board_in, x_in, y_in, x_end, y_end);
			case pieces.wknight:
				return knight(board_in, x_in, y_in, x_end, y_end,true);
			case pieces.wrook:
				return rook(board_in, x_in, y_in, x_end, y_end,true);
			case pieces.wbishop:
				return bishop(board_in, x_in, y_in, x_end, y_end,true);
			case pieces.wqueen:
				return queen(board_in, x_in, y_in, x_end, y_end,true);
			case pieces.wking:
				return w_king(board_in, x_in, y_in, x_end, y_end);
		}
		return(false);
	}

	public static boolean black(int[][] board_in, int x_in, int y_in, int x_end, int y_end)
	{
		int piece = board_in[y_in][x_in];
		switch(piece)
		{
			case pieces.bpawn:
				return b_pawn(board_in, x_in, y_in, x_end, y_end);
			case pieces.bknight:
				return knight(board_in, x_in, y_in, x_end, y_end,false);
			case pieces.brook:
				return rook(board_in, x_in, y_in, x_end, y_end,false);
			case pieces.bbishop:
				return bishop(board_in, x_in, y_in, x_end, y_end,false);
			case pieces.bqueen:
				return queen(board_in, x_in, y_in, x_end, y_end,false);
			case pieces.bking:
				return b_king(board_in, x_in, y_in, x_end, y_end);
		}
		return(false);
	}

	public static boolean validinternal(int[][] board_in, int x_in, int y_in, int x_end, int y_end)
	{
		try
		{
			int piece = board_in[y_in][x_in];
			if (is_white(piece))
				return(white(board_in, x_in, y_in, x_end, y_end));
			else if (is_black(piece))
				return(black(board_in, x_in, y_in, x_end, y_end));
			return false;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public static boolean validinternal(board board_in, move move_in)
	{
		try {
			int x_in = move_in.get_x_in();
		    int y_in = move_in.get_y_in();
		    int x_end = move_in.get_x_end();
		    int y_end  = move_in.get_y_end();
		    int[][] board_temp = board_in.toArray();
			int piece = board_temp[y_in][x_in];
			if (is_white(piece))
				return(white(board_temp, x_in, y_in, x_end, y_end));
			else if (is_black(piece))
				return(black(board_temp, x_in, y_in, x_end, y_end));
			return false;
		} 
		catch(Exception e) 
		{
			return false;
		}
	}
}
