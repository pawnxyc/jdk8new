import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.Predicate;

@Data
@AllArgsConstructor
//定义两个谓词逻辑
public class User {

    private int year;
    private String name;
    private char sex;
    public static final Predicate<User> yearmorethen10 = user -> user.getYear()>10;
    public static final Predicate<User> sexisman = user -> user.getSex() == 'm';

}
