package QueuePlusDp;

// hard level divide ques in three parts to solve this.
public class Sum_of_distances_in_tree {
    class Solution {

        public int fillRemNodes(int countRemNodes[],List<List<Integer>> lis,int node,boolean visited[]){

            visited[node]=true;
            int count=0;
            List<Integer> temp=lis.get(node);
            for(int i=0;i<temp.size();i++){
                if(!visited[temp.get(i)]){
                    count=count+fillRemNodes(countRemNodes,lis,temp.get(i),visited);
                }
            }
            countRemNodes[node]=count;
            return count+1;

        }

        public void findForZeroNode( List<List<Integer>> lis, boolean visited[], int node,int result[]){
            Queue<Integer> queue=new LinkedList<>();
            queue.add(node);
            int level=0;
            int total=0;
            while(!queue.isEmpty()){
                int size=queue.size();
                total=total+size*level;
                while(size>0){
                    Integer j=queue.poll();
                    visited[j]=true;
                    List<Integer> l= lis.get(j);
                    for(Integer o:l){
                        if(visited[o]==false){
                            queue.add(o);
                        }
                    }
                    size--;
                }
                level++;


            }
            result[node]=total;

        }

        public void finalFillNodes(List<List<Integer>> lis, boolean visited[], int node,int result[],int n,int countRemNodes[]){
            if(visited[node]==false)
                visited[node]=true;
            else
                return;

            List<Integer> cc=new ArrayList(lis.get(node));
            for(int i=0;i<cc.size();i++){
                Integer j=cc.get(i);
                if(visited[j]==false){
                    result[j]=result[node]+n-2*countRemNodes[j]-2;
                }
                finalFillNodes(lis,visited,j,result,n,countRemNodes);
            }
            return;

        }
        public int[] sumOfDistancesInTree(int n, int[][] edges) {


            List<List<Integer>> lis=new ArrayList<>();
            for(int i=0;i<n;i++)
                lis.add(new ArrayList<>());
            for(int i=0;i<edges.length;i++){
                lis.get(edges[i][0]).add(edges[i][1]);
                lis.get(edges[i][1]).add(edges[i][0]);
            }
            int countRemNodes[]=new int[n];
            boolean visited[]=new boolean[n];
            fillRemNodes(countRemNodes,lis,0,visited);
            visited=new boolean[n];
            int result[]=new int[n];
            findForZeroNode(lis,visited,0,result);
            visited=new boolean[n];

            finalFillNodes(lis,visited,0,result,n,countRemNodes);
            return result;



        }
    }
}
