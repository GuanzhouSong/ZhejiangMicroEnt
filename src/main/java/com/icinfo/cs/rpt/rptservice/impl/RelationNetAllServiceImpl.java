/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice.impl;

import com.icinfo.cs.common.utils.EntNameUtil;

import com.icinfo.cs.rpt.rptmapper.RelationNetAllMapper;
import com.icinfo.cs.rpt.rptmodel.CorpNode;
import com.icinfo.cs.rpt.rptmodel.RelationNetAll;
import com.icinfo.cs.rpt.rptservice.IRelationNetAllService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 描述:  cs_relation_net_all 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年07月12日
 */
@Service
public class RelationNetAllServiceImpl extends MyBatisServiceSupport implements IRelationNetAllService {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(RelationNetAllServiceImpl.class);

    @Autowired
    private RelationNetAllMapper relationNetAllMapper;


    //echarts版本
    private String vision = null;

    /**
     * 描述：根据内部序号查询 xml 并判断to_id不能为空
     * @param corpid
     * @return
     */
    public List<RelationNetAll> selectByFromId(String corpid){
        if(StringUtils.isNotBlank(corpid)){
           return   relationNetAllMapper.selectByCopid(corpid);
        }
        return null;
    }

    /**
     * 描述：根据内部序号查询
     * @param corpid
     * @return
     */
    public List<RelationNetAll> selectByToId(String corpid){
        if(StringUtils.isNotBlank(corpid)){
            return relationNetAllMapper.selectByToId(corpid);
        }
        return null;
    }

    /**
     * @return
     * @描述： 获取数据
     * @author: wangjin
     * @date 2017-07-12 16:02
     */
    @Override
   public Map<String, Object> select_result(PageRequest request) throws Exception {
        //获取参数值
        Map<String, Object> paramMap = request.getParams();

        String entName = paramMap.get("entName").toString();
        String corpid = paramMap.get("corpid").toString();
        int isGxcsSlt = Integer.parseInt((String) paramMap.get("isGxcsSlt"));//层级

        Map<String, Object> qryMap = new HashMap<String, Object>();
        qryMap.put("nbxh", corpid);
        List<String> nodeList = new ArrayList<String>();
        List<String> linkList = new ArrayList<String>();

        CorpNode rootNode = new CorpNode(entName,"",corpid,"","1");

        //节点集合
        List<CorpNode> nextNodeList = new ArrayList<CorpNode>();
        nextNodeList.add(rootNode);

            nodeList.add("{symbolSize: 30,category:0, name: '"+corpid+"',label:'"+EntNameUtil.getShortNameOfZj(entName)+"',nodeName:'"+entName+"',value : 10,corpid:'"+corpid+"'}");

        for(int i=0;i<isGxcsSlt;i++){//动态显示关系层数
            nextNodeList = doGetAllChidNodeAndLink(nextNodeList,nodeList,linkList);
            nextNodeList = removeDuplicateCorpNode(nextNodeList);
        }
        nodeList = removeDuplicate(nodeList);
        linkList = removeDuplicate(linkList);
        String str = null;

        for(int i=0;i<nodeList.size();i++){//寻找与第一层及重复企业
            if(nodeList.get(i).contains(corpid)&&nodeList.get(i).contains("category:2")){
                str = nodeList.get(i);
            }
        }
        nodeList.remove(str);
        qryMap.put("nodeList", nodeList);
        qryMap.put("linkList", linkList);
        return qryMap;

    }

    /**
     * 描述：业务逻辑判断
     * @param corpNodeList 节点集合
     * @param nodeList
     * @param linkList
     * @return
     */
    private List<CorpNode> doGetAllChidNodeAndLink(List<CorpNode> corpNodeList, List<String> nodeList,
                                                   List<String> linkList) throws Exception {
        List<CorpNode> tempNodeList = new ArrayList<CorpNode>();
        List<CorpNode> tempotherNodeList = new ArrayList<CorpNode>();
        List<RelationNetAll> relationNodeList = new ArrayList<RelationNetAll>();  //企业法定代表人、投资方、高管
        for (CorpNode corpNode : corpNodeList) {
            if ("1".equals(corpNode.getNodeType())) {//判断是否是法人
                tempNodeList.addAll(doGetCorpChildNodeAndLink(corpNode, tempotherNodeList, nodeList, linkList, relationNodeList));
            } else {
                if (null == corpNode.getCertNo() || "".equals(corpNode.getCertNo())) {
                    continue;
                }
                List<CorpNode> tempNodeListperson = doGetPersonalChildNodeAndLink(corpNode, tempotherNodeList, nodeList, linkList, relationNodeList);
                tempNodeList.addAll(tempNodeListperson);
            }
        }
        return tempNodeList;

    }

