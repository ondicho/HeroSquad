public class Squad {
    private String name;
    private String cause;
    private int maxSize;
    private Hero squadList;

    public Squad(String name, String cause, int maxSize, Hero squadList){
        name=name;
        cause=cause;
        maxSize=maxSize;

    }

    public String getName() {
        return name;
    }

    public String getCause() {
        return cause;
    }

    public Hero getSquadList() {
        return squadList;
    }

    public int getMaxSize() {
        return maxSize;
    }
}
