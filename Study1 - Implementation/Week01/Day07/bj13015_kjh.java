import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  //// 규칙들이 복잡해보이지 않아서 좋습니다. 
class Main {
  ////배워갑니다.공백에 대한 변수명을 잘 지어내신거 같습니다.
  public static void main(String[] args) throws Exception {
    final int N = Input.nextInt();
    int height = 2 * N - 1;

    StringBuilder sb = new StringBuilder();
    sb.append(buildEdge(N));
    for(int i = 1; i < height - 1; i++) {
      sb.append(buildBorder(N, i));
    }
    sb.append(buildEdge(N));

    System.out.print(sb);
  }

  static StringBuilder buildEdge(int N) {
    StringBuilder sb = new StringBuilder();
    int spaces = 2 * N - 3;
    sb.append("*".repeat(N))
      .append(" ".repeat(spaces))
      .append("*".repeat(N))
      .append('\n');
    return sb;
  }

  //// 루프 하나하나마다 아래와 같은 연산을 계속 해줘야 해서 효율성에서 좀 아쉬워 보이네요 ㅠ
  //// => 가독성이 떨어진다는 말씀일까요? 메모리/시간 효율은 Java 1위입니다!
  //// => 가독성 개선법을 약 10분동안 고민해봤는데 획기적인 방법이 떠오르지 않아 그대로 둡니다 ㅠㅠ
  static StringBuilder buildBorder(int N, int i) {
    StringBuilder sb = new StringBuilder();
    int height = 2 * N - 1;
    int middleHeight = height / 2;
    int distanceFromEdge = (i > middleHeight) ? (height - i - 1) : (i);

    int indent = distanceFromEdge;
    int innerSpaces = N - 2;
    int centerSpaces = (2 * N - 3) - (distanceFromEdge * 2);
    
    sb.append(" ".repeat(indent))
      .append("*")
      .append(" ".repeat(innerSpaces))
      .append("*");

    if (i != middleHeight) {
      sb.append(" ".repeat(centerSpaces))
        .append("*");
    }

    sb.append(" ".repeat(innerSpaces))
      .append("*")
      .append("\n");

    return sb;
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