package com.mikeriv.ssui_2016.a3gameengine.fsm;

import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.Button;

import com.mikeriv.ssui_2016.a3gameengine.XMLtag;
import com.mikeriv.ssui_2016.a3gameengine.action.ChangeImageAction;
import com.mikeriv.ssui_2016.a3gameengine.action.DebugAction;
import com.mikeriv.ssui_2016.a3gameengine.action.DropDragFocusAction;
import com.mikeriv.ssui_2016.a3gameengine.action.FSMAction;
import com.mikeriv.ssui_2016.a3gameengine.action.FSMActionType;
import com.mikeriv.ssui_2016.a3gameengine.action.FollowEventAction;
import com.mikeriv.ssui_2016.a3gameengine.action.GetDragFocusAction;
import com.mikeriv.ssui_2016.a3gameengine.action.MoveIncAction;
import com.mikeriv.ssui_2016.a3gameengine.action.MoveToAction;
import com.mikeriv.ssui_2016.a3gameengine.action.RunAnimAction;
import com.mikeriv.ssui_2016.a3gameengine.action.SendMessageAction;
import com.mikeriv.ssui_2016.a3gameengine.character.GameCharacter;
import com.mikeriv.ssui_2016.a3gameengine.character.GameCharacterBase;
import com.mikeriv.ssui_2016.a3gameengine.character.GameCharacterPreBase;
import com.mikeriv.ssui_2016.a3gameengine.engine.GameEnginePreBase;
import com.mikeriv.ssui_2016.a3gameengine.event.FSMEventType;
import com.mikeriv.ssui_2016.a3gameengine.eventmatch.ButtonMatch;
import com.mikeriv.ssui_2016.a3gameengine.eventmatch.FSMEventMatcher;
import com.mikeriv.ssui_2016.a3gameengine.eventmatch.MessageMatch;
import com.mikeriv.ssui_2016.a3gameengine.eventmatch.TypeMatch;

public class FSMxmlTranslator {
	
	/**
	 * Safely extract a float valued attribute from the given element, returning
	 * a default value if the attribute is missing.
	 * @param e Element we are getting the attribute value from
	 * @param attr String indicating the name of the attribute we want
	 * @param defaultVal Default value returned if there is no such attribute
	 * @return
	 */
	public static float getFloatAttr(Element e, String attr, float defaultVal) {
		// if we don't actually have an element bail with the default
		if (e == null) return defaultVal;
		// get the attribute value as a string and bail if it wasn't there
		String strVal = e.getAttribute(attr);
		if (strVal =="") return defaultVal;
		// return the corresponding float (or the default value if its bad)
		try {
		return Float.parseFloat(strVal);
		} catch (NumberFormatException ex) {
			return defaultVal;
		}
	}
	
	/**
	 * Safely extract an int valued attribute from the given element, returning
	 * a default value if the attribute is missing.
	 * @param e Element we are getting the attribute value from
	 * @param attr String indicating the name of the attribute we want
	 * @param defaultVal Default value returned if there is no such attribute
	 * @return
	 */
	public static int getIntAttr(Element e, String attr, int defaultVal) {
		// if we don't actually have an element bail with the default
		if (e == null) return defaultVal;
		// get the attribute value as a string and bail if it wasn't there
		String strVal = e.getAttribute(attr);
		if (strVal =="") return defaultVal;
		// return the corresponding float (or the default value if its bad)
		try {
		return Integer.parseInt(strVal);
		} catch (NumberFormatException ex) {
			return defaultVal;
		}
	}
	
	/**
	 * Safely extract an index from a string valued attribute of the 
	 * given element, returning -1 if the attribute does not name an object
	 * in the provided dictionary
	 * 
	 * @param e Element we are getting the attribute value from
	 * @param attr String indicating the name of the attribute we want
	 * @param dict a HashMap<String,Integer> which maps 
	 *                      character names to character indexes
	 * @return
	 */
	public static int getNameToIDAttr(
			Element e, 
			String attr, 
			HashMap<String, Integer> dict) 
	{
		// if we don't actually have an element bail with the default
		if (e == null) return -1;
		// get the attribute value as a string and bail if it wasn't there
		String strVal = e.getAttribute(attr);
		if (strVal =="") return -1;
	    // look up the item by name
		Integer ch = dict.get(e.getAttribute(attr));
		// return the index if it's there or the default otherwise
		if (ch == null) 
			return -1;
		else
			return ch;
	}
	

