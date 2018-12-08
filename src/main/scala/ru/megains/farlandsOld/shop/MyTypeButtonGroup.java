package ru.megains.farlandsOld.shop;


import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.Iterator;

public class MyTypeButtonGroup extends ButtonsParentGroup {
    private ClassButtonGroup classButtonGroup;
    private int locId;
    private int buttonSelected = 0;

    public MyTypeButtonGroup(ClassButtonGroup classButtonGroup, int locId) {
        this.classButtonGroup = classButtonGroup;
        this.locId = locId;
    }

    public void addButton(MyTypeButton button) {
        int width = 0;

        Actor btn;
        for(Iterator var3 = this.getChildren().iterator(); var3.hasNext(); width = (int)((float)width + btn.getWidth())) {
            btn = (Actor)var3.next();
        }

        button.setLocId(this.locId);
        button.setPosition((float)width, 0.0F);
        this.addActor(button);
    }

    public void click(int buttonId) {
        this.buttonSelected = buttonId;
        Iterator var2 = this.getChildren().iterator();

        while(var2.hasNext()) {
            Actor btn = (Actor)var2.next();
            ((MyTypeButton)btn).click(buttonId, this.classButtonGroup.getSelectedClass());
        }

    }

    public int getNameGroupSelected() {
        return 0;
    }

    public int getButtonSelected() {
        return this.buttonSelected;
    }
}

