package model.fsm;
import model.data.SafeData;
import model.fsm.states.ClosedSafeState;

// * por onde vão entrar as ordens da maquina de estados
// dps vai redirecionar as ordens ao estado atual
public class SafeContext {
    private ISafeState currentFSMState;
    private SafeData data;

    public SafeContext(){
        data = new SafeData();
        //currentFSMState = new ClosedSafeState(this,data);
        currentFSMState = SafeState.CLOSED.getInstance(this,data);
    }

    //public SafeContext(SafeData data){ //dependency injection
    //    this.data = data;
    //    ......
    //    currentFSMState = new ...(this,data);
    //}

    void changeState(ISafeState newState){
        currentFSMState = newState;
    }

    public SafeState getState(){
        return currentFSMState.getState();
    }

    public boolean open(String inputPin) {
        return currentFSMState.open(inputPin);
    }

    public boolean close() {
        return currentFSMState.close();
    }

    public boolean unBlock(String inputPuk) {
        return currentFSMState.unBlock(inputPuk);
    }

    public boolean deposit(double qt) {
        return currentFSMState.deposit(qt);
    }

    public boolean witdraw(double qt) {
        return currentFSMState.witdraw(qt);
    }

    public double consult() {
        return currentFSMState.consult();
    }

    // * GETTERS GLOBAIS:
    // (to show info if you want :) )

    //so podem emitir dados publicos
    // ! nunca um set!

    public int getTriess(){return data.getTries();}
    public boolean isOpen(){return data.isDoorOpen();}
}
