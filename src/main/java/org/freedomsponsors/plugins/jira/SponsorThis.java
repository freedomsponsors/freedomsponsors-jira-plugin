package org.freedomsponsors.plugins.jira;

import java.util.HashMap;
import java.util.Map;

import com.atlassian.crowd.embedded.api.User;
import com.atlassian.jira.config.properties.ApplicationProperties;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.status.Status;
import com.atlassian.jira.plugin.webfragment.contextproviders.AbstractJiraContextProvider;
import com.atlassian.jira.plugin.webfragment.model.JiraHelper;

public class SponsorThis extends AbstractJiraContextProvider
{       
	private final ApplicationProperties applicationProperties;

	public SponsorThis(ApplicationProperties applicationProperties) // magic constructor
    {
        this.applicationProperties = applicationProperties;
    }
	
	@Override
    public Map getContextMap(User user, JiraHelper jiraHelper) {
        Map contextMap = new HashMap();        
        String baseUrl = applicationProperties.getString("jira.baseurl");
        Issue currentIssue = (Issue) jiraHelper.getContextParams().get("issue");        
        String issueKey = currentIssue.getKey();
        String status = ((Status)currentIssue.getStatusObject()).getName();
        boolean visible = !status.equalsIgnoreCase("resolved") && !status.equalsIgnoreCase("closed");
        contextMap.put("issueKey", issueKey);
        contextMap.put("baseUrl", baseUrl);
        contextMap.put("visible", visible);
        
        
        return contextMap;
    }
	

}
