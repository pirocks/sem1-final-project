import java.io.PrintWriter;

public class positon_eval_refactor
{
    public static PrintWriter writer;
    public static moves_store store = new moves_store();
    public static int board_count;
    public static final double special = 200000.0;
    //everything static for performance
    public static eval_move eval_top(scored_board board_in,boolean white_to_moveq,int depth,prune_data Prune_data,int dot_node)
    {
        int current_dot = dot_writers.add_node();
        dot_writers.link_node(dot_node,current_dot);
        if(depth == 0)
        {
            //need somme shit here
            dot_writers.complete_node(board_in.get_eval(),board_in,current_dot,white_to_moveq,depth);
            return new eval_move(-1,-1,-1,-1,board_in.get_eval());
        }
        else
        {
            move[] moves = new move[8*4//pawns
            + 2*8 //knights
            + 2*(9+9)//bishop
            + 2*(8+8-1)//rooks
            + 2*8 //king
            + 2*(9+9) + 2*(8+8-1)//queen
            ];//need to figure out what actually is
            eval_move eval_to_return;
            int len;
            if(white_to_moveq)
            {
                len = generators.generate_white(board_in,moves,0);
                eval_to_return = call_generated_top(board_in,moves,len,white_to_moveq,depth,Prune_data,current_dot);
                return eval_to_return;
            }
            else
            {
                len = generators.generate_black(board_in,moves,0);
                //for (int i =0;i < len ;i++ ) assert(valid.is_black(moves[i].getPiece(board_in)));
                eval_to_return = call_generated_top(board_in,moves,len,white_to_moveq,depth,Prune_data,current_dot);
                //eval_move to_return = min_max(evals,len,white_to_moveq,depth);
                return eval_to_return;
            }
            
        }
    }
    public static eval_move call_generated_top(scored_board board_in,move[] moves_in,int len,boolean white_to_moveq,int depth,prune_data Prune_data,int dot_node)
    {
        if(white_to_moveq)
            return call_generated_max_top(board_in, moves_in,len,white_to_moveq,depth,Prune_data,dot_node);
        else
            return call_generated_min_top(board_in, moves_in,len,white_to_moveq,depth,Prune_data,dot_node);
    }
    public static eval_move call_generated_max_top(scored_board board_in,move[] moves_in,int len,boolean white_to_moveq,int depth,prune_data Prune_data,int dot_node)
    {
        scored_board current_board;
        move current_move;
        eval_move[] evaluations = new eval_move[len];
        eval_move current;
        if(len == 0)
            return new eval_move(-1,-1,-1,-1,special);
        eval_move max = new eval_move(-1,-1,-1,-1,special);
        for(int i = 0; i < len; i++)
        {
            current_board = scored_board.copy_board(board_in);
            current_move = moves_in[i];
            assert(valid.validinternal(board_in,current_move));
            current_board.apply_move(current_move);//this better be updating scores
            evaluations[i] = new eval_move(current_move,(eval(current_board,!white_to_moveq,depth - 1,new prune_data(max,true),dot_node)).get_value());
            if(!valid.validinternal_all(board_in,evaluations[i]))
                evaluations[i] = new eval_move(-1,-1,-1,-1,special);
            current = evaluations[i];
            if(max.get_value() == special)
                max = current;
            if(current.get_value() > max.get_value() && current.get_value() != special)
                max = current;
            if(Prune_data != null)
            {
                assert(!Prune_data.maxq);
                if(max.get_value() >= Prune_data.Eval_move.get_value())
                    return max;
            }
        }
        dot_writers.complete_node(board_in.get_eval(),board_in,dot_node,white_to_moveq,depth,evaluations,len,max);
        if(max.get_value() == special)
        {
            System.out.print("Ai detected stalemate");
            combinedCurses.raw_mode.leave_raw();
            System.exit(0);
        }
        return max;
        //return evaluations;
    }
    public static eval_move call_generated_min_top(scored_board board_in,move[] moves_in,int len,boolean white_to_moveq,int depth,prune_data Prune_data,int dot_node)
    {
        scored_board current_board;
        move current_move;
        eval_move[] evaluations = new eval_move[len];
        if(len == 0)
            return new eval_move(-1,-1,-1,-1,special);
        eval_move min = new eval_move(-1,-1,-1,-1,special);
        eval_move current;
        for(int i = 0; i < len; i++)
        {
            current_board = scored_board.copy_board(board_in);
            current_move = moves_in[i];
            assert(valid.validinternal(board_in,current_move));
            current_board.apply_move(current_move);//this better be updating scores
            evaluations[i] = new eval_move(current_move,(eval(current_board,!white_to_moveq,depth - 1,new prune_data(min,false),dot_node)).get_value());
            if(!valid.validinternal_all(board_in,evaluations[i]))
                evaluations[i] = new eval_move(-1,-1,-1,-1,special);
            current = evaluations[i];
            if(min.get_value() == special)
                min = current;
            if(current.get_value() < min.get_value() && current.get_value() != special)
                min = current;
            if(Prune_data != null)
            {
                assert(Prune_data.maxq);
                if(min.get_value() <= Prune_data.Eval_move.get_value())
                    return min;
            }
        }
        if(min.get_value() == special)
        {
            System.out.print("Ai detected stalemate");
            combinedCurses.raw_mode.leave_raw();
            System.exit(0);
        }
        dot_writers.complete_node(board_in.get_eval(),board_in,dot_node,white_to_moveq,depth,evaluations,len,min);
        return min;
        
    }
    public static eval_move call_generated(scored_board board_in,move[] moves_in,int len,boolean white_to_moveq,int depth,prune_data Prune_data,int dot_node)
    {
        if(white_to_moveq)
            return call_generated_max(board_in, moves_in,len,white_to_moveq,depth,Prune_data,dot_node);
        else
            return call_generated_min(board_in, moves_in,len,white_to_moveq,depth,Prune_data,dot_node);
    }
    public static eval_move call_generated_max(scored_board board_in,move[] moves_in,int len,boolean white_to_moveq,int depth,prune_data Prune_data,int dot_node)
    {
        scored_board current_board;
        move current_move;
        eval_move[] evaluations = new eval_move[len];
        eval_move current;
        if(len == 0)
            return new eval_move(-1,-1,-1,-1,special);
        eval_move max = new eval_move(-1,-1,-1,-1,special);
        for(int i = 0; i < len; i++)
        {
            current_board = scored_board.copy_board(board_in);
            current_move = moves_in[i];
            assert(valid.validinternal(board_in,current_move));
            current_board.apply_move(current_move);//this better be updating scores
            evaluations[i] = new eval_move(current_move,(eval(current_board,!white_to_moveq,depth - 1,new prune_data(max,true),dot_node)).get_value());
            current = evaluations[i];
            if(max.get_value() == special)
                max = current;
            if(current.get_value() > max.get_value() && current.get_value() != special)
                max = current;
            if(Prune_data != null)
            {
                assert(!Prune_data.maxq);
                if(max.get_value() >= Prune_data.Eval_move.get_value())
                    return max;
            }
        }
        dot_writers.complete_node(board_in.get_eval(),board_in,dot_node,white_to_moveq,depth,evaluations,len,max);
        return max;
        //return evaluations;
    }
    public static eval_move call_generated_min(scored_board board_in,move[] moves_in,int len,boolean white_to_moveq,int depth,prune_data Prune_data,int dot_node)
    {
        scored_board current_board;
        move current_move;
        eval_move[] evaluations = new eval_move[len];
        if(len == 0)
            return new eval_move(-1,-1,-1,-1,special);
        eval_move min = new eval_move(-1,-1,-1,-1,special);
        eval_move current;
        for(int i = 0; i < len; i++)
        {
            current_board = scored_board.copy_board(board_in);
            current_move = moves_in[i];
            assert(valid.validinternal(board_in,current_move));
            current_board.apply_move(current_move);//this better be updating scores
            evaluations[i] = new eval_move(current_move,(eval(current_board,!white_to_moveq,depth - 1,new prune_data(min,false),dot_node)).get_value());
            current = evaluations[i];
            if(min.get_value() == special)
                min = current;
            if(current.get_value() < min.get_value() && current.get_value() != special)
                min = current;
            if(Prune_data != null)
            {
                assert(Prune_data.maxq);
                if(min.get_value() <= Prune_data.Eval_move.get_value())
                    return min;
            }
        }
        dot_writers.complete_node(board_in.get_eval(),board_in,dot_node,white_to_moveq,depth,evaluations,len,min);
        return min;
        
    }
    public static eval_move eval(scored_board board_in,boolean white_to_moveq,int depth,prune_data Prune_data,int dot_node)
    {
        int current_dot = dot_writers.add_node();
        dot_writers.link_node(dot_node,current_dot);
        if(depth == 0)
        {
            //need somme shit here
            dot_writers.complete_node(board_in.get_eval(),board_in,current_dot,white_to_moveq,depth);
            return new eval_move(-1,-1,-1,-1,board_in.get_eval());
        }
        else
        {
            move[] moves = new move[8*4//pawns
            + 2*8 //knights
            + 2*(9+9)//bishop
            + 2*(8+8-1)//rooks
            + 2*8 //king
            + 2*(9+9) + 2*(8+8-1)//queen
            ];//need to figure out what actually is
            eval_move eval_to_return;
            int len;
            if(white_to_moveq)
            {
                len = generators.generate_white(board_in,moves,0);
                eval_to_return = call_generated(board_in,moves,len,white_to_moveq,depth,Prune_data,current_dot);
                return eval_to_return;
            }
            else
            {
                len = generators.generate_black(board_in,moves,0);
                for (int i =0;i < len ;i++ ) assert(valid.is_black(moves[i].getPiece(board_in)));
                eval_to_return = call_generated(board_in,moves,len,white_to_moveq,depth,Prune_data,current_dot);
                //eval_move to_return = min_max(evals,len,white_to_moveq,depth);
                
                return eval_to_return;
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
                return generate_rook(board_in,out,temp,x_in,y_in);
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
    
    // PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
    // writer.println("The first line");
    // writer.println("The second line");
    // writer.close();
    public static class dot_writers
    {
        public static void init()
        {
            try{
            writer =  new PrintWriter("out.dot", "UTF-8");
            }
            catch(Exception e)
            {
                System.out.print("failed to init");
                utils.sleep(100000);
                return;
            }
            writer.println("digraph mygraph {");
            board_count = 0;
        }
        // public static int add_node(int value_in,board board_in)
        // {
        //     board_count++;
        // 	writer.println(String.format("a%d [label=\"",board_count));
        // 	writer.println(String.format("%s\n value: %d\n node:a%d\"] [fontname = \"Courier\"];\n",utils.create_fancy_board(board_in),value_in,board_count));
        // 	return board_count;
        // }
        public static int add_node()
        {
            //System.out.println(writer);
        	board_count++;
    		writer.print(String.format("a%d;",board_count));
            return board_count;
        }
        public static void link_node(int node1,int node2)
        {
            writer.print(String.format("a%d -> a%d;\n",node1,node2));
        }
        public static int complete_node(double value_in,board board_in,int board_in_count,boolean white_to_moveq,int depth)
        {
        	writer.print(String.format("a%d [label=\"",board_in_count));
        // 	String[] array = utils.create_fancy_board(board_in);
        // 	String out = "\n";
        // 	for(int i=0;i<array.length;i++)
        // 	{
        // 	    out+=array[i];
        // 	    out+="\n";
        // 	}
        	writer.print(String.format("%s value: %f node:a%d white_to_moveq:%s depth: %d\"] [fontname = \"Courier\"];\n",board_in.toString_non_fancy(),value_in,board_in_count,white_to_moveq+"",depth));
        	return board_count;
        }
        public static int complete_node(double value_in,board board_in,int board_in_count,boolean white_to_moveq,int depth,eval_move[] array,int len,eval_move result)
        {
        	writer.print(String.format("a%d [label=\"",board_in_count));
        	String arrayString="[";
        	for(int i = 0; i < len;i++)
        	{
        	    arrayString+=array[i].get_value() + "";
        	    arrayString+=",";
        	}
        	arrayString+="]";
        	arrayString+=String.format("min_max:%f",result.get_value());
        	writer.print(String.format("%s value: %f node:a%d white_to_moveq:%s depth: %d,array:\n%s\n\"] [fontname = \"Courier\"];\n",board_in.toString_non_fancy(),value_in,board_in_count,white_to_moveq+"",depth,arrayString));
        	return board_count;
        }
        public static void close()
        {
            writer.print("}");
            writer.close();
        }
    }
}
