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
		if(abs(x_in - x_end) > 1 && 0 == abs(y_in - y_end) && y_in == 7)//castling
		{
			if(x_in == 4 && y_in == 7 && x_end == 1 && y_end == 7)
			{
				if(board_in[7][0] == pieces.wrook && board_in[7][1] == pieces.blank && board_in[7][2] == pieces.blank)
					return true;
			}
			else if(x_in == 4 && y_in == 7 && x_end == 6 && y_end == 7)//| x_end == 5)
			{
				if(board_in[7][7] == pieces.wrook && board_in[7][6] == pieces.blank && board_in[7][5] == pieces.blank && board_in[7][4] == pieces.wking)
					return true;
			}
			return false;
		}
		if (on_board(x_end,y_end))
		{
			if(abs(y_in - y_end) > 1)
				return false;
			if(abs(x_in - x_end) > 1)
				return false;
			if(is_black(board_in[y_end][x_end]) || board_in[y_end][x_end] == pieces.blank)
			{
				if(abs(y_in - y_end) == 1 && (abs(x_in -x_end) == 1 || abs(x_in -x_end) == 0))
					return true;
				if(abs(y_in - y_end) == 0 && abs(x_in -x_end) == 1)
					return true;
			}
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
		if(abs(x_in - x_end) > 1 && 0 == abs(y_in - y_end) && y_in == 0)//castling
		{
			if(x_in == 3 && y_in == 0 && (x_end == 1) && y_end == 0 )
			{
				if(board_in[0][0] == pieces.wrook && board_in[0][1] == pieces.blank && board_in[0][2] == pieces.blank)
					return true;
			}
			else if(x_in == 3 && y_in == 0 && (x_end == 5) && y_end == 0 )//| x_end == 5)
			{
				if(board_in[0][7] == pieces.wrook && board_in[0][6] == pieces.blank && board_in[0][5] == pieces.blank && board_in[0][4] == pieces.blank)
					return true;
			}
			return false;
		}
		if(abs(y_in - y_end) > 1)
				return false;
			if(abs(x_in - x_end) > 1)
				return false;
		//assert(false);
		if (on_board(x_end,y_end))
			if(is_white(board_in[y_end][x_end]) || board_in[y_end][x_end] == pieces.blank)
				if(abs(y_in - y_end) == 1 || abs(x_in -x_end) == 1)
					return true;
		return false;
	}

	public static boolean white(int[][] board_in, int x_in, int y_in, int x_end, int y_end)
	{
		//assert(false);
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
		//assert(false);
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
	
	public static boolean validinternal_all(board board_in,move move_in)
	{
		if(validinternal(board_in,move_in))
		{
			boolean to_move = determine_white_to_move(board_in,move_in);
			scored_board temp = new scored_board(board_in.copy_board(board_in));
			temp.apply_move(move_in);
			if(check_for_check(temp,to_move))
				return false;
			//check_for_checkmate(temp,to_move);
			return true;
		}
		return false;
	}
	public static boolean determine_white_to_move(board board_in,move move_in)
	{
		int y = move_in.get_y_in();
		int x = move_in.get_x_in();
		if(valid.is_white(board_in.toArray()[y][x]))
		{
			return true;
		}
		return false;
	}
	public static boolean check_for_stalemate(scored_board board_in,boolean white_to_moveq)
	{
		System.out.println("value"+positon_eval_valid.eval(board_in,white_to_moveq,1,null,0).get_value());
		if(positon_eval_valid.eval(board_in,white_to_moveq,1,null,0).get_value() == positon_eval_valid.special)
		{
			//stalemate
			return true;
		}
		return false;
	}
	public static boolean check_for_checkmate(scored_board board_in,boolean white_to_moveq)
	{
		// System.out.println("value:"+positon_eval_valid.eval(board_in,white_to_moveq,2,null,0).get_value());
		// System.out.println("value2:"+positon_eval_valid.eval(board_in,white_to_moveq,2,null,0).get_value());
		if(positon_eval_valid.eval(board_in,white_to_moveq,2,null,0).get_value() <= -900.0 || positon_eval_valid.eval(board_in,white_to_moveq,2,null,0).get_value() >= 900.0)
		{
			return true;
			//checkmate
		}
		return false;
	}
	public static boolean check_for_check(scored_board board_in,boolean white_to_moveq)
	{
		//System.out.print("value:"+positon_eval_valid.eval(board_in,!white_to_moveq,1,null,0).get_value());
		if(positon_eval_valid.eval(board_in,!white_to_moveq,1,null,0).get_value() <= -900.0 || positon_eval_valid.eval(board_in,!white_to_moveq,1,null,0).get_value() >= 900.0)
		{
			//check
			return true;
		}
		return false;
	}
}
