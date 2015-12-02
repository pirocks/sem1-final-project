public class moves_store
{
    /*
    a_move white_moves[4] = {
    {0,-1},
    {-1,-1},
    {1,-1},
    {0,-2},
    };
    a_move black_moves[4] = {
        {0,1},
        {-1,1},
        {1,1},
        {0,2},
    };
    a_move white_moves_pawn[4] = {
        {0,-1},
        {-1,-1},
        {1,-1},
        {0,-2},
    };
    a_move black_moves_pawn[4] = {
        {0,1},
        {-1,1},
        {1,1},
        {0,2},
    };
    a_move king_moves[8] = {
        {0,1},
        {0,-1},
        {1,1},
        {1,-1},
        {1,0},
        {-1,1},
        {-1,0},
        {-1,-1},
    };
    a_move knight_moves[8] = {
    {1,2},
    {1,-2},
    {-1,2},
    {-1,-2},
    {2,1},
    {2,-1},
    {-2,1},
    {-2,-1},
};
    
    */
    public static generic_move pawn_white[];
    public static generic_move pawn_black[];
    public static generic_move knight[];
    public static generic_move king[];
    
    public moves_store()
    {
        pawn_white = new generic_move[] {
            new generic_move(0,-1),
            new generic_move(-1,-1),
            new generic_move(1,-1),
            new generic_move(0,-2)
        };
        pawn_black = new generic_move[] {
            new generic_move(0,1),
            new generic_move(-1,1),
            new generic_move(1,1),
            new generic_move(0,2)
        };
        knight = new generic_move[] {
            new generic_move(1,2),
            new generic_move(1,-2),
            new generic_move(-1,2),
            new generic_move(-1,-2),
            new generic_move(2,1),
            new generic_move(2,-1),
            new generic_move(-2,1),
            new generic_move(-2,-1),
        };
        king = new generic_move[] {
            new generic_move(0,1),
            new generic_move(0,-1),
            new generic_move(1,-1),
            new generic_move(1,1),
            new generic_move(1,0),
            new generic_move(-1,1),
            new generic_move(-1,0),
            new generic_move(-1,-1),
        };
    }
}