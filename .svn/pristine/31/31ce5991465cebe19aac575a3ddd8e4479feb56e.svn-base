/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.bulletin.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.constant.QuartzJobName;
import com.icinfo.cs.base.model.CodeCertype;
import com.icinfo.cs.base.service.ICodeCertypeService;
import com.icinfo.cs.base.service.ICsQuartzJobService;
import com.icinfo.cs.bulletin.dto.PubAnnounceMentDto;
import com.icinfo.cs.bulletin.mapper.PubAnnounceMentMapper;
import com.icinfo.cs.bulletin.model.PubAnnounceMent;
import com.icinfo.cs.bulletin.service.IPubAnnounceMentService;
import com.icinfo.cs.common.constant.BulletinType;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.SleepUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.drcheck.mapper.PubDeptSctaskMapper;
import com.icinfo.cs.drcheck.mapper.PubScresultMapper;
import com.icinfo.cs.drcheck.mapper.PubSctaskMapper;
import com.icinfo.cs.drcheck.model.PubSctask;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.favorable.model.FavorAbleInfo;
import com.icinfo.cs.favorable.service.IFavorAbleInfoService;
import com.icinfo.cs.nocreditPunish.dto.NoCreditPunishInfoDto;
import com.icinfo.cs.nocreditPunish.mapper.NoCreditPunishInfoMapper;
import com.icinfo.cs.opanomaly.dto.PubOpanoMalyDto;
import com.icinfo.cs.opanomaly.mapper.PubOpaDetailMapper;
import com.icinfo.cs.opanomaly.mapper.PubOpanoMalyMapper;
import com.icinfo.cs.opanomaly.model.PubOpaDetail;
import com.icinfo.cs.opanomaly.model.PubOpanoMaly;
import com.icinfo.cs.opanomaly.service.IPubOpanoMalyService;
import com.icinfo.cs.other.model.PubJusticeInfo;
import com.icinfo.cs.other.service.IPubJusticeInfoService;
import com.icinfo.cs.sccheck.dto.PubScPlanTaskDto;
import com.icinfo.cs.sccheck.mapper.PubScPlanTaskMapper;
import com.icinfo.cs.sccheck.model.PubSccheckItem;
import com.icinfo.cs.sccheck.service.IPubSccheckItemService;
import com.icinfo.cs.secnocreditsup.mapper.ExpSeriousCrimeListMapper;
import com.icinfo.cs.secnocreditsup.model.ExpSeriousCrimeList;
import com.icinfo.cs.secnocreditsup.service.IExpSeriousCrimeListService;
import com.icinfo.cs.simpleesc.dto.ErEscAppinfoDto;
import com.icinfo.cs.simpleesc.mapper.ErEscAppinfoMapper;
import com.icinfo.cs.simpleesc.model.ErEscAppinfo;
import com.icinfo.cs.simpleesc.service.IErEscAppinfoService;
import com.icinfo.cs.yr.dto.PubOtherpunishDto;
import com.icinfo.cs.yr.model.Bulletins;
import com.icinfo.cs.yr.model.PubOtherpunish;
import com.icinfo.cs.yr.service.IBulletinsService;
import com.icinfo.cs.yr.service.IPubOtherpunishService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.core.transaction.annotation.Transaction;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_pub_announcement 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
@Service
public class PubAnnounceMentServiceImpl extends MyBatisServiceSupport implements IPubAnnounceMentService {

	private static final Logger logger = LoggerFactory.getLogger(PubAnnounceMentServiceImpl.class);

	@Autowired
	PubAnnounceMentMapper pubAnnounceMentMapper;
	@Autowired
	IPubJusticeInfoService pubJusticeInfoService;
	@Autowired
	IPubOtherpunishService pubOtherpunishService;
	@Autowired
	private IPubOpanoMalyService pubOpanoMalyService;
	@Autowired
	PubOpanoMalyMapper pubOpanoMalyMapper;
	@Autowired
	PubOpaDetailMapper pubOpaDetailMapper;
	@Autowired
	PubDeptSctaskMapper pubDeptSctaskMapper;
	@Autowired
	PubSctaskMapper pubSctaskMapper;
	@Autowired
	PubScresultMapper pubScresultMapper;
	@Autowired
	IMidBaseInfoService midBaseInfoService;
	@Autowired
	IExpSeriousCrimeListService expSeriousCrimeListService;
	@Autowired
	ExpSeriousCrimeListMapper expSeriousCrimeListMapper;
	@Autowired
	ICodeCertypeService codeCertypeService;
	@Autowired
	ErEscAppinfoMapper erEscAppinfoMapper;
	@Autowired
	ICsQuartzJobService csQuartzJobService;
	@Autowired
	IErEscAppinfoService erEscAppinfoService;
	@Autowired
	IBulletinsService bulletinsService;
	@Autowired
	PubScPlanTaskMapper pubScPlanTaskMapper;
	@Autowired
	IPubSccheckItemService pubScCheckItemService;
	@Autowired
	NoCreditPunishInfoMapper noCreditPunishInfoMapper;
	@Autowired
	IFavorAbleInfoService favorAbleInfoService;
	// 插入公告数据失败的个数
	private int insertFailsTotal = 0;

	/**
	 * 描述：获取信息公示公告列表数据
	 * 
	 * @author yujingwei
	 * @date 2016-10-17
	 * @param request
	 * @return PageResponse
	 * @throws Exception
	 */
	public List<PubAnnounceMent> queryBulletinInfoList(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> searchMap = request.getParams();
		return pubAnnounceMentMapper.doGetBulletinInfo(searchMap);
	}

