package com.nang.model;

public class Appointment {
	private int did;
	private int cid;
	private int sid;
	public Appointment() {}
	public Appointment(int did, int cid, int sid, int pid, String date, String time) {
		super();
		this.did = did;
		this.cid = cid;
		this.sid = sid;
		this.pid = pid;
		this.date = date;
		this.time = time;
	}
	private int pid;
	private String date;
	private String time;
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

}
