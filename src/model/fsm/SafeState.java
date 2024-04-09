package model.fsm;

import model.data.SafeData;
import model.fsm.states.BlockedSafeState;
import model.fsm.states.ClosedSafeState;
import model.fsm.states.OpenSafeState;

public enum SafeState {
    CLOSED, OPEN, BLOCKED;

    public static ISafeState getInstance(SafeState type, SafeContext context, SafeData data){
        return switch (type){
            case OPEN -> new OpenSafeState(context,data);
            case BLOCKED -> new BlockedSafeState(context,data);
            case CLOSED -> new ClosedSafeState(context,data);
        };
    }

    public ISafeState getInstance(SafeContext context, SafeData data){
        return switch (this){
            case OPEN -> new OpenSafeState(context,data);
            case BLOCKED -> new BlockedSafeState(context,data);
            case CLOSED -> new ClosedSafeState(context,data);
        };
    }
}

