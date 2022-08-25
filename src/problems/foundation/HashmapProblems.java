package problems.foundation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;

public class HashmapProblems {
	
	static char maxCharacter(String st) {
		
		char[] chararr = st.toCharArray();
		HashMap<Character, Integer> hm = new HashMap<>();
		for(Character ch: chararr) {
			if(hm.containsKey(ch)) {
				hm.put(ch, hm.get(ch)+1);
			}else {
				hm.put(ch, 1);
			}
		}
		
		Set<Character> keys = hm.keySet();
		int max = 0;
		char maxchar = '\0';
		for(Character ch: keys) {
			if(max<hm.get(ch)) {
				max = hm.get(ch);
				maxchar = ch;
			}
		}
		return maxchar;
		
	}

	public static void main(String[] args) {
		
//		System.out.println(maxCharacter("abhijeettakleisgreat"));
		HashSet<Integer> hs = new HashSet<>();
		hs.contains(5);
	}

}
