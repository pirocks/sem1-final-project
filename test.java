public class test 
{
    public static void main(String[] args) 
    {
        try 
        {
            String[] cmd = {"/bin/sh", "-c", "stty raw </dev/tty"};
            Runtime.getRuntime().exec(cmd).waitFor();
        }
        catch (Exception e) 
        {
            return;
        }
    }
}
