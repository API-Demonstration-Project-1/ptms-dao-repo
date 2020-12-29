package com.toystore.ecomm.ptms.daorepo.repository;

public interface TenantRepositoryCustom {
	public void createDbSchemaNTables(String newDbName);
	public void dropDbSchema(String existingDbName);
}
