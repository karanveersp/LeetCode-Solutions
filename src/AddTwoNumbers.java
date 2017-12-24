
class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if (l1 == null && l2 == null)
            return null;
        else if (l1 == null){
            l1 = new ListNode(0);
        }
        else if (l2 == null){
            l2 = new ListNode(0);
        }
        
        int resultVal = ((l1.val + l2.val) % 10);
        int carryOver = (l1.val + l2.val) / 10;
        ListNode result = new ListNode(resultVal);
        
        if (carryOver != 0){
            if (l1.next != null){
                l1.next.val++;
            }
            else if (l2.next != null){
                l2.next.val++;
            }
            else{
                result.next = new ListNode(1);
                return result;
            }
        }
        
        result.next = addTwoNumbers(l1.next, l2.next);
        return result;
    }

    // recursive buildList for testing
    public static ListNode buildList(ListNode head, int[] arr, int i){
        if (i == arr.length) return null;
        head = new ListNode(arr[i]);
        head.next = buildList(head, arr, i+1);
        return head;
    }

    // recursive traversal of a list returning values as a string
    public static String traverseList(ListNode list){
        if (list == null) return "";
        String num = String.valueOf(list.val);
        return num + traverseList(list.next);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);

        int[] input1 = new int[]{2,4,3};
        int[] input2 = new int[]{5,6,4};

        l1 = buildList(l1, input1, 0);
        l2 = buildList(l1, input2, 0);

        ListNode resultList = addTwoNumbers(l1, l2);

        String result = traverseList(resultList);

        System.out.println("List 1 = (2 -> 4 -> 3) : List 2 = (5 -> 6 -> 4)");
        System.out.println("Sum = (" + result.charAt(0) + " -> " + result.charAt(1) + " -> " + result.charAt(2) + ")");
        System.out.println("342 + 465 = 807");

    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}