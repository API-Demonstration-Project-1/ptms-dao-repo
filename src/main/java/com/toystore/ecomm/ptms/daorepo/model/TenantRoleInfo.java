package com.toystore.ecomm.ptms.daorepo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.validation.annotation.Validated;

import com.toystore.ecomm.ptms.daorepo.factory.POJOFactory;

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
@EqualsAndHashCode

@Entity
@Table(name = "TENANT_ROLE")
public class TenantRoleInfo   {

  static {
        POJOFactory.register("TENANTROLEINFO", TenantRoleInfo.class);
  }
  
  @Id
  @Column(name = "ROLE_ID", nullable = false)
  private Integer roleId;
  
  @Column(name = "ROLE_NAME", nullable = false)
  private String roleName;

  @Column(name = "ROLE_DESC", nullable = false)
  private String roleDesc;
}

