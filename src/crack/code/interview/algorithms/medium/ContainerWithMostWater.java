package crack.code.interview.algorithms.medium;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] input = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println("ContainerWithMostWater: " + maxArea(input));
    }


    public static int maxArea(int[] height) {

        int n = height.length;
        int maxArea = 0;
        int i = 0;
        int j = n - 1;
        int indexLength = n - 1;

        while (i < j) {
            int area = (Math.min(height[i], height[j])) * indexLength ;
            maxArea = Math.max(maxArea, area);
            indexLength--;
            if (height[i] <= height[j])
                i++;
            else
                j--;
        }
        return maxArea;
    }

    public static int maxArea1(int[] height) {

        int n = height.length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > 0; j--) {

                int indexLength = j - i;
                int area = (Math.min(height[i], height[j])) * indexLength ;
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}
