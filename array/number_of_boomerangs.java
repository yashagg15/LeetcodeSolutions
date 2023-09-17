package array;

public class number_of_boomerangs {

    class Solution {
        public int numberOfBoomerangs(int[][] points) {


            Map<Integer,Integer> map=new HashMap<>();
            int res=0;

            for(int i=0;i<points.length;i++){
                map=new HashMap<>();
                for(int j=0;j<points.length;j++){

                    if(i!=j){
                        int x=points[i][0]-points[j][0];
                        int y=points[i][1]-points[j][1];
                        int dist=x*x+y*y;
                        if(!map.containsKey(dist)){
                            map.put(dist,1);
                        }else{
                            map.put(dist,map.get(dist)+1);
                        }
                    }


                }
                System.out.println(map);
                for(Integer v:map.values()){
                    res=res+v*(v-1);
                }
            }


            return res;


        }
    }
}
