import copy
items = [
    'back_tab',
    'bell',
    'carriage_return',
    'change_scroll_region',
    'clear_all_tabs',
    'clear_screen',
    'clr_bol',
    'clr_eol',
    'clr_eos',
    'cursor_address',
    'cursor_down',
    'cursor_home',
    'cursor_invisible',
    'cursor_left',
    'cursor_normal',
    'cursor_right',
    'cursor_up',
    'cursor_visible',
    'delete_character',
    'delete_line',
    'ena_acs',
    'enter_alt_charset_mode',
    'enter_blink_mode',
    'enter_bold_mode',
    'enter_ca_mode',
    'enter_insert_mode', 
    'enter_reverse_mode',
    'enter_standout_mode',
    'enter_underline_mode',
    'exit_alt_charset_mode',
    'exit_attribute_mode',
    'exit_ca_mode',
    'exit_insert_mode',
    'exit_standout_mode',
    'exit_underline_mode', 
    'flash_screen',
    'init_2string', 
    'insert_line',
    'key_backspace', 
    'key_btab', 
    'key_dc',
    'key_down',
    'key_end', 
    'key_f1',
    'key_f10',
    'key_f11',
    'key_f12',
    'key_f2',
    'key_f3',
    'key_f4',
    'key_f5',
    'key_f6',
    'key_f7',
    'key_f8',
    'key_f9',
    'key_home',
    'key_ic',
    'key_left',
    'key_mouse',
    'key_npage',
    'key_ppage',
    'key_right',
    'key_up',
    'keypad_local',
    'keypad_xmit',
    'newline',
    'orig_pair',
    'parm_dch',
    'parm_delete_line',
    'parm_down_cursor', 
    'parm_ich',
    'parm_insert_line',
    'parm_left_cursor',
    'parm_right_cursor',
    'parm_up_cursor',
    'reset_2string',
    'restore_cursor',
    'save_cursor',
    'scroll_forward',
    'scroll_reverse',
    'set_a_background',
    'set_a_foreground',
    'set_attributes',
    'set_tab',
    'tab',
    ]




begin = """
import java.io.*;
import java.util.Scanner;

public class myCurses_auto
{
    public static final String BLACK = "\033[0m";
    public static final String RED = "\033[31m";
    public static final String GREEN = "\033[32m";
    public static final String YELLOW = "\033[33m";
    public static final String BLUE = "\033[34m";
    public static final String MAGENTA = "\033[35m";
    public static final String CYAN = "\033[36m";
    public static final String WHITE = "\033[37m";
"""
format1 ="""    public static String %s;\n"""

begin2="""    
    public static String cmp;
    public myCurses_auto()
    {
        cmp = constructorStuff.getCmp();
        String[] cmp_array = constructorStuff.toArray(cmp);
        constructorStuff.set_vars.enter_bold_mode_init(cmp_array);
        System.out.println("bold");
        constructorStuff.set_vars.clear_screen_init(cmp_array);
        System.out.println(clear_screen);
        System.out.println("clear");
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
            String inputStreamString = new Scanner(in,"UTF-8").useDelimiter("\\\\A").next();
            return inputStreamString;
        }
        public static String[] toArray(String in)
        {
            return in.split(" ");
        }
        public static class set_vars
        {
            """
        
end ="""}
    }
    public static void init()
    {
        System.out.print(enter_bold_mode);
    }
}

"""

middle_format = """\n            public static void %s_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\\\");
                    if((in[i]).indexOf("%s") != -1)
                    {
                        %s = in[i].substring(index,in[i].length() - 1).replace("\\\\E","\\033");
                        System.out.println(%s);
                    }
                }
            }"""


def generate():
    middle1 =''
    for item in items:
        middle1 += format1 % (item)
    middle2 = ''
    for item in items:
        middle2 += (middle_format % (item,item,item,item))
    return begin + middle1 + begin2 + middle2 + end
print generate()