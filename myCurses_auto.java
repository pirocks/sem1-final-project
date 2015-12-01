
import java.io.*;
import java.util.Scanner;

public class myCurses
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
            public static void back_tab_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        back_tab = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void bell_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        bell = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void carriage_return_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        carriage_return = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void change_scroll_region_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        change_scroll_region = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void clear_all_tabs_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        clear_all_tabs = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void clear_screen_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        clear_screen = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void clr_bol_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        clr_bol = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void clr_eol_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        clr_eol = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void clr_eos_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        clr_eos = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void cursor_address_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        cursor_address = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void cursor_down_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        cursor_down = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void cursor_home_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        cursor_home = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void cursor_invisible_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        cursor_invisible = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void cursor_left_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        cursor_left = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void cursor_normal_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        cursor_normal = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void cursor_right_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        cursor_right = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void cursor_up_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        cursor_up = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void cursor_visible_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        cursor_visible = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void delete_character_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        delete_character = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void delete_line_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        delete_line = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void ena_acs_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        ena_acs = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void enter_alt_charset_mode_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        enter_alt_charset_mode = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void enter_blink_mode_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        enter_blink_mode = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void enter_bold_mode_init(String[] in)
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
            }public static void enter_ca_mode_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        enter_ca_mode = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void enter_insert_mode_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        enter_insert_mode = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void enter_reverse_mode_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        enter_reverse_mode = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void enter_standout_mode_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        enter_standout_mode = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void enter_underline_mode_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        enter_underline_mode = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void exit_alt_charset_mode_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        exit_alt_charset_mode = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void exit_attribute_mode_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        exit_attribute_mode = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void exit_ca_mode_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        exit_ca_mode = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void exit_insert_mode_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        exit_insert_mode = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void exit_standout_mode_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        exit_standout_mode = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void exit_underline_mode_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        exit_underline_mode = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void flash_screen_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        flash_screen = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void init_2string_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        init_2string = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void insert_line_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        insert_line = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void key_backspace_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        key_backspace = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void key_btab_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        key_btab = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void key_dc_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        key_dc = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void key_down_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        key_down = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void key_end_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        key_end = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void key_f1_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        key_f1 = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void key_f10_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        key_f10 = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void key_f11_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        key_f11 = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void key_f12_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        key_f12 = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void key_f2_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        key_f2 = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void key_f3_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        key_f3 = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void key_f4_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        key_f4 = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void key_f5_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        key_f5 = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void key_f6_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        key_f6 = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void key_f7_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        key_f7 = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void key_f8_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        key_f8 = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void key_f9_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        key_f9 = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void key_home_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        key_home = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void key_ic_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        key_ic = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void key_left_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        key_left = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void key_mouse_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        key_mouse = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void key_npage_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        key_npage = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void key_ppage_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        key_ppage = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void key_right_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        key_right = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void key_up_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        key_up = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void keypad_local_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        keypad_local = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void keypad_xmit_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        keypad_xmit = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void newline_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        newline = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void orig_pair_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        orig_pair = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void parm_dch_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        parm_dch = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void parm_delete_line_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        parm_delete_line = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void parm_down_cursor_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        parm_down_cursor = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void parm_ich_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        parm_ich = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void parm_insert_line_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        parm_insert_line = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void parm_left_cursor_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        parm_left_cursor = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void parm_right_cursor_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        parm_right_cursor = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void parm_up_cursor_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        parm_up_cursor = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void reset_2string_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        reset_2string = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void restore_cursor_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        restore_cursor = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void save_cursor_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        save_cursor = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void scroll_forward_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        scroll_forward = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void scroll_reverse_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        scroll_reverse = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void set_a_background_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        set_a_background = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void set_a_foreground_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        set_a_foreground = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void set_attributes_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        set_attributes = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void set_tab_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        set_tab = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }public static void tab_init(String[] in)
            {
                int index = -1;
                for(int i = 0; i < in.length; i++)
                {
                    index = (in[i]).indexOf("\\");
                    if((in[i]).indexOf("enter_bold_mode") != -1)
                    {
                        tab = in[i].substring(index,in[i].length() - 1).replace("\\E","\033");
                        System.out.println(enter_bold_mode);
                    }
                }
            }}
    }
    public static void init()
    {
        System.out.print(buffer_init);
    }
}


