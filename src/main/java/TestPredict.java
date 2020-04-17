import java.util.*;
import java.util.stream.Collectors;

public class TestPredict {

    public static void main(String[] args) {
        User u1= new User(11,"xiaom",'m');
        User u2= new User(10,"pawn",'w');
        User u3= new User(122,"faker",'w');
        User u4= new User(11,"joker",'m');

        List<User> list = Arrays.asList(u1,u2,u3,u4);
        List<User>  list1 = list.stream().
                filter(User.yearmorethen10.and(User.sexisman)).
                collect(Collectors.toList());

        System.out.println(list1);
    }
}
