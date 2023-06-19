import java.util.Random;

/**
 * The Main class demonstrates the performance comparison between a custom List implementation
 * and the ArrayList class from the java.util package. Measure the time to add 10, 1000, 10000, 100000 elements to the ArrayList
 * and LinkedList for benchmark checking.
 */
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        long startTime;
        List<Integer> list = new List<>();
        list.list_create(10);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; ++i) {
            list.add_Node(random.nextInt(10));
        }
        System.out.println("List: 1000 elements input time " + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; ++i) {
            list.add_Node(random.nextInt(10));
        }
        System.out.println("List: 10000 elements input time " + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; ++i) {
            list.add_Node(random.nextInt(10));
        }
        System.out.println("List: 100000 elements input time " + (System.currentTimeMillis() - startTime) + "ms");
        list.clear();

        System.gc();

        ArrayList<Integer> arr = new ArrayList<>(10);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; ++i) {
            arr.addElement(random.nextInt(10));
        }
        System.out.println("ArrayList: 1000 elements input time " + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; ++i) {
            arr.addElement(random.nextInt(10));
        }
        System.out.println("ArrayList: 10000 elements input time " + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; ++i) {
            arr.addElement(random.nextInt(10));
        }
        System.out.println("ArrayList: 100000 elements input time " + (System.currentTimeMillis() - startTime) + "ms");

    }
}