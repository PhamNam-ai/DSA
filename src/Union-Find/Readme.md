There are  nodes in an undirected graph, and a number of edges connecting some nodes. In each edge, the first value will be between  and , inclusive. The second node will be between  and , inclusive. Given a list of edges, determine the size of the smallest and largest connected components that have  or more nodes. A node can have any number of connections. The highest node value will always be connected to at least  other node.

Note Single nodes should not be considered in the answer.

Example

image
The smaller component contains  nodes and the larger contains . Return the array .

Function Description
Complete the connectedComponents function in the editor below.

connectedComponents has the following parameter(s):
- int bg[n][2]: a 2-d array of integers that represent node ends of graph edges

Returns
- int[2]: an array with 2 integers, the smallest and largest component sizes

Input Format

The first line contains an integer , the size of .
Each of the next  lines contain two space-separated integers,  and .

Constraints

Sample Input

STDIN   Function
-----   --------
5       bg[] size n = 5
1 6     bg = [[1, 6],[2, 7], [3, 8], [4,9], [2, 6]]
2 7
3 8
4 9
2 6
Sample Output

2 4
Explanation

image

Since the component with node  contains only one node, it is not considered.

The number of vertices in the smallest connected component in the graph is  based on either  or .

The number of vertices in the largest connected component in the graph is  i.e. .