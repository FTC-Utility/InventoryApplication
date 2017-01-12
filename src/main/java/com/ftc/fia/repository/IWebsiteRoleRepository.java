package com.ftc.fia.repository;

import com.ftc.fia.domain.EquipmentType;
import com.ftc.fia.domain.WebsiteRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by ABarrero on 1/3/2017.
 */
public interface IWebsiteRoleRepository extends JpaRepository<WebsiteRole, Long> {

  @Query("FROM WebsiteRole w WHERE w.id = :website_role_id")
  WebsiteRole findById(@Param("website_role_id") int website_role_id);

  @Query("FROM WebsiteRole w WHERE w.description = :description")
  WebsiteRole findByType(@Param("description") String description);
}
