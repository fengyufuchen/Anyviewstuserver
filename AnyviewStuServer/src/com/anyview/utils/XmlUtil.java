/**   
* @Title: XmlUtil.java 
* @Package com.anyview.utils 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 何凡 <piaobo749@qq.com>   
* @date 2015年11月3日 上午12:26:14 
* @version V1.0   
*/
package com.anyview.utils;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.anyview.entities.ChoiceOptionsVO;
import com.anyview.entities.FileMsgVO;
import com.anyview.entities.ProblemContentVO;

/** 
 * @ClassName: XmlUtil 
 * @Description: TODO(生成和解析xml) 
 * @author 何凡 <piaobo749@qq.com>
 * @date 2015年11月3日 上午12:26:14 
 *  
 */
public class XmlUtil{
	
	public static Log log = LogFactory.getLog(XmlUtil.class);
	/**
	 * @Description: TODO(创建程序题xml) 
	 * @param problemContent
	 * @author 何凡 <piaobo749@qq.com>
	 * @date 2015年11月3日 上午12:36:14
	 */
	public static Document createProgramXML(ProblemContentVO problemContent){
		Document document = DocumentHelper.createDocument();
		//根节点
		Element root = document.addElement("program");
		//主文件结点
		Element mainFile = root.addElement("mainFile");
		mainFile.addAttribute("fileName", problemContent.getMainFile().getFileName());
		mainFile.setText(problemContent.getMainFile().getFileContent());
		//用户文件结点
		Element userFile = root.addElement("userFile");
		userFile.addAttribute("fileName", problemContent.getUserFile().getFileName());
		userFile.setText(problemContent.getUserFile().getFileContent());
		//答案文件结点
		Element answerFile = root.addElement("answerFile");
		answerFile.addAttribute("fileName", problemContent.getAnswerFile().getFileName());
		answerFile.setText(problemContent.getAnswerFile().getFileContent());
		//程序题内容结点
		Element programContent = root.addElement("programContent");
		programContent.setText(problemContent.getProgramContent());
		//程序题文档结点
		Element programDocument = root.addElement("document");
		programDocument.setText(problemContent.getDocument());
		//头文件结点（含多个头文件子结点）
		Element headFiles = root.addElement("headFiles");
		for(FileMsgVO f : problemContent.getHeadFiles()){
			Element headFile = headFiles.addElement("headFile");
			headFile.addAttribute("fileName", f.getFileName());
			headFile.setText(f.getFileContent());
		}
		return document;
	}
	
	/**
	 * 
	 * @Description: TODO(创建选择题xml) 
	 * @param problemContent
	 * @param 是否是单选
	 * @return
	 * @author 何凡 <piaobo749@qq.com>
	 * @date 2015年11月3日 上午1:53:54
	 */
	public static Document createChoiceXML(ProblemContentVO problemContent, Boolean isSingle){
		String contextText = "";
		List<ChoiceOptionsVO> optionsList = null;
		if(isSingle){
			contextText = problemContent.getSingleContent();
			optionsList = problemContent.getSingleOptions();
		}else{
			contextText = problemContent.getMultipleContent();
			optionsList = problemContent.getMultipleOptions();
		}
		Document document = DocumentHelper.createDocument();
		//根节点
		Element root = document.addElement("choice");
		//选择题题干
		Element choiceContent = root.addElement("choiceContent");
		choiceContent.setText(contextText);
		//选择题选项
		Element options = root.addElement("options");
		for(ChoiceOptionsVO c : optionsList){
			Element option = options.addElement("option");
			//选项正确性作为结点的属性
			option.addAttribute("isRight", c.getIsRight().toString());
			//选项序号为属性
			option.addAttribute("sequence", c.getSequence());
			option.setText(c.getOptContent());
		}
		return document;
	}
	
	/**
	 * 
	 * @Description: TODO(创建判断题xml) 
	 * @param problemContent
	 * @return
	 * @author 何凡 <piaobo749@qq.com>
	 * @date 2015年11月3日 上午2:45:03
	 */
	public static Document createJudgmentXML(ProblemContentVO problemContent){
		Document document = DocumentHelper.createDocument();
		//根节点
		Element root = document.addElement("judgment");
		root.setText(problemContent.getJudgmentContent());
		//正确性作为属性
		root.addAttribute("isRight", problemContent.getIsRight().toString());
		return document;
	}
	
	/**
	 * 
	 * @Description: TODO(创建题目提示xml) 
	 * @param ptip
	 * @return
	 * @author 何凡 <piaobo749@qq.com>
	 * @date 2015年11月3日 上午3:36:26
	 */
	public static Document createTipXML(String ptip){
		Document document = DocumentHelper.createDocument();
		//根节点
		Element root = document.addElement("ptip");
		root.setText(ptip);
		return document;
	}
	
