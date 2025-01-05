class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int closestX = Math.max(x1, Math.min(xCenter, x2)); //closest x value on rectangle from the center of circle
        int closestY = Math.max(y1, Math.min(yCenter, y2));

        int distanceX = xCenter - closestX; //horizontal distance b/w circle center and nearest point on rectangle
        int distanceY = yCenter - closestY;
        

        return distanceX*distanceX + distanceY*distanceY <= radius*radius; // if > than, the circle doesn't overlap.
    }
}