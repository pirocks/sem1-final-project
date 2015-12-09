
import java.io.*;
import java.util.Scanner;

public class Curses
{

    // this file was generated with the python script generate.py
    // the python script was used due to the need to write hundreds of identical(almost) methods
    public static final String BLACK = "[0m";
    public static final String RED = "[31m";
    public static final String GREEN = "[32m";
    public static final String YELLOW = "[33m";
    public static final String BLUE = "[34m";
    public static final String MAGENTA = "[35m";
    public static final String CYAN = "[36m";
    public static final String WHITE = "[37m";
    public static String back_tab;
    public static String bell;
    public static String carriage_return;
    public static String change_scroll_region;
    public static String clear_all_tabs;
    public static String clear_screen;
    public static String cursor_down;
    public static String cursor_home;
    public static String cursor_invisible;
    public static String cursor_left;
    public static String cursor_normal;
    public static String cursor_right;
    public static String cursor_up;
    public static String cursor_visible;
    public static String delete_character;
    public static String delete_line;
    public static String ena_acs;
    public static String enter_alt_charset_mode;
    public static String enter_blink_mode;
    public static String enter_bold_mode;
    public static String enter_ca_mode;
    public static String enter_insert_mode;
    public static String enter_reverse_mode;
    public static String enter_standout_mode;
    public static String enter_underline_mode;
    public static String exit_alt_charset_mode;
    public static String exit_attribute_mode;
    public static String exit_ca_mode;
    public static String exit_insert_mode;
    public static String exit_standout_mode;
    public static String exit_underline_mode;
    public static String flash_screen;
    public static String init_2string;
    public static String insert_line;
    public static String key_backspace;
    public static String key_btab;
    public static String key_dc;
    public static String key_down;
    public static String key_end;
    public static String key_f1;
    public static String key_f10;
    public static String key_f11;
    public static String key_f12;
    public static String key_f2;
    public static String key_f3;
    public static String key_f4;
    public static String key_f5;
    public static String key_f6;
    public static String key_f7;
    public static String key_f8;
    public static String key_f9;
    public static String key_home;
    public static String key_ic;
    public static String key_left;
    public static String key_mouse;
    public static String key_npage;
    public static String key_ppage;
    public static String key_right;
    public static String key_up;
    public static String keypad_local;
    public static String keypad_xmit;
    public static String newline;
    public static String orig_pair;
    public static String reset_2string;
    public static String restore_cursor;
    public static String save_cursor;
    public static String scroll_forward;
    public static String scroll_reverse;
    public static String set_a_background;
    public static String set_a_foreground;
    public static String set_attributes;
    public static String set_tab;
    public static String tab;
    
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
            String inputStreamString = new Scanner(in,"UTF-8").useDelimiter("\\A").next();
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
                return in.replace("\\E","\033")
                //.replace("^J", Character.toString((char)10))
                .replace("^@","\0")
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
            
