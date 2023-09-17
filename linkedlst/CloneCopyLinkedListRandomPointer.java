package linkedlst;

class Node{
    int val;
    Node random;
    Node next;

    public Node(int val){
        this.val=val;
    }
}

public class CloneCopyLinkedListRandomPointer {
    class Solution {
        public Node copyRandomList(Node head) {

            Map<Node,Node> map=new HashMap<>();

            Node temp=head;
            int i=0;
            while(temp!=null){
                map.put(temp,new Node(temp.val));
                temp=temp.next;
            }
            temp=head;
            while(temp!=null){
                Node random=temp.random;
                if(random==null){
                    map.get(temp).random=null;
                }else{
                    Node ne=map.get(random);
                    map.get(temp).random=ne;
                }
                Node next=temp.next;
                if(next==null){
                    map.get(temp).next=null;
                }else{
                    Node ne=map.get(next);
                    map.get(temp).next=ne;
                }
                temp=temp.next;
            }
            return map.get(head);



        }
    }
}
