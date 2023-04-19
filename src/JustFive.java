public class JustFive {
    private static int instanceCount = 0;

    public JustFive() {
        if (instanceCount >= 5) {
            throw new RuntimeException("Only 5 instances of JustFive allowed");
        }
        instanceCount++;
    }

    public static void main(String[] args) {
        JustFive a = new JustFive();
        JustFive b = new JustFive();
        JustFive c = new JustFive();
        JustFive d = new JustFive();
        JustFive e = new JustFive();
        JustFive f = new JustFive(); // This will throw a RuntimeException
    }
}
