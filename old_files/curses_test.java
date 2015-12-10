public class curses_test
{
    public static void main(String[] args)
    {
        board global_board = board.copy_board(utils.defualt_board);
        String[] array = new String[] {
            "                                                                ",//1 //64
            "                                                                ",//2
            "                                                                ",//3
            "                                                                ",//4
            "                                                                ",//5
            "                                                                ",//6
            "                                      random text               ",//7
            "                                                                ",//8
            "                                                                ",//9
            "                                                                ",//10
            "                                                                ",//11
            "                                                                ",//12
        };
        //Curses_interface curse = new Curses_interface(array,12);
        //Curses_high_level high = new Curses_high_level();
        //curse.board_overwrite(global_board);
        highlighted_board newboard = new highlighted_board(global_board.toArray());
        newboard.set_selected(0,0);
        combinedCurses combined = new combinedCurses(newboard,new String[]
            {
                "","","",""
            }
        );
        Curses_command_line_ui.ask_for_piece_white(newboard,false,false,combined);
        // System.out.println("hc" + utils.RESET);
        // for(int i =0;i < 8;i++) 
        // {
        //     System.out.println(i);
        //     System.out.println(utils.create_fancy_board(global_board)[i]);
        // }
    }
}