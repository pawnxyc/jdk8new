package SocketTest;

public interface StateService {

    Score getScoreByState(int state);

    void saveScore(Score s);
}
