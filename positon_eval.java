
public class positon_eval 
{
    public static final double special = 200000.0;
    //everything static for performance
    public static double call_generated(board board_in,move[] moves_in,int len)
    {
        double[] evaluations = new double[1000];//need to figue out what actually is
        for(int i = 0; i < len; i++)
        {
            
            evaluations[i] = eval();
        }
    }
    public static double eval(scored_board board_in,boolean white_to_moveq,int depth)
    {
        if(depth == 0)
        {
            return board_in.get_eval();
        }
        else
        {
            move[] moves;
            if(white_to_moveq)
            {
                generators.generate_white(board_in,moves,0);
            }
            else
            {
                generators.generate_black(board_in,moves,0);
            }
        }
    }
    public static class generators
    {
        public static int generate_white(board board_in,move[] out,int len)
        {
            int len_out = len;
            int piece;
            int[][] b = board_in.toArray();
            for(int y = 0; y < b.length;y++)//not sute this is actually y but doesn't matter
                for(int x = 0; x < b[0].length;x++)
                {
                    piece = b[y][x];
                    switch(piece)
                    {
                        case pieces.white.pawn:
                            len_out = individual.generate_pawn_white(board_in,out,len_out,x,y);
                            break;
                        case pieces.white.knight:
                            len_out = individual.generate_knight(board_in,out,len_out,x,y);
                            break;
                        case pieces.white.king:
                            len_out = individual.generate_king(board_in,out,len_out,x,y);
                            break;
                        case pieces.white.bishop:
                            len_out = individual.generate_bishop(board_in,out,len_out,x,y);
                            break;
                        case pieces.white.queen:
                            len_out = individual.generate_queen(board_in,out,len_out,x,y);
                            break;
                        case pieces.white.rook:
                            len_out = individual.generate_rook(board_in,out,len_out,x,y);
                            break;
                    }
                }
        }
        public static int generate_black(board board_in,move[] out,int len)
        {
            int len_out = len;
            int piece;
            int[][] b = board_in.toArray();
            for(int y = 0; y < b.length;y++)//not sute this is actually y but doesn't matter
                for(int x = 0; x < b[0].length;x++)
                {
                    piece = b[y][x];
                    switch(piece)
                    {
                        case pieces.white.pawn:
                            len_out = individual.generate_pawn_black(board_in,out,len_out,x,y);
                            break;
                        case pieces.white.knight:
                            len_out = individual.generate_knight(board_in,out,len_out,x,y);
                            break;
                        case pieces.white.king:
                            len_out = individual.generate_king(board_in,out,len_out,x,y);
                            break;
                        case pieces.white.bishop:
                            len_out = individual.generate_bishop(board_in,out,len_out,x,y);
                            break;
                        case pieces.white.queen:
                            len_out = individual.generate_queen(board_in,out,len_out,x,y);
                            break;
                        case pieces.white.rook:
                            len_out = individual.generate_rook(board_in,out,len_out,x,y);
                            break;
                    }
                }
        }
        public static class individual
        {
            public static int generate_queen(board board_in,move[] out,int len,int x_in,int y_in) // returns new len
            {
                int temp = generate_bishop(board_in,out,len,x_in,y_in);
                return generate_rook(board_in,out,len,x_in,y_in);
            }
            public static int generate_bishop(board board_in,move[] out,int len,int x_in,int y_in)
            {
                int templen = len;
                int x;
                int y;
                move current_move;
                for(x = 1,y = 1,current_move = new move(x_in,y_in,x_in + x,y_in + y); valid.validinternal(board_in,current_move);x++,y++,current_move = new move(x_in,y_in,x_in + x,y_in + y))
                {
                    out[templen] = current_move;
                    templen++;
                }
                for(x = -1,y = 1,current_move = new move(x_in,y_in,x_in + x,y_in + y); valid.validinternal(board_in,current_move);x--,y++,current_move = new move(x_in,y_in,x_in + x,y_in + y))
                {
                    out[templen] = current_move;
                    templen++;
                }
                x = 0;
                for(x = 1,y = -1,current_move = new move(x_in,y_in,x_in + x,y_in + y); valid.validinternal(board_in,current_move);x++,y--,current_move = new move(x_in,y_in,x_in + x,y_in + y))
                {
                    out[templen] = current_move;
                    templen++;
                }
                for(x = -1,y = -1,current_move = new move(x_in,y_in,x_in + x,y_in + y); valid.validinternal(board_in,current_move);x--,y--,current_move = new move(x_in,y_in,x_in + x,y_in + y))
                {
                    out[templen] = current_move;
                    templen++;
                }
                return templen;
            }
            public static int generate_rook(board board_in,move[] out,int len,int x_in,int y_in)
            {
                int templen = len;
                int x = 0;
                int y = 0;
                move current_move;
                for(x = 1,current_move = new move(x_in,y_in,x_in + x,y_in + y); valid.validinternal(board_in,current_move);x++,current_move = new move(x_in,y_in,x_in + x,y_in + y))
                {
                    out[templen] = current_move;
                    templen++;
                }
                for(x = -1,current_move = new move(x_in,y_in,x_in + x,y_in + y); valid.validinternal(board_in,current_move);x--,current_move = new move(x_in,y_in,x_in + x,y_in + y))
                {
                    out[templen] = current_move;
                    templen++;
                }
                x = 0;
                for(y = 1,current_move = new move(x_in,y_in,x_in + x,y_in + y); valid.validinternal(board_in,current_move);y++,current_move = new move(x_in,y_in,x_in + x,y_in + y))
                {
                    out[templen] = current_move;
                    templen++;
                }
                for(y = -1,current_move = new move(x_in,y_in,x_in + x,y_in + y); valid.validinternal(board_in,current_move);y--,current_move = new move(x_in,y_in,x_in + x,y_in + y))
                {
                    out[templen] = current_move;
                    templen++;
                }
                return templen;
            }
            public static int generate_knight(board board_in,move[] out,int len,int x_in,int y_in)
            {
                int templen = len;
                move current_move;
                for(int i = 0; i < moves_store.knight.length;i++)
                {
                    current_move = moves_store.knight[i].to_move(x_in,y_in);
                    if(valid.validinternal(board_in,current_move))
                    {
                        out[templen] = current_move;
                        templen++;
                    }
                }
                return templen;
            }
            public static int generate_king(board board_in,move[] out,int len,int x_in,int y_in)
            {
                 int templen = len;
                move current_move;
                for(int i = 0; i < moves_store.king.length;i++)
                {
                    current_move = moves_store.king[i].to_move(x_in,y_in);
                    if(valid.validinternal(board_in,current_move))
                    {
                        out[templen] = current_move;
                        templen++;
                    }
                }
                return templen;
            }
            public static int generate_pawn_white(board board_in,move[] out,int len,int x_in,int y_in)
            {
                int templen = len;
                move current_move;
                for(int i = 0; i < moves_store.pawn_white.length;i++)
                {
                    current_move = moves_store.pawn_white[i].to_move(x_in,y_in);
                    if(valid.validinternal(board_in,current_move))
                    {
                        out[templen] = current_move;
                        templen++;
                    }
                }
                return templen; 
            }
            public static int generate_pawn_black(board board_in,move[] out,int len,int x_in,int y_in)
            {
                int templen = len;
                move current_move;
                for(int i = 0; i < moves_store.pawn_black.length;i++)
                {
                    current_move = moves_store.pawn_black[i].to_move(x_in,y_in);
                    if(valid.validinternal(board_in,current_move))
                    {
                        out[templen] = current_move;
                        templen++;
                    }
                }
                return templen;
            }
        }
    }
    public static double min_max(eval_move[] array,int len,boolean white_to_moveq,int depth)
    {
        if(white_to_moveq)
            return max(array,len);
        else
            return min(array,len);
    }
    public static double min(eval_move[] array,int len)
    {
        double current;
        if(len == 0)
            return special;
        double min = array[0].get_value();
        for(int i = 0; i < len; i++)
        {
            current = array[i].get_value();
            if(min == special)
                min = current;
            if(current < min && current != special)
                min = current;
        }
        return min;
    }
    public static double max(eval_move[] array,int len)
    {
        double current;
        if(len == 0)
            return special;
        double max = array[0].get_value();
        for(int i = 0; i < len; i++)
        {
            current = array[i].get_value();
            if(max == special)
                max = current;
            if(current < max && current != special)
                max = current;
        }
        return max;
    }
    
}
