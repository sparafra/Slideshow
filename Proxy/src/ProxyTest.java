import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Bridge.IconWindow;
import Bridge.MacImplementor;
import Bridge.Window;

class ProxyTest {

	@Test
	void test() {
		Window win = new IconWindow(new MacImplementor());
		win.drawLoadButton(10, 10, 111, 11, "12");
	}

}
