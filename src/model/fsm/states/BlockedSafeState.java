package model.fsm.states;

import model.data.SafeData;
import model.fsm.SafeContext;
import model.fsm.SafeState;
import model.fsm.SafeStateAdapter;

public class BlockedSafeState extends SafeStateAdapter {
    public BlockedSafeState(SafeContext context, SafeData data) {
        super(context, data);
    }

    @Override
    public boolean unBlock(String inputPuk) {
        boolean res = data.unBlock(inputPuk);

        if(res)
            //changeState(new ClosedSafeState(context,data));
            changeState(SafeState.CLOSED);

        return res;
    }

    @Override
    public SafeState getState() {
        return SafeState.BLOCKED;
    }
}
