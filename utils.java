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
    public static void display_fancy_board(board board_in)
    {
        String background;
		int piece;
		for(int y = 0; y < 8;y++)
		{
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
				    assert(false);
				    return;
				}
			}
			System.out.print("|\n");
		}
		System.out.print(RESET);
		
    }
}