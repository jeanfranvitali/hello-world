package com.jfvi.myapp.helloworld.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_message")
@SequenceGenerator(name="message_id_seq",
sequenceName="message_id_seq",allocationSize=1)
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="message_id_seq")
	private Integer id;

	private String content;

	@Column(name="msg_date")
	@Temporal(TemporalType.DATE)
	private Date date;

	private Boolean important;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="usr_id")
	private User userBean;

	public Message() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getImportant() {
		return this.important;
	}

	public void setImportant(Boolean important) {
		this.important = important;
	}

	public User getUserBean() {
		return this.userBean;
	}

	public void setUserBean(User userBean) {
		this.userBean = userBean;
	}

}