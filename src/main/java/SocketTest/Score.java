package SocketTest;

public enum Score {
    PERFECT(100,"满分"),GOOD(80,"优秀"),NOT_BAD(60,"及格"),BAD(10,"差生");
    private int grade;
    private String priority;

    @Override
    public String toString() {
        return this.priority+"===="+this.grade;
    }

    private Score(int grade, String priority){
        this.grade = grade;
        this.priority = priority;
    }
    public static Score getS(int i){
        switch (i){
            case 100:return Score.PERFECT;
            case 80:return Score.GOOD;
            case 60:return Score.NOT_BAD;
            case 10:return Score.BAD;
        }
        return PERFECT;
    }
}
