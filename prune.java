public static class prune
{
    move[] prune_internal(eval_move)
    eval_move[] prune_from_array(eval_move[] moves, int len)
    {
        //eval_move top5 = new eval_move[5];
        //eval_move bottom5 = new eval_move[5];
        //init bottom/top arrays
        eval_move[] out = new eval_move[10];
        Arrays.sort(moves);
        for(int i = 0; i < 5;i++)
        {
            out[i] = moves[i];
        }
        int moves_i;
        for(int i = 5; i < 10; i++)
        {
            moves_i = len - (i - 5);
            out[i] = moves[move_i];
        }
        return out;
    }
    public static move[] to_move(eval_move in, int len)
    {
        move[] out = new move[len];
        for(int i =0; i < len;i++)
            out[i] = new move(in[i]);
        return out;
    }
    
}