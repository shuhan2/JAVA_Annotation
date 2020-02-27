import com.thoughtworks.OneArg;

public class OneArgTest {

  @OneArg
  public void print1(String name) {
    System.out.println(name);
  }

  @OneArg
  public void print2(String name, int value) {
    System.out.println("two args" + name + value);
  }
  public static void main(String[] args) {
    OneArgTest one = new OneArgTest();
    one.print1("alex");
    one.print2("alex", 18);
  }
}
