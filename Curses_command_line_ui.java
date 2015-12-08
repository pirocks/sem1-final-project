public class Curses_command_line_ui
{
    public static void ask_for_piece_white(highlighted_board global_board, boolean aiw, boolean aib,Curses_high_level curses_initq )
    {
        String[] message_piece = new String[]{
            "Select a white piece.",
            "Use the arrow keys.",
            "Use ennter to select",
            ""
        };
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
        int[] piece = curses_initq.get_piece_coordinates(message_piece);
        int x = piece[0];
        int y = piece[1];
        if(global_board.getPiece(y,x) == pieces.blank)
        {
            System.out.println("That is not a piece");
            ask_for_piece_white(global_board,aiw,aib,curses_initq);
        }
        if(valid.is_black(global_board.getPiece(y,x)))
        {
            System.out.println("That is a black piece. Please select a white piece");
            ask_for_piece_white(global_board,aiw,aib,curses_initq);
        }
        ask_for_move_white(global_board,aiw,aib,x,y,curses_initq);
    }
    public static void ask_for_move_white(highlighted_board global_board,boolean aiw, boolean aib,int x, int y,Curses_high_level curses_initq)
    {
        String[] message_move = new String[]{
            "Please select the",
            "location you want",
            "to move to",""
        };
        int[] temp = curses_initq.get_move_coordinates(message_move,x,y);
        int x_end = temp[0];
        int y_end = temp[1];
        if(!valid.validinternal(global_board.toArray(),x,y,x_end,y_end))
        {
            System.out.println("That is not a valid move");
            ask_for_piece_white(global_board,aiw,aib,curses_initq);
        }
        move current_move = new move(x,y,x_end,y_end);
        global_board.apply_move(current_move);
        ask_for_piece_black(global_board,aiw,aib,curses_initq);
    }
    public static void ask_for_piece_black(highlighted_board global_board, boolean aiw, boolean aib,Curses_high_level curses_initq)
    {
        String[] message_piece = new String[]{
            "Select a white piece.",
            "Use the arrow keys.",
            "Use ennter to select",
            ""
        };
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
        int[] piece = curses_initq.get_piece_coordinates(message_piece);
        int x = piece[0];
        int y = piece[1];
        if(global_board.getPiece(y,x) == pieces.blank)
        {
            System.out.println("That is not a piece");
            ask_for_piece_black(global_board,aiw,aib,curses_initq);
        }
        if(valid.is_black(global_board.getPiece(y,x)))
        {
            System.out.println("That is a black piece. Please select a white piece");
            ask_for_piece_black(global_board,aiw,aib,curses_initq);
        }
        ask_for_move_black(global_board,aiw,aib,x,y,curses_initq);
    }
    public static void ask_for_move_black(highlighted_board global_board,boolean aiw, boolean aib,int x, int y,Curses_high_level curses_initq)
    {
        String[] message_move = new String[]{
            "Please select the",
            "location you want",
            "to move to",""
        };
        int[] temp = curses_initq.get_move_coordinates(message_move,x,y);
        int x_end = temp[0];
        int y_end = temp[1];
        if(!valid.validinternal(global_board.toArray(),x,y,x_end,y_end))
        {
            System.out.println("That is not a valid move");
            ask_for_piece_black(global_board,aiw,aib,curses_initq);
        }
        move current_move = new move(x,y,x_end,y_end);
        global_board.apply_move(current_move);
        ask_for_piece_white(global_board,aiw,aib,curses_initq);
    }
}