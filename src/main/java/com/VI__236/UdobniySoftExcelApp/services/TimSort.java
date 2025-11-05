package com.VI__236.UdobniySoftExcelApp.services;

import org.springframework.stereotype.Component;

@Component
public class TimSort {
    private static final int MIN_MERGE = 32;

    public int[] sort(int[] array) {
        if (array == null || array.length < 2) {
            return array != null ? array.clone() : null;
        }

        int[] sortedArray = array.clone();
        int n = sortedArray.length;

        for (int start = 0; start < n; start += MIN_MERGE) {
            int end = Math.min(start + MIN_MERGE - 1, n - 1);
            insertionSort(sortedArray, start, end);
        }

        int[] temp = new int[n];
        for (int size = MIN_MERGE; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = Math.min(left + size - 1, n - 1);
                int right = Math.min(left + 2 * size - 1, n - 1);

                if (mid < right) {
                    merge(sortedArray, temp, left, mid, right);
                }
            }
        }

        return sortedArray;
    }

    private static void insertionSort(int[] array, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= left && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    private static void merge(int[] array, int[] temp, int left, int mid, int right) {
        System.arraycopy(array, left, temp, left, right - left + 1);

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                array[k++] = temp[i++];
            } else {
                array[k++] = temp[j++];
            }
        }

        while (i <= mid) {
            array[k++] = temp[i++];
        }

        while (j <= right) {
            array[k++] = temp[j++];
        }
    }

    public static void printArray(int[] array) {
        if (array == null) {
            System.out.println("null");
            return;
        }
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(int[] array) {
        if (array == null || array.length < 2) return true;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
