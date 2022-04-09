public class CountBricks {
    private static final String john = "John";
    private static final String jack = "Jack";

    static class Solution {
        int johnsBricks = 0;
        public String whoPlacedTheBrick(String user, int bricksTillNow, int totalBricks) {
            int tempBricks;
            if (bricksTillNow >= totalBricks)
                return user + " " + (user == john ? johnsBricks : johnsBricks*2);
            if (user == john)
                tempBricks = ++johnsBricks;
            else
                tempBricks = johnsBricks*2;
            return whoPlacedTheBrick(user == john ? jack : john, bricksTillNow + tempBricks, totalBricks);
        }
    }

    public static void main(String[] args) {
        int numberOfBricks = 13;
        System.out.println(new Solution().whoPlacedTheBrick(john, 0, numberOfBricks));
    }
}
