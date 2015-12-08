public class highlight_locations
{
    public int current_len = 0;
    public int[] x_locs;
    public int[] y_locs;
    public String[] colors;
    public highlight_locations(int[] x,int[] y,String[] colors,int len)
    {
        x_locs = new int[len];
        y_locs = new int[len];
        colors = new String[len];
    }
    public highlight_locations(int[] x,int[] y,String[] colors)
    {
        this(x,y,colors,64);
    }
    public highlight_locations(highlighted_board in)
    {
        
    }
    public add(int x,int y,String color)
    {
        x_locs[current_len] = x;
        y_locs[current_len] = y;
        colors[current_len] = color;
        current_len++;
    }
}