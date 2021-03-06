import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  ////변수명 짓기 대회 1등하실거 같아요! 전체적으로 깔끔하고 가독성이 좋습니다. : 22 변수명 짓기 대회 ㅋㅋㅋㅋㅋ 대상 예약인가요
  //// => ㅎㅎㅎㅎ 과찬이십니다.. 감사합니다!
class Main {
  public static void main(String[] args) throws Exception {
    final String myPhone = Input.nextLine();
    final String onesPhone = Input.nextLine(); 
    
    String mixedNumber = mixNumber(myPhone, onesPhone);
    String harmony = predictHarmony(mixedNumber);

    System.out.print(harmony);
  }
  
  private static String mixNumber(String phoneA, String phoneB) {
    StringBuilder mixedNumber = new StringBuilder();

    for (int i = 0; i < 8; i++) {
      //// 오호 StringBuilder 활용이 좋네요
      mixedNumber.append(phoneA.charAt(i))
        .append(phoneB.charAt(i));
    }

    return mixedNumber.toString();
  }

  private static String predictHarmony(String mixedNumber) {
    if (mixedNumber.length() == 2) return mixedNumber;

    StringBuilder harmonies = new StringBuilder();
    for (int i = 0; i < mixedNumber.length() - 1; i++) {
      int sumOfTwoNumber = charToInt(mixedNumber.charAt(i)) + charToInt(mixedNumber.charAt(i + 1));
      int harmony = sumOfTwoNumber % 10;
      harmonies.append(harmony);
    }

    return predictHarmony(harmonies.toString());
  }
  
  private static int charToInt(char ch) {
    return ch - '0';
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
