-- 小微企业
-- 新设企业
-- select count(*) from cs_mid_baseinfo t where t.EstDate >= DATE_FORMAT('2016-01-01','%Y-%m-%d') ;

-- select * from cs_sm_baseinfo t limit 100;

-- 01	本年度新设立的市场主体
-- 02	上年度已年报的市场主体
/*
新设企业，个体户.
*/

-- delete from cs_sm_baseinfo where diryear = 2016;

INSERT INTO cs_sm_baseinfo (
	pripid,
	diryear,
	uniscid,
	regno,
	entname,
	enttypecatg,
	enttype,
	estDate,
	RegCap,
	regorg,
	industryphy,
	industryCo,
	dircreatetime,
	dircreatereason,
	dircreatereasoncode,
	createtime 
)
select pripid,'2016' diryear ,unicode,regno,entname,enttypecatg,enttype,estdate,regcap,regorg,industryphy,industryco,sysdate(),
'本年度新设立的市场主体','01', sysdate() from cs_mid_baseinfo t 
 where t.EstDate >= DATE_FORMAT('2016-01-01','%Y-%m-%d') and t.estdate < DATE_FORMAT('2017-01-01','%Y-%m-%d') 
 and t.RegState in ('K','B','A','DA','X','Q')
 and t.EntTypeCatg = '50' 
; 
-- 2017-05-03 新设分支机构直接列入。

INSERT INTO cs_sm_baseinfo (
	pripid,
	diryear,
	uniscid,
	regno,
	entname,
	enttypecatg,
	enttype,
	estDate,
	RegCap,
	regorg,
	industryphy,
	industryCo,
	dircreatetime,
	dircreatereason,
	dircreatereasoncode,
	createtime 
)
select pripid,'2016' diryear ,unicode,regno,entname,enttypecatg,enttype,estdate,regcap,regorg,industryphy,industryco,sysdate(),
'本年度新设立的市场主体','01', sysdate() from cs_mid_baseinfo t 
 where t.EstDate >= DATE_FORMAT('2016-01-01','%Y-%m-%d') and t.estdate < DATE_FORMAT('2017-01-01','%Y-%m-%d') 
 and t.RegState in ('K','B','A','DA','X','Q')
 and t.EntTypeCatg in('22','25','28','32','34');


/*
新设企业，其他
内资公司	1000 - 1229
内资企业法人	3000 - 3500
内资合伙企业	4530 - 4533
个人独资企业	4540
内资非法人企业	4400 - 4420、4600、4700
外资公司	5000- 5290、6000 - 6290
外商投资合伙企业	5400- 5490 、6400 - 6490
外国（地区）企业在中国境内从事生产经营活动	7300 - 7390
中外合作非法人企业	5300 – 5390、6300 - 6390
*/

-- select * from cs_mid_baseinfo  where EstDate >= DATE_FORMAT('2017-01-01','%Y-%m-%d') limit 10
INSERT INTO cs_sm_baseinfo (
	pripid,
	diryear,
	uniscid,
	regno,
	entname,
	enttypecatg,
	enttype,
	estDate,
	RegCap,
	regorg,
	industryphy,
	industryCo,
	dircreatetime,
	dircreatereason,
	dircreatereasoncode,
	createtime 
)
select
  pripid,'2016' diryear ,unicode,regno,entname,enttypecatg,enttype,estdate,regcap,regorg,
industryphy,industryco,sysdate(),
'本年度新设立的市场主体','01', sysdate() 
from cs_mid_baseinfo t where t.EstDate >= DATE_FORMAT('2016-01-01','%Y-%m-%d') and t.estdate < DATE_FORMAT('2017-01-01','%Y-%m-%d') 
 and t.RegState in ('K','B','A','DA','X','Q')
-- and ( cast( t.EntType  as signed) >= 1000 and cast( t.EntType  as signed)  <= 1229)
and  t.EntType  in (1000,1100,1110,1120,1121,1122,1123,1130,1140,1150,1151,1152,1153,1190,1200,1210,1211,1212,1213,1219,1220,1221,1222,1223,1229,
3000,3100,3200,3300,3400,3500,
4530,4531,4532,4533,
4540,
4400,4410,4420,4600,4700,
5000,5100,5110,5120,5130,5140,5150,5160,5190,5200,5210,5220,5230,5240,5290, 6000,6100,6110,6120,6130,6140,6150,6160,6170,6190,6200,6210,6220,6230,6240,6250,6260,6290,
5400,5410,5420,5430,5490,6400,6410,6420,6430,6490,
7300,7310,7390,
5300,5310,5320,5390,6300,6310,6320,6390
)
and (RegCap > 0 and RegCap <= 500)
and CurrencyCN = '元人民币'
-- order by t.EntType
; 


/*
  存续企业
*/

-- 个体户，已年报 直接列入

