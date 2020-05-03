package gui;

import memory.Memory;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.*;

import java.io.Serializable;

import static org.assertj.swing.edt.GuiActionRunner.execute;

@Ignore
public class ButtonTest implements Serializable {

    private FrameFixture window;

    static {/*setUoOnce();*/
        FailOnThreadViolationRepaintManager.install();
    }

    public static void setUoOnce() {
        FailOnThreadViolationRepaintManager.install();
    }

    @Before
    public void initial(){
        MainFrame frame = execute(()-> new MainFrame(Settings.readSettings()));
        window = new FrameFixture(frame);
        window.show();
    }

    @After
    public void terminal(){
        window.cleanUp();
    }

//    @Test
    public void pushTheButton_01(){
        Assert.assertFalse(Memory.isValueNegative);
        window.button("button_∓").click();
//        Assert.assertTrue(Memory.isValueNegative);
    }

    @Test
    public void pushTheButton_02(){
        Assert.assertEquals(0, Memory.parserCache.length());
        window.button("button_.").click();
        Assert.assertEquals(1, Memory.parserCache.length());
    }

}