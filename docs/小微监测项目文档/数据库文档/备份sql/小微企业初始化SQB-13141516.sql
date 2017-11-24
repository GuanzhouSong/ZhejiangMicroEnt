TRUNCATE TABLE sm_baseinfo_his;
TRUNCATE TABLE sm_baseinfo;
-- ---新设----
/***
 * 初始化基本信息表
 * 1 获取新设立企业信息
 * 2 获取新设分支机构 
 */
INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	t.PriPID, 'XS' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2017' SmYear 
FROM cs_mid_baseinfo t 
WHERE t.EstDate >= DATE_FORMAT('2017-01-01','%Y-%m-%d') 
AND t.EstDate < DATE_FORMAT('2018-01-01','%Y-%m-%d') 
AND t.RegState IN ('K','B','A','DA','X','Q')
AND (
(t.EntType  IN ('1000','1100','1110','1120','1121','1122','1123','1130','1140','1150','1151','1152','1153','1190',
'1200','1210','1211','1212','1213','1219','1220','1221','1222','1223','1229',
'3000','3100','3200','3300','3400','3500',
'4530','4531','4532','4533','4540',
'4400','4410','4420','4600','4700',
'5000','5100','5110','5120','5130','5140','5150','5160','5190','5200','5210','5220','5230','5240','5290',
'6000','6100','6110','6120','6130','6140','6150','6160','6170','6190','6200','6210','6220','6230','6240','6250','6260','6290',
'5400','5410','5420','5430','5490','6400','6410','6420','6430','6490',
'7300','7310','7390',
'5300','5310','5320','5390','6300','6310','6320','6390'
)
AND RegCap > 0
AND RegCap <= 500
AND CurrencyCN = '元人民币' ) OR (t.EntTypeCatg IN('22','25','28','32','34'))
)
; 

-- ----年报-----------------
-- ------------------------------------------------------------------------------------------------------
/**
 企业已年报，是否小微判断
 已年报，农林牧渔
*/
INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2013' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2013 
AND t.PriPID = b.PriPID AND b.Year = 2013
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy = 'A'
AND b.VENDINC < 500 AND b.VendInc >= 0
; 

/**
 企业已年报，是否小微判断
 已年报，农林牧渔
*/
INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2014' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2014 
AND t.PriPID = b.PriPID AND b.Year = 2014
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy = 'A'
AND b.VENDINC < 500 AND b.VendInc >= 0
; 

/**
 企业已年报，是否小微判断
 已年报，农林牧渔
*/
INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2015' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2015 
AND t.PriPID = b.PriPID AND b.Year = 2015
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy = 'A'
AND b.VENDINC < 500 AND b.VendInc >= 0
; 

/**
 企业已年报，是否小微判断
 已年报，农林牧渔
*/
INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2016' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2016 
AND t.PriPID = b.PriPID AND b.Year = 2016
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy = 'A'
AND b.VENDINC < 500 AND b.VendInc >= 0
; 
-- ------------------------------------------------------------------------------------------------------

-- ------------------------------------------------------------------------------------------------------

/**
 企业已年报，是否小微判断
 工业，04
*/

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2013' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE
 t.PriPID = s.PriPID AND s.Year = 2013 
AND t.PriPID = b.PriPID AND b.Year = 2013
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('B','C','D' )
AND ((b.VENDINC < 2000 AND b.VendInc >= 0)
OR (b.EmpNum < 300 AND b.EmpNum >= 0))
; 

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2014' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE
 t.PriPID = s.PriPID AND s.Year = 2014 
AND t.PriPID = b.PriPID AND b.Year = 2014
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('B','C','D' )
AND ((b.VENDINC < 2000 AND b.VendInc >= 0)
OR (b.EmpNum < 300 AND b.EmpNum >= 0))
; 

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2015' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE
 t.PriPID = s.PriPID AND s.Year = 2015 
