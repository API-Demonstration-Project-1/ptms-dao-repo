package com.toystore.ecomm.ptms.daorepo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.validation.annotation.Validated;

import com.toystore.ecomm.ptms.daorepo.factory.POJOFactory;
import com.toystore.ecomm.ptms.daorepo.model.audit.Auditable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;

/**
 * Registration
 */
@Validated

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)

@Entity
@Table(name = "TENANT")
public class TenantInfo extends Auditable<String> {

	static {
		POJOFactory.register("TENANTINFO", TenantInfo.class);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TENANT_ID", nullable = false, columnDefinition = "BINARY(16)")
	private Integer tenantId;

	@Column(name = "TENANT_NAME", nullable = false)
	private String tenantName;

	@Column(name = "TENANT_EMAIL", nullable = false)
	private String tenantEmail;
	
	@Column(name = "TENANT_MOBILE", nullable = false)
	private String tenantMobile;

	@Column(name = "TENANT_USERNAME", nullable = false)
	private String tenantUsername;

	@Setter(AccessLevel.NONE)
	@Column(name = "TENANT_PASSWORD", nullable = false)
	private String tenantPassword;

	@Column(name = "TENANT_VERIFIED", nullable = false)
	private String tenantVerified;

	@Column(name = "VERIFICATION_ID", nullable = false)
	private String verificationId;

	@Column(name = "ROLE_ID", nullable = false)
	private Integer tenantRoleId;

	@Column(name = "PPMS_CUSTOMER_ID", nullable = true)
	private Integer customerId;

	@OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<SubscriptionInfo> subscriptionInfoList;

	@OneToOne(mappedBy = "tenantInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private TenantDBInfo tenantDBInfo;

	@OneToOne
	@JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID", nullable = false, insertable = false, updatable = false)
	private TenantRoleInfo tenantRoleInfo;

	public void setTenantPassword(String tenantPassword) {
		this.tenantPassword = BCrypt.hashpw(tenantPassword, BCrypt.gensalt());
	}

}
