package Beans;

import java.sql.Date;

public class SurveyBeans 
{

	String surveyName;
	String email;
	String targetAudience;
	Date creationDate;
	Date startDate;
	Date endDate;
	String surveyStatus;
	String workingDays;
	String creationAmount;
	String rewardAmount;
	public String getCreationAmount() {
		return creationAmount;
	}
	public void setCreationAmount(String creationAmount) {
		this.creationAmount = creationAmount;
	}
	public String getRewardAmount() {
		return rewardAmount;
	}
	public void setRewardAmount(String rewardAmount) {
		this.rewardAmount = rewardAmount;
	}
	public String getSurveyName() 
	{
		return surveyName;
	}
	public void setSurveyName(String surveyName)
	{
		this.surveyName = surveyName;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getTargetAudience() 
	{
		return targetAudience;
	}
	public void setTargetAudience(String targetAudience) 
	{
		this.targetAudience = targetAudience;
	}
	public Date getCreationDate() 
	{
		return creationDate;
	}
	public void setCreationDate(Date creationDate) 
	{
		this.creationDate = creationDate;
	}
	public Date getStartDate() 
	{
		return startDate;
	}
	public void setStartDate(Date startDate) 
	{
		this.startDate = startDate;
	}
	public Date getEndDate() 
	{
		return endDate;
	}
	public void setEndDate(Date endDate) 
	{
		this.endDate = endDate;
	}
	public String getSurveyStatus() 
	{
		return surveyStatus;
	}
	public void setSurveyStatus(String surveyStatus) 
	{
		this.surveyStatus = surveyStatus;
	}
	public String getWorkingDays() 
	{
		return workingDays;
	}
	public void setWorkingDays(String workingDays) 
	{
		this.workingDays = workingDays;
	}
	
}
