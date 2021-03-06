import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

class Main {
  public static void main(String[] args) throws Exception {
    final int N = Input.nextInt();
    int[][] papers = new int[N][N];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        papers[i][j] = Input.nextInt();
      }
    }

    PaperCutter paperCutter = new PaperCutter(papers);
    
    paperCutter.cut();
    paperCutter.printPaperAmounts();
  }
}

class PaperCutter {
  private int[][] papers;
  private int[] amount;

  public PaperCutter(int[][] papers) {
    this.papers = papers;

    amount = new int[3];
    //// 0으로 초기화 하는 건 명확히 나타내기 위해서 인가요?
    //// => static 아닌건 자동 0 초기화가 안되는걸로 알아서 수동 초기화해줬습니다
    amount[0] = amount[1] = amount[2] = 0;
  }

  public void cut() {
    cut(papers.length, 0, 0);
  }

  //// cut()이 따로 있길래 밑에 메소드는 private이겠거니 했는데 public이네요..? 골라쓸 수 있도록 제공해주는 건가요?
  //// => 아뇨 ㅌㅋㅋㅋ 그게 의도된 부분이었는데 무의식적으로 이렇게 했어요 감사합니다!
  private void cut(int size, int y, int x) {
    if (areAllEqual(size, y, x)) {
      amount[papers[y][x] + 1] += 1;
      return;
    }

    //// nextSize * i 연산은 i loop에서 하는 건 어떤가요?
    //// => 넹 그게 훨씬 가독성 좋은거같아요! 반영했습니다
    int nextSize = size / 3;
    for (int ySize = 0; ySize < nextSize * 3; ySize += nextSize) {
      for (int xSize = 0; xSize < nextSize * 3; xSize += nextSize) {
        cut(nextSize, y + ySize, x + xSize);
      }
    }
  }

  private boolean areAllEqual(int size, int y, int x) {
    if (size == 1) return true;

    int head = papers[y][x];

    for (int i = y; i < y + size; i++) {
      for (int j = x; j < x + size; j++) {
        if (head != papers[i][j]) {
          return false;
        }
      }
    }

    return true;
  }

  public void printPaperAmounts() {
    for (int i = 0; i < 3; i++) {
      System.out.println(amount[i]);
    }
  }
}

class Input {
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringTokenizer tokenizer;

  public static String nextLine() {
    try {
      return br.readLine();
    } catch(Exception e) { }
    
    return null;
  }

  public static int nextInt() {
    String nextString = next();
    return Integer.parseInt(nextString);
  }

  public static double nextDouble() {
    String nextString = next();
    return Double.parseDouble(nextString);
  }

  public static long nextLong() {
    String nextString = next();
    return Long.parseLong(nextString);
  }

  public static char nextChar() {
    String nextString = next();
    return nextString.charAt(0);
  }
  
  public static String next() {
    makeTokensIfNeed();
    return tokenizer.nextToken();
  }

  public static void skipLine() {
    nextLine();
  }

  public static void skipLine(int n) {
    for (int i = 0; i < n; i++) {
      nextLine();
    }
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
    return new StringTokenizer(nextLine(), " ");
  }
}