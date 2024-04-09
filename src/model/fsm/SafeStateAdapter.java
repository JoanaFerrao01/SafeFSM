package model.fsm;
import model.data.SafeData;


//! esta classe tem de ficar no msm package da context !!!
// porque o changeState é package private
public abstract class SafeStateAdapter implements ISafeState{
    protected SafeContext context;
    protected SafeData data;

    protected SafeStateAdapter(SafeContext context, SafeData data){
        this.context = context;
        this.data = data;
    }

    protected void changeState(ISafeState newState){ //recebe o estado ja construido
        context.changeState(newState);
    }

    protected void changeState(SafeState newState){ //recebe apenas a enumeracao (q o identifica)
        context.changeState(newState.getInstance(context,data));
    }

    @Override
    public boolean open(String inputPin) {

        /*
            1. atuar sobre os dados
            2. decidir o prox estado
            3. alterar estado
        */
        return false;
    }

    @Override
    public boolean close() {
        return false;
    }

    @Override
    public boolean unBlock(String inputPuk) {
        return false;
    }

    @Override
    public boolean deposit(double qt) {
        return false;
    }

    @Override
    public boolean witdraw(double qt) {
        return false;
    }

    @Override
    public double consult() {
        return -1.0;
    }
}

