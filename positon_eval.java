
public class positon_eval 
{
    public static final special = 200000.0;
    //everything static for performance
    public static double call_generated(board board_in,move[] moves_in,int len)
    {
        double[] evaluations = new double[1000];//need to figue out what actually is
        for(int i = 0; i < len, i++)
        {
            
            evaluations[i] = eval()
        }
    }
    public static double eval(scored_board board_in,boolean white_to_moveq,int depth)
    {
        if(depth == 0)
        {
            return board_in.get_eval();
        }
        else
        {
            move moves
            if(white_to_moveq)
            {
                generate_white()
            }
            else
            {
                generate_black()
            }
        }
    }
    public static int generate_white(scored_board board_in,eval_move[] out,int len);
    public static int generate_black(scored_board board_in,eval_move[] out,int len);
    public static int generate_knight(scored_board board_in,eval_move[] out,int len);
    public static int generate_king(scored_board board_in,eval_move[] out,int len);
    public static int generate_pawn_white(scored_board board_in,eval_move[] out,int len);
    public static int generate_pawn_black(scored_board board_in,eval_move[] out,int len);
    public static double min_max(eval_move[] array,int len,boolean white_to_moveq,int depth)
    {
        if(white_to_moveq)
            return max(array,len);
        else
            return min(array,len);
    }
    public static double min(eval_move[] array,int len)
    {
        double current;
        if(len == 0)
            return special;
        double min = array[0];
        for(int i = 0; i < len; i++)
        {
            current = array[i];
            if(min == special)
                min = current;
            if(current < min && current != special)
                min = current;
        }
        return min;
    }
    public static double max(eval_move[] array,int len)
    {
        double current;
        if(len == 0)
            return special;
        double max = array[0];
        for(int i = 0; i < len; i++)
        {
            current = array[i];
            if(max == special)
                max = current;
            if(current < max && current != special)
                max = current;
        }
        return max
    }
    
}
