package org.itstep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "good_actions")
public class GoodAction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "action_id")
	private Integer id;
	
	@Column (name = "description", length = 2000, nullable = true)
	private String description;
	
	@Column (name = "time_action")
	private Long timeAction;
	
	@ManyToOne (targetEntity = Account.class)
	private Account account;
	
	@ManyToOne (targetEntity = Good.class)
	private Good good;
	
	public GoodAction() { }
	public GoodAction(Integer id, String description, Long timeAction, Account account, Good good) {		
		this.id = id;
		this.description = description;
		this.timeAction = timeAction;
		this.account = account;
		this.good = good;
	}
	
}