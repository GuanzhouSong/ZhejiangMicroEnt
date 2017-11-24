package com.icinfo.cs.rpt.rptmodel;

/** 
 * 描述: 节点类
 * @author gqf
 * @date 2015年6月23日  
 */
public class CorpNode {
	private String name;
	private String label;
	private String nodeName;
	private String category;
	private String value;
	private String symbol;
	private String symbolSize;
	private String draggable;
	//样式
	private String itemStyleObj;
	
	private String corpid;
	private String certNo;//身份证
	//是否是自然人 1:法人，2自然人
	private String nodeType;//是否是自然人
	private String entNo;//注册号
	
	public String getNodeType() {
		return nodeType;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getSymbolSize() {
		return symbolSize;
	}
	public void setSymbolSize(String symbolSize) {
		this.symbolSize = symbolSize;
	}
	public String getDraggable() {
		return draggable;
	}
	public void setDraggable(String draggable) {
		this.draggable = draggable;
	}
	

	public String getItemStyleObj() {
		return itemStyleObj;
	}
	public void setItemStyleObj(String itemStyleObj) {
		this.itemStyleObj = itemStyleObj;
	}
	public String getCorpid() {
		return corpid;
	}
	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}
	public String getCertNo() {
		return certNo;
	}
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	public String getEntNo() {
		return entNo;
	}
	public void setEntNo(String entNo) {
		this.entNo = entNo;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public CorpNode(String name, String entNo, String corpid, String certNo, String nodeType ) {
		super();
		this.name = name;
		this.corpid = corpid;
		this.entNo = entNo;
		this.certNo = certNo;
		this.nodeType = nodeType;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	@Override
	public boolean equals(Object obj) {
		CorpNode tempNode = (CorpNode)obj;
		if(certNo!=null&&tempNode.getName().equals(this.name)&&tempNode.getNodeType().equals(nodeType)&&certNo.equals(tempNode.getCertNo())){
			 return true;     
		}
		return false;
	}
	@Override
	public int hashCode() {
		return certNo.hashCode()+name.hashCode();
	}
	
	
	

}
