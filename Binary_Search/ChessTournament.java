package Binary_Search;

import java.util.Arrays;

/*
        * Chess Tournament
        * Problem Statement: Chess tournament is going to be organized in Ninjaland. There will be C chess players going to attend the tournament. All the players Will be staying in a hotel. The hotel has N free rooms available for the players, where one player Will choose one room to live in. The ith room is at position(i) in the hotel. All rooms are in distinct positions. 
        Focus level of a chess player is defined as the minimum distance between his room and the room of another player. The overall focus of a tournament is defined as the minimum focus level among all players. You as an organizer obviously want the overall focus as high as possible so you assign the rooms to players such that the overall focus is as high as possible.

        Sample Input:
            2
            4 2
            5 4 2 1
            6 4
            6 7 9 13 15 11
        Sample Output 2 :
            4
            2
        Explanation:
            In test case 1, 
            we only have to allocate rooms to 2 players so we can assign rooms that are first and last which are 1 and 5, so our answer is 5 - 1 = 4.

            In test case 2, 
            there is no way by which we can allocate rooms such that every player will have the 3 or more as its least distance to other players. So the answer is 2 and one possible allocation of rooms is as follows.
                Player1 = 6
                Player2 = 9
                Player3 = 11
                Player4 = 13 
 */

/* 
    * This is one of the questions on search on answer in binary search
    
    * firstly we need to find search space i.e. lower & upper boundary
    * for that we know that in one room one player can live in so minimum will be 1
    * and let's suppose there are only two players then we can simply give room at extreme positions which are available, so maximum can be (last position - first position)
    * now if players are more than rooms available then we'll store result as -1
    * now apply binary search, for possible room allotment store result as mid and move towards right else move towards left
    * finally return result
    
    * now to check for possible room allotment, take one starting position and players as one and traverse through array 
    * if current room position - first position taken is greater than or equal to distance (i.e. mid) then add one player and set first position as current position
    * if players are greater than or equal to required players then return true else return false;
*/
public class ChessTournament {
    public static int chessTournament(int[] positions, int n, int chessPlayers) {
        // Write your code here.
        Arrays.sort(positions);
        int l = 1, r = positions[n - 1] - positions[0], res = -1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (isPossible(positions, n, chessPlayers, mid)) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    private static boolean isPossible(int[] positions, int n, int chessPlayers, int distance) {
        int position = positions[0], players = 1;
        for (int i = 1; i < n; i++) {
            if (positions[i] - position >= distance) {
                players++;
                position = positions[i];
            }
        }
        return players >= chessPlayers;
    }

    // driver code
    public static void main(String[] args) {
        int[] arr = { 6, 7, 9, 13, 15, 11 };
        int chessPlayers = 4;
        System.out.println(chessTournament(arr, arr.length, chessPlayers));
    }
}