	/**
	 * 
	 * @Description: TODO(解析xml为ProblemContentVO) 
	 * @param pc
	 * @param kind 题目类型: 0：程序题  1：例题 2：填空题 3：单项选择题 4：多项选择题 5：判断题
	 * @return
	 * @author 何凡 <piaobo749@qq.com>
	 * @throws DocumentException 
	 * @date 2015年11月6日 上午9:48:58
	 */
	public static ProblemContentVO resoveProblemContent(String xml, Integer kind) throws DocumentException{
		switch(kind){
		case 0 : return resoveProgramXML(xml);
		case 1 : return null;
		case 2 : return null;
		case 3 : return resoveChoiceXML(xml, true);
		case 4 : return resoveChoiceXML(xml, false);
		case 5 : return resoveJudgmentXML(xml);
		default : return null;
		}
		
	}

	/**
	 * 
	 * @Description: TODO(解析程序题xml) 
	 * @param xml
	 * @return
	 * @author 何凡 <piaobo749@qq.com>
	 * @throws DocumentException 
	 * @date 2015年11月6日 上午10:27:39
	 */
	@SuppressWarnings("unchecked")
	public static ProblemContentVO resoveProgramXML(String xml) throws DocumentException{
		ProblemContentVO pcvo = new ProblemContentVO();
		FileMsgVO filevo = new FileMsgVO();
		Document document = DocumentHelper.parseText(xml);
		Element root = document.getRootElement();
		//主文件
		Element node = root.element("mainFile");
		filevo.setFileName(node.attributeValue("fileName"));
		filevo.setFileContent(node.getText());
		pcvo.setMainFile(filevo);
		//用户文件
		node = root.element("userFile");
		filevo.setFileName(node.attributeValue("fileName"));
		filevo.setFileContent(node.getText());
		pcvo.setUserFile(filevo);
		//答案文件
		node = root.element("answerFile");
		filevo.setFileName(node.attributeValue("fileName"));
		filevo.setFileContent(node.getText());
		pcvo.setAnswerFile(filevo);
		//内容
		pcvo.setProgramContent(root.elementText("programContent"));
		//文档
		pcvo.setDocument(root.elementText("document"));
		//头文件
		List<Element> heads = root.element("headFiles").elements("headFile");
		List<FileMsgVO> headFiles = new ArrayList<FileMsgVO>();
		for(Element e : heads){
			FileMsgVO headFile = new FileMsgVO();
			headFile.setFileName(e.attributeValue("fileName"));
			headFile.setFileContent(e.getText());
			headFiles.add(headFile);
		}
		pcvo.setHeadFiles(headFiles);
		return pcvo;
	}
	
	/**
	 * 
	 * @Description: TODO(解析选择题xml) 
	 * @param xml
	 * @param isSingle 是否是单选
	 * @return
	 * @author 何凡 <piaobo749@qq.com>
	 * @throws DocumentException 
	 * @date 2015年11月6日 上午11:37:51
	 */
	@SuppressWarnings("unchecked")
	public static ProblemContentVO resoveChoiceXML(String xml, Boolean isSingle) throws DocumentException{
		ProblemContentVO pcvo = new ProblemContentVO();
		Document document = DocumentHelper.parseText(xml);
		Element root = document.getRootElement();
		List<Element> options = root.element("options").elements("option");
		List<ChoiceOptionsVO> optionsList = new ArrayList<ChoiceOptionsVO>();
		for(Element e : options){
			ChoiceOptionsVO co = new ChoiceOptionsVO();
			co.setIsRight(Boolean.parseBoolean(e.attributeValue("isRight")));
			co.setSequence(e.attributeValue("sequence"));
			co.setOptContent(e.getText());
			optionsList.add(co);
		}
		if(isSingle){
			pcvo.setSingleContent(root.elementText("choiceContent"));
			pcvo.setSingleOptions(optionsList);
		}else{
			pcvo.setMultipleContent(root.elementText("choiceContent"));
			pcvo.setMultipleOptions(optionsList);
		}
		return pcvo;
	}
	
	/**
	 * 
	 * @Description: TODO(解析判断题xml) 
	 * @param xml
	 * @return
	 * @throws DocumentException
	 * @author 何凡 <piaobo749@qq.com>
	 * @date 2015年11月6日 上午11:56:29
	 */
	public static ProblemContentVO resoveJudgmentXML(String xml) throws DocumentException{
		ProblemContentVO pcvo = new ProblemContentVO();
		Document document = DocumentHelper.parseText(xml);
		Element root = document.getRootElement();
		pcvo.setJudgmentContent(root.getText());
		pcvo.setIsRight(Boolean.parseBoolean(root.attributeValue("isRight")));
		return pcvo;
	}
	
	/**
	 * 
	 * @Description: TODO(解析题目提示xml) 
	 * @param xml
	 * @return
	 * @throws DocumentException
	 * @author 何凡 <piaobo749@qq.com>
	 * @date 2015年11月8日 下午5:03:40
	 */
	public static String resoveProblemTipXML(String xml) throws DocumentException{
		Document document = DocumentHelper.parseText(xml);
		Element root = document.getRootElement();
		return root.getText();
	}
	
}




