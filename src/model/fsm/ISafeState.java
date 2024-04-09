package model.fsm;

import model.fsm.SafeState;

public interface ISafeState {
    boolean open(String inputPin);
    boolean close();
    boolean unBlock(String inputPuk);
    boolean deposit(double qt);
    boolean witdraw(double qt);

    double consult(); //basicamente um get: MAS apenas válido em determinados momentos na maquina

    SafeState getState();
}
