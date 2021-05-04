package Bridge;

public abstract class Window {

	WindowImplementor Implementor;
	
	public Window(WindowImplementor w) {
		Implementor = w;
	}
	
	public void draw(int x, int y) {}
	
	public void drawButton(int x, int y, int width, int height, String text) {}
	
	public void drawLoadButton(int x, int y, int width, int height, String text) {}
	public void drawPreviousButton(int x, int y, int width, int height, String text, boolean visible) {}
	public void drawNextButton(int x, int y, int width, int height, String text, boolean visible) {}
	public void drawLabel(int x, int y, int width, int height, String text, boolean visible, String Name) {}

}
