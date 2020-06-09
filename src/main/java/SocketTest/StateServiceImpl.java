package SocketTest;

public class StateServiceImpl implements StateService {
    @Override
    public Score getScoreByState(int state) {
        System.out.println("方法执行");
        return Score.getS(state);
    }

    @Override
    public void saveScore(Score s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        System.out.println(Score.getS(100));

    }

}
