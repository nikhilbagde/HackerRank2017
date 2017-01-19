package GeeksForGeeks.CodingProblems.Trees.Set1;

import GeeksForGeeks.CodingProblems.Trees.BinaryTree;
import GeeksForGeeks.CodingProblems.Trees.TreeNode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Nikhil on 1/17/2017 8:55 PM.
 */
public class PrintLevelWise {
    private static void printLevelWise(TreeNode node, int level){
        Queue<TreeNode> nodesQ = new LinkedList<>();
        Queue<Integer> levelQ = new LinkedList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o1 > o2 ? -1 : (o2 > o1) ? 1 : 0);

        nodesQ.offer(node);
        levelQ.offer(0);

        while(!nodesQ.isEmpty()){
            TreeNode node1 =  nodesQ.poll();
            int currentLevel = levelQ.poll();

            if(currentLevel == level){
                maxHeap.add(node1.value);           //for calculating max in given level.
                System.out.print(node1.value + " ");    //for level wise printing
            }

            if(node1.left != null || node1.right!= null){
                currentLevel += 1;
                if(node1.left!= null){
                    levelQ.add(currentLevel);
                    nodesQ.add(node1.left);
                }
                if(node1.right!= null){
                    levelQ.add(currentLevel);
                    nodesQ.add(node1.right);
                }
            }
        }

        printPriorityQueue(maxHeap);
    }
    private static void printPriorityQueue(PriorityQueue<Integer> maxHeap){
        int lenght = maxHeap.size();
        /*for (int i = 0; i < maxHeap.size(); i++) {
            System.out.print(maxHeap.poll());
        }*/
        while (!maxHeap.isEmpty())
            System.out.print(maxHeap.poll()+" ");
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> test = new PriorityQueue<>((o1, o2) -> o1>o2?-1:o1<o2?1:0);
        /*test.add(5);        test.add(1);        test.add(6);        test.add(2);        test.add(7);        test.add(3);
        test.add(8);        test.add(4);        test.add(9);*/
        //printPriorityQueue(test);

        BinaryTree testLevelWiseTree = ConstructBST.constructBST();
        printLevelWise(testLevelWiseTree.getRoot(), 2);
    }
}
