public class test {
    public static void main(String[] args){
        System.out.println(func3(6,3));
    }

    private static int func3(int m, int n) {
        if (m < n)
              return 0;
        else
              return 1 + func3(m-n, n);
  }
}