	/**
	 * Extract an array of buttons from the passed in XML element
	 * 
	 * @param docEle the element from which the buttons are extracted
	 * @param engine the game engine which the buttons belong to
	 * @param ctx application context
	 * @return array of button objects created from the XML
	 */
	public static Button[] getButtonsFromXML(Element docEle, GameEnginePreBase engine, Context ctx){

		//get a nodelist of elements
		NodeList nl = docEle.getElementsByTagName(XMLtag.BUTTON);

		Button[] buttons = null;	
		HashMap<String, Integer> buttonDict = new HashMap<String, Integer>();


		if(nl != null && nl.getLength() > 0) {
			buttons = new Button[nl.getLength()];	
			for(int i = 0 ; i < nl.getLength();i++) {

				//get the character element
				Element el = (Element)nl.item(i);

				String name = el.getAttribute(XMLtag.NAME_ATTR);

				//Log.d("ssui", "button name:" + name);
				buttons[i] = new Button(ctx);
				buttons[i].setText(name);
				if(buttonDict.put(name, buttonDict.size()) != null)
					Log.d("ssui", "Button names are not unique");
			}
		}
		else
			buttons = new Button[0];

		engine.mButtons = buttons;
		engine.mButtonDict = buttonDict;

		return buttons;

	}


	/**
	 * Extract an array of characters from the passed in XML element
	 * 
	 * @param docEle the element from which the characters are extracted
	 * @param engine the game engine which the characters belong to
	 * @param ctx application context
	 * @return array of GameCharacter objects created from the XML
	 */
	public static GameCharacter[] getCharactersFromXML(Element docEle, GameEnginePreBase engine, Context ctx){

		//get a nodelist of elements
		NodeList nl = docEle.getElementsByTagName(XMLtag.CHARACTER);

		GameCharacterPreBase[] characters = null;
		if(nl != null && nl.getLength() > 0) {
			characters = new GameCharacterPreBase[nl.getLength()];
			
			HashMap<String, Integer> characterDict = new HashMap<String, Integer>();
			
			for(int i = 0 ; i < nl.getLength();i++) {
				//get the character element
				Element el = (Element)nl.item(i);
				if(characterDict.put(el.getAttribute(XMLtag.NAME_ATTR), i) != null)
					Log.d("ssui", "Character names not unique");
			}
			
			for(int i = 0 ; i < nl.getLength();i++) {

				//get the character element
				Element el = (Element)nl.item(i);

				FSMState[] states = getStatesFromXML(el, characterDict, engine, ctx);

				Bitmap bmp = getBitmapFromIdentifier(el.getAttribute(XMLtag.INITBMP_ATTR), ctx);

				int x = getIntAttr(el, XMLtag.INITX_ATTR, 0);
				int y = getIntAttr(el, XMLtag.INITY_ATTR, 0);
				int w = getIntAttr(el, XMLtag.INITW_ATTR, 0);
				int h = getIntAttr(el, XMLtag.INITH_ATTR, 0);

				GameCharacterPreBase c = 
					new GameCharacterBase(engine,i, x,y,w,h,states, bmp);

				characters[i] = c;
			}
		}
		else
			characters = new GameCharacterPreBase[0];

		return characters;
	}

	/**
	 * Returns the Bitmap for the drawable specified by "attribute"
	 * 
	 * @param attribute the string identifier of the drawable
	 * @param ctx the context of the application that contains this drawable
	 * @return the Bitmap of the specified drawable
	 */
	private static Bitmap getBitmapFromIdentifier(String attribute, Context ctx) {
		int id = ctx.getResources().getIdentifier(attribute, "drawable", ctx.getPackageName());
		return BitmapFactory.decodeResource(ctx.getResources(), id);
	}


