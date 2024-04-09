package model.fsm.states;

import model.data.SafeData;
import model.fsm.ISafeState;
import model.fsm.SafeContext;
import model.fsm.SafeState;

public class SafeStateFactory {
    private SafeStateFactory(){}

    //or in enum!!!!
    public static ISafeState getInstance(SafeState type, SafeContext context, SafeData data){
        return switch (type){
            case CLOSED -> new ClosedSafeState(context,data);
            case OPEN -> new OpenSafeState(context,data);
            case BLOCKED -> new BlockedSafeState(context,data);
        };
    }
}