	/**
	 * 描述：通过UID获取公告信息
	 * 
	 * @author yujingwei
	 * @date 2016-10-17
	 * @param uID
	 * @return PubAnnounceMent
	 * @throws Exception
	 */
	public PubAnnounceMent doGetpubAnnounceMentInfo(String UID, String pubType) throws Exception {
		PubAnnounceMent newPubAnnounceMent = new PubAnnounceMent();
		newPubAnnounceMent.setLinkUID(UID);
		if (pubType != null) {
			newPubAnnounceMent.setPubType(pubType);
		}
		return pubAnnounceMentMapper.selectOne(newPubAnnounceMent);
	}

	/**
	 * 描述：根据公告类型返回不同的视图
	 * 
	 * @author yujingwei
	 * @date 2016-10-17
	 * @param request
	 * @return PageResponse
	 * @throws Exception
	 */
	public ModelAndView doGetViewByPubType(String relatedID, String pubType, ModelAndView view, String entName)
			throws Exception {

		// 1.司法协助(股权冻结，股权变更)
		if (pubType.equals(BulletinType.JusticeInfoAlter.getCode())
				|| pubType.equals(BulletinType.JusticeInfoFroz.getCode())) {
			view.setViewName("pub/infobulletin/justice");
			PubJusticeInfo pubJusticeInfo = pubJusticeInfoService.doGetPubJusticeInfoForPub(relatedID);
			List<CodeCertype> codeCertypeList = codeCertypeService.selectAll();
			view.addObject("codeCertypeList", codeCertypeList);
			view.addObject("pubJusticeInfo", pubJusticeInfo);
		}

		// 2.行政处罚公告
		if (pubType.equals(BulletinType.PunishInfo.getCode())) {
			view.setViewName("pub/infobulletin/punish");
			PubOtherpunishDto pubOtherpunish = pubOtherpunishService.doGetOtherPunishInfo(relatedID);
			view.addObject("pubOtherpunish", pubOtherpunish);
		}

		// 3.列入列出经营异常名录、期满三年提醒公告
		if (pubType.equals(BulletinType.AnomalyIn.getCode()) || pubType.equals(BulletinType.AnomalyRemind.getCode())) {
			view.setViewName("/pub/infobulletin/anomalydetail");
			PubOpanoMaly newPubOpanoMaly = new PubOpanoMaly();
			newPubOpanoMaly.setBusExcList(relatedID);
			PubOpanoMaly pubOpanoMaly = pubOpanoMalyMapper.selectOne(newPubOpanoMaly);
			view.addObject("pubOpanoMaly", pubOpanoMaly);
			if (pubOpanoMaly.getAbnTime() != null) {
				view.addObject("abnTime3", DateUtil.addYears(pubOpanoMaly.getAbnTime(), 3));
			}
			if (pubType.equals(BulletinType.AnomalyRemind.getCode())) {
				view.addObject("pubAnnounceMent",
						doGetpubAnnounceMentInfo(relatedID, BulletinType.AnomalyRemind.getCode()));
			}
		}
		if (pubType.equals(BulletinType.AnomalyOut.getCode())) {
			view.setViewName("/pub/infobulletin/anomalydetail");
			PubOpaDetail newPubOpaDetail = new PubOpaDetail();
			newPubOpaDetail.setBusExcList(relatedID);
			PubOpaDetail pubOpaDetail = pubOpaDetailMapper.selectOne(newPubOpaDetail);
			view.addObject("pubOpaDetail", pubOpaDetail);
			PubOpanoMaly pubOpanoMalyout = pubOpanoMalyService.selectPubOpanoMalyByBusExcList(relatedID);
			view.addObject("pubOpanoMalyout", pubOpanoMalyout);
			view.addObject("pubOpaDetail", pubOpaDetail);
		}

		// 4.抽查检查公告
		if (pubType.equals(BulletinType.SpotBulletin.getCode()) || pubType.equals(BulletinType.CheckBulletin.getCode())
				|| pubType.equals(BulletinType.SpotTaskBulletin.getCode())) {
			view.setViewName("/pub/infobulletin/spotcheck");
			if (pubType.equals(BulletinType.SpotTaskBulletin.getCode())) {
				List<PubScPlanTaskDto> dtos = pubScPlanTaskMapper.selectScentTaskForBulletin(relatedID);
				for (PubScPlanTaskDto pubScPlanTaskDto : dtos) {
					List<PubSccheckItem> pubScCheckItemList = pubScCheckItemService
							.selectPubSccheckItemByTaskUid(relatedID);
					String itemNames = "";
					for (PubSccheckItem psi : pubScCheckItemList) {
						if (StringUtils.isEmpty(itemNames)) {
							itemNames = psi.getCheckName();
						} else {
							itemNames += "," + psi.getCheckName();
						}
					}
					pubScPlanTaskDto.setCheckItemName(itemNames);
				}
				view.setViewName("/pub/infobulletin/spottask");
				view.addObject("spotTaskList", dtos);
				view.addObject("innerCode", dtos.get(0).getInnerCode());
			}
			PubAnnounceMent pubAnnounceMent = doGetpubAnnounceMentInfo(relatedID, null);
			view.addObject("pubAnnounceMent", pubAnnounceMent);
		}

		// 5.严重违法列入、列出公告
		if (pubType.equals(BulletinType.IlldisIn.getCode())) {
			view.setViewName("/pub/infobulletin/illdisin");
			ExpSeriousCrimeList expSeriousCrimeList = new ExpSeriousCrimeList();
			expSeriousCrimeList.setUid(relatedID);
			ExpSeriousCrimeList expSeriousCrimeListInfo = expSeriousCrimeListMapper.selectOne(expSeriousCrimeList);
			view.addObject("expSeriousCrimeList", expSeriousCrimeListInfo);
		}

		// 6.简易注销公告
		if (pubType.equals(BulletinType.SimpleLogout.getCode())) {
			view.setViewName("/pub/infobulletin/simpcan");
			ErEscAppinfoDto erEscAppinfo = erEscAppinfoService.getErEscAppinfoByPriPID(relatedID);
			erEscAppinfo.setPriPID(AESEUtil.encodeCorpid(erEscAppinfo.getPriPID()));
			view.addObject("erEscAppinfo", erEscAppinfo);
		}

		// 7.拟吊销营业执照听证公告
		if (pubType.equals(BulletinType.ReadyRevokeLicense.getCode())
				|| pubType.equals(BulletinType.RevokeLicense.getCode())
				|| pubType.equals(BulletinType.RegOrgRevoke.getCode())
				|| pubType.equals(BulletinType.YearCheck.getCode())) {
			Bulletins bulletins = bulletinsService.selectByUID(relatedID);
			view.addObject("Bulletins", bulletins);
			String files = bulletins.getBulData();
			if (files != null && !files.isEmpty()) {
				view.addObject("files", files.split("\\|"));
			}
			view.setViewName("/pub/infobulletin/buldata");
		}

		// 8.失信联合惩戒公告
		if (pubType.equals(BulletinType.NocreditEntPunish.getCode())
				|| pubType.equals(BulletinType.NocreditPeoplePunish.getCode())) {
			Map<String, Object> parms = new HashMap<String, Object>();
			parms.put("batchNo", relatedID);
			parms.put("entName", entName);
			List<NoCreditPunishInfoDto> infoDtos = noCreditPunishInfoMapper.selectAllFullInfoList(parms);
			if (CollectionUtils.isNotEmpty(infoDtos)) {
				view.addObject("noCreditPunishInfo", infoDtos.get(0));
			}
			view.setViewName("/pub/infobulletin/nocreditpunish");
		}
		// 10.良好信息公示公告
		if (pubType.equals(BulletinType.Credit.getCode()) || pubType.equals(BulletinType.Hundred.getCode())
				|| pubType.equals(BulletinType.Wellknown.getCode()) || pubType.equals(BulletinType.Zhiming.getCode())
				|| pubType.equals(BulletinType.Famous.getCode()) || pubType.equals(BulletinType.Demonstration.getCode())
				|| pubType.equals(BulletinType.Growstar.getCode())) {
			view.setViewName("/pub/infobulletin/favor");
			// 查询良好信息
			FavorAbleInfo favorAbleInfo = favorAbleInfoService.selectFavorAbleInfoByUid(relatedID);
			view.addObject("favorAbleInfo", favorAbleInfo);
			if (pubType.equals(BulletinType.Credit.getCode())) {
				view.addObject("title", BulletinType.Credit.getDesc());
			} else if (pubType.equals(BulletinType.Hundred.getCode())) {
				view.addObject("title", BulletinType.Hundred.getDesc());
			} else if (pubType.equals(BulletinType.Wellknown.getCode())) {
				view.addObject("title", BulletinType.Wellknown.getDesc());
			} else if (pubType.equals(BulletinType.Zhiming.getCode())) {
				view.addObject("title", BulletinType.Zhiming.getDesc());
			} else if (pubType.equals(BulletinType.Famous.getCode())) {
				view.addObject("title", BulletinType.Famous.getDesc());
			} else if (pubType.equals(BulletinType.Demonstration.getCode())) {
				view.addObject("title", BulletinType.Demonstration.getDesc());
			} else if (pubType.equals(BulletinType.Growstar.getCode())) {
				view.addObject("title", BulletinType.Growstar.getDesc());
			} else {
				view.addObject("title", "-");
			}

		}
		return view;
	}

