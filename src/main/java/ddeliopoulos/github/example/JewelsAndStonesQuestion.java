package ddeliopoulos.github.example;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStonesQuestion {

    public static void main(String[] args) {
        JewelsAndStonesQuestion jAndS = new JewelsAndStonesQuestion();

        String jewels = "aA";
        String stones = "aAAbbbb";

        System.out.println(jAndS.numJewelsInStones(jewels, stones));
    }

    public int numJewelsInStones2(String jewels, String stones) {
        final boolean[] isAJewel = new boolean['z'];

        for (int jewelIndex = 0; jewelIndex < jewels.length(); ++jewelIndex) {
            isAJewel[jewels.charAt(jewelIndex)] = true;
        }

        int count = 0;
        for (int stonesIndex = 0; stonesIndex < stones.length(); ++stonesIndex) {
            if (isAJewel[stones.charAt(stonesIndex)]) ++count;
        }

        return count;
    }

    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        Set<Character> set = new HashSet<>();

        for (int jewelIndex = 0; jewelIndex < jewels.length(); jewelIndex++) {
            set.add(jewels.charAt(jewelIndex));
        }
        for (int stonesIndex = 0; stonesIndex < stones.length(); stonesIndex++) {
            if (set.contains(stones.charAt(stonesIndex))) count++;
        }

        return count;
//        int jewelsCount = 0;
//        for (int i = 0; i < jewels.length(); i++) {
//            for (int j = 0; j < stones.length(); j++) {
//                if (jewels.charAt(i) == stones.charAt(j)) jewelsCount++;
//            }
//        }
//        return jewelsCount;
    }
}
