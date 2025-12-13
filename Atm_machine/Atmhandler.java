package Atm_machine;

public abstract class Atmhandler{
    private Atmhandler nextHandler;

    public String setNextHandler(Atmhandler handler){
        this.nextHandler = handler;
        return "Next Handler Set";
    }
    public void next(int amount){
        move(amount);
        if(nextHandler != null){
            nextHandler.next(amount);
        }
    }
    public abstract void move(int amount);

}

    

    