	/**
	 * 描述：公告信息数据插入
	 * 
	 * @author yujingwei
	 * @date 2016-10-17
	 * @param request
	 * @return PageResponse
	 * @throws Exception
	 */
	public void doCreatBulletinAllInfo() throws Exception {
		try {
			// 阻塞任务，防止并发访问数据库
			SleepUtil.threadSleep();
			if (csQuartzJobService.checkJobIsExecute(QuartzJobName.BULLETIN_JOB.getJobName())) {
				return;
			}
			csQuartzJobService.insert(QuartzJobName.BULLETIN_JOB.getJobName());
			long time1 = System.currentTimeMillis();
			String updateDate = DateUtil.getNdaylater2(new Date(), -1);

			// a.司法协助公告数据
			List<PubJusticeInfo> pubJusticeInfoList = pubJusticeInfoService.doGetInfoByJusticeType(updateDate);
			int Justicetotal = insertInfoForJustice(pubJusticeInfoList);

			// b.行政处罚公告数据
			List<PubOtherpunish> pubOtherpunishList = pubOtherpunishService.selectOtherPunishForBulletin(updateDate);
			int punishTotal = insertInfoForPunish(pubOtherpunishList);

			// c.经营异常公告数据
			List<PubOpanoMalyDto> pubOpanoMalyList = pubOpanoMalyService.queryPubOpanoMalyListForNotice(updateDate);
			int opanoMalyTotal = insertInfoForPubOpanoMaly(pubOpanoMalyList);

			// d.简易注销公告
			List<ErEscAppinfo> erEscAppinfoList = erEscAppinfoMapper.selectEscAppInfoForBulletin(updateDate);
			int erEscAppinfoTotal = insertInfoForErEscAppinfo(erEscAppinfoList);

			// e.失信联合惩戒公告
			if (noCreditPunishInfoMapper.selectNeedCreateEntBulletinTotal() > 0) {
				noCreditPunishInfoMapper.doInsertAnnounceByNocreditInfo();
			}
			if (noCreditPunishInfoMapper.selectNeedCreateManBulletinTotal() > 0) {
				noCreditPunishInfoMapper.doInsertAnnounceByNocreditManInfo();
			}

			// f.抽查检查公告数据
			List<PubSctask> pubSctaskList = pubSctaskMapper.selectScTaskListForBulletin(updateDate);
			int SoptCheckTotal = insertInfoForSoptCheck(pubSctaskList);

			// g.严重违法失信企业公告
			List<ExpSeriousCrimeList> expSeriousCrimeList = expSeriousCrimeListService
					.selectSeriousCrimeInfoForBulletin(updateDate);
			int expCrimeTotal = insertInfoForCrimeInfo(expSeriousCrimeList);

			// f.企业良好信息
			List<FavorAbleInfo> favorAbleInfoList = favorAbleInfoService.selectFavorAbleInfoForBulletin(updateDate);
			int favorAbleInfoTotal = insertFavorAbleInfo(favorAbleInfoList);

			int count = Justicetotal + punishTotal + opanoMalyTotal + erEscAppinfoTotal + SoptCheckTotal + expCrimeTotal
					+ favorAbleInfoTotal;
			long time2 = System.currentTimeMillis();
			logger.info("-----公告数据生成定时任务结束-----");
			logger.info(
					"耗时" + (time2 - time1) + "ms,一共生成【" + count + "】条数据" + ",其中有【" + insertFailsTotal + "】条数据插入失败！");
		} catch (Exception ex) {
			logger.info("公告定时任务发生异常：{}", ex);
			throw new BusinessException(ex.getCause().getMessage(), ex);
		}
	}

