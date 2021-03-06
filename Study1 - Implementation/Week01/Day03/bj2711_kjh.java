import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws Exception {
    final int T = Input.nextInt();

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < T; i++) {
      int typoLocation = Input.nextInt();
      String word = Input.next();
      
      sb.append(eraseOneLetter(word, typoLocation - 1))
        .append('\n');
    }
    System.out.print(sb);
  }

  //// 구현 자체를 착실히 해내신 것 같아요
  //// 이런 방법으로도 짤 수 있구나를 느끼고 가요
  private static String eraseOneLetter(String word, int index) {
    String beforeTarget = word.substring(0, index);

    int indexAfterTarget = Math.min(index + 1, word.length());
    String afterTarget = word.substring(indexAfterTarget);

    return beforeTarget + afterTarget;
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
