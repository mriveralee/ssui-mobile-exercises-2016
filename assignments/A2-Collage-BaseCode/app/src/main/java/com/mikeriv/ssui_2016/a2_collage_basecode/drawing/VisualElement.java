
package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Canvas;
import android.graphics.PointF;

/**
 * This interface defines the API for all visual elements which can appear in
 * a collage, including elements intending to primarily provide visual displays
 * as well as those intending to primarily provide layouts for other visual
 * elements.  (Note that all objects implementing this interface are expected
 * to support and layout child objects.  However, objects primarily providing
 * visual displays are likely to do this in a simple default fashion.)
 *
 * Each <code>VisualElement</code> maintains a notion of its position (relative to
 * its containing or parent <code>VisualElement</code>) as well as its size.  its
 * size may be determined <i>intrinsically</i> (that is inside the object based
 * on what it draws) or may be set from the outside.  Every <code>VisualElement</code>
 * object is responsible for maintaining a possible list of <i>child</i> objects
 * which are contained inside it. Finally, each <code>VisualElement</code> object is
 * also responsible for drawing its own appearance, and for arranging for the
 * layout and drawing of a set of child objects that appear within it.
 *
 * @author Scott Hudson
 * @author Michael Rivera (modified 10/16/2016)
 *
 */
public interface VisualElement {
	/*--------------------------------------------------*/
	/* Geometry */
	/*--------------------------------------------------*/

	/* . . . . . . . . . . . . . . . . . . . . . . . . . */
	/**
	 * Set the position (of the top left corner) of the VisualElement
	 * with respect to its parent's top left corner.  Note that the position
	 * of an VisualElement is most typically established by its parent at layout time,
	 * so other calls to this routine may expect to often have their results
	 * replaced during layout.
	 *
	 * @param pos the new position of the VisualElement
	 */
	public void setPosition(PointF pos);

	/* . . . . . . . . . . . . . . . . . . . . . . . . . */
	/**
	 * Set the position (of the top left corner) of the VisualElement
	 * with respect to its parent's top left corner.  Note that the position
	 * of an VisualElement is most typically established by its parent at layout time,
	 * so other calls to this routine may expect to often have their results
	 * replaced during layout.
	 *
	 * @param x the new x position of the VisualElement
	 * @param y the new y position of the VisualElement
	 */
	public void setPosition(float x, float y);

	/* . . . . . . . . . . . . . . . . . . . . . . . . . */
	/**
	 * Set the x (horizontal) position (of the top left corner) of the VisualElement
	 * with respect to its parent's top left corner.  Note that the position
	 * of an VisualElement is most typically established by its parent at layout time,
	 * so other calls to this routine may expect to often have their results
	 * replaced during layout.
	 *
	 * @param x the new x position of the VisualElement
	 */
	public void setX(float x);

	/* . . . . . . . . . . . . . . . . . . . . . . . . . */
	/**
	 * Set the y (vertical) position (of the top left corner) of the VisualElement
	 * with respect to its parent's top left corner.  Note that the position
	 * of an VisualElement is most typically established by its parent at layout time,
	 * so other calls to this routine may expect to often have their results
	 * replaced during layout.
	 *
	 * @param y the new y position of the VisualElement
	 */
	public void setY(float y);

	/* . . . . . . . . . . . . . . . . . . . . . . . . . */
	/**
	 * Return the current x,y position of the VisualElement as a point
	 *
	 * @return the position of the VisualElement
	 */
	public PointF getPosition();

	/* . . . . . . . . . . . . . . . . . . . . . . . . . */
	/**
	 * Return the current x (horizontal) position of the VisualElement
	 *
	 * @return the x position of the VisualElement
	 */
	public float getX();

	/* . . . . . . . . . . . . . . . . . . . . . . . . . */
	/**
	 * Return the current y (vertical) position of the VisualElement
	 *
	 * @return the y position of the VisualElement
	 */
	public float getY();

	/* . . . . . . . . . . . . . . . . . . . . . . . . . */
	/**
	 * Indicate whether the size of this VisualElement is <i>intrinsic</i>.  An VisualElement
	 * has intrinsic size if it determines its own size.  For example, an
	 * VisualElement that draws an bitmap image might have an intrinsic size which is
	 * determined by the size of the bitmap.  VisualElements which have intrinsic size
	 * will ignore attempts to set their size with the <code>setSize()</code>,
	 * <code>setW()</code>, or <code>setH()</code> methods.
	 *
	 * @return a boolean indicating whether this object's size is intrinsic
	 *        (computed internally)
	 */
	public boolean sizeIsIntrinsic();