	/**
	 * 描述：良好公示信息插入
	 * 
	 * @author baifangfang
	 * @date 2017年10月17日
	 * @param favorAbleInfoList
	 * @return
	 */
	private int insertFavorAbleInfo(List<FavorAbleInfo> favorAbleInfoList) {
		int total = 0;
		PubAnnounceMent newPubAnnounceMentInfo = new PubAnnounceMent();
		for (FavorAbleInfo favorAbleInfo : favorAbleInfoList) {
			try {
				PubAnnounceMent pubAnnounceMent = new PubAnnounceMent();
				pubAnnounceMent.setLinkUID(favorAbleInfo.getUid());
				pubAnnounceMent.setPriPID(favorAbleInfo.getPriPID());
				pubAnnounceMent.setAuditDate(favorAbleInfo.getRegDate());
				pubAnnounceMent.setEntName(favorAbleInfo.getEntName());
				pubAnnounceMent.setAuditDeptName(favorAbleInfo.getRegDeptCn());
				pubAnnounceMent.setCreateTime(new Date());
				pubAnnounceMent.setLicZone(favorAbleInfo.getLicZone());
				pubAnnounceMent.setYear(favorAbleInfo.getRegYear().toString());
				if ("0".equals(favorAbleInfo.getFavType())) {
					pubAnnounceMent.setPubType(BulletinType.Hundred.getCode());
				} else if ("1".equals(favorAbleInfo.getFavType())) {
					pubAnnounceMent.setPubType(BulletinType.Wellknown.getCode());
				} else if ("2".equals(favorAbleInfo.getFavType())) {
					pubAnnounceMent.setPubType(BulletinType.Zhiming.getCode());
				} else if ("3".equals(favorAbleInfo.getFavType())) {
					pubAnnounceMent.setPubType(BulletinType.Famous.getCode());
				} else if ("4".equals(favorAbleInfo.getFavType())) {
					pubAnnounceMent.setPubType(BulletinType.Credit.getCode());
				} else if ("5".equals(favorAbleInfo.getFavType())) {
					pubAnnounceMent.setPubType(BulletinType.Demonstration.getCode());
				} else {
					pubAnnounceMent.setPubType(BulletinType.Growstar.getCode());
				}
				pubAnnounceMent.setPubTitle(favorAbleInfo.getEntName());

				MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(favorAbleInfo.getPriPID());
				if (midBaseInfo != null && midBaseInfo.getRegOrg() != null) {
					pubAnnounceMent.setAuditArea(midBaseInfo.getRegOrg().substring(0, 4));
				}
				if (favorAbleInfo.getUid() != null) {
					newPubAnnounceMentInfo.setLinkUID(favorAbleInfo.getUid());
					if ("0".equals(favorAbleInfo.getFavType())) {
						newPubAnnounceMentInfo.setPubType(BulletinType.Hundred.getCode());
					} else if ("1".equals(favorAbleInfo.getFavType())) {
						pubAnnounceMent.setPubType(BulletinType.Wellknown.getCode());
					} else if ("2".equals(favorAbleInfo.getFavType())) {
						pubAnnounceMent.setPubType(BulletinType.Zhiming.getCode());
					} else if ("3".equals(favorAbleInfo.getFavType())) {
						pubAnnounceMent.setPubType(BulletinType.Famous.getCode());
					} else if ("4".equals(favorAbleInfo.getFavType())) {
						pubAnnounceMent.setPubType(BulletinType.Credit.getCode());
					} else if ("5".equals(favorAbleInfo.getFavType())) {
						pubAnnounceMent.setPubType(BulletinType.Demonstration.getCode());
					} else {
						pubAnnounceMent.setPubType(BulletinType.Growstar.getCode());
					}
					pubAnnounceMentMapper.delete(newPubAnnounceMentInfo);
				}
				pubAnnounceMentMapper.insert(pubAnnounceMent);
				total++;
			} catch (Exception e) {
				logger.info("公告定时任务发生异常：{}", e);
				insertFailsTotal++;
				continue;
			}
		}
		return total;
	}