AND t.PriPID = b.PriPID AND b.Year = 2015
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('B','C','D' )
AND ((b.VENDINC < 2000 AND b.VendInc >= 0)
OR (b.EmpNum < 300 AND b.EmpNum >= 0))
; 


/**
 企业已年报，是否小微判断
 工业，04
*/

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2016' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE
 t.PriPID = s.PriPID AND s.Year = 2016 
AND t.PriPID = b.PriPID AND b.Year = 2016
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('B','C','D' )
AND ((b.VENDINC < 2000 AND b.VendInc >= 0)
OR (b.EmpNum < 300 AND b.EmpNum >= 0))
; 
-- ------------------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------

/**
 企业已年报，是否小微判断
 建筑业,05
 建筑业	营业收入(Y)	人民币万元	0≤Y<6000
	资产总额(Z)	人民币万元	0≤Z<5000
*/

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID  , '2013' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2013 
AND t.PriPID = b.PriPID AND b.Year = 2013
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('E' )
AND ((b.VENDINC < 6000 AND b.VendInc >= 0)
OR (b.ASSGRO < 5000 AND b.ASSGRO >= 0))
; 

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID  , '2014' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2014 
AND t.PriPID = b.PriPID AND b.Year = 2014
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('E' )
AND ((b.VENDINC < 6000 AND b.VendInc >= 0)
OR (b.ASSGRO < 5000 AND b.ASSGRO >= 0))
; 

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID  , '2015' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2015 
AND t.PriPID = b.PriPID AND b.Year = 2015
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('E' )
AND ((b.VENDINC < 6000 AND b.VendInc >= 0)
OR (b.ASSGRO < 5000 AND b.ASSGRO >= 0))
; 


INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID  , '2016' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2016 
AND t.PriPID = b.PriPID AND b.Year = 2016
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('E' )
AND ((b.VENDINC < 6000 AND b.VendInc >= 0)
OR (b.ASSGRO < 5000 AND b.ASSGRO >= 0))
; 

-- ------------------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------

/**
 企业已年报，是否小微判断
  06 批发业	从业人员(X)	人	0≤X<20
	营业收入(Y)	人民币万元	0≤Y<5000
*/

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2013' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE
t.PriPID = s.PriPID AND s.Year = 2013 
AND t.PriPID = b.PriPID AND b.Year = 2013
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('F' ) AND t.IndustryCo LIKE '51%'
AND ((b.VENDINC < 5000 AND b.VendInc >= 0)
OR (b.EmpNum < 20 AND b.EmpNum >= 0))
; 


INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2014' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE
t.PriPID = s.PriPID AND s.Year = 2014 
AND t.PriPID = b.PriPID AND b.Year = 2014
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('F' ) AND t.IndustryCo LIKE '51%'
AND ((b.VENDINC < 5000 AND b.VendInc >= 0)
OR (b.EmpNum < 20 AND b.EmpNum >= 0))
; 


INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2015' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE
t.PriPID = s.PriPID AND s.Year = 2015 
AND t.PriPID = b.PriPID AND b.Year = 2015
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('F' ) AND t.IndustryCo LIKE '51%'
AND ((b.VENDINC < 5000 AND b.VendInc >= 0)
OR (b.EmpNum < 20 AND b.EmpNum >= 0))
; 

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2016' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE
t.PriPID = s.PriPID AND s.Year = 2016 
AND t.PriPID = b.PriPID AND b.Year = 2016
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('F' ) AND t.IndustryCo LIKE '51%'
AND ((b.VENDINC < 5000 AND b.VendInc >= 0)
OR (b.EmpNum < 20 AND b.EmpNum >= 0))
; 
-- ------------------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------


/**
 企业已年报，是否小微判断
  07 零售业	从业人员(X)	人	0≤X<50
	营业收入(Y)	人民币万元	0≤Y<500
*/

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2013' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE
t.PriPID = s.PriPID AND s.Year = 2013 
AND t.PriPID = b.PriPID AND b.Year = 2013
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('F' ) AND t.IndustryCo LIKE '52%'
AND ((b.VENDINC < 500 AND b.VendInc >= 0)
OR (b.EmpNum < 50 AND b.EmpNum >= 0))
; 


INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2014' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE
t.PriPID = s.PriPID AND s.Year = 2014 
AND t.PriPID = b.PriPID AND b.Year = 2014
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('F' ) AND t.IndustryCo LIKE '52%'
AND ((b.VENDINC < 500 AND b.VendInc >= 0)
OR (b.EmpNum < 50 AND b.EmpNum >= 0))
; 


INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2015' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE
t.PriPID = s.PriPID AND s.Year = 2015 
AND t.PriPID = b.PriPID AND b.Year = 2015
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('F' ) AND t.IndustryCo LIKE '52%'
AND ((b.VENDINC < 500 AND b.VendInc >= 0)
OR (b.EmpNum < 50 AND b.EmpNum >= 0))
; 

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2016' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE
t.PriPID = s.PriPID AND s.Year = 2016 
AND t.PriPID = b.PriPID AND b.Year = 2016
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('F' ) AND t.IndustryCo LIKE '52%'
AND ((b.VENDINC < 500 AND b.VendInc >= 0)
OR (b.EmpNum < 50 AND b.EmpNum >= 0))
; 

-- ------------------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------
/**
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
INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID  , '2013' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE
 t.PriPID = s.PriPID AND s.Year = 2013
AND t.PriPID = b.PriPID AND b.Year = 2013
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('G') AND SUBSTR(t.IndustryCo,1,2) IN ('53','54','55','56','57','58') 
AND ((b.VENDINC < 3000 AND b.VendInc >= 0)
OR (b.EmpNum < 300 AND b.EmpNum >= 0))
; 

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID  , '2014' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE
 t.PriPID = s.PriPID AND s.Year = 2014
AND t.PriPID = b.PriPID AND b.Year = 2014
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('G') AND SUBSTR(t.IndustryCo,1,2) IN ('53','54','55','56','57','58') 
AND ((b.VENDINC < 3000 AND b.VendInc >= 0)
OR (b.EmpNum < 300 AND b.EmpNum >= 0))
; 

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID  , '2015' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE
 t.PriPID = s.PriPID AND s.Year = 2015
AND t.PriPID = b.PriPID AND b.Year = 2015
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('G') AND SUBSTR(t.IndustryCo,1,2) IN ('53','54','55','56','57','58') 
AND ((b.VENDINC < 3000 AND b.VendInc >= 0)
OR (b.EmpNum < 300 AND b.EmpNum >= 0))
; 

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID  , '2016' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE
 t.PriPID = s.PriPID AND s.Year = 2016 
AND t.PriPID = b.PriPID AND b.Year = 2016
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('G') AND SUBSTR(t.IndustryCo,1,2) IN ('53','54','55','56','57','58') 
AND ((b.VENDINC < 3000 AND b.VendInc >= 0)
OR (b.EmpNum < 300 AND b.EmpNum >= 0))
; 

-- ------------------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------

/**
 企业已年报，是否小微判断
  09 G59   	仓储业 
  仓储业	从业人员(X)	人	0≤X<100
	营业收入(Y)	人民币万元	0≤Y<1000
*/

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2013' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

t.PriPID = s.PriPID AND s.Year = 2013 
AND t.PriPID = b.PriPID AND b.Year = 2013
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('G') AND SUBSTR(t.IndustryCo,1,2) = ('59') 
AND ((b.VENDINC < 1000 AND b.VendInc >= 0)
OR (b.EmpNum < 100 AND b.EmpNum >= 0))
;

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2014' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

t.PriPID = s.PriPID AND s.Year = 2014 
AND t.PriPID = b.PriPID AND b.Year = 2014
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('G') AND SUBSTR(t.IndustryCo,1,2) = ('59') 
AND ((b.VENDINC < 1000 AND b.VendInc >= 0)
OR (b.EmpNum < 100 AND b.EmpNum >= 0))
;

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2015' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

t.PriPID = s.PriPID AND s.Year = 2015 
AND t.PriPID = b.PriPID AND b.Year = 2015
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('G') AND SUBSTR(t.IndustryCo,1,2) = ('59') 
AND ((b.VENDINC < 1000 AND b.VendInc >= 0)
OR (b.EmpNum < 100 AND b.EmpNum >= 0))
;

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2016' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

t.PriPID = s.PriPID AND s.Year = 2016 
AND t.PriPID = b.PriPID AND b.Year = 2016
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('G') AND SUBSTR(t.IndustryCo,1,2) = ('59') 
AND ((b.VENDINC < 1000 AND b.VendInc >= 0)
OR (b.EmpNum < 100 AND b.EmpNum >= 0))
;

-- ------------------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------

/**
 企业已年报，是否小微判断
  10 
  邮政业	从业人员(X)	人	0≤X<300
	营业收入(Y)	人民币万元	0≤Y<2000
*/

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2013' SmYear   
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE
 t.PriPID = s.PriPID AND s.Year = 2013 
AND t.PriPID = b.PriPID AND b.Year = 2013 
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('G') AND SUBSTR(t.IndustryCo,1,2) = ('60') 
AND ((b.VENDINC < 2000 AND b.VendInc >= 0)
OR (b.EmpNum < 300 AND b.EmpNum >= 0))
; 

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2014' SmYear   
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE
 t.PriPID = s.PriPID AND s.Year = 2014 
AND t.PriPID = b.PriPID AND b.Year = 2014 
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('G') AND SUBSTR(t.IndustryCo,1,2) = ('60') 
AND ((b.VENDINC < 2000 AND b.VendInc >= 0)
OR (b.EmpNum < 300 AND b.EmpNum >= 0))
; 

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2015' SmYear   
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE
 t.PriPID = s.PriPID AND s.Year = 2015 
AND t.PriPID = b.PriPID AND b.Year = 2015 
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('G') AND SUBSTR(t.IndustryCo,1,2) = ('60') 
AND ((b.VENDINC < 2000 AND b.VendInc >= 0)
OR (b.EmpNum < 300 AND b.EmpNum >= 0))
; 

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID  , '2016' SmYear  
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE
 t.PriPID = s.PriPID AND s.Year = 2016 
AND t.PriPID = b.PriPID AND b.Year = 2016
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('G') AND SUBSTR(t.IndustryCo,1,2) = ('60') 
AND ((b.VENDINC < 2000 AND b.VendInc >= 0)
OR (b.EmpNum < 300 AND b.EmpNum >= 0))
; 
-- ------------------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------


/**
 企业已年报，是否小微判断
  11 
  住宿业	从业人员(X)	人	0≤X<100
	营业收入(Y)	人民币万元	0≤Y<2000
*/

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2013' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2013 
AND t.PriPID = b.PriPID AND b.Year = 2013 
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('H') AND SUBSTR(t.IndustryCo,1,2) = ('61') 
AND ((b.VENDINC < 2000 AND b.VendInc >= 0)
OR (b.EmpNum < 100 AND b.EmpNum >= 0))
; 

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2014' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2014 
AND t.PriPID = b.PriPID AND b.Year = 2014 
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('H') AND SUBSTR(t.IndustryCo,1,2) = ('61') 
AND ((b.VENDINC < 2000 AND b.VendInc >= 0)
OR (b.EmpNum < 100 AND b.EmpNum >= 0))
; 

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2015' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2015 
AND t.PriPID = b.PriPID AND b.Year = 2015 
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('H') AND SUBSTR(t.IndustryCo,1,2) = ('61') 
AND ((b.VENDINC < 2000 AND b.VendInc >= 0)
OR (b.EmpNum < 100 AND b.EmpNum >= 0))
; 

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2016' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2016 
AND t.PriPID = b.PriPID AND b.Year = 2016
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('H') AND SUBSTR(t.IndustryCo,1,2) = ('61') 
AND ((b.VENDINC < 2000 AND b.VendInc >= 0)
OR (b.EmpNum < 100 AND b.EmpNum >= 0))
; 

-- ------------------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------

/**
 企业已年报，是否小微判断
  12 
  餐饮业	从业人员(X)	人	0≤X<100
	营业收入(Y)	人民币万元	0≤Y<2000
*/

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2013' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2013 
AND t.PriPID = b.PriPID AND b.Year = 2013
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('H') AND SUBSTR(t.IndustryCo,1,2) = ('62') 
AND ((b.VENDINC < 2000 AND b.VendInc >= 0)
OR (b.EmpNum < 100 AND b.EmpNum >= 0))
; 

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2014' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2014 
AND t.PriPID = b.PriPID AND b.Year = 2014
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('H') AND SUBSTR(t.IndustryCo,1,2) = ('62') 
AND ((b.VENDINC < 2000 AND b.VendInc >= 0)
OR (b.EmpNum < 100 AND b.EmpNum >= 0))
; 

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2015' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2015 
AND t.PriPID = b.PriPID AND b.Year = 2015
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('H') AND SUBSTR(t.IndustryCo,1,2) = ('62') 
AND ((b.VENDINC < 2000 AND b.VendInc >= 0)
OR (b.EmpNum < 100 AND b.EmpNum >= 0))
; 

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2016' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2016 
AND t.PriPID = b.PriPID AND b.Year = 2016
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('H') AND SUBSTR(t.IndustryCo,1,2) = ('62') 
AND ((b.VENDINC < 2000 AND b.VendInc >= 0)
OR (b.EmpNum < 100 AND b.EmpNum >= 0))
; 

-- ------------------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------

/**
 企业已年报，是否小微判断
  13 
  信息传输业	从业人员(X)	人	0≤X<100
	营业收入(Y)	人民币万元	0≤Y<1000
*/
INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2013' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2013 
AND t.PriPID = b.PriPID AND b.Year = 2013
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('I') AND SUBSTR(t.IndustryCo,1,2) IN ('63','64') 
AND ((b.VENDINC < 1000 AND b.VendInc >= 0)
OR (b.EmpNum < 100 AND b.EmpNum >= 0))
;


INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2014' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2014
AND t.PriPID = b.PriPID AND b.Year = 2014
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('I') AND SUBSTR(t.IndustryCo,1,2) IN ('63','64') 
AND ((b.VENDINC < 1000 AND b.VendInc >= 0)
OR (b.EmpNum < 100 AND b.EmpNum >= 0))
;


INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2015' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2015 
AND t.PriPID = b.PriPID AND b.Year = 2015
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('I') AND SUBSTR(t.IndustryCo,1,2) IN ('63','64') 
AND ((b.VENDINC < 1000 AND b.VendInc >= 0)
OR (b.EmpNum < 100 AND b.EmpNum >= 0))
;

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2016' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2016 
AND t.PriPID = b.PriPID AND b.Year = 2016
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('I') AND SUBSTR(t.IndustryCo,1,2) IN ('63','64') 
AND ((b.VENDINC < 1000 AND b.VendInc >= 0)
OR (b.EmpNum < 100 AND b.EmpNum >= 0))
;

-- ------------------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------

/**
 企业已年报，是否小微判断
  14 
  软件和信息技术服务业	从业人员(X)	人	0≤X<100
	营业收入(Y)	人民币万元	0≤Y<1000
*/

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2013' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2013 
AND t.PriPID = b.PriPID AND b.Year = 2013
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('I') AND SUBSTR(t.IndustryCo,1,2) = ('65') 
AND ((b.VENDINC < 1000 AND b.VendInc >= 0)
OR (b.EmpNum < 100 AND b.EmpNum >= 0))
; 


INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2014' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2014 
AND t.PriPID = b.PriPID AND b.Year = 2014
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('I') AND SUBSTR(t.IndustryCo,1,2) = ('65') 
AND ((b.VENDINC < 1000 AND b.VendInc >= 0)
OR (b.EmpNum < 100 AND b.EmpNum >= 0))
; 


INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2015' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2015 
AND t.PriPID = b.PriPID AND b.Year = 2015
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('I') AND SUBSTR(t.IndustryCo,1,2) = ('65') 
AND ((b.VENDINC < 1000 AND b.VendInc >= 0)
OR (b.EmpNum < 100 AND b.EmpNum >= 0))
; 

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2016' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2016
AND t.PriPID = b.PriPID AND b.Year = 2016
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('I') AND SUBSTR(t.IndustryCo,1,2) = ('65') 
AND ((b.VENDINC < 1000 AND b.VendInc >= 0)
OR (b.EmpNum < 100 AND b.EmpNum >= 0))
; 

-- ------------------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------

/**
 企业已年报，是否小微判断
  15 
  房地产开发经营	营业收入(Y)	人民币万元	0≤Y<1000
	资产总额(Z)	人民币万元	0≤Z<5000
*/
INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2013' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2013 
AND t.PriPID = b.PriPID AND b.Year = 2013
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('K') AND t.IndustryCo = '7010'
AND ((b.AssGro < 5000 AND b.AssGro >= 0)
OR (b.VENDINC < 1000 AND b.VENDINC >= 0))
;


INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2014' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2014 
AND t.PriPID = b.PriPID AND b.Year = 2014
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('K') AND t.IndustryCo = '7010'
AND ((b.AssGro < 5000 AND b.AssGro >= 0)
OR (b.VENDINC < 1000 AND b.VENDINC >= 0))
;


INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2015' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2015 
AND t.PriPID = b.PriPID AND b.Year = 2015
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('K') AND t.IndustryCo = '7010'
AND ((b.AssGro < 5000 AND b.AssGro >= 0)
OR (b.VENDINC < 1000 AND b.VENDINC >= 0))
;

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2016' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2016 
AND t.PriPID = b.PriPID AND b.Year = 2016
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('K') AND t.IndustryCo = '7010'
AND ((b.AssGro < 5000 AND b.AssGro >= 0)
OR (b.VENDINC < 1000 AND b.VENDINC >= 0))
;

-- ------------------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------

/**
 企业已年报，是否小微判断
  16 
  物业管理	从业人员(X)	人	0≤X<300
	营业收入(Y)	人民币万元	0≤Y<1000
*/
INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2013' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2013 
AND t.PriPID = b.PriPID AND b.Year = 2013
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('K') AND t.IndustryCo = '7020'
AND ((b.VendInc < 1000 AND b.VendInc >= 0)
OR (b.EmpNum < 300 AND b.EmpNum >= 0))
; 

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2014' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2014 
AND t.PriPID = b.PriPID AND b.Year = 2014
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('K') AND t.IndustryCo = '7020'
AND ((b.VendInc < 1000 AND b.VendInc >= 0)
OR (b.EmpNum < 300 AND b.EmpNum >= 0))
; 


INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2015' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2015 
AND t.PriPID = b.PriPID AND b.Year = 2015
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('K') AND t.IndustryCo = '7020'
AND ((b.VendInc < 1000 AND b.VendInc >= 0)
OR (b.EmpNum < 300 AND b.EmpNum >= 0))
; 

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2016' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2016 
AND t.PriPID = b.PriPID AND b.Year = 2016
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('K') AND t.IndustryCo = '7020'
AND ((b.VendInc < 1000 AND b.VendInc >= 0)
OR (b.EmpNum < 300 AND b.EmpNum >= 0))
; 

-- ------------------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------

/**
 企业已年报，是否小微判断
  17 
  租赁和商务服务业	从业人员(X)	人	0≤X<100
	资产总额(Z)	人民币万元	0≤Z<8000
*/

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2013' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2013 
AND t.PriPID = b.PriPID AND b.Year = 2013
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('L')  
AND ((b.AssGro < 8000 AND b.AssGro >= 0)
OR (b.EmpNum < 100 AND b.EmpNum >= 0))
; 


INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2014' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2014 
AND t.PriPID = b.PriPID AND b.Year = 2014
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('L')  
AND ((b.AssGro < 8000 AND b.AssGro >= 0)
OR (b.EmpNum < 100 AND b.EmpNum >= 0))
; 


INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2015' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2015 
AND t.PriPID = b.PriPID AND b.Year = 2015
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('L')  
AND ((b.AssGro < 8000 AND b.AssGro >= 0)
OR (b.EmpNum < 100 AND b.EmpNum >= 0))
; 

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2016' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2016 
AND t.PriPID = b.PriPID AND b.Year = 2016
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('L')  
AND ((b.AssGro < 8000 AND b.AssGro >= 0)
OR (b.EmpNum < 100 AND b.EmpNum >= 0))
; 

-- ------------------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------

/**
 企业已年报，是否小微判断
  18 
  其他未列明行业
房地产业
房地产中介服务
自有房地产经营活动
其他房地产业
  从业人员(X)	人	0≤X<100
*/

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2013' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2013
AND t.PriPID = b.PriPID AND b.Year = 2013
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('K') AND t.IndustryCo IN( '7000','7030','7040','7090')
AND b.EmpNum < 100 AND b.EmpNum >= 0
;


INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2014' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2014
AND t.PriPID = b.PriPID AND b.Year = 2014
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('K') AND t.IndustryCo IN( '7000','7030','7040','7090')
AND b.EmpNum < 100 AND b.EmpNum >= 0
;


INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2015' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2015
AND t.PriPID = b.PriPID AND b.Year = 2015
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('K') AND t.IndustryCo IN( '7000','7030','7040','7090')
AND b.EmpNum < 100 AND b.EmpNum >= 0
;

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2016' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2016 
AND t.PriPID = b.PriPID AND b.Year = 2016
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('K') AND t.IndustryCo IN( '7000','7030','7040','7090')
AND b.EmpNum < 100 AND b.EmpNum >= 0
;

-- ------------------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------

