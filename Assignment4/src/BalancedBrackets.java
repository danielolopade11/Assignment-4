public class BalancedBrackets {

    public static String isBalanced(String s){
        DoublyLinkedList balance = new DoublyLinkedList();
        for(int i = 0; i < s.length(); i++){
            balance.add(s.charAt(i));
        }
        Node end = balance.getTail();
        Node beg = balance.getHead();
        while(end.next != beg && end != beg){
            if(beg.data == '(' && end.data == ')'){
                end = end.prev;
                beg = beg.next;
                continue;
            }
            if(beg.data == '{' && end.data == '}'){
                end = end.prev;
                beg = beg.next;
                continue;
            }
            if(beg.data == '[' && end.data == ']'){
                end = end.prev;
                beg = beg.next;
                continue;
            }

            return "NO";

        }

        return "YES";
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{[()]}"));
        System.out.println(isBalanced("{[(]]}"));
        System.out.println(isBalanced("{{[[(())]]}}"));
    }
}
