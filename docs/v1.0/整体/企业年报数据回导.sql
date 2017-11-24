/* 数据回导 */
/* 把原主体身份代码更新成新的主体身份代码 */
-- =============================================================================
-- 数据回导，企业pripid有修改后，以前的历史年报数据会无法关联，需要统一处理，目前只有企业数据。
-- 删除该企业年报主表cs_yr_reg_check多余数据，保留有年报记录和所有年份（比如13、14、15年已年报记录，还有16年未年报记录）
-- 删除该企业新的重复年报记录（比如企业宁波13、14、15年已年报，迁移到杭州又报了13年，需要先删除杭州报送的13年年报记录）
-- 数据核对完成后，执行以下回导语句
-- =============================================================================

-- 设定注册号
SET @regno ='330184000094093';

-- 企业新的内部序号 ，可以手工修改。
SET @newPripid = (SELECT pripid FROM cs_mid_baseinfo WHERE regstate='K' AND regno = @regno LIMIT 1);
-- 企业旧的内部序号，可以手工修改。
SET @oldPripid = (SELECT pripid FROM cs_yr_reg_check WHERE regno = @regno LIMIT 1);
-- 查看注册号、新主题身份代码、旧主题身份代码看有没问题，有问题的话就手动输入
SELECT @regno,@newPripid,@oldPripid ,LENGTH(@newPripid),LENGTH(@oldPripid);

SELECT '回导开始',SYSDATE() ;

-- 删除迁移后年报记录，这里只是登陆后初始化的一条数据，如果已重新报送了，需要手动删除剩余记录
DELETE FROM cs_yr_form WHERE PriPID = @newPripid AND YEAR=2013 AND IFNULL(@oldPripid,'')<>'' AND IFNULL(@newPripid,'')<>'' ;
DELETE FROM cs_yr_baseinfo WHERE PriPID = @newPripid AND YEAR=2013 AND IFNULL(@oldPripid,'')<>'' AND IFNULL(@newPripid,'')<>'' ;

UPDATE cs_yr_reg_check SET PriPID = @newPripid WHERE PriPID = @oldPripid AND IFNULL(@oldPripid,'')<>'' AND IFNULL(@newPripid,'')<>'' ;

UPDATE cs_yr_form SET PriPID = @newPripid WHERE PriPID = @oldPripid AND IFNULL(@oldPripid,'')<>'' AND IFNULL(@newPripid,'')<>'' ;

UPDATE cs_yr_baseinfo SET PriPID = @newPripid WHERE PriPID = @oldPripid AND IFNULL(@oldPripid,'')<>'' AND IFNULL(@newPripid,'')<>'' ;

UPDATE cs_yr_asset SET PriPID = @newPripid WHERE PriPID = @oldPripid AND IFNULL(@oldPripid,'')<>'' AND IFNULL(@newPripid,'')<>'' ;

UPDATE cs_yr_otherinfo SET PriPID = @newPripid WHERE PriPID = @oldPripid AND IFNULL(@oldPripid,'')<>'' AND IFNULL(@newPripid,'')<>'' ;

UPDATE cs_yr_subcapital SET PriPID = @newPripid WHERE PriPID = @oldPripid AND IFNULL(@oldPripid,'')<>'' AND IFNULL(@newPripid,'')<>'' ;

UPDATE cs_yr_websiteinfo SET PriPID = @newPripid WHERE PriPID = @oldPripid AND IFNULL(@oldPripid,'')<>'' AND IFNULL(@newPripid,'')<>'' ;

UPDATE cs_yr_alterstockinfo SET PriPID = @newPripid WHERE PriPID = @oldPripid AND IFNULL(@oldPripid,'')<>'' AND IFNULL(@newPripid,'')<>'' ;

UPDATE cs_yr_forguaranteeinfo SET PriPID = @newPripid WHERE PriPID = @oldPripid AND IFNULL(@oldPripid,'')<>'' AND IFNULL(@newPripid,'')<>'' ;

UPDATE cs_yr_social_security SET PriPID = @newPripid WHERE PriPID = @oldPripid AND IFNULL(@oldPripid,'')<>'' AND IFNULL(@newPripid,'')<>'' ;

UPDATE cs_baseinfo SET PriPID = @newPripid WHERE PriPID = @oldPripid AND IFNULL(@oldPripid,'')<>'' AND IFNULL(@newPripid,'')<>'' ;

UPDATE cs_pub_eppassword SET PriPID = @newPripid WHERE PriPID = @oldPripid AND IFNULL(@oldPripid,'')<>'' AND IFNULL(@newPripid,'')<>'' ;

SELECT '回导结束',SYSDATE() ;