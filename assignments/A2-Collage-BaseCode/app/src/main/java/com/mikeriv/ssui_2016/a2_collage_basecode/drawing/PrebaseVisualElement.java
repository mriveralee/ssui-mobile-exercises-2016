/**
 *
 */
package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Canvas;
import android.graphics.PointF;

/**
 * This base class provides a partial implementation of the VisualElement interface.
 * You are to provide the rest of this implementation to create a full base
 * class called BaseVisualElement (which must inherit from this class).
 *
 * @see PrebaseVisualElement
 * @author Scott Hudson
 * @author Michael Rivera (modified 10/16/2016)
 *
 */
public abstract class PrebaseVisualElement implements VisualElement {

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#setPosition(android.graphics.PointF)
	 */
	@Override
    public void setPosition(PointF pos) {
		if (pos != null) {
			setPosition(pos.x, pos.y);
		}
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#setPosition(float, float)
	 */
	@Override
	public void setPosition(float x, float y) {
		setX(x);
		setY(y);
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#setX(float)
	 */
	@Override
	abstract public void setX(float x);

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#setY(float)
	 */
	@Override
	abstract public void setY(float y);

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#getPosition()
	 */
	@Override
	public PointF getPosition() {
		return new PointF(getX(),getY());
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#getX()
	 */
	@Override
	abstract public float getX();

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#getY()
	 */
	@Override
	abstract public float getY();

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#sizeIsIntrinsic()
	 */
	@Override
	public boolean sizeIsIntrinsic() {
		// default value -- override in subclasses that need to...
		return false;
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#setSize(android.graphics.PointF)
	 */
	@Override
	public void setSize(PointF size) {
		if (size != null) {
			setSize(size.x,size.y);
		}
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#setSize(float, float)
	 */
	@Override
	public void setSize(float w, float h) {
		setW(w);
		setH(h);
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#setW(float)
	 */
	@Override
	abstract public void setW(float w);

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#setH(float)
	 */
	@Override
	abstract public void setH(float h);

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#getSize()
	 */
	@Override
	public PointF getSize() {
		return new PointF(getW(),getH());
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#getW()
	 */
	@Override
	abstract public float getW();

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#getH()
	 */
	@Override
	abstract public float getH();

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#getParent()
	 */
	@Override
	abstract public VisualElement getParent();

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#setParent()
	 */
	@Override
	abstract public void setParent(VisualElement newParent);

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#getNumChildren()
	 */
	@Override
	abstract public int getNumChildren();

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#getChildAt(int)
	 */
	@Override
	abstract public VisualElement getChildAt(int index);

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#findChild(com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement)
	 */
	@Override
	abstract public int findChild(VisualElement child);

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#addChild(com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement)
	 */
	@Override
	abstract public void addChild(VisualElement child);

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#removeChildAt(int)
	 */
	@Override
	abstract public void removeChildAt(int index);

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#removeChild(com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement)
	 */
	@Override
	abstract public void removeChild(VisualElement child);

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#moveChildFirst(com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement)
	 */
	@Override
	abstract public void moveChildFirst(VisualElement child);

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#moveChildLast(com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement)
	 */
	@Override
	abstract public void moveChildLast(VisualElement child);

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#moveChildEarlier(com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement)
	 */
	@Override
	abstract public void moveChildEarlier(VisualElement child);

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#moveChildLater(com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement)
	 */
	@Override
	abstract public void moveChildLater(VisualElement child);


	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#doLayout()
	 */
	@Override
	abstract public void doLayout();

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#draw(android.graphics.Canvas)
	 */
	@Override
	abstract public void draw(Canvas onCanvas);

	/**
	 * Default constructor.
	 */
	public PrebaseVisualElement() {
		// do default initialization at an odd size so its easy to see when
		// the size is never set up.
		this(0,0);
	}

	/**
	 * Constructor with position only.
	 */
	public PrebaseVisualElement(float xLoc, float yLoc) {
		// do default initialization at an odd size so its easy to see when
		// the size is never set up.
		this(xLoc,yLoc,13.7f, 17.9f);
	}

	/**
	 * Full constructor giving position and size.
	 */
	public PrebaseVisualElement(float xLoc, float yLoc, float width, float height) {
		setPosition(xLoc,yLoc);
		setSize(width,height);
	}
}