	/**
	 * 描述：列入严重违法失信名单数据插入
	 * 
	 * @author yujingwei
	 * @date 2016-10-17
	 * @param pubDeptSctaskList
	 * @return void
	 * @throws Exception
	 */
	private int insertInfoForCrimeInfo(List<ExpSeriousCrimeList> expSeriousCrimeList) throws Exception {
		int total = 0;
		PubAnnounceMent newPubAnnounceMentInfo = new PubAnnounceMent();
		if (CollectionUtils.isNotEmpty(expSeriousCrimeList)) {
			for (ExpSeriousCrimeList expSeriousCrimeListInfo : expSeriousCrimeList) {
				try {
					PubAnnounceMent pubAnnounceMent = new PubAnnounceMent();
					pubAnnounceMent.setLinkUID(expSeriousCrimeListInfo.getUid());
					pubAnnounceMent.setPriPID(expSeriousCrimeListInfo.getPriPID());
					pubAnnounceMent.setAuditDate(expSeriousCrimeListInfo.getAddSecDate());
					pubAnnounceMent.setEntName(expSeriousCrimeListInfo.getEntName());
					pubAnnounceMent.setAuditDeptName(expSeriousCrimeListInfo.getAddSecOrg());
					pubAnnounceMent.setCreateTime(new Date());
					pubAnnounceMent.setPubType(BulletinType.IlldisIn.getCode());
					pubAnnounceMent
							.setPubTitle("关于" + expSeriousCrimeListInfo.getEntName() + BulletinType.IlldisIn.getDesc());
					MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(expSeriousCrimeListInfo.getPriPID());
					if (midBaseInfo != null && midBaseInfo.getRegOrg() != null) {
						pubAnnounceMent.setAuditArea(midBaseInfo.getRegOrg().substring(0, 4));
					}
					if (expSeriousCrimeListInfo.getUid() != null) {
						newPubAnnounceMentInfo.setLinkUID(expSeriousCrimeListInfo.getUid());
						newPubAnnounceMentInfo.setPubType(BulletinType.IlldisIn.getCode());
						pubAnnounceMentMapper.delete(newPubAnnounceMentInfo);
					}
					pubAnnounceMentMapper.insert(pubAnnounceMent);
					total++;
				} catch (Exception e) {
					logger.info("公告定时任务发生异常：{}", e);
					insertFailsTotal++;
					continue;
				}
			}
		}
		return total;
	}

	/**
	 * 描述：抽查公告数据插入
	 * 
	 * @author yujingwei
	 * @date 2016-10-17
	 * @param pubDeptSctaskList
	 * @return void
	 * @throws Exception
	 */
	private int insertInfoForSoptCheck(List<PubSctask> pubSctaskList) throws Exception {
		int total = 0;
		PubAnnounceMent newPubAnnounceMentInfo = new PubAnnounceMent();
		if (CollectionUtils.isNotEmpty(pubSctaskList)) {
			for (PubSctask pubSctask : pubSctaskList) {
				try {
					PubAnnounceMent pubAnnounceMent = new PubAnnounceMent();
					pubAnnounceMent.setLinkUID(pubSctask.getUID());
					pubAnnounceMent.setEntName(pubSctask.getTaskName());
					pubAnnounceMent.setPubType(BulletinType.SpotBulletin.getCode());
					pubAnnounceMent.setPubTitle(pubSctask.getTaskName() + BulletinType.SpotBulletin.getDesc());
					pubAnnounceMent.setAuditDate(pubSctask.getCreateTime());
					pubAnnounceMent.setAuditDeptName(pubSctask.getLeaderDeptDesc());
					pubAnnounceMent.setCreateTime(new Date());
					if (pubSctask.getUID() != null) {
						newPubAnnounceMentInfo.setLinkUID(pubSctask.getUID());
						newPubAnnounceMentInfo.setPubType(BulletinType.SpotBulletin.getCode());
						pubAnnounceMentMapper.delete(newPubAnnounceMentInfo);
					}
					pubAnnounceMentMapper.insert(pubAnnounceMent);
					total++;
				} catch (Exception e) {
					logger.info("公告定时任务发生异常：{}", e);
					insertFailsTotal++;
					continue;
				}
			}
		}
		return total;
	}

