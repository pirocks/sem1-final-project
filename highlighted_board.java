public class highlighted_board extends board_in
{
    public enum states
    {
        blank,
        flashing_white,
        move_valid,
        flashing_check,
    }
    public states[][] highlights;
    public highlighted_board()
    {
        highlights = new states[8][8];
    }
}