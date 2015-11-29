# crazyDFS
All possible combination of DFS path from a given start to end node in a graph

Source : https://www.hackerrank.com/contests/programaniacs-june-15/challenges/dfs-on-tree

Problem Statement

You are given a tree of N nodes numbered from 1 to N. Let DFS reach node f starting from node s. How many different ways are there to do so? Two ways are considered to be different if their lists of successively visited vertices are different.

Input Format

The first line of input contains an integer T, the number of test cases. T test cases follow. Each test case starts with three integers N (number of nodes), s (starting node), and f (destination node). Each of the next N−1 lines contains two integers, u and v, representing an edge between u and v.

Output Format

Print T lines, each containing the answer for the corresponding test case modulo 109+7.

Constraints 
1≤T,N≤100 
1≤s,f,u,v≤N 
s≠f 
u≠v
Sample Input

4
5 2 4
1 3
5 3
3 2
4 2
5 2 1
2 1
2 3
4 3
2 5
6 1 5
1 2
2 5
2 4
4 3
5 6
6 3 2
1 3
1 6
1 4
4 5
4 2
Sample Output

3
5
2
4
Explanation

Sample Case #00: There are three possible ways to reach node 4: 
1) 2−4 
2) 2−3−1−5−4 
3) 2−3−5−1−4

Sample Case #01: All ways to reach node 1 are listed below. 
1) 2−1 
2) 2−3−4−1 
3) 2−3−4−5−1 
4) 2−5−1 
5) 2−5−3−4−1

Sample Case #02: Just two DFS routes 1−2−5 and 1−2−4−3−5.
