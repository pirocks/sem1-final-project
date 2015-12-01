import java.io.*;
import java.util.Scanner;

public class myCurses
{
    public static final String BLACK = "\033[0m";
    public static final String RED = "\033[31m";
    public static final String GREEN = "\033[32m";
    public static final String YELLOW = "\033[33m";
    public static final String BLUE = "\033[34m";
    public static final String MAGENTA = "\033[35m";
    public static final String CYAN = "\033[36m";
    public static final String WHITE = "\033[37m";
    public static String enter_bold_mode;
    public static String cursor_home;
    public static String change_scroll_region;
    
    public static String cmp;
    public myCurses()
    {
        cmp = constructorStuff.getCmp();
        System.out.println(constructorStuff.getCmp());
        String[] cmp_array = constructorStuff.toArray(cmp);
        constructorStuff.set_vars.set_buffer_init(cmp_array);
    }
    public static class constructorStuff
    {
        public static String getCmp()
        {
            try
            {
                Process process = Runtime.getRuntime().exec("infocmp -L");
                return inputStreamToString(process.getInputStream());
            }
            catch(IOException e)
            {
                System.out.println("something is wrong");
                return "";
            }
        }
        private static String inputStreamToString(InputStream in)
        {
            String inputStreamString = new Scanner(in,"UTF-8").useDelimiter("\\A").next();
            return inputStreamString;
        }
        public static String[] toArray(String in)
        {
            return in.split(" ");
        }
        public static class set_vars
        {
            public static void enter_bold_mode_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        enter_bold_mode = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }
            public static void cursor_home_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("cursor_home") != -1)
                    {
                        cursor_home = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(cursor_home);
                    }
                }
            }
            public static void change_scroll_region_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("cursor_home") != -1)
                    {
                        change_scroll_region = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(cursor_home);
                    }
                }
            }
        }
    }
    public static void init()
    {
        System.out.print(buffer_init);
    }
}