	/**
	 * 描述：列入列出经营异常数据插入
	 * 
	 * @author yujingwei
	 * @date 2016-10-17
	 * @param pubOpanoMalyList
	 * @return void
	 * @throws Exception
	 */
	@Transaction
	private int insertInfoForPubOpanoMaly(List<PubOpanoMalyDto> pubOpanoMalyList) throws Exception {
		int total = 0;
		// 列异期满公告数据全量删除再添加
		// PubAnnounceMent pam = new PubAnnounceMent();
		// pam.setPubType("3");
		// pubAnnounceMentMapper.delete(pam);

		PubAnnounceMent newPubAnnounceMentInfo = new PubAnnounceMent();
		if (CollectionUtils.isNotEmpty(pubOpanoMalyList)) {
			for (PubOpanoMalyDto pubOpanoMalyDto : pubOpanoMalyList) {
				try {
					PubAnnounceMent pubAnnounceMent = new PubAnnounceMent();
					pubAnnounceMent.setLinkUID(pubOpanoMalyDto.getBusExcList());
					pubAnnounceMent.setPriPID(pubOpanoMalyDto.getPriPID());
					pubAnnounceMent.setAuditDate(pubOpanoMalyDto.getAuditDate());
					if (StringUtil.isEmpty(pubOpanoMalyDto.getEntName())) {
						continue;
					}
					pubAnnounceMent.setEntName(pubOpanoMalyDto.getEntName());
					pubAnnounceMent.setAuditDeptName(pubOpanoMalyDto.getDeptName());
					pubAnnounceMent.setCreateTime(new Date());
					if ("1".equals(pubOpanoMalyDto.getPubState())) {
						// 列入异常公告
						pubAnnounceMent.setPubType(BulletinType.AnomalyIn.getCode());
						pubAnnounceMent
								.setPubTitle("关于" + pubOpanoMalyDto.getEntName() + BulletinType.AnomalyIn.getDesc());
					} else if ("2".equals(pubOpanoMalyDto.getPubState())) {
						// 列出异常公告
						pubAnnounceMent.setPubType(BulletinType.AnomalyOut.getCode());
						pubAnnounceMent
								.setPubTitle("关于" + pubOpanoMalyDto.getEntName() + BulletinType.AnomalyOut.getDesc());
					} else if ("3".equals(pubOpanoMalyDto.getPubState())) {
						Date abnTimeDate = DateUtil.getNdaylaterDate(
								DateUtil.getNyearlaterDateObject(pubOpanoMalyDto.getAuditDate(), 3), -60);
						pubAnnounceMent.setAuditDate(abnTimeDate);
						pubAnnounceMent.setPubType(BulletinType.AnomalyRemind.getCode());
						pubAnnounceMent.setPubTitle(
								"关于" + pubOpanoMalyDto.getEntName() + BulletinType.AnomalyRemind.getDesc());
					}
					MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(pubOpanoMalyDto.getPriPID());
					if (midBaseInfo != null && midBaseInfo.getRegOrg() != null) {
						pubAnnounceMent.setAuditArea(midBaseInfo.getRegOrg().substring(0, 4));
					}
					if (pubOpanoMalyDto.getBusExcList() != null) {
						newPubAnnounceMentInfo.setLinkUID(pubOpanoMalyDto.getBusExcList());
						newPubAnnounceMentInfo.setPubType(pubOpanoMalyDto.getPubState());
						pubAnnounceMentMapper.delete(newPubAnnounceMentInfo);
					}
					pubAnnounceMentMapper.insert(pubAnnounceMent);
					total++;
				} catch (Exception e) {
					logger.info("公告定时任务发生异常：{}", e);
					insertFailsTotal++;
					continue;
				}
			}
		}
		return total;
	}

	/**
	 * 描述：行政处罚数据插入
	 * 
	 * @author yujingwei
	 * @date 2016-10-17
	 * @param pubOtherpunishList
	 * @return void
	 * @throws Exception
	 */
	private int insertInfoForPunish(List<PubOtherpunish> pubOtherpunishList) throws Exception {
		int total = 0;
		PubAnnounceMent newPubAnnounceMentInfo = new PubAnnounceMent();
		if (CollectionUtils.isNotEmpty(pubOtherpunishList)) {
			for (PubOtherpunish pubOtherpunish : pubOtherpunishList) {
				try {
					PubAnnounceMent pubAnnounceMent = new PubAnnounceMent();
					pubAnnounceMent.setLinkUID(pubOtherpunish.getCaseNO());
					pubAnnounceMent.setPriPID(pubOtherpunish.getPriPID());
					pubAnnounceMent.setAuditDate(pubOtherpunish.getAuditDate());
					pubAnnounceMent.setEntName(pubOtherpunish.getEntName());
					if (StringUtil.isEmpty(pubOtherpunish.getEntName())) {
						continue;
					}
					pubAnnounceMent.setAuditDeptName(pubOtherpunish.getJudAuth());
					pubAnnounceMent.setCreateTime(new Date());
					pubAnnounceMent.setPubType(BulletinType.PunishInfo.getCode());
					pubAnnounceMent.setPubTitle(pubOtherpunish.getEntName() + BulletinType.PunishInfo.getDesc());
					MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(pubOtherpunish.getPriPID());
					if (midBaseInfo != null && midBaseInfo.getRegOrg() != null) {
						pubAnnounceMent.setAuditArea(midBaseInfo.getRegOrg().substring(0, 4));
					}
					if (pubOtherpunish.getCaseNO() != null) {
						newPubAnnounceMentInfo.setLinkUID(pubOtherpunish.getCaseNO());
						newPubAnnounceMentInfo.setPubType(BulletinType.PunishInfo.getCode());
						pubAnnounceMentMapper.delete(newPubAnnounceMentInfo);
					}
					pubAnnounceMentMapper.insert(pubAnnounceMent);
					total++;
				} catch (Exception e) {
					logger.info("公告定时任务发生异常：{}", e);
					insertFailsTotal++;
					continue;
				}
			}
		}
		return total;
	}

