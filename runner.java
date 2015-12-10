public class runner
{
    public static void main(String[] args)
    {
        board global_board = utils.defualt_board;
        highlighted_board newboard = new highlighted_board(global_board.toArray());
        newboard.set_selected(0,0);
        combinedCurses combined = new combinedCurses(newboard,new String[]
            {
                "","","",""
            }
        );
        Curses_command_line_ui.ask_for_piece_white(newboard,false,false,combined);
    }
    
}