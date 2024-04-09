package model.fsm.states;

import model.data.SafeData;
import model.fsm.SafeContext;
import model.fsm.SafeState;
import model.fsm.SafeStateAdapter;

public class OpenSafeState extends SafeStateAdapter {
    public OpenSafeState(SafeContext context, SafeData data) {
        super(context, data);
    }

    @Override
    public boolean deposit(double qt){
        //boolean res = data.deposit(qt);
        //decidir estado seguinte
        //alterar estado
        //changeState(new OpenSafeState(context,data));
        //return res;

        return data.deposit(qt); //fica no msm estado (check diagrama de estados if needed)
    }

    @Override
    public boolean witdraw(double qt) {
        return data.witdraw(qt); //fica no msm estado (check diagrama de estados if needed)
    }

    @Override
    public double consult() {
        return data.getValue(); //fica no msm estado (check diagrama de estados if needed)
    }

    @Override
    public boolean close() {
        boolean res = data.closeDoor();
        if (res)
            //changeState(new ClosedSafeState(context, data));
            //changeState(SafeStateFactory.getInstance(SafeState.CLOSED,context,data));
            //changeState(SafeState.CLOSED.getInstance(context,data));
            changeState(SafeState.CLOSED);
        return res;
    }

    @Override
    public SafeState getState() {
        return SafeState.OPEN;
    }
}
