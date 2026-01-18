import javaweb.JavaWebOps;
public class main {
    public static void main(String[] args) {
        JavaWebOps jwo = new JavaWebOps("https://www.google.com");
        System.out.println(jwo.getAllLinks());
        System.out.println(jwo.getAllImages());
        System.out.println(jwo.getDataAtElementId("hfcr"));

    }
}
