package com.tie.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tie.model.TieMsg;
import com.tie.model.taxEntity;

public class TieEntityDao extends BaseDao {
	public List<taxEntity> findTieMsgByTieDocId(int id) {
		getConnection();

		List<taxEntity> taxEntityList = new ArrayList<taxEntity>();
		try {
			taxEntity taxentity = new taxEntity();
			
			String sql = "select * from mx.taxentity where tieDocId = ? order by taxIdNum";

			PreparedStatement selectStatement = conn.prepareStatement(sql);
			selectStatement.setInt(1, id);
			rs = selectStatement.executeQuery();

			while (rs.next()) {
				int tieDocId = rs.getInt("tieDocId");
				String entityCode = rs.getString("entityCode");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String taxIdNum = rs.getString("taxIdNum");
				
				String incorpCountryCode = rs.getString("incorpCountryCode");
				String otherEntityInfo = rs.getString("otherEntityInfo");
				String resCountryCode = rs.getString("resCountryCode");
				String idNum = rs.getString("idNum");
				int isPermExtabliment = rs.getInt("isPermExtabliment");
				String addrLegalType = rs.getString("addrLegalType");
				String addrCountryCode = rs.getString("addrCountryCode");
				String addrFreeText = rs.getString("addrFreeText");
				String addrStreet = rs.getString("addrStreet");
				String addrBuildingIdentifier = rs.getString("addrBuildingIdentifier");
				String addrSuiteIdentifier = rs.getString("addrSuiteIdentifier");
				String addrFloorIdentifier = rs.getString("addrFloorIdentifier");
				String addrPOB = rs.getString("addrPOB");

				taxentity = new taxEntity(tieDocId, entityCode, name, description, taxIdNum, incorpCountryCode, otherEntityInfo, resCountryCode,
						idNum, isPermExtabliment, addrLegalType, addrCountryCode, addrFreeText, addrStreet,
						addrBuildingIdentifier, addrSuiteIdentifier, addrFloorIdentifier, addrPOB);
				// tieapp = new TieApp(name,description);
				taxEntityList.add(taxentity);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			/*
			 * if (conn != null) { try { conn.close(); } catch (SQLException e)
			 * { e.printStackTrace(); } }
			 */
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

		return taxEntityList;
	}
}
