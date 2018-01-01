/**
 * Created by bettychang on 12/31/17.
 */
public enum Piece {
    ONE(1, 238, 100),
    TWO(2, 204, 150),
    THREE(3, 272, 150),
    FOUR(4, 170, 200),
    FIVE(5, 238, 200),
    SIX(6, 306, 200),
    SEVEN(7, 136, 250),
    EIGHT(8, 204, 250),
    NINE(9, 272, 250),
    TEN(10, 340, 250),
    ELEVEN(11, 102, 300),
    TWELVE(12, 170, 300),
    THIRTEEN(13, 238, 300),
    FOURTEEN(14, 306, 300),
    FIFTEEN(15, 374, 300)
    ;

    static final int SIZE = 24;
    int id;
    int x;
    int y;

    Piece(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }
}
