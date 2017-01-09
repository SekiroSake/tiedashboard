/**
 * 
 */
/**
 * @author awang
 *
 */
package com.tie.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tie.model.TieMsg;

public class TieMsgDao extends BaseDao {
	public List<TieMsg> findTieMsgByOwnerId(int id) {
		getConnection();
	
		List<TieMsg> msgList = new ArrayList<TieMsg>();
		try {
			TieMsg tieMsg = new TieMsg();;
			String sql = "select * from mx.tiemsg where ownerid = ?";

			PreparedStatement selectStatement = conn.prepareStatement(sql);
			selectStatement.setInt(1, id);
			rs = selectStatement.executeQuery();

			while (rs.next()) {
				int tieMsgId = rs.getInt("tieMsgId");
				String subject = rs.getString("subject");
				String code = rs.getString("code");
				String description = rs.getString("description");
				String notes = rs.getString("notes");
				int senderId = rs.getInt("senderId");
				int ownerid = rs.getInt("ownerid");
				int tieMsgStateId = rs.getInt("tieMsgStateId");
				String sendingEntityIdNum = rs.getString("sendingEntityIdNum");
				String transmittingCountry = rs.getString("transmittingCountry");
				String receivingCountries = rs.getString("receivingCountries");
				String messageType = rs.getString("messageType");
				String lauguage = rs.getString("lauguage");
				String warning = rs.getString("warning");
				String contact = rs.getString("contact");
				String messageRefId = rs.getString("messageRefId");
				String messageTypeIndic = rs.getString("messageTypeIndic");
				String corrMessageRefIds = rs.getString("corrMessageRefIds");
				String reportingPeriod = rs.getString("reportingPeriod");
				String timestamp = rs.getString("timestamp");
				String rawMsg = rs.getString("rawMsg");

				tieMsg = new TieMsg(tieMsgId, subject, code, description, notes, senderId, ownerid, tieMsgStateId,
						sendingEntityIdNum, transmittingCountry, receivingCountries, messageType, lauguage, warning,
						contact, messageRefId, messageTypeIndic, corrMessageRefIds, reportingPeriod, timestamp, rawMsg);
				// tieapp = new TieApp(name,description);
				msgList.add(tieMsg);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			/*
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}*/
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return msgList;
	}
	public TieMsg findTieMsgByTieMsgId(int id) {
		getConnection();
	
		TieMsg msg = new TieMsg();
		try {
			
			String sql = "select * from mx.tiemsg where tiemsgId = ?";

			PreparedStatement selectStatement = conn.prepareStatement(sql);
			selectStatement.setInt(1, id);
			rs = selectStatement.executeQuery();

			while (rs.next()) {
				int tieMsgId = rs.getInt("tieMsgId");
				String subject = rs.getString("subject");
				String code = rs.getString("code");
				String description = rs.getString("description");
				String notes = rs.getString("notes");
				int senderId = rs.getInt("senderId");
				int ownerid = rs.getInt("ownerid");
				int tieMsgStateId = rs.getInt("tieMsgStateId");
				String sendingEntityIdNum = rs.getString("sendingEntityIdNum");
				String transmittingCountry = rs.getString("transmittingCountry");
				String receivingCountries = rs.getString("receivingCountries");
				String messageType = rs.getString("messageType");
				String lauguage = rs.getString("lauguage");
				String warning = rs.getString("warning");
				String contact = rs.getString("contact");
				String messageRefId = rs.getString("messageRefId");
				String messageTypeIndic = rs.getString("messageTypeIndic");
				String corrMessageRefIds = rs.getString("corrMessageRefIds");
				String reportingPeriod = rs.getString("reportingPeriod");
				String timestamp = rs.getString("timestamp");
				String rawMsg = rs.getString("rawMsg");

				msg = new TieMsg(tieMsgId, subject, code, description, notes, senderId, ownerid, tieMsgStateId,
						sendingEntityIdNum, transmittingCountry, receivingCountries, messageType, lauguage, warning,
						contact, messageRefId, messageTypeIndic, corrMessageRefIds, reportingPeriod, timestamp, rawMsg);
				// tieapp = new TieApp(name,description);
				
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			/*
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}*/
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return msg;
	}
	
	public void saveTieMessage(TieMsg tieMsg){
		
		getConnection();
		
	
		try {
			System.out.println("Started to save");
			String sql = "insert into mx.tiemsg values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement saveStatement = conn.prepareStatement(sql);
			saveStatement.setString(1, null);
			saveStatement.setString(2, tieMsg.getSubject());
			saveStatement.setString(3, tieMsg.getCode());
			saveStatement.setString(4, tieMsg.getDescription());
			saveStatement.setString(5, tieMsg.getNotes());
			saveStatement.setInt(6, 3);
			saveStatement.setInt(7, 4);//CD This is hard coded as 4, will change to tieMsg.getOwnerId() later
			saveStatement.setInt(8, 1);
			saveStatement.setString(9, tieMsg.getSendingEntityIdNum());
			saveStatement.setString(10, tieMsg.getTransmittingCountry());
			saveStatement.setString(11, tieMsg.getReceivingCountries());
			saveStatement.setString(12, tieMsg.getMessageType());
			saveStatement.setString(13, tieMsg.getLauguage());
			saveStatement.setString(14, tieMsg.getWarning());
			saveStatement.setString(15, tieMsg.getContact());
			saveStatement.setString(16, tieMsg.getMessageRefId());
			saveStatement.setString(17, tieMsg.getMessageTypeIndic());
			saveStatement.setString(18, tieMsg.getCorrMessageRefIds());
			saveStatement.setString(19, tieMsg.getReportingPeriod());
			saveStatement.setString(20, tieMsg.getTimestamp());
			saveStatement.setString(21, tieMsg.getRawMsg());
	
	
		
			
			saveStatement.executeUpdate();
			System.out.println("Done  save: " + tieMsg);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}