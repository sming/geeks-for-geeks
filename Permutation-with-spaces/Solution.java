import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Given a string you need to print all possible strings that can be made by placing spaces (zero or
 * one) in between them. The output should be printed in sorted increasing order of strings
 *
 * <p>Example 1:
 *
 * <p>Input: S = "ABC" Output: (A B C)(A BC)(AB C)(ABC) Explanation: ABC AB C A BC A B C These are
 * the possible combination of "ABC".
 */
class Solution {

    ArrayList<String> permutation(String str) {
        var result = new ArrayList<String>();
        if (str == null | str.isEmpty())
            return result;

        var chars = new ArrayList<Character>();
        for(int i = 0; i < str.length(); i++) {
            chars.add(str.charAt(i));
        }

        for(int i = 0; i < str.length(); i++) {

        }
    /*
    recursive function(i=0)
    split string at i
    add [pre+post]
    add pre + if (len(post)) > 1
        explode post, passing pre

    add post + if (len(pre)) > 1
        explode pre, passing post
     */

//    private Collection<String> permutation2(int idx, String str) {
//        var result = new ArrayList<String>();
//        var preSubStr = str.substring(0, idx);
//            var postSubStr = str.substring(idx);
//            result.add(preSubStr);
//            result.add(postSubStr);
//        }
//    }
}
