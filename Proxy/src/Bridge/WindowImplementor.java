package Bridge;

public interface WindowImplementor {
	
	public void draw(int x, int y);
	public void drawBar();
	public void drawTitle();
	public void drawButton(int x, int y, int width, int height, String text);
	public void drawLoadButton(int x, int y, int width, int height, String text);
	public void drawNextButton(int x, int y, int width, int height, String text, boolean visible);
	public void drawPreviousButton(int x, int y, int width, int height, String text, boolean visible);
	public void drawLabel(int x, int y, int width, int height, String text, boolean visible, String Name);
	public void showNext();
	public void showPrevious();
	
}
