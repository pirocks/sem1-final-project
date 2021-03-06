public final class generic_move
{
    private int yend;
    private int xend;
    public generic_move(int xend, int yend)
    {
        this.yend = yend;
        this.xend = xend;
    }
    public move to_move(int x_in, int y_in)
    {
        //no validity assert neceseary
        return new move(x_in,y_in,x_in+xend,y_in+yend);
    }
    public int[] get_end()
    {
        int[] out = {xend,yend};
        return(out);
    }
    public int get_xend()
    {
        return xend;
    }
    public int get_yend()
    {
        return yend;
    }
    public generic_move(move in)
    {
        this.xend = in.get_x_end();
        this.yend = in.get_y_end();
    }
}