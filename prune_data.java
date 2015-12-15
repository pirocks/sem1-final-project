public class prune_data
{
    public eval_move Eval_move;
    public boolean maxq;
    public prune_data(eval_move eval_in,boolean maxq)
    {
        this.Eval_move = eval_in;
        this.maxq = maxq;
    }
}