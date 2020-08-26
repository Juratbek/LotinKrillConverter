import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    @Test
    void convertToKrill() {
        String result = String.valueOf(Converter.convertToKrill("Salom dunyo."));
        assertEquals("Салом дунйо.", result);
    }

    @Test
    void convertToKrill_unusual_words() {
        String result = String.valueOf(Converter.convertToKrill("Yer, eshik, Sirk"));
        assertEquals("Ер, эшик, Цирк", result);
    }

    @Test
    void convertToLotin() {
        String result = String.valueOf(Converter.convertToLotin("Салом дунйо."));
        assertEquals("Salom dunyo.", result);
    }

    @Test
    void convertToLotin_unusual_words() {
        String result = String.valueOf(Converter.convertToLotin("Цирк, ер, енг, Ер."));
        assertEquals("Sirk, yer, yeng, Yer.", result);
    }
}