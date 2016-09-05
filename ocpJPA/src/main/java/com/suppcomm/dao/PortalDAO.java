package com.suppcomm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.suppcomm.entity.Portal;
import com.br.suppcomm.entity.PortalLoginVO;



public interface PortalDAO  extends JpaRepository<Portal, Long>{
	public Portal findByPortalId(Long  idPortal);
	public Portal findByPortalNumber(String portalNumber);
	public List<Portal> listAll();
	@Query(value="insert into portal_login  (login_id, portal_id) values(:loginId, :portalId)",nativeQuery=true)
	public void associatePortalLogin(Long portalId, Long loginId);
	
	@Query(value="SELECT " +
        		"    case when P.login_id is null then :loginId else P.login_id end   as loginId ," +
        		"	 portal.portal_id as portalId," +
        		"	 case when  P.portal_id is null then false else true end as checked ," +
        		"	 portal.name            as portalName " +

        		"	FROM portal LEFT JOIN  (SELECT * FROM portal_login WHERE portal_login.login_id = :loginId)  AS P ON (portal.portal_id = P.portal_id) order by portal.name",nativeQuery=true 
)
	public List<PortalLoginVO> listAllByLogin(Long loginId);

	@Query(value = "Delete from portal_login p Where p.login_id  = :loginId ", nativeQuery=true)
	public void removeAllPortalsLogin(@Param("loginId") Long loginId);

}
