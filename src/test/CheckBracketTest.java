import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckBracketTest {

    @Test
    void checkBracket() {
        assertEquals(-1, CheckBracket.checkBracket(""));
        assertEquals(-1, CheckBracket.checkBracket("()[]{}"));
        assertEquals(0, CheckBracket.checkBracket(")"));
        assertEquals(1, CheckBracket.checkBracket("["));
        assertEquals(2, CheckBracket.checkBracket("{}}"));
        assertEquals(4, CheckBracket.checkBracket("[fkv}"));//на четвертом месте должна стоять скобка { чтобы было [fkv{}...
        assertEquals(-1, CheckBracket.checkBracket("(12 + A[0]) / ((b{0, 1} - c {6, n}) * 2)"));
        assertEquals(-1, CheckBracket.checkBracket("(((((()[[]]){()})())[[[]]]){[][]})"));
        assertEquals(3, CheckBracket.checkBracket("{[(])}"));
        assertEquals(8, CheckBracket.checkBracket("{a[b(c)b}a"));

    }
}