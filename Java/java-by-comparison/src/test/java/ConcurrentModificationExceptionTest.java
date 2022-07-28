import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ConcurrentModificationExceptionTest {

    private List<String> list = new ArrayList<>();

    @BeforeEach
    void setList() {
        list.add("a");
        list.add("b");
        list.add("c");
    }

    @Test
    @DisplayName("enhanced for loop 내에서 데이터를 조작할 경우 충돌 에러")
    void enhancedFor() {
        assertThrows(ConcurrentModificationException.class, () -> {
            for (String s : list) {
                list.remove("a");
            }
        });
    }

    @Test
    @DisplayName("컬렉션 내 데이터를 조작할 때는 iterator 사용")
    void iterator() {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (Objects.equals("a", iterator.next())) {
                iterator.remove();
            }
        }
        assertEquals(2, list.size());
    }
}