	/**
	 * Extract an array of states from the passed in XML element
	 * 
	 * @param docEle the element from which the states are extracted
	 * @param characterDict mapping from character names to id
	 * @param engine the game engine which the states belong to
	 * @param ctx application context
	 * @return array of FSMState objects created from the XML
	 */
	public static FSMState[] getStatesFromXML(Element docEle, HashMap<String, Integer> characterDict, GameEnginePreBase engine, Context ctx){

		//get a nodelist of elements
		NodeList nl = docEle.getElementsByTagName(XMLtag.STATE);
		HashMap<String, Integer> stateDict = new HashMap<String, Integer>();

		FSMState[] states = null;
		if(nl != null && nl.getLength() > 0) {
			states = new FSMState[nl.getLength()];
			for(int i = 0 ; i < nl.getLength();i++) {

				//get the character element
				Element el = (Element)nl.item(i);
				if(stateDict.put(el.getAttribute(XMLtag.NAME_ATTR), i) != null)
					Log.d("ssui", "State names are not unique");
			}
			for(int i = 0 ; i < nl.getLength();i++) {

				//get the character element
				Element el = (Element)nl.item(i);

				FSMTransition[] trans = getTransitionsFromXML(el, stateDict, characterDict, engine, ctx);
				states[i] = new FSMState(i, el.getAttribute(XMLtag.NAME_ATTR), trans);
			}
		}
		else
			states = new FSMState[0];

		Log.d("ssui", "num_states:" + states.length);
		return states;
	}


	/**
	 * Extract an array of transitions from the passed in XML element
	 * 
	 * @param docEle the element from which the transitions are extracted
	 * @param stateDict mapping from state names to id numbers
	 * @param characterDict mapping from character names to id numbers
	 * @param engine the game engine which the transitions belong to
	 * @param ctx application context
	 * @return array of FSMTransition objects created from the XML
	 */
	public static FSMTransition[] getTransitionsFromXML(Element docEle, HashMap<String, Integer> stateDict, HashMap<String, Integer> characterDict, GameEnginePreBase engine, Context ctx){
		//get a nodelist of elements
		//ArrayList<FSMTransition> transitions = new ArrayList<FSMTransition>();

		NodeList nl = docEle.getElementsByTagName(XMLtag.TRANSITION);

		FSMTransition[] transitions = null;

		if(nl != null && nl.getLength() > 0) {
			transitions = new FSMTransition[nl.getLength()];
			for(int i = 0 ; i < nl.getLength();i++) {

				//get the character element
				Element el = (Element)nl.item(i);

				FSMEventMatcher em = getEventMatcherFromXML(el, engine);
				FSMAction[] a = getActionsFromXML(el, characterDict, ctx);
				int dest = getNameToIDAttr(el, XMLtag.TARGET_STATE_ATTR, stateDict);

				transitions[i] = new FSMTransition(em, a, dest);
			}
		}
		else
			transitions = new FSMTransition[0];

		return transitions;
	}


	/**
	 * Extract an FSMEventMatcher from the passed in XML element
	 * 
	 * @param docEle the element from which the event matcher is extracted
	 * @param engine the game engine which the matcher belongs to
	 * @return FSMEventMatcher object created from the XML
	 */
	public static FSMEventMatcher getEventMatcherFromXML(Element docEle, GameEnginePreBase engine){
		NodeList nl = docEle.getElementsByTagName(XMLtag.EVENT_MATCHER);

		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);