INSERT INTO cs_sm_baseinfo (
	pripid,
	diryear,
	uniscid,
	regno,
	entname,
	enttypecatg,
	enttype,
	estDate,
	RegCap,
	regorg,
	industryphy,
	industryCo,
	dircreatetime,
	dircreatereason,
	dircreatereasoncode,
	createtime ,
  year,
  MAIBUSINC,
  EmpNum
)
select t.pripid,'2016' diryear ,t.unicode,t.regno,t.entname,t.enttypecatg,t.enttype,t.estdate,t.regcap,t.regorg,t.industryphy,t.industryco,sysdate(),
'上年度已年报的市场主体','02', sysdate(),
2015,b.VendInc,b.empnum
 from cs_mid_baseinfo t,cs_yr_reg_check s 
 left join cs_yr_pb_baseinfo b on s.PriPID = b.pripid and s.`Year` = b.year
  where
 t.PriPID = s.PriPID and s.`Year` = 2015 
 and s.IsReported <> '0'
 and t.RegState in ('K','B','A','DA','X','Q') and t.EntTypeCatg = '50' 

; -- 2598811   存续状态修改后 2600463
 

/*
 企业已年报，是否小微判断
已年报，农林牧渔
*/

INSERT INTO cs_sm_baseinfo (
	pripid,
	diryear,
	uniscid,
	regno,
	entname,
	enttypecatg,
	enttype,
	estDate,
	RegCap,
	regorg,
	industryphy,
	industryCo,
	dircreatetime,
	dircreatereason,
	dircreatereasoncode,
	createtime ,
  Year,
  AssgroIsp,
  ASSGRO,
  MaiBusincIsp,
  MAIBUSINC,
  EmpNumIsp,
  EmpNum

)

SELECT
	t.pripid,
	'2016' diryear,
	t.unicode,
	t.regno,
	t.entname,
	t.enttypecatg,
	t.enttype,
	t.estdate,
	t.regcap,
	t.regorg,
	t.industryphy,
	t.industryco,
	sysdate(),
	'上年度已年报的市场主体',
	'02',
	sysdate(),
  2015,
  b.AssGroIsPub,
  b.AssGro,
  b.MaiBusIncIsPub,
  b.MaiBusInc,
  b.EmpNumDis,
  b.EmpNum 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID and s.`Year` = 2015 
and t.PriPID = b.PriPID and b.`Year` = 2015
and s.IsReported <> '0'
-- and t.EstDate >= DATE_FORMAT('2016-01-01','%Y-%m-%d') and  t.EstDate < DATE_FORMAT('2017-01-01','%Y-%m-%d')
 and t.RegState in ('K','B','A','DA','X','Q') and t.EntTypeCatg in ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
and t.IndustryPhy = 'A'
and b.VENDINC < 500 and b.VendInc >= 0
; 


/*
 企业已年报，是否小微判断
 工业，04
*/

INSERT INTO cs_sm_baseinfo (
	pripid,
	diryear,
	uniscid,
	regno,
	entname,
	enttypecatg,
	enttype,
	estDate,
	RegCap,
	regorg,
	industryphy,
	industryCo,
	dircreatetime,
	dircreatereason,
	dircreatereasoncode,
	createtime ,
  Year,
  AssgroIsp,
  ASSGRO,
  MaiBusincIsp,
  MAIBUSINC,
  EmpNumIsp,
  EmpNum

)

SELECT
	t.pripid,
	'2016' diryear,
	t.unicode,
	t.regno,
	t.entname,
	t.enttypecatg,
	t.enttype,
	t.estdate,
	t.regcap,
	t.regorg,
	t.industryphy,
	t.industryco,
	sysdate(),
	'上年度已年报的市场主体',
	'02',
	sysdate(),
  2015,
  b.AssGroIsPub,
  b.AssGro,
  b.MaiBusIncIsPub,
  b.MaiBusInc,
  b.EmpNumDis,
  b.EmpNum 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE
 t.PriPID = s.PriPID and s.`Year` = 2015 
and t.PriPID = b.PriPID and b.`Year` = 2015
and s.IsReported <> '0'
-- and t.EstDate >= DATE_FORMAT('2016-01-01','%Y-%m-%d') and  t.EstDate < DATE_FORMAT('2017-01-01','%Y-%m-%d')
 and t.RegState in ('K','B','A','DA','X','Q') and t.EntTypeCatg in ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
and t.IndustryPhy in('B','C','D' )
and ((b.VENDINC < 2000 and b.VendInc >= 0)
or (b.EmpNum < 300 and b.EmpNum >= 0))
; 


/*
 企业已年报，是否小微判断
 建筑业,05
 建筑业	营业收入(Y)	人民币万元	0≤Y<6000
	资产总额(Z)	人民币万元	0≤Z<5000
*/

INSERT INTO cs_sm_baseinfo (
	pripid,
	diryear,
	uniscid,
	regno,
	entname,
	enttypecatg,
	enttype,
	estDate,
	RegCap,
	regorg,
	industryphy,
	industryCo,
	dircreatetime,
	dircreatereason,
	dircreatereasoncode,
	createtime ,
  Year,
  AssgroIsp,
  ASSGRO,
  MaiBusincIsp,
  MAIBUSINC,
  EmpNumIsp,
  EmpNum

)

SELECT
	t.pripid,
	'2016' diryear,
	t.unicode,
	t.regno,
	t.entname,
	t.enttypecatg,
	t.enttype,
	t.estdate,
	t.regcap,
	t.regorg,
	t.industryphy,
	t.industryco,
	sysdate(),
	'上年度已年报的市场主体',
	'02',
	sysdate(),
  2015,
  b.AssGroIsPub,
  b.AssGro,
  b.MaiBusIncIsPub,
  b.MaiBusInc,
  b.EmpNumDis,
  b.EmpNum 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID and s.`Year` = 2015 
and t.PriPID = b.PriPID and b.`Year` = 2015
and s.IsReported <> '0'
-- and t.EstDate >= DATE_FORMAT('2016-01-01','%Y-%m-%d') and  t.EstDate < DATE_FORMAT('2017-01-01','%Y-%m-%d')
 and t.RegState in ('K','B','A','DA','X','Q') and t.EntTypeCatg in ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
and t.IndustryPhy in('E' )
and ((b.VENDINC < 6000 and b.VendInc >= 0)
or (b.ASSGRO < 5000 and b.ASSGRO >= 0))
; 


/*
 企业已年报，是否小微判断
  06 批发业	从业人员(X)	人	0≤X<20
	营业收入(Y)	人民币万元	0≤Y<5000
*/

INSERT INTO cs_sm_baseinfo (
	pripid,
	diryear,
	uniscid,
	regno,
	entname,
	enttypecatg,
	enttype,
	estDate,
	RegCap,
	regorg,
	industryphy,
	industryCo,
	dircreatetime,
	dircreatereason,
	dircreatereasoncode,
	createtime ,
  Year,
  AssgroIsp,
  ASSGRO,
  MaiBusincIsp,
  MAIBUSINC,
  EmpNumIsp,
  EmpNum

)

SELECT
	t.pripid,
	'2016' diryear,
	t.unicode,
	t.regno,
	t.entname,
	t.enttypecatg,
	t.enttype,
	t.estdate,
	t.regcap,
	t.regorg,
	t.industryphy,
	t.industryco,
	sysdate(),
	'上年度已年报的市场主体',
	'02',
	sysdate(),
  2015,
  b.AssGroIsPub,
  b.AssGro,
  b.MaiBusIncIsPub,
  b.MaiBusInc,
  b.EmpNumDis,
  b.EmpNum 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID and s.`Year` = 2015 
and t.PriPID = b.PriPID and b.`Year` = 2015
and s.IsReported <> '0'
-- and t.EstDate >= DATE_FORMAT('2016-01-01','%Y-%m-%d') and  t.EstDate < DATE_FORMAT('2017-01-01','%Y-%m-%d')
 and t.RegState in ('K','B','A','DA','X','Q') and t.EntTypeCatg in ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
and t.IndustryPhy in('F' ) and t.IndustryCo like '51%'
and ((b.VENDINC < 5000 and b.VendInc >= 0)
or (b.EmpNum < 20 and b.EmpNum >= 0))
; 


/*
 企业已年报，是否小微判断
  07 零售业	从业人员(X)	人	0≤X<50
	营业收入(Y)	人民币万元	0≤Y<500
*/

INSERT INTO cs_sm_baseinfo (
	pripid,
	diryear,
	uniscid,
	regno,
	entname,
	enttypecatg,
	enttype,
	estDate,
	RegCap,
	regorg,
	industryphy,
	industryCo,
	dircreatetime,
	dircreatereason,
	dircreatereasoncode,
	createtime ,
  Year,
  AssgroIsp,
  ASSGRO,
  MaiBusincIsp,
  MAIBUSINC,
  EmpNumIsp,
  EmpNum

)

SELECT
	t.pripid,
	'2016' diryear,
	t.unicode,
	t.regno,
	t.entname,
	t.enttypecatg,
	t.enttype,
	t.estdate,
	t.regcap,
	t.regorg,
	t.industryphy,
	t.industryco,
	sysdate(),
	'上年度已年报的市场主体',
	'02',
	sysdate(),
  2015,
  b.AssGroIsPub,
  b.AssGro,
  b.MaiBusIncIsPub,
  b.MaiBusInc,
  b.EmpNumDis,
  b.EmpNum 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID and s.`Year` = 2015 
and t.PriPID = b.PriPID and b.`Year` = 2015
and s.IsReported <> '0'
-- and t.EstDate >= DATE_FORMAT('2016-01-01','%Y-%m-%d') and  t.EstDate < DATE_FORMAT('2017-01-01','%Y-%m-%d')
 and t.RegState in ('K','B','A','DA','X','Q') and t.EntTypeCatg in ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
and t.IndustryPhy in('F' ) and t.IndustryCo like '52%'
and ((b.VENDINC < 500 and b.VendInc >= 0)
or (b.EmpNum < 50 and b.EmpNum >= 0))
; 


/*
 企业已年报，是否小微判断
  08 交通运输业	从业人员(X)	人	0≤X<300
	营业收入(Y)	人民币万元	0≤Y<3000
G53   	铁路运输业
G54   	道路运输业
G55   	水上运输业
G56   	航空运输业 
G57   	管道运输业 
G58   	装卸搬运和运输代理业
*/

INSERT INTO cs_sm_baseinfo (
	pripid,
	diryear,
	uniscid,
	regno,
	entname,
	enttypecatg,
	enttype,
	estDate,
	RegCap,
	regorg,
	industryphy,
	industryCo,
	dircreatetime,
	dircreatereason,
	dircreatereasoncode,
	createtime ,
  Year,
  AssgroIsp,
  ASSGRO,
  MaiBusincIsp,
  MAIBUSINC,
  EmpNumIsp,
  EmpNum

)

SELECT
	t.pripid,
	'2016' diryear,
	t.unicode,
	t.regno,
	t.entname,
	t.enttypecatg,
	t.enttype,
	t.estdate,
	t.regcap,
	t.regorg,
	t.industryphy,
	t.industryco,
	sysdate(),
	'上年度已年报的市场主体',
	'02',
	sysdate(),
  2015,
  b.AssGroIsPub,
  b.AssGro,
  b.MaiBusIncIsPub,
  b.MaiBusInc,
  b.EmpNumDis,
  b.EmpNum 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID and s.`Year` = 2015 
and t.PriPID = b.PriPID and b.`Year` = 2015
and s.IsReported <> '0'
-- and t.EstDate >= DATE_FORMAT('2016-01-01','%Y-%m-%d') and  t.EstDate < DATE_FORMAT('2016-01-01','%Y-%m-%d')
 and t.RegState in ('K','B','A','DA','X','Q') and t.EntTypeCatg in ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
and t.IndustryPhy in('G') and substr(t.IndustryCo,1,2) in ('53','54','55','56','57','58') 
and ((b.VENDINC < 3000 and b.VendInc >= 0)
or (b.EmpNum < 300 and b.EmpNum >= 0))
; 

/*
 企业已年报，是否小微判断
  09 G59   	仓储业 
  仓储业	从业人员(X)	人	0≤X<100
	营业收入(Y)	人民币万元	0≤Y<1000
*/

INSERT INTO cs_sm_baseinfo (
	pripid,
	diryear,
	uniscid,
	regno,
	entname,
	enttypecatg,
	enttype,
	estDate,
	RegCap,
	regorg,
	industryphy,
	industryCo,
	dircreatetime,
	dircreatereason,
	dircreatereasoncode,
	createtime ,
  Year,
  AssgroIsp,
  ASSGRO,
  MaiBusincIsp,
  MAIBUSINC,
  EmpNumIsp,
  EmpNum

)

SELECT
	t.pripid,
	'2016' diryear,
	t.unicode,
	t.regno,
	t.entname,
	t.enttypecatg,
	t.enttype,
	t.estdate,
	t.regcap,
	t.regorg,
	t.industryphy,
	t.industryco,
	sysdate(),
	'上年度已年报的市场主体',
	'02',
	sysdate(),
  2015,
  b.AssGroIsPub,
  b.AssGro,
  b.MaiBusIncIsPub,
  b.MaiBusInc,
  b.EmpNumDis,
  b.EmpNum 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID and s.`Year` = 2015 
and t.PriPID = b.PriPID and b.`Year` = 2015
and s.IsReported <> '0'
-- and t.EstDate >= DATE_FORMAT('2016-01-01','%Y-%m-%d') and  t.EstDate < DATE_FORMAT('2016-01-01','%Y-%m-%d')
 and t.RegState in ('K','B','A','DA','X','Q') and t.EntTypeCatg in ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
and t.IndustryPhy in('G') and substr(t.IndustryCo,1,2) = ('59') 
and ((b.VENDINC < 1000 and b.VendInc >= 0)
or (b.EmpNum < 100 and b.EmpNum >= 0))
; 


/*
 企业已年报，是否小微判断
  10 
  邮政业	从业人员(X)	人	0≤X<300
	营业收入(Y)	人民币万元	0≤Y<2000
*/

INSERT INTO cs_sm_baseinfo (
	pripid,
	diryear,
	uniscid,
	regno,
	entname,
	enttypecatg,
	enttype,
	estDate,
	RegCap,
	regorg,
	industryphy,
	industryCo,
	dircreatetime,
	dircreatereason,
	dircreatereasoncode,
	createtime ,
  Year,
  AssgroIsp,
  ASSGRO,
  MaiBusincIsp,
  MAIBUSINC,
  EmpNumIsp,
  EmpNum

)

SELECT
	t.pripid,
	'2016' diryear,
	t.unicode,
	t.regno,
	t.entname,
	t.enttypecatg,
	t.enttype,
	t.estdate,
	t.regcap,
	t.regorg,
	t.industryphy,
	t.industryco,
	sysdate(),
	'上年度已年报的市场主体',
	'02',
	sysdate(),
  2015,
  b.AssGroIsPub,
  b.AssGro,
  b.MaiBusIncIsPub,
  b.MaiBusInc,
  b.EmpNumDis,
  b.EmpNum 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID and s.`Year` = 2015 