	/**
	 * 描述：司法协助数据插入
	 * 
	 * @author yujingwei
	 * @date 2016-10-17
	 * @param pubJusticeInfoList
	 * @return void
	 * @throws Exception
	 */
	private int insertInfoForJustice(List<PubJusticeInfo> pubJusticeInfoList) throws Exception {
		int total = 0;
		PubAnnounceMent newPubAnnounceMentInfo = new PubAnnounceMent();
		if (CollectionUtils.isNotEmpty(pubJusticeInfoList)) {
			for (PubJusticeInfo pubJusticeInfo : pubJusticeInfoList) {
				try {
					PubAnnounceMent pubAnnounceMent = new PubAnnounceMent();
					pubAnnounceMent.setLinkUID(pubJusticeInfo.getUID());
					pubAnnounceMent.setPriPID(pubJusticeInfo.getPriPID());
					pubAnnounceMent.setAuditDate(pubJusticeInfo.getAuditDate());
					pubAnnounceMent.setEntName(pubJusticeInfo.getEntName());
					pubAnnounceMent.setAuditDeptName(pubJusticeInfo.getAuditName());
					pubAnnounceMent.setCreateTime(new Date());
					if (pubJusticeInfo.getJusticeType().equalsIgnoreCase("1")) {
						pubAnnounceMent.setPubType(BulletinType.JusticeInfoFroz.getCode());
						pubAnnounceMent
								.setPubTitle(pubJusticeInfo.getEntName() + BulletinType.JusticeInfoFroz.getDesc());
					} else if (pubJusticeInfo.getJusticeType().equalsIgnoreCase("2")) {
						pubAnnounceMent.setPubType(BulletinType.JusticeInfoAlter.getCode());
						pubAnnounceMent
								.setPubTitle(pubJusticeInfo.getEntName() + BulletinType.JusticeInfoAlter.getDesc());
					}
					MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(pubJusticeInfo.getPriPID());
					if (midBaseInfo != null && midBaseInfo.getRegOrg() != null) {
						pubAnnounceMent.setAuditArea(midBaseInfo.getRegOrg().substring(0, 4));
					}
					if (pubJusticeInfo.getUID() != null) {
						newPubAnnounceMentInfo.setLinkUID(pubJusticeInfo.getUID());
						if (pubJusticeInfo.getJusticeType().equals("1")) {
							newPubAnnounceMentInfo.setPubType(BulletinType.JusticeInfoFroz.getCode());
						} else {
							newPubAnnounceMentInfo.setPubType(BulletinType.JusticeInfoAlter.getCode());
						}
						pubAnnounceMentMapper.delete(newPubAnnounceMentInfo);
					}
					pubAnnounceMentMapper.insert(pubAnnounceMent);
					total++;
				} catch (Exception e) {
					logger.info("公告定时任务发生异常：{}", e);
					insertFailsTotal++;
					continue;
				}
			}
		}
		return total;
	}

	/**
	 * 描述：简易注销定时插入
	 * 
	 * @author yujingwei
	 * @date 2016-10-17
	 * @param pubJusticeInfoList
	 * @return void
	 * @throws Exception
	 */
	private int insertInfoForErEscAppinfo(List<ErEscAppinfo> erEscAppinfoList) throws Exception {
		int total = 0;
		PubAnnounceMent newPubAnnounceMentInfo = new PubAnnounceMent();
		if (CollectionUtils.isNotEmpty(erEscAppinfoList)) {
			for (ErEscAppinfo erEscAppinfo : erEscAppinfoList) {
				try {
					PubAnnounceMent pubAnnounceMent = new PubAnnounceMent();
					pubAnnounceMent.setLinkUID(erEscAppinfo.getPriPID());
					pubAnnounceMent.setPriPID(erEscAppinfo.getPriPID());
					pubAnnounceMent.setAuditDate(erEscAppinfo.getAppDate());
					pubAnnounceMent.setEntName(erEscAppinfo.getEntName());
					pubAnnounceMent.setCreateTime(new Date());
					pubAnnounceMent.setPubType(BulletinType.SimpleLogout.getCode());
					pubAnnounceMent
							.setPubTitle(erEscAppinfo.getEntName() + "关于申请" + BulletinType.SimpleLogout.getDesc());
					MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(erEscAppinfo.getPriPID());
					if (midBaseInfo != null && midBaseInfo.getRegOrg() != null) {
						pubAnnounceMent.setAuditArea(midBaseInfo.getRegOrg().substring(0, 4));
					}
					if (erEscAppinfo.getPriPID() != null) {
						newPubAnnounceMentInfo.setLinkUID(erEscAppinfo.getPriPID());
						newPubAnnounceMentInfo.setPubType(BulletinType.SimpleLogout.getCode());
						pubAnnounceMentMapper.delete(newPubAnnounceMentInfo);
					}
					pubAnnounceMentMapper.insert(pubAnnounceMent);
					total++;
				} catch (Exception e) {
					logger.info("公告定时任务发生异常：{}", e);
					insertFailsTotal++;
					continue;
				}
			}
		}
		return total;
	}

	/**
	 * 描述: 新增
	 * 
	 * @auther gaojinling
	 * @date 2017年6月8日
	 * @param pubAnnounceMent
	 * @return
	 * @throws Exception
	 */
	public int insertOne(PubAnnounceMent pubAnnounceMent) throws Exception {
		pubAnnounceMent.setCreateTime(new Date());
		return pubAnnounceMentMapper.insert(pubAnnounceMent);
	}

	/**
	 * 描述: 修改(通过linkUid更新)
	 * 
	 * @auther gaojinling
	 * @date 2017年6月8日
	 * @param pubAnnounceMent
	 * @return
	 * @throws Exception
	 */
	public int UpdateOne(PubAnnounceMent pubAnnounceMent) throws Exception {
		Example ex = new Example(PubAnnounceMent.class);
		ex.createCriteria().andEqualTo("linkUID", pubAnnounceMent.getLinkUID());
		pubAnnounceMent.setCreateTime(new Date());
		return pubAnnounceMentMapper.updateByExampleSelective(pubAnnounceMent, ex);
	}

