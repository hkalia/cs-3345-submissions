public class HeapSort {
    /**
     * Heap sort method
     */
    public static long totalComparisons = 0;
    public static long totalMovements = 0;

    public static <E extends Comparable<E>> void heapSort(E[] list) {
        // Create a Heap of integers
        Heap<E> heap = new Heap<>();

        // Add elements to the heap
        for (int i = 0; i < list.length; i++)
            heap.add(list[i]);

        // Remove elements from the heap
        for (int i = list.length - 1; i >= 0; i--)
            list[i] = heap.remove();
    }

    public static <E extends Comparable<E>> void heapSortMod(E[] list) {
        // Create a Heap of integers
        HeapMod<E> heap = new HeapMod<>();

        // Add elements to the heap
        for (int i = 0; i < list.length; i++) {
            heap.add(list[i]);
            totalComparisons++;
            totalMovements += 2;
        }


        // Remove elements from the heap
        for (int i = list.length - 1; i >= 0; i--) {
            list[i] = heap.remove();
            totalComparisons++;
            totalMovements += 2;
        }
        totalMovements++;


    }

    /**
     * A test method
     */
    public static void main(String[] args) {
        Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
        heapSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }
}