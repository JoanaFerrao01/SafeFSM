package model.fsm.states;

import model.data.SafeData;
import model.fsm.SafeContext;
import model.fsm.SafeState;
import model.fsm.SafeStateAdapter;

public class ClosedSafeState extends SafeStateAdapter {
    public ClosedSafeState(SafeContext context, SafeData data) {
        super(context, data);
    }

    @Override
    public boolean open(String inputPin) {
        if(data.openDoor(inputPin)) {
            changeState(new OpenSafeState(context, data));
            return true;
        }

        if(data.isBlocked()) changeState(SafeState.BLOCKED);
            //changeState(new BlockedSafeState(context,data));

        return false;
    }

    @Override
    public SafeState getState() {
        return SafeState.CLOSED;
    }
}
