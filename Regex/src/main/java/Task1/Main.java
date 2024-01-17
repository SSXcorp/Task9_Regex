package Task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        //Classes Pattern and Matcher don't have a public constructors that we are able to use
        //We can get this objects using methods : compile() and matcher()

        //Pattern pattern = new Pattern();
        //Matcher matcher = new Matcher();

        //String matching

        Pattern pattern = Pattern.compile("Hello");
        Matcher matcher = pattern.matcher("Hello");

        System.out.println("Match found: " + matcher.find());
        System.out.println("=============================================");

        //Using cycle
        Pattern pattern2 = Pattern.compile("World");
        Matcher matcher2 = pattern2.matcher("World World");
        int matches = 0;
        while (matcher2.find()) {
            matches++;
        }
        System.out.println("Amount of matches: " + matches);

        //Meta characters
        //"." - any character
        System.out.println("=============================================");

        //Matching any char in . (each char)
        System.out.println("Pattern: '.' ");
        int matches2 = getMatchingAmount(".", "G g?1");
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //Matching any char in Wor. (everything after Wor as one char until next War in text)
        System.out.println("Pattern: Wor. ");
        matches2 = getMatchingAmount("Wor.", "World? w12e");
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //Matching any char in [abc] (in range a b c)
        System.out.println("Pattern: [abc]");
        matches2 = getMatchingAmount("[abc]", "cdba");
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //Matching any char in [bcr]at (something that starts on letters in range (bcr) and ends on at)
        System.out.println("Pattern: [bcr]at");
        matches2 = getMatchingAmount("[bcr]at", "b at c1at r?at ");
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //Matching any char in [^abc] (something that is NOT in range)
        System.out.println("Pattern: [^abc]");
        matches2 = getMatchingAmount("[^abc]", "gg");
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //Matching any char in [^bcr]at
        System.out.println("Pattern: [^bcr]at");
        matches2 = getMatchingAmount("[^bcr]at", "sat mat eat rat");
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //Matching any char in [A-Z]
        System.out.println("Pattern: [A-Z]");
        matches2 = getMatchingAmount("[A-Z]", "Hello World");
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //Matching any char in [a-z]
        System.out.println("Pattern: [a-z]");
        matches2 = getMatchingAmount("[a-z]", "Hello World");
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //Matching any char in [a-zA-Z]
        System.out.println("Pattern: [a-zA-Z]");
        matches2 = getMatchingAmount("[a-zA-Z]", "Hello World");
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //Matching any char in [1-5]
        System.out.println("Pattern: [1-5]");
        matches2 = getMatchingAmount("[1-5]", "Hello World 123");
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //Matching any char in 3[0-5]
        System.out.println("Pattern: 3[0-5]");
        matches2 = getMatchingAmount("3[0-5]", "Hello World 123 321 333");
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //Matching any char in [1-3[7-9]]
        System.out.println("Pattern: [1-3[7-9]]");
        matches2 = getMatchingAmount("[1-3[7-9]]", "123456789");
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //Matching any char in [1-6&&[3-9]] (from 3 to 6)
        System.out.println("Pattern: [1-6&&[3-9]]");
        matches2 = getMatchingAmount("[1-6&&[3-9]]", "123456789");
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //Matching any char in [0-9&&[^2468]] (from 0 to 9 and numbers are NOT 2468)
        System.out.println("Pattern: [0-9&&[^2468]]");
        matches2 = getMatchingAmount("[0-9&&[^2468]]", "123456789");
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");


        // Predefined Characters
        // Второй бекслеш - это экранирование в Java

        //Matching any char in \\d (everything that number)
        System.out.println("Pattern: \\d (2 backslash) ");
        matches2 = getMatchingAmount("\\d", "123ad^? ");
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //Matching any char in \\D (everything that NOT number even SPACE)
        System.out.println("Pattern: \\D (2 backslash) ");
        matches2 = getMatchingAmount("\\D", "123ad^? ");
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //Matching any char in \\s (everything that SPACE)
        System.out.println("Pattern: \\s (2 backslash) ");
        matches2 = getMatchingAmount("\\s", "1 2 3ad^?");
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //Matching any char in \\S (everything that NOT SPACE)
        System.out.println("Pattern: \\S (2 backslash) ");
        matches2 = getMatchingAmount("\\S", "1 2 3ad^?");
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //Matching any char in \\w (everything that letter or number)
        System.out.println("Pattern: \\w (2 backslash) ");
        matches2 = getMatchingAmount("\\w", "Hello world1 1 ?/@");
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //Matching any char in \\W (everything that NOT letter or number (SPACE + Meta symbols))
        System.out.println("Pattern: \\W (2 backslash) ");
        matches2 = getMatchingAmount("\\W", "Hello world1 1 ?/@");
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //Quantifiers
        //Чтобы явно указать кол-во совпадений

        //Matching any char in \\a? (returns 3) returns true even if the string is empty
        System.out.println("Pattern: \\a? (2 backslash) ");
        matches2 = getMatchingAmount("\\a?", "hi"); // h + 1 + " " in the end of each line = 3
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //Matching any char in \\a* (to match text 0 or limitless time) (a{0,} - is the same)
        System.out.println("Pattern: \\a* (2 backslash) ");
        matches2 = getMatchingAmount("\\a*", "hello");
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //Matching any char in \\a+ (returns false if 0 matches )
        System.out.println("Pattern: \\a+ (2 backslash) ");
        matches2 = getMatchingAmount("\\a+", "abcdef");
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //Matching any char in \\a{3} (returns 2 because we have 2 words as 3a letters )
        System.out.println("Pattern: a{3} ");
        matches2 = getMatchingAmount("a{3}", "aaaab1bb ?aaa");
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //Matching any char in \\a{2,3} (from 2 to 3 a letters )
        System.out.println("Pattern: a{2,3} ");
        matches2 = getMatchingAmount("a{3}", "aaaa"); // жадное сопоставление aaa
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //Matching any char in \\a{2,3}? (from 2 to 3 a letters )
        System.out.println("Pattern: a{2,3}? ");
        matches2 = getMatchingAmount("a{2,3}?", "aaaa"); // ленивое сопоставление aa
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //Capturing Groups

        //When 2 numbers are near each other
        System.out.println("Pattern: \\d\\d ");
        matches2 = getMatchingAmount("\\d\\d", "1234");
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //When 2 numbers are near each other same
        System.out.println("Pattern: (\\d\\d)\\1 ");
        matches2 = getMatchingAmount("(\\d\\d)\\1", "1414");
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //Boundary Matchers
        //If we need to find the place when matching was created

        //When matching at the top of string
        System.out.println("Pattern: ^dog ");
        matches2 = getMatchingAmount("^dog", "dogs world");
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //When matching at the end of string
        System.out.println("Pattern: dog$ ");
        matches2 = getMatchingAmount("dog$", "Hello dog");
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //to find dog word in the sentence with the space before and after dog
        System.out.println("Pattern: \\bdog\\b ");
        matches2 = getMatchingAmount("\\bdog\\b", "Hello dog world");
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //to find dog word in the sentence with the space before and any letter or digit after dog
        System.out.println("Pattern: \\bdog\\B ");
        matches2 = getMatchingAmount("\\bdog\\B", "Hello dogs world");
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        //FLAGS

        System.out.println("Pattern: \u00E9. Flag : CANON_EQ ");
        matches2 = getMatchingAmountWithFlag("\u00E9", "\u0065\u0301", Pattern.CANON_EQ); // Полное каноническое соответствие
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        System.out.println("Pattern: dog . Flag : CASE_INSENSITIVE");
        matches2 = getMatchingAmountWithFlag("dog", "This is a Dog", Pattern.CASE_INSENSITIVE); // To ignore case
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");


        System.out.println("Pattern: dog . Flag : COMMENTS");
        matches2 = getMatchingAmountWithFlag("dog #Hello world", "This is a dog", Pattern.COMMENTS); // To make comment
        System.out.println("Matches: " + matches2);

        System.out.println("=============================================");

        System.out.println("Pattern: (.) . Flag : DOTALL");
        matches2 = getMatchingAmountWithFlag("(.)", "this is a sample \nthis is second line", Pattern.DOTALL); //In dot all mode it matches all the characters including line terminators.
        System.out.println("Matches: " + matches2);  // 36 + 1 (letter n in \n)

        System.out.println("=============================================");

        System.out.println("Pattern:(.*) . Flag : LITERAL");
        matches2 = getMatchingAmountWithFlag("(.*)", "this (.*)", Pattern.LITERAL); //To look for a regex as a symbol.
        System.out.println("Matches: " + matches2);  // 36 + 1 (letter n in \n)

        System.out.println("=============================================");

        System.out.println("Pattern: dog$ . Flag : MULTILINE");
        matches2 = getMatchingAmountWithFlag("dog$", "This is a dog" + System.getProperty("line.separator")
                        + "this is a fox", Pattern.MULTILINE); //To look for a regex at the end of each line including line separators
        System.out.println("Matches: " + matches2);  // 36 + 1 (letter n in \n)

        System.out.println("=============================================");

        // Matcher methods

        System.out.println("Start method");
        Pattern p = Pattern.compile("\\bdog\\b");
        Matcher m = p.matcher("This dog is mine dog dogs");
        int count = 0;
        while (m.find()) {
            count++;
            System.out.println("Match number " + count);
            System.out.println("start(): " + m.start());
            System.out.println("end(): " + m.end());
        }

        System.out.println("=============================================");

        Pattern p2 = Pattern.compile("hi");
        Matcher m2 = p2.matcher("hi everyone! Everyone hi !");

        System.out.println("lookingAt: 'hi' in 'hi everyone' " + m2.lookingAt()); //string should contain pattern in string
        System.out.println("Matches: 'hi' in 'hi everyone' " + m2.matches()); //all string should be equals

        System.out.println("=============================================");

        System.out.println("Replace methods");
        System.out.println("Old string: hi everyone! Everyone hi !");
        String newString = m2.replaceFirst("hello");
        System.out.println("New string: " + newString);
        newString = m2.replaceAll("hello");
        System.out.println("New string2: " + newString);

        System.out.println("=============================================");
        

    }

    public static int getMatchingAmount (String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int matches = 0;
        while (matcher.find()) {
            matches++;
        }
        return matches;
    }

    public static int getMatchingAmountWithFlag (String regex, String text, int flags) {
        Pattern pattern = Pattern.compile(regex, flags);
        Matcher matcher = pattern.matcher(text);
        int matches = 0;
        while (matcher.find()) {
            matches++;
        }
        return matches;
    }
}
