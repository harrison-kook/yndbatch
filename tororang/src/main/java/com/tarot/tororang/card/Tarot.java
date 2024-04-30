package com.tarot.tororang.card;

import com.tarot.tororang.enums.TarotEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Tarot {
    public void printTarotCards() {
        String[] tarot = getSortedTarotCards();

//        System.out.print(tarot[0]);

        for (int i = 0; i < 3; i++) {
//            System.out.println(tarot[i]);
            System.out.println(TarotEnum.nValue(tarot[i]));
            System.out.println(TarotEnum.nAddr(tarot[i]));
        }
    }

    private List<String> getTarotCardList() {
        List<String> cardList = getCardList();
        List<String> tarot;

        Collections.shuffle(cardList);

        tarot = cardList.subList(0, 3);

        return tarot;
    }

    private String[] getSortedTarotCards() {
        List<String> tarot = getTarotCardList();
        String[] result = new String[3];

        tarot.toArray(result);
        Arrays.sort(result);

        return result;
    }

    private List<String> getCardList() {
        List<String> cardList = new ArrayList<String>();
        cardList.add("TMU00");
        cardList.add("TMR00");
        cardList.add("TMU01");
        cardList.add("TMR01");
        cardList.add("TMU02");
        cardList.add("TMR02");
        cardList.add("TMU03");
        cardList.add("TMR03");
        cardList.add("TMU04");
        cardList.add("TMR04");
        cardList.add("TMU05");
        cardList.add("TMR05");
        cardList.add("TMU06");
        cardList.add("TMR06");
        cardList.add("TMU07");
        cardList.add("TMR07");
        cardList.add("TMU08");
        cardList.add("TMR08");
        cardList.add("TMU09");
        cardList.add("TMR09");
        cardList.add("TMU10");
        cardList.add("TMR10");
        cardList.add("TMU11");
        cardList.add("TMR11");
        cardList.add("TMU12");
        cardList.add("TMR12");
        cardList.add("TMU13");
        cardList.add("TMR13");
        cardList.add("TMU14");
        cardList.add("TMR14");
        cardList.add("TMU15");
        cardList.add("TMR15");
        cardList.add("TMU16");
        cardList.add("TMR16");
        cardList.add("TMU17");
        cardList.add("TMR17");
        cardList.add("TMU18");
        cardList.add("TMR18");
        cardList.add("TMU19");
        cardList.add("TMR19");
        cardList.add("TMU20");
        cardList.add("TMR20");
        cardList.add("TMU21");
        cardList.add("TMR21");
        cardList.add("TSU01");
        cardList.add("TSR01");
        cardList.add("TSU02");
        cardList.add("TSR02");
        cardList.add("TSU03");
        cardList.add("TSR03");
        cardList.add("TSU04");
        cardList.add("TSR04");
        cardList.add("TSU05");
        cardList.add("TSR05");
        cardList.add("TSU06");
        cardList.add("TSR06");
        cardList.add("TSU07");
        cardList.add("TSR07");
        cardList.add("TSU08");
        cardList.add("TSR08");
        cardList.add("TSU09");
        cardList.add("TSR09");
        cardList.add("TSU10");
        cardList.add("TSR10");
        cardList.add("TSU11");
        cardList.add("TSR11");
        cardList.add("TSU12");
        cardList.add("TSR12");
        cardList.add("TSU13");
        cardList.add("TSR13");
        cardList.add("TSU14");
        cardList.add("TSR14");
        cardList.add("TPU01");
        cardList.add("TPR01");
        cardList.add("TPU02");
        cardList.add("TPR02");
        cardList.add("TPU03");
        cardList.add("TPR03");
        cardList.add("TPU04");
        cardList.add("TPR04");
        cardList.add("TPU05");
        cardList.add("TPR05");
        cardList.add("TPU06");
        cardList.add("TPR06");
        cardList.add("TPU07");
        cardList.add("TPR07");
        cardList.add("TPU08");
        cardList.add("TPR08");
        cardList.add("TPU09");
        cardList.add("TPR09");
        cardList.add("TPU10");
        cardList.add("TPR10");
        cardList.add("TPU11");
        cardList.add("TPR11");
        cardList.add("TPU12");
        cardList.add("TPR12");
        cardList.add("TPU13");
        cardList.add("TPR13");
        cardList.add("TPU14");
        cardList.add("TPR14");
        cardList.add("TWU01");
        cardList.add("TWR01");
        cardList.add("TWU02");
        cardList.add("TWR02");
        cardList.add("TWU03");
        cardList.add("TWR03");
        cardList.add("TWU04");
        cardList.add("TWR04");
        cardList.add("TWU05");
        cardList.add("TWR05");
        cardList.add("TWU06");
        cardList.add("TWR06");
        cardList.add("TWU07");
        cardList.add("TWR07");
        cardList.add("TWU08");
        cardList.add("TWR08");
        cardList.add("TWU09");
        cardList.add("TWR09");
        cardList.add("TWU10");
        cardList.add("TWR10");
        cardList.add("TWU11");
        cardList.add("TWR11");
        cardList.add("TWU12");
        cardList.add("TWR12");
        cardList.add("TWU13");
        cardList.add("TWR13");
        cardList.add("TWU14");
        cardList.add("TWR14");
        cardList.add("TCU01");
        cardList.add("TCR01");
        cardList.add("TCU02");
        cardList.add("TCR02");
        cardList.add("TCU03");
        cardList.add("TCR03");
        cardList.add("TCU04");
        cardList.add("TCR04");
        cardList.add("TCU05");
        cardList.add("TCR05");
        cardList.add("TCU06");
        cardList.add("TCR06");
        cardList.add("TCU07");
        cardList.add("TCR07");
        cardList.add("TCU08");
        cardList.add("TCR08");
        cardList.add("TCU09");
        cardList.add("TCR09");
        cardList.add("TCU10");
        cardList.add("TCR10");
        cardList.add("TCU11");
        cardList.add("TCR11");
        cardList.add("TCU12");
        cardList.add("TCR12");
        cardList.add("TCU13");
        cardList.add("TCR13");
        cardList.add("TCU14");
        cardList.add("TCR14");
        return cardList;
    }
}
