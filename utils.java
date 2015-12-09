public class utils
{
    public static final int blank =   0;
	public static final int wking =   1;
	public static final int wqueen =  2;
	public static final int wrook =   3;
	public static final int wbishop = 4;
	public static final int wknight = 5;
	public static final int wpawn =   6;
	public static final int bking =   7;
	public static final int bqueen =  8;
	public static final int brook =   9;
	public static final int bbishop = 10;
	public static final int bknight = 11;
	public static final int bpawn =   12;
    public static board defualt_board = new board(new int[][] {
	    {brook,bknight,bbishop,bqueen,bking,bbishop,bknight,brook},
	    {bpawn,bpawn,bpawn,bpawn,bpawn,bpawn,bpawn,bpawn},
	    {blank,blank,blank,blank,blank,blank,blank,blank},
	    {blank,blank,blank,blank,blank,blank,blank,blank},
	    {blank,blank,blank,blank,blank,blank,blank,blank},
	    {blank,blank,blank,blank,blank,blank,blank,blank},
	    {wpawn,wpawn,wpawn,wpawn,wpawn,wpawn,wpawn,wpawn},
	    {wrook,wknight,wbishop,wqueen,wking,wbishop,wknight,wrook},
    }
    );
    public static final String BLACK = "[0m";
    public static final String RED = "[31m";
    public static final String GREEN = "[32m";
    public static final String YELLOW = "[33m";
    public static final String BLUE = "[34m";
    public static final String MAGENTA = "[35m";
    public static final String CYAN = "[36m";
    public static final String WHITE = "[37m";
    public static final String RESET = "\033[0m";
    //public static Curses global_curses;
    public static void display_fancy_board(board board_in)
    {
        String background;
		int piece;
		for(int y = 0; y < 8;y++)
		{
		    System.out.print(RESET);
		    System.out.print("|");
			for(int x = 0; x < 8;x++)
			{
			    if((x + y) % 2 == 0)
    				background = "\033[47m";
    			else
    				background = "\033[40m";
    			System.out.print(background);
				piece = board_in.toArray()[y][x];
				if(valid.is_black(piece))
				{
				    System.out.print(BLUE);
				    switch(piece)
				    {
				        case pieces.black.king:
				            System.out.print("BK");
				            break;
				        case pieces.black.knight:
				            System.out.print("BN");
				            break;
				        case pieces.black.bishop:
				            System.out.print("BB");
				            break;
				        case pieces.black.pawn:
				            System.out.print("BP");
				            break;
				        case pieces.black.queen:
				            System.out.print("BQ");
				            break;
				        case pieces.black.rook:
				            System.out.print("BR");
				            break;
				        default:
				            assert(false);
				            return;
				    }
				}
				else if(valid.is_white(piece))
				{
				    System.out.print(RED);
				    switch(piece)
				    {
				        case pieces.white.king:
				            System.out.print("WK");
				            break;
				        case pieces.white.knight:
				            System.out.print("WN");
				            break;
				        case pieces.white.bishop:
				            System.out.print("WB");
				            break;
				        case pieces.white.pawn:
				            System.out.print("WP");
				            break;
				        case pieces.white.queen:
				            System.out.print("WQ");
				            break;
				        case pieces.white.rook:
				            System.out.print("WR");
				            break;
				        default:
				            assert(false);
				            return;
				    }
				}
				else
				{
				    System.out.print("  ");
				    assert(piece == blank);
				}
			}
			System.out.print(RESET);
			System.out.print("|\n");
		}
		System.out.print(RESET);
		
    }
    public static String[] create_fancy_board(board board_in)
    {
    	int out_i = 0;
    	String[] out = new String[8];
    	for(int i = 0; i < 8;i++)
    	{
    		out[i] = "";
    	}
    	String background;
		int piece;
		for(int y = 0; y < 8;y++)
		{
			out[out_i] += RESET;
		    out[out_i] += "|";
			for(int x = 0; x < 8;x++)
			{
			    if((x + y) % 2 == 0)
    				background = "\033[47m";
    			else
    				background = "\033[40m";
    			out[out_i] += background;
				piece = board_in.toArray()[y][x];
				if(valid.is_black(piece))
				{
				    out[out_i] += BLUE;
				    switch(piece)
				    {
				        case pieces.black.king:
				            out[out_i] += ("BK");
				            break;
				        case pieces.black.knight:
				            out[out_i] += ("BN");
				            break;
				        case pieces.black.bishop:
				            out[out_i] += ("BB");
				            break;
				        case pieces.black.pawn:
				            out[out_i] += ("BP");
				            break;
				        case pieces.black.queen:
				            out[out_i] += ("BQ");
				            break;
				        case pieces.black.rook:
				            out[out_i] += ("BR");
				            break;
				        default:
				            assert(false);
				            return null;
				    }
				}
				else if(valid.is_white(piece))
				{
				    out[out_i] += RED;
				    switch(piece)
				    {
				        case pieces.white.king:
				            out[out_i] += ("WK");
				            break;
				        case pieces.white.knight:
				            out[out_i] += ("WN");
				            break;
				        case pieces.white.bishop:
				            out[out_i] += ("WB");
				            break;
				        case pieces.white.pawn:
				            out[out_i] += ("WP");
				            break;
				        case pieces.white.queen:
				            out[out_i] += ("WQ");
				            break;
				        case pieces.white.rook:
				            out[out_i] += ("WR");
				            break;
				        default:
				            assert(false);
				            return null;
				    }
				}
				else
				{
				    out[out_i] += "  ";
				    assert(piece == blank);
				}
			}
			out[out_i] += RESET;
			out[out_i] += "|";
			out_i++;
		}
		out_i--;
		out[out_i] += RESET;
		return out;
    }
    public static String[] create_fancy_board(highlighted_board board_in)
    {
    	//System.out.print("highlighted_board");
    	highlight_locations locs = new highlight_locations(board_in);
    	//System.out.println(locs.toString());
    	int out_i = 0;
    	String[] out = new String[8];
    	for(int i = 0; i < 8;i++)
    	{
    		out[i] = "";
    	}
    	String background;
		int piece;
		for(int y = 0; y < 8;y++)
		{
			out[out_i] += RESET;
		    out[out_i] += "|";
			for(int x = 0; x < 8;x++)
			{
			    if((x + y) % 2 == 0)
    				background = "\033[47m";
    			else
    				background = "\033[40m";
    			out[out_i] += background;
    			int x_i,y_i;
				piece = board_in.toArray()[y][x];
				if(valid.is_black(piece))
				{
				    out[out_i] += BLUE;
				    x_i = find(locs.x_locs,x);
	    			y_i = find(locs.x_locs,y);
	    			// System.out.println("x_i:"+x_i+"y_i:"+y_i+"x:"+x+"y:"+y);
	    			if( x_i != -1 && y_i != -1 && x_i == y_i){
	    				out[out_i] += locs.colors[x_i];
	    				//System.out.println("caught");
	    			}
				    switch(piece)
				    {
				        case pieces.black.king:
				            out[out_i] += ("BK");
				            break;
				        case pieces.black.knight:
				            out[out_i] += ("BN");
				            break;
				        case pieces.black.bishop:
				            out[out_i] += ("BB");
				            break;
				        case pieces.black.pawn:
				            out[out_i] += ("BP");
				            break;
				        case pieces.black.queen:
				            out[out_i] += ("BQ");
				            break;
				        case pieces.black.rook:
				            out[out_i] += ("BR");
				            break;
				        default:
				            assert(false);
				            return null;
				    }
				}
				else if(valid.is_white(piece))
				{
				    out[out_i] += RED;
				    x_i = find(locs.x_locs,x);
	    			y_i = find(locs.x_locs,y);
	    			if( x_i != -1 && y_i != -1 && x_i == y_i){
	    				out[out_i] += locs.colors[x_i];
	    				//System.out.println("caught");
	    			}
				    switch(piece)
				    {
				        case pieces.white.king:
				            out[out_i] += ("WK");
				            break;
				        case pieces.white.knight:
				            out[out_i] += ("WN");
				            break;
				        case pieces.white.bishop:
				            out[out_i] += ("WB");
				            break;
				        case pieces.white.pawn:
				            out[out_i] += ("WP");
				            break;
				        case pieces.white.queen:
				            out[out_i] += ("WQ");
				            break;
				        case pieces.white.rook:
				            out[out_i] += ("WR");
				            break;
				        default:
				            assert(false);
				            return null;
				    }
				}
				else
				{
				    out[out_i] += "  ";
				    assert(piece == blank);
				}
			}
			out[out_i] += RESET;
			out[out_i] += "|";
			out_i++;
		}
		out_i--;
		out[out_i] += RESET;
		return out;
    }
    public static void sleep(int in)
    {
    	try {
            Thread.sleep(in);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    public static String[] string_aray_copy(String[] in)
    {
    	String[] out = new String[in.length];
    	for(int i = 0;i < in.length;i++)
    	{
    		out[i] = new String(in[i]);
    	}
    	return out;
    }
    public static int find(int[] haystack,int needle)
    {
    	for(int i = 0;i < haystack.length;i++)
    	{
    		if(haystack[i] == needle)
    			return i;
    	}
    	return -1;
    }
}