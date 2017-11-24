package com.icinfo.cs.base.constant;

public enum QuartzJobName {
	
	PANORAMA_JOB("全景查询索引定时JOB"),
	PUB_IDX_JOB("公示索引定时JOB"),
	SM_IDX_JOB("小微企业索引定时JOB"),
	BULLETIN_JOB("插入公告数据JOB"),
	DTINFO_JOB("双告知推送JOB"),
	DZDTINFO_JOB("多证合一推送JOB"),
	SCINFO_JOB("更新抽查检查时间JOB"),
	SENDSMS_JOB("短信群发定时JOB"),
	PBOPANOMALY_JOB("个体户已补报定时移出经营异常时间JOB"),
	PUBOPANOMALYDXAUTOOUT_JOB("企业/农专、个体户注销移出异常时间JOB"), 
	REGISTINFO_JOB("户口建档批量分配JOB"), 
	PBOPANOMALYISINDIVID_JOB("个体户个转企自动移出异常时间JOB"),
	PBOPANOMALYNOREPORT_JOB("个体户未按时年报列入异常时间JOB"),
	YR_MSG_SEND_JOB("年报消息推送JOB"),
	OPANOMALY_MSG_SEND_JOB("企信联连异常消息推送JOB"), 
	IMINFO_MSG_SEND_JOB("企信联连即时消息推送JOB"),
	SCCHECK_MSG_SEND_JOB("企信联连抽查检查消息推送JOB"), 
	QCDZ_ZTCOUNT_JOB("全程电子化主体信息交换JOB"), 
	QCDZ_SLOWDATA_JOB("全程电子慢交换JOB"),
	QCDZ_MAPDATA_JOB("全程电子地图数据交换JOB"),
	QUALIFICATION_LIMIT_JOB("任职资格限制信息定时JOB"),
	REPORT_CHECK_JOB("补报核查定时JOB"), 
	PUBOTHERLICENCEGOV_JOB("公示许可证、行政处罚归集定时任务JOB");
	
	
	
	private String jobName;
	
	private QuartzJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobName() {
		return jobName;
	}

}
