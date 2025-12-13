package Atm_machine;

public class Controller {
    private static Controller instance;
    private Atmhandler atmhandler;

        private Controller(){
            Atmhandler idle = new idle();
            Atmhandler cardinserted = new selectamount();
            Atmhandler pinentered = new withdraw();
            this.atmhandler = idle;
            idle.setNextHandler(cardinserted);
            cardinserted.setNextHandler(pinentered);
        }

    public static Controller getInstance(){
        if(instance==null){
            instance = new Controller();
        }
        return instance;
    }
    public void level(int amount){
        atmhandler.next(amount);
    }
}
