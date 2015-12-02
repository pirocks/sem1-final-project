public class eval_move extends move
{
    private double value;
    public eval_move(int x_in, int y_in, int x_end,int y_end,boolean castlingq,double value)
    {
        this.value = value;
        super(x_in,y_in,x_end,y_end,castlingq);
    }
    public eval_move(int x_in, int y_in, int x_end,int y_end,double value)
    {
        this(x_in,y_in,x_end,y_end,false,value);
    }
    public eval_move(int[] moves,double value)
    {
        this.value = value;
        super(moves)
    }
    public double get_value()
    {
        return value;
    }
}