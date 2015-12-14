#!/bin/python
import copy
items = [
    'back_tab',
    'bell',
    'carriage_return',
    'change_scroll_region',
    'clear_all_tabs',
    'clear_screen',
    # 'clr_bol',
    # 'clr_eol',
    # 'clr_eos',
    # 'cursor_address',
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
#    'ena_acs',
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
#    'newline',
    'orig_pair',
    # 'parm_dch',
    # 'parm_delete_line',
    # 'parm_down_cursor', 
    # 'parm_ich',
    # 'parm_insert_line',
    # 'parm_left_cursor',
    # 'parm_right_cursor',
    # 'parm_up_cursor',
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

public class Curses
{

    // this file was generated with the python script generate.py
    // the python script was used due to the need to write hundreds of identical(almost) methods
    public static final String BLACK = "\033[0m";
    public static final String RED = "\033[31m";
    public static final String GREEN = "\033[32m";
    public static final String YELLOW = "\033[33m";
    public static final String BLUE = "\033[34m";
    public static final String MAGENTA = "\033[35m";
    public static final String CYAN = "\033[36m";
    public static final String WHITE = "\033[37m";
	public static final String newline = "\n"l
"""
format1 ="""    public static String %s;\n"""

begin2="""    
    public static String cmp;
    public static void fix_the_terminal()
    {
        try{
        String[] cmd = {"/bin/sh", "-c", "stty sane </dev/tty"};
        Runtime.getRuntime().exec(cmd).waitFor();
        }
        catch(Exception e)
        {
            return;
        }
    }
    public Curses()
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
        cmp = constructorStuff.getCmp();
        constructorStuff.set_vars.init_all(cmp);
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
            public static String doReplace(String in)
            {
                return in.replace("\\\\E","\\033")
                //.replace("^J", Character.toString((char)10))
                .replace("^@","\\0")
                .replace("^A", Character.toString((char)1))
                .replace("^B", Character.toString((char)2))
                .replace("^C", Character.toString((char)3))
                .replace("^D", Character.toString((char)4))
                .replace("^E", Character.toString((char)5))
                .replace("^F", Character.toString((char)6))
                .replace("^G", Character.toString((char)7))
                .replace("^H", Character.toString((char)8))
                .replace("^I", Character.toString((char)9))
                .replace("^J", Character.toString((char)10))
                .replace("^K", Character.toString((char)11))
                .replace("^L", Character.toString((char)12))
                .replace("^M", Character.toString((char)13))
                .replace("^N", Character.toString((char)14))
                .replace("^O", Character.toString((char)15))
                .replace("^P", Character.toString((char)16))
                .replace("^Q", Character.toString((char)17))
                .replace("^R", Character.toString((char)18))
                .replace("^S", Character.toString((char)19))
                .replace("^T", Character.toString((char)20))
                .replace("^U", Character.toString((char)21))
                .replace("^V", Character.toString((char)22))
                .replace("^W", Character.toString((char)23))
                .replace("^X", Character.toString((char)24))
                .replace("^Y", Character.toString((char)25))
                .replace("^Z", Character.toString((char)24));
            }
            """

init_all_beg = """ public static void init_all(String in) {"""
init_all_mid = """set_vars.%s_init(in);\n"""
init_all_end = """}"""
end ="""}
    }
    
    public static void init()
    {
        System.out.print(enter_bold_mode);
    }
    
}

"""

middle_format = """\n            public static void %s_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("%s=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    %s = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + "%s" + "failed to initialize");
                    utils.sleep(500);
                }
            }"""


def generate():
    middle1 =''
    for item in items:
        middle1 += format1 % (item)
    middle2 = ''
    for item in items:
        middle2 += (middle_format % (item,item,item,item))
    init_all = init_all_beg
    for item in items:
        init_all += init_all_mid % (item)
    init_all += init_all_end
    return begin + middle1 + begin2 + middle2 +init_all+ end
print generate()
