
public class MergeSort {
    public static long totalComparisons = 0;
    public static long totalMovements = 0;

    /**
     * The method for sorting the numbers
     */
    public static void mergeSort(int[] list) {
        if (list.length > 1) {
            // Merge sort the first half
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            // Merge sort the second half
            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2,
                    secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            // Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, list);
        }
    }

    /**
     * Merge two sorted lists
     */
    public static void merge(int[] list1, int[] list2, int[] temp) {
        int current1 = 0; // Current index in list1
        int current2 = 0; // Current index in list2
        int current3 = 0; // Current index in temp

        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2])
                temp[current3++] = list1[current1++];
            else
                temp[current3++] = list2[current2++];
        }

        while (current1 < list1.length)
            temp[current3++] = list1[current1++];

        while (current2 < list2.length)
            temp[current3++] = list2[current2++];
    }

    /**
     * The method for sorting the numbers (MODIFIED)
     */
    public static void mergeSortMod(int[] list) {
        if (list.length > 1) {
            // Merge sort the first half
            int[] firstHalf = new int[list.length / 2];
            totalMovements++;
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            totalMovements += list.length / 2;
            mergeSortMod(firstHalf);

            // Merge sort the second half
            int secondHalfLength = list.length - list.length / 2;
            totalMovements++;
            int[] secondHalf = new int[secondHalfLength];
            totalMovements++;
            System.arraycopy(list, list.length / 2,
                    secondHalf, 0, secondHalfLength);
            totalMovements += secondHalfLength;
            mergeSortMod(secondHalf);

            // Merge firstHalf with secondHalf into list
            mergeMod(firstHalf, secondHalf, list);
        }
        totalComparisons++;

    }

    /**
     * Merge two sorted lists (MODIFIED)
     */
    public static void mergeMod(int[] list1, int[] list2, int[] temp) {
        int current1 = 0; // Current index in list1
        int current2 = 0; // Current index in list2
        int current3 = 0; // Current index in temp
        totalMovements += 3;


        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2])
                temp[current3++] = list1[current1++];
            else
                temp[current3++] = list2[current2++];
            totalMovements++;
            totalComparisons += 3;
        }
        totalComparisons += 2;

        while (current1 < list1.length) {
            temp[current3++] = list1[current1++];
            totalMovements++;
            totalComparisons++;
        }
        totalComparisons++;


        while (current2 < list2.length) {
            temp[current3++] = list2[current2++];
            totalMovements++;
            totalComparisons++;
        }
        totalComparisons++;

    }

    /**
     * A test method
     */
    public static void main(String[] args) {
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        mergeSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }
}