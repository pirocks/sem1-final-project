public class runner
{
    public static void main(String[] args)
    {
        board global_board = utils.debug_board;
        highlighted_board newboard = new highlighted_board(global_board.toArray());
        newboard.set_selected(0,0);
        combinedCurses combined = new combinedCurses(newboard,new String[]
        {
            "","","",""
        }
        );
        
        Curses_command_line_ui.ask_for_piece_white(newboard,false,true,combined,0,0,null);
        // use command line ui for debugging
        ////command_line_ui.ask_for_piece_white(global_board,false,false);
        // scored_board in = new scored_board(global_board);
        // prune_data hjh = null;
        // System.out.println(positon_eval.eval(in,false,2,hjh));
    }
    
}