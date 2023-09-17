package QueuePlusDp;

//PriorityQueue Hard ques
public class IPO {

    class Solution {
        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

            PriorityQueue<Integer> proft=new PriorityQueue<>((a,b)->profits[b]-profits[a]);

            PriorityQueue<Integer> cap=new PriorityQueue<>((a,b)->capital[a]-capital[b]);

            for(int i=0;i<capital.length;i++){
                cap.add(i);
            }

            while(k>0){

                while(!cap.isEmpty() && capital[cap.peek()]<=w){
                    proft.add(cap.poll());
                }
                if(proft.isEmpty())
                    break;

                w=w+profits[proft.poll()];
                k--;
            }
            return w;




        }

    }

}
