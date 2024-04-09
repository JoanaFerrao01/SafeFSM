package ui;

import model.fsm.SafeContext;

public class SafeUI {
    SafeContext fsm;

    public SafeUI(SafeContext fsm){
        this.fsm = fsm;
    }

    public void start(){
        int res;

        do{
            // * melhor!
            /*switch (fsm.getState()){
                case OPEN -> ;
                case CLOSED -> ;
                case BLOCKED -> ;
            }*/

            //pior..

            System.out.println("\nSafe controller ** \nCurrent State: " + fsm.getState());

            res = pt.isec.pa.utils.PAInput.chooseOption("Actions","Open","Close","Unblock","Consult","Deposit","Witdraw","Exit");
            switch (res){
                case 1 -> fsm.open(pt.isec.pa.utils.PAInput.readString("Pin Code: ",false));
                case 2 -> fsm.close();
                case 3 -> fsm.unBlock(pt.isec.pa.utils.PAInput.readString("Puk Code: ",false));
                case 4 -> System.out.printf("Balance: %.2f\n", fsm.consult());
                case 5 -> fsm.deposit(pt.isec.pa.utils.PAInput.readNumber("Amount: "));
                case 6 -> fsm.witdraw(pt.isec.pa.utils.PAInput.readNumber("Amount: "));
            }

        }while (res!=7);
    }
}
