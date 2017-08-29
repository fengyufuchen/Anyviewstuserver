/**   
* @Title: ProblemContentVO.java 
* @Package com.anyview.entities 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 何凡 <piaobo749@qq.com>   
* @date 2015年10月29日 下午10:16:25 
* @version V1.0   
*/
package com.anyview.entities;

import java.util.List;

/** 
 * @ClassName: ProblemContentVO 
 * @Description: TODO(封装题目内容) 
 * @author 何凡 <piaobo749@qq.com>
 * @date 2015年10月29日 下午10:16:25 
 *  
 */
public class ProblemContentVO {

	//单择题
	private String singleContent;//单选题题干
	private List<ChoiceOptionsVO> singleOptions;//单选题选项
	//多选题
	private String multipleContent;//多选题题干
	private List<ChoiceOptionsVO> multipleOptions;//多选题
	//判断题
	private String judgmentContent;//判断题题干
	private Boolean isRight;
	//填空题
//	private 
	//程序题
	private FileMsgVO mainFile;//主文件
	private FileMsgVO userFile;//用户文件
	private FileMsgVO answerFile;//答案文件
	private List<FileMsgVO> headFiles;//头文件
	private String programContent;//程序题内容
	private String document;//题目文档
	
	public String getSingleContent() {
		return singleContent;
	}
	public void setSingleContent(String singleContent) {
		this.singleContent = singleContent;
	}
	public List<ChoiceOptionsVO> getSingleOptions() {
		return singleOptions;
	}
	public void setSingleOptions(List<ChoiceOptionsVO> singleOptions) {
		this.singleOptions = singleOptions;
	}
	public String getMultipleContent() {
		return multipleContent;
	}
	public void setMultipleContent(String multipleContent) {
		this.multipleContent = multipleContent;
	}
	public List<ChoiceOptionsVO> getMultipleOptions() {
		return multipleOptions;
	}
	public void setMultipleOptions(List<ChoiceOptionsVO> multipleOptions) {
		this.multipleOptions = multipleOptions;
	}
	public String getJudgmentContent() {
		return judgmentContent;
	}
	public void setJudgmentContent(String judgmentContent) {
		this.judgmentContent = judgmentContent;
	}
	public Boolean getIsRight() {
		return isRight;
	}
	public void setIsRight(Boolean isRight) {
		this.isRight = isRight;
	}
	public FileMsgVO getMainFile() {
		return mainFile;
	}
	public void setMainFile(FileMsgVO mainFile) {
		this.mainFile = mainFile;
	}
	public FileMsgVO getUserFile() {
		return userFile;
	}
	public void setUserFile(FileMsgVO userFile) {
		this.userFile = userFile;
	}
	public FileMsgVO getAnswerFile() {
		return answerFile;
	}
	public void setAnswerFile(FileMsgVO answerFile) {
		this.answerFile = answerFile;
	}
	public List<FileMsgVO> getHeadFiles() {
		return headFiles;
	}
	public void setHeadFiles(List<FileMsgVO> headFiles) {
		this.headFiles = headFiles;
	}
	public String getProgramContent() {
		return programContent;
	}
	public void setProgramContent(String programContent) {
		this.programContent = programContent;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	
	
	
}
