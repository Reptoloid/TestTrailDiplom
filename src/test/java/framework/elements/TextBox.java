package framework.elements;

import org.openqa.selenium.By;

public class TextBox extends BaseElments {

    public TextBox(By by) {
        super(by);
    }

    @Override
    protected String getElementType() {
        return getLoc("log.text.box");
    }
}