	/**
	 * 
	 * 描述: 删除
	 * 
	 * @auther gaojinling
	 * @date 2017年6月8日
	 * @param linkuid
	 * @return
	 * @throws SQLException
	 */
	public int deleteOne(String linkuid) throws Exception {
		Example ex = new Example(PubAnnounceMent.class);
		ex.createCriteria().andEqualTo("linkUID", linkuid);
		return pubAnnounceMentMapper.deleteByExample(ex);
	}

	/**
	 * 描述: 获取列表数据
	 * 
	 * @author yujingwei
	 * @date 2017年07月19日
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	public List<PubAnnounceMentDto> doGetPubBulletinfoForServer(PageRequest request) throws Exception {
		Map<String, Object> searchMap = request.getParams();
		int pageSize = request.getLength();
		searchMap.put("numStart", (request.getPageNum() - 1) * pageSize);
		searchMap.put("pageSize", pageSize);
		// 登记状态
		if (searchMap.get("regState") != null && !searchMap.get("regState").toString().equals("")) {
			searchMap.put("regStates", searchMap.get("regState").toString().split(","));
		}
		return pubAnnounceMentMapper.doGetPubBulletinfoForServer(searchMap);
	}

	/**
	 * 描述: 获取列表数据个数
	 * 
	 * @author yujingwei
	 * @date 2017年07月19日
	 * @param request
	 * @return Integer
	 * @throws SQLException
	 */
	public Integer doGetPubBulletinTotalForServer(PageRequest request) throws Exception {
		Map<String, Object> searchMap = request.getParams();
		// 登记状态
		if (searchMap.get("regState") != null && !searchMap.get("regState").toString().equals("")) {
			searchMap.put("regStates", searchMap.get("regState").toString().split(","));
		}
		return pubAnnounceMentMapper.selectPubBulletinTotalForServer(searchMap);
	}

	/**
	 * 描述: 获取信息公告家数
	 * 
	 * @author yujingwei
	 * @date 2017年07月19日
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	public Integer doGetDistinctBulletinTotal(Map<String, Object> dataParmMap) throws Exception {
		// 登记状态
		if (dataParmMap.get("regState") != null && !dataParmMap.get("regState").toString().equals("")) {
			dataParmMap.put("regStates", dataParmMap.get("regState").toString().split(","));
		}
		return pubAnnounceMentMapper.selectDistinctBulletinTotalForServer(dataParmMap);
	}

	@Override
	public void test() throws Exception {
		String updateDate = DateUtil.getNdaylater2(new Date(), -1);
		List<PubOpanoMalyDto> pubOpanoMalyList = pubOpanoMalyService.queryPubOpanoMalyListForNotice(updateDate);
		PubAnnounceMent newPubAnnounceMentInfo = new PubAnnounceMent();
		if (CollectionUtils.isNotEmpty(pubOpanoMalyList)) {
			for (PubOpanoMalyDto pubOpanoMalyDto : pubOpanoMalyList) {
				try {
					PubAnnounceMent pubAnnounceMent = new PubAnnounceMent();
					pubAnnounceMent.setLinkUID(pubOpanoMalyDto.getBusExcList());
					pubAnnounceMent.setPriPID(pubOpanoMalyDto.getPriPID());
					pubAnnounceMent.setAuditDate(pubOpanoMalyDto.getAuditDate());
					if (StringUtil.isEmpty(pubOpanoMalyDto.getEntName())) {
						continue;
					}
					pubAnnounceMent.setEntName(pubOpanoMalyDto.getEntName());
					pubAnnounceMent.setAuditDeptName(pubOpanoMalyDto.getDeptName());
					pubAnnounceMent.setCreateTime(new Date());
					if ("3".equals(pubOpanoMalyDto.getPubState())) {
						// 期满三年公告
						Date abnTimeDate = DateUtil.getNdaylaterDate(
								DateUtil.getNyearlaterDateObject(pubOpanoMalyDto.getAuditDate(), 3), -60);
						pubAnnounceMent.setAuditDate(abnTimeDate);
						pubAnnounceMent.setPubType(BulletinType.AnomalyRemind.getCode());
						pubAnnounceMent.setPubTitle(
								"关于" + pubOpanoMalyDto.getEntName() + BulletinType.AnomalyRemind.getDesc());
					}
					MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(pubOpanoMalyDto.getPriPID());
					if (midBaseInfo != null && midBaseInfo.getRegOrg() != null) {
						pubAnnounceMent.setAuditArea(midBaseInfo.getRegOrg().substring(0, 4));
					}
					if (pubOpanoMalyDto.getBusExcList() != null) {
						newPubAnnounceMentInfo.setLinkUID(pubOpanoMalyDto.getBusExcList());
						newPubAnnounceMentInfo.setPubType(pubOpanoMalyDto.getPubState());
						pubAnnounceMentMapper.delete(newPubAnnounceMentInfo);
					}
					pubAnnounceMentMapper.insert(pubAnnounceMent);
				} catch (Exception e) {
					logger.info("公告定时任务发生异常：{}", e);
					continue;
				}
			}
		}
	}

	@Override
	public PubAnnounceMent findBySomeMsg(String priPID, Date abnTime, String pubType) throws Exception {
		Example example = new Example(PubAnnounceMent.class);
		example.createCriteria().andEqualTo("priPID", priPID).andEqualTo("pubType", pubType).andEqualTo("auditDate",
				abnTime);
		List<PubAnnounceMent> data = pubAnnounceMentMapper.selectByExample(example);
		if (data.size() > 0)
			return data.get(0);
		return null;
	}

}