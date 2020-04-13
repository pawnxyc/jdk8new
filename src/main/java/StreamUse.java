import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class StreamUse {

    public static void main(String[] args) {
//用stream流的方式来处理集合
        List<String> list = Arrays.asList(new String[]{"james","curry","harden1111","hamerose"});
        List<String> players = list.stream().
                filter(s->s.startsWith("h")).
                map(String::toUpperCase).
                sorted().
                collect(Collectors.toList());

        System.out.println(players);
    }
}