	/* . . . . . . . . . . . . . . . . . . . . . . . . . */
	/**
	 * Set the size of this object.  Note: if this object has intrinsic size
	 * (which will be indicated by the <code>sizeIsIntrinsic()</code> method
	 * returning true), this call is silently ignored.
	 * @param size a point providing two values for a size
	 *             (size.x gives the width and size.y gives the height)
	 */
	public void setSize(PointF size);

	/* . . . . . . . . . . . . . . . . . . . . . . . . . */
	/**
	 * Set the size of this object.  Note: if this object has intrinsic size
	 * (which will be indicated by the <code>sizeIsIntrinsic()</code> method
	 * returning true), this call is silently ignored.
	 * @param w the new width of the VisualElement
	 * @param h the new height of the VisualElement
	 */
	public void setSize(float w, float h);

	/* . . . . . . . . . . . . . . . . . . . . . . . . . */
	/**
	 * Set the width of this object.  Note: if this object has intrinsic size
	 * (which will be indicated by the <code>sizeIsIntrinsic()</code> method
	 * returning true), this call is silently ignored.
	 * @param w the new width of the VisualElement
	 */
	public void setW(float w);

	/* . . . . . . . . . . . . . . . . . . . . . . . . . */
	/**
	 * Set the height of this object.  Note: if this object has intrinsic size
	 * (which will be indicated by the <code>sizeIsIntrinsic()</code> method
	 * returning true), this call is silently ignored.
	 * @param h the new height of the VisualElement
	 */
	public void setH(float h);

	/* . . . . . . . . . . . . . . . . . . . . . . . . . */
	/**
	 * Return the size of this VisualElement as a point.  The x value of the point
	 * will provide the width of the object and the y value will provide the
	 * height.
	 * @return the size of the VisualElement as a point (x gives width, y gives height)
	 */
	public PointF getSize();

	/* . . . . . . . . . . . . . . . . . . . . . . . . . */
	/**
	 * Return the width of this VisualElement.
	 * @return the width of the VisualElement
	 */
	public float getW();


	/* . . . . . . . . . . . . . . . . . . . . . . . . . */
	/**
	 * Return the height of this VisualElement.
	 * @return the height of the VisualElement
	 */
	public float getH();

	/*--------------------------------------------------*/
	/* Child List Manipulation */
	/*--------------------------------------------------*/

	/* . . . . . . . . . . . . . . . . . . . . . . . . . */
	/**
	 * Return the parent of this VisualElement.  A null parent indicates that this
	 * VisualElement is not currently installed in any parent object.
	 * @return the parent of this VisualElement.
	 */
	public VisualElement getParent();

	/* . . . . . . . . . . . . . . . . . . . . . . . . . */
	/**
	 * Set the parent of this VisualElement.  Note: this method does not add or remove
	 * this object from the old or new parent's child list, it simply sets the
	 * recorded parent object for this VisualElement.  In most cases this action alone
	 * is not sufficient and should be accompanied by appropriate modifications
	 * to the child list of the parent object(s) involved.
	 * @param newParent the new parent of this VisualElement.
	 */
	public void setParent(VisualElement newParent);

	/* . . . . . . . . . . . . . . . . . . . . . . . . . */
	/**
	 * Return the number of children this VisualElement currently has
	 * @return the number of children of this VisualElement
	 */
	public int getNumChildren();

	/* . . . . . . . . . . . . . . . . . . . . . . . . . */
	/**
	 * Return the child object of this VisualElement at the given index (or null if
	 * the index is outside the valid child indexes for the VisualElement, i.e., is
	 * < 0 or >= <code>getNumChildren()</code>).
	 * @return the child at the given index (or null if out of bounds)
	 */
	public VisualElement getChildAt(int index);

	/* . . . . . . . . . . . . . . . . . . . . . . . . . */
	/**
	 * Find the given child this VisualElement's child list and return its index. If
	 * the given child is not a child of this VisualElement, this method returns -1.
	 * @return the index of the given child (or -1 of this is not a child)
	 */
	public int findChild(VisualElement child);

