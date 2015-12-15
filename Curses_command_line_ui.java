public class Curses_command_line_ui
{
    public static void ask_for_piece_white(highlighted_board global_board, boolean aiw, boolean aib,combinedCurses curses_initq,int x_in,int y_in,String[] message_piece)
    {
        if(valid.check_for_checkmate(new scored_board(global_board),true))
        {
            //System.out.println(curses_initq.curses.clear_screen);
            combinedCurses.raw_mode.leave_raw();
            System.out.println("Checkmate");
            System.exit(0);
        }
        if(valid.check_for_stalemate(new scored_board(global_board),true)
        {
            combinedCurses.raw_mode.leave_raw();
            System.out.println("Stalemate");
            System.exit(0);
        }
        if(message_piece == null)
            message_piece = new String[]{"Select a white piece.","Use the arrow keys.","Use enter to select","Hit q to quit"};
        if(aiw)
        {
            //experimental
            scored_board temp = new scored_board(global_board);
            positon_eval_refactor.dot_writers.init();
            curses_initq.write_message(new String[] {"thinking deep and","buggy(hopefully not) ","thoughts....",""});
            move current_move = new move(positon_eval_refactor.eval_top(temp,true,5,null,positon_eval_refactor.dot_writers.add_node()));
            //do ai moves
            positon_eval_refactor.dot_writers.close();
            global_board.apply_move(current_move);
            curses_initq.write_board(global_board);
            ask_for_piece_black(global_board,aiw,aib,curses_initq,x_in,y_in,null);
        }
        int[] piece = curses_initq.get_piece_coordinates(message_piece,x_in,y_in);
        int x = piece[0];
        int y = piece[1];
        if(global_board.getPiece(y,x) == pieces.blank)
        {
            //curses_initq.update_message(new String[] {"That is not a piece","Select a white piece.","Use the arrow keys.","Use enter to select"});
            global_board.clean_prevselected();
            curses_initq.write_board(global_board);
            ask_for_piece_white(global_board,aiw,aib,curses_initq,x,y,new String[] {"That is not a piece.          ","Select a white piece.          ","Use the arrow keys.            ","Use enter to select       "});
        }
        if(valid.is_black(global_board.getPiece(y,x)))
        {
            //curses_initq.update_message(new String[]{"That is a black piece.","Select a white piece.","Use the arrow keys.","Use enter to select"});
            global_board.clean_prevselected();
            curses_initq.write_board(global_board);
            ask_for_piece_white(global_board,aiw,aib,curses_initq,x,y,new String[]{"That is a black piece.     ","Select a white piece.      ","Use the arrow keys.      ","Use enter to select         "});
        }
        global_board.set_prevselected(x,y);
        curses_initq.write_board(global_board);
        ask_for_move_white(global_board,aiw,aib,x,y,curses_initq);
    }
    public static void ask_for_move_white(highlighted_board global_board,boolean aiw, boolean aib,int x, int y,combinedCurses curses_initq)
    {
        String[] message_move = new String[]{"Please select the  ","location you want","to move to","Hit q to quit"};
        int[] temp = curses_initq.get_move_coordinates(message_move,x,y);
        int x_end = temp[0];
        int y_end = temp[1];
        if(!valid.validinternal_all(global_board,new move(x,y,x_end,y_end)))
        {
            global_board.clean_prevselected();
            curses_initq.write_board(global_board);
            ask_for_piece_white(global_board,aiw,aib,curses_initq,x_end,y_end,new String[]{"That is not a valid move.","Please reselect your piece","and try again",""});
        }
        move current_move = new move(x,y,x_end,y_end);
        global_board.set_prevselected(x,y);
        global_board.apply_move(current_move);
        curses_initq.write_board(global_board);
        ask_for_piece_black(global_board,aiw,aib,curses_initq,x_end,y_end,null);
    }
    public static void ask_for_piece_black(highlighted_board global_board, boolean aiw, boolean aib,combinedCurses curses_initq,int x_in,int y_in,String[] message_piece)
    {
        if(valid.check_for_checkmate(new scored_board(global_board),false))
        {
            //System.out.println(curses_initq.curses.clear_screen);
            combinedCurses.raw_mode.leave_raw();
            System.out.println("Checkmate");
            System.exit(0);
        }
        if(valid.check_for_stalemate(new scored_board(global_board),true)
        {
            combinedCurses.raw_mode.leave_raw();
            System.out.println("Stalemate");
            System.exit(0);
        }
        if(message_piece == null)
            message_piece = new String[]{"Select a black piece.","Use the arrow keys.","Use enter to select",""};
        if(aib)
        {
            //experimental
            scored_board temp = new scored_board(global_board);
            positon_eval_refactor.dot_writers.init();
            curses_initq.write_message(new String[] {"thinking deep and","buggy(hopefully not) ","",""});
            move current_move = new move(positon_eval_refactor.eval_top(temp,false,5,null,positon_eval_refactor.dot_writers.add_node()));
            //do ai moves
            positon_eval_refactor.dot_writers.close();
            global_board.apply_move(current_move);
            curses_initq.set_board(global_board);curses_initq.update();
            ask_for_piece_white(global_board,aiw,aib,curses_initq,x_in,y_in,null);
            //assert(false);
        }
        int[] piece = curses_initq.get_piece_coordinates(message_piece,x_in,y_in);
        int x = piece[0];
        int y = piece[1];
        if(global_board.getPiece(y,x) == pieces.blank)
        {
            global_board.clean_prevselected();
            curses_initq.write_board(global_board);
            ask_for_piece_black(global_board,aiw,aib,curses_initq,x,y,new String[]{"That is not a piece      ","Select a black piece.        ","Use the arrow keys.         ","Use enter to select"});
        }
        if(valid.is_white(global_board.getPiece(y,x)))
        {
            global_board.clean_prevselected();
            curses_initq.write_board(global_board);
            ask_for_piece_black(global_board,aiw,aib,curses_initq,x,y,new String[]{"That is a white piece.         ","Please select a white piece      ","",""});
        }
        global_board.set_prevselected(x,y);
        curses_initq.write_board(global_board);
        ask_for_move_black(global_board,aiw,aib,x,y,curses_initq);
    }
    public static void ask_for_move_black(highlighted_board global_board,boolean aiw, boolean aib,int x, int y,combinedCurses curses_initq)
    {
        String[] message_move = new String[]{
            "Please select the",
            "location you want",
            "to move to",
            "Hit q to quit"
        };
        int[] temp = curses_initq.get_move_coordinates(message_move,x,y);
        int x_end = temp[0];
        int y_end = temp[1];
        if(!valid.validinternal_all(global_board,new move(x,y,x_end,y_end)))
        {
            global_board.clean_prevselected();
            curses_initq.write_board(global_board);
            ask_for_piece_black(global_board,aiw,aib,curses_initq,x_end,y_end,new String[]{"That is not a valid move.","Please reselect your piece","and try again",""});
        }
        move current_move = new move(x,y,x_end,y_end);
        global_board.set_prevselected(x,y);
        global_board.apply_move(current_move);
        global_board.set_prevselected(x,y);
        curses_initq.set_board(global_board);
        ask_for_piece_white(global_board,aiw,aib,curses_initq,x_end,y_end,null);
    }
}