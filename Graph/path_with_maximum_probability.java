package Graph;

//Based on Dijkstra
public class path_with_maximum_probability {

    class Solution {

        class Prob{
            public int key;
            public double value;

            public Prob(int key,double value){
                this.key=key;
                this.value=value;
            }
            public int getKey(){
                return key;
            }
            public double getValue(){
                return value;
            }
        }

        public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

            Map<Integer,Map<Integer,Double>> mp=new HashMap<>();

            for(int i=0;i<n;i++)
                mp.put(i,new HashMap<>());

            for(int i=0;i<edges.length;i++){
                mp.get(edges[i][0]).put(edges[i][1],succProb[i]);
                mp.get(edges[i][1]).put(edges[i][0],succProb[i]);
            }
            Prob prob=new Prob(start,1);

            PriorityQueue<Prob> queue=new PriorityQueue<>((a,b)->{
                if(b.getValue()>a.getValue())
                    return 1;
                return -1;
            });
            queue.add(prob);
            double succ[]=new double[n];
            succ[start]=1;

            while(!queue.isEmpty()){
                Prob p=queue.poll();
                int key=p.getKey();
                double value=p.getValue();
                Map<Integer,Double> temp=mp.get(key);
                for(Map.Entry<Integer,Double> m:temp.entrySet()){
                    int upcomingKey=m.getKey();
                    double probValue=m.getValue();
                    double mul=value*probValue;
                    if(mul>succ[upcomingKey]){
                        succ[upcomingKey]=mul;
                        queue.add(new Prob(upcomingKey,mul));
                    }

                }
            }

            return succ[end];

        }
    }
}
