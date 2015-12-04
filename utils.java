public class utils
{
    public static final String BLACK = "[0m";
    public static final String RED = "[31m";
    public static final String GREEN = "[32m";
    public static final String YELLOW = "[33m";
    public static final String BLUE = "[34m";
    public static final String MAGENTA = "[35m";
    public static final String CYAN = "[36m";
    public static final String WHITE = "[37m";
    public static final String RESET = "\x1b[0m"
    public static void display_fancy_board(board board_in)
    {
		int piece;
		for(int y = 0; y < 8;y++)
		{
		    System.out.print("|")
			for(int x = 0; x < 8;x++)
			{
				piece = boardValue[y][x]
				if(valid.is_black(piece))
				{
				    switch(piece)
				    {
				        case pieces.black.king:
				            break;
				        case pieces.black.king:
				            break;
				        case pieces.black.king:
				            break;
				        case pieces.black.king:
				            break;
				        case pieces.black.king:
				            break;
				        default:
				            assert(false);
				            return;
				    }
				}
				else if(valid.is_white(piece)
				{
				    switch(piece)
				    {
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
			System.out.print("|\n")
		}
		System.out.print(RESET)
		
    }
}