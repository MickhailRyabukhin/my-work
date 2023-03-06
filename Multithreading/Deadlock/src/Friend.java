public class Friend implements Comparable<Friend> {
    
    private final String name;
    private int balls = 0;
    
    public Friend(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void throwBallTo(Friend catcher) {
        if (balls > 2000) {
            System.exit(1);
        }
        System.out.format("%s: %s кинул мне мяч!%n", catcher.getName(), this.name);
        balls++;
        synchronized (compareTo(catcher) > 0 ? catcher : this) {
            catcher.throwBallTo(this);
        }
        
    }
    
    @Override
    public int compareTo(Friend o) {
        return this.getName().compareTo(o.getName());
    }
}
