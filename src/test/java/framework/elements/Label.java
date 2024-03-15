package framework.elements;

import org.openqa.selenium.By;

public class Label extends BaseElments {
    public Label(By by) {
        super(by);
    }

    @Override
    protected String getElementType() {
        return getLoc("log.label");
    }
}
