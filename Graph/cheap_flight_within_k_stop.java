package Graph;

// Based on dijkstra problem.
public class cheap_flight_within_k_stop {
    class Solution {
        int result=Integer.MAX_VALUE;

        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {


            Map<Integer,Map<Integer,Integer>> mp=new HashMap<>();
            for(int i=0;i<n;i++){
                mp.put(i,new HashMap<>());
            }

            for(int i=0;i<flights.length;i++){
                int s=flights[i][0];
                int d=flights[i][1];
                int val=flights[i][2];
                mp.get(s).put(d,val);
            }
            int dist[]=new int[n];
            for(int i=0;i<n;i++)
                dist[i]=Integer.MAX_VALUE;
            int count=0;
            Queue<int[]> queue=new LinkedList<>();
            queue.add(new int[]{0,src});

            while(!queue.isEmpty() && count<=k){
                int siz=queue.size();
                while(siz>0){

                    int[] temp=queue.poll();
                    int point=temp[1];
                    int curDist=temp[0];
                    Map<Integer,Integer> m=mp.get(point);
                    for(Map.Entry<Integer,Integer> p:m.entrySet()){
                        int des=p.getKey();
                        if(dist[des]>p.getValue()+curDist){
                            dist[des]=p.getValue()+curDist;
                            queue.add(new int[]{p.getValue()+curDist,des});
                        }
                        else
                            continue;


                    }
                    siz--;
                }

                count++;
            }
            return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];

        }
    }
}
