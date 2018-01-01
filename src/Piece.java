/**
 * Created by bettychang on 12/31/17.
 */
public enum Piece {
    ONE(1, 1, 238, 100),
    TWO(2, 2, 204, 150),
    THREE(3, 2, 272, 150),
    FOUR(4, 3, 170, 200),
    FIVE(5, 3, 238, 200),
    SIX(6, 3, 306, 200),
    SEVEN(7, 4, 136, 250),
    EIGHT(8, 4, 204, 250),
    NINE(9, 4, 272, 250),
    TEN(10, 4, 340, 250),
    ELEVEN(11, 5, 102, 300),
    TWELVE(12, 5, 170, 300),
    THIRTEEN(13, 5, 238, 300),
    FOURTEEN(14, 5, 306, 300),
    FIFTEEN(15, 5, 374, 300);

    static final int SIZE = 24;
    static final int MARGIN = 2;
    int id;
    int level;
    int x;
    int y;

    Piece(int id, int level, int x, int y) {
        this.id = id;
        this.level = level;
        this.x = x;
        this.y = y;
    }

    public boolean inBounds(int mouseX, int mouseY) {
        if (mouseX < x - MARGIN || mouseX > x + SIZE + MARGIN) {
            return false;
        }
        if (mouseY < y - MARGIN || mouseY > y + SIZE + MARGIN) {
            return false;
        }
        return true;
    }
}
