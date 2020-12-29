package com.toystore.ecomm.ptms.daorepo.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.validation.annotation.Validated;

import com.toystore.ecomm.ptms.daorepo.factory.POJOFactory;
import com.toystore.ecomm.ptms.daorepo.model.audit.Auditable;
import com.toystore.ecomm.ptms.util.StringAttributeConverter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
@Table(name = "TENANT_DB")
public class TenantDBInfo extends Auditable<String> {

	static {
		POJOFactory.register("TENANTDBINFO", TenantDBInfo.class);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TENANT_DB_ID", nullable = false)
	private Integer tenantDBId;

	@Column(name = "TENANT_ID", nullable = false)
	private Integer tenantId;

	@Column(name = "TENANT_DB_URL", nullable = false)
	private String tenantDBUrl;

	@Column(name = "TENANT_DB_NAME", nullable = false)
	private String tenantDBName;

	@Column(name = "TENANT_DB_USERNAME", nullable = false)
	private String tenantDBUsername;

	@Column(name = "TENANT_DB_PASSWORD", nullable = false)
	@Convert(converter = StringAttributeConverter.class)
	private String tenantDBPassword;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "TENANT_ID", nullable = false, insertable = false, updatable = false)
	private TenantInfo tenantInfo;

}
