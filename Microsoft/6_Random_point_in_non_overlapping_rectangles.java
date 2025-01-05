import java.util.Random;

class Solution {
    private int[][] rects;
    private int[] area;
    private Random random;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.random = new Random();
        this.area = new int[rects.length];
        int totalArea = 0;

        // Compute cumulative areas
        for (int i = 0; i < rects.length; i++) {
            int width = rects[i][2] - rects[i][0] + 1;
            int height = rects[i][3] - rects[i][1] + 1;
            if (width > 0 && height > 0) { // Only include valid rectangles
                totalArea += width * height;
            }
            area[i] = totalArea;
        }
    }

    public int[] pick() {
        // Generate a random target from 1 to the total area
        int target = random.nextInt(area[area.length - 1]) + 1;

        // Use Arrays.binarySearch to find the rectangle containing the target area
        int rect_id = findRectangle(target);

        // Compute point within the selected rectangle
        int[] rect = rects[rect_id];
        int areaStart = rect_id > 0 ? area[rect_id - 1] : 0; // Starting area of this rectangle
        int offset = target - areaStart - 1; // Offset within this rectangle's area
        int width = rect[2] - rect[0] + 1;

        // Calculate x and y based on the offset
        int x = rect[0] + offset % width;
        int y = rect[1] + offset / width;

        return new int[] { x, y };
    }

    private int findRectangle(int target) {
        // Use a modified binary search to find the rectangle index
        int low = 0, high = area.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (area[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */