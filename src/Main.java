/*

* AÇÕES                 |       ESTADOS
------------------------+---------------------------
- abrir                 |
    Input: código       |       Fechado
                        |
 - fechar               |       Aberto
                        |
 - depositar            |       Bloqueado
    Input: quantid      |
                        |       (Desbloqueado): fechado
 - levantar             |
    Input: quantid      |
                        |
 - consultar            |
                        |
 - desbloquear          |
    Input: Código PUK   |
                        |

 */
/*
    * DIAGRAMA DE ESTADOS

            abrir && codigo: errado && tentativas < 3          depositar/levantar
           +-----+                                              +----+
           |     V             abrir && codigo: correto         |    |
    o---->[Fechado]------------------------------------------->[Aberto]<-+
            |    ^                                                 |     |
            |    +-------------------------------------------------+     |
            |                       fechar                               |
            |                                                            | desbloquear &&
            | abrir && codigo: errado && tentativas >= 3                 | puk: correto
            V                                                            |
         [Bloqueado]-----------------------------------------------------+
          ^       |
          +-------+
            desbloquear && puk: errado

 */

import model.fsm.SafeContext;
import ui.SafeUI;

public class Main {
    public static void main(String[] args) {
        SafeContext FSM = new SafeContext();
        SafeUI ui = new SafeUI(FSM);
        ui.start();
    }
}