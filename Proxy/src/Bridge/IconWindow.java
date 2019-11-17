package Bridge;

public class IconWindow extends Window{

	
	public IconWindow(WindowImplementor w) {
		super(w);
	}
	
	@Override
	public void draw()
	{
		Implementor.drawBar();
		Implementor.drawTitle();
	}
	
	@Override
	public void drawButton(int x, int y, int width, int height, String text)
	{
		Implementor.drawButton(x, y, width, height, text);
	}
	
	@Override
	public void drawLoadButton(int x, int y, int width, int height, String text)
	{
		Implementor.drawLoadButton(x, y, width, height, text);
	}
	
	@Override
	public void drawPreviousButton(int x, int y, int width, int height, String text)
	{
		Implementor.drawPreviousButton(x, y, width, height, text);
	}
	
	@Override
	public void drawNextButton(int x, int y, int width, int height, String text)
	{
		Implementor.drawNextButton(x, y, width, height, text);
	}
}