and t.PriPID = b.PriPID and b.`Year` = 2015
and s.IsReported <> '0'
-- and t.EstDate >= DATE_FORMAT('2016-01-01','%Y-%m-%d') and  t.EstDate < DATE_FORMAT('2016-01-01','%Y-%m-%d')
 and t.RegState in ('K','B','A','DA','X','Q') and t.EntTypeCatg in ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
and t.IndustryPhy in('G') and substr(t.IndustryCo,1,2) = ('60') 
and ((b.VENDINC < 2000 and b.VendInc >= 0)
or (b.EmpNum < 300 and b.EmpNum >= 0))
; 



/*
 企业已年报，是否小微判断
  11 
  住宿业	从业人员(X)	人	0≤X<100
	营业收入(Y)	人民币万元	0≤Y<2000
*/

INSERT INTO cs_sm_baseinfo (
	pripid,
	diryear,
	uniscid,
	regno,
	entname,
	enttypecatg,
	enttype,
	estDate,
	RegCap,
	regorg,
	industryphy,
	industryCo,
	dircreatetime,
	dircreatereason,
	dircreatereasoncode,
	createtime ,
  Year,
  AssgroIsp,
  ASSGRO,
  MaiBusincIsp,
  MAIBUSINC,
  EmpNumIsp,
  EmpNum

)

SELECT
	t.pripid,
	'2016' diryear,
	t.unicode,
	t.regno,
	t.entname,
	t.enttypecatg,
	t.enttype,
	t.estdate,
	t.regcap,
	t.regorg,
	t.industryphy,
	t.industryco,
	sysdate(),
	'上年度已年报的市场主体',
	'02',
	sysdate(),
  2015,
  b.AssGroIsPub,
  b.AssGro,
  b.MaiBusIncIsPub,
  b.MaiBusInc,
  b.EmpNumDis,
  b.EmpNum 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID and s.`Year` = 2015 
and t.PriPID = b.PriPID and b.`Year` = 2015
and s.IsReported <> '0'
-- and t.EstDate >= DATE_FORMAT('2016-01-01','%Y-%m-%d') and  t.EstDate < DATE_FORMAT('2016-01-01','%Y-%m-%d')
 and t.RegState in ('K','B','A','DA','X','Q') and t.EntTypeCatg in ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
and t.IndustryPhy in('H') and substr(t.IndustryCo,1,2) = ('61') 
and ((b.VENDINC < 2000 and b.VendInc >= 0)
or (b.EmpNum < 100 and b.EmpNum >= 0))
; 


/*
 企业已年报，是否小微判断
  12 
  餐饮业	从业人员(X)	人	0≤X<100
	营业收入(Y)	人民币万元	0≤Y<2000
*/

INSERT INTO cs_sm_baseinfo (
	pripid,
	diryear,
	uniscid,
	regno,
	entname,
	enttypecatg,
	enttype,
	estDate,
	RegCap,
	regorg,
	industryphy,
	industryCo,
	dircreatetime,
	dircreatereason,
	dircreatereasoncode,
	createtime ,
  Year,
  AssgroIsp,
  ASSGRO,
  MaiBusincIsp,
  MAIBUSINC,
  EmpNumIsp,
  EmpNum

)

SELECT
	t.pripid,
	'2016' diryear,
	t.unicode,
	t.regno,
	t.entname,
	t.enttypecatg,
	t.enttype,
	t.estdate,
	t.regcap,
	t.regorg,
	t.industryphy,
	t.industryco,
	sysdate(),
	'上年度已年报的市场主体',
	'02',
	sysdate(),
  2015,
  b.AssGroIsPub,
  b.AssGro,
  b.MaiBusIncIsPub,
  b.MaiBusInc,
  b.EmpNumDis,
  b.EmpNum 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID and s.`Year` = 2015 
and t.PriPID = b.PriPID and b.`Year` = 2015
and s.IsReported <> '0'
-- and t.EstDate >= DATE_FORMAT('2016-01-01','%Y-%m-%d') and  t.EstDate < DATE_FORMAT('2016-01-01','%Y-%m-%d')
 and t.RegState in ('K','B','A','DA','X','Q') and t.EntTypeCatg in ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
and t.IndustryPhy in('H') and substr(t.IndustryCo,1,2) = ('62') 
and ((b.VENDINC < 2000 and b.VendInc >= 0)
or (b.EmpNum < 100 and b.EmpNum >= 0))
; 


/*
 企业已年报，是否小微判断
  13 
  信息传输业	从业人员(X)	人	0≤X<100
	营业收入(Y)	人民币万元	0≤Y<1000
*/

