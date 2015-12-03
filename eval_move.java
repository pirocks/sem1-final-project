public class eval_move extends move
{
    private double value;
    public eval_move(int x_in, int y_in, int x_end,int y_end,boolean castlingq,double value)
    {
        super(x_in,y_in,x_end,y_end,castlingq);
        this.value = value;
    }
    public eval_move(int x_in, int y_in, int x_end,int y_end,double value)
    {
        this(x_in,y_in,x_end,y_end,false,value);
    }
    public eval_move(int[] moves,double value)
    {
        super(moves);
        this.value = value;
    }
    public eval_move(move in,double value)
    {
        super(in);
        this.value = value;
    }
    public double get_value()
    {
        return value;
    }
    public int compareTo(eval_move in)
    {
        return(this.get_value() - in.get_value());
    }
}