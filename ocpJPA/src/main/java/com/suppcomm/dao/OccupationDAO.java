package com.suppcomm.dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.suppcomm.entity.Ivr;
import com.br.suppcomm.entity.Occupation;
import com.br.suppcomm.entity.PieChartOccupationPortalVO;
import com.br.suppcomm.entity.PieChartOccupationSiteVO;
import com.br.suppcomm.entity.PieChartOccupationTotalVO;
import com.br.suppcomm.entity.Portal;
import com.br.suppcomm.entity.Site;



public interface OccupationDAO extends JpaRepository<Occupation, Long> {
	@Query(name= "occupationReleaseAll")
	public void releaseAll(@Param("ivr") Ivr ivr, @Param ("hangupStatus") String hangupStatus, @Param("datetimeHangup") Timestamp datetimeHangup);

	public Occupation findByMsisdn(String msisdn);
	
	public Occupation findByCallId(String callId);
	
	@Query(name="occupationTotalByLogin")
	public PieChartOccupationTotalVO totalOccupationByLogged(@Param("login_id") Long loginId);
	
	public List<PieChartOccupationPortalVO> portalOccupationByLogged(String order);
	
	
	public List<PieChartOccupationPortalVO>  occupationPortalsByLoginOrderName(String order);
	
	public List<PieChartOccupationPortalVO>  occupationPortalsByLoginOrderUsed(String order);
	
	
	public List<Occupation> listByIvr(Ivr ivr);
	
	public List<PieChartOccupationSiteVO> portalOccupationSiteByLogged();
	
	public PieChartOccupationSiteVO portalOccupationSiteByLogged(Site site);
	
	public List<PieChartOccupationPortalVO> portalSiteOccupationByLogged(Site site);
	
	@Query(name="occupationReleaseAllLastMinute")
	void releaseAllLastMinute(@Param("ivr") Ivr ivr, @Param("minute") int minute, @Param("hangupStatus")  String hangupStatus ,@Param("datetimeIncall")  Timestamp datetimeIncall, @Param("datetimeHangup") Timestamp datetimeHangup);
	
	public List<Occupation> listByPortal(Portal portal);
	
	@Query(name="occupationReleaseAllByPortal")
	void releaseAllByPortal(@Param("hangupStatus") String hangupStatus, @Param("portal") Portal portal,@Param("datetimeHangup") Timestamp datetimeHangup);
	
	
	public Occupation findBymsisdn(String msisdn);
	
	public Occupation findBycallId(String callId);
	
	
	@Query(name="occupationSitesByLogin")
	public List<PieChartOccupationSiteVO> portalOccupationSiteByLogged(@Param("login_id") Long login);
	
	@Query(name="occupationOriginateMsisdnByLogin")
	public List<PieChartOccupationSiteVO> portalOccupationUFByLogged(@Param("login_id") Long login);
}
