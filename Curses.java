
import java.io.*;
import java.util.Scanner;

public class Curses
{
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
    public static String clr_bol;
    public static String clr_eol;
    public static String clr_eos;
    public static String cursor_address;
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
    public static String parm_dch;
    public static String parm_delete_line;
    public static String parm_down_cursor;
    public static String parm_ich;
    public static String parm_insert_line;
    public static String parm_left_cursor;
    public static String parm_right_cursor;
    public static String parm_up_cursor;
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
    public Curses()
    {
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
            
            public static void back_tab_init(String in)
            {
                int word_index = (in).indexOf("back_tab=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug back_tab" + "thing: " + final_word);
                back_tab = final_word.replace("\\E","\033");
            }
            public static void bell_init(String in)
            {
                int word_index = (in).indexOf("bell=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug bell" + "thing: " + final_word);
                bell = final_word.replace("\\E","\033");
            }
            public static void carriage_return_init(String in)
            {
                int word_index = (in).indexOf("carriage_return=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug carriage_return" + "thing: " + final_word);
                carriage_return = final_word.replace("\\E","\033");
            }
            public static void change_scroll_region_init(String in)
            {
                int word_index = (in).indexOf("change_scroll_region=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug change_scroll_region" + "thing: " + final_word);
                change_scroll_region = final_word.replace("\\E","\033");
            }
            public static void clear_all_tabs_init(String in)
            {
                int word_index = (in).indexOf("clear_all_tabs=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug clear_all_tabs" + "thing: " + final_word);
                clear_all_tabs = final_word.replace("\\E","\033");
            }
            public static void clear_screen_init(String in)
            {
                int word_index = (in).indexOf("clear_screen=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug clear_screen" + "thing: " + final_word);
                clear_screen = final_word.replace("\\E","\033");
            }
            public static void clr_bol_init(String in)
            {
                int word_index = (in).indexOf("clr_bol=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug clr_bol" + "thing: " + final_word);
                clr_bol = final_word.replace("\\E","\033");
            }
            public static void clr_eol_init(String in)
            {
                int word_index = (in).indexOf("clr_eol=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug clr_eol" + "thing: " + final_word);
                clr_eol = final_word.replace("\\E","\033");
            }
            public static void clr_eos_init(String in)
            {
                int word_index = (in).indexOf("clr_eos=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug clr_eos" + "thing: " + final_word);
                clr_eos = final_word.replace("\\E","\033");
            }
            public static void cursor_address_init(String in)
            {
                int word_index = (in).indexOf("cursor_address=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug cursor_address" + "thing: " + final_word);
                cursor_address = final_word.replace("\\E","\033");
            }
            public static void cursor_down_init(String in)
            {
                int word_index = (in).indexOf("cursor_down=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug cursor_down" + "thing: " + final_word);
                cursor_down = final_word.replace("\\E","\033");
            }
            public static void cursor_home_init(String in)
            {
                int word_index = (in).indexOf("cursor_home=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug cursor_home" + "thing: " + final_word);
                cursor_home = final_word.replace("\\E","\033");
            }
            public static void cursor_invisible_init(String in)
            {
                int word_index = (in).indexOf("cursor_invisible=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug cursor_invisible" + "thing: " + final_word);
                cursor_invisible = final_word.replace("\\E","\033");
            }
            public static void cursor_left_init(String in)
            {
                int word_index = (in).indexOf("cursor_left=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug cursor_left" + "thing: " + final_word);
                cursor_left = final_word.replace("\\E","\033");
            }
            public static void cursor_normal_init(String in)
            {
                int word_index = (in).indexOf("cursor_normal=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug cursor_normal" + "thing: " + final_word);
                cursor_normal = final_word.replace("\\E","\033");
            }
            public static void cursor_right_init(String in)
            {
                int word_index = (in).indexOf("cursor_right=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug cursor_right" + "thing: " + final_word);
                cursor_right = final_word.replace("\\E","\033");
            }
            public static void cursor_up_init(String in)
            {
                int word_index = (in).indexOf("cursor_up=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug cursor_up" + "thing: " + final_word);
                cursor_up = final_word.replace("\\E","\033");
            }
            public static void cursor_visible_init(String in)
            {
                int word_index = (in).indexOf("cursor_visible=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug cursor_visible" + "thing: " + final_word);
                cursor_visible = final_word.replace("\\E","\033");
            }
            public static void delete_character_init(String in)
            {
                int word_index = (in).indexOf("delete_character=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug delete_character" + "thing: " + final_word);
                delete_character = final_word.replace("\\E","\033");
            }
            public static void delete_line_init(String in)
            {
                int word_index = (in).indexOf("delete_line=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug delete_line" + "thing: " + final_word);
                delete_line = final_word.replace("\\E","\033");
            }
            public static void ena_acs_init(String in)
            {
                int word_index = (in).indexOf("ena_acs=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug ena_acs" + "thing: " + final_word);
                ena_acs = final_word.replace("\\E","\033");
            }
            public static void enter_alt_charset_mode_init(String in)
            {
                int word_index = (in).indexOf("enter_alt_charset_mode=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug enter_alt_charset_mode" + "thing: " + final_word);
                enter_alt_charset_mode = final_word.replace("\\E","\033");
            }
            public static void enter_blink_mode_init(String in)
            {
                int word_index = (in).indexOf("enter_blink_mode=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug enter_blink_mode" + "thing: " + final_word);
                enter_blink_mode = final_word.replace("\\E","\033");
            }
            public static void enter_bold_mode_init(String in)
            {
                int word_index = (in).indexOf("enter_bold_mode=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug enter_bold_mode" + "thing: " + final_word);
                enter_bold_mode = final_word.replace("\\E","\033");
            }
            public static void enter_ca_mode_init(String in)
            {
                int word_index = (in).indexOf("enter_ca_mode=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug enter_ca_mode" + "thing: " + final_word);
                enter_ca_mode = final_word.replace("\\E","\033");
            }
            public static void enter_insert_mode_init(String in)
            {
                int word_index = (in).indexOf("enter_insert_mode=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug enter_insert_mode" + "thing: " + final_word);
                enter_insert_mode = final_word.replace("\\E","\033");
            }
            public static void enter_reverse_mode_init(String in)
            {
                int word_index = (in).indexOf("enter_reverse_mode=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug enter_reverse_mode" + "thing: " + final_word);
                enter_reverse_mode = final_word.replace("\\E","\033");
            }
            public static void enter_standout_mode_init(String in)
            {
                int word_index = (in).indexOf("enter_standout_mode=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug enter_standout_mode" + "thing: " + final_word);
                enter_standout_mode = final_word.replace("\\E","\033");
            }
            public static void enter_underline_mode_init(String in)
            {
                int word_index = (in).indexOf("enter_underline_mode=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug enter_underline_mode" + "thing: " + final_word);
                enter_underline_mode = final_word.replace("\\E","\033");
            }
            public static void exit_alt_charset_mode_init(String in)
            {
                int word_index = (in).indexOf("exit_alt_charset_mode=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug exit_alt_charset_mode" + "thing: " + final_word);
                exit_alt_charset_mode = final_word.replace("\\E","\033");
            }
            public static void exit_attribute_mode_init(String in)
            {
                int word_index = (in).indexOf("exit_attribute_mode=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug exit_attribute_mode" + "thing: " + final_word);
                exit_attribute_mode = final_word.replace("\\E","\033");
            }
            public static void exit_ca_mode_init(String in)
            {
                int word_index = (in).indexOf("exit_ca_mode=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug exit_ca_mode" + "thing: " + final_word);
                exit_ca_mode = final_word.replace("\\E","\033");
            }
            public static void exit_insert_mode_init(String in)
            {
                int word_index = (in).indexOf("exit_insert_mode=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug exit_insert_mode" + "thing: " + final_word);
                exit_insert_mode = final_word.replace("\\E","\033");
            }
            public static void exit_standout_mode_init(String in)
            {
                int word_index = (in).indexOf("exit_standout_mode=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug exit_standout_mode" + "thing: " + final_word);
                exit_standout_mode = final_word.replace("\\E","\033");
            }
            public static void exit_underline_mode_init(String in)
            {
                int word_index = (in).indexOf("exit_underline_mode=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug exit_underline_mode" + "thing: " + final_word);
                exit_underline_mode = final_word.replace("\\E","\033");
            }
            public static void flash_screen_init(String in)
            {
                int word_index = (in).indexOf("flash_screen=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug flash_screen" + "thing: " + final_word);
                flash_screen = final_word.replace("\\E","\033");
            }
            public static void init_2string_init(String in)
            {
                int word_index = (in).indexOf("init_2string=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug init_2string" + "thing: " + final_word);
                init_2string = final_word.replace("\\E","\033");
            }
            public static void insert_line_init(String in)
            {
                int word_index = (in).indexOf("insert_line=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug insert_line" + "thing: " + final_word);
                insert_line = final_word.replace("\\E","\033");
            }
            public static void key_backspace_init(String in)
            {
                int word_index = (in).indexOf("key_backspace=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug key_backspace" + "thing: " + final_word);
                key_backspace = final_word.replace("\\E","\033");
            }
            public static void key_btab_init(String in)
            {
                int word_index = (in).indexOf("key_btab=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug key_btab" + "thing: " + final_word);
                key_btab = final_word.replace("\\E","\033");
            }
            public static void key_dc_init(String in)
            {
                int word_index = (in).indexOf("key_dc=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug key_dc" + "thing: " + final_word);
                key_dc = final_word.replace("\\E","\033");
            }
            public static void key_down_init(String in)
            {
                int word_index = (in).indexOf("key_down=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug key_down" + "thing: " + final_word);
                key_down = final_word.replace("\\E","\033");
            }
            public static void key_end_init(String in)
            {
                int word_index = (in).indexOf("key_end=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug key_end" + "thing: " + final_word);
                key_end = final_word.replace("\\E","\033");
            }
            public static void key_f1_init(String in)
            {
                int word_index = (in).indexOf("key_f1=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug key_f1" + "thing: " + final_word);
                key_f1 = final_word.replace("\\E","\033");
            }
            public static void key_f10_init(String in)
            {
                int word_index = (in).indexOf("key_f10=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug key_f10" + "thing: " + final_word);
                key_f10 = final_word.replace("\\E","\033");
            }
            public static void key_f11_init(String in)
            {
                int word_index = (in).indexOf("key_f11=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug key_f11" + "thing: " + final_word);
                key_f11 = final_word.replace("\\E","\033");
            }
            public static void key_f12_init(String in)
            {
                int word_index = (in).indexOf("key_f12=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug key_f12" + "thing: " + final_word);
                key_f12 = final_word.replace("\\E","\033");
            }
            public static void key_f2_init(String in)
            {
                int word_index = (in).indexOf("key_f2=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug key_f2" + "thing: " + final_word);
                key_f2 = final_word.replace("\\E","\033");
            }
            public static void key_f3_init(String in)
            {
                int word_index = (in).indexOf("key_f3=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug key_f3" + "thing: " + final_word);
                key_f3 = final_word.replace("\\E","\033");
            }
            public static void key_f4_init(String in)
            {
                int word_index = (in).indexOf("key_f4=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug key_f4" + "thing: " + final_word);
                key_f4 = final_word.replace("\\E","\033");
            }
            public static void key_f5_init(String in)
            {
                int word_index = (in).indexOf("key_f5=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug key_f5" + "thing: " + final_word);
                key_f5 = final_word.replace("\\E","\033");
            }
            public static void key_f6_init(String in)
            {
                int word_index = (in).indexOf("key_f6=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug key_f6" + "thing: " + final_word);
                key_f6 = final_word.replace("\\E","\033");
            }
            public static void key_f7_init(String in)
            {
                int word_index = (in).indexOf("key_f7=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug key_f7" + "thing: " + final_word);
                key_f7 = final_word.replace("\\E","\033");
            }
            public static void key_f8_init(String in)
            {
                int word_index = (in).indexOf("key_f8=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug key_f8" + "thing: " + final_word);
                key_f8 = final_word.replace("\\E","\033");
            }
            public static void key_f9_init(String in)
            {
                int word_index = (in).indexOf("key_f9=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug key_f9" + "thing: " + final_word);
                key_f9 = final_word.replace("\\E","\033");
            }
            public static void key_home_init(String in)
            {
                int word_index = (in).indexOf("key_home=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug key_home" + "thing: " + final_word);
                key_home = final_word.replace("\\E","\033");
            }
            public static void key_ic_init(String in)
            {
                int word_index = (in).indexOf("key_ic=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug key_ic" + "thing: " + final_word);
                key_ic = final_word.replace("\\E","\033");
            }
            public static void key_left_init(String in)
            {
                int word_index = (in).indexOf("key_left=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug key_left" + "thing: " + final_word);
                key_left = final_word.replace("\\E","\033");
            }
            public static void key_mouse_init(String in)
            {
                int word_index = (in).indexOf("key_mouse=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug key_mouse" + "thing: " + final_word);
                key_mouse = final_word.replace("\\E","\033");
            }
            public static void key_npage_init(String in)
            {
                int word_index = (in).indexOf("key_npage=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug key_npage" + "thing: " + final_word);
                key_npage = final_word.replace("\\E","\033");
            }
            public static void key_ppage_init(String in)
            {
                int word_index = (in).indexOf("key_ppage=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug key_ppage" + "thing: " + final_word);
                key_ppage = final_word.replace("\\E","\033");
            }
            public static void key_right_init(String in)
            {
                int word_index = (in).indexOf("key_right=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug key_right" + "thing: " + final_word);
                key_right = final_word.replace("\\E","\033");
            }
            public static void key_up_init(String in)
            {
                int word_index = (in).indexOf("key_up=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug key_up" + "thing: " + final_word);
                key_up = final_word.replace("\\E","\033");
            }
            public static void keypad_local_init(String in)
            {
                int word_index = (in).indexOf("keypad_local=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug keypad_local" + "thing: " + final_word);
                keypad_local = final_word.replace("\\E","\033");
            }
            public static void keypad_xmit_init(String in)
            {
                int word_index = (in).indexOf("keypad_xmit=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug keypad_xmit" + "thing: " + final_word);
                keypad_xmit = final_word.replace("\\E","\033");
            }
            public static void newline_init(String in)
            {
                int word_index = (in).indexOf("newline=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug newline" + "thing: " + final_word);
                newline = final_word.replace("\\E","\033");
            }
            public static void orig_pair_init(String in)
            {
                int word_index = (in).indexOf("orig_pair=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug orig_pair" + "thing: " + final_word);
                orig_pair = final_word.replace("\\E","\033");
            }
            public static void parm_dch_init(String in)
            {
                int word_index = (in).indexOf("parm_dch=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug parm_dch" + "thing: " + final_word);
                parm_dch = final_word.replace("\\E","\033");
            }
            public static void parm_delete_line_init(String in)
            {
                int word_index = (in).indexOf("parm_delete_line=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug parm_delete_line" + "thing: " + final_word);
                parm_delete_line = final_word.replace("\\E","\033");
            }
            public static void parm_down_cursor_init(String in)
            {
                int word_index = (in).indexOf("parm_down_cursor=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug parm_down_cursor" + "thing: " + final_word);
                parm_down_cursor = final_word.replace("\\E","\033");
            }
            public static void parm_ich_init(String in)
            {
                int word_index = (in).indexOf("parm_ich=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug parm_ich" + "thing: " + final_word);
                parm_ich = final_word.replace("\\E","\033");
            }
            public static void parm_insert_line_init(String in)
            {
                int word_index = (in).indexOf("parm_insert_line=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug parm_insert_line" + "thing: " + final_word);
                parm_insert_line = final_word.replace("\\E","\033");
            }
            public static void parm_left_cursor_init(String in)
            {
                int word_index = (in).indexOf("parm_left_cursor=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug parm_left_cursor" + "thing: " + final_word);
                parm_left_cursor = final_word.replace("\\E","\033");
            }
            public static void parm_right_cursor_init(String in)
            {
                int word_index = (in).indexOf("parm_right_cursor=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug parm_right_cursor" + "thing: " + final_word);
                parm_right_cursor = final_word.replace("\\E","\033");
            }
            public static void parm_up_cursor_init(String in)
            {
                int word_index = (in).indexOf("parm_up_cursor=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug parm_up_cursor" + "thing: " + final_word);
                parm_up_cursor = final_word.replace("\\E","\033");
            }
            public static void reset_2string_init(String in)
            {
                int word_index = (in).indexOf("reset_2string=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug reset_2string" + "thing: " + final_word);
                reset_2string = final_word.replace("\\E","\033");
            }
            public static void restore_cursor_init(String in)
            {
                int word_index = (in).indexOf("restore_cursor=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug restore_cursor" + "thing: " + final_word);
                restore_cursor = final_word.replace("\\E","\033");
            }
            public static void save_cursor_init(String in)
            {
                int word_index = (in).indexOf("save_cursor=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug save_cursor" + "thing: " + final_word);
                save_cursor = final_word.replace("\\E","\033");
            }
            public static void scroll_forward_init(String in)
            {
                int word_index = (in).indexOf("scroll_forward=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug scroll_forward" + "thing: " + final_word);
                scroll_forward = final_word.replace("\\E","\033");
            }
            public static void scroll_reverse_init(String in)
            {
                int word_index = (in).indexOf("scroll_reverse=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug scroll_reverse" + "thing: " + final_word);
                scroll_reverse = final_word.replace("\\E","\033");
            }
            public static void set_a_background_init(String in)
            {
                int word_index = (in).indexOf("set_a_background=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug set_a_background" + "thing: " + final_word);
                set_a_background = final_word.replace("\\E","\033");
            }
            public static void set_a_foreground_init(String in)
            {
                int word_index = (in).indexOf("set_a_foreground=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug set_a_foreground" + "thing: " + final_word);
                set_a_foreground = final_word.replace("\\E","\033");
            }
            public static void set_attributes_init(String in)
            {
                int word_index = (in).indexOf("set_attributes=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug set_attributes" + "thing: " + final_word);
                set_attributes = final_word.replace("\\E","\033");
            }
            public static void set_tab_init(String in)
            {
                int word_index = (in).indexOf("set_tab=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug set_tab" + "thing: " + final_word);
                set_tab = final_word.replace("\\E","\033");
            }
            public static void tab_init(String in)
            {
                int word_index = (in).indexOf("tab=");
                //System.out.println("debug word_index" + word_index);
                String new_string = in.substring(word_index);
                //System.out.println("debug new_string_index" + new_string);
                int equals_index = (new_string).indexOf("=");
                int comma_index = new_string.indexOf(",");
                //System.out.println("debug equals comma:" + equals_index + " " + comma_index);
                String final_word = new_string.substring(equals_index + 1,comma_index);
                //System.out.println("debug tab" + "thing: " + final_word);
                tab = final_word.replace("\\E","\033");
            } public static void init_all(String in) {set_vars.back_tab_init(in);
set_vars.bell_init(in);
set_vars.carriage_return_init(in);
set_vars.change_scroll_region_init(in);
set_vars.clear_all_tabs_init(in);
set_vars.clear_screen_init(in);
set_vars.clr_bol_init(in);
set_vars.clr_eol_init(in);
set_vars.clr_eos_init(in);
set_vars.cursor_address_init(in);
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
set_vars.parm_dch_init(in);
set_vars.parm_delete_line_init(in);
set_vars.parm_down_cursor_init(in);
set_vars.parm_ich_init(in);
set_vars.parm_insert_line_init(in);
set_vars.parm_left_cursor_init(in);
set_vars.parm_right_cursor_init(in);
set_vars.parm_up_cursor_init(in);
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


