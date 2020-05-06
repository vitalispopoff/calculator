package gui;

import static org.assertj.swing.edt.GuiActionRunner.execute;

import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;

public class ButtonTest{

    private FrameFixture window;

    public static void setUpOnce(){
        FailOnThreadViolationRepaintManager.install();
    }

    @Before
    public void initial(){
        MainFrame frame = execute(()-> new MainFrame(Settings.readSettings()));
    }

    @After
    public void terminal(){
        window.cleanUp();
    }
}