/**
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

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2013' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2013 
AND t.PriPID = b.PriPID AND b.Year = 2013
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('J','M','N','O','P','Q','R','S','T') 
AND b.EmpNum < 100 AND b.EmpNum >= 0
; 

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2014' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2014 
AND t.PriPID = b.PriPID AND b.Year = 2014
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('J','M','N','O','P','Q','R','S','T') 
AND b.EmpNum < 100 AND b.EmpNum >= 0
; 

INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2015' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2015 
AND t.PriPID = b.PriPID AND b.Year = 2015
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('J','M','N','O','P','Q','R','S','T') 
AND b.EmpNum < 100 AND b.EmpNum >= 0
; 


INSERT INTO 
	sm_baseinfo (PriPID, SmentReason, IsSment, UID , SmYear )
SELECT
	s.PriPID, 'ZC' SmentReason,'1' IsSment ,REPLACE(UUID(),'-','') UID , '2016' SmYear 
FROM
	cs_mid_baseinfo t,
	cs_yr_reg_check s,
	cs_yr_asset b
WHERE

 t.PriPID = s.PriPID AND s.Year = 2016 
AND t.PriPID = b.PriPID AND b.Year = 2016
AND s.IsReported <> '0'
AND t.RegState IN ('K','B','A','DA','X','Q') AND t.EntTypeCatg IN ('11','12','13','14','31','32','33','34','21','22','24','27','28','50','16','17')
AND t.IndustryPhy IN('J','M','N','O','P','Q','R','S','T') 
AND b.EmpNum < 100 AND b.EmpNum >= 0
; 

-- ------------------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------

-- 增加删除非小微企业类型
DELETE FROM sm_baseinfo WHERE EntType NOT IN(
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


-- ---------更新列-----------------------

UPDATE sm_baseinfo S,cs_mid_baseinfo B
SET 
 
	S.EntName = B.EntName, 
	S.RegNO = B.RegNO ,	
	S.Dom = B.Dom , 
	S.LeRep = B.LeRep , 
	S.RegCap = B.RegCap,
	S.EntType = B.EntType ,
	S.EstDate = B.EstDate, 
	S.IndustryCo = B.IndustryCo, 
	S.RegOrg = B.RegOrg,
	S.IndustryPhy = B.IndustryPhy,
	S.RegState = B.RegState , 
	S.RegCapUSD = B.RegCapUSD ,
	S.UNICODE = B.UNICODE , 
	S.PostalCode = B.PostalCode ,
	S.OpFrom = B.OpFrom ,
	S.OpTo = B.OpTo ,
	S.Currency = B.Currency ,
	S.Tel = B.Tel ,
	S.Email = B.Email ,
	S.ApprDate = B.ApprDate ,
	S.AltDate = B.AltDate ,
	S.CurrencyCn = B.CurrencyCn ,
	S.OpForm = B.OpForm , 
	S.OpScope = B.OpScope ,
	S.EntTypeCatg = B.EntTypeCatg , 
	S.RegOrgName = B.RegOrgName ,
	S.LocalAdm = B.LocalAdm ,
	S.LocalAdmName = B.LocalAdmName ,
	S.SliceNO = B.SliceNO ,
	S.SliceNOName = B.SliceNOName ,
	S.CerNO = B.CerNO ,
	S.EmpNum = B.EmpNum
WHERE
	S.pripid = B.pripid
	;



DELETE   FROM sm_baseinfo WHERE id IN  (SELECT id FROM ((SELECT MIN(id) AS id FROM sm_baseinfo GROUP BY pripid HAVING COUNT(1) > 1)) T );
DELETE   FROM sm_baseinfo WHERE id IN  (SELECT id FROM ((SELECT MIN(id) AS id FROM sm_baseinfo GROUP BY pripid HAVING COUNT(1) > 1)) T );
DELETE   FROM sm_baseinfo WHERE id IN  (SELECT id FROM ((SELECT MIN(id) AS id FROM sm_baseinfo GROUP BY pripid HAVING COUNT(1) > 1)) T );
DELETE   FROM sm_baseinfo WHERE id IN  (SELECT id FROM ((SELECT MIN(id) AS id FROM sm_baseinfo GROUP BY pripid HAVING COUNT(1) > 1)) T );
DELETE   FROM sm_baseinfo WHERE id IN  (SELECT id FROM ((SELECT MIN(id) AS id FROM sm_baseinfo GROUP BY pripid HAVING COUNT(1) > 1)) T );
DELETE   FROM sm_baseinfo WHERE id IN  (SELECT id FROM ((SELECT MIN(id) AS id FROM sm_baseinfo GROUP BY pripid HAVING COUNT(1) > 1)) T );
DELETE   FROM sm_baseinfo WHERE id IN  (SELECT id FROM ((SELECT MIN(id) AS id FROM sm_baseinfo GROUP BY pripid HAVING COUNT(1) > 1)) T );




INSERT INTO sm_baseinfo_his (uid,PriPID,SmentReason,HisReason)
SELECT REPLACE(UUID(),'-','') UID ,PriPID,SmentReason,'INSERT' HisReason FROM sm_baseinfo;


