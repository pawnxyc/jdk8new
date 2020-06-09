import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class StreamUse {

    public static void main(String[] args) {
//用stream流的方式来处理集合,流是jdk8配合lambda表达式的增强集合数据处理的方式，
        List<String> list = Arrays.asList("james","curry","harden1111","hamerose","hhhhxd");
        List<String> players = list.stream().
                filter(s->s.startsWith("h")).
                map(String::toUpperCase).//每一个value来调方法。
                sorted().
                collect(Collectors.toList());

        System.out.println(players);
    }
}
