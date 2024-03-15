package framework.elements;

import org.openqa.selenium.By;

public class Image extends BaseElments {
    public Image(By by) {
        super(by);
    }

    @Override
    protected String getElementType() {
        return getLoc("log.image");
    }
}
