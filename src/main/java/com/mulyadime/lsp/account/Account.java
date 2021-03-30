/**
 * 
 */
package com.mulyadime.lsp.account;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * @author hamid.mulyadi
 *
 */
@Data
@Entity
@Table(name = "account_user")
public class Account {
	
	@Id
	@GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
	@GeneratedValue(generator = "UUIDGenerator")
	@Column(name = "pk_account_user", length = 36, nullable = false)
	private String id;
	
	@Column(unique = true, length = 25, nullable = false)
	private String username;
	
	@Column(length = 100, nullable = false)
	private String password;
	
	@Column(length = 15, nullable = false)
	private String role = "ROLE_USER";
	
	@Column(name = "created_at", nullable = false)
	private Instant createdAt;
	
	public Account() {
		super();
	}

	public Account(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role	  = role;
		this.createdAt= Instant.now();
	}

}
