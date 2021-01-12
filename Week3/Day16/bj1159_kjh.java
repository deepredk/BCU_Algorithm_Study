import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class Main {
  public static void main(String[] args) throws Exception {
    StringBuilder sb = new StringBuilder();

    int numberOfAlphabets = 'z' - 'a' + 1;
    int[] firstLettersCount = new int[numberOfAlphabets];
    Arrays.fill(firstLettersCount, 0);

    final int N = Input.nextInt();

    for (int i = 0; i < N; i++) {
      String lastName = Input.nextLine();
      firstLettersCount[lastName.charAt(0) - 'a']++; 
    }

    for (int i = 0; i < numberOfAlphabets; i++) {
      if (firstLettersCount[i] >= 5) {
        char firstLetter = (char) ('a' + i);
        sb.append(firstLetter);
      }
    }

    System.out.print(sb.length() == 0 ? "PREDAJA" : sb);
  }
}

class Input {
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringTokenizer tokenizer;

  public static String nextLine() {
    return readLine();
  }

  public static int nextInt() {
    String nextString = next();
    return Integer.parseInt(nextString);
  }
  
  public static String next() {
    makeTokensIfNeed();
    return tokenizer.nextToken();
  }

  private static void makeTokensIfNeed() {
    makeTokensIfNotReadedYet();
    makeTokensIfHasNoToken();
  }

  private static void makeTokensIfNotReadedYet() {
    if (tokenizer == null) {
      tokenizer = makeTokens();
    }
  }

  private static void makeTokensIfHasNoToken() {
    if (tokenizer.hasMoreTokens() == false) {
      tokenizer = makeTokens();
    }
  }
  
  private static StringTokenizer makeTokens() {
    return new StringTokenizer(readLine(), " ");
  }

  private static String readLine() {
    try {
      return br.readLine();
    } catch(Exception e) { }
    
    return null;
  }
}