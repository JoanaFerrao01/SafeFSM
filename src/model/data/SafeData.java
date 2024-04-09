package model.data;

public class SafeData {
    private static final String PIN_CODE = "0000";
    private static final String PUK_CODE = "001100";
    private static final int MAX_TRIES = 3;

    private double value;
    private int tries;

    private boolean openDoor;

    public SafeData(){
        value = 0.0;
        tries = 0;
        openDoor = false;
    }

    public int getTries(){return tries;}

    public boolean isDoorOpen(){return openDoor;}

    public boolean isBlocked(){return tries >= MAX_TRIES;}

    public double getValue(){return openDoor ? value : -1;}

    public boolean deposit(double qt){
        if(!openDoor || qt<=0)
            return false;

        value += qt;
        return true;
    }

    public boolean witdraw(double qt){
        if(!openDoor || qt>value || qt<=0)
            return false;

        value-=qt;
        return true;
    }

    public boolean openDoor(String inputPin){
        if(openDoor || inputPin == null || isBlocked())
            return false;

        if(!PIN_CODE.equals(inputPin)){
            tries++;
            return false;
        }

        tries = 0;
        openDoor = true;
        return true;
    }

    public boolean closeDoor(){
        if(!openDoor)
            return false;

        openDoor = false;
        return true;
    }

    public boolean unBlock(String inputPuk){
        if(!isBlocked() || !PUK_CODE.equals(inputPuk)) //inputPuk == null não é necessário pq está a ser validado no equals ; se fosse inputPuk.equals já era preciso!
            return false;

        tries=0;
        return true;
    }
}
