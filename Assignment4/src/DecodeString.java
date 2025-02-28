public class DecodeString {
    public static String decodeString(String s) {
        DoublyLinkedList charStack = new DoublyLinkedList();
        IntDoublyLinkedList countStack = new IntDoublyLinkedList();
        String currentString = "";
        int k = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.add(k);
                charStack.addString(currentString);
                currentString = "";
                k = 0;
            } else if (ch == ']') {

                StringBuilder decodedString = new StringBuilder();
                if(charStack.getTail() != null) {
                    decodedString.append(charStack.getTail().data);
                }
                charStack.removeLast();
                int repeatTimes = countStack.removeLast().data;
                for (int j = 0; j < repeatTimes; j++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString.toString();
            } else {
                currentString += ch;
            }
        }

        return currentString;
    }

    public static void main(String[] args) {
        String s1 = "3[a]2[bc]";
        System.out.println(decodeString(s1));

        String s2 = "3[a2[c]]";
        System.out.println(decodeString(s2));

        String s3 = "2[abc]3[cd]ef";
        System.out.println(decodeString(s3));
    }
}