            public static void back_tab_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("back_tab=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    back_tab = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + back_tab + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void bell_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("bell=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    bell = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + bell + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void carriage_return_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("carriage_return=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    carriage_return = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + carriage_return + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void change_scroll_region_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("change_scroll_region=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    change_scroll_region = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + change_scroll_region + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void clear_all_tabs_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("clear_all_tabs=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    clear_all_tabs = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + clear_all_tabs + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void clear_screen_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("clear_screen=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    clear_screen = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + clear_screen + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void cursor_down_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("cursor_down=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    cursor_down = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + cursor_down + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void cursor_home_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("cursor_home=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    cursor_home = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + cursor_home + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void cursor_invisible_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("cursor_invisible=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    cursor_invisible = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + cursor_invisible + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void cursor_left_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("cursor_left=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    cursor_left = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + cursor_left + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void cursor_normal_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("cursor_normal=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    cursor_normal = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + cursor_normal + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void cursor_right_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("cursor_right=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    cursor_right = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + cursor_right + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void cursor_up_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("cursor_up=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    cursor_up = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + cursor_up + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void cursor_visible_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("cursor_visible=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    cursor_visible = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + cursor_visible + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void delete_character_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("delete_character=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    delete_character = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + delete_character + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void delete_line_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("delete_line=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    delete_line = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + delete_line + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void ena_acs_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("ena_acs=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    ena_acs = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + ena_acs + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void enter_alt_charset_mode_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("enter_alt_charset_mode=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    enter_alt_charset_mode = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + enter_alt_charset_mode + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void enter_blink_mode_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("enter_blink_mode=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    enter_blink_mode = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + enter_blink_mode + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void enter_bold_mode_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("enter_bold_mode=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    enter_bold_mode = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + enter_bold_mode + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void enter_ca_mode_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("enter_ca_mode=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    enter_ca_mode = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + enter_ca_mode + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void enter_insert_mode_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("enter_insert_mode=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    enter_insert_mode = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + enter_insert_mode + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void enter_reverse_mode_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("enter_reverse_mode=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    enter_reverse_mode = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + enter_reverse_mode + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void enter_standout_mode_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("enter_standout_mode=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    enter_standout_mode = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + enter_standout_mode + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void enter_underline_mode_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("enter_underline_mode=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    enter_underline_mode = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + enter_underline_mode + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void exit_alt_charset_mode_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("exit_alt_charset_mode=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    exit_alt_charset_mode = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + exit_alt_charset_mode + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void exit_attribute_mode_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("exit_attribute_mode=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    exit_attribute_mode = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + exit_attribute_mode + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void exit_ca_mode_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("exit_ca_mode=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    exit_ca_mode = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + exit_ca_mode + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void exit_insert_mode_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("exit_insert_mode=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    exit_insert_mode = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + exit_insert_mode + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void exit_standout_mode_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("exit_standout_mode=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    exit_standout_mode = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + exit_standout_mode + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void exit_underline_mode_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("exit_underline_mode=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    exit_underline_mode = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + exit_underline_mode + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void flash_screen_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("flash_screen=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    flash_screen = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + flash_screen + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void init_2string_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("init_2string=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    init_2string = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + init_2string + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void insert_line_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("insert_line=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    insert_line = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + insert_line + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void key_backspace_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("key_backspace=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    key_backspace = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + key_backspace + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void key_btab_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("key_btab=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    key_btab = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + key_btab + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void key_dc_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("key_dc=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    key_dc = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + key_dc + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void key_down_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("key_down=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    key_down = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + key_down + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void key_end_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("key_end=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    key_end = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + key_end + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void key_f1_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("key_f1=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    key_f1 = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + key_f1 + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void key_f10_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("key_f10=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    key_f10 = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + key_f10 + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void key_f11_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("key_f11=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    key_f11 = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + key_f11 + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void key_f12_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("key_f12=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    key_f12 = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + key_f12 + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void key_f2_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("key_f2=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    key_f2 = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + key_f2 + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void key_f3_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("key_f3=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    key_f3 = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + key_f3 + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void key_f4_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("key_f4=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    key_f4 = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + key_f4 + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void key_f5_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("key_f5=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    key_f5 = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + key_f5 + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void key_f6_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("key_f6=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    key_f6 = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + key_f6 + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void key_f7_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("key_f7=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    key_f7 = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + key_f7 + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void key_f8_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("key_f8=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    key_f8 = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + key_f8 + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void key_f9_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("key_f9=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    key_f9 = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + key_f9 + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void key_home_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("key_home=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    key_home = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + key_home + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void key_ic_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("key_ic=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    key_ic = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + key_ic + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void key_left_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("key_left=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    key_left = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + key_left + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void key_mouse_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("key_mouse=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    key_mouse = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + key_mouse + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void key_npage_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("key_npage=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    key_npage = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + key_npage + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void key_ppage_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("key_ppage=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    key_ppage = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + key_ppage + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void key_right_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("key_right=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    key_right = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + key_right + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void key_up_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("key_up=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    key_up = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + key_up + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void keypad_local_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("keypad_local=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    keypad_local = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + keypad_local + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void keypad_xmit_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("keypad_xmit=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    keypad_xmit = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + keypad_xmit + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void newline_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("newline=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    newline = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + newline + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void orig_pair_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("orig_pair=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    orig_pair = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + orig_pair + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void reset_2string_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("reset_2string=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    reset_2string = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + reset_2string + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void restore_cursor_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("restore_cursor=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    restore_cursor = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + restore_cursor + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void save_cursor_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("save_cursor=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    save_cursor = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + save_cursor + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void scroll_forward_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("scroll_forward=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    scroll_forward = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + scroll_forward + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void scroll_reverse_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("scroll_reverse=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    scroll_reverse = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + scroll_reverse + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void set_a_background_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("set_a_background=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    set_a_background = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + set_a_background + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void set_a_foreground_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("set_a_foreground=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    set_a_foreground = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + set_a_foreground + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void set_attributes_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("set_attributes=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    set_attributes = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + set_attributes + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void set_tab_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("set_tab=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    set_tab = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + set_tab + "failed to initialize");
                    utils.sleep(500);
                }
            }
            public static void tab_init(String in)
            {
                try
                {
                    int word_index = (in).indexOf("tab=");
                    String new_string = in.substring(word_index);
                    int equals_index = (new_string).indexOf("=");
                    int comma_index = new_string.indexOf(",");
                    String final_word = new_string.substring(equals_index + 1,comma_index);
                    tab = doReplace(final_word);
                }
                catch(Exception e)
                {
                    System.out.println("Warning:" + tab + "failed to initialize");
                    utils.sleep(500);
                }
            } public static void init_all(String in) {set_vars.back_tab_init(in);
set_vars.bell_init(in);
set_vars.carriage_return_init(in);
set_vars.change_scroll_region_init(in);
set_vars.clear_all_tabs_init(in);
set_vars.clear_screen_init(in);
set_vars.cursor_down_init(in);
set_vars.cursor_home_init(in);
set_vars.cursor_invisible_init(in);
set_vars.cursor_left_init(in);
set_vars.cursor_normal_init(in);
set_vars.cursor_right_init(in);
set_vars.cursor_up_init(in);
set_vars.cursor_visible_init(in);
set_vars.delete_character_init(in);
set_vars.delete_line_init(in);
set_vars.ena_acs_init(in);
set_vars.enter_alt_charset_mode_init(in);
set_vars.enter_blink_mode_init(in);
set_vars.enter_bold_mode_init(in);
set_vars.enter_ca_mode_init(in);
set_vars.enter_insert_mode_init(in);
set_vars.enter_reverse_mode_init(in);
set_vars.enter_standout_mode_init(in);
set_vars.enter_underline_mode_init(in);
set_vars.exit_alt_charset_mode_init(in);
set_vars.exit_attribute_mode_init(in);
set_vars.exit_ca_mode_init(in);
set_vars.exit_insert_mode_init(in);
set_vars.exit_standout_mode_init(in);
set_vars.exit_underline_mode_init(in);
set_vars.flash_screen_init(in);
set_vars.init_2string_init(in);
set_vars.insert_line_init(in);
set_vars.key_backspace_init(in);
set_vars.key_btab_init(in);
set_vars.key_dc_init(in);
set_vars.key_down_init(in);
set_vars.key_end_init(in);
set_vars.key_f1_init(in);
set_vars.key_f10_init(in);
set_vars.key_f11_init(in);
set_vars.key_f12_init(in);
set_vars.key_f2_init(in);
set_vars.key_f3_init(in);
set_vars.key_f4_init(in);
set_vars.key_f5_init(in);
set_vars.key_f6_init(in);
set_vars.key_f7_init(in);
set_vars.key_f8_init(in);
set_vars.key_f9_init(in);
set_vars.key_home_init(in);
set_vars.key_ic_init(in);
set_vars.key_left_init(in);
set_vars.key_mouse_init(in);
set_vars.key_npage_init(in);
set_vars.key_ppage_init(in);
set_vars.key_right_init(in);
set_vars.key_up_init(in);
set_vars.keypad_local_init(in);
set_vars.keypad_xmit_init(in);
set_vars.newline_init(in);
set_vars.orig_pair_init(in);
set_vars.reset_2string_init(in);
set_vars.restore_cursor_init(in);
set_vars.save_cursor_init(in);
set_vars.scroll_forward_init(in);
set_vars.scroll_reverse_init(in);
set_vars.set_a_background_init(in);
set_vars.set_a_foreground_init(in);
set_vars.set_attributes_init(in);
set_vars.set_tab_init(in);
set_vars.tab_init(in);
}}
    }
    
    public static void init()
    {
        System.out.print(enter_bold_mode);
    }
    
}


