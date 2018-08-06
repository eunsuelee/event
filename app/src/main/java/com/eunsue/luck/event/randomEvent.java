package com.eunsue.luck.event;

import java.util.ArrayList;
import java.util.Random;

public class randomEvent {
    private ArrayList<Integer> card = new ArrayList<>();
    private String[] event = {"꽝", "꽝", "당첨", "꽝"};

    public randomEvent(){
        setRandom();
    }

    public String getResult(int index){
        String result = "";
        try {
            int event_index = card.get(index);
            result = this.event[event_index];
        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
            result = "잘못된 입력 값 입니다. (1~4)";
        }
        return result;
    }

    public void setRandom(){
        Random random = new Random();
        ArrayList<Integer> buf = new ArrayList<>();

        for(int i=0; i<4; i++){
            int index = random.nextInt(4);

            if(buf.contains(index)){
                i--;
            }
            else{
                buf.add(index);
            }
        }

        card = buf;
    }
}
