public interface Fighter {
    void attack() throws InterruptedException;
    
    void takeDamage(int damage);
    
    void move(int x, int y);
    
    void gameOver();
}
