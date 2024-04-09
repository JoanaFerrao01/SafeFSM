package model.fsm;

import model.data.SafeData;
import model.fsm.states.BlockedSafeState;
import model.fsm.states.ClosedSafeState;
import model.fsm.states.OpenSafeState;

public enum SafeState {
    CLOSED, OPEN, BLOCKED;

    //factory method: same
    //v1
    public static ISafeState getInstance(SafeState type, SafeContext context, SafeData data){
        return switch (type){
            case OPEN -> new OpenSafeState(context,data);
            case BLOCKED -> new BlockedSafeState(context,data);
            case CLOSED -> new ClosedSafeState(context,data);
        };
    }

    //v2
    public ISafeState getInstance(SafeContext context, SafeData data){
        return switch (this){
            case OPEN -> new OpenSafeState(context,data);
            case BLOCKED -> new BlockedSafeState(context,data);
            case CLOSED -> new ClosedSafeState(context,data);
        };
    }
}

