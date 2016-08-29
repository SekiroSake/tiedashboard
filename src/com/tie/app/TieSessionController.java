
package com.tie.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tie.dao.TiePersister;
import com.tie.model.CbcrTable1;
import com.tie.model.CbcrTable2;
import com.tie.model.TieDoc;
import com.tie.model.TieMsg;
import com.tie.model.TieMsgReceiver;
import com.tie.model.TieMsgState;
import com.tie.model.TieUser;
import com.tie.model.TieTaxEntity;
import com.tie.ui.TieMainPage;

/**
 * @author awang Respond to requests from one user session
 */
public class TieSessionController extends TieControllerBase {

	private String userCode;
	// point to ui class

	// TieMainPage mainPage;
	// TiePersister persister = null;

	// The key to access session controller
	public static String sesssionControllerName = "theSessionController";

	public void init() {

	}

	public TieSessionController() {
		init();
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	/*
	 * public TieMainPage getMainPage() { return mainPage; }
	 * 
	 * public void setMainPage(TieMainPage mainPage) { this.mainPage = mainPage;
	 * }
	 */

	// populate the mainPage's every object
	// get the persister first
	// from the persister get the Dao and invoke method insides it to populate
	/* over to mainPage */
	// everything in one time
	public void handleLogin(String username) {
		TiePersister persister = TieController.getController().getPersister();

		// -------- populate for header pane --------------
		String appName = persister.getTieAppDao().findTieAppById(1).getName();

		// find the id of the user who's login ()
		TieUser user = persister.getTieUserDao().findTieUserByCode(username);
		// System.out.println("User:" + user.toString());
		String userNameOnBoard = user.getName();

		getMainPage().setAppName(appName);
		TieMainPage.getTieMainPage().setAppName(appName);
		TieMainPage.getTieMainPage().setUsername(userNameOnBoard);

		// TODO language and language list

		// ToDo List<TieMsg> TieMsgDao.findMessageBsyOwner( long ownerId )
		// ToDo add findTieMsgById in tieMsgDao
		// msgList = persister.getTieMsgDao().findTieMsgByCode(code);
		// TieMainPage.getTieMainPage().setMsgList(msgList);

		// ------- populate for msg pane --------
		List<TieMsg> msgList = new ArrayList<TieMsg>();
		msgList = persister.getTieMsgDao().findTieMsgByOwnerId(user.getTieUserId());// (user.getTieUserId());
		TieMainPage.getTieMainPage().setMsgList(msgList);

		// TODO
		// ------ populate current msg pane, msg tab -------
		// pick the first msg from msgList as the current msg
		// currentMsg =
		// all current msg attributes are now available to jsp
		TieMsg currentmsg = msgList.get(0);
		// TieMainPage.getTieMainPage().setCurrentMsg(currentmsg);
		TieMainPage.getTieMainPage().setCurrentMsg(currentmsg);
		// Populate sender of the current msg
		int senderId = currentmsg.getSenderId();

		TieUser sender = persister.getTieUserDao().findTieUserById(senderId);
		currentmsg.setSender(sender);
		// Populate receivers of the current msg
		int currentTieMsgId = currentmsg.getTieMsgId();
		List<TieMsgReceiver> tiemsgReceiverList = new ArrayList<TieMsgReceiver>();
		tiemsgReceiverList = persister.getTieMsgReceiverDao().findTieMsgReceiverById(currentTieMsgId);
		TieMainPage.getTieMainPage().setTiemsgReceiverList(tiemsgReceiverList);
		
		//Populate the state of current msg
		TieMsgState tieMsgState = TieMsgState.findById(currentmsg.getTieMsgStateId());
		TieMainPage.getTieMainPage().setTieMsgState(tieMsgState);
		
		// ------ populate current msg pane, doc tab, docs of the currentMsg
		List<TieDoc> tieDocList = new ArrayList<TieDoc>();
		tieDocList = persister.getTieDocDao().findTieDocByTieMsgId(currentTieMsgId);
		currentmsg.setTieDocList(tieDocList);
		
		// populate current doc
		// TODO: Handle current doc situation
		TieDoc currentDoc = tieDocList.get(0);
		TieMainPage.getTieMainPage().setCurrentTieDoc(currentDoc);

		// ------ populate current msg pane, entity tab -------
		int currentDocId = currentDoc.getTieDocId();
		List<TieTaxEntity> taxEntitylist = new ArrayList<TieTaxEntity>();
		taxEntitylist = persister.getTieEntityDao().findTieMsgByTieDocId(currentDocId);
		TieMainPage.getTieMainPage().setTaxEntitylist(taxEntitylist);
				
		// ------ populate current msg pane, table1 tab -------
		List<CbcrTable1> cbcrTable1List = persister.getCbcrTable1Dao().findCbcrTable1ByTieDocId(currentDocId);
		currentDoc.setCbcrTable1List(cbcrTable1List);
		
		// ------ populate current msg pane, table2 tab -------		
		List<CbcrTable2> cbcrTable2List = persister.getCbcrTable2Dao().findCbcrTable2ByTieDocId(currentDocId);
		currentDoc.setCbcrTable2List(cbcrTable2List);
		// ------ populate current msg pane, table3 tab -------

	}

	/**
	 * 
	 * @return The main page for the user session.
	 */
	public TieMainPage getMainPage() {
		TieMainPage retval = null;

		retval = TieMainPage.getTieMainPage();

		return retval;
	}// end getMainPage()

}// end class TieSessionContrller