			if(FSMEventType.indexFromName(el.getAttribute(XMLtag.TYPE_ATTR)) == FSMEventType.BUTTON_PRESSED){
				return new ButtonMatch(engine.getButtonIDFromName(el.getAttribute(XMLtag.BUTTONNAME_ATTR)));
			}
			else if(FSMEventType.indexFromName(el.getAttribute(XMLtag.TYPE_ATTR)) == FSMEventType.MESSAGE_ARRIVED){
				return new MessageMatch(el.getAttribute(XMLtag.MESSAGE_ATTR));
			}
			return new TypeMatch(FSMEventType.indexFromName(el.getAttribute(XMLtag.TYPE_ATTR)));
		}

		else
			return null;
	}


	/**
	 * Extract an array of actions from the passed in XML element
	 * 
	 * @param docEle the element from which the transitions are extracted
	 * @param characterDict mapping from character names to id numbers
	 * @param ctx application context
	 * @return array of FSMAction objects created from the XML
	 */
	public static FSMAction[] getActionsFromXML(Element docEle, HashMap<String, Integer> characterDict, Context ctx){
		NodeList nl = docEle.getElementsByTagName(XMLtag.ACTION);

		FSMAction[] actions = null;

		if(nl != null && nl.getLength() > 0) {
			actions = new FSMAction[nl.getLength()];
			for(int i = 0 ; i < nl.getLength();i++) {
				Element el = (Element)nl.item(i);

				int type = FSMActionType.indexFromName(el.getAttribute(XMLtag.TYPE_ATTR));

				switch(type){
				case FSMActionType.MOVE_INC:
					actions[i] = new MoveIncAction(
							getFloatAttr(el,XMLtag.TARGET_OFFSET_X_ATTR,0.0f), 
							getFloatAttr(el,XMLtag.TARGET_OFFSET_Y_ATTR, 0.0f));
					break;
				case FSMActionType.CHANGE_IMAGE:
					actions[i] = new ChangeImageAction(getBitmapFromIdentifier(el.getAttribute(XMLtag.BMP_ATTR), ctx));
					break;
				case FSMActionType.MOVE_TO:
					actions[i] = new MoveToAction(
						getFloatAttr(el, XMLtag.TARGET_ABSOLUTE_X_ATTR, 0.0f), 
						getFloatAttr(el, XMLtag.TARGET_ABSOLUTE_Y_ATTR, 0.0f));
					break;
				case FSMActionType.DEBUG_MESSAGE:
					actions[i] = new DebugAction(el.getAttribute(XMLtag.MESSAGE_ATTR));
					break;
				case FSMActionType.RUN_ANIM:
					actions[i] =  new RunAnimAction(
					getNameToIDAttr(el,XMLtag.MOVING_CHARACTER_NAME_ATTR,characterDict), 
					getNameToIDAttr(el,XMLtag.TARGET_CHARACTER_NAME_ATTR,characterDict),  
					getIntAttr(el,XMLtag.DURATION_ATTR, 0),  
					getFloatAttr(el,XMLtag.TARGET_OFFSET_X_ATTR, 0.0f), 
					getFloatAttr(el,XMLtag.TARGET_OFFSET_Y_ATTR, 0.0f), 
					el.getAttribute(XMLtag.END_MESSAGE_ATTR), 
					el.getAttribute(XMLtag.PASS_OVER_MESSAGE_ATTR));
					break;
				case FSMActionType.FOLLOW_EVENT_POSITION:
					actions[i] = new FollowEventAction();
					break;
				case FSMActionType.GET_DRAG_FOCUS:
					actions[i] = new GetDragFocusAction();
					break;
				case FSMActionType.DROP_DRAG_FOCUS:
					actions[i] = new DropDragFocusAction();
					break;
				case FSMActionType.SEND_MESSAGE:
					actions[i] = new SendMessageAction(
							getNameToIDAttr(el,XMLtag.TARGET_CHARACTER_NAME_ATTR,characterDict),
							el.getAttribute(XMLtag.MESSAGE_ATTR));
					break;
				default:
					//This is an error!  xx
					break;
				}
			}
			return actions;
		}
		return new FSMAction[0];
	}


	/**
	 * Parses the XML file specified by xmlFileResourceID, configuring the
	 * game engine with the buttons and returning the Character array.
	 * 
	 * @param xmlFileResourceID the R.raw ID for the xml file to be parsed
	 * @param engine the game engine which the xml file belong to
	 * @param ctx application context
	 * @return array of GameCharacter objects created from the XML
	 */
	public static GameCharacter[] parseXML(int xmlFileResourceID, GameEnginePreBase engine, Context ctx){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		Document dom = null;

		try {

			//Using factory get an instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();

			//parse using builder to get DOM representation of the XML file
			dom = db.parse(ctx.getResources().openRawResource(xmlFileResourceID));


		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}

		if(dom == null){
			engine.mButtons = new Button[0];
			return new GameCharacter[0];
		}
			
		getButtonsFromXML(dom.getDocumentElement(), engine, ctx);
		return getCharactersFromXML(dom.getDocumentElement(), engine, ctx);
	}


}
