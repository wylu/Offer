package Offer.Chapter3;

public class RegularMatch {
    public static boolean match(char[] str, char[] pattern){
        if (str == null || pattern == null)
            return false;
        return matchCore(str, 0, pattern, 0);
    }

    private static boolean matchCore(char[] str, int idxStr, char[] pattern, int idxPat) {
        if (idxStr == str.length && idxPat == pattern.length)
            return true;
        if (idxStr != str.length && idxPat == pattern.length)
            return false;

        if (idxPat + 1 < pattern.length && pattern[idxPat + 1] == '*'){
            if (idxStr != str.length && (pattern[idxPat] == str[idxStr] || pattern[idxPat] == '.'))
                return matchCore(str, idxStr + 1, pattern, idxPat + 2)
                        || matchCore(str, idxStr + 1, pattern, idxPat)
                        || matchCore(str, idxStr, pattern, idxPat + 2);
            else return matchCore(str, idxStr, pattern, idxPat + 2);
        }
        if (idxStr != str.length && (str[idxStr] == pattern[idxPat] || pattern[idxPat] == '.'))
            return matchCore(str, idxStr + 1, pattern, idxPat + 1);

        return false;
    }

    public static void main(String[] args){
        System.out.println(match("aaa".toCharArray(), "ab*ac*a".toCharArray()));
        System.out.println(match("".toCharArray(), ".*".toCharArray()));
    }
}
