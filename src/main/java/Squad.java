public class Squad {
    private String mSquadName;
    private String mCause;
    private int mMaxSize;
//    private Hero mSquadList;

    public Squad(String squadName, String cause, int maxSize){
        mSquadName=squadName;
        mCause=cause;
        mMaxSize=maxSize;

    }

    public String getName() {
        return mSquadName;
    }

    public String getCause() {
        return mCause;
    }

//    public Hero getSquadList() {
//        return mSquadList;
//    }

    public int getMaxSize() {
        return mMaxSize;
    }
}