    /**
     * 描述：企业查询子关系业务逻辑
     * @param corpNode
     * @param corpNodeList
     * @param nodeList
     * @param linkList
     * @return
     * @throws Exception
     */
    public List<CorpNode> doGetCorpChildNodeAndLink(CorpNode corpNode,
                                                    List<CorpNode> corpNodeList,
                                                    List<String> nodeList,
                                                    List<String> linkList,
                                                    List<RelationNetAll> relationNodeList) throws Exception {
            relationNodeList = selectByFromId(corpNode.getCorpid());
        for (RelationNetAll rel : relationNodeList) {
            if (rel.getTo_type().equals("1")) {// 法人
                if(rel.getTo_name()==null) continue;
                nodeList.add("{category:2, name: '" +rel.getTo_id()+"',label:'"+EntNameUtil.getShortNameOfZj(rel.getTo_name())+"',nodeName:'"+ rel.getTo_name() + "',value : 2,corpid:'" + rel.getTo_id() + "'}");
                linkList.add(createLink(rel.getFrom_id(),rel.getFrom_name(),rel.getTo_id(),rel.getTo_name(),rel.getRelation_name(), doGetLineStyle(rel.getRelation_name())));
                corpNodeList.add(new CorpNode(rel.getTo_name(), "", rel.getTo_id(),"", rel.getTo_type()));
            } else {
                nodeList.add("{category:1, name: '"+rel.getTo_id()+"',label:'"+rel.getTo_name()+"',certNo:'"+rel.getTo_id()+"',nodeName:'" + rel.getTo_name() + "',value : 2}");
                linkList.add(createLink(rel.getFrom_id(),rel.getFrom_name(),rel.getTo_id(),rel.getTo_name(),  rel.getRelation_name(), doGetLineStyle(rel.getRelation_name())));
                corpNodeList.add(new CorpNode(rel.getTo_name(), "", "",rel.getTo_id(), rel.getTo_type()));
            }
        }
        relationNodeList.clear();
        return corpNodeList;
    }



    //自然人 循环取出法人关系，股东关系、高管关系
    private List<CorpNode> doGetPersonalChildNodeAndLink(
            CorpNode corpNode, List<CorpNode> corpNodeList, List<String> nodeList, List<String> linkList,List<RelationNetAll> relationNodeList) {
        relationNodeList = selectByToId(corpNode.getCertNo());

        for (RelationNetAll rel : relationNodeList) {
            nodeList.add("{category:2, name: '" +rel.getFrom_id()+"',label:'"+EntNameUtil.getShortNameOfZj(rel.getFrom_name())+"',nodeName:'"+ rel.getFrom_name() + "',value : 2,corpid:'" + rel.getFrom_id() + "'}");
            linkList.add(createLink(rel.getFrom_id(),rel.getFrom_name(),rel.getTo_id(),rel.getTo_name(),rel.getRelation_name(), doGetLineStyle(rel.getRelation_name())));
            corpNodeList.add(new CorpNode(rel.getFrom_name(),"", rel.getFrom_id(),"", "1"));
        }

        relationNodeList.clear();
        return corpNodeList;
    }






    /**
     * 描述: TODO
     * @auther gqf
     * @date 2015年6月25日
     * @param list
     * @return
     */
    List<String> removeDuplicate(List<String> list) {
        HashSet<String> hashSet = new HashSet<String>(list);
        list.clear();
        list.addAll(hashSet);
        return list;
    }


    /**
     * 工具类
     * @param source
     * @param sourceName
     * @param target
     * @param targetName
     * @param name
     * @param style
     * @return
     */
    public String createLink( String source,String sourceName,String target,String targetName, String name, String style){
        String link="{source : '"+source+"',sourceName:'"+sourceName+"', target :'"+target+"',targetName:'"+targetName+"', weight : 1, lineStyle: "+style+", relation: '"+name+"'}";
        return link;
    }

    public String removeKh(String name){
        if (name != null) {
            name = name.replace("(", "").replace("（", "").replace(")", "").replace("）", "");
        }
        return name;
    }


    /**
     * 描述: 对象相等
     * @auther gqf
     * @date 2015年6月25日
     * @param list
     * @return
     */

    List<CorpNode> removeDuplicateCorpNode(List<CorpNode> list){
        List<CorpNode> tempList= new ArrayList<CorpNode>();
        for(CorpNode tempNode:list){
            if(!tempList.contains(tempNode)) tempList.add(tempNode);
        }

        return tempList;
    }

    /**
     *@Description 获取关系网络对应关系样式
     *@author ylr
     *@date 2017-07-14
     */
    private String doGetLineStyle(String  relation){
        if("股东关系".equals(relation))
            return "{normal: {width: 1.5,color: 'red'}}";
        if("高管关系".equals(relation))
            return "{normal: {width: 1,color: 'blue'}}";
        if("法定代表人关系".equals(relation))
            return "{normal: {width: 2,color: 'maroon'}}";
        return "{normal: {width: 1,color: 'blue'}}";
    }


}