package com.toystore.ecomm.ptms.daorepo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.validation.annotation.Validated;

import com.toystore.ecomm.ptms.daorepo.factory.POJOFactory;
import com.toystore.ecomm.ptms.daorepo.model.audit.Auditable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Subscription
 */
@Validated

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode (callSuper = false)

@Entity
@Table(name = "SUBSCRIPTION")
public class SubscriptionInfo extends Auditable<String> {
	
	static {
        POJOFactory.register("SUBSCRIPTIONINFO", SubscriptionInfo.class);
    }

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SUBSCRIPTION_ID", nullable = false)
	private Integer subscriptionId;

	@Column(name = "TENANT_ID", nullable = false)
	private Integer tenantId;

	@Column(name = "PLAN_TYPE_ID", nullable = false)
	private Integer planTypeId;

	@ManyToOne
	@JoinColumn(name = "PLAN_TYPE_ID", insertable = false, updatable = false)
	private SubscriptionTypeInfo planType;

	@ManyToOne
	@JoinColumn(name = "TENANT_ID", nullable = false, insertable = false, updatable = false)
	private TenantInfo tenant;

	@Column(name = "RENEWAL_TYPE_ID", nullable = false)
	private Integer renewalTypeId;

	@OneToOne
	@JoinColumn(name = "RENEWAL_TYPE_ID", insertable = false, updatable = false)
	private RenewalTypeInfo renewalType;

	@Column(name = "START_DATE", nullable = false)
	private Date startDate;

	@Column(name = "END_DATE", nullable = false)
	private Date endDate;

	@Column(name = "VALID", nullable = false)
	private String isValid;
}
