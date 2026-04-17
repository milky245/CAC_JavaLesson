package lesson09.challenge04.Nurserry.logic;

import lesson09.challenge04.Nurserry.Exception.CriticalConditionException;

public class Nurse {
    private String name;

    public Nurse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //ここに適切な処理を記述
    public void takeTemperature(NurserySchoolChild child) throws CriticalConditionException {

        int temperature = child.getTemperature();
        System.out.println(child.getName() + "の体温は" + temperature + "度です。");
        if (temperature >= 38) {
            throw new CriticalConditionException("\n"+child.getName() + "は重体です。\n\nすぐに病院に行ってください。");
        }
    }


}
