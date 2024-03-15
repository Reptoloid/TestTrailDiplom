package framework.elements;

import org.openqa.selenium.By;


public class ComboBox extends BaseElments{
    public ComboBox(By by) {
        super(by);
    }

    @Override
    protected String getElementType() {
        return getLoc("log.combo.box");
    }
}