INSERT INTO cs_sm_baseinfo (
	pripid,
	diryear,
	uniscid,
	regno,
	entname,
	enttypecatg,
	enttype,
	estDate,
	RegCap,
	regorg,
	industryphy,
	industryCo,
	dircreatetime,
	dircreatereason,
	dircreatereasoncode,
	createtime ,
  Year,
  AssgroIsp,
  ASSGRO,
  MaiBusincIsp,
  MAIBUSINC,
  EmpNumIsp,
  EmpNum

)

SELECT
	t.pripid,
	'2016' diryear,
	t.unicode,
	t.regno,
	t.entname,
	t.enttypecatg,
	t.enttype,
	t.estdate,
	t.regcap,
	t.regorg,
	t.industryphy,
	t.industryco,
	sysdate(),
	'上年度已年报的市场主体',
	'02',
	sysdate(),
  2015,
  b.AssGroIsPub,
  b.AssGro,
  b.MaiBusIncIsPub,
  b.MaiBusInc,
  b.EmpNumDis,
  b.EmpNum 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID and s.`Year` = 2015 
and t.PriPID = b.PriPID and b.`Year` = 2015
and s.IsReported <> '0'
-- and t.EstDate >= DATE_FORMAT('2016-01-01','%Y-%m-%d') and  t.EstDate < DATE_FORMAT('2016-01-01','%Y-%m-%d')
 and t.RegState in ('K','B','A','DA','X','Q') and t.EntTypeCatg in ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
and t.IndustryPhy in('I') and substr(t.IndustryCo,1,2) in ('63','64') 
and ((b.VENDINC < 1000 and b.VendInc >= 0)
or (b.EmpNum < 100 and b.EmpNum >= 0))
; 


/*
 企业已年报，是否小微判断
  14 
  软件和信息技术服务业	从业人员(X)	人	0≤X<100
	营业收入(Y)	人民币万元	0≤Y<1000
*/

INSERT INTO cs_sm_baseinfo (
	pripid,
	diryear,
	uniscid,
	regno,
	entname,
	enttypecatg,
	enttype,
	estDate,
	RegCap,
	regorg,
	industryphy,
	industryCo,
	dircreatetime,
	dircreatereason,
	dircreatereasoncode,
	createtime ,
  Year,
  AssgroIsp,
  ASSGRO,
  MaiBusincIsp,
  MAIBUSINC,
  EmpNumIsp,
  EmpNum

)

SELECT
	t.pripid,
	'2016' diryear,
	t.unicode,
	t.regno,
	t.entname,
	t.enttypecatg,
	t.enttype,
	t.estdate,
	t.regcap,
	t.regorg,
	t.industryphy,
	t.industryco,
	sysdate(),
	'上年度已年报的市场主体',
	'02',
	sysdate(),
  2015,
  b.AssGroIsPub,
  b.AssGro,
  b.MaiBusIncIsPub,
  b.MaiBusInc,
  b.EmpNumDis,
  b.EmpNum 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID and s.`Year` = 2015 
and t.PriPID = b.PriPID and b.`Year` = 2015
and s.IsReported <> '0'
-- and t.EstDate >= DATE_FORMAT('2016-01-01','%Y-%m-%d') and  t.EstDate < DATE_FORMAT('2016-01-01','%Y-%m-%d')
 and t.RegState in ('K','B','A','DA','X','Q') and t.EntTypeCatg in ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
and t.IndustryPhy in('I') and substr(t.IndustryCo,1,2) = ('65') 
and ((b.VENDINC < 1000 and b.VendInc >= 0)
or (b.EmpNum < 100 and b.EmpNum >= 0))
; 


/*
 企业已年报，是否小微判断
  15 
  房地产开发经营	营业收入(Y)	人民币万元	0≤Y<1000
	资产总额(Z)	人民币万元	0≤Z<5000
*/

INSERT INTO cs_sm_baseinfo (
	pripid,
	diryear,
	uniscid,
	regno,
	entname,
	enttypecatg,
	enttype,
	estDate,
	RegCap,
	regorg,
	industryphy,
	industryCo,
	dircreatetime,
	dircreatereason,
	dircreatereasoncode,
	createtime ,
  Year,
  AssgroIsp,
  ASSGRO,
  MaiBusincIsp,
  MAIBUSINC,
  EmpNumIsp,
  EmpNum

)

SELECT
	t.pripid,
	'2016' diryear,
	t.unicode,
	t.regno,
	t.entname,
	t.enttypecatg,
	t.enttype,
	t.estdate,
	t.regcap,
	t.regorg,
	t.industryphy,
	t.industryco,
	sysdate(),
	'上年度已年报的市场主体',
	'02',
	sysdate(),
  2015,
  b.AssGroIsPub,
  b.AssGro,
  b.MaiBusIncIsPub,
  b.MaiBusInc,
  b.EmpNumDis,
  b.EmpNum 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID and s.`Year` = 2015 
and t.PriPID = b.PriPID and b.`Year` = 2015
and s.IsReported <> '0'
-- and t.EstDate >= DATE_FORMAT('2016-01-01','%Y-%m-%d') and  t.EstDate < DATE_FORMAT('2016-01-01','%Y-%m-%d')
 and t.RegState in ('K','B','A','DA','X','Q') and t.EntTypeCatg in ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
