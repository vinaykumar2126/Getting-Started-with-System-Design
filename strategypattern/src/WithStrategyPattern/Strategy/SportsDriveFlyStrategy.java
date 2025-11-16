package WithStrategyPattern.Strategy;

public class SportsDriveFlyStrategy implements DriveStrategy {
    @Override
    public void drive(){
        System.out.println("Sports drive capability with flying feature");
    }
    
}
