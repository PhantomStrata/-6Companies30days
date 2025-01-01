class Solution {
    public int findTheWinner(int n, int k) {
        int winner = 0;  //assume 1 person remains at position 0
        for(int i=1; i<=n; i++) 
        {
            winner = (winner+k)%i;  //update which index is for the winner 
        }
        return winner+1;    //change from 0-indexing to 1-indexing
    }
}