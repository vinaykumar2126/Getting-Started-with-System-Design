package WithStrategyPattern;

import WithStrategyPattern.Strategy.SportsDriveFlyStrategy;

public class CycleVehicle extends Vehicle {
    CycleVehicle(){
        super(new SportsDriveFlyStrategy());
    }
}
    

