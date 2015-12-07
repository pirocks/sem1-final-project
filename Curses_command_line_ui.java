public class command_line_ui
{
    public static void ask_for_piece_white(board global_board, boolean aiw, boolean aib)
    {
        if(aiw)
        {
            // //experimental
            // scored_board temp = new scored_board(global_board);
            // move current_move = new move(positon_eval.eval(temp,true,3,null));
            // //do ai moves
            // global_board.apply_move(current_move);
            // ask_for_piece_black(global_board,aiw,aib);
            // //assert(false);
        }
        utils.display_fancy_board(global_board);
        System.out.println("Enter the x coordinate of the white piece you would like to move(integer from 0 to 7):");
        int x = TextIO.getlnInt();
        System.out.println("Enter the y coordinate of the white piece you would like to move(integer from 0 to 7):");
        int y = TextIO.getlnInt();
        if(global_board.getPiece(y,x) == pieces.blank)
        {
            System.out.println("That is not a piece");
            ask_for_piece_white(global_board,aiw,aib);
        }
        if(valid.is_black(global_board.getPiece(y,x)))
        {
            System.out.println("That is a black piece. Please select a white piece");
            ask_for_piece_white(global_board,aiw,aib);
        }
        ask_for_move_white(global_board,aiw,aib,x,y);
    }
    public static void ask_for_move_white(board global_board,boolean aiw, boolean aib,int x, int y)
    {
        System.out.println("Please select the x coordinate of the location you want to move your black piece to.");
        int x_end = TextIO.getlnInt();
        System.out.println("Please select the y coordinate of the location you want to move your black piece to.");
        int y_end = TextIO.getlnInt();
        if(!valid.validinternal(global_board.toArray(),x,y,x_end,y_end))
        {
            System.out.println("That is not a valid move");
            ask_for_piece_white(global_board,aiw,aib);
        }
        move current_move = new move(x,y,x_end,y_end);
        global_board.apply_move(current_move);
        ask_for_piece_black(global_board,aiw,aib);
    }
    public static void ask_for_piece_black(board global_board, boolean aiw, boolean aib)
    {
        if(aib)
        {
            // //experimental
            // scored_board temp = new scored_board(global_board);
            // positon_eval.eval(temp,false,3,null);
            // //do ai moves
            // assert(false);
        }
        utils.display_fancy_board(global_board);
        System.out.println("Enter the x coordinate of the black piece you would like to move(integer from 0 to 7):");
        int x = TextIO.getlnInt();
        System.out.println("Enter the y coordinate of the black piece you would like to move(integer from 0 to 7):");
        int y = TextIO.getlnInt();
        if(global_board.getPiece(y,x) == pieces.blank)
        {
            System.out.println("That is not a piece");
            ask_for_piece_black(global_board,aiw,aib);
        }
        if(valid.is_white(global_board.getPiece(y,x)))
        {
            System.out.println("That is a white piece. Please select a black piece");
            ask_for_piece_black(global_board,aiw,aib);
        }
        ask_for_move_black(global_board,aiw,aib,x,y);
    }
    public static void ask_for_move_black(board global_board,boolean aiw, boolean aib,int x, int y)
    {
        System.out.println("Please select the x coordinate of the location you want to move your black piece to.");
        int x_end = TextIO.getlnInt();
        System.out.println("Please select the y coordinate of the location you want to move your black piece to.");
        int y_end = TextIO.getlnInt();
        if(!valid.validinternal(global_board.toArray(),x,y,x_end,y_end))
        {
            System.out.println("That is not a valid move");
            ask_for_piece_white(global_board,aiw,aib);
        }
        move current_move = new move(x,y,x_end,y_end);
        global_board.apply_move(current_move);
        ask_for_piece_white(global_board,aiw,aib);
    }
}