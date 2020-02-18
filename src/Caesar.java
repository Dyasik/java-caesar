import java.util.ArrayList;
import java.util.List;

public class Caesar {

    private static String SOURCE_STRING = "Еъёчхф Вхзёюлх, адздёиу ф ждэщхб, црбх еёдюэчъщъгюъв южаижжзчх, ждчъёнъгжзчдв. Ъы зёюивй " +
        "жёхчгюв бюнс ж ъы вдгивъгзхбсгрв аёхкдв. \n" +
        "Зъеъёс вгъ дмъчющгд, мзд гъюэцъьгджзс тздшд аёхкх фчбфъзжф жбъщжзчюъв гъждчъёнъгжзчх мъбдчъмъжадшд югщючющиивх. \n" +
        "Ф юэимюб чхни южздёюу ю чгыж юэвъгъгюф, здмгъъ дзёхэюч еджздфггиу юэвъгмючджзс мъбдчъмъжаюк едёдадч. \n" +
        "Ю зъв гъ въгъъ, еджбъщдчхбх гъищхмх. Ф еёюнъб а чрчдщи, мзд чюгдя чжъви вдя югзъббъаз, х чдэвдьгд, вды мёъэвъёгдъ жзёъвбъгюъ ад " +
        "чжъви шхёвдгюмгдви. \n" +
        "Гхязю ёънъгюъ вгъ едвдшбх еёдшёхввх югзиюзючгдшд зюех, жеълюхбсгд ждэщхггхф щбф юэимъгюф деёъщъбъггрк жздёдг мъбдчъмъжадя щиню. " +
        "\n" +
        "Въгф вдьгд гхэчхзс дзлдв Вхзёюлр, х ъы, цъэ еёъичъбюмъгюф, вхзъёсу.";
    private static String CHARS_TO_IGNORE = " .,\n";
    private static List<Character> alphabet = new ArrayList<>();

    public static void main(String[] args) {
        initAlphabet();
        for (int i = 1; i < alphabet.size(); i++) {
            System.out.printf("%nShift = %d%n", i);
            System.out.println(shiftStringRight(SOURCE_STRING, i));
        }
    }

    private static void initAlphabet() {
        for (int charCode = 1040; charCode <= 1103; charCode++) {
            alphabet.add((char) charCode);
        }
        alphabet.add(6, 'Ё');
        alphabet.add(39, 'ё');
    }

    private static String shiftStringRight(String string, int shift) {
        return string.chars()
            .map(c -> {
                if (CHARS_TO_IGNORE.indexOf((char) c) != -1) {
                    return c;
                }

                return shiftCodePointRight(c, shift);
            })
            .mapToObj(i -> (char) i)
            .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
            .toString();
    }

    private static int shiftCodePointRight(int codePoint, int shift) {
        int codePointIndex = alphabet.indexOf((char) codePoint);
        int newCodePointIndex = codePointIndex + shift;

        if (newCodePointIndex >= alphabet.size()) {
            newCodePointIndex -= alphabet.size();
        }

        return alphabet.get(newCodePointIndex);
    }

}
