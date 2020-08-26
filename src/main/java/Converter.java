import java.util.*;

public class Converter {

    private static final HashMap<Character, String> LOTINLETTERS = new HashMap<Character, String>() {
        {
            put('а', "a");
            put('б', "b");
            put('c', "s");
            put('д', "d");
            put('е', "e");
            put('э', "e");
            put('ф', "f");
            put('г', "g");
            put('ҳ', "h");
            put('и', "i");
            put('ж', "j");
            put('к', "k");
            put('л', "l");
            put('м', "m");
            put('н', "n");
            put('о', "o");
            put('п', "p");
            put('қ', "q");
            put('р', "r");
            put('с', "s");
            put('т', "t");
            put('у', "u");
            put('в', "v");
            put('х', "x");
            put('й', "y");
            put('з', "z");
            put('ё', "yo");
            put('ю', "yu");
            put('я', "ya");
            put('ц', "ts");
            put('ш', "sh");
            put('щ', "sh");
            put('ў', "o`");
            put('ъ', "'");
            put('ч', "ch");
            put('ь', "");
            put('ғ', "g`");
            put('w', "w");
            put('\n', "\n");
            put('\b', "\b");
            put('\t', "\t");
            put('\f', "\f");
            put('\r', "\r");
        }
    };

    private static final HashMap<String, Character> KRILLLETTERS = new HashMap<String, Character>() {
        {
            put("a", 'а');
            put("b", 'б');
            put("d", 'д');
            put("e", 'е');
            put("f", 'ф');
            put("g", 'г');
            put("g‘", 'ғ');
            put("g'", 'ғ');
            put("G`", 'Ғ');
            put("G'", 'Ғ');
            put("h", 'ҳ');
            put("i", 'и');
            put("j", 'ж');
            put("k", 'к');
            put("l", 'л');
            put("m", 'м');
            put("n", 'н');
            put("o", 'о');
            put("p", 'п');
            put("q", 'қ');
            put("r", 'р');
            put("s", 'с');
            put("t", 'т');
            put("o‘", 'ў');
            put("o'", 'ў');
            put("O'", 'Ў');
            put("O`", 'Ў');
            put("u", 'у');
            put("v", 'в');
            put("x", 'х');
            put("y", 'й');
            put("z", 'з');
            put("w", 'w');
            put("'", 'ъ');
            put("’", 'ъ');
            put("ch", 'ч');
            put("Ch", 'Ч');
            put("sh", 'ш');
            put("Sh", 'Ш');
            put("\n", '\n');
            put("\b", '\b');
            put("\t", '\t');
            put("\f", '\f');
            put("\r", '\r');
        }
    };

    private static final HashMap<String, String> ILLEGALKRILLWORDS = new HashMap<String, String>() {
        {
            put("цирк", "sirk");
            put("Цирк", "Sirk");
            put("ер", "yer");
            put("Ер", "Yer");
            put("ерлик", "yerlik");
            put("Ерлик", "Yerlik");
            put("енг", "yeng");
            put("Енг", "Yeng");
        }
    };

    private static final HashMap<String, String> ILLEGALLOTINWORDS = new HashMap<String, String>() {
        {
            put("sirk", "цирк");
            put("Sirk", "Цирк");
            put("Yer", "Ер");
            put("yer", "ер");
            put("Elon", "Элон");
            put("elon", "элон");
            put("eski", "эски");
            put("Eski", "Эски");
            put("eshik", "эшик");
            put("Eshik", "Эшик");
            put("Egar", "эгар");
            put("egar", "Эгар");
            put("Egri", "Эгри");
            put("egri", "эгри");
        }
    };

    public static StringBuilder convertToKrill(String lotin) {
        StringBuilder result = new StringBuilder();
        for (String key :
                ILLEGALLOTINWORDS.keySet()) {
            if (lotin.contains(key)) {
                lotin = lotin.replace(key, ILLEGALLOTINWORDS.get(key));
            }
        }
        char[] array = lotin.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (KRILLLETTERS.containsKey(String.valueOf(c).toLowerCase())) {
                if (i != array.length - 1) {
                    String s = "" + c + array[i + 1];
                    if (KRILLLETTERS.containsKey(s)) {
                        result.append(KRILLLETTERS.get(s));
                        i++;
                        continue;
                    }
                }
                if (Character.isUpperCase(c)) {
                    c = Character.toLowerCase(c);
                    result.append(Character.toUpperCase((Character) KRILLLETTERS.get(String.valueOf(c))));
                } else {
                    result.append(KRILLLETTERS.get(String.valueOf(c)));
                }
            } else {
                result.append(c);
            }
        }
        return result;
    }

    public static StringBuilder convertToLotin(String krill) {
        StringBuilder result = new StringBuilder();
        for (String key :
                ILLEGALKRILLWORDS.keySet()) {
            if (krill.contains(key)) {
                krill = krill.replace(key, ILLEGALKRILLWORDS.get(key));
            }
        }
        char[] array = krill.toCharArray();
        for (char c : array) {
            if (LOTINLETTERS.containsKey(Character.toLowerCase(c))) {
                if (Character.isUpperCase(c)) {
                    c = Character.toLowerCase(c);
                    result.append(LOTINLETTERS.get(c).toUpperCase());
                } else {
                    result.append(LOTINLETTERS.get(c));
                }
            } else {
                result.append(c);
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(convertToKrill("Bolalar Ombudsmani Aliya Yunusova maxsus ixtisoslashtirilgan muassasalardagi bolalarni deinstitutsionalizatsiya qilish vazifalari haqida gapirib berdi."));
        System.out.println(convertToKrill("Yer, eshik, Sirk"));
    }
}
