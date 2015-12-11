
public class positon_eval 
{
    public static moves_store store = new moves_store();
    public static final double special = 200000.0;
    //everything static for performance
    public static eval_move[] call_generated(scored_board board_in,move[] moves_in,int len,boolean white_to_moveq,int depth,prune_data Prune_data)
    {
        scored_board current_board;
        move current_move;
        eval_move[] evaluations = new eval_move[len];
        for(int i = 0; i < len; i++)
        {
            current_board = scored_board.copy_board(board_in);
            current_move = moves_in[i];
            assert(valid.validinternal(board_in,current_move));
            current_board.apply_move(current_move);//this better be updating scores
            //add tons of asserts
            evaluations[i] = new eval_move(current_move,(eval(current_board,!white_to_moveq,depth - 1,Prune_data)).get_value());
        }
        return evaluations;
    }
    public static eval_move eval(scored_board board_in,boolean white_to_moveq,int depth,prune_data Prune_data)
    {
        if(depth == 0)
        {
            //need somme shit here
            return new eval_move(-1,-1,-1,-1,board_in.get_eval());
        }
        else
        {
            move[] moves = new move[1000];//need to figure out what actually is
            eval_move evals[];
            int len;
            if(white_to_moveq)
            {
                len = generators.generate_white(board_in,moves,0);
                evals = call_generated(board_in,moves,len,white_to_moveq,depth,Prune_data);
                return min_max(evals,len,white_to_moveq,depth);
            }
            else
            {
                len = generators.generate_black(board_in,moves,0);
                for (int i =0;i < len ;i++ ) assert(valid.is_black(moves[i].getPiece(board_in)));
                evals = call_generated(board_in,moves,len,white_to_moveq,depth,Prune_data);
                return min_max(evals,len,white_to_moveq,depth);
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
            return len_out;
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
                        case pieces.black.pawn:
                            len_out = individual.generate_pawn_black(board_in,out,len_out,x,y);
                            break;
                        case pieces.black.knight:
                            len_out = individual.generate_knight(board_in,out,len_out,x,y);
                            break;
                        case pieces.black.king:
                            len_out = individual.generate_king(board_in,out,len_out,x,y);
                            break;
                        case pieces.black.bishop:
                            len_out = individual.generate_bishop(board_in,out,len_out,x,y);
                            break;
                        case pieces.black.queen:
                            len_out = individual.generate_queen(board_in,out,len_out,x,y);
                            break;
                        case pieces.black.rook:
                            len_out = individual.generate_rook(board_in,out,len_out,x,y);
                            break;
                    }
                }
            return len_out;
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
                //for (int i =len;i < templen ;i++ ) assert(valid.is_black(out[i].getPiece(board_in)));
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
                //for (int i =len;i < templen ;i++ ) assert(valid.is_black(out[i].getPiece(board_in)));
                return templen;
            }
            public static int generate_knight(board board_in,move[] out,int len,int x_in,int y_in)
            {
                int templen = len;
                move current_move;
                for(int i = 0; i < store.knight.length;i++)
                {
                    current_move = store.knight[i].to_move(x_in,y_in);
                    if(valid.validinternal(board_in,current_move))
                    {
                        out[templen] = current_move;
                        templen++;
                    }
                }
                //for (int i =len;i < templen ;i++ ) assert(valid.is_black(out[i].getPiece(board_in)));
                return templen;
            }
            public static int generate_king(board board_in,move[] out,int len,int x_in,int y_in)
            {
                 int templen = len;
                move current_move;
                for(int i = 0; i < store.king.length;i++)
                {
                    current_move = store.king[i].to_move(x_in,y_in);
                    if(valid.validinternal(board_in,current_move))
                    {
                        out[templen] = current_move;
                        templen++;
                    }
                }
                //for (int i =len;i < templen ;i++ ) assert(valid.is_black(out[i].getPiece(board_in)));
                return templen;
            }
            public static int generate_pawn_white(board board_in,move[] out,int len,int x_in,int y_in)
            {
                int templen = len;
                move current_move;
                for(int i = 0; i < store.pawn_white.length;i++)
                {
                    current_move = store.pawn_white[i].to_move(x_in,y_in);
                    if(valid.validinternal(board_in,current_move))
                    {
                        out[templen] = current_move;
                        templen++;
                    }
                }
                //for (int i =len;i < templen ;i++ ) assert(valid.is_black(out[i].getPiece(board_in)));
                return templen; 
            }
            public static int generate_pawn_black(board board_in,move[] out,int len,int x_in,int y_in)
            {
                int templen = len;
                move current_move;
                for(int i = 0; i < store.pawn_black.length;i++)
                {
                    current_move = store.pawn_black[i].to_move(x_in,y_in);
                    if(valid.validinternal(board_in,current_move))
                    {
                        out[templen] = current_move;
                        templen++;
                    }
                }
                //for (int i =len;i < templen ;i++ ) assert(valid.is_black(out[i].getPiece(board_in)));
                return templen;
            }
        }
    }
    public static eval_move min_max(eval_move[] array,int len,boolean white_to_moveq,int depth)
    {
        if(white_to_moveq)
            return max(array,len);
        else
            return min(array,len);
    }
    public static eval_move min(eval_move[] array,int len)
    {
        eval_move current;
        if(len == 0)
            return new eval_move(-1,-1,-1,-1,special);
        eval_move min = array[0];
        for(int i = 0; i < len; i++)
        {
            current = array[i];
            if(min.get_value() == special)
                min = current;
            if(current.get_value() < min.get_value() && current.get_value() != special)
                min = current;
        }
        return min;
    }
    public static eval_move max(eval_move[] array,int len)
    {
        eval_move current;
        if(len == 0)
            return new eval_move(-1,-1,-1,-1,special);
        eval_move max = array[0];
        for(int i = 1; i < len; i++)
        {
            current = array[i];
            if(max.get_value() == special)
                max = current;
            if(current.get_value() < max.get_value() && current.get_value() != special)
                max = current;
        }
        return max;
    }
    
}