and t.IndustryPhy in('K') and t.IndustryCo = '7010'
and ((b.AssGro < 5000 and b.AssGro >= 0)
or (b.VENDINC < 1000 and b.VENDINC >= 0))
; 


/*
 企业已年报，是否小微判断
  16 
  物业管理	从业人员(X)	人	0≤X<300
	营业收入(Y)	人民币万元	0≤Y<1000
*/
INSERT INTO cs_sm_baseinfo (
	pripid,
	diryear,
	uniscid,
	regno,
	entname,
	enttypecatg,
	enttype,
	estDate,
	RegCap,
	regorg,
	industryphy,
	industryCo,
	dircreatetime,
	dircreatereason,
	dircreatereasoncode,
	createtime ,
  Year,
  AssgroIsp,
  ASSGRO,
  MaiBusincIsp,
  MAIBUSINC,
  EmpNumIsp,
  EmpNum

)

SELECT
	t.pripid,
	'2016' diryear,
	t.unicode,
	t.regno,
	t.entname,
	t.enttypecatg,
	t.enttype,
	t.estdate,
	t.regcap,
	t.regorg,
	t.industryphy,
	t.industryco,
	sysdate(),
	'上年度已年报的市场主体',
	'02',
	sysdate(),
  2015,
  b.AssGroIsPub,
  b.AssGro,
  b.MaiBusIncIsPub,
  b.MaiBusInc,
  b.EmpNumDis,
  b.EmpNum 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID and s.`Year` = 2015 
and t.PriPID = b.PriPID and b.`Year` = 2015
and s.IsReported <> '0'
-- and t.EstDate >= DATE_FORMAT('2016-01-01','%Y-%m-%d') and  t.EstDate < DATE_FORMAT('2016-01-01','%Y-%m-%d')
 and t.RegState in ('K','B','A','DA','X','Q') and t.EntTypeCatg in ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
and t.IndustryPhy in('K') and t.IndustryCo = '7020'
and ((b.VendInc < 1000 and b.VendInc >= 0)
or (b.EmpNum < 300 and b.EmpNum >= 0))
; 



/*
 企业已年报，是否小微判断
  17 
  租赁和商务服务业	从业人员(X)	人	0≤X<100
	资产总额(Z)	人民币万元	0≤Z<8000
*/

INSERT INTO cs_sm_baseinfo (
	pripid,
	diryear,
	uniscid,
	regno,
	entname,
	enttypecatg,
	enttype,
	estDate,
	RegCap,
	regorg,
	industryphy,
	industryCo,
	dircreatetime,
	dircreatereason,
	dircreatereasoncode,
	createtime ,
  Year,
  AssgroIsp,
  ASSGRO,
  MaiBusincIsp,
  MAIBUSINC,
  EmpNumIsp,
  EmpNum

)

SELECT
	t.pripid,
	'2016' diryear,
	t.unicode,
	t.regno,
	t.entname,
	t.enttypecatg,
	t.enttype,
	t.estdate,
	t.regcap,
	t.regorg,
	t.industryphy,
	t.industryco,
	sysdate(),
	'上年度已年报的市场主体',
	'02',
	sysdate(),
  2015,
  b.AssGroIsPub,
  b.AssGro,
  b.MaiBusIncIsPub,
  b.MaiBusInc,
  b.EmpNumDis,
  b.EmpNum 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID and s.`Year` = 2015 
and t.PriPID = b.PriPID and b.`Year` = 2015
and s.IsReported <> '0'
-- and t.EstDate >= DATE_FORMAT('2016-01-01','%Y-%m-%d') and  t.EstDate < DATE_FORMAT('2016-01-01','%Y-%m-%d')
 and t.RegState in ('K','B','A','DA','X','Q') and t.EntTypeCatg in ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
and t.IndustryPhy in('L')  
and ((b.AssGro < 8000 and b.AssGro >= 0)
or (b.EmpNum < 100 and b.EmpNum >= 0))
; 


/*
 企业已年报，是否小微判断
  18 
  其他未列明行业
房地产业
房地产中介服务
自有房地产经营活动
其他房地产业
  从业人员(X)	人	0≤X<100
*/
INSERT INTO cs_sm_baseinfo (
	pripid,
	diryear,
	uniscid,
	regno,
	entname,
	enttypecatg,
	enttype,
	estDate,
	RegCap,
	regorg,
	industryphy,
	industryCo,
	dircreatetime,
	dircreatereason,
	dircreatereasoncode,
	createtime ,
  Year,
  AssgroIsp,
  ASSGRO,
  MaiBusincIsp,
  MAIBUSINC,
  EmpNumIsp,
  EmpNum

)

