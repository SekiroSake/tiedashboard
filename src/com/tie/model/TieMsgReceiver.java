package com.tie.model;

public class TieMsgReceiver {
	private int tieMsgId;
	private String senderCode;
	private String receiverCode;
	private String tieMsgTrackingStatusId;
	private String trackingNote;
	private String receivingCountry;

	public TieMsgReceiver() {
		// super();
	}

	public TieMsgReceiver(int tieMsgId, String senderCode, String receiverCode, String tieMsgTrackingStatusId,
			String trackingNote, String receivingCountry) {
		super();
		this.tieMsgId = tieMsgId;
		this.senderCode = senderCode;
		this.receiverCode = receiverCode;
		this.tieMsgTrackingStatusId = tieMsgTrackingStatusId;
		this.trackingNote = trackingNote;
		this.receivingCountry = receivingCountry;
	}

	public int getTieMsgId() {
		return tieMsgId;
	}

	public void setTieMsgId(int tieMsgId) {
		this.tieMsgId = tieMsgId;
	}

	public String getSenderCode() {
		return senderCode;
	}

	public void setSenderCode(String senderCode) {
		this.senderCode = senderCode;
	}

	public String getReceiverCode() {
		return receiverCode;
	}

	public void setReceiverCode(String receiverCode) {
		this.receiverCode = receiverCode;
	}

	public String getTieMsgTrackingStatusId() {
		return tieMsgTrackingStatusId;
	}

	public void setTieMsgTrackingStatusId(String tieMsgTrackingStatusId) {
		this.tieMsgTrackingStatusId = tieMsgTrackingStatusId;
	}

	public String getTrackingNote() {
		return trackingNote;
	}

	public void setTrackingNote(String trackingNote) {
		this.trackingNote = trackingNote;
	}

	public String getReceivingCountry() {
		return receivingCountry;
	}

	public void setReceivingCountry(String receivingCountry) {
		this.receivingCountry = receivingCountry;
	}

	@Override
	public String toString() {
		return "TieMsgReceiver [tieMsgId=" + tieMsgId + ", senderCode=" + senderCode + ", receiverCode=" + receiverCode
				+ ", tieMsgTrackingStatusId=" + tieMsgTrackingStatusId + ", trackingNote=" + trackingNote
				+ ", receivingCountry=" + receivingCountry + "]";
	}

}