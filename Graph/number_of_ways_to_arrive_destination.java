package Graph;

public class number_of_ways_to_arrive_destination {

    class Solution {
        public int countPaths(int n, int[][] roads) {

            List<Map<Integer,Integer>> list=new ArrayList<>();

            for(int i=0;i<n;i++){
                list.add(new HashMap<>());
            }

            for(int i=0;i<roads.length;i++){
                list.get(roads[i][0]).put(roads[i][1],roads[i][2]);
                list.get(roads[i][1]).put(roads[i][0],roads[i][2]);
            }


            long[] dp=new long[n];
            Arrays.fill(dp,Long.MAX_VALUE);

            long count[]=new long[n];
            count[n-1]=1;

            PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->{
                if(a[1]<=b[1])
                    return -1;
                return 1;
            });
            pq.add(new long[]{n-1,0});
            long[] res=new long[]{Long.MAX_VALUE,1};

            while(!pq.isEmpty()){

                long[] pol=pq.poll();
                if(dp[(int)pol[0]]<pol[1])
                    continue;
                Map<Integer,Integer> m=list.get((int)pol[0]);

                for(Map.Entry<Integer,Integer> h:m.entrySet()){
                    long val=pol[1]+h.getValue();
                    int up=h.getKey();
                    // if(up==0){
                    //     if(res[0]>val){
                    //        res=new long[]{val,1};
                    //     }else if(res[0]==val){
                    //         res=new long[]{val,res[1]+1};
                    //     }
                    // }

                    if(dp[up]>val && up!=(n-1)){
                        dp[up]=val;
                        count[up]=count[(int)pol[0]];
                        pq.add(new long[]{up,val});
                    }else if(dp[up]==val){
                        count[up]=(count[up]+count[(int)pol[0]])%1000000007;
                    }
                }


            }

            return (int)(count[0]%(1000000000+7));



        }
    }
}
