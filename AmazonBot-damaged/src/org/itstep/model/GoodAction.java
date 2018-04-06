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
	@GeneratedValue //(strategy = GenerationType.AUTO)
	@Column (name = "action_id")
	private Integer id;
	
	@Column(name = "action_time")
	private Long actionTime;
	
	@Column (name = "action")
	private String action;
	
	@Column (name = "is_added_to_cart")
	private Boolean isAddedToCart;
	
	@ManyToOne (targetEntity = Account.class)
	private Account account;
	
	@ManyToOne (targetEntity = Good.class)
	private Good good;
	
	public GoodAction() {		
	}
	
	public GoodAction(Long actionTime, String action, Boolean isAddedToCart, Account account, Good good) {
		this.actionTime = actionTime;
		this.action = action;
		this.isAddedToCart = isAddedToCart;
		this.account = account;
		this.good = good;
	}
	
}