import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LamdaExample1 {

	static List<String> storeList = List.of("hello", "word", "effective", "I");
	static List<String> words = new ArrayList<>();

	public static void main(String[] args) {

		// 1. 익명클래스 사용
		setting(storeList, words);
		Collections.sort(words, new Comparator<String>() {
			@Override public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		});
		printResult(words);

		// 2. 람다식 사용
		setting(storeList, words);
		Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
		printResult(words);

		// 3. 람다식 단축: 생성자 레퍼런스 사용
		setting(storeList, words);
		Collections.sort(words, Comparator.comparingInt(String::length));
		printResult(words);

		// 4. List sort 람다식
		setting(storeList, words);
		words.sort(Comparator.comparingInt(String::length));
		printResult(words);

	}

	static void setting(List<String> list, List<String> words) {
		clear(words);
		addWord(list, words);
	}

	static private void clear (List<String> list){
		list.clear();
	}

	static private List<String> addWord(List<String> list, List<String> words){
		list.forEach(
				word -> words.add(word)
		);
		return words;
	}

	static private void printResult(List<String> words){
		words.forEach(word -> System.out.println(word));
		System.out.println();
	}

}
