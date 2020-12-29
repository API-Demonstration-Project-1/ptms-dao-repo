package com.toystore.ecomm.ptms.daorepo.model;

import org.springframework.validation.annotation.Validated;

import com.toystore.ecomm.ptms.daorepo.factory.POJOFactory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Subscription
 */
@Validated

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
@Table(name = "SUBSCRIPTION_TYPE")
public class SubscriptionTypeInfo {
	
	static {
        POJOFactory.register("SUBSCRIPTIONTYPEINFO", SubscriptionTypeInfo.class);
    }

	@Id
	@Column(name = "PLAN_TYPE_ID", nullable = false)
	private Integer planTypeId;

	@Column(name = "PLAN_NAME", nullable = false)
	private String planName;

	@Column(name = "PRICING", nullable = false)
	private String pricing;
}
