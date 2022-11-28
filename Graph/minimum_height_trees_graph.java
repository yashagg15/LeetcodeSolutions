package Graph;

import java.util.*;

public class minimum_height_trees_graph {

    class Solution {

        public List<Integer> findMinHeightTrees(int n, int[][] edges) {

            List<List<Integer>> lis=new ArrayList<>();
            List<Integer> result=new ArrayList<>();
            if(edges.length==0 && n==1){
                result.add(0);
                return result;
            }

            for(int i=0;i<n;i++)
                lis.add(new ArrayList<>());

            int indegree[]=new int[n];

            for(int i=0;i<edges.length;i++){
                lis.get(edges[i][0]).add(edges[i][1]);
                lis.get(edges[i][1]).add(edges[i][0]);
                indegree[edges[i][0]]++;
                indegree[edges[i][1]]++;
            }
            Queue<Integer> queue=new LinkedList<>();
            for(int i=0;i<indegree.length;i++){
                if(indegree[i]==1)
                    queue.add(i);
            }

            while(n>2){
                n=n-queue.size();
                int size=queue.size();
                while(size-->0){
                    int pol=queue.remove();
                    for(Integer i:lis.get(pol)){
                        indegree[i]--;
                        if(indegree[i]==1)
                            queue.add(i);
                    }
                }
            }

            while(!queue.isEmpty()){
                result.add(queue.remove());
            }
            return result;

        }
    }
}
