public class curses_test
{
    public static void main(String[] args)
    {
        board global_board = utils.defualt_board;
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
        Curses_interface curse = new Curses_interface(array,12);
        curse.board_overwrite(global_board);
    }
}