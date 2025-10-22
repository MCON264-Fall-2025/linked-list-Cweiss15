package linkedlist;

import org.apache.commons.lang3.NotImplementedException;
import support.CycleInfo;
import support.LLNode;

public class LinkedListCycleAnalyzer<T> {
    public static <T> CycleInfo detectCycleInfo(LLNode<T> head) {
        LLNode<T> fast = head;
        LLNode<T> slow = head;
        int size = 1;
        int index = 0;


        while (fast != null && fast.getLink() != null) {
            slow = slow.getLink();
            fast = fast.getLink().getLink();

            if (fast == slow) {
                slow = head;

                while (fast != slow) {
                    slow = slow.getLink();
                    fast = fast.getLink();
                    index++;
                }

                LLNode<T> temp = slow.getLink();
                while (slow != temp) {
                    temp = temp.getLink();
                    size++;
                }
                return new CycleInfo(index, size);
            }
        }
        return new CycleInfo(-1, 0);
    }
}