	/* . . . . . . . . . . . . . . . . . . . . . . . . . */
	/**
	 * Add the given child to the end of this VisualElement's child list.  Attempts to
	 * add null children are ignored.  If the given child is currently the child
	 * of another object it is removed from that parent's child list.  If the
	 * given child is currently the child of this object it is removed from the
	 * its current position in the child list and placed at the end.
	 * @param child the child to be added to the child list.
	 */
	public void addChild(VisualElement child);

	/* . . . . . . . . . . . . . . . . . . . . . . . . . */
	/**
	 * Remove the child at the given index in the VisualElement's child list.  Any
	 * children later in the child list are moved earlier (so the child list
	 * never contains "empty slots"). Attempts to remove non-existent children
	 * are ignored.  After this method, the removed child should report a null
	 * parent.
	 * @param index the index of the child to be removed.
	 */
	public void removeChildAt(int index);

	/* . . . . . . . . . . . . . . . . . . . . . . . . . */
	/**
	 * Remove the given child from the VisualElement's child list.  Any
	 * children later in the child list are moved earlier (so the child list
	 * never contains "empty slots"). Attempts to remove children
	 * not in the child list are ignored.  After this method, the removed
	 * child (if any) should report a null parent.
	 * @param child the child to be removed.
	 */
	public void removeChild(VisualElement child);

	/* . . . . . . . . . . . . . . . . . . . . . . . . . */
	/**
	 * Move the given child so that it is first in the child list, moving
	 * other children further back (and "filling in" the old slot of the child
	 * so that the child list never contains "empty slots").  Attempts to move
	 * a child not currently in the child list are ignored.
	 * @param child the child to be moved.
	 */
	public void moveChildFirst(VisualElement child);

	/* . . . . . . . . . . . . . . . . . . . . . . . . . */
	/**
	 * Move the given child so that it is last in the child list, moving
	 * other children earlier as needed and "filling in" the old slot of the
	 * child so that the child list never contains "empty slots".  Attempts to
	 * move a child not currently in the child list are ignored.
	 * @param child the child to be moved.
	 */
	public void moveChildLast(VisualElement child);

	/* . . . . . . . . . . . . . . . . . . . . . . . . . */
	/**
	 * Move the given child one position earlier in the child list, moving
	 * other children later as needed and "filling in" the old slot of the
	 * child so that the child list never contains "empty slots".  If this child
	 * is already at the front of the child list, this method does nothing.
	 * Attempts to move a child not currently in the child list are ignored.
	 * @param child the child to be moved.
	 */
	public void moveChildEarlier(VisualElement child);

	/* . . . . . . . . . . . . . . . . . . . . . . . . . */
	/**
	 * Move the given child one position later in the child list, moving
	 * other children earlier as needed and "filling in" the old slot of the
	 * child so that the child list never contains "empty slots".  If this child
	 * is already at the end of the child list, this method does nothing.
	 * Attempts to move a child not currently in the child list are ignored.
	 * @param child the child to be moved.
	 */
	public void moveChildLater(VisualElement child);

	/*--------------------------------------------------*/
	/* Layout and Drawing */
	/*--------------------------------------------------*/

	/* . . . . . . . . . . . . . . . . . . . . . . . . . */
	/**
	 * Perform a top-down layout traversal of the VisualElement tree rooted at this
	 * VisualElement. This method should set the position each child object to create
	 * the layout strategy it enforces.
	 */
	public void doLayout();


	/* . . . . . . . . . . . . . . . . . . . . . . . . . */
	/**
	 * Draw this VisualElement and all child VisualElements on the given <code>Canvas</code>
	 * object. All drawing must be clipped to the bounds of this object as well
	 * as the bounds of all ancestor objects, and in general, must respect any
	 * clipping region already established in the <code>Canvas</code> object it
	 * draws on. The local coordinate system for the object will have been
	 * established within the Canvas prior to this call.  That is, the Canvas
	 * transformation will be set so that 0,0 is already where the top-left
	 * corner of this VisualElement will be drawn.
	 * @param onCanvas the <code>Canvas</code> object that drawing is done on.
	 */
	public void draw(Canvas onCanvas);
}