SELECT
	t.pripid,
	'2016' diryear,
	t.unicode,
	t.regno,
	t.entname,
	t.enttypecatg,
	t.enttype,
	t.estdate,
	t.regcap,
	t.regorg,
	t.industryphy,
	t.industryco,
	sysdate(),
	'上年度已年报的市场主体',
	'02',
	sysdate(),
  2015,
  b.AssGroIsPub,
  b.AssGro,
  b.MaiBusIncIsPub,
  b.MaiBusInc,
  b.EmpNumDis,
  b.EmpNum 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID and s.`Year` = 2015 
and t.PriPID = b.PriPID and b.`Year` = 2015
and s.IsReported <> '0'
-- and t.EstDate >= DATE_FORMAT('2016-01-01','%Y-%m-%d') and  t.EstDate < DATE_FORMAT('2016-01-01','%Y-%m-%d')
 and t.RegState in ('K','B','A','DA','X','Q') and t.EntTypeCatg in ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
and t.IndustryPhy in('K') and t.IndustryCo in( '7000','7030','7040','7090')
and b.EmpNum < 100 and b.EmpNum >= 0
; 

/*
-- 其他
J     	金融业
M     	科学研究和技术服务业
N     	水利、环境和公共设施管理业
O     	居民服务、修理和其他服务业
P     	教育
Q     	卫生和社会工作
R     	文化、体育和娱乐业
S     	公共管理、社会保障和社会组织
T     	国际组织
*/

INSERT INTO cs_sm_baseinfo (
	pripid,
	diryear,
	uniscid,
	regno,
	entname,
	enttypecatg,
	enttype,
	estDate,
	RegCap,
	regorg,
	industryphy,
	industryCo,
	dircreatetime,
	dircreatereason,
	dircreatereasoncode,
	createtime ,
  Year,
  AssgroIsp,
  ASSGRO,
  MaiBusincIsp,
  MAIBUSINC,
  EmpNumIsp,
  EmpNum

)

SELECT
	t.pripid,
	'2016' diryear,
	t.unicode,
	t.regno,
	t.entname,
	t.enttypecatg,
	t.enttype,
	t.estdate,
	t.regcap,
	t.regorg,
	t.industryphy,
	t.industryco,
	sysdate(),
	'上年度已年报的市场主体',
	'02',
	sysdate(),
  2015,
  b.AssGroIsPub,
  b.AssGro,
  b.MaiBusIncIsPub,
  b.MaiBusInc,
  b.EmpNumDis,
  b.EmpNum 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID and s.`Year` = 2015 
and t.PriPID = b.PriPID and b.`Year` = 2015
and s.IsReported <> '0'
-- and t.EstDate >= DATE_FORMAT('2016-01-01','%Y-%m-%d') and  t.EstDate < DATE_FORMAT('2016-01-01','%Y-%m-%d')
 and t.RegState in ('K','B','A','DA','X','Q') and t.EntTypeCatg in ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
and t.IndustryPhy in('J','M','N','O','P','Q','R','S','T') 
and b.EmpNum < 100 and b.EmpNum >= 0
; 

-- SELECT count(*) from cs_sm_baseinfo where DirYear = 2016; -- 4638427

-- 增加删除非小微企业类型
delete from cs_sm_baseinfo where DirYear = '2016' and EntType not in(
'1000',
'1100',
'1110',
'1120',
'1121',
'1122',
'1123',
'1130',
'1140',
'1150',
'1151',
'1152',
'1153',
'1190',
'1200',
'1210',
'1211',
'1212',
'1213',
'1219',
'1220',
'1221',
'1222',
'1223',
'1229',
'2000',
'2100',
'2110',
'2120',
'2121',
'2122',
'2123',
'2130',
'2140',
'2150',
'2151',
'2152',
'2153',
'2190',
'2200',
'2210',
'2211',
'2212',
'2213',
'2219',
'2220',
'2221',
'2222',
'2223',
'2229',
'3000',
'3100',
'3200',
'3300',
'3400',
'3500',
'4000',
'4300',
'4310',
'4320',
'4330',
'4340',
'4400',
'4410',
'4420',
'4500',
'4530',
'4531',
'4532',
'4533',
'4540',
'4550',
'4551',
'4552',
'4553',
'4560',
'4600',
'4700',
'5000',
'5100',
'5110',
'5120',
'5130',
'5140',
'5150',
'5160',
'5190',
'5200',
'5210',
'5220',
'5230',
'5240',
'5290',
'5300',
'5310',
'5320',
'5390',
'5400',
'5410',
'5420',
'5430',
'5490',
'5800',
'5810',
'5820',
'5830',
'5840',
'5890',
'6000',
'6100',
'6110',
'6120',
'6130',
'6140',
'6150',
'6160',
'6170',
'6190',
'6200',
'6210',
'6220',
'6230',
'6240',
'6250',
'6260',
'6290',
'6300',
'6310',
'6320',
'6390',
'6400',
'6410',
'6420',
'6430',
'6490',
'6800',
'6810',
'6820',
'6830',
'6840',
'6890',
'7000',
'7100',
'7110',
'7120',
'7130',
'7190',
'7200',
'7300',
'7310',
'7390',
'9500',
'4900'
)
;


