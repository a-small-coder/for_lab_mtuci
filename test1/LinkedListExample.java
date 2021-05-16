import java.util.LinkedList;
public class LinkedListExample {
        public static void main(String[] args) {
     
            String str1 = new String("Hello ");
            String str2 = new String("world");
            String str3 = new String("!");
            LinkedList<String> list = new LinkedList<>();
            list.add(str1);
            list.add(str3);
            list.add(1, str2);
     
            System.out.println(list);
            // будет выведено [Hello , world, !]
     
        }
